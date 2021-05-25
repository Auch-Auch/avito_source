package com.avito.android.search.filter.analytics;

import com.avito.android.FilterAnalyticsData;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.remote.model.SearchParams;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class FilterAnalyticsInteractorImpl_Factory implements Factory<FilterAnalyticsInteractorImpl> {
    public final Provider<Analytics> a;
    public final Provider<SearchParams> b;
    public final Provider<TreeStateIdGenerator> c;
    public final Provider<FilterAnalyticsData> d;

    public FilterAnalyticsInteractorImpl_Factory(Provider<Analytics> provider, Provider<SearchParams> provider2, Provider<TreeStateIdGenerator> provider3, Provider<FilterAnalyticsData> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static FilterAnalyticsInteractorImpl_Factory create(Provider<Analytics> provider, Provider<SearchParams> provider2, Provider<TreeStateIdGenerator> provider3, Provider<FilterAnalyticsData> provider4) {
        return new FilterAnalyticsInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static FilterAnalyticsInteractorImpl newInstance(Analytics analytics, SearchParams searchParams, TreeStateIdGenerator treeStateIdGenerator, FilterAnalyticsData filterAnalyticsData) {
        return new FilterAnalyticsInteractorImpl(analytics, searchParams, treeStateIdGenerator, filterAnalyticsData);
    }

    @Override // javax.inject.Provider
    public FilterAnalyticsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
