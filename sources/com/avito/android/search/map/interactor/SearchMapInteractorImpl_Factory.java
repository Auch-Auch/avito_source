package com.avito.android.search.map.interactor;

import com.avito.android.Features;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SuggestParamsConverter;
import com.avito.android.search.SearchDeepLinkInteractor;
import com.avito.android.search.map.provider.SearchHashProvider;
import com.avito.android.serp.InlineFiltersInteractor;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SearchMapInteractorImpl_Factory implements Factory<SearchMapInteractorImpl> {
    public final Provider<SearchApi> a;
    public final Provider<SearchParams> b;
    public final Provider<SuggestParamsConverter> c;
    public final Provider<SearchParamsConverter> d;
    public final Provider<TypedErrorThrowableConverter> e;
    public final Provider<SearchDeepLinkInteractor> f;
    public final Provider<MapViewPortProvider> g;
    public final Provider<SchedulersFactory3> h;
    public final Provider<SearchHashProvider> i;
    public final Provider<InlineFiltersInteractor> j;
    public final Provider<Features> k;

    public SearchMapInteractorImpl_Factory(Provider<SearchApi> provider, Provider<SearchParams> provider2, Provider<SuggestParamsConverter> provider3, Provider<SearchParamsConverter> provider4, Provider<TypedErrorThrowableConverter> provider5, Provider<SearchDeepLinkInteractor> provider6, Provider<MapViewPortProvider> provider7, Provider<SchedulersFactory3> provider8, Provider<SearchHashProvider> provider9, Provider<InlineFiltersInteractor> provider10, Provider<Features> provider11) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
    }

    public static SearchMapInteractorImpl_Factory create(Provider<SearchApi> provider, Provider<SearchParams> provider2, Provider<SuggestParamsConverter> provider3, Provider<SearchParamsConverter> provider4, Provider<TypedErrorThrowableConverter> provider5, Provider<SearchDeepLinkInteractor> provider6, Provider<MapViewPortProvider> provider7, Provider<SchedulersFactory3> provider8, Provider<SearchHashProvider> provider9, Provider<InlineFiltersInteractor> provider10, Provider<Features> provider11) {
        return new SearchMapInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static SearchMapInteractorImpl newInstance(SearchApi searchApi, SearchParams searchParams, SuggestParamsConverter suggestParamsConverter, SearchParamsConverter searchParamsConverter, TypedErrorThrowableConverter typedErrorThrowableConverter, SearchDeepLinkInteractor searchDeepLinkInteractor, MapViewPortProvider mapViewPortProvider, SchedulersFactory3 schedulersFactory3, SearchHashProvider searchHashProvider, InlineFiltersInteractor inlineFiltersInteractor, Features features) {
        return new SearchMapInteractorImpl(searchApi, searchParams, suggestParamsConverter, searchParamsConverter, typedErrorThrowableConverter, searchDeepLinkInteractor, mapViewPortProvider, schedulersFactory3, searchHashProvider, inlineFiltersInteractor, features);
    }

    @Override // javax.inject.Provider
    public SearchMapInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get());
    }
}
