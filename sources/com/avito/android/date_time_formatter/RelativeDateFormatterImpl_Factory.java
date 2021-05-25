package com.avito.android.date_time_formatter;

import android.content.res.Resources;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import java.util.Locale;
import javax.inject.Provider;
public final class RelativeDateFormatterImpl_Factory implements Factory<RelativeDateFormatterImpl> {
    public final Provider<TimeSource> a;
    public final Provider<Resources> b;
    public final Provider<Locale> c;

    public RelativeDateFormatterImpl_Factory(Provider<TimeSource> provider, Provider<Resources> provider2, Provider<Locale> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static RelativeDateFormatterImpl_Factory create(Provider<TimeSource> provider, Provider<Resources> provider2, Provider<Locale> provider3) {
        return new RelativeDateFormatterImpl_Factory(provider, provider2, provider3);
    }

    public static RelativeDateFormatterImpl newInstance(TimeSource timeSource, Resources resources, Locale locale) {
        return new RelativeDateFormatterImpl(timeSource, resources, locale);
    }

    @Override // javax.inject.Provider
    public RelativeDateFormatterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
