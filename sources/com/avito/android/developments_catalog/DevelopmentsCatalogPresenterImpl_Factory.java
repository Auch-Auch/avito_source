package com.avito.android.developments_catalog;

import com.avito.android.Features;
import com.avito.android.IdProvider;
import com.avito.android.developments_catalog.analytics.DevelopmentsCatalogAnalyticsInteractor;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DevelopmentsCatalogPresenterImpl_Factory implements Factory<DevelopmentsCatalogPresenterImpl> {
    public final Provider<String> a;
    public final Provider<String> b;
    public final Provider<String> c;
    public final Provider<String> d;
    public final Provider<DevelopmentsCatalogInteractor> e;
    public final Provider<DevelopmentsCatalogAnalyticsInteractor> f;
    public final Provider<IdProvider> g;
    public final Provider<SchedulersFactory3> h;
    public final Provider<Features> i;

    public DevelopmentsCatalogPresenterImpl_Factory(Provider<String> provider, Provider<String> provider2, Provider<String> provider3, Provider<String> provider4, Provider<DevelopmentsCatalogInteractor> provider5, Provider<DevelopmentsCatalogAnalyticsInteractor> provider6, Provider<IdProvider> provider7, Provider<SchedulersFactory3> provider8, Provider<Features> provider9) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
    }

    public static DevelopmentsCatalogPresenterImpl_Factory create(Provider<String> provider, Provider<String> provider2, Provider<String> provider3, Provider<String> provider4, Provider<DevelopmentsCatalogInteractor> provider5, Provider<DevelopmentsCatalogAnalyticsInteractor> provider6, Provider<IdProvider> provider7, Provider<SchedulersFactory3> provider8, Provider<Features> provider9) {
        return new DevelopmentsCatalogPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static DevelopmentsCatalogPresenterImpl newInstance(String str, String str2, String str3, String str4, DevelopmentsCatalogInteractor developmentsCatalogInteractor, DevelopmentsCatalogAnalyticsInteractor developmentsCatalogAnalyticsInteractor, IdProvider idProvider, SchedulersFactory3 schedulersFactory3, Features features) {
        return new DevelopmentsCatalogPresenterImpl(str, str2, str3, str4, developmentsCatalogInteractor, developmentsCatalogAnalyticsInteractor, idProvider, schedulersFactory3, features);
    }

    @Override // javax.inject.Provider
    public DevelopmentsCatalogPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get());
    }
}
