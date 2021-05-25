package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.spam_actions.SpamActionsPresenter;
import com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideMessageSpamActionsListenerFactory implements Factory<SpamActionsPresenter.Listener> {
    public final ChannelFragmentModule a;
    public final Provider<MessageListPresenter> b;

    public ChannelFragmentModule_ProvideMessageSpamActionsListenerFactory(ChannelFragmentModule channelFragmentModule, Provider<MessageListPresenter> provider) {
        this.a = channelFragmentModule;
        this.b = provider;
    }

    public static ChannelFragmentModule_ProvideMessageSpamActionsListenerFactory create(ChannelFragmentModule channelFragmentModule, Provider<MessageListPresenter> provider) {
        return new ChannelFragmentModule_ProvideMessageSpamActionsListenerFactory(channelFragmentModule, provider);
    }

    public static SpamActionsPresenter.Listener provideMessageSpamActionsListener(ChannelFragmentModule channelFragmentModule, MessageListPresenter messageListPresenter) {
        return (SpamActionsPresenter.Listener) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideMessageSpamActionsListener(messageListPresenter));
    }

    @Override // javax.inject.Provider
    public SpamActionsPresenter.Listener get() {
        return provideMessageSpamActionsListener(this.a, this.b.get());
    }
}
