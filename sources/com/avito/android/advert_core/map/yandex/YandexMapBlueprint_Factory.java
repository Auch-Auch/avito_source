package com.avito.android.advert_core.map.yandex;

import com.avito.android.advert_core.map.MapPresenter;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class YandexMapBlueprint_Factory implements Factory<YandexMapBlueprint> {
    public final Provider<MapPresenter> a;
    public final Provider<AmenityMarkerIconFactory> b;

    public YandexMapBlueprint_Factory(Provider<MapPresenter> provider, Provider<AmenityMarkerIconFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static YandexMapBlueprint_Factory create(Provider<MapPresenter> provider, Provider<AmenityMarkerIconFactory> provider2) {
        return new YandexMapBlueprint_Factory(provider, provider2);
    }

    public static YandexMapBlueprint newInstance(MapPresenter mapPresenter, AmenityMarkerIconFactory amenityMarkerIconFactory) {
        return new YandexMapBlueprint(mapPresenter, amenityMarkerIconFactory);
    }

    @Override // javax.inject.Provider
    public YandexMapBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
