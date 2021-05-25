package com.avito.android.safedeal.delivery_courier.order_update;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryCourierOrderUpdateAnalyticsTrackerImpl_Factory implements Factory<DeliveryCourierOrderUpdateAnalyticsTrackerImpl> {
    public final Provider<Analytics> a;

    public DeliveryCourierOrderUpdateAnalyticsTrackerImpl_Factory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static DeliveryCourierOrderUpdateAnalyticsTrackerImpl_Factory create(Provider<Analytics> provider) {
        return new DeliveryCourierOrderUpdateAnalyticsTrackerImpl_Factory(provider);
    }

    public static DeliveryCourierOrderUpdateAnalyticsTrackerImpl newInstance(Analytics analytics) {
        return new DeliveryCourierOrderUpdateAnalyticsTrackerImpl(analytics);
    }

    @Override // javax.inject.Provider
    public DeliveryCourierOrderUpdateAnalyticsTrackerImpl get() {
        return newInstance(this.a.get());
    }
}
