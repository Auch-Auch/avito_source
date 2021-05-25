package com.avito.android.orders.feature.list.adapter.order;

import com.avito.android.orders.feature.common.viewmodel.OrderItem;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class OrderItemPresenter_Factory implements Factory<OrderItemPresenter> {
    public final Provider<Consumer<OrderItem>> a;

    public OrderItemPresenter_Factory(Provider<Consumer<OrderItem>> provider) {
        this.a = provider;
    }

    public static OrderItemPresenter_Factory create(Provider<Consumer<OrderItem>> provider) {
        return new OrderItemPresenter_Factory(provider);
    }

    public static OrderItemPresenter newInstance(Consumer<OrderItem> consumer) {
        return new OrderItemPresenter(consumer);
    }

    @Override // javax.inject.Provider
    public OrderItemPresenter get() {
        return newInstance(this.a.get());
    }
}
