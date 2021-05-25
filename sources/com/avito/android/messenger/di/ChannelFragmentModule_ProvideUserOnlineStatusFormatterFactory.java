package com.avito.android.messenger.di;

import android.content.res.Resources;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Formatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
import ru.avito.messenger.api.entity.UserLastActivity;
public final class ChannelFragmentModule_ProvideUserOnlineStatusFormatterFactory implements Factory<Formatter<UserLastActivity>> {
    public final ChannelFragmentModule a;
    public final Provider<Resources> b;
    public final Provider<TimeSource> c;
    public final Provider<Locale> d;

    public ChannelFragmentModule_ProvideUserOnlineStatusFormatterFactory(ChannelFragmentModule channelFragmentModule, Provider<Resources> provider, Provider<TimeSource> provider2, Provider<Locale> provider3) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static ChannelFragmentModule_ProvideUserOnlineStatusFormatterFactory create(ChannelFragmentModule channelFragmentModule, Provider<Resources> provider, Provider<TimeSource> provider2, Provider<Locale> provider3) {
        return new ChannelFragmentModule_ProvideUserOnlineStatusFormatterFactory(channelFragmentModule, provider, provider2, provider3);
    }

    public static Formatter<UserLastActivity> provideUserOnlineStatusFormatter(ChannelFragmentModule channelFragmentModule, Resources resources, TimeSource timeSource, Locale locale) {
        return (Formatter) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideUserOnlineStatusFormatter(resources, timeSource, locale));
    }

    @Override // javax.inject.Provider
    public Formatter<UserLastActivity> get() {
        return provideUserOnlineStatusFormatter(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
