package com.avito.android.advert.favorites;

import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.favorites.FavoriteAdvertsSyncEventProvider;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsFavoriteInteractorImpl_Factory implements Factory<AdvertDetailsFavoriteInteractorImpl> {
    public final Provider<FavoriteAdvertsInteractor> a;
    public final Provider<FavoriteAdvertsSyncEventProvider> b;
    public final Provider<SchedulersFactory3> c;

    public AdvertDetailsFavoriteInteractorImpl_Factory(Provider<FavoriteAdvertsInteractor> provider, Provider<FavoriteAdvertsSyncEventProvider> provider2, Provider<SchedulersFactory3> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AdvertDetailsFavoriteInteractorImpl_Factory create(Provider<FavoriteAdvertsInteractor> provider, Provider<FavoriteAdvertsSyncEventProvider> provider2, Provider<SchedulersFactory3> provider3) {
        return new AdvertDetailsFavoriteInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static AdvertDetailsFavoriteInteractorImpl newInstance(FavoriteAdvertsInteractor favoriteAdvertsInteractor, FavoriteAdvertsSyncEventProvider favoriteAdvertsSyncEventProvider, SchedulersFactory3 schedulersFactory3) {
        return new AdvertDetailsFavoriteInteractorImpl(favoriteAdvertsInteractor, favoriteAdvertsSyncEventProvider, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsFavoriteInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
