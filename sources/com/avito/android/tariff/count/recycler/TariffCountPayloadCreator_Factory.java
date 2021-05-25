package com.avito.android.tariff.count.recycler;

import dagger.internal.Factory;
public final class TariffCountPayloadCreator_Factory implements Factory<TariffCountPayloadCreator> {

    public static final class a {
        public static final TariffCountPayloadCreator_Factory a = new TariffCountPayloadCreator_Factory();
    }

    public static TariffCountPayloadCreator_Factory create() {
        return a.a;
    }

    public static TariffCountPayloadCreator newInstance() {
        return new TariffCountPayloadCreator();
    }

    @Override // javax.inject.Provider
    public TariffCountPayloadCreator get() {
        return newInstance();
    }
}
