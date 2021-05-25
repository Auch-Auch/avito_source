package com.avito.android.permissions;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LocationPermissionProviderImpl_Factory implements Factory<LocationPermissionProviderImpl> {
    public final Provider<Fragment> a;

    public LocationPermissionProviderImpl_Factory(Provider<Fragment> provider) {
        this.a = provider;
    }

    public static LocationPermissionProviderImpl_Factory create(Provider<Fragment> provider) {
        return new LocationPermissionProviderImpl_Factory(provider);
    }

    public static LocationPermissionProviderImpl newInstance(Fragment fragment) {
        return new LocationPermissionProviderImpl(fragment);
    }

    @Override // javax.inject.Provider
    public LocationPermissionProviderImpl get() {
        return newInstance(this.a.get());
    }
}
