package com.avito.android.orders.feature.common.converter;

import dagger.internal.Factory;
public final class OrdersItemConverterImpl_Factory implements Factory<OrdersItemConverterImpl> {

    public static final class a {
        public static final OrdersItemConverterImpl_Factory a = new OrdersItemConverterImpl_Factory();
    }

    public static OrdersItemConverterImpl_Factory create() {
        return a.a;
    }

    public static OrdersItemConverterImpl newInstance() {
        return new OrdersItemConverterImpl();
    }

    @Override // javax.inject.Provider
    public OrdersItemConverterImpl get() {
        return newInstance();
    }
}
