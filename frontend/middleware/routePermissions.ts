import { Context } from '@nuxt/types';
import { UserPermissions } from 'hangar-api';
import { AuthState } from '~/store/auth';

export default ({ store, params, $api, $auth }: Context) => {
    if (params.author && params.slug) {
        if ($auth.isLoggedIn()) {
            return $api
                .request<UserPermissions>('permissions', true, 'get', {
                    author: params.author,
                    slug: params.slug,
                })
                .then((userPermissions) => {
                    store.commit('auth/SET_ROUTE_PERMISSIONS', userPermissions.permissionBinString);
                })
                .catch(() => {
                    store.commit('auth/SET_ROUTE_PERMISSIONS', null);
                });
        }
    } else if (params.user) {
        if ($auth.isLoggedIn()) {
            return $api
                .request<UserPermissions>('permissions', true, 'get', {
                    organization: params.user,
                })
                .then((userPermissions) => {
                    store.commit('auth/SET_ROUTE_PERMISSIONS', userPermissions.permissionBinString);
                })
                .catch(() => {
                    store.commit('auth/SET_ROUTE_PERMISSIONS', null);
                });
        }
    } else if ($auth.isLoggedIn()) {
        // Catch-all (just use global permissions)
        store.commit('auth/SET_ROUTE_PERMISSIONS', (store.state.auth as AuthState).user!.headerData.globalPermission);
        return;
    }
    store.commit('auth/SET_ROUTE_PERMISSIONS', null);
    // TODO other route permissions
};
