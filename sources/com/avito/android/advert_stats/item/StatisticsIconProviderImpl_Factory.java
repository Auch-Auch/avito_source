package com.avito.android.advert_stats.item;

import dagger.internal.Factory;
public final class StatisticsIconProviderImpl_Factory implements Factory<StatisticsIconProviderImpl> {

    public static final class a {
        public static final StatisticsIconProviderImpl_Factory a = new StatisticsIconProviderImpl_Factory();
    }

    public static StatisticsIconProviderImpl_Factory create() {
        return a.a;
    }

    public static StatisticsIconProviderImpl newInstance() {
        return new StatisticsIconProviderImpl();
    }

    @Override // javax.inject.Provider
    public StatisticsIconProviderImpl get() {
        return newInstance();
    }
}
