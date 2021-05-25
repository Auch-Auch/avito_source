package com.avito.android.orders.feature.host;

import com.avito.android.Features;
import com.avito.android.remote.orders.OrdersApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class OrdersRepositoryImpl_Factory implements Factory<OrdersRepositoryImpl> {
    public final Provider<SchedulersFactory3> a;
    public final Provider<OrdersApi> b;
    public final Provider<Features> c;
    public final Provider<String> d;

    public OrdersRepositoryImpl_Factory(Provider<SchedulersFactory3> provider, Provider<OrdersApi> provider2, Provider<Features> provider3, Provider<String> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static OrdersRepositoryImpl_Factory create(Provider<SchedulersFactory3> provider, Provider<OrdersApi> provider2, Provider<Features> provider3, Provider<String> provider4) {
        return new OrdersRepositoryImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static OrdersRepositoryImpl newInstance(SchedulersFactory3 schedulersFactory3, OrdersApi ordersApi, Features features, String str) {
        return new OrdersRepositoryImpl(schedulersFactory3, ordersApi, features, str);
    }

    @Override // javax.inject.Provider
    public OrdersRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
