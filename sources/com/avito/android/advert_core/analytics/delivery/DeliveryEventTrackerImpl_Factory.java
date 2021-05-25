package com.avito.android.advert_core.analytics.delivery;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryEventTrackerImpl_Factory implements Factory<DeliveryEventTrackerImpl> {
    public final Provider<Analytics> a;

    public DeliveryEventTrackerImpl_Factory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static DeliveryEventTrackerImpl_Factory create(Provider<Analytics> provider) {
        return new DeliveryEventTrackerImpl_Factory(provider);
    }

    public static DeliveryEventTrackerImpl newInstance(Analytics analytics) {
        return new DeliveryEventTrackerImpl(analytics);
    }

    @Override // javax.inject.Provider
    public DeliveryEventTrackerImpl get() {
        return newInstance(this.a.get());
    }
}
