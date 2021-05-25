package com.avito.android.messenger.channels.mvi.interactor;

import com.avito.android.messenger.channels.mvi.interactor.ChannelsLastMessageProvider;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.util.SchedulersFactory;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ChannelsLastMessageProviderImpl_Factory implements Factory<ChannelsLastMessageProviderImpl> {
    public final Provider<ChannelsLastMessageProvider.State> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<MessageRepo> c;

    public ChannelsLastMessageProviderImpl_Factory(Provider<ChannelsLastMessageProvider.State> provider, Provider<SchedulersFactory> provider2, Provider<MessageRepo> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static ChannelsLastMessageProviderImpl_Factory create(Provider<ChannelsLastMessageProvider.State> provider, Provider<SchedulersFactory> provider2, Provider<MessageRepo> provider3) {
        return new ChannelsLastMessageProviderImpl_Factory(provider, provider2, provider3);
    }

    public static ChannelsLastMessageProviderImpl newInstance(ChannelsLastMessageProvider.State state, SchedulersFactory schedulersFactory, Lazy<MessageRepo> lazy) {
        return new ChannelsLastMessageProviderImpl(state, schedulersFactory, lazy);
    }

    @Override // javax.inject.Provider
    public ChannelsLastMessageProviderImpl get() {
        return newInstance(this.a.get(), this.b.get(), DoubleCheck.lazy(this.c));
    }
}
