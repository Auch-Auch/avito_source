package com.avito.android.orders.feature.list.adapter;

import dagger.internal.Factory;
public final class OrdersContentsComparator_Factory implements Factory<OrdersContentsComparator> {

    public static final class a {
        public static final OrdersContentsComparator_Factory a = new OrdersContentsComparator_Factory();
    }

    public static OrdersContentsComparator_Factory create() {
        return a.a;
    }

    public static OrdersContentsComparator newInstance() {
        return new OrdersContentsComparator();
    }

    @Override // javax.inject.Provider
    public OrdersContentsComparator get() {
        return newInstance();
    }
}
