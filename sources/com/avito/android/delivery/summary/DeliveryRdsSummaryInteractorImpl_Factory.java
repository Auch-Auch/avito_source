package com.avito.android.delivery.summary;

import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryRdsSummaryInteractorImpl_Factory implements Factory<DeliveryRdsSummaryInteractorImpl> {
    public final Provider<DeliveryApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<TypedErrorThrowableConverter> c;
    public final Provider<String> d;

    public DeliveryRdsSummaryInteractorImpl_Factory(Provider<DeliveryApi> provider, Provider<SchedulersFactory3> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<String> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static DeliveryRdsSummaryInteractorImpl_Factory create(Provider<DeliveryApi> provider, Provider<SchedulersFactory3> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<String> provider4) {
        return new DeliveryRdsSummaryInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static DeliveryRdsSummaryInteractorImpl newInstance(DeliveryApi deliveryApi, SchedulersFactory3 schedulersFactory3, TypedErrorThrowableConverter typedErrorThrowableConverter, String str) {
        return new DeliveryRdsSummaryInteractorImpl(deliveryApi, schedulersFactory3, typedErrorThrowableConverter, str);
    }

    @Override // javax.inject.Provider
    public DeliveryRdsSummaryInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
