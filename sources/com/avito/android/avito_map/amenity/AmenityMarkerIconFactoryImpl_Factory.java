package com.avito.android.avito_map.amenity;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AmenityMarkerIconFactoryImpl_Factory implements Factory<AmenityMarkerIconFactoryImpl> {
    public final Provider<Context> a;

    public AmenityMarkerIconFactoryImpl_Factory(Provider<Context> provider) {
        this.a = provider;
    }

    public static AmenityMarkerIconFactoryImpl_Factory create(Provider<Context> provider) {
        return new AmenityMarkerIconFactoryImpl_Factory(provider);
    }

    public static AmenityMarkerIconFactoryImpl newInstance(Context context) {
        return new AmenityMarkerIconFactoryImpl(context);
    }

    @Override // javax.inject.Provider
    public AmenityMarkerIconFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
