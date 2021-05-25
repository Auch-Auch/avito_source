package com.avito.android.search.map.interactor;

import com.avito.android.remote.SearchApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.search.map.view.SerpListResourcesProvider;
import com.avito.android.serp.CommercialBannersInteractor;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpInteractorImpl_Factory implements Factory<SerpInteractorImpl> {
    public final Provider<SearchApi> a;
    public final Provider<SearchParamsConverter> b;
    public final Provider<CommercialBannersInteractor> c;
    public final Provider<SerpCacheInteractor> d;
    public final Provider<RandomKeyProvider> e;
    public final Provider<SerpListResourcesProvider> f;
    public final Provider<TypedErrorThrowableConverter> g;
    public final Provider<MapViewPortProvider> h;
    public final Provider<SchedulersFactory3> i;

    public SerpInteractorImpl_Factory(Provider<SearchApi> provider, Provider<SearchParamsConverter> provider2, Provider<CommercialBannersInteractor> provider3, Provider<SerpCacheInteractor> provider4, Provider<RandomKeyProvider> provider5, Provider<SerpListResourcesProvider> provider6, Provider<TypedErrorThrowableConverter> provider7, Provider<MapViewPortProvider> provider8, Provider<SchedulersFactory3> provider9) {
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

    public static SerpInteractorImpl_Factory create(Provider<SearchApi> provider, Provider<SearchParamsConverter> provider2, Provider<CommercialBannersInteractor> provider3, Provider<SerpCacheInteractor> provider4, Provider<RandomKeyProvider> provider5, Provider<SerpListResourcesProvider> provider6, Provider<TypedErrorThrowableConverter> provider7, Provider<MapViewPortProvider> provider8, Provider<SchedulersFactory3> provider9) {
        return new SerpInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static SerpInteractorImpl newInstance(SearchApi searchApi, SearchParamsConverter searchParamsConverter, CommercialBannersInteractor commercialBannersInteractor, SerpCacheInteractor serpCacheInteractor, RandomKeyProvider randomKeyProvider, SerpListResourcesProvider serpListResourcesProvider, TypedErrorThrowableConverter typedErrorThrowableConverter, MapViewPortProvider mapViewPortProvider, SchedulersFactory3 schedulersFactory3) {
        return new SerpInteractorImpl(searchApi, searchParamsConverter, commercialBannersInteractor, serpCacheInteractor, randomKeyProvider, serpListResourcesProvider, typedErrorThrowableConverter, mapViewPortProvider, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public SerpInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get());
    }
}
