package com.avito.android.messenger.conversation.mvi.platform_actions;

import com.avito.android.Features;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateProducer;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
public final class PlatformActionsCoordinatorImpl_Factory implements Factory<PlatformActionsCoordinatorImpl> {
    public final Provider<ChannelContextInteractor> a;
    public final Provider<MessageListInteractor> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<Features> d;
    public final Provider<Set<PlatformActionsStateProducer.Factory<?>>> e;

    public PlatformActionsCoordinatorImpl_Factory(Provider<ChannelContextInteractor> provider, Provider<MessageListInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<Features> provider4, Provider<Set<PlatformActionsStateProducer.Factory<?>>> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static PlatformActionsCoordinatorImpl_Factory create(Provider<ChannelContextInteractor> provider, Provider<MessageListInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<Features> provider4, Provider<Set<PlatformActionsStateProducer.Factory<?>>> provider5) {
        return new PlatformActionsCoordinatorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static PlatformActionsCoordinatorImpl newInstance(ChannelContextInteractor channelContextInteractor, MessageListInteractor messageListInteractor, SchedulersFactory schedulersFactory, Features features, Set<PlatformActionsStateProducer.Factory<?>> set) {
        return new PlatformActionsCoordinatorImpl(channelContextInteractor, messageListInteractor, schedulersFactory, features, set);
    }

    @Override // javax.inject.Provider
    public PlatformActionsCoordinatorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
