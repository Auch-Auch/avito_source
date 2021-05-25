package com.avito.android.delivery.order_cancellation;

import dagger.internal.Factory;
public final class RdsOrderCancellationItemsConverterImpl_Factory implements Factory<RdsOrderCancellationItemsConverterImpl> {

    public static final class a {
        public static final RdsOrderCancellationItemsConverterImpl_Factory a = new RdsOrderCancellationItemsConverterImpl_Factory();
    }

    public static RdsOrderCancellationItemsConverterImpl_Factory create() {
        return a.a;
    }

    public static RdsOrderCancellationItemsConverterImpl newInstance() {
        return new RdsOrderCancellationItemsConverterImpl();
    }

    @Override // javax.inject.Provider
    public RdsOrderCancellationItemsConverterImpl get() {
        return newInstance();
    }
}
