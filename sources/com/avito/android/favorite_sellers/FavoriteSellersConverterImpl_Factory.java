package com.avito.android.favorite_sellers;

import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteSellersConverterImpl_Factory implements Factory<FavoriteSellersConverterImpl> {
    public final Provider<SerpAdvertConverter> a;
    public final Provider<FavoriteStatusResolver> b;
    public final Provider<ViewedStatusResolver> c;

    public FavoriteSellersConverterImpl_Factory(Provider<SerpAdvertConverter> provider, Provider<FavoriteStatusResolver> provider2, Provider<ViewedStatusResolver> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static FavoriteSellersConverterImpl_Factory create(Provider<SerpAdvertConverter> provider, Provider<FavoriteStatusResolver> provider2, Provider<ViewedStatusResolver> provider3) {
        return new FavoriteSellersConverterImpl_Factory(provider, provider2, provider3);
    }

    public static FavoriteSellersConverterImpl newInstance(SerpAdvertConverter serpAdvertConverter, FavoriteStatusResolver favoriteStatusResolver, ViewedStatusResolver viewedStatusResolver) {
        return new FavoriteSellersConverterImpl(serpAdvertConverter, favoriteStatusResolver, viewedStatusResolver);
    }

    @Override // javax.inject.Provider
    public FavoriteSellersConverterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
