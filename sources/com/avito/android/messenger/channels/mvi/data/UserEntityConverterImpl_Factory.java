package com.avito.android.messenger.channels.mvi.data;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class UserEntityConverterImpl_Factory implements Factory<UserEntityConverterImpl> {
    public final Provider<ChannelPropertySerializer> a;

    public UserEntityConverterImpl_Factory(Provider<ChannelPropertySerializer> provider) {
        this.a = provider;
    }

    public static UserEntityConverterImpl_Factory create(Provider<ChannelPropertySerializer> provider) {
        return new UserEntityConverterImpl_Factory(provider);
    }

    public static UserEntityConverterImpl newInstance(ChannelPropertySerializer channelPropertySerializer) {
        return new UserEntityConverterImpl(channelPropertySerializer);
    }

    @Override // javax.inject.Provider
    public UserEntityConverterImpl get() {
        return newInstance(this.a.get());
    }
}
