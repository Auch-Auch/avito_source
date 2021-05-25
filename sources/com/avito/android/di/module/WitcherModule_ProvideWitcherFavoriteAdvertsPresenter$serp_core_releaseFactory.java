package com.avito.android.di.module;

import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsResourceProvider;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class WitcherModule_ProvideWitcherFavoriteAdvertsPresenter$serp_core_releaseFactory implements Factory<FavoriteAdvertsPresenter> {
    public final Provider<FavoriteAdvertsInteractor> a;
    public final Provider<FavoriteAdvertsResourceProvider> b;
    public final Provider<SchedulersFactory3> c;

    public WitcherModule_ProvideWitcherFavoriteAdvertsPresenter$serp_core_releaseFactory(Provider<FavoriteAdvertsInteractor> provider, Provider<FavoriteAdvertsResourceProvider> provider2, Provider<SchedulersFactory3> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static WitcherModule_ProvideWitcherFavoriteAdvertsPresenter$serp_core_releaseFactory create(Provider<FavoriteAdvertsInteractor> provider, Provider<FavoriteAdvertsResourceProvider> provider2, Provider<SchedulersFactory3> provider3) {
        return new WitcherModule_ProvideWitcherFavoriteAdvertsPresenter$serp_core_releaseFactory(provider, provider2, provider3);
    }

    public static FavoriteAdvertsPresenter provideWitcherFavoriteAdvertsPresenter$serp_core_release(FavoriteAdvertsInteractor favoriteAdvertsInteractor, FavoriteAdvertsResourceProvider favoriteAdvertsResourceProvider, SchedulersFactory3 schedulersFactory3) {
        return (FavoriteAdvertsPresenter) Preconditions.checkNotNullFromProvides(WitcherModule.INSTANCE.provideWitcherFavoriteAdvertsPresenter$serp_core_release(favoriteAdvertsInteractor, favoriteAdvertsResourceProvider, schedulersFactory3));
    }

    @Override // javax.inject.Provider
    public FavoriteAdvertsPresenter get() {
        return provideWitcherFavoriteAdvertsPresenter$serp_core_release(this.a.get(), this.b.get(), this.c.get());
    }
}
