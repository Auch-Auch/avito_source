package com.avito.android.location_list.di;

import com.avito.android.remote.error.LocationsNotFoundErrorCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class LocationListModule_ProvideLocationsNotFoundErrorCaseFactory implements Factory<LocationsNotFoundErrorCase> {
    public final LocationListModule a;

    public LocationListModule_ProvideLocationsNotFoundErrorCaseFactory(LocationListModule locationListModule) {
        this.a = locationListModule;
    }

    public static LocationListModule_ProvideLocationsNotFoundErrorCaseFactory create(LocationListModule locationListModule) {
        return new LocationListModule_ProvideLocationsNotFoundErrorCaseFactory(locationListModule);
    }

    public static LocationsNotFoundErrorCase provideLocationsNotFoundErrorCase(LocationListModule locationListModule) {
        return (LocationsNotFoundErrorCase) Preconditions.checkNotNullFromProvides(locationListModule.provideLocationsNotFoundErrorCase());
    }

    @Override // javax.inject.Provider
    public LocationsNotFoundErrorCase get() {
        return provideLocationsNotFoundErrorCase(this.a);
    }
}
