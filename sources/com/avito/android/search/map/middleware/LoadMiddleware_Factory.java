package com.avito.android.search.map.middleware;

import com.avito.android.search.map.interactor.SearchMapInteractor;
import com.avito.android.search.map.interactor.SerpInteractor;
import com.avito.android.search.map.view.SerpListResourcesProvider;
import com.avito.android.search.subscriptions.SubscribeSearchInteractor;
import com.avito.android.serp.SerpItemProcessor;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LoadMiddleware_Factory implements Factory<LoadMiddleware> {
    public final Provider<SearchMapInteractor> a;
    public final Provider<SerpItemProcessor> b;
    public final Provider<SerpInteractor> c;
    public final Provider<SerpListResourcesProvider> d;
    public final Provider<SchedulersFactory3> e;
    public final Provider<SubscribeSearchInteractor> f;

    public LoadMiddleware_Factory(Provider<SearchMapInteractor> provider, Provider<SerpItemProcessor> provider2, Provider<SerpInteractor> provider3, Provider<SerpListResourcesProvider> provider4, Provider<SchedulersFactory3> provider5, Provider<SubscribeSearchInteractor> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static LoadMiddleware_Factory create(Provider<SearchMapInteractor> provider, Provider<SerpItemProcessor> provider2, Provider<SerpInteractor> provider3, Provider<SerpListResourcesProvider> provider4, Provider<SchedulersFactory3> provider5, Provider<SubscribeSearchInteractor> provider6) {
        return new LoadMiddleware_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static LoadMiddleware newInstance(SearchMapInteractor searchMapInteractor, SerpItemProcessor serpItemProcessor, SerpInteractor serpInteractor, SerpListResourcesProvider serpListResourcesProvider, SchedulersFactory3 schedulersFactory3, SubscribeSearchInteractor subscribeSearchInteractor) {
        return new LoadMiddleware(searchMapInteractor, serpItemProcessor, serpInteractor, serpListResourcesProvider, schedulersFactory3, subscribeSearchInteractor);
    }

    @Override // javax.inject.Provider
    public LoadMiddleware get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
