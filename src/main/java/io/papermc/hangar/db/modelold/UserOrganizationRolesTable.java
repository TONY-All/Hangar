package io.papermc.hangar.db.modelold;


import io.papermc.hangar.modelold.Role;

import java.time.OffsetDateTime;

public class UserOrganizationRolesTable implements RoleTable {

    private long id;
    private OffsetDateTime createdAt;
    private long userId;
    private String roleType;
    private long organizationId;
    private boolean accepted;
    private Role role;

    public UserOrganizationRolesTable(long userId, String roleType, long organizationId, boolean accepted) {
        this.userId = userId;
        this.roleType = roleType;
        this.organizationId = organizationId;
        this.accepted = accepted;
    }

    public UserOrganizationRolesTable() { }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }


    public long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(long organizationId) {
        this.organizationId = organizationId;
    }


    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean isAccepted) {
        this.accepted = isAccepted;
    }

    @Override
    public Role getRole() {
        if (this.role == null) {
            role = Role.fromValue(roleType);
        }
        return role;
    }
}
