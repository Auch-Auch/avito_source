package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.app_call.AppCallMessageClickListener;
import com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideAppCallMessageClickListenerFactory implements Factory<AppCallMessageClickListener> {
    public final ChannelFragmentModule a;
    public final Provider<MessageListPresenter> b;

    public ChannelFragmentModule_ProvideAppCallMessageClickListenerFactory(ChannelFragmentModule channelFragmentModule, Provider<MessageListPresenter> provider) {
        this.a = channelFragmentModule;
        this.b = provider;
    }

    public static ChannelFragmentModule_ProvideAppCallMessageClickListenerFactory create(ChannelFragmentModule channelFragmentModule, Provider<MessageListPresenter> provider) {
        return new ChannelFragmentModule_ProvideAppCallMessageClickListenerFactory(channelFragmentModule, provider);
    }

    public static AppCallMessageClickListener provideAppCallMessageClickListener(ChannelFragmentModule channelFragmentModule, MessageListPresenter messageListPresenter) {
        return (AppCallMessageClickListener) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideAppCallMessageClickListener(messageListPresenter));
    }

    @Override // javax.inject.Provider
    public AppCallMessageClickListener get() {
        return provideAppCallMessageClickListener(this.a, this.b.get());
    }
}
