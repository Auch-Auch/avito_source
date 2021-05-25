package com.avito.android.location_list.di;

import com.avito.android.location_list.LocationListPresenter;
import com.avito.android.location_list.LocationListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LocationListModule_ProvideLocationListenerFactory implements Factory<LocationListener> {
    public final LocationListModule a;
    public final Provider<LocationListPresenter> b;

    public LocationListModule_ProvideLocationListenerFactory(LocationListModule locationListModule, Provider<LocationListPresenter> provider) {
        this.a = locationListModule;
        this.b = provider;
    }

    public static LocationListModule_ProvideLocationListenerFactory create(LocationListModule locationListModule, Provider<LocationListPresenter> provider) {
        return new LocationListModule_ProvideLocationListenerFactory(locationListModule, provider);
    }

    public static LocationListener provideLocationListener(LocationListModule locationListModule, LocationListPresenter locationListPresenter) {
        return (LocationListener) Preconditions.checkNotNullFromProvides(locationListModule.provideLocationListener(locationListPresenter));
    }

    @Override // javax.inject.Provider
    public LocationListener get() {
        return provideLocationListener(this.a, this.b.get());
    }
}
