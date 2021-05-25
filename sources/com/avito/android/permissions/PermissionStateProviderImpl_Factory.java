package com.avito.android.permissions;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class PermissionStateProviderImpl_Factory implements Factory<PermissionStateProviderImpl> {
    public final Provider<PermissionChecker> a;
    public final Provider<PermissionStorage> b;

    public PermissionStateProviderImpl_Factory(Provider<PermissionChecker> provider, Provider<PermissionStorage> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PermissionStateProviderImpl_Factory create(Provider<PermissionChecker> provider, Provider<PermissionStorage> provider2) {
        return new PermissionStateProviderImpl_Factory(provider, provider2);
    }

    public static PermissionStateProviderImpl newInstance(PermissionChecker permissionChecker, PermissionStorage permissionStorage) {
        return new PermissionStateProviderImpl(permissionChecker, permissionStorage);
    }

    @Override // javax.inject.Provider
    public PermissionStateProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
