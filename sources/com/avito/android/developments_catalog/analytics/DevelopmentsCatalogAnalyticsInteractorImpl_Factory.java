package com.avito.android.developments_catalog.analytics;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DevelopmentsCatalogAnalyticsInteractorImpl_Factory implements Factory<DevelopmentsCatalogAnalyticsInteractorImpl> {
    public final Provider<Analytics> a;

    public DevelopmentsCatalogAnalyticsInteractorImpl_Factory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static DevelopmentsCatalogAnalyticsInteractorImpl_Factory create(Provider<Analytics> provider) {
        return new DevelopmentsCatalogAnalyticsInteractorImpl_Factory(provider);
    }

    public static DevelopmentsCatalogAnalyticsInteractorImpl newInstance(Analytics analytics) {
        return new DevelopmentsCatalogAnalyticsInteractorImpl(analytics);
    }

    @Override // javax.inject.Provider
    public DevelopmentsCatalogAnalyticsInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
