package com.avito.android.order.feature.order;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class OrderViewModelFactory_Factory implements Factory<OrderViewModelFactory> {
    public final Provider<OrderRepository> a;

    public OrderViewModelFactory_Factory(Provider<OrderRepository> provider) {
        this.a = provider;
    }

    public static OrderViewModelFactory_Factory create(Provider<OrderRepository> provider) {
        return new OrderViewModelFactory_Factory(provider);
    }

    public static OrderViewModelFactory newInstance(OrderRepository orderRepository) {
        return new OrderViewModelFactory(orderRepository);
    }

    @Override // javax.inject.Provider
    public OrderViewModelFactory get() {
        return newInstance(this.a.get());
    }
}
