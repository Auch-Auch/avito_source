package com.avito.android.messenger.conversation.mvi.platform_actions.legacy;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractor;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LegacyPlatformActionsPresenterImpl_Factory implements Factory<LegacyPlatformActionsPresenterImpl> {
    public final Provider<ChannelContextInteractor> a;
    public final Provider<MessageListInteractor> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<Analytics> d;
    public final Provider<Features> e;

    public LegacyPlatformActionsPresenterImpl_Factory(Provider<ChannelContextInteractor> provider, Provider<MessageListInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<Analytics> provider4, Provider<Features> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static LegacyPlatformActionsPresenterImpl_Factory create(Provider<ChannelContextInteractor> provider, Provider<MessageListInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<Analytics> provider4, Provider<Features> provider5) {
        return new LegacyPlatformActionsPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static LegacyPlatformActionsPresenterImpl newInstance(ChannelContextInteractor channelContextInteractor, MessageListInteractor messageListInteractor, SchedulersFactory schedulersFactory, Analytics analytics, Features features) {
        return new LegacyPlatformActionsPresenterImpl(channelContextInteractor, messageListInteractor, schedulersFactory, analytics, features);
    }

    @Override // javax.inject.Provider
    public LegacyPlatformActionsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
