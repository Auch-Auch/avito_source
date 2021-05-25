package com.avito.android.delivery.order_cancellation.details;

import dagger.internal.Factory;
public final class ReasonDetailsItemsConverterImpl_Factory implements Factory<ReasonDetailsItemsConverterImpl> {

    public static final class a {
        public static final ReasonDetailsItemsConverterImpl_Factory a = new ReasonDetailsItemsConverterImpl_Factory();
    }

    public static ReasonDetailsItemsConverterImpl_Factory create() {
        return a.a;
    }

    public static ReasonDetailsItemsConverterImpl newInstance() {
        return new ReasonDetailsItemsConverterImpl();
    }

    @Override // javax.inject.Provider
    public ReasonDetailsItemsConverterImpl get() {
        return newInstance();
    }
}
