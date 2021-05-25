package com.avito.android.messenger.di;

import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.platform_actions.sample.SamplePlatformActionsStateProducer;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideSamplePlatformActionsStateProducerFactory implements Factory<SamplePlatformActionsStateProducer> {
    public final ChannelFragmentModule a;
    public final Provider<ChannelFragment> b;
    public final Provider<ChannelFragment.Params> c;
    public final Provider<ViewModelFactory> d;

    public ChannelFragmentModule_ProvideSamplePlatformActionsStateProducerFactory(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment> provider, Provider<ChannelFragment.Params> provider2, Provider<ViewModelFactory> provider3) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static ChannelFragmentModule_ProvideSamplePlatformActionsStateProducerFactory create(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment> provider, Provider<ChannelFragment.Params> provider2, Provider<ViewModelFactory> provider3) {
        return new ChannelFragmentModule_ProvideSamplePlatformActionsStateProducerFactory(channelFragmentModule, provider, provider2, provider3);
    }

    public static SamplePlatformActionsStateProducer provideSamplePlatformActionsStateProducer(ChannelFragmentModule channelFragmentModule, ChannelFragment channelFragment, ChannelFragment.Params params, ViewModelFactory viewModelFactory) {
        return (SamplePlatformActionsStateProducer) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideSamplePlatformActionsStateProducer(channelFragment, params, viewModelFactory));
    }

    @Override // javax.inject.Provider
    public SamplePlatformActionsStateProducer get() {
        return provideSamplePlatformActionsStateProducer(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
