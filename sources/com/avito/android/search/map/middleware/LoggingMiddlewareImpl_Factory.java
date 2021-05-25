package com.avito.android.search.map.middleware;

import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.search.map.interactor.SearchMapAnalyticsInteractor;
import com.avito.android.search.map.metric.SearchMapTracker;
import com.avito.android.serp.CommercialBannersAnalyticsInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LoggingMiddlewareImpl_Factory implements Factory<LoggingMiddlewareImpl> {
    public final Provider<SearchMapTracker> a;
    public final Provider<SearchMapAnalyticsInteractor> b;
    public final Provider<LocationAnalyticsInteractor> c;
    public final Provider<CommercialBannersAnalyticsInteractor> d;

    public LoggingMiddlewareImpl_Factory(Provider<SearchMapTracker> provider, Provider<SearchMapAnalyticsInteractor> provider2, Provider<LocationAnalyticsInteractor> provider3, Provider<CommercialBannersAnalyticsInteractor> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static LoggingMiddlewareImpl_Factory create(Provider<SearchMapTracker> provider, Provider<SearchMapAnalyticsInteractor> provider2, Provider<LocationAnalyticsInteractor> provider3, Provider<CommercialBannersAnalyticsInteractor> provider4) {
        return new LoggingMiddlewareImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static LoggingMiddlewareImpl newInstance(SearchMapTracker searchMapTracker, SearchMapAnalyticsInteractor searchMapAnalyticsInteractor, LocationAnalyticsInteractor locationAnalyticsInteractor, CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor) {
        return new LoggingMiddlewareImpl(searchMapTracker, searchMapAnalyticsInteractor, locationAnalyticsInteractor, commercialBannersAnalyticsInteractor);
    }

    @Override // javax.inject.Provider
    public LoggingMiddlewareImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
