package com.avito.android.delivery.summary.konveyor;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryRdsSummaryKonveyorResourceProviderImpl_Factory implements Factory<DeliveryRdsSummaryKonveyorResourceProviderImpl> {
    public final Provider<Resources> a;

    public DeliveryRdsSummaryKonveyorResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static DeliveryRdsSummaryKonveyorResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new DeliveryRdsSummaryKonveyorResourceProviderImpl_Factory(provider);
    }

    public static DeliveryRdsSummaryKonveyorResourceProviderImpl newInstance(Resources resources) {
        return new DeliveryRdsSummaryKonveyorResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public DeliveryRdsSummaryKonveyorResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
