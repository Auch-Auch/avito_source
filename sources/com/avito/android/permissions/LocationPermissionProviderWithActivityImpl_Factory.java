package com.avito.android.permissions;

import androidx.fragment.app.FragmentActivity;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LocationPermissionProviderWithActivityImpl_Factory implements Factory<LocationPermissionProviderWithActivityImpl> {
    public final Provider<FragmentActivity> a;

    public LocationPermissionProviderWithActivityImpl_Factory(Provider<FragmentActivity> provider) {
        this.a = provider;
    }

    public static LocationPermissionProviderWithActivityImpl_Factory create(Provider<FragmentActivity> provider) {
        return new LocationPermissionProviderWithActivityImpl_Factory(provider);
    }

    public static LocationPermissionProviderWithActivityImpl newInstance(FragmentActivity fragmentActivity) {
        return new LocationPermissionProviderWithActivityImpl(fragmentActivity);
    }

    @Override // javax.inject.Provider
    public LocationPermissionProviderWithActivityImpl get() {
        return newInstance(this.a.get());
    }
}
