package com.avito.android.publish.start_publish;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.drafts.analytics.PublishSessionIdGenerator;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class StartPublishViewModelFactory_Factory implements Factory<StartPublishViewModelFactory> {
    public final Provider<AccountStateProvider> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<StartPublishInteractor> c;
    public final Provider<PublishAnalyticsDataProvider> d;
    public final Provider<PublishSessionIdGenerator> e;
    public final Provider<StartPublishResourceProvider> f;
    public final Provider<Analytics> g;
    public final Provider<PublishEventTracker> h;

    public StartPublishViewModelFactory_Factory(Provider<AccountStateProvider> provider, Provider<SchedulersFactory3> provider2, Provider<StartPublishInteractor> provider3, Provider<PublishAnalyticsDataProvider> provider4, Provider<PublishSessionIdGenerator> provider5, Provider<StartPublishResourceProvider> provider6, Provider<Analytics> provider7, Provider<PublishEventTracker> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static StartPublishViewModelFactory_Factory create(Provider<AccountStateProvider> provider, Provider<SchedulersFactory3> provider2, Provider<StartPublishInteractor> provider3, Provider<PublishAnalyticsDataProvider> provider4, Provider<PublishSessionIdGenerator> provider5, Provider<StartPublishResourceProvider> provider6, Provider<Analytics> provider7, Provider<PublishEventTracker> provider8) {
        return new StartPublishViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static StartPublishViewModelFactory newInstance(AccountStateProvider accountStateProvider, SchedulersFactory3 schedulersFactory3, StartPublishInteractor startPublishInteractor, PublishAnalyticsDataProvider publishAnalyticsDataProvider, PublishSessionIdGenerator publishSessionIdGenerator, StartPublishResourceProvider startPublishResourceProvider, Analytics analytics, PublishEventTracker publishEventTracker) {
        return new StartPublishViewModelFactory(accountStateProvider, schedulersFactory3, startPublishInteractor, publishAnalyticsDataProvider, publishSessionIdGenerator, startPublishResourceProvider, analytics, publishEventTracker);
    }

    @Override // javax.inject.Provider
    public StartPublishViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
