package com.avito.android.delivery.map.point_info;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryRdsPointInfoResourceProviderImpl_Factory implements Factory<DeliveryRdsPointInfoResourceProviderImpl> {
    public final Provider<Resources> a;

    public DeliveryRdsPointInfoResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static DeliveryRdsPointInfoResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new DeliveryRdsPointInfoResourceProviderImpl_Factory(provider);
    }

    public static DeliveryRdsPointInfoResourceProviderImpl newInstance(Resources resources) {
        return new DeliveryRdsPointInfoResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public DeliveryRdsPointInfoResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
