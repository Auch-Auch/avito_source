package com.avito.android.search.map.interactor;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.search.map.provider.SearchHashProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SearchMapAnalyticsInteractorImpl_Factory implements Factory<SearchMapAnalyticsInteractorImpl> {
    public final Provider<Analytics> a;
    public final Provider<TreeStateIdGenerator> b;
    public final Provider<Features> c;
    public final Provider<SearchHashProvider> d;
    public final Provider<TreeClickStreamParent> e;

    public SearchMapAnalyticsInteractorImpl_Factory(Provider<Analytics> provider, Provider<TreeStateIdGenerator> provider2, Provider<Features> provider3, Provider<SearchHashProvider> provider4, Provider<TreeClickStreamParent> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static SearchMapAnalyticsInteractorImpl_Factory create(Provider<Analytics> provider, Provider<TreeStateIdGenerator> provider2, Provider<Features> provider3, Provider<SearchHashProvider> provider4, Provider<TreeClickStreamParent> provider5) {
        return new SearchMapAnalyticsInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SearchMapAnalyticsInteractorImpl newInstance(Analytics analytics, TreeStateIdGenerator treeStateIdGenerator, Features features, SearchHashProvider searchHashProvider, TreeClickStreamParent treeClickStreamParent) {
        return new SearchMapAnalyticsInteractorImpl(analytics, treeStateIdGenerator, features, searchHashProvider, treeClickStreamParent);
    }

    @Override // javax.inject.Provider
    public SearchMapAnalyticsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
