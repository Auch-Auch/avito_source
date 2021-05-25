package com.avito.android.location_list.di;

import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.permissions.LocationPermissionProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LocationListModule_ProvideLocationPermissionDialogPresenterFactory implements Factory<LocationPermissionDialogPresenter> {
    public final LocationListModule a;
    public final Provider<LocationPermissionProvider> b;

    public LocationListModule_ProvideLocationPermissionDialogPresenterFactory(LocationListModule locationListModule, Provider<LocationPermissionProvider> provider) {
        this.a = locationListModule;
        this.b = provider;
    }

    public static LocationListModule_ProvideLocationPermissionDialogPresenterFactory create(LocationListModule locationListModule, Provider<LocationPermissionProvider> provider) {
        return new LocationListModule_ProvideLocationPermissionDialogPresenterFactory(locationListModule, provider);
    }

    public static LocationPermissionDialogPresenter provideLocationPermissionDialogPresenter(LocationListModule locationListModule, LocationPermissionProvider locationPermissionProvider) {
        return (LocationPermissionDialogPresenter) Preconditions.checkNotNullFromProvides(locationListModule.provideLocationPermissionDialogPresenter(locationPermissionProvider));
    }

    @Override // javax.inject.Provider
    public LocationPermissionDialogPresenter get() {
        return provideLocationPermissionDialogPresenter(this.a, this.b.get());
    }
}
