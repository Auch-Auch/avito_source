package com.avito.android.orders.feature.common.converter;

import dagger.internal.Factory;
public final class OrdersTabItemConverterImpl_Factory implements Factory<OrdersTabItemConverterImpl> {

    public static final class a {
        public static final OrdersTabItemConverterImpl_Factory a = new OrdersTabItemConverterImpl_Factory();
    }

    public static OrdersTabItemConverterImpl_Factory create() {
        return a.a;
    }

    public static OrdersTabItemConverterImpl newInstance() {
        return new OrdersTabItemConverterImpl();
    }

    @Override // javax.inject.Provider
    public OrdersTabItemConverterImpl get() {
        return newInstance();
    }
}
