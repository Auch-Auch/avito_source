package com.avito.android.safedeal.delivery_courier.summary.konveyor;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryCourierSummaryKonveyorResourceProviderImpl_Factory implements Factory<DeliveryCourierSummaryKonveyorResourceProviderImpl> {
    public final Provider<Resources> a;

    public DeliveryCourierSummaryKonveyorResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static DeliveryCourierSummaryKonveyorResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new DeliveryCourierSummaryKonveyorResourceProviderImpl_Factory(provider);
    }

    public static DeliveryCourierSummaryKonveyorResourceProviderImpl newInstance(Resources resources) {
        return new DeliveryCourierSummaryKonveyorResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public DeliveryCourierSummaryKonveyorResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
