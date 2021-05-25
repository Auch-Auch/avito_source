package com.avito.android.messenger.di;

import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvidePlatformActionsCoordinatorFactory implements Factory<PlatformActionsCoordinator> {
    public final ChannelFragmentModule a;
    public final Provider<ChannelFragment> b;
    public final Provider<ChannelFragment.Params> c;
    public final Provider<ViewModelFactory> d;

    public ChannelFragmentModule_ProvidePlatformActionsCoordinatorFactory(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment> provider, Provider<ChannelFragment.Params> provider2, Provider<ViewModelFactory> provider3) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static ChannelFragmentModule_ProvidePlatformActionsCoordinatorFactory create(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment> provider, Provider<ChannelFragment.Params> provider2, Provider<ViewModelFactory> provider3) {
        return new ChannelFragmentModule_ProvidePlatformActionsCoordinatorFactory(channelFragmentModule, provider, provider2, provider3);
    }

    public static PlatformActionsCoordinator providePlatformActionsCoordinator(ChannelFragmentModule channelFragmentModule, ChannelFragment channelFragment, ChannelFragment.Params params, ViewModelFactory viewModelFactory) {
        return (PlatformActionsCoordinator) Preconditions.checkNotNullFromProvides(channelFragmentModule.providePlatformActionsCoordinator(channelFragment, params, viewModelFactory));
    }

    @Override // javax.inject.Provider
    public PlatformActionsCoordinator get() {
        return providePlatformActionsCoordinator(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
