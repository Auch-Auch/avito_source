package com.avito.android.delivery.map.start_ordering;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.remote.model.ParametrizedEvent;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DeliveryRdsStartOrderingViewModelFactory_Factory implements Factory<DeliveryRdsStartOrderingViewModelFactory> {
    public final Provider<DeliveryRdsStartOrderingInteractor> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<String> c;
    public final Provider<String> d;
    public final Provider<String> e;
    public final Provider<Boolean> f;
    public final Provider<Boolean> g;
    public final Provider<String> h;
    public final Provider<DeliveryStartOrderingResourceProvider> i;
    public final Provider<Analytics> j;
    public final Provider<AccountStateProvider> k;
    public final Provider<BaseScreenPerformanceTracker> l;
    public final Provider<ParametrizedEvent> m;

    public DeliveryRdsStartOrderingViewModelFactory_Factory(Provider<DeliveryRdsStartOrderingInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<String> provider3, Provider<String> provider4, Provider<String> provider5, Provider<Boolean> provider6, Provider<Boolean> provider7, Provider<String> provider8, Provider<DeliveryStartOrderingResourceProvider> provider9, Provider<Analytics> provider10, Provider<AccountStateProvider> provider11, Provider<BaseScreenPerformanceTracker> provider12, Provider<ParametrizedEvent> provider13) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
        this.l = provider12;
        this.m = provider13;
    }

    public static DeliveryRdsStartOrderingViewModelFactory_Factory create(Provider<DeliveryRdsStartOrderingInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<String> provider3, Provider<String> provider4, Provider<String> provider5, Provider<Boolean> provider6, Provider<Boolean> provider7, Provider<String> provider8, Provider<DeliveryStartOrderingResourceProvider> provider9, Provider<Analytics> provider10, Provider<AccountStateProvider> provider11, Provider<BaseScreenPerformanceTracker> provider12, Provider<ParametrizedEvent> provider13) {
        return new DeliveryRdsStartOrderingViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    public static DeliveryRdsStartOrderingViewModelFactory newInstance(DeliveryRdsStartOrderingInteractor deliveryRdsStartOrderingInteractor, SchedulersFactory3 schedulersFactory3, String str, String str2, String str3, boolean z, boolean z2, String str4, DeliveryStartOrderingResourceProvider deliveryStartOrderingResourceProvider, Analytics analytics, AccountStateProvider accountStateProvider, BaseScreenPerformanceTracker baseScreenPerformanceTracker, ParametrizedEvent parametrizedEvent) {
        return new DeliveryRdsStartOrderingViewModelFactory(deliveryRdsStartOrderingInteractor, schedulersFactory3, str, str2, str3, z, z2, str4, deliveryStartOrderingResourceProvider, analytics, accountStateProvider, baseScreenPerformanceTracker, parametrizedEvent);
    }

    @Override // javax.inject.Provider
    public DeliveryRdsStartOrderingViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get().booleanValue(), this.g.get().booleanValue(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get());
    }
}
