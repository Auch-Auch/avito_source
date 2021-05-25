package com.avito.android.delivery.order_cancellation.details;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.delivery.order_cancellation.OrderCancellationResourceProvider;
import com.avito.android.delivery.order_cancellation.RdsOrderCancellationInteractor;
import com.avito.android.remote.model.ReasonRds;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ReasonDetailsViewModelFactory_Factory implements Factory<ReasonDetailsViewModelFactory> {
    public final Provider<Analytics> a;
    public final Provider<RdsOrderCancellationInteractor> b;
    public final Provider<AccountStateProvider> c;
    public final Provider<ReasonDetailsItemsConverter> d;
    public final Provider<SchedulersFactory> e;
    public final Provider<OrderCancellationResourceProvider> f;
    public final Provider<ReasonRds> g;
    public final Provider<String> h;

    public ReasonDetailsViewModelFactory_Factory(Provider<Analytics> provider, Provider<RdsOrderCancellationInteractor> provider2, Provider<AccountStateProvider> provider3, Provider<ReasonDetailsItemsConverter> provider4, Provider<SchedulersFactory> provider5, Provider<OrderCancellationResourceProvider> provider6, Provider<ReasonRds> provider7, Provider<String> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static ReasonDetailsViewModelFactory_Factory create(Provider<Analytics> provider, Provider<RdsOrderCancellationInteractor> provider2, Provider<AccountStateProvider> provider3, Provider<ReasonDetailsItemsConverter> provider4, Provider<SchedulersFactory> provider5, Provider<OrderCancellationResourceProvider> provider6, Provider<ReasonRds> provider7, Provider<String> provider8) {
        return new ReasonDetailsViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static ReasonDetailsViewModelFactory newInstance(Analytics analytics, RdsOrderCancellationInteractor rdsOrderCancellationInteractor, AccountStateProvider accountStateProvider, ReasonDetailsItemsConverter reasonDetailsItemsConverter, SchedulersFactory schedulersFactory, OrderCancellationResourceProvider orderCancellationResourceProvider, ReasonRds reasonRds, String str) {
        return new ReasonDetailsViewModelFactory(analytics, rdsOrderCancellationInteractor, accountStateProvider, reasonDetailsItemsConverter, schedulersFactory, orderCancellationResourceProvider, reasonRds, str);
    }

    @Override // javax.inject.Provider
    public ReasonDetailsViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
