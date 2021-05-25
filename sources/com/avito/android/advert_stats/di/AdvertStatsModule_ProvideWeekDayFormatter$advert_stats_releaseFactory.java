package com.avito.android.advert_stats.di;

import com.avito.android.util.DayOfWeekFormatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
public final class AdvertStatsModule_ProvideWeekDayFormatter$advert_stats_releaseFactory implements Factory<DayOfWeekFormatter> {
    public final AdvertStatsModule a;
    public final Provider<Locale> b;

    public AdvertStatsModule_ProvideWeekDayFormatter$advert_stats_releaseFactory(AdvertStatsModule advertStatsModule, Provider<Locale> provider) {
        this.a = advertStatsModule;
        this.b = provider;
    }

    public static AdvertStatsModule_ProvideWeekDayFormatter$advert_stats_releaseFactory create(AdvertStatsModule advertStatsModule, Provider<Locale> provider) {
        return new AdvertStatsModule_ProvideWeekDayFormatter$advert_stats_releaseFactory(advertStatsModule, provider);
    }

    public static DayOfWeekFormatter provideWeekDayFormatter$advert_stats_release(AdvertStatsModule advertStatsModule, Locale locale) {
        return (DayOfWeekFormatter) Preconditions.checkNotNullFromProvides(advertStatsModule.provideWeekDayFormatter$advert_stats_release(locale));
    }

    @Override // javax.inject.Provider
    public DayOfWeekFormatter get() {
        return provideWeekDayFormatter$advert_stats_release(this.a, this.b.get());
    }
}
