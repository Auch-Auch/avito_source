package com.avito.android.delivery.order_cancellation;

import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RdsOrderCancellationInteractorImpl_Factory implements Factory<RdsOrderCancellationInteractorImpl> {
    public final Provider<DeliveryApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<TypedErrorThrowableConverter> c;

    public RdsOrderCancellationInteractorImpl_Factory(Provider<DeliveryApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static RdsOrderCancellationInteractorImpl_Factory create(Provider<DeliveryApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        return new RdsOrderCancellationInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static RdsOrderCancellationInteractorImpl newInstance(DeliveryApi deliveryApi, SchedulersFactory schedulersFactory, TypedErrorThrowableConverter typedErrorThrowableConverter) {
        return new RdsOrderCancellationInteractorImpl(deliveryApi, schedulersFactory, typedErrorThrowableConverter);
    }

    @Override // javax.inject.Provider
    public RdsOrderCancellationInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
