package com.avito.android.location.find;

import com.avito.android.geo.GeoStorage;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FusedLocationInteractorImpl_Factory implements Factory<FusedLocationInteractorImpl> {
    public final Provider<GeoStorage> a;

    public FusedLocationInteractorImpl_Factory(Provider<GeoStorage> provider) {
        this.a = provider;
    }

    public static FusedLocationInteractorImpl_Factory create(Provider<GeoStorage> provider) {
        return new FusedLocationInteractorImpl_Factory(provider);
    }

    public static FusedLocationInteractorImpl newInstance(GeoStorage geoStorage) {
        return new FusedLocationInteractorImpl(geoStorage);
    }

    @Override // javax.inject.Provider
    public FusedLocationInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
