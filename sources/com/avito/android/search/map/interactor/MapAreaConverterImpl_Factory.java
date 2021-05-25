package com.avito.android.search.map.interactor;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MapAreaConverterImpl_Factory implements Factory<MapAreaConverterImpl> {
    public final Provider<MapViewPortProvider> a;

    public MapAreaConverterImpl_Factory(Provider<MapViewPortProvider> provider) {
        this.a = provider;
    }

    public static MapAreaConverterImpl_Factory create(Provider<MapViewPortProvider> provider) {
        return new MapAreaConverterImpl_Factory(provider);
    }

    public static MapAreaConverterImpl newInstance(MapViewPortProvider mapViewPortProvider) {
        return new MapAreaConverterImpl(mapViewPortProvider);
    }

    @Override // javax.inject.Provider
    public MapAreaConverterImpl get() {
        return newInstance(this.a.get());
    }
}
