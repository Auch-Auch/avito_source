package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.mvi.deeplinks.payout.DeliveryCourierPayoutInteractor;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideDeliveryCourierPayoutInteractor$messenger_releaseFactory implements Factory<DeliveryCourierPayoutInteractor> {
    public final ChannelFragmentModule a;
    public final Provider<DeliveryApi> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<TypedErrorThrowableConverter> d;

    public ChannelFragmentModule_ProvideDeliveryCourierPayoutInteractor$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<DeliveryApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static ChannelFragmentModule_ProvideDeliveryCourierPayoutInteractor$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<DeliveryApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        return new ChannelFragmentModule_ProvideDeliveryCourierPayoutInteractor$messenger_releaseFactory(channelFragmentModule, provider, provider2, provider3);
    }

    public static DeliveryCourierPayoutInteractor provideDeliveryCourierPayoutInteractor$messenger_release(ChannelFragmentModule channelFragmentModule, DeliveryApi deliveryApi, SchedulersFactory schedulersFactory, TypedErrorThrowableConverter typedErrorThrowableConverter) {
        return (DeliveryCourierPayoutInteractor) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideDeliveryCourierPayoutInteractor$messenger_release(deliveryApi, schedulersFactory, typedErrorThrowableConverter));
    }

    @Override // javax.inject.Provider
    public DeliveryCourierPayoutInteractor get() {
        return provideDeliveryCourierPayoutInteractor$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
