package com.avito.android.safedeal.delivery_type.items;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryTypeResourceProviderImpl_Factory implements Factory<DeliveryTypeResourceProviderImpl> {
    public final Provider<Resources> a;

    public DeliveryTypeResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static DeliveryTypeResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new DeliveryTypeResourceProviderImpl_Factory(provider);
    }

    public static DeliveryTypeResourceProviderImpl newInstance(Resources resources) {
        return new DeliveryTypeResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public DeliveryTypeResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
