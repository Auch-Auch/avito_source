package com.avito.android.safedeal.delivery_courier.order_update;

import com.avito.android.Features;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.validation.LocalPretendInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryCourierOrderUpdateInteractorImpl_Factory implements Factory<DeliveryCourierOrderUpdateInteractorImpl> {
    public final Provider<DeliveryApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<TypedErrorThrowableConverter> c;
    public final Provider<LocalPretendInteractor> d;
    public final Provider<Features> e;

    public DeliveryCourierOrderUpdateInteractorImpl_Factory(Provider<DeliveryApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<LocalPretendInteractor> provider4, Provider<Features> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static DeliveryCourierOrderUpdateInteractorImpl_Factory create(Provider<DeliveryApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<LocalPretendInteractor> provider4, Provider<Features> provider5) {
        return new DeliveryCourierOrderUpdateInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static DeliveryCourierOrderUpdateInteractorImpl newInstance(DeliveryApi deliveryApi, SchedulersFactory schedulersFactory, TypedErrorThrowableConverter typedErrorThrowableConverter, LocalPretendInteractor localPretendInteractor, Features features) {
        return new DeliveryCourierOrderUpdateInteractorImpl(deliveryApi, schedulersFactory, typedErrorThrowableConverter, localPretendInteractor, features);
    }

    @Override // javax.inject.Provider
    public DeliveryCourierOrderUpdateInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
