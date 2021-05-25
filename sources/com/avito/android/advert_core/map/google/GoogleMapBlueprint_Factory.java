package com.avito.android.advert_core.map.google;

import com.avito.android.advert_core.map.MapPresenter;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class GoogleMapBlueprint_Factory implements Factory<GoogleMapBlueprint> {
    public final Provider<MapPresenter> a;
    public final Provider<AmenityMarkerIconFactory> b;

    public GoogleMapBlueprint_Factory(Provider<MapPresenter> provider, Provider<AmenityMarkerIconFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static GoogleMapBlueprint_Factory create(Provider<MapPresenter> provider, Provider<AmenityMarkerIconFactory> provider2) {
        return new GoogleMapBlueprint_Factory(provider, provider2);
    }

    public static GoogleMapBlueprint newInstance(MapPresenter mapPresenter, AmenityMarkerIconFactory amenityMarkerIconFactory) {
        return new GoogleMapBlueprint(mapPresenter, amenityMarkerIconFactory);
    }

    @Override // javax.inject.Provider
    public GoogleMapBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
