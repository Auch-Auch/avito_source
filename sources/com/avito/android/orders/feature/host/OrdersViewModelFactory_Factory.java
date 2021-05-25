package com.avito.android.orders.feature.host;

import com.avito.android.orders.feature.common.converter.OrdersItemConverter;
import com.avito.android.orders.feature.common.converter.OrdersTabItemConverter;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class OrdersViewModelFactory_Factory implements Factory<OrdersViewModelFactory> {
    public final Provider<OrdersRepository> a;
    public final Provider<TypedErrorThrowableConverter> b;
    public final Provider<OrdersTabItemConverter> c;
    public final Provider<OrdersItemConverter> d;
    public final Provider<String> e;

    public OrdersViewModelFactory_Factory(Provider<OrdersRepository> provider, Provider<TypedErrorThrowableConverter> provider2, Provider<OrdersTabItemConverter> provider3, Provider<OrdersItemConverter> provider4, Provider<String> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static OrdersViewModelFactory_Factory create(Provider<OrdersRepository> provider, Provider<TypedErrorThrowableConverter> provider2, Provider<OrdersTabItemConverter> provider3, Provider<OrdersItemConverter> provider4, Provider<String> provider5) {
        return new OrdersViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static OrdersViewModelFactory newInstance(OrdersRepository ordersRepository, TypedErrorThrowableConverter typedErrorThrowableConverter, OrdersTabItemConverter ordersTabItemConverter, OrdersItemConverter ordersItemConverter, String str) {
        return new OrdersViewModelFactory(ordersRepository, typedErrorThrowableConverter, ordersTabItemConverter, ordersItemConverter, str);
    }

    @Override // javax.inject.Provider
    public OrdersViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
