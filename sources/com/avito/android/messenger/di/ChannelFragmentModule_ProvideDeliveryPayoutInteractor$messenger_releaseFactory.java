package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.mvi.deeplinks.payout.DeliveryPayoutInteractor;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideDeliveryPayoutInteractor$messenger_releaseFactory implements Factory<DeliveryPayoutInteractor> {
    public final ChannelFragmentModule a;
    public final Provider<DeliveryApi> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<TypedErrorThrowableConverter> d;

    public ChannelFragmentModule_ProvideDeliveryPayoutInteractor$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<DeliveryApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static ChannelFragmentModule_ProvideDeliveryPayoutInteractor$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<DeliveryApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        return new ChannelFragmentModule_ProvideDeliveryPayoutInteractor$messenger_releaseFactory(channelFragmentModule, provider, provider2, provider3);
    }

    public static DeliveryPayoutInteractor provideDeliveryPayoutInteractor$messenger_release(ChannelFragmentModule channelFragmentModule, DeliveryApi deliveryApi, SchedulersFactory schedulersFactory, TypedErrorThrowableConverter typedErrorThrowableConverter) {
        return (DeliveryPayoutInteractor) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideDeliveryPayoutInteractor$messenger_release(deliveryApi, schedulersFactory, typedErrorThrowableConverter));
    }

    @Override // javax.inject.Provider
    public DeliveryPayoutInteractor get() {
        return provideDeliveryPayoutInteractor$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
