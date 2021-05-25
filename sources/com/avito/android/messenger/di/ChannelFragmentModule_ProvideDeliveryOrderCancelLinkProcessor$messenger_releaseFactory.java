package com.avito.android.messenger.di;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.messenger.conversation.mvi.deeplinks.cancel_order.DeliveryOrderCancelLinkProcessor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideDeliveryOrderCancelLinkProcessor$messenger_releaseFactory implements Factory<DeliveryOrderCancelLinkProcessor> {
    public final ChannelFragmentModule a;
    public final Provider<ActivityIntentFactory> b;

    public ChannelFragmentModule_ProvideDeliveryOrderCancelLinkProcessor$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<ActivityIntentFactory> provider) {
        this.a = channelFragmentModule;
        this.b = provider;
    }

    public static ChannelFragmentModule_ProvideDeliveryOrderCancelLinkProcessor$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<ActivityIntentFactory> provider) {
        return new ChannelFragmentModule_ProvideDeliveryOrderCancelLinkProcessor$messenger_releaseFactory(channelFragmentModule, provider);
    }

    public static DeliveryOrderCancelLinkProcessor provideDeliveryOrderCancelLinkProcessor$messenger_release(ChannelFragmentModule channelFragmentModule, ActivityIntentFactory activityIntentFactory) {
        return (DeliveryOrderCancelLinkProcessor) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideDeliveryOrderCancelLinkProcessor$messenger_release(activityIntentFactory));
    }

    @Override // javax.inject.Provider
    public DeliveryOrderCancelLinkProcessor get() {
        return provideDeliveryOrderCancelLinkProcessor$messenger_release(this.a, this.b.get());
    }
}
