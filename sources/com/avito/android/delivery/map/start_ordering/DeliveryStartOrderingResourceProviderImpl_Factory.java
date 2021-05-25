package com.avito.android.delivery.map.start_ordering;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryStartOrderingResourceProviderImpl_Factory implements Factory<DeliveryStartOrderingResourceProviderImpl> {
    public final Provider<Resources> a;

    public DeliveryStartOrderingResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static DeliveryStartOrderingResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new DeliveryStartOrderingResourceProviderImpl_Factory(provider);
    }

    public static DeliveryStartOrderingResourceProviderImpl newInstance(Resources resources) {
        return new DeliveryStartOrderingResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public DeliveryStartOrderingResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
