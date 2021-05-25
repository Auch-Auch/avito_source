package com.avito.android.messenger.conversation.mvi;

import com.avito.android.messenger.blacklist_reasons.BlockUserInteractor;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MessageSpamActionsInteractorImpl_Factory implements Factory<MessageSpamActionsInteractorImpl> {
    public final Provider<BlockUserInteractor> a;
    public final Provider<ChannelContextInteractor> b;
    public final Provider<SchedulersFactory> c;

    public MessageSpamActionsInteractorImpl_Factory(Provider<BlockUserInteractor> provider, Provider<ChannelContextInteractor> provider2, Provider<SchedulersFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MessageSpamActionsInteractorImpl_Factory create(Provider<BlockUserInteractor> provider, Provider<ChannelContextInteractor> provider2, Provider<SchedulersFactory> provider3) {
        return new MessageSpamActionsInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static MessageSpamActionsInteractorImpl newInstance(BlockUserInteractor blockUserInteractor, ChannelContextInteractor channelContextInteractor, SchedulersFactory schedulersFactory) {
        return new MessageSpamActionsInteractorImpl(blockUserInteractor, channelContextInteractor, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public MessageSpamActionsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
