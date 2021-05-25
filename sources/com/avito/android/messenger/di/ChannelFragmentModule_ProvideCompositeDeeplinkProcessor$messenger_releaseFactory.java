package com.avito.android.messenger.di;

import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideCompositeDeeplinkProcessor$messenger_releaseFactory implements Factory<DeeplinkProcessor> {
    public final ChannelFragmentModule a;
    public final Provider<ChannelFragment> b;
    public final Provider<ChannelFragment.Params> c;
    public final Provider<ViewModelFactory> d;

    public ChannelFragmentModule_ProvideCompositeDeeplinkProcessor$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment> provider, Provider<ChannelFragment.Params> provider2, Provider<ViewModelFactory> provider3) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static ChannelFragmentModule_ProvideCompositeDeeplinkProcessor$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment> provider, Provider<ChannelFragment.Params> provider2, Provider<ViewModelFactory> provider3) {
        return new ChannelFragmentModule_ProvideCompositeDeeplinkProcessor$messenger_releaseFactory(channelFragmentModule, provider, provider2, provider3);
    }

    public static DeeplinkProcessor provideCompositeDeeplinkProcessor$messenger_release(ChannelFragmentModule channelFragmentModule, ChannelFragment channelFragment, ChannelFragment.Params params, ViewModelFactory viewModelFactory) {
        return (DeeplinkProcessor) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideCompositeDeeplinkProcessor$messenger_release(channelFragment, params, viewModelFactory));
    }

    @Override // javax.inject.Provider
    public DeeplinkProcessor get() {
        return provideCompositeDeeplinkProcessor$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
