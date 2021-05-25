package com.avito.android.messenger.di;

import android.content.res.Resources;
import com.avito.android.messenger.conversation.formatter.MessageDateFormatter;
import com.avito.android.messenger.conversation.formatter.MessageTimeFormatter;
import com.avito.android.messenger.conversation.mvi.messages.MessageListItemConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideMessageListItemConverter$messenger_releaseFactory implements Factory<MessageListItemConverter> {
    public final ChannelFragmentModule a;
    public final Provider<MessageDateFormatter> b;
    public final Provider<MessageTimeFormatter> c;
    public final Provider<Resources> d;

    public ChannelFragmentModule_ProvideMessageListItemConverter$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<MessageDateFormatter> provider, Provider<MessageTimeFormatter> provider2, Provider<Resources> provider3) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static ChannelFragmentModule_ProvideMessageListItemConverter$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<MessageDateFormatter> provider, Provider<MessageTimeFormatter> provider2, Provider<Resources> provider3) {
        return new ChannelFragmentModule_ProvideMessageListItemConverter$messenger_releaseFactory(channelFragmentModule, provider, provider2, provider3);
    }

    public static MessageListItemConverter provideMessageListItemConverter$messenger_release(ChannelFragmentModule channelFragmentModule, MessageDateFormatter messageDateFormatter, MessageTimeFormatter messageTimeFormatter, Resources resources) {
        return (MessageListItemConverter) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideMessageListItemConverter$messenger_release(messageDateFormatter, messageTimeFormatter, resources));
    }

    @Override // javax.inject.Provider
    public MessageListItemConverter get() {
        return provideMessageListItemConverter$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
