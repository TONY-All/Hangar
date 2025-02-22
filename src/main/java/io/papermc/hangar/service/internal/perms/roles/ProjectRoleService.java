package io.papermc.hangar.service.internal.perms.roles;

import io.papermc.hangar.db.dao.HangarDao;
import io.papermc.hangar.db.dao.internal.table.roles.ProjectRolesDAO;
import io.papermc.hangar.model.common.roles.ProjectRole;
import io.papermc.hangar.model.db.roles.ProjectRoleTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectRoleService extends RoleService<ProjectRoleTable, ProjectRole, ProjectRolesDAO> {

    @Autowired
    public ProjectRoleService(HangarDao<ProjectRolesDAO> roleDao) {
        super(roleDao.get());
    }

    @Override
    public ProjectRoleTable getRole(long projectId, long userId) {
        return super.getRole(projectId, userId);
    }
}
