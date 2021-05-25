package com.avito.android.messenger.conversation.mvi.deeplinks.delete_channel;

import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuInteractor;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeleteChannelDeeplinkProcessorImpl_Factory implements Factory<DeleteChannelDeeplinkProcessorImpl> {
    public final Provider<ChannelMenuInteractor> a;

    public DeleteChannelDeeplinkProcessorImpl_Factory(Provider<ChannelMenuInteractor> provider) {
        this.a = provider;
    }

    public static DeleteChannelDeeplinkProcessorImpl_Factory create(Provider<ChannelMenuInteractor> provider) {
        return new DeleteChannelDeeplinkProcessorImpl_Factory(provider);
    }

    public static DeleteChannelDeeplinkProcessorImpl newInstance(Lazy<ChannelMenuInteractor> lazy) {
        return new DeleteChannelDeeplinkProcessorImpl(lazy);
    }

    @Override // javax.inject.Provider
    public DeleteChannelDeeplinkProcessorImpl get() {
        return newInstance(DoubleCheck.lazy(this.a));
    }
}
