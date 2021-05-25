package com.avito.android.delivery.order_cancellation;

import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RdsOrderCancellationReasonsViewModelFactory_Factory implements Factory<RdsOrderCancellationReasonsViewModelFactory> {
    public final Provider<RdsOrderCancellationInteractor> a;
    public final Provider<OrderCancellationResourceProvider> b;
    public final Provider<RdsOrderCancellationItemsConverter> c;
    public final Provider<SchedulersFactory> d;
    public final Provider<String> e;
    public final Provider<BaseScreenPerformanceTracker> f;

    public RdsOrderCancellationReasonsViewModelFactory_Factory(Provider<RdsOrderCancellationInteractor> provider, Provider<OrderCancellationResourceProvider> provider2, Provider<RdsOrderCancellationItemsConverter> provider3, Provider<SchedulersFactory> provider4, Provider<String> provider5, Provider<BaseScreenPerformanceTracker> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static RdsOrderCancellationReasonsViewModelFactory_Factory create(Provider<RdsOrderCancellationInteractor> provider, Provider<OrderCancellationResourceProvider> provider2, Provider<RdsOrderCancellationItemsConverter> provider3, Provider<SchedulersFactory> provider4, Provider<String> provider5, Provider<BaseScreenPerformanceTracker> provider6) {
        return new RdsOrderCancellationReasonsViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static RdsOrderCancellationReasonsViewModelFactory newInstance(RdsOrderCancellationInteractor rdsOrderCancellationInteractor, OrderCancellationResourceProvider orderCancellationResourceProvider, RdsOrderCancellationItemsConverter rdsOrderCancellationItemsConverter, SchedulersFactory schedulersFactory, String str, BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        return new RdsOrderCancellationReasonsViewModelFactory(rdsOrderCancellationInteractor, orderCancellationResourceProvider, rdsOrderCancellationItemsConverter, schedulersFactory, str, baseScreenPerformanceTracker);
    }

    @Override // javax.inject.Provider
    public RdsOrderCancellationReasonsViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
