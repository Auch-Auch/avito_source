package com.avito.android.location_list.di;

import com.avito.android.location_list.LocationItemTwoLinesPresenterImpl;
import com.avito.android.location_list.LocationItemTwoLinesRadioButtonBlueprint;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LocationListModule_ProvideLocationItemTwoLinesBluePrintFactory implements Factory<LocationItemTwoLinesRadioButtonBlueprint> {
    public final LocationListModule a;
    public final Provider<LocationItemTwoLinesPresenterImpl> b;

    public LocationListModule_ProvideLocationItemTwoLinesBluePrintFactory(LocationListModule locationListModule, Provider<LocationItemTwoLinesPresenterImpl> provider) {
        this.a = locationListModule;
        this.b = provider;
    }

    public static LocationListModule_ProvideLocationItemTwoLinesBluePrintFactory create(LocationListModule locationListModule, Provider<LocationItemTwoLinesPresenterImpl> provider) {
        return new LocationListModule_ProvideLocationItemTwoLinesBluePrintFactory(locationListModule, provider);
    }

    public static LocationItemTwoLinesRadioButtonBlueprint provideLocationItemTwoLinesBluePrint(LocationListModule locationListModule, LocationItemTwoLinesPresenterImpl locationItemTwoLinesPresenterImpl) {
        return (LocationItemTwoLinesRadioButtonBlueprint) Preconditions.checkNotNullFromProvides(locationListModule.provideLocationItemTwoLinesBluePrint(locationItemTwoLinesPresenterImpl));
    }

    @Override // javax.inject.Provider
    public LocationItemTwoLinesRadioButtonBlueprint get() {
        return provideLocationItemTwoLinesBluePrint(this.a, this.b.get());
    }
}
