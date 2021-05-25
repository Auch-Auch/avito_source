package com.avito.android.favorite_sellers.adapter.advert_list.di;

import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsResourceProvider;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdvertListItemModule_ProvideFavoriteAdvertsPresenterFactory implements Factory<FavoriteAdvertsPresenter> {
    public final Provider<FavoriteAdvertsInteractor> a;
    public final Provider<FavoriteAdvertsResourceProvider> b;
    public final Provider<SchedulersFactory3> c;

    public AdvertListItemModule_ProvideFavoriteAdvertsPresenterFactory(Provider<FavoriteAdvertsInteractor> provider, Provider<FavoriteAdvertsResourceProvider> provider2, Provider<SchedulersFactory3> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AdvertListItemModule_ProvideFavoriteAdvertsPresenterFactory create(Provider<FavoriteAdvertsInteractor> provider, Provider<FavoriteAdvertsResourceProvider> provider2, Provider<SchedulersFactory3> provider3) {
        return new AdvertListItemModule_ProvideFavoriteAdvertsPresenterFactory(provider, provider2, provider3);
    }

    public static FavoriteAdvertsPresenter provideFavoriteAdvertsPresenter(FavoriteAdvertsInteractor favoriteAdvertsInteractor, FavoriteAdvertsResourceProvider favoriteAdvertsResourceProvider, SchedulersFactory3 schedulersFactory3) {
        return (FavoriteAdvertsPresenter) Preconditions.checkNotNullFromProvides(AdvertListItemModule.provideFavoriteAdvertsPresenter(favoriteAdvertsInteractor, favoriteAdvertsResourceProvider, schedulersFactory3));
    }

    @Override // javax.inject.Provider
    public FavoriteAdvertsPresenter get() {
        return provideFavoriteAdvertsPresenter(this.a.get(), this.b.get(), this.c.get());
    }
}
