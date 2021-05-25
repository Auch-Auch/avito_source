package com.avito.android.favorite_sellers.adapter.error;

import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class ErrorItemPresenterImpl_Factory implements Factory<ErrorItemPresenterImpl> {
    public final Provider<Consumer<FavoriteSellersItemAction>> a;

    public ErrorItemPresenterImpl_Factory(Provider<Consumer<FavoriteSellersItemAction>> provider) {
        this.a = provider;
    }

    public static ErrorItemPresenterImpl_Factory create(Provider<Consumer<FavoriteSellersItemAction>> provider) {
        return new ErrorItemPresenterImpl_Factory(provider);
    }

    public static ErrorItemPresenterImpl newInstance(Consumer<FavoriteSellersItemAction> consumer) {
        return new ErrorItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public ErrorItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
