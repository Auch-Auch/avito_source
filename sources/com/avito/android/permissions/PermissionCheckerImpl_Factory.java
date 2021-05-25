package com.avito.android.permissions;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PermissionCheckerImpl_Factory implements Factory<PermissionCheckerImpl> {
    public final Provider<Context> a;

    public PermissionCheckerImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static PermissionCheckerImpl_Factory create(Provider<Context> provider) {
        return new PermissionCheckerImpl_Factory(provider);
    }

    public static PermissionCheckerImpl newInstance(Context context) {
        return new PermissionCheckerImpl(context);
    }

    @Override // javax.inject.Provider
    public PermissionCheckerImpl get() {
        return newInstance(this.a.get());
    }
}
