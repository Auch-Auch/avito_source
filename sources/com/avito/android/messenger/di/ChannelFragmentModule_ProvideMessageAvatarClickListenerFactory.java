package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.MessageAvatarClickListener;
import com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideMessageAvatarClickListenerFactory implements Factory<MessageAvatarClickListener> {
    public final ChannelFragmentModule a;
    public final Provider<MessageListPresenter> b;

    public ChannelFragmentModule_ProvideMessageAvatarClickListenerFactory(ChannelFragmentModule channelFragmentModule, Provider<MessageListPresenter> provider) {
        this.a = channelFragmentModule;
        this.b = provider;
    }

    public static ChannelFragmentModule_ProvideMessageAvatarClickListenerFactory create(ChannelFragmentModule channelFragmentModule, Provider<MessageListPresenter> provider) {
        return new ChannelFragmentModule_ProvideMessageAvatarClickListenerFactory(channelFragmentModule, provider);
    }

    public static MessageAvatarClickListener provideMessageAvatarClickListener(ChannelFragmentModule channelFragmentModule, MessageListPresenter messageListPresenter) {
        return (MessageAvatarClickListener) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideMessageAvatarClickListener(messageListPresenter));
    }

    @Override // javax.inject.Provider
    public MessageAvatarClickListener get() {
        return provideMessageAvatarClickListener(this.a, this.b.get());
    }
}
