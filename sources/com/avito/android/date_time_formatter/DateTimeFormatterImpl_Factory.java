package com.avito.android.date_time_formatter;

import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import java.util.Locale;
import javax.inject.Provider;
public final class DateTimeFormatterImpl_Factory implements Factory<DateTimeFormatterImpl> {
    public final Provider<TimeSource> a;
    public final Provider<DateTimeFormatterResourceProvider> b;
    public final Provider<Locale> c;
    public final Provider<Integer> d;

    public DateTimeFormatterImpl_Factory(Provider<TimeSource> provider, Provider<DateTimeFormatterResourceProvider> provider2, Provider<Locale> provider3, Provider<Integer> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static DateTimeFormatterImpl_Factory create(Provider<TimeSource> provider, Provider<DateTimeFormatterResourceProvider> provider2, Provider<Locale> provider3, Provider<Integer> provider4) {
        return new DateTimeFormatterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static DateTimeFormatterImpl newInstance(TimeSource timeSource, DateTimeFormatterResourceProvider dateTimeFormatterResourceProvider, Locale locale, int i) {
        return new DateTimeFormatterImpl(timeSource, dateTimeFormatterResourceProvider, locale, i);
    }

    @Override // javax.inject.Provider
    public DateTimeFormatterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get().intValue());
    }
}
