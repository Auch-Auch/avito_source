package com.avito.android.location_list.di;

import com.avito.android.location_list.LocationItemSingleLinePresenterImpl;
import com.avito.android.location_list.LocationItemSingleLineRadioButtonBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LocationListModule_ProvideLocationItemSingleLineBluePrintFactory implements Factory<LocationItemSingleLineRadioButtonBlueprint> {
    public final LocationListModule a;
    public final Provider<LocationItemSingleLinePresenterImpl> b;

    public LocationListModule_ProvideLocationItemSingleLineBluePrintFactory(LocationListModule locationListModule, Provider<LocationItemSingleLinePresenterImpl> provider) {
        this.a = locationListModule;
        this.b = provider;
    }

    public static LocationListModule_ProvideLocationItemSingleLineBluePrintFactory create(LocationListModule locationListModule, Provider<LocationItemSingleLinePresenterImpl> provider) {
        return new LocationListModule_ProvideLocationItemSingleLineBluePrintFactory(locationListModule, provider);
    }

    public static LocationItemSingleLineRadioButtonBlueprint provideLocationItemSingleLineBluePrint(LocationListModule locationListModule, LocationItemSingleLinePresenterImpl locationItemSingleLinePresenterImpl) {
        return (LocationItemSingleLineRadioButtonBlueprint) Preconditions.checkNotNullFromProvides(locationListModule.provideLocationItemSingleLineBluePrint(locationItemSingleLinePresenterImpl));
    }

    @Override // javax.inject.Provider
    public LocationItemSingleLineRadioButtonBlueprint get() {
        return provideLocationItemSingleLineBluePrint(this.a, this.b.get());
    }
}
