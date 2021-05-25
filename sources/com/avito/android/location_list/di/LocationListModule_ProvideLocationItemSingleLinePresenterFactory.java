package com.avito.android.location_list.di;

import com.avito.android.location_list.LocationItemSingleLinePresenterImpl;
import com.avito.android.location_list.LocationListPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LocationListModule_ProvideLocationItemSingleLinePresenterFactory implements Factory<LocationItemSingleLinePresenterImpl> {
    public final LocationListModule a;
    public final Provider<LocationListPresenter> b;

    public LocationListModule_ProvideLocationItemSingleLinePresenterFactory(LocationListModule locationListModule, Provider<LocationListPresenter> provider) {
        this.a = locationListModule;
        this.b = provider;
    }

    public static LocationListModule_ProvideLocationItemSingleLinePresenterFactory create(LocationListModule locationListModule, Provider<LocationListPresenter> provider) {
        return new LocationListModule_ProvideLocationItemSingleLinePresenterFactory(locationListModule, provider);
    }

    public static LocationItemSingleLinePresenterImpl provideLocationItemSingleLinePresenter(LocationListModule locationListModule, Lazy<LocationListPresenter> lazy) {
        return (LocationItemSingleLinePresenterImpl) Preconditions.checkNotNullFromProvides(locationListModule.provideLocationItemSingleLinePresenter(lazy));
    }

    @Override // javax.inject.Provider
    public LocationItemSingleLinePresenterImpl get() {
        return provideLocationItemSingleLinePresenter(this.a, DoubleCheck.lazy(this.b));
    }
}
