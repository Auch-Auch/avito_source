package com.avito.android.safedeal.delivery_courier.order_update;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryCourierOrderUpdateResourceProviderImpl_Factory implements Factory<DeliveryCourierOrderUpdateResourceProviderImpl> {
    public final Provider<Resources> a;

    public DeliveryCourierOrderUpdateResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static DeliveryCourierOrderUpdateResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new DeliveryCourierOrderUpdateResourceProviderImpl_Factory(provider);
    }

    public static DeliveryCourierOrderUpdateResourceProviderImpl newInstance(Resources resources) {
        return new DeliveryCourierOrderUpdateResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public DeliveryCourierOrderUpdateResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
