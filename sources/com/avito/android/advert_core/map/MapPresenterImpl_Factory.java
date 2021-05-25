package com.avito.android.advert_core.map;

import dagger.internal.Factory;
public final class MapPresenterImpl_Factory implements Factory<MapPresenterImpl> {

    public static final class a {
        public static final MapPresenterImpl_Factory a = new MapPresenterImpl_Factory();
    }

    public static MapPresenterImpl_Factory create() {
        return a.a;
    }

    public static MapPresenterImpl newInstance() {
        return new MapPresenterImpl();
    }

    @Override // javax.inject.Provider
    public MapPresenterImpl get() {
        return newInstance();
    }
}
