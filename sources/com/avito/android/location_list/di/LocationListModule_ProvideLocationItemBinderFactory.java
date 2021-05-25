package com.avito.android.location_list.di;

import com.avito.android.location_list.LocationItemSingleLineRadioButtonBlueprint;
import com.avito.android.location_list.LocationItemTwoLinesRadioButtonBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LocationListModule_ProvideLocationItemBinderFactory implements Factory<ItemBinder> {
    public final LocationListModule a;
    public final Provider<LocationItemTwoLinesRadioButtonBlueprint> b;
    public final Provider<LocationItemSingleLineRadioButtonBlueprint> c;

    public LocationListModule_ProvideLocationItemBinderFactory(LocationListModule locationListModule, Provider<LocationItemTwoLinesRadioButtonBlueprint> provider, Provider<LocationItemSingleLineRadioButtonBlueprint> provider2) {
        this.a = locationListModule;
        this.b = provider;
        this.c = provider2;
    }

    public static LocationListModule_ProvideLocationItemBinderFactory create(LocationListModule locationListModule, Provider<LocationItemTwoLinesRadioButtonBlueprint> provider, Provider<LocationItemSingleLineRadioButtonBlueprint> provider2) {
        return new LocationListModule_ProvideLocationItemBinderFactory(locationListModule, provider, provider2);
    }

    public static ItemBinder provideLocationItemBinder(LocationListModule locationListModule, LocationItemTwoLinesRadioButtonBlueprint locationItemTwoLinesRadioButtonBlueprint, LocationItemSingleLineRadioButtonBlueprint locationItemSingleLineRadioButtonBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(locationListModule.provideLocationItemBinder(locationItemTwoLinesRadioButtonBlueprint, locationItemSingleLineRadioButtonBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideLocationItemBinder(this.a, this.b.get(), this.c.get());
    }
}
