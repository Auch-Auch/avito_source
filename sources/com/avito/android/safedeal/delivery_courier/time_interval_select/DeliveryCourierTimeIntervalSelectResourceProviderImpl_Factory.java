package com.avito.android.safedeal.delivery_courier.time_interval_select;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryCourierTimeIntervalSelectResourceProviderImpl_Factory implements Factory<DeliveryCourierTimeIntervalSelectResourceProviderImpl> {
    public final Provider<Resources> a;

    public DeliveryCourierTimeIntervalSelectResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static DeliveryCourierTimeIntervalSelectResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new DeliveryCourierTimeIntervalSelectResourceProviderImpl_Factory(provider);
    }

    public static DeliveryCourierTimeIntervalSelectResourceProviderImpl newInstance(Resources resources) {
        return new DeliveryCourierTimeIntervalSelectResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public DeliveryCourierTimeIntervalSelectResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
