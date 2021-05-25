package com.avito.android.shop.detailed;

import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.SerpElementItemConverter;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopDetailedItemsConverterImpl_Factory implements Factory<ShopDetailedItemsConverterImpl> {
    public final Provider<ShopAdvertsResourceProvider> a;
    public final Provider<SerpElementItemConverter> b;
    public final Provider<FavoriteStatusResolver> c;
    public final Provider<ViewedStatusResolver> d;

    public ShopDetailedItemsConverterImpl_Factory(Provider<ShopAdvertsResourceProvider> provider, Provider<SerpElementItemConverter> provider2, Provider<FavoriteStatusResolver> provider3, Provider<ViewedStatusResolver> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static ShopDetailedItemsConverterImpl_Factory create(Provider<ShopAdvertsResourceProvider> provider, Provider<SerpElementItemConverter> provider2, Provider<FavoriteStatusResolver> provider3, Provider<ViewedStatusResolver> provider4) {
        return new ShopDetailedItemsConverterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static ShopDetailedItemsConverterImpl newInstance(ShopAdvertsResourceProvider shopAdvertsResourceProvider, SerpElementItemConverter serpElementItemConverter, FavoriteStatusResolver favoriteStatusResolver, ViewedStatusResolver viewedStatusResolver) {
        return new ShopDetailedItemsConverterImpl(shopAdvertsResourceProvider, serpElementItemConverter, favoriteStatusResolver, viewedStatusResolver);
    }

    @Override // javax.inject.Provider
    public ShopDetailedItemsConverterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
