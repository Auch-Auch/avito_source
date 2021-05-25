package com.avito.android.safedeal.delivery_courier.time_interval_select;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryCourierTimeIntervalSelectAnalyticsTrackerImpl_Factory implements Factory<DeliveryCourierTimeIntervalSelectAnalyticsTrackerImpl> {
    public final Provider<Analytics> a;

    public DeliveryCourierTimeIntervalSelectAnalyticsTrackerImpl_Factory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static DeliveryCourierTimeIntervalSelectAnalyticsTrackerImpl_Factory create(Provider<Analytics> provider) {
        return new DeliveryCourierTimeIntervalSelectAnalyticsTrackerImpl_Factory(provider);
    }

    public static DeliveryCourierTimeIntervalSelectAnalyticsTrackerImpl newInstance(Analytics analytics) {
        return new DeliveryCourierTimeIntervalSelectAnalyticsTrackerImpl(analytics);
    }

    @Override // javax.inject.Provider
    public DeliveryCourierTimeIntervalSelectAnalyticsTrackerImpl get() {
        return newInstance(this.a.get());
    }
}
