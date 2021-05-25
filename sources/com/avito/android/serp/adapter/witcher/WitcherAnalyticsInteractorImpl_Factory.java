package com.avito.android.serp.adapter.witcher;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class WitcherAnalyticsInteractorImpl_Factory implements Factory<WitcherAnalyticsInteractorImpl> {
    public final Provider<Analytics> a;

    public WitcherAnalyticsInteractorImpl_Factory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static WitcherAnalyticsInteractorImpl_Factory create(Provider<Analytics> provider) {
        return new WitcherAnalyticsInteractorImpl_Factory(provider);
    }

    public static WitcherAnalyticsInteractorImpl newInstance(Analytics analytics) {
        return new WitcherAnalyticsInteractorImpl(analytics);
    }

    @Override // javax.inject.Provider
    public WitcherAnalyticsInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
