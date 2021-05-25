package com.avito.android.favorites;

import com.avito.android.favorites.remote.FavoritesApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoritesCounterLoader_Factory implements Factory<FavoritesCounterLoader> {
    public final Provider<FavoritesApi> a;

    public FavoritesCounterLoader_Factory(Provider<FavoritesApi> provider) {
        this.a = provider;
    }

    public static FavoritesCounterLoader_Factory create(Provider<FavoritesApi> provider) {
        return new FavoritesCounterLoader_Factory(provider);
    }

    public static FavoritesCounterLoader newInstance(FavoritesApi favoritesApi) {
        return new FavoritesCounterLoader(favoritesApi);
    }

    @Override // javax.inject.Provider
    public FavoritesCounterLoader get() {
        return newInstance(this.a.get());
    }
}
