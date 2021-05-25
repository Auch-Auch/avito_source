package com.avito.android.tariff.count.viewmodel;

import dagger.internal.Factory;
public final class PriceConverterImpl_Factory implements Factory<PriceConverterImpl> {

    public static final class a {
        public static final PriceConverterImpl_Factory a = new PriceConverterImpl_Factory();
    }

    public static PriceConverterImpl_Factory create() {
        return a.a;
    }

    public static PriceConverterImpl newInstance() {
        return new PriceConverterImpl();
    }

    @Override // javax.inject.Provider
    public PriceConverterImpl get() {
        return newInstance();
    }
}
