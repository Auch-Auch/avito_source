package com.avito.android.home.analytics;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class HomeAnalyticsInteractorImpl_Factory implements Factory<HomeAnalyticsInteractorImpl> {
    public final Provider<Analytics> a;
    public final Provider<TreeStateIdGenerator> b;
    public final Provider<Features> c;

    public HomeAnalyticsInteractorImpl_Factory(Provider<Analytics> provider, Provider<TreeStateIdGenerator> provider2, Provider<Features> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static HomeAnalyticsInteractorImpl_Factory create(Provider<Analytics> provider, Provider<TreeStateIdGenerator> provider2, Provider<Features> provider3) {
        return new HomeAnalyticsInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static HomeAnalyticsInteractorImpl newInstance(Analytics analytics, TreeStateIdGenerator treeStateIdGenerator, Features features) {
        return new HomeAnalyticsInteractorImpl(analytics, treeStateIdGenerator, features);
    }

    @Override // javax.inject.Provider
    public HomeAnalyticsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
