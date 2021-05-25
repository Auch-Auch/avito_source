package com.avito.android.messenger.di;

import android.content.res.Resources;
import com.avito.android.messenger.conversation.formatter.MessageDateFormatter;
import com.avito.android.server_time.TimeSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideMessageDateFormatter$messenger_releaseFactory implements Factory<MessageDateFormatter> {
    public final ChannelFragmentModule a;
    public final Provider<TimeSource> b;
    public final Provider<Locale> c;
    public final Provider<Resources> d;

    public ChannelFragmentModule_ProvideMessageDateFormatter$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<TimeSource> provider, Provider<Locale> provider2, Provider<Resources> provider3) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static ChannelFragmentModule_ProvideMessageDateFormatter$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<TimeSource> provider, Provider<Locale> provider2, Provider<Resources> provider3) {
        return new ChannelFragmentModule_ProvideMessageDateFormatter$messenger_releaseFactory(channelFragmentModule, provider, provider2, provider3);
    }

    public static MessageDateFormatter provideMessageDateFormatter$messenger_release(ChannelFragmentModule channelFragmentModule, TimeSource timeSource, Locale locale, Resources resources) {
        return (MessageDateFormatter) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideMessageDateFormatter$messenger_release(timeSource, locale, resources));
    }

    @Override // javax.inject.Provider
    public MessageDateFormatter get() {
        return provideMessageDateFormatter$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
