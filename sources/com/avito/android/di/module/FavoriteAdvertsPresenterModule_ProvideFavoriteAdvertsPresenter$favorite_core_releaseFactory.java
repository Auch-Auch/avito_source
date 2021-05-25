package com.avito.android.di.module;

import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsResourceProvider;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsPresenter$favorite_core_releaseFactory implements Factory<FavoriteAdvertsPresenter> {
    public final Provider<FavoriteAdvertsInteractor> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<FavoriteAdvertsResourceProvider> c;

    public FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsPresenter$favorite_core_releaseFactory(Provider<FavoriteAdvertsInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<FavoriteAdvertsResourceProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsPresenter$favorite_core_releaseFactory create(Provider<FavoriteAdvertsInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<FavoriteAdvertsResourceProvider> provider3) {
        return new FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsPresenter$favorite_core_releaseFactory(provider, provider2, provider3);
    }

    public static FavoriteAdvertsPresenter provideFavoriteAdvertsPresenter$favorite_core_release(FavoriteAdvertsInteractor favoriteAdvertsInteractor, SchedulersFactory3 schedulersFactory3, FavoriteAdvertsResourceProvider favoriteAdvertsResourceProvider) {
        return (FavoriteAdvertsPresenter) Preconditions.checkNotNullFromProvides(FavoriteAdvertsPresenterModule.provideFavoriteAdvertsPresenter$favorite_core_release(favoriteAdvertsInteractor, schedulersFactory3, favoriteAdvertsResourceProvider));
    }

    @Override // javax.inject.Provider
    public FavoriteAdvertsPresenter get() {
        return provideFavoriteAdvertsPresenter$favorite_core_release(this.a.get(), this.b.get(), this.c.get());
    }
}
