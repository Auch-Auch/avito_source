package com.avito.android.di.module;

import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.date_time_formatter.DateTimeFormatterResourceProvider;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
public final class DateTimeFormatterModule_ProvideLowerCaseDateTimeFormatterFactory implements Factory<DateTimeFormatter> {
    public final Provider<TimeSource> a;
    public final Provider<DateTimeFormatterResourceProvider> b;
    public final Provider<Locale> c;

    public DateTimeFormatterModule_ProvideLowerCaseDateTimeFormatterFactory(Provider<TimeSource> provider, Provider<DateTimeFormatterResourceProvider> provider2, Provider<Locale> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static DateTimeFormatterModule_ProvideLowerCaseDateTimeFormatterFactory create(Provider<TimeSource> provider, Provider<DateTimeFormatterResourceProvider> provider2, Provider<Locale> provider3) {
        return new DateTimeFormatterModule_ProvideLowerCaseDateTimeFormatterFactory(provider, provider2, provider3);
    }

    public static DateTimeFormatter provideLowerCaseDateTimeFormatter(TimeSource timeSource, DateTimeFormatterResourceProvider dateTimeFormatterResourceProvider, Locale locale) {
        return (DateTimeFormatter) Preconditions.checkNotNullFromProvides(DateTimeFormatterModule.provideLowerCaseDateTimeFormatter(timeSource, dateTimeFormatterResourceProvider, locale));
    }

    @Override // javax.inject.Provider
    public DateTimeFormatter get() {
        return provideLowerCaseDateTimeFormatter(this.a.get(), this.b.get(), this.c.get());
    }
}
