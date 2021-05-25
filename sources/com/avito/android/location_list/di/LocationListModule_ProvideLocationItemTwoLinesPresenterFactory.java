package com.avito.android.location_list.di;

import com.avito.android.location_list.LocationItemTwoLinesPresenterImpl;
import com.avito.android.location_list.LocationListPresenter;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LocationListModule_ProvideLocationItemTwoLinesPresenterFactory implements Factory<LocationItemTwoLinesPresenterImpl> {
    public final LocationListModule a;
    public final Provider<LocationListPresenter> b;

    public LocationListModule_ProvideLocationItemTwoLinesPresenterFactory(LocationListModule locationListModule, Provider<LocationListPresenter> provider) {
        this.a = locationListModule;
        this.b = provider;
    }

    public static LocationListModule_ProvideLocationItemTwoLinesPresenterFactory create(LocationListModule locationListModule, Provider<LocationListPresenter> provider) {
        return new LocationListModule_ProvideLocationItemTwoLinesPresenterFactory(locationListModule, provider);
    }

    public static LocationItemTwoLinesPresenterImpl provideLocationItemTwoLinesPresenter(LocationListModule locationListModule, Lazy<LocationListPresenter> lazy) {
        return (LocationItemTwoLinesPresenterImpl) Preconditions.checkNotNullFromProvides(locationListModule.provideLocationItemTwoLinesPresenter(lazy));
    }

    @Override // javax.inject.Provider
    public LocationItemTwoLinesPresenterImpl get() {
        return provideLocationItemTwoLinesPresenter(this.a, DoubleCheck.lazy(this.b));
    }
}
