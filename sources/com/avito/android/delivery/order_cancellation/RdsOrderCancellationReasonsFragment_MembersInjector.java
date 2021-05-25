package com.avito.android.delivery.order_cancellation;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class RdsOrderCancellationReasonsFragment_MembersInjector implements MembersInjector<RdsOrderCancellationReasonsFragment> {
    public final Provider<Analytics> a;
    public final Provider<RdsOrderCancellationReasonsViewModel> b;
    public final Provider<SimpleRecyclerAdapter> c;
    public final Provider<DataAwareAdapterPresenter> d;
    public final Provider<OrderCancellationResourceProvider> e;
    public final Provider<BaseScreenPerformanceTracker> f;

    public RdsOrderCancellationReasonsFragment_MembersInjector(Provider<Analytics> provider, Provider<RdsOrderCancellationReasonsViewModel> provider2, Provider<SimpleRecyclerAdapter> provider3, Provider<DataAwareAdapterPresenter> provider4, Provider<OrderCancellationResourceProvider> provider5, Provider<BaseScreenPerformanceTracker> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<RdsOrderCancellationReasonsFragment> create(Provider<Analytics> provider, Provider<RdsOrderCancellationReasonsViewModel> provider2, Provider<SimpleRecyclerAdapter> provider3, Provider<DataAwareAdapterPresenter> provider4, Provider<OrderCancellationResourceProvider> provider5, Provider<BaseScreenPerformanceTracker> provider6) {
        return new RdsOrderCancellationReasonsFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsFragment.adapterPresenter")
    public static void injectAdapterPresenter(RdsOrderCancellationReasonsFragment rdsOrderCancellationReasonsFragment, DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        rdsOrderCancellationReasonsFragment.adapterPresenter = dataAwareAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsFragment.analytics")
    public static void injectAnalytics(RdsOrderCancellationReasonsFragment rdsOrderCancellationReasonsFragment, Analytics analytics) {
        rdsOrderCancellationReasonsFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(RdsOrderCancellationReasonsFragment rdsOrderCancellationReasonsFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        rdsOrderCancellationReasonsFragment.recyclerAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsFragment.resourceProvider")
    public static void injectResourceProvider(RdsOrderCancellationReasonsFragment rdsOrderCancellationReasonsFragment, OrderCancellationResourceProvider orderCancellationResourceProvider) {
        rdsOrderCancellationReasonsFragment.resourceProvider = orderCancellationResourceProvider;
    }

    @InjectedFieldSignature("com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsFragment.tracker")
    public static void injectTracker(RdsOrderCancellationReasonsFragment rdsOrderCancellationReasonsFragment, BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        rdsOrderCancellationReasonsFragment.tracker = baseScreenPerformanceTracker;
    }

    @InjectedFieldSignature("com.avito.android.delivery.order_cancellation.RdsOrderCancellationReasonsFragment.viewModel")
    public static void injectViewModel(RdsOrderCancellationReasonsFragment rdsOrderCancellationReasonsFragment, RdsOrderCancellationReasonsViewModel rdsOrderCancellationReasonsViewModel) {
        rdsOrderCancellationReasonsFragment.viewModel = rdsOrderCancellationReasonsViewModel;
    }

    public void injectMembers(RdsOrderCancellationReasonsFragment rdsOrderCancellationReasonsFragment) {
        injectAnalytics(rdsOrderCancellationReasonsFragment, this.a.get());
        injectViewModel(rdsOrderCancellationReasonsFragment, this.b.get());
        injectRecyclerAdapter(rdsOrderCancellationReasonsFragment, this.c.get());
        injectAdapterPresenter(rdsOrderCancellationReasonsFragment, this.d.get());
        injectResourceProvider(rdsOrderCancellationReasonsFragment, this.e.get());
        injectTracker(rdsOrderCancellationReasonsFragment, this.f.get());
    }
}
