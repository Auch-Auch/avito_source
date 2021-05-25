package com.avito.android.delivery.order_cancellation;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class OrderCancellationResourceProviderImpl_Factory implements Factory<OrderCancellationResourceProviderImpl> {
    public final Provider<Resources> a;

    public OrderCancellationResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static OrderCancellationResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new OrderCancellationResourceProviderImpl_Factory(provider);
    }

    public static OrderCancellationResourceProviderImpl newInstance(Resources resources) {
        return new OrderCancellationResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public OrderCancellationResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
