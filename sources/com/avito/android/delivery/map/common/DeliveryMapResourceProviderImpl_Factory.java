package com.avito.android.delivery.map.common;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryMapResourceProviderImpl_Factory implements Factory<DeliveryMapResourceProviderImpl> {
    public final Provider<Resources> a;

    public DeliveryMapResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static DeliveryMapResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new DeliveryMapResourceProviderImpl_Factory(provider);
    }

    public static DeliveryMapResourceProviderImpl newInstance(Resources resources) {
        return new DeliveryMapResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public DeliveryMapResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
