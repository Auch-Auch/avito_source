package com.avito.android.search.map.reducer;

import com.avito.android.avito_map.AvitoMapZoomLevel;
import com.avito.android.search.map.favorite_pins.FavoritePinsInteractor;
import com.avito.android.search.map.interactor.MapViewPortProvider;
import com.avito.android.search.map.interactor.ViewedPinsInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MapReducer_Factory implements Factory<MapReducer> {
    public final Provider<ViewedPinsInteractor> a;
    public final Provider<MapViewPortProvider> b;
    public final Provider<AvitoMapZoomLevel> c;
    public final Provider<FavoritePinsInteractor> d;

    public MapReducer_Factory(Provider<ViewedPinsInteractor> provider, Provider<MapViewPortProvider> provider2, Provider<AvitoMapZoomLevel> provider3, Provider<FavoritePinsInteractor> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MapReducer_Factory create(Provider<ViewedPinsInteractor> provider, Provider<MapViewPortProvider> provider2, Provider<AvitoMapZoomLevel> provider3, Provider<FavoritePinsInteractor> provider4) {
        return new MapReducer_Factory(provider, provider2, provider3, provider4);
    }

    public static MapReducer newInstance(ViewedPinsInteractor viewedPinsInteractor, MapViewPortProvider mapViewPortProvider, AvitoMapZoomLevel avitoMapZoomLevel, FavoritePinsInteractor favoritePinsInteractor) {
        return new MapReducer(viewedPinsInteractor, mapViewPortProvider, avitoMapZoomLevel, favoritePinsInteractor);
    }

    @Override // javax.inject.Provider
    public MapReducer get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
