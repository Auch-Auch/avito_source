package com.avito.android.favorites.adapter.error;

import com.avito.android.favorites.action.FavoriteItemAction;
import dagger.internal.Factory;
import io.reactivex.functions.Consumer;
import javax.inject.Provider;
public final class FavoriteErrorItemPresenterImpl_Factory implements Factory<FavoriteErrorItemPresenterImpl> {
    public final Provider<Consumer<FavoriteItemAction>> a;

    public FavoriteErrorItemPresenterImpl_Factory(Provider<Consumer<FavoriteItemAction>> provider) {
        this.a = provider;
    }

    public static FavoriteErrorItemPresenterImpl_Factory create(Provider<Consumer<FavoriteItemAction>> provider) {
        return new FavoriteErrorItemPresenterImpl_Factory(provider);
    }

    public static FavoriteErrorItemPresenterImpl newInstance(Consumer<FavoriteItemAction> consumer) {
        return new FavoriteErrorItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public FavoriteErrorItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
