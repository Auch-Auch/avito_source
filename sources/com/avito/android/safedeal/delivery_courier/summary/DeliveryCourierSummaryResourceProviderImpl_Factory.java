package com.avito.android.safedeal.delivery_courier.summary;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryCourierSummaryResourceProviderImpl_Factory implements Factory<DeliveryCourierSummaryResourceProviderImpl> {
    public final Provider<Resources> a;

    public DeliveryCourierSummaryResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static DeliveryCourierSummaryResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new DeliveryCourierSummaryResourceProviderImpl_Factory(provider);
    }

    public static DeliveryCourierSummaryResourceProviderImpl newInstance(Resources resources) {
        return new DeliveryCourierSummaryResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public DeliveryCourierSummaryResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
