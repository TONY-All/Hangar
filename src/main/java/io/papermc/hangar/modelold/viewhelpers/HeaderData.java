package io.papermc.hangar.modelold.viewhelpers;

import io.papermc.hangar.db.modelold.UsersTable;
import io.papermc.hangar.model.common.Permission;

public class HeaderData {

    private final UsersTable currentUser;
    private final Permission globalPermission;
    private final boolean hasNotice;
    private final boolean hasUnreadNotifications;
    private final boolean unresolvedFlags;
    private final boolean hasProjectApprovals;
    private final boolean hasReviewQueue;

    public static final HeaderData UNAUTHENTICATED = new HeaderData();

    public HeaderData(UsersTable currentUser, Permission globalPermission, boolean hasNotice, boolean hasUnreadNotifications, boolean unresolvedFlags, boolean hasProjectApprovals, boolean hasReviewQueue) {
        this.currentUser = currentUser;
        this.globalPermission = globalPermission;
        this.hasNotice = hasNotice;
        this.hasUnreadNotifications = hasUnreadNotifications;
        this.unresolvedFlags = unresolvedFlags;
        this.hasProjectApprovals = hasProjectApprovals;
        this.hasReviewQueue = hasReviewQueue;
    }

    private HeaderData() {
        currentUser = null;
        globalPermission = Permission.None;
        hasNotice = false;
        hasUnreadNotifications = false;
        unresolvedFlags = false;
        hasProjectApprovals = false;
        hasReviewQueue = false;
    }

    public boolean isAuthenticated() {
        return currentUser != null;
    }

    public boolean hasUser() {
        return currentUser != null;
    }

    public boolean isCurrentUser(UsersTable usersTable) {
        return hasUser() && currentUser.getId() == usersTable.getId();
    }

    public boolean isCurrentUser(long userId) {
        return hasUser() && currentUser.getId() == userId;
    }

    public boolean globalPerm(Permission permission) {
        return globalPermission.has(permission);
    }

    public UsersTable getCurrentUser() {
        return currentUser;
    }

    public Permission getGlobalPermission() {
        return globalPermission;
    }

    public boolean hasNotice() {
        return hasNotice;
    }

    public boolean hasUnreadNotifications() {
        return hasUnreadNotifications;
    }

    public boolean hasUnresolvedFlags() {
        return unresolvedFlags;
    }

    public boolean hasProjectApprovals() {
        return hasProjectApprovals;
    }

    public boolean hasReviewQueue() {
        return hasReviewQueue;
    }
}
