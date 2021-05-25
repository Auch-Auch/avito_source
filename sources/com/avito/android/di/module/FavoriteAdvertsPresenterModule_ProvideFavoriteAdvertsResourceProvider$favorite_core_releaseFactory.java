package com.avito.android.di.module;

import android.content.res.Resources;
import com.avito.android.favorite.FavoriteAdvertsResourceProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsResourceProvider$favorite_core_releaseFactory implements Factory<FavoriteAdvertsResourceProvider> {
    public final Provider<Resources> a;

    public FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsResourceProvider$favorite_core_releaseFactory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsResourceProvider$favorite_core_releaseFactory create(Provider<Resources> provider) {
        return new FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsResourceProvider$favorite_core_releaseFactory(provider);
    }

    public static FavoriteAdvertsResourceProvider provideFavoriteAdvertsResourceProvider$favorite_core_release(Resources resources) {
        return (FavoriteAdvertsResourceProvider) Preconditions.checkNotNullFromProvides(FavoriteAdvertsPresenterModule.provideFavoriteAdvertsResourceProvider$favorite_core_release(resources));
    }

    @Override // javax.inject.Provider
    public FavoriteAdvertsResourceProvider get() {
        return provideFavoriteAdvertsResourceProvider$favorite_core_release(this.a.get());
    }
}
