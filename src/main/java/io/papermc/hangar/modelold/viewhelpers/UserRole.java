package io.papermc.hangar.modelold.viewhelpers;

import io.papermc.hangar.db.modelold.RoleTable;
import io.papermc.hangar.modelold.Role;

public class UserRole<R extends RoleTable> {

    private final R userRole;
    private final boolean isAccepted;
    private final Role role;

    public UserRole(R userRole) {
        this.userRole = userRole;
        this.isAccepted = userRole.isAccepted();
        this.role = Role.valueOf(userRole.getRoleType().toUpperCase());
    }

    public R getUserRole() {
        return userRole;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public Role getRole() {
        return role;
    }
}
