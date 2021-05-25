package com.avito.android.orders.feature.list.adapter.loading;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class OrderLoadingItemBlueprint_Factory implements Factory<OrderLoadingItemBlueprint> {
    public final Provider<LoadingItemPresenter> a;

    public OrderLoadingItemBlueprint_Factory(Provider<LoadingItemPresenter> provider) {
        this.a = provider;
    }

    public static OrderLoadingItemBlueprint_Factory create(Provider<LoadingItemPresenter> provider) {
        return new OrderLoadingItemBlueprint_Factory(provider);
    }

    public static OrderLoadingItemBlueprint newInstance(LoadingItemPresenter loadingItemPresenter) {
        return new OrderLoadingItemBlueprint(loadingItemPresenter);
    }

    @Override // javax.inject.Provider
    public OrderLoadingItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
