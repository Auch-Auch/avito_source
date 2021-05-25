package com.avito.android.favorites.adapter.error;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class FavoriteErrorItemBlueprint_Factory implements Factory<FavoriteErrorItemBlueprint> {
    public final Provider<FavoriteErrorItemPresenter> a;

    public FavoriteErrorItemBlueprint_Factory(Provider<FavoriteErrorItemPresenter> provider) {
        this.a = provider;
    }

    public static FavoriteErrorItemBlueprint_Factory create(Provider<FavoriteErrorItemPresenter> provider) {
        return new FavoriteErrorItemBlueprint_Factory(provider);
    }

    public static FavoriteErrorItemBlueprint newInstance(FavoriteErrorItemPresenter favoriteErrorItemPresenter) {
        return new FavoriteErrorItemBlueprint(favoriteErrorItemPresenter);
    }

    @Override // javax.inject.Provider
    public FavoriteErrorItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
