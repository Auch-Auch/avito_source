package com.avito.android.search.map.di;

import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.interactor.SerpCacheInteractor;
import com.avito.android.serp.SerpItemProcessor;
import com.avito.android.serp.adapter.SerpItemSaturator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpInteractorModule_ProvideCacheInteractorFactory implements Factory<SerpCacheInteractor> {
    public final Provider<SerpItemProcessor> a;
    public final Provider<SerpItemSaturator> b;
    public final Provider<SearchMapState> c;

    public SerpInteractorModule_ProvideCacheInteractorFactory(Provider<SerpItemProcessor> provider, Provider<SerpItemSaturator> provider2, Provider<SearchMapState> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SerpInteractorModule_ProvideCacheInteractorFactory create(Provider<SerpItemProcessor> provider, Provider<SerpItemSaturator> provider2, Provider<SearchMapState> provider3) {
        return new SerpInteractorModule_ProvideCacheInteractorFactory(provider, provider2, provider3);
    }

    public static SerpCacheInteractor provideCacheInteractor(SerpItemProcessor serpItemProcessor, SerpItemSaturator serpItemSaturator, SearchMapState searchMapState) {
        return (SerpCacheInteractor) Preconditions.checkNotNullFromProvides(SerpInteractorModule.provideCacheInteractor(serpItemProcessor, serpItemSaturator, searchMapState));
    }

    @Override // javax.inject.Provider
    public SerpCacheInteractor get() {
        return provideCacheInteractor(this.a.get(), this.b.get(), this.c.get());
    }
}
