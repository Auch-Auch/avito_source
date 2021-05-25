package com.avito.android.orders.feature.list;

import com.avito.android.Features;
import com.avito.android.remote.orders.OrdersApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class OrdersListRepositoryImpl_Factory implements Factory<OrdersListRepositoryImpl> {
    public final Provider<SchedulersFactory3> a;
    public final Provider<OrdersApi> b;
    public final Provider<Features> c;

    public OrdersListRepositoryImpl_Factory(Provider<SchedulersFactory3> provider, Provider<OrdersApi> provider2, Provider<Features> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static OrdersListRepositoryImpl_Factory create(Provider<SchedulersFactory3> provider, Provider<OrdersApi> provider2, Provider<Features> provider3) {
        return new OrdersListRepositoryImpl_Factory(provider, provider2, provider3);
    }

    public static OrdersListRepositoryImpl newInstance(SchedulersFactory3 schedulersFactory3, OrdersApi ordersApi, Features features) {
        return new OrdersListRepositoryImpl(schedulersFactory3, ordersApi, features);
    }

    @Override // javax.inject.Provider
    public OrdersListRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
