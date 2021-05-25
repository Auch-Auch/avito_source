package com.avito.android.advert_core.delivery;

import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.AdvertDeliveryC2C;
import com.avito.android.util.SchedulersFactory3;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDeliveryBlockRepositoryImpl_Factory implements Factory<AdvertDeliveryBlockRepositoryImpl> {
    public final Provider<String> a;
    public final Provider<DeliveryApi> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<TypedErrorThrowableConverter> d;
    public final Provider<PublishRelay<AdvertDeliveryC2C>> e;

    public AdvertDeliveryBlockRepositoryImpl_Factory(Provider<String> provider, Provider<DeliveryApi> provider2, Provider<SchedulersFactory3> provider3, Provider<TypedErrorThrowableConverter> provider4, Provider<PublishRelay<AdvertDeliveryC2C>> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AdvertDeliveryBlockRepositoryImpl_Factory create(Provider<String> provider, Provider<DeliveryApi> provider2, Provider<SchedulersFactory3> provider3, Provider<TypedErrorThrowableConverter> provider4, Provider<PublishRelay<AdvertDeliveryC2C>> provider5) {
        return new AdvertDeliveryBlockRepositoryImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AdvertDeliveryBlockRepositoryImpl newInstance(String str, DeliveryApi deliveryApi, SchedulersFactory3 schedulersFactory3, TypedErrorThrowableConverter typedErrorThrowableConverter, PublishRelay<AdvertDeliveryC2C> publishRelay) {
        return new AdvertDeliveryBlockRepositoryImpl(str, deliveryApi, schedulersFactory3, typedErrorThrowableConverter, publishRelay);
    }

    @Override // javax.inject.Provider
    public AdvertDeliveryBlockRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
