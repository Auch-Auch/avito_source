package com.avito.android.messenger.di;

import android.content.res.Resources;
import com.avito.android.date_time_formatter.RelativeDateFormatter;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
public final class RelativeDateFormatterModule_ProvideRelativeDateFormatterFactory implements Factory<RelativeDateFormatter> {
    public final Provider<TimeSource> a;
    public final Provider<Locale> b;
    public final Provider<Resources> c;

    public RelativeDateFormatterModule_ProvideRelativeDateFormatterFactory(Provider<TimeSource> provider, Provider<Locale> provider2, Provider<Resources> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static RelativeDateFormatterModule_ProvideRelativeDateFormatterFactory create(Provider<TimeSource> provider, Provider<Locale> provider2, Provider<Resources> provider3) {
        return new RelativeDateFormatterModule_ProvideRelativeDateFormatterFactory(provider, provider2, provider3);
    }

    public static RelativeDateFormatter provideRelativeDateFormatter(TimeSource timeSource, Locale locale, Resources resources) {
        return (RelativeDateFormatter) Preconditions.checkNotNullFromProvides(RelativeDateFormatterModule.provideRelativeDateFormatter(timeSource, locale, resources));
    }

    @Override // javax.inject.Provider
    public RelativeDateFormatter get() {
        return provideRelativeDateFormatter(this.a.get(), this.b.get(), this.c.get());
    }
}
