package com.avito.android.advert_core.map.di;

import com.avito.android.Features;
import com.avito.android.advert_core.map.MapBlueprint;
import com.avito.android.advert_core.map.MapPresenter;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MapModule_ProvideMapBlueprintFactory implements Factory<MapBlueprint> {
    public final Provider<MapPresenter> a;
    public final Provider<Features> b;
    public final Provider<AmenityMarkerIconFactory> c;

    public MapModule_ProvideMapBlueprintFactory(Provider<MapPresenter> provider, Provider<Features> provider2, Provider<AmenityMarkerIconFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MapModule_ProvideMapBlueprintFactory create(Provider<MapPresenter> provider, Provider<Features> provider2, Provider<AmenityMarkerIconFactory> provider3) {
        return new MapModule_ProvideMapBlueprintFactory(provider, provider2, provider3);
    }

    public static MapBlueprint provideMapBlueprint(MapPresenter mapPresenter, Features features, AmenityMarkerIconFactory amenityMarkerIconFactory) {
        return (MapBlueprint) Preconditions.checkNotNullFromProvides(MapModule.INSTANCE.provideMapBlueprint(mapPresenter, features, amenityMarkerIconFactory));
    }

    @Override // javax.inject.Provider
    public MapBlueprint get() {
        return provideMapBlueprint(this.a.get(), this.b.get(), this.c.get());
    }
}
