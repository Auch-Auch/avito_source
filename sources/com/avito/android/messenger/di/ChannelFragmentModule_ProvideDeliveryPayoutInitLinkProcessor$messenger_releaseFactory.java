package com.avito.android.messenger.di;

import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeepLinkProcessingListener;
import com.avito.android.messenger.conversation.mvi.deeplinks.payout.DeliveryPayoutInteractor;
import com.avito.android.messenger.conversation.mvi.deeplinks.payout.PayoutInitLinkProcessor;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideDeliveryPayoutInitLinkProcessor$messenger_releaseFactory implements Factory<PayoutInitLinkProcessor> {
    public final ChannelFragmentModule a;
    public final Provider<DeliveryPayoutInteractor> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<TypedErrorThrowableConverter> d;
    public final Provider<ActivityIntentFactory> e;
    public final Provider<DeepLinkProcessingListener> f;
    public final Provider<Resources> g;

    public ChannelFragmentModule_ProvideDeliveryPayoutInitLinkProcessor$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<DeliveryPayoutInteractor> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<ActivityIntentFactory> provider4, Provider<DeepLinkProcessingListener> provider5, Provider<Resources> provider6) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
    }

    public static ChannelFragmentModule_ProvideDeliveryPayoutInitLinkProcessor$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<DeliveryPayoutInteractor> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<ActivityIntentFactory> provider4, Provider<DeepLinkProcessingListener> provider5, Provider<Resources> provider6) {
        return new ChannelFragmentModule_ProvideDeliveryPayoutInitLinkProcessor$messenger_releaseFactory(channelFragmentModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static PayoutInitLinkProcessor provideDeliveryPayoutInitLinkProcessor$messenger_release(ChannelFragmentModule channelFragmentModule, DeliveryPayoutInteractor deliveryPayoutInteractor, SchedulersFactory schedulersFactory, TypedErrorThrowableConverter typedErrorThrowableConverter, ActivityIntentFactory activityIntentFactory, Lazy<DeepLinkProcessingListener> lazy, Resources resources) {
        return (PayoutInitLinkProcessor) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideDeliveryPayoutInitLinkProcessor$messenger_release(deliveryPayoutInteractor, schedulersFactory, typedErrorThrowableConverter, activityIntentFactory, lazy, resources));
    }

    @Override // javax.inject.Provider
    public PayoutInitLinkProcessor get() {
        return provideDeliveryPayoutInitLinkProcessor$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), DoubleCheck.lazy(this.f), this.g.get());
    }
}
