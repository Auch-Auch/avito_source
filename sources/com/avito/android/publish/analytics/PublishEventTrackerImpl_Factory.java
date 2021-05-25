package com.avito.android.publish.analytics;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.CurrentUserIdProvider;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PublishEventTrackerImpl_Factory implements Factory<PublishEventTrackerImpl> {
    public final Provider<Analytics> a;
    public final Provider<PublishAnalyticsDataProvider> b;
    public final Provider<CurrentUserIdProvider> c;
    public final Provider<Gson> d;

    public PublishEventTrackerImpl_Factory(Provider<Analytics> provider, Provider<PublishAnalyticsDataProvider> provider2, Provider<CurrentUserIdProvider> provider3, Provider<Gson> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static PublishEventTrackerImpl_Factory create(Provider<Analytics> provider, Provider<PublishAnalyticsDataProvider> provider2, Provider<CurrentUserIdProvider> provider3, Provider<Gson> provider4) {
        return new PublishEventTrackerImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static PublishEventTrackerImpl newInstance(Analytics analytics, PublishAnalyticsDataProvider publishAnalyticsDataProvider, CurrentUserIdProvider currentUserIdProvider, Gson gson) {
        return new PublishEventTrackerImpl(analytics, publishAnalyticsDataProvider, currentUserIdProvider, gson);
    }

    @Override // javax.inject.Provider
    public PublishEventTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
