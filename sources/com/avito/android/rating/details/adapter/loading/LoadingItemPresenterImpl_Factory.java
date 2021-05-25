package com.avito.android.rating.details.adapter.loading;

import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class LoadingItemPresenterImpl_Factory implements Factory<LoadingItemPresenterImpl> {
    public final Provider<Consumer<LoadingItemNextPageAction>> a;

    public LoadingItemPresenterImpl_Factory(Provider<Consumer<LoadingItemNextPageAction>> provider) {
        this.a = provider;
    }

    public static LoadingItemPresenterImpl_Factory create(Provider<Consumer<LoadingItemNextPageAction>> provider) {
        return new LoadingItemPresenterImpl_Factory(provider);
    }

    public static LoadingItemPresenterImpl newInstance(Consumer<LoadingItemNextPageAction> consumer) {
        return new LoadingItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public LoadingItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
