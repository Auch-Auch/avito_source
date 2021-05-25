package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.MessageClickListener;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter;
import com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideMessageClickListenerFactory implements Factory<MessageClickListener> {
    public final ChannelFragmentModule a;
    public final Provider<MessageListPresenter> b;
    public final Provider<MessageMenuPresenter> c;

    public ChannelFragmentModule_ProvideMessageClickListenerFactory(ChannelFragmentModule channelFragmentModule, Provider<MessageListPresenter> provider, Provider<MessageMenuPresenter> provider2) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ChannelFragmentModule_ProvideMessageClickListenerFactory create(ChannelFragmentModule channelFragmentModule, Provider<MessageListPresenter> provider, Provider<MessageMenuPresenter> provider2) {
        return new ChannelFragmentModule_ProvideMessageClickListenerFactory(channelFragmentModule, provider, provider2);
    }

    public static MessageClickListener provideMessageClickListener(ChannelFragmentModule channelFragmentModule, MessageListPresenter messageListPresenter, MessageMenuPresenter messageMenuPresenter) {
        return (MessageClickListener) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideMessageClickListener(messageListPresenter, messageMenuPresenter));
    }

    @Override // javax.inject.Provider
    public MessageClickListener get() {
        return provideMessageClickListener(this.a, this.b.get(), this.c.get());
    }
}
