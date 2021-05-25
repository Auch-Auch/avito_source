package com.avito.android.safedeal.delivery_courier.summary;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryItemsConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryCourierSummaryViewModelFactory_Factory implements Factory<DeliveryCourierSummaryViewModelFactory> {
    public final Provider<Analytics> a;
    public final Provider<DeliveryCourierSummaryInteractor> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<String> d;
    public final Provider<String> e;
    public final Provider<DeliveryCourierSummaryItemsConverter> f;
    public final Provider<DeliveryCourierSummaryResourceProvider> g;
    public final Provider<AccountStateProvider> h;
    public final Provider<BaseScreenPerformanceTracker> i;

    public DeliveryCourierSummaryViewModelFactory_Factory(Provider<Analytics> provider, Provider<DeliveryCourierSummaryInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<String> provider4, Provider<String> provider5, Provider<DeliveryCourierSummaryItemsConverter> provider6, Provider<DeliveryCourierSummaryResourceProvider> provider7, Provider<AccountStateProvider> provider8, Provider<BaseScreenPerformanceTracker> provider9) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
    }

    public static DeliveryCourierSummaryViewModelFactory_Factory create(Provider<Analytics> provider, Provider<DeliveryCourierSummaryInteractor> provider2, Provider<SchedulersFactory> provider3, Provider<String> provider4, Provider<String> provider5, Provider<DeliveryCourierSummaryItemsConverter> provider6, Provider<DeliveryCourierSummaryResourceProvider> provider7, Provider<AccountStateProvider> provider8, Provider<BaseScreenPerformanceTracker> provider9) {
        return new DeliveryCourierSummaryViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static DeliveryCourierSummaryViewModelFactory newInstance(Analytics analytics, DeliveryCourierSummaryInteractor deliveryCourierSummaryInteractor, SchedulersFactory schedulersFactory, String str, String str2, DeliveryCourierSummaryItemsConverter deliveryCourierSummaryItemsConverter, DeliveryCourierSummaryResourceProvider deliveryCourierSummaryResourceProvider, AccountStateProvider accountStateProvider, BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        return new DeliveryCourierSummaryViewModelFactory(analytics, deliveryCourierSummaryInteractor, schedulersFactory, str, str2, deliveryCourierSummaryItemsConverter, deliveryCourierSummaryResourceProvider, accountStateProvider, baseScreenPerformanceTracker);
    }

    @Override // javax.inject.Provider
    public DeliveryCourierSummaryViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get());
    }
}
