package com.avito.android.serp.adapter;

import com.avito.android.favorite.FavoriteAdvertsInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteStatusResolverImpl_Factory implements Factory<FavoriteStatusResolverImpl> {
    public final Provider<FavoriteAdvertsInteractor> a;

    public FavoriteStatusResolverImpl_Factory(Provider<FavoriteAdvertsInteractor> provider) {
        this.a = provider;
    }

    public static FavoriteStatusResolverImpl_Factory create(Provider<FavoriteAdvertsInteractor> provider) {
        return new FavoriteStatusResolverImpl_Factory(provider);
    }

    public static FavoriteStatusResolverImpl newInstance(FavoriteAdvertsInteractor favoriteAdvertsInteractor) {
        return new FavoriteStatusResolverImpl(favoriteAdvertsInteractor);
    }

    @Override // javax.inject.Provider
    public FavoriteStatusResolverImpl get() {
        return newInstance(this.a.get());
    }
}
