package com.avito.android.safedeal.delivery_courier.time_interval_select;

import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryCourierTimeIntervalSelectInteractorImpl_Factory implements Factory<DeliveryCourierTimeIntervalSelectInteractorImpl> {
    public final Provider<DeliveryApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<TypedErrorThrowableConverter> c;

    public DeliveryCourierTimeIntervalSelectInteractorImpl_Factory(Provider<DeliveryApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static DeliveryCourierTimeIntervalSelectInteractorImpl_Factory create(Provider<DeliveryApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        return new DeliveryCourierTimeIntervalSelectInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static DeliveryCourierTimeIntervalSelectInteractorImpl newInstance(DeliveryApi deliveryApi, SchedulersFactory schedulersFactory, TypedErrorThrowableConverter typedErrorThrowableConverter) {
        return new DeliveryCourierTimeIntervalSelectInteractorImpl(deliveryApi, schedulersFactory, typedErrorThrowableConverter);
    }

    @Override // javax.inject.Provider
    public DeliveryCourierTimeIntervalSelectInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
