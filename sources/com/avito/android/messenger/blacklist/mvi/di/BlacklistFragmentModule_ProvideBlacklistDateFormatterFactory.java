package com.avito.android.messenger.blacklist.mvi.di;

import android.content.res.Resources;
import com.avito.android.date_time_formatter.BlacklistDateFormatter;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
public final class BlacklistFragmentModule_ProvideBlacklistDateFormatterFactory implements Factory<BlacklistDateFormatter> {
    public final Provider<TimeSource> a;
    public final Provider<Resources> b;
    public final Provider<Locale> c;

    public BlacklistFragmentModule_ProvideBlacklistDateFormatterFactory(Provider<TimeSource> provider, Provider<Resources> provider2, Provider<Locale> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static BlacklistFragmentModule_ProvideBlacklistDateFormatterFactory create(Provider<TimeSource> provider, Provider<Resources> provider2, Provider<Locale> provider3) {
        return new BlacklistFragmentModule_ProvideBlacklistDateFormatterFactory(provider, provider2, provider3);
    }

    public static BlacklistDateFormatter provideBlacklistDateFormatter(TimeSource timeSource, Resources resources, Locale locale) {
        return (BlacklistDateFormatter) Preconditions.checkNotNullFromProvides(BlacklistFragmentModule.INSTANCE.provideBlacklistDateFormatter(timeSource, resources, locale));
    }

    @Override // javax.inject.Provider
    public BlacklistDateFormatter get() {
        return provideBlacklistDateFormatter(this.a.get(), this.b.get(), this.c.get());
    }
}
