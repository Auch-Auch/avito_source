package com.avito.android.messenger.di;

import android.content.res.Resources;
import com.avito.android.messenger.conversation.mvi.deeplinks.AbstractDeeplinkProcessorListener;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeepLinkProcessingListener;
import com.avito.android.messenger.conversation.mvi.deeplinks.cancel_order.DeliveryOrderCancelLinkProcessor;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideDeliveryOrderCancelLinkProcessorListener$messenger_releaseFactory implements Factory<AbstractDeeplinkProcessorListener<DeliveryOrderCancelLinkProcessor>> {
    public final ChannelFragmentModule a;
    public final Provider<DeliveryApi> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<TypedErrorThrowableConverter> d;
    public final Provider<DeepLinkProcessingListener> e;
    public final Provider<Resources> f;

    public ChannelFragmentModule_ProvideDeliveryOrderCancelLinkProcessorListener$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<DeliveryApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<DeepLinkProcessingListener> provider4, Provider<Resources> provider5) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
    }

    public static ChannelFragmentModule_ProvideDeliveryOrderCancelLinkProcessorListener$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<DeliveryApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<DeepLinkProcessingListener> provider4, Provider<Resources> provider5) {
        return new ChannelFragmentModule_ProvideDeliveryOrderCancelLinkProcessorListener$messenger_releaseFactory(channelFragmentModule, provider, provider2, provider3, provider4, provider5);
    }

    public static AbstractDeeplinkProcessorListener<DeliveryOrderCancelLinkProcessor> provideDeliveryOrderCancelLinkProcessorListener$messenger_release(ChannelFragmentModule channelFragmentModule, DeliveryApi deliveryApi, SchedulersFactory schedulersFactory, TypedErrorThrowableConverter typedErrorThrowableConverter, Lazy<DeepLinkProcessingListener> lazy, Resources resources) {
        return (AbstractDeeplinkProcessorListener) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideDeliveryOrderCancelLinkProcessorListener$messenger_release(deliveryApi, schedulersFactory, typedErrorThrowableConverter, lazy, resources));
    }

    @Override // javax.inject.Provider
    public AbstractDeeplinkProcessorListener<DeliveryOrderCancelLinkProcessor> get() {
        return provideDeliveryOrderCancelLinkProcessorListener$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get(), DoubleCheck.lazy(this.e), this.f.get());
    }
}
