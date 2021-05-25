package com.avito.android.location_list.di;

import com.avito.android.location_list.LocationListInteractor;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.error.LocationsNotFoundErrorCase;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LocationListModule_ProvideInteractorFactory implements Factory<LocationListInteractor> {
    public final LocationListModule a;
    public final Provider<LocationApi> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<TypedErrorThrowableConverter> d;
    public final Provider<LocationsNotFoundErrorCase> e;

    public LocationListModule_ProvideInteractorFactory(LocationListModule locationListModule, Provider<LocationApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<LocationsNotFoundErrorCase> provider4) {
        this.a = locationListModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static LocationListModule_ProvideInteractorFactory create(LocationListModule locationListModule, Provider<LocationApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<LocationsNotFoundErrorCase> provider4) {
        return new LocationListModule_ProvideInteractorFactory(locationListModule, provider, provider2, provider3, provider4);
    }

    public static LocationListInteractor provideInteractor(LocationListModule locationListModule, LocationApi locationApi, SchedulersFactory schedulersFactory, TypedErrorThrowableConverter typedErrorThrowableConverter, LocationsNotFoundErrorCase locationsNotFoundErrorCase) {
        return (LocationListInteractor) Preconditions.checkNotNullFromProvides(locationListModule.provideInteractor(locationApi, schedulersFactory, typedErrorThrowableConverter, locationsNotFoundErrorCase));
    }

    @Override // javax.inject.Provider
    public LocationListInteractor get() {
        return provideInteractor(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
