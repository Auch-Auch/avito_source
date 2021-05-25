package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.formatter.MessageTimeFormatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideMessageTimeFormatter$messenger_releaseFactory implements Factory<MessageTimeFormatter> {
    public final ChannelFragmentModule a;
    public final Provider<Locale> b;

    public ChannelFragmentModule_ProvideMessageTimeFormatter$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<Locale> provider) {
        this.a = channelFragmentModule;
        this.b = provider;
    }

    public static ChannelFragmentModule_ProvideMessageTimeFormatter$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<Locale> provider) {
        return new ChannelFragmentModule_ProvideMessageTimeFormatter$messenger_releaseFactory(channelFragmentModule, provider);
    }

    public static MessageTimeFormatter provideMessageTimeFormatter$messenger_release(ChannelFragmentModule channelFragmentModule, Locale locale) {
        return (MessageTimeFormatter) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideMessageTimeFormatter$messenger_release(locale));
    }

    @Override // javax.inject.Provider
    public MessageTimeFormatter get() {
        return provideMessageTimeFormatter$messenger_release(this.a, this.b.get());
    }
}
