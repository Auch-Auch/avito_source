package com.avito.android.di.module;

import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpItemConverterModule_ProvideFavoriteStatusResolverFactory implements Factory<FavoriteStatusResolver> {
    public final Provider<FavoriteAdvertsInteractor> a;

    public SerpItemConverterModule_ProvideFavoriteStatusResolverFactory(Provider<FavoriteAdvertsInteractor> provider) {
        this.a = provider;
    }

    public static SerpItemConverterModule_ProvideFavoriteStatusResolverFactory create(Provider<FavoriteAdvertsInteractor> provider) {
        return new SerpItemConverterModule_ProvideFavoriteStatusResolverFactory(provider);
    }

    public static FavoriteStatusResolver provideFavoriteStatusResolver(FavoriteAdvertsInteractor favoriteAdvertsInteractor) {
        return (FavoriteStatusResolver) Preconditions.checkNotNullFromProvides(SerpItemConverterModule.provideFavoriteStatusResolver(favoriteAdvertsInteractor));
    }

    @Override // javax.inject.Provider
    public FavoriteStatusResolver get() {
        return provideFavoriteStatusResolver(this.a.get());
    }
}
