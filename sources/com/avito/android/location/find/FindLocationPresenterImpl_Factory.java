package com.avito.android.location.find;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class FindLocationPresenterImpl_Factory implements Factory<FindLocationPresenterImpl> {
    public final Provider<DefaultLocationProvider> a;
    public final Provider<GoogleServicesLocationProvider> b;

    public FindLocationPresenterImpl_Factory(Provider<DefaultLocationProvider> provider, Provider<GoogleServicesLocationProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static FindLocationPresenterImpl_Factory create(Provider<DefaultLocationProvider> provider, Provider<GoogleServicesLocationProvider> provider2) {
        return new FindLocationPresenterImpl_Factory(provider, provider2);
    }

    public static FindLocationPresenterImpl newInstance(DefaultLocationProvider defaultLocationProvider, GoogleServicesLocationProvider googleServicesLocationProvider) {
        return new FindLocationPresenterImpl(defaultLocationProvider, googleServicesLocationProvider);
    }

    @Override // javax.inject.Provider
    public FindLocationPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
