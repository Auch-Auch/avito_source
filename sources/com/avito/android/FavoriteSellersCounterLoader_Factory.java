package com.avito.android;

import com.avito.android.remote.FavoriteSellersApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteSellersCounterLoader_Factory implements Factory<FavoriteSellersCounterLoader> {
    public final Provider<FavoriteSellersApi> a;

    public FavoriteSellersCounterLoader_Factory(Provider<FavoriteSellersApi> provider) {
        this.a = provider;
    }

    public static FavoriteSellersCounterLoader_Factory create(Provider<FavoriteSellersApi> provider) {
        return new FavoriteSellersCounterLoader_Factory(provider);
    }

    public static FavoriteSellersCounterLoader newInstance(FavoriteSellersApi favoriteSellersApi) {
        return new FavoriteSellersCounterLoader(favoriteSellersApi);
    }

    @Override // javax.inject.Provider
    public FavoriteSellersCounterLoader get() {
        return newInstance(this.a.get());
    }
}
