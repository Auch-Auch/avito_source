package com.avito.android.location_list.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LocationListModule_ProvideAdapterPresenterFactory implements Factory<AdapterPresenter> {
    public final LocationListModule a;
    public final Provider<ItemBinder> b;

    public LocationListModule_ProvideAdapterPresenterFactory(LocationListModule locationListModule, Provider<ItemBinder> provider) {
        this.a = locationListModule;
        this.b = provider;
    }

    public static LocationListModule_ProvideAdapterPresenterFactory create(LocationListModule locationListModule, Provider<ItemBinder> provider) {
        return new LocationListModule_ProvideAdapterPresenterFactory(locationListModule, provider);
    }

    public static AdapterPresenter provideAdapterPresenter(LocationListModule locationListModule, ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(locationListModule.provideAdapterPresenter(itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return provideAdapterPresenter(this.a, this.b.get());
    }
}
