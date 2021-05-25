package com.avito.android.permissions;

import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PermissionStorageImpl_Factory implements Factory<PermissionStorageImpl> {
    public final Provider<Preferences> a;

    public PermissionStorageImpl_Factory(Provider<Preferences> provider) {
        this.a = provider;
    }

    public static PermissionStorageImpl_Factory create(Provider<Preferences> provider) {
        return new PermissionStorageImpl_Factory(provider);
    }

    public static PermissionStorageImpl newInstance(Preferences preferences) {
        return new PermissionStorageImpl(preferences);
    }

    @Override // javax.inject.Provider
    public PermissionStorageImpl get() {
        return newInstance(this.a.get());
    }
}
