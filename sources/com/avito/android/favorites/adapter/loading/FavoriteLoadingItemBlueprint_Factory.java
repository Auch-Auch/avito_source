package com.avito.android.favorites.adapter.loading;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteLoadingItemBlueprint_Factory implements Factory<FavoriteLoadingItemBlueprint> {
    public final Provider<FavoriteLoadingItemPresenter> a;

    public FavoriteLoadingItemBlueprint_Factory(Provider<FavoriteLoadingItemPresenter> provider) {
        this.a = provider;
    }

    public static FavoriteLoadingItemBlueprint_Factory create(Provider<FavoriteLoadingItemPresenter> provider) {
        return new FavoriteLoadingItemBlueprint_Factory(provider);
    }

    public static FavoriteLoadingItemBlueprint newInstance(FavoriteLoadingItemPresenter favoriteLoadingItemPresenter) {
        return new FavoriteLoadingItemBlueprint(favoriteLoadingItemPresenter);
    }

    @Override // javax.inject.Provider
    public FavoriteLoadingItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
