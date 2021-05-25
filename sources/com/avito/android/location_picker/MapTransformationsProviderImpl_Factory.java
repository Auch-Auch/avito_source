package com.avito.android.location_picker;

import dagger.internal.Factory;
public final class MapTransformationsProviderImpl_Factory implements Factory<MapTransformationsProviderImpl> {

    public static final class a {
        public static final MapTransformationsProviderImpl_Factory a = new MapTransformationsProviderImpl_Factory();
    }

    public static MapTransformationsProviderImpl_Factory create() {
        return a.a;
    }

    public static MapTransformationsProviderImpl newInstance() {
        return new MapTransformationsProviderImpl();
    }

    @Override // javax.inject.Provider
    public MapTransformationsProviderImpl get() {
        return newInstance();
    }
}
