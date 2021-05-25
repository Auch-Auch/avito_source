package com.avito.android.di.module;

import com.avito.android.serp.SerpItemProcessor;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.SerpElementItemConverter;
import com.avito.android.serp.adapter.SerpItemSizeAdjuster;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import com.avito.android.serp.adapter.item_sorter.SerpItemSorter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpItemConverterModule_ProvideSerpItemProcessorFactory implements Factory<SerpItemProcessor> {
    public final Provider<SerpElementItemConverter> a;
    public final Provider<SerpItemSorter> b;
    public final Provider<SerpItemSizeAdjuster> c;
    public final Provider<FavoriteStatusResolver> d;
    public final Provider<ViewedStatusResolver> e;
    public final Provider<SchedulersFactory3> f;

    public SerpItemConverterModule_ProvideSerpItemProcessorFactory(Provider<SerpElementItemConverter> provider, Provider<SerpItemSorter> provider2, Provider<SerpItemSizeAdjuster> provider3, Provider<FavoriteStatusResolver> provider4, Provider<ViewedStatusResolver> provider5, Provider<SchedulersFactory3> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static SerpItemConverterModule_ProvideSerpItemProcessorFactory create(Provider<SerpElementItemConverter> provider, Provider<SerpItemSorter> provider2, Provider<SerpItemSizeAdjuster> provider3, Provider<FavoriteStatusResolver> provider4, Provider<ViewedStatusResolver> provider5, Provider<SchedulersFactory3> provider6) {
        return new SerpItemConverterModule_ProvideSerpItemProcessorFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static SerpItemProcessor provideSerpItemProcessor(SerpElementItemConverter serpElementItemConverter, SerpItemSorter serpItemSorter, SerpItemSizeAdjuster serpItemSizeAdjuster, FavoriteStatusResolver favoriteStatusResolver, ViewedStatusResolver viewedStatusResolver, SchedulersFactory3 schedulersFactory3) {
        return (SerpItemProcessor) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideSerpItemProcessor(serpElementItemConverter, serpItemSorter, serpItemSizeAdjuster, favoriteStatusResolver, viewedStatusResolver, schedulersFactory3));
    }

    @Override // javax.inject.Provider
    public SerpItemProcessor get() {
        return provideSerpItemProcessor(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
