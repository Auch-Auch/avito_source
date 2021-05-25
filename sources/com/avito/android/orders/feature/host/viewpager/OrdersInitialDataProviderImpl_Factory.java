package com.avito.android.orders.feature.host.viewpager;

import dagger.internal.Factory;
public final class OrdersInitialDataProviderImpl_Factory implements Factory<OrdersInitialDataProviderImpl> {

    public static final class a {
        public static final OrdersInitialDataProviderImpl_Factory a = new OrdersInitialDataProviderImpl_Factory();
    }

    public static OrdersInitialDataProviderImpl_Factory create() {
        return a.a;
    }

    public static OrdersInitialDataProviderImpl newInstance() {
        return new OrdersInitialDataProviderImpl();
    }

    @Override // javax.inject.Provider
    public OrdersInitialDataProviderImpl get() {
        return newInstance();
    }
}
