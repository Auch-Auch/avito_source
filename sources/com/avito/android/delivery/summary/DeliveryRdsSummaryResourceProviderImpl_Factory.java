package com.avito.android.delivery.summary;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryRdsSummaryResourceProviderImpl_Factory implements Factory<DeliveryRdsSummaryResourceProviderImpl> {
    public final Provider<Resources> a;

    public DeliveryRdsSummaryResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static DeliveryRdsSummaryResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new DeliveryRdsSummaryResourceProviderImpl_Factory(provider);
    }

    public static DeliveryRdsSummaryResourceProviderImpl newInstance(Resources resources) {
        return new DeliveryRdsSummaryResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public DeliveryRdsSummaryResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
