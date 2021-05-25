package com.avito.android.delivery.map.point_info;

import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryRdsPointInfoInteractorImpl_Factory implements Factory<DeliveryRdsPointInfoInteractorImpl> {
    public final Provider<DeliveryApi> a;
    public final Provider<TypedErrorThrowableConverter> b;
    public final Provider<SchedulersFactory3> c;

    public DeliveryRdsPointInfoInteractorImpl_Factory(Provider<DeliveryApi> provider, Provider<TypedErrorThrowableConverter> provider2, Provider<SchedulersFactory3> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static DeliveryRdsPointInfoInteractorImpl_Factory create(Provider<DeliveryApi> provider, Provider<TypedErrorThrowableConverter> provider2, Provider<SchedulersFactory3> provider3) {
        return new DeliveryRdsPointInfoInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static DeliveryRdsPointInfoInteractorImpl newInstance(DeliveryApi deliveryApi, TypedErrorThrowableConverter typedErrorThrowableConverter, SchedulersFactory3 schedulersFactory3) {
        return new DeliveryRdsPointInfoInteractorImpl(deliveryApi, typedErrorThrowableConverter, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public DeliveryRdsPointInfoInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
