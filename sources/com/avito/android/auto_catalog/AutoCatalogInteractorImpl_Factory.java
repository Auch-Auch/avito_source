package com.avito.android.auto_catalog;

import com.avito.android.auto_catalog.remote.AutoCatalogApi;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.serp.adapter.SerpElementItemConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AutoCatalogInteractorImpl_Factory implements Factory<AutoCatalogInteractorImpl> {
    public final Provider<String> a;
    public final Provider<AutoCatalogData> b;
    public final Provider<AutoCatalogApi> c;
    public final Provider<SearchApi> d;
    public final Provider<SerpElementItemConverter> e;
    public final Provider<SearchParamsConverter> f;
    public final Provider<SchedulersFactory> g;
    public final Provider<TypedErrorThrowableConverter> h;

    public AutoCatalogInteractorImpl_Factory(Provider<String> provider, Provider<AutoCatalogData> provider2, Provider<AutoCatalogApi> provider3, Provider<SearchApi> provider4, Provider<SerpElementItemConverter> provider5, Provider<SearchParamsConverter> provider6, Provider<SchedulersFactory> provider7, Provider<TypedErrorThrowableConverter> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static AutoCatalogInteractorImpl_Factory create(Provider<String> provider, Provider<AutoCatalogData> provider2, Provider<AutoCatalogApi> provider3, Provider<SearchApi> provider4, Provider<SerpElementItemConverter> provider5, Provider<SearchParamsConverter> provider6, Provider<SchedulersFactory> provider7, Provider<TypedErrorThrowableConverter> provider8) {
        return new AutoCatalogInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static AutoCatalogInteractorImpl newInstance(String str, AutoCatalogData autoCatalogData, AutoCatalogApi autoCatalogApi, SearchApi searchApi, SerpElementItemConverter serpElementItemConverter, SearchParamsConverter searchParamsConverter, SchedulersFactory schedulersFactory, TypedErrorThrowableConverter typedErrorThrowableConverter) {
        return new AutoCatalogInteractorImpl(str, autoCatalogData, autoCatalogApi, searchApi, serpElementItemConverter, searchParamsConverter, schedulersFactory, typedErrorThrowableConverter);
    }

    @Override // javax.inject.Provider
    public AutoCatalogInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
