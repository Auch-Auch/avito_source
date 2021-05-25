package com.avito.android.safedeal.delivery_courier.order_update;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class DeliveryCourierOrderUpdateFragment_MembersInjector implements MembersInjector<DeliveryCourierOrderUpdateFragment> {
    public final Provider<Analytics> a;
    public final Provider<DeliveryCourierOrderUpdateViewModel> b;
    public final Provider<SimpleRecyclerAdapter> c;
    public final Provider<DataAwareAdapterPresenter> d;
    public final Provider<DeepLinkIntentFactory> e;
    public final Provider<ActivityIntentFactory> f;
    public final Provider<DeepLinkFactory> g;
    public final Provider<DeliveryCourierOrderUpdateResourceProvider> h;
    public final Provider<DeliveryCourierOrderUpdateAnalyticsTracker> i;
    public final Provider<BaseScreenPerformanceTracker> j;

    public DeliveryCourierOrderUpdateFragment_MembersInjector(Provider<Analytics> provider, Provider<DeliveryCourierOrderUpdateViewModel> provider2, Provider<SimpleRecyclerAdapter> provider3, Provider<DataAwareAdapterPresenter> provider4, Provider<DeepLinkIntentFactory> provider5, Provider<ActivityIntentFactory> provider6, Provider<DeepLinkFactory> provider7, Provider<DeliveryCourierOrderUpdateResourceProvider> provider8, Provider<DeliveryCourierOrderUpdateAnalyticsTracker> provider9, Provider<BaseScreenPerformanceTracker> provider10) {
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
    }

    public static MembersInjector<DeliveryCourierOrderUpdateFragment> create(Provider<Analytics> provider, Provider<DeliveryCourierOrderUpdateViewModel> provider2, Provider<SimpleRecyclerAdapter> provider3, Provider<DataAwareAdapterPresenter> provider4, Provider<DeepLinkIntentFactory> provider5, Provider<ActivityIntentFactory> provider6, Provider<DeepLinkFactory> provider7, Provider<DeliveryCourierOrderUpdateResourceProvider> provider8, Provider<DeliveryCourierOrderUpdateAnalyticsTracker> provider9, Provider<BaseScreenPerformanceTracker> provider10) {
        return new DeliveryCourierOrderUpdateFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment, ActivityIntentFactory activityIntentFactory) {
        deliveryCourierOrderUpdateFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateFragment.adapterPresenter")
    public static void injectAdapterPresenter(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment, DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        deliveryCourierOrderUpdateFragment.adapterPresenter = dataAwareAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateFragment.analytics")
    public static void injectAnalytics(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment, Analytics analytics) {
        deliveryCourierOrderUpdateFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateFragment.deepLinkFactory")
    public static void injectDeepLinkFactory(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment, DeepLinkFactory deepLinkFactory) {
        deliveryCourierOrderUpdateFragment.deepLinkFactory = deepLinkFactory;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        deliveryCourierOrderUpdateFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateFragment.performanceTracker")
    public static void injectPerformanceTracker(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment, BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        deliveryCourierOrderUpdateFragment.performanceTracker = baseScreenPerformanceTracker;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        deliveryCourierOrderUpdateFragment.recyclerAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateFragment.resourceProvider")
    public static void injectResourceProvider(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment, DeliveryCourierOrderUpdateResourceProvider deliveryCourierOrderUpdateResourceProvider) {
        deliveryCourierOrderUpdateFragment.resourceProvider = deliveryCourierOrderUpdateResourceProvider;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateFragment.tracker")
    public static void injectTracker(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment, DeliveryCourierOrderUpdateAnalyticsTracker deliveryCourierOrderUpdateAnalyticsTracker) {
        deliveryCourierOrderUpdateFragment.tracker = deliveryCourierOrderUpdateAnalyticsTracker;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateFragment.viewModel")
    public static void injectViewModel(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment, DeliveryCourierOrderUpdateViewModel deliveryCourierOrderUpdateViewModel) {
        deliveryCourierOrderUpdateFragment.viewModel = deliveryCourierOrderUpdateViewModel;
    }

    public void injectMembers(DeliveryCourierOrderUpdateFragment deliveryCourierOrderUpdateFragment) {
        injectAnalytics(deliveryCourierOrderUpdateFragment, this.a.get());
        injectViewModel(deliveryCourierOrderUpdateFragment, this.b.get());
        injectRecyclerAdapter(deliveryCourierOrderUpdateFragment, this.c.get());
        injectAdapterPresenter(deliveryCourierOrderUpdateFragment, this.d.get());
        injectDeepLinkIntentFactory(deliveryCourierOrderUpdateFragment, this.e.get());
        injectActivityIntentFactory(deliveryCourierOrderUpdateFragment, this.f.get());
        injectDeepLinkFactory(deliveryCourierOrderUpdateFragment, this.g.get());
        injectResourceProvider(deliveryCourierOrderUpdateFragment, this.h.get());
        injectTracker(deliveryCourierOrderUpdateFragment, this.i.get());
        injectPerformanceTracker(deliveryCourierOrderUpdateFragment, this.j.get());
    }
}
