package com.avito.android.di.module;

import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.date_time_formatter.DateTimeFormatterResourceProvider;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
public final class DateTimeFormatterModule_ProvideUpperCaseDateTimeFormatterFactory implements Factory<DateTimeFormatter> {
    public final Provider<TimeSource> a;
    public final Provider<DateTimeFormatterResourceProvider> b;
    public final Provider<Locale> c;

    public DateTimeFormatterModule_ProvideUpperCaseDateTimeFormatterFactory(Provider<TimeSource> provider, Provider<DateTimeFormatterResourceProvider> provider2, Provider<Locale> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static DateTimeFormatterModule_ProvideUpperCaseDateTimeFormatterFactory create(Provider<TimeSource> provider, Provider<DateTimeFormatterResourceProvider> provider2, Provider<Locale> provider3) {
        return new DateTimeFormatterModule_ProvideUpperCaseDateTimeFormatterFactory(provider, provider2, provider3);
    }

    public static DateTimeFormatter provideUpperCaseDateTimeFormatter(TimeSource timeSource, DateTimeFormatterResourceProvider dateTimeFormatterResourceProvider, Locale locale) {
        return (DateTimeFormatter) Preconditions.checkNotNullFromProvides(DateTimeFormatterModule.provideUpperCaseDateTimeFormatter(timeSource, dateTimeFormatterResourceProvider, locale));
    }

    @Override // javax.inject.Provider
    public DateTimeFormatter get() {
        return provideUpperCaseDateTimeFormatter(this.a.get(), this.b.get(), this.c.get());
    }
}
