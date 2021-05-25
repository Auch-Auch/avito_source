package com.avito.android.messenger.di;

import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.messenger.conversation.mvi.deeplinks.AbstractDeeplinkProcessorListener;
import com.avito.android.messenger.conversation.mvi.deeplinks.payout.PayoutInitLinkProcessor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideStrPayoutInitLinkProcessorListener$messenger_releaseFactory implements Factory<AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor>> {
    public final ChannelFragmentModule a;
    public final Provider<DeepLinkIntentFactory> b;

    public ChannelFragmentModule_ProvideStrPayoutInitLinkProcessorListener$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<DeepLinkIntentFactory> provider) {
        this.a = channelFragmentModule;
        this.b = provider;
    }

    public static ChannelFragmentModule_ProvideStrPayoutInitLinkProcessorListener$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<DeepLinkIntentFactory> provider) {
        return new ChannelFragmentModule_ProvideStrPayoutInitLinkProcessorListener$messenger_releaseFactory(channelFragmentModule, provider);
    }

    public static AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor> provideStrPayoutInitLinkProcessorListener$messenger_release(ChannelFragmentModule channelFragmentModule, DeepLinkIntentFactory deepLinkIntentFactory) {
        return (AbstractDeeplinkProcessorListener) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideStrPayoutInitLinkProcessorListener$messenger_release(deepLinkIntentFactory));
    }

    @Override // javax.inject.Provider
    public AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor> get() {
        return provideStrPayoutInitLinkProcessorListener$messenger_release(this.a, this.b.get());
    }
}
