package com.avito.android.messenger.di;

import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideSendMessagePresenter$messenger_releaseFactory implements Factory<SendMessagePresenter> {
    public final ChannelFragmentModule a;
    public final Provider<ChannelFragment> b;
    public final Provider<ChannelFragment.Params> c;
    public final Provider<ViewModelFactory> d;

    public ChannelFragmentModule_ProvideSendMessagePresenter$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment> provider, Provider<ChannelFragment.Params> provider2, Provider<ViewModelFactory> provider3) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static ChannelFragmentModule_ProvideSendMessagePresenter$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment> provider, Provider<ChannelFragment.Params> provider2, Provider<ViewModelFactory> provider3) {
        return new ChannelFragmentModule_ProvideSendMessagePresenter$messenger_releaseFactory(channelFragmentModule, provider, provider2, provider3);
    }

    public static SendMessagePresenter provideSendMessagePresenter$messenger_release(ChannelFragmentModule channelFragmentModule, ChannelFragment channelFragment, ChannelFragment.Params params, ViewModelFactory viewModelFactory) {
        return (SendMessagePresenter) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideSendMessagePresenter$messenger_release(channelFragment, params, viewModelFactory));
    }

    @Override // javax.inject.Provider
    public SendMessagePresenter get() {
        return provideSendMessagePresenter$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
