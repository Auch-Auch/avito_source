package com.avito.android.messenger.di;

import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.conversation.ChannelFragment;
import com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewLinkProcessorListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideRequestReviewLinkProcessorListenerFactory implements Factory<RequestReviewLinkProcessorListener> {
    public final ChannelFragmentModule a;
    public final Provider<ChannelFragment> b;
    public final Provider<ChannelFragment.Params> c;
    public final Provider<ViewModelFactory> d;

    public ChannelFragmentModule_ProvideRequestReviewLinkProcessorListenerFactory(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment> provider, Provider<ChannelFragment.Params> provider2, Provider<ViewModelFactory> provider3) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static ChannelFragmentModule_ProvideRequestReviewLinkProcessorListenerFactory create(ChannelFragmentModule channelFragmentModule, Provider<ChannelFragment> provider, Provider<ChannelFragment.Params> provider2, Provider<ViewModelFactory> provider3) {
        return new ChannelFragmentModule_ProvideRequestReviewLinkProcessorListenerFactory(channelFragmentModule, provider, provider2, provider3);
    }

    public static RequestReviewLinkProcessorListener provideRequestReviewLinkProcessorListener(ChannelFragmentModule channelFragmentModule, ChannelFragment channelFragment, ChannelFragment.Params params, ViewModelFactory viewModelFactory) {
        return (RequestReviewLinkProcessorListener) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideRequestReviewLinkProcessorListener(channelFragment, params, viewModelFactory));
    }

    @Override // javax.inject.Provider
    public RequestReviewLinkProcessorListener get() {
        return provideRequestReviewLinkProcessorListener(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
