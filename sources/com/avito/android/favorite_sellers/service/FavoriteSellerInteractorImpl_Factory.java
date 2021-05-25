package com.avito.android.favorite_sellers.service;

import com.avito.android.FavoriteSellersRepository;
import com.avito.android.remote.FavoriteSellersApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteSellerInteractorImpl_Factory implements Factory<FavoriteSellerInteractorImpl> {
    public final Provider<FavoriteSellersApi> a;
    public final Provider<FavoriteSellersRepository> b;

    public FavoriteSellerInteractorImpl_Factory(Provider<FavoriteSellersApi> provider, Provider<FavoriteSellersRepository> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static FavoriteSellerInteractorImpl_Factory create(Provider<FavoriteSellersApi> provider, Provider<FavoriteSellersRepository> provider2) {
        return new FavoriteSellerInteractorImpl_Factory(provider, provider2);
    }

    public static FavoriteSellerInteractorImpl newInstance(FavoriteSellersApi favoriteSellersApi, FavoriteSellersRepository favoriteSellersRepository) {
        return new FavoriteSellerInteractorImpl(favoriteSellersApi, favoriteSellersRepository);
    }

    @Override // javax.inject.Provider
    public FavoriteSellerInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
