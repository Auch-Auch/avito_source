package com.avito.android.location.find;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class GoogleServicesLocationProviderImpl_Factory implements Factory<GoogleServicesLocationProviderImpl> {
    public final Provider<FusedLocationInteractor> a;

    public GoogleServicesLocationProviderImpl_Factory(Provider<FusedLocationInteractor> provider) {
        this.a = provider;
    }

    public static GoogleServicesLocationProviderImpl_Factory create(Provider<FusedLocationInteractor> provider) {
        return new GoogleServicesLocationProviderImpl_Factory(provider);
    }

    public static GoogleServicesLocationProviderImpl newInstance(FusedLocationInteractor fusedLocationInteractor) {
        return new GoogleServicesLocationProviderImpl(fusedLocationInteractor);
    }

    @Override // javax.inject.Provider
    public GoogleServicesLocationProviderImpl get() {
        return newInstance(this.a.get());
    }
}
