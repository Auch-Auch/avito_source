package com.avito.android.search.map.favorite_pins;

import com.avito.android.favorite.FavoriteAdvertsInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavouritePinsInteractorImpl_Factory implements Factory<FavouritePinsInteractorImpl> {
    public final Provider<FavoriteAdvertsInteractor> a;

    public FavouritePinsInteractorImpl_Factory(Provider<FavoriteAdvertsInteractor> provider) {
        this.a = provider;
    }

    public static FavouritePinsInteractorImpl_Factory create(Provider<FavoriteAdvertsInteractor> provider) {
        return new FavouritePinsInteractorImpl_Factory(provider);
    }

    public static FavouritePinsInteractorImpl newInstance(FavoriteAdvertsInteractor favoriteAdvertsInteractor) {
        return new FavouritePinsInteractorImpl(favoriteAdvertsInteractor);
    }

    @Override // javax.inject.Provider
    public FavouritePinsInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
