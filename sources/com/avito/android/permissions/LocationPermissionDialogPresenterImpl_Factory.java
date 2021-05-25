package com.avito.android.permissions;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class LocationPermissionDialogPresenterImpl_Factory implements Factory<LocationPermissionDialogPresenterImpl> {
    public final Provider<LocationPermissionProvider> a;

    public LocationPermissionDialogPresenterImpl_Factory(Provider<LocationPermissionProvider> provider) {
        this.a = provider;
    }

    public static LocationPermissionDialogPresenterImpl_Factory create(Provider<LocationPermissionProvider> provider) {
        return new LocationPermissionDialogPresenterImpl_Factory(provider);
    }

    public static LocationPermissionDialogPresenterImpl newInstance(LocationPermissionProvider locationPermissionProvider) {
        return new LocationPermissionDialogPresenterImpl(locationPermissionProvider);
    }

    @Override // javax.inject.Provider
    public LocationPermissionDialogPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
