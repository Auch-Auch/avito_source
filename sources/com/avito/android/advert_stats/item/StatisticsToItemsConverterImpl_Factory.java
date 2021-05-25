package com.avito.android.advert_stats.item;

import com.avito.android.Features;
import com.avito.android.analytics.bivrost.BivrostTutorialSessionStorage;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class StatisticsToItemsConverterImpl_Factory implements Factory<StatisticsToItemsConverterImpl> {
    public final Provider<StatisticStringResourceProvider> a;
    public final Provider<StatisticsIconProvider> b;
    public final Provider<StatisticDatesFormatter> c;
    public final Provider<Features> d;
    public final Provider<BivrostTutorialSessionStorage> e;

    public StatisticsToItemsConverterImpl_Factory(Provider<StatisticStringResourceProvider> provider, Provider<StatisticsIconProvider> provider2, Provider<StatisticDatesFormatter> provider3, Provider<Features> provider4, Provider<BivrostTutorialSessionStorage> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static StatisticsToItemsConverterImpl_Factory create(Provider<StatisticStringResourceProvider> provider, Provider<StatisticsIconProvider> provider2, Provider<StatisticDatesFormatter> provider3, Provider<Features> provider4, Provider<BivrostTutorialSessionStorage> provider5) {
        return new StatisticsToItemsConverterImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static StatisticsToItemsConverterImpl newInstance(StatisticStringResourceProvider statisticStringResourceProvider, StatisticsIconProvider statisticsIconProvider, StatisticDatesFormatter statisticDatesFormatter, Features features, BivrostTutorialSessionStorage bivrostTutorialSessionStorage) {
        return new StatisticsToItemsConverterImpl(statisticStringResourceProvider, statisticsIconProvider, statisticDatesFormatter, features, bivrostTutorialSessionStorage);
    }

    @Override // javax.inject.Provider
    public StatisticsToItemsConverterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
