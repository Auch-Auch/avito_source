package com.avito.android.safedeal.delivery_type;

import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.safedeal.remote.SafeDealApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryTypeInteractorImpl_Factory implements Factory<DeliveryTypeInteractorImpl> {
    public final Provider<DeliveryTypeData> a;
    public final Provider<SafeDealApi> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<TypedErrorThrowableConverter> d;

    public DeliveryTypeInteractorImpl_Factory(Provider<DeliveryTypeData> provider, Provider<SafeDealApi> provider2, Provider<SchedulersFactory3> provider3, Provider<TypedErrorThrowableConverter> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static DeliveryTypeInteractorImpl_Factory create(Provider<DeliveryTypeData> provider, Provider<SafeDealApi> provider2, Provider<SchedulersFactory3> provider3, Provider<TypedErrorThrowableConverter> provider4) {
        return new DeliveryTypeInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static DeliveryTypeInteractorImpl newInstance(DeliveryTypeData deliveryTypeData, SafeDealApi safeDealApi, SchedulersFactory3 schedulersFactory3, TypedErrorThrowableConverter typedErrorThrowableConverter) {
        return new DeliveryTypeInteractorImpl(deliveryTypeData, safeDealApi, schedulersFactory3, typedErrorThrowableConverter);
    }

    @Override // javax.inject.Provider
    public DeliveryTypeInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
