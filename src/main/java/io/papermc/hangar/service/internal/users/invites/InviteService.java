package io.papermc.hangar.service.internal.users.invites;

import io.papermc.hangar.HangarComponent;
import io.papermc.hangar.db.dao.HangarDao;
import io.papermc.hangar.db.dao.internal.HangarNotificationsDAO;
import io.papermc.hangar.db.dao.internal.table.UserDAO;
import io.papermc.hangar.exceptions.HangarApiException;
import io.papermc.hangar.model.Named;
import io.papermc.hangar.model.common.roles.Role;
import io.papermc.hangar.model.db.Table;
import io.papermc.hangar.model.db.UserTable;
import io.papermc.hangar.model.db.roles.ExtendedRoleTable;
import io.papermc.hangar.model.internal.api.requests.EditMembersForm.Member;
import io.papermc.hangar.service.internal.perms.members.MemberService;
import io.papermc.hangar.service.internal.perms.roles.RoleService;
import io.papermc.hangar.service.internal.users.NotificationService;
import io.papermc.hangar.service.internal.users.notifications.JoinableNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public abstract class InviteService<R extends Role<RT>, RT extends ExtendedRoleTable<R>, J extends Table & Named> extends HangarComponent {

    @Autowired
    protected HangarDao<HangarNotificationsDAO> hangarNotificationsDAO;

    @Autowired
    protected NotificationService notificationService;

    @Autowired
    private HangarDao<UserDAO> userDAO;

    private final RoleService<RT, R, ?> roleService;
    private final MemberService<R, RT, ?, ?, ?, ?, ?, ?> memberService;
    private final JoinableNotificationService<RT, J> joinableNotificationService;
    private final String errorPrefix;

    protected InviteService(RoleService<RT, R, ?> roleService, MemberService<R, RT, ?, ?, ?, ?, ?, ?> memberService, JoinableNotificationService<RT, J> joinableNotificationService, String errorPrefix) {
        this.roleService = roleService;
        this.memberService = memberService;
        this.joinableNotificationService = joinableNotificationService;
        this.errorPrefix = errorPrefix;
    }

    @Transactional
    public void sendInvites(List<HangarApiException> errors, List<Member<R>> invitees, J joinable) {
        StringBuilder sb = new StringBuilder("Invited: ");
        List<RT> toBeInvited = new ArrayList<>();
        for (int i = 0; i < invitees.size(); i++) {
            Member<R> invitee = invitees.get(i);
            UserTable userTable = userDAO.get().getUserTable(invitee.getName());
            if (userTable == null) {
                errors.add(new HangarApiException(this.errorPrefix + "invalidUser", invitee.getName()));
                continue;
            }
            RT rt = roleService.addRole(invitee.getRole().create(joinable.getId(), userTable.getId(), false), true);
            if (rt == null) {
                errors.add(new HangarApiException(this.errorPrefix + "alreadyInvited", invitee.getName()));
                continue;
            }
            toBeInvited.add(rt);
            sb.append(userTable.getName()).append(" (").append(invitee.getRole().getTitle()).append(")");
            if (i + 1 != invitees.size()) {
                sb.append(", ");
            }
        }
        if (!invitees.isEmpty()) {
            joinableNotificationService.invited(toBeInvited, joinable);
            logInvitesSent(joinable.getId(), sb.toString());
        }
    }

    abstract void logInvitesSent(long principalId, String log);

    public void acceptInvite(RT roleTable) {
        if (roleTable.isAccepted()) {
            throw new IllegalArgumentException("Cannot accept an invite that has already been accepted");
        }
        roleTable = roleService.changeAcceptance(roleTable, true);
        memberService.addMember(roleTable);
        UserTable userTable = userDAO.get().getUserTable(roleTable.getUserId());
        logInviteAccepted(roleTable, userTable);
    }

    abstract void logInviteAccepted(RT roleTable, UserTable userTable);

    public void unacceptInvite(RT roleTable) {
        if (!roleTable.isAccepted()) {
            throw new IllegalArgumentException("Cannot un-accept a non-accepted invite");
        }
        roleTable = roleService.changeAcceptance(roleTable, false);
        UserTable userTable = userDAO.get().getUserTable(roleTable.getUserId());
        memberService.removeMember(roleTable, userTable.getName(), false);
        logInviteUnaccepted(roleTable, userTable);
    }

    abstract void logInviteUnaccepted(RT roleTable, UserTable userTable);

    public void declineInvite(RT roleTable) {
        roleService.deleteRole(roleTable);
        logInviteDeclined(roleTable, userDAO.get().getUserTable(roleTable.getUserId()));
    }

    abstract void logInviteDeclined(RT roleTable, UserTable userTable);

}
