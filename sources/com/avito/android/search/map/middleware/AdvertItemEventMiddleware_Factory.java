package com.avito.android.search.map.middleware;

import com.avito.android.favorite.FavoriteAdvertsPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertItemEventMiddleware_Factory implements Factory<AdvertItemEventMiddleware> {
    public final Provider<FavoriteAdvertsPresenter> a;

    public AdvertItemEventMiddleware_Factory(Provider<FavoriteAdvertsPresenter> provider) {
        this.a = provider;
    }

    public static AdvertItemEventMiddleware_Factory create(Provider<FavoriteAdvertsPresenter> provider) {
        return new AdvertItemEventMiddleware_Factory(provider);
    }

    public static AdvertItemEventMiddleware newInstance(FavoriteAdvertsPresenter favoriteAdvertsPresenter) {
        return new AdvertItemEventMiddleware(favoriteAdvertsPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertItemEventMiddleware get() {
        return newInstance(this.a.get());
    }
}
