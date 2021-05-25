package com.avito.android.tariff.view;

import dagger.internal.Factory;
public final class TariffBarConverterImpl_Factory implements Factory<TariffBarConverterImpl> {

    public static final class a {
        public static final TariffBarConverterImpl_Factory a = new TariffBarConverterImpl_Factory();
    }

    public static TariffBarConverterImpl_Factory create() {
        return a.a;
    }

    public static TariffBarConverterImpl newInstance() {
        return new TariffBarConverterImpl();
    }

    @Override // javax.inject.Provider
    public TariffBarConverterImpl get() {
        return newInstance();
    }
}
