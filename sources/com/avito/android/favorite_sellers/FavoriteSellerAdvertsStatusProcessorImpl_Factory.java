package com.avito.android.favorite_sellers;

import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteSellerAdvertsStatusProcessorImpl_Factory implements Factory<FavoriteSellerAdvertsStatusProcessorImpl> {
    public final Provider<FavoriteStatusResolver> a;
    public final Provider<ViewedStatusResolver> b;

    public FavoriteSellerAdvertsStatusProcessorImpl_Factory(Provider<FavoriteStatusResolver> provider, Provider<ViewedStatusResolver> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static FavoriteSellerAdvertsStatusProcessorImpl_Factory create(Provider<FavoriteStatusResolver> provider, Provider<ViewedStatusResolver> provider2) {
        return new FavoriteSellerAdvertsStatusProcessorImpl_Factory(provider, provider2);
    }

    public static FavoriteSellerAdvertsStatusProcessorImpl newInstance(FavoriteStatusResolver favoriteStatusResolver, ViewedStatusResolver viewedStatusResolver) {
        return new FavoriteSellerAdvertsStatusProcessorImpl(favoriteStatusResolver, viewedStatusResolver);
    }

    @Override // javax.inject.Provider
    public FavoriteSellerAdvertsStatusProcessorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
