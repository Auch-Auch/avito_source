package com.avito.android.messenger.channels.mvi.data;

import com.avito.android.messenger.conversation.mvi.data.MessageEntityConverter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ChannelEntityConverterImpl_Factory implements Factory<ChannelEntityConverterImpl> {
    public final Provider<MessageEntityConverter> a;
    public final Provider<UserEntityConverter> b;
    public final Provider<ChannelContextSerializer> c;
    public final Provider<ChannelPropertySerializer> d;

    public ChannelEntityConverterImpl_Factory(Provider<MessageEntityConverter> provider, Provider<UserEntityConverter> provider2, Provider<ChannelContextSerializer> provider3, Provider<ChannelPropertySerializer> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static ChannelEntityConverterImpl_Factory create(Provider<MessageEntityConverter> provider, Provider<UserEntityConverter> provider2, Provider<ChannelContextSerializer> provider3, Provider<ChannelPropertySerializer> provider4) {
        return new ChannelEntityConverterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static ChannelEntityConverterImpl newInstance(MessageEntityConverter messageEntityConverter, UserEntityConverter userEntityConverter, ChannelContextSerializer channelContextSerializer, ChannelPropertySerializer channelPropertySerializer) {
        return new ChannelEntityConverterImpl(messageEntityConverter, userEntityConverter, channelContextSerializer, channelPropertySerializer);
    }

    @Override // javax.inject.Provider
    public ChannelEntityConverterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
