package com.avito.android.order.feature.order;

import com.avito.android.remote.order.OrderApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class OrderRepositoryImpl_Factory implements Factory<OrderRepositoryImpl> {
    public final Provider<OrderApi> a;
    public final Provider<String> b;
    public final Provider<SchedulersFactory3> c;

    public OrderRepositoryImpl_Factory(Provider<OrderApi> provider, Provider<String> provider2, Provider<SchedulersFactory3> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static OrderRepositoryImpl_Factory create(Provider<OrderApi> provider, Provider<String> provider2, Provider<SchedulersFactory3> provider3) {
        return new OrderRepositoryImpl_Factory(provider, provider2, provider3);
    }

    public static OrderRepositoryImpl newInstance(OrderApi orderApi, String str, SchedulersFactory3 schedulersFactory3) {
        return new OrderRepositoryImpl(orderApi, str, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public OrderRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
