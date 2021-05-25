package com.avito.android.tariff.count.recycler;

import dagger.internal.Factory;
public final class TariffCountContentsComparator_Factory implements Factory<TariffCountContentsComparator> {

    public static final class a {
        public static final TariffCountContentsComparator_Factory a = new TariffCountContentsComparator_Factory();
    }

    public static TariffCountContentsComparator_Factory create() {
        return a.a;
    }

    public static TariffCountContentsComparator newInstance() {
        return new TariffCountContentsComparator();
    }

    @Override // javax.inject.Provider
    public TariffCountContentsComparator get() {
        return newInstance();
    }
}
