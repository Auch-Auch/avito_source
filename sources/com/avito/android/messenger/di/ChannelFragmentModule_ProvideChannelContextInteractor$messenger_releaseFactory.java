package com.avito.android.messenger.di;

import com.avito.android.Features;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideChannelContextInteractor$messenger_releaseFactory implements Factory<ChannelContextInteractor> {
    public final ChannelFragmentModule a;
    public final Provider<ChannelFragment> b;
    public final Provider<ChannelFragment.Params> c;
    public final Provider<ViewModelFactory> d;
    public final Provider<Features> e;

    public ChannelFragmentModule_ProvideChannelContextInteractor$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment> provider, Provider<ChannelFragment.Params> provider2, Provider<ViewModelFactory> provider3, Provider<Features> provider4) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static ChannelFragmentModule_ProvideChannelContextInteractor$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment> provider, Provider<ChannelFragment.Params> provider2, Provider<ViewModelFactory> provider3, Provider<Features> provider4) {
        return new ChannelFragmentModule_ProvideChannelContextInteractor$messenger_releaseFactory(channelFragmentModule, provider, provider2, provider3, provider4);
    }

    public static ChannelContextInteractor provideChannelContextInteractor$messenger_release(ChannelFragmentModule channelFragmentModule, ChannelFragment channelFragment, ChannelFragment.Params params, ViewModelFactory viewModelFactory, Features features) {
        return (ChannelContextInteractor) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideChannelContextInteractor$messenger_release(channelFragment, params, viewModelFactory, features));
    }

    @Override // javax.inject.Provider
    public ChannelContextInteractor get() {
        return provideChannelContextInteractor$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
