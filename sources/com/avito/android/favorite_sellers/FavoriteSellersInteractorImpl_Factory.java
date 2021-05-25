package com.avito.android.favorite_sellers;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteSellersInteractorImpl_Factory implements Factory<FavoriteSellersInteractorImpl> {
    public final Provider<ScreenModeInteractor> a;

    public FavoriteSellersInteractorImpl_Factory(Provider<ScreenModeInteractor> provider) {
        this.a = provider;
    }

    public static FavoriteSellersInteractorImpl_Factory create(Provider<ScreenModeInteractor> provider) {
        return new FavoriteSellersInteractorImpl_Factory(provider);
    }

    public static FavoriteSellersInteractorImpl newInstance(ScreenModeInteractor screenModeInteractor) {
        return new FavoriteSellersInteractorImpl(screenModeInteractor);
    }

    @Override // javax.inject.Provider
    public FavoriteSellersInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
