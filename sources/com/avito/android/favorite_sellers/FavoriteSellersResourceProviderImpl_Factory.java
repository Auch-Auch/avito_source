package com.avito.android.favorite_sellers;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteSellersResourceProviderImpl_Factory implements Factory<FavoriteSellersResourceProviderImpl> {
    public final Provider<Resources> a;

    public FavoriteSellersResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static FavoriteSellersResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new FavoriteSellersResourceProviderImpl_Factory(provider);
    }

    public static FavoriteSellersResourceProviderImpl newInstance(Resources resources) {
        return new FavoriteSellersResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public FavoriteSellersResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
