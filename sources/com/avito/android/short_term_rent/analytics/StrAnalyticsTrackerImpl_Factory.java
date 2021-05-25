package com.avito.android.short_term_rent.analytics;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class StrAnalyticsTrackerImpl_Factory implements Factory<StrAnalyticsTrackerImpl> {
    public final Provider<String> a;
    public final Provider<Analytics> b;

    public StrAnalyticsTrackerImpl_Factory(Provider<String> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static StrAnalyticsTrackerImpl_Factory create(Provider<String> provider, Provider<Analytics> provider2) {
        return new StrAnalyticsTrackerImpl_Factory(provider, provider2);
    }

    public static StrAnalyticsTrackerImpl newInstance(String str, Analytics analytics) {
        return new StrAnalyticsTrackerImpl(str, analytics);
    }

    @Override // javax.inject.Provider
    public StrAnalyticsTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
