package com.avito.android.tariff.edit_info.item.prolongation;

import dagger.internal.Factory;
public final class TariffProlongationPayloadCreator_Factory implements Factory<TariffProlongationPayloadCreator> {

    public static final class a {
        public static final TariffProlongationPayloadCreator_Factory a = new TariffProlongationPayloadCreator_Factory();
    }

    public static TariffProlongationPayloadCreator_Factory create() {
        return a.a;
    }

    public static TariffProlongationPayloadCreator newInstance() {
        return new TariffProlongationPayloadCreator();
    }

    @Override // javax.inject.Provider
    public TariffProlongationPayloadCreator get() {
        return newInstance();
    }
}
