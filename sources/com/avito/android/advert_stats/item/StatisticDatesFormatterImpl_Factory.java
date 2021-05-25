package com.avito.android.advert_stats.item;

import dagger.internal.Factory;
public final class StatisticDatesFormatterImpl_Factory implements Factory<StatisticDatesFormatterImpl> {

    public static final class a {
        public static final StatisticDatesFormatterImpl_Factory a = new StatisticDatesFormatterImpl_Factory();
    }

    public static StatisticDatesFormatterImpl_Factory create() {
        return a.a;
    }

    public static StatisticDatesFormatterImpl newInstance() {
        return new StatisticDatesFormatterImpl();
    }

    @Override // javax.inject.Provider
    public StatisticDatesFormatterImpl get() {
        return newInstance();
    }
}
