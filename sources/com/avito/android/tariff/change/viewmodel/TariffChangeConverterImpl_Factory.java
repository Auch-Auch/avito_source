package com.avito.android.tariff.change.viewmodel;

import dagger.internal.Factory;
public final class TariffChangeConverterImpl_Factory implements Factory<TariffChangeConverterImpl> {

    public static final class a {
        public static final TariffChangeConverterImpl_Factory a = new TariffChangeConverterImpl_Factory();
    }

    public static TariffChangeConverterImpl_Factory create() {
        return a.a;
    }

    public static TariffChangeConverterImpl newInstance() {
        return new TariffChangeConverterImpl();
    }

    @Override // javax.inject.Provider
    public TariffChangeConverterImpl get() {
        return newInstance();
    }
}
