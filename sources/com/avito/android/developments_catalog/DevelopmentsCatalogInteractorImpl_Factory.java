package com.avito.android.developments_catalog;

import com.avito.android.Features;
import com.avito.android.developments_catalog.remote.DevelopmentsCatalogApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DevelopmentsCatalogInteractorImpl_Factory implements Factory<DevelopmentsCatalogInteractorImpl> {
    public final Provider<DevelopmentsCatalogApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<TypedErrorThrowableConverter> c;
    public final Provider<Features> d;

    public DevelopmentsCatalogInteractorImpl_Factory(Provider<DevelopmentsCatalogApi> provider, Provider<SchedulersFactory3> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<Features> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static DevelopmentsCatalogInteractorImpl_Factory create(Provider<DevelopmentsCatalogApi> provider, Provider<SchedulersFactory3> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<Features> provider4) {
        return new DevelopmentsCatalogInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static DevelopmentsCatalogInteractorImpl newInstance(DevelopmentsCatalogApi developmentsCatalogApi, SchedulersFactory3 schedulersFactory3, TypedErrorThrowableConverter typedErrorThrowableConverter, Features features) {
        return new DevelopmentsCatalogInteractorImpl(developmentsCatalogApi, schedulersFactory3, typedErrorThrowableConverter, features);
    }

    @Override // javax.inject.Provider
    public DevelopmentsCatalogInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
