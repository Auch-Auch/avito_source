package com.avito.android.favorite_sellers.adapter.loading;

import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class LoadingItemPresenterImpl_Factory implements Factory<LoadingItemPresenterImpl> {
    public final Provider<Consumer<FavoriteSellersItemAction>> a;

    public LoadingItemPresenterImpl_Factory(Provider<Consumer<FavoriteSellersItemAction>> provider) {
        this.a = provider;
    }

    public static LoadingItemPresenterImpl_Factory create(Provider<Consumer<FavoriteSellersItemAction>> provider) {
        return new LoadingItemPresenterImpl_Factory(provider);
    }

    public static LoadingItemPresenterImpl newInstance(Consumer<FavoriteSellersItemAction> consumer) {
        return new LoadingItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public LoadingItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
