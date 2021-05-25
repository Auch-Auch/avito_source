package com.avito.android.favorite;

import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteAdvertsPresenterImpl_Factory implements Factory<FavoriteAdvertsPresenterImpl> {
    public final Provider<FavoriteAdvertsInteractor> a;
    public final Provider<FavoriteAdvertsResourceProvider> b;
    public final Provider<SchedulersFactory3> c;

    public FavoriteAdvertsPresenterImpl_Factory(Provider<FavoriteAdvertsInteractor> provider, Provider<FavoriteAdvertsResourceProvider> provider2, Provider<SchedulersFactory3> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static FavoriteAdvertsPresenterImpl_Factory create(Provider<FavoriteAdvertsInteractor> provider, Provider<FavoriteAdvertsResourceProvider> provider2, Provider<SchedulersFactory3> provider3) {
        return new FavoriteAdvertsPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static FavoriteAdvertsPresenterImpl newInstance(FavoriteAdvertsInteractor favoriteAdvertsInteractor, FavoriteAdvertsResourceProvider favoriteAdvertsResourceProvider, SchedulersFactory3 schedulersFactory3) {
        return new FavoriteAdvertsPresenterImpl(favoriteAdvertsInteractor, favoriteAdvertsResourceProvider, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public FavoriteAdvertsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
