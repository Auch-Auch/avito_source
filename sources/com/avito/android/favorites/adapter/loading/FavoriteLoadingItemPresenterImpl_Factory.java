package com.avito.android.favorites.adapter.loading;

import com.avito.android.favorites.action.FavoriteItemAction;
import dagger.internal.Factory;
import io.reactivex.functions.Consumer;
import javax.inject.Provider;
public final class FavoriteLoadingItemPresenterImpl_Factory implements Factory<FavoriteLoadingItemPresenterImpl> {
    public final Provider<Consumer<FavoriteItemAction>> a;

    public FavoriteLoadingItemPresenterImpl_Factory(Provider<Consumer<FavoriteItemAction>> provider) {
        this.a = provider;
    }

    public static FavoriteLoadingItemPresenterImpl_Factory create(Provider<Consumer<FavoriteItemAction>> provider) {
        return new FavoriteLoadingItemPresenterImpl_Factory(provider);
    }

    public static FavoriteLoadingItemPresenterImpl newInstance(Consumer<FavoriteItemAction> consumer) {
        return new FavoriteLoadingItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public FavoriteLoadingItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
