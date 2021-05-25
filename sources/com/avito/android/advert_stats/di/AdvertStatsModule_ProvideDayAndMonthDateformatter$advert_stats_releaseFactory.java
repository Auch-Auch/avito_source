package com.avito.android.advert_stats.di;

import com.avito.android.util.DayAndMonthDateFormatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class AdvertStatsModule_ProvideDayAndMonthDateformatter$advert_stats_releaseFactory implements Factory<DayAndMonthDateFormatter> {
    public final AdvertStatsModule a;

    public AdvertStatsModule_ProvideDayAndMonthDateformatter$advert_stats_releaseFactory(AdvertStatsModule advertStatsModule) {
        this.a = advertStatsModule;
    }

    public static AdvertStatsModule_ProvideDayAndMonthDateformatter$advert_stats_releaseFactory create(AdvertStatsModule advertStatsModule) {
        return new AdvertStatsModule_ProvideDayAndMonthDateformatter$advert_stats_releaseFactory(advertStatsModule);
    }

    public static DayAndMonthDateFormatter provideDayAndMonthDateformatter$advert_stats_release(AdvertStatsModule advertStatsModule) {
        return (DayAndMonthDateFormatter) Preconditions.checkNotNullFromProvides(advertStatsModule.provideDayAndMonthDateformatter$advert_stats_release());
    }

    @Override // javax.inject.Provider
    public DayAndMonthDateFormatter get() {
        return provideDayAndMonthDateformatter$advert_stats_release(this.a);
    }
}
