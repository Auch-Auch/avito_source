package com.avito.android.in_app_calls.permissions;

import com.avito.android.permissions.PermissionStateProvider;
import com.avito.android.permissions.PermissionStorage;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallPermissionsManagerImpl_Factory implements Factory<CallPermissionsManagerImpl> {
    public final Provider<PermissionStateProvider> a;
    public final Provider<PermissionStorage> b;

    public CallPermissionsManagerImpl_Factory(Provider<PermissionStateProvider> provider, Provider<PermissionStorage> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CallPermissionsManagerImpl_Factory create(Provider<PermissionStateProvider> provider, Provider<PermissionStorage> provider2) {
        return new CallPermissionsManagerImpl_Factory(provider, provider2);
    }

    public static CallPermissionsManagerImpl newInstance(PermissionStateProvider permissionStateProvider, PermissionStorage permissionStorage) {
        return new CallPermissionsManagerImpl(permissionStateProvider, permissionStorage);
    }

    @Override // javax.inject.Provider
    public CallPermissionsManagerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
