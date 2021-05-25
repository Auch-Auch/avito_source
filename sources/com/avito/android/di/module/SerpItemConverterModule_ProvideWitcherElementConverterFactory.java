package com.avito.android.di.module;

import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import com.avito.android.serp.adapter.witcher.WitcherElementConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpItemConverterModule_ProvideWitcherElementConverterFactory implements Factory<WitcherElementConverter> {
    public final Provider<SerpAdvertConverter> a;
    public final Provider<FavoriteStatusResolver> b;
    public final Provider<ViewedStatusResolver> c;

    public SerpItemConverterModule_ProvideWitcherElementConverterFactory(Provider<SerpAdvertConverter> provider, Provider<FavoriteStatusResolver> provider2, Provider<ViewedStatusResolver> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SerpItemConverterModule_ProvideWitcherElementConverterFactory create(Provider<SerpAdvertConverter> provider, Provider<FavoriteStatusResolver> provider2, Provider<ViewedStatusResolver> provider3) {
        return new SerpItemConverterModule_ProvideWitcherElementConverterFactory(provider, provider2, provider3);
    }

    public static WitcherElementConverter provideWitcherElementConverter(SerpAdvertConverter serpAdvertConverter, FavoriteStatusResolver favoriteStatusResolver, ViewedStatusResolver viewedStatusResolver) {
        return (WitcherElementConverter) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideWitcherElementConverter(serpAdvertConverter, favoriteStatusResolver, viewedStatusResolver));
    }

    @Override // javax.inject.Provider
    public WitcherElementConverter get() {
        return provideWitcherElementConverter(this.a.get(), this.b.get(), this.c.get());
    }
}
