package io.papermc.hangar.service.internal.perms.roles;

import io.papermc.hangar.db.dao.HangarDao;
import io.papermc.hangar.db.dao.internal.table.roles.OrganizationRolesDAO;
import io.papermc.hangar.model.common.roles.OrganizationRole;
import io.papermc.hangar.model.db.roles.OrganizationRoleTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationRoleService extends RoleService<OrganizationRoleTable, OrganizationRole, OrganizationRolesDAO> {

    @Autowired
    public OrganizationRoleService(HangarDao<OrganizationRolesDAO> roleDao) {
        super(roleDao.get());
    }

    @Override
    public OrganizationRoleTable getRole(long organizationId, long userId) {
        return super.getRole(organizationId, userId);
    }
}
