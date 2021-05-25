package com.avito.android.suggest_locations.analytics;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SuggestLocationsAnalyticsInteractorImpl_Factory implements Factory<SuggestLocationsAnalyticsInteractorImpl> {
    public final Provider<Analytics> a;

    public SuggestLocationsAnalyticsInteractorImpl_Factory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static SuggestLocationsAnalyticsInteractorImpl_Factory create(Provider<Analytics> provider) {
        return new SuggestLocationsAnalyticsInteractorImpl_Factory(provider);
    }

    public static SuggestLocationsAnalyticsInteractorImpl newInstance(Analytics analytics) {
        return new SuggestLocationsAnalyticsInteractorImpl(analytics);
    }

    @Override // javax.inject.Provider
    public SuggestLocationsAnalyticsInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
