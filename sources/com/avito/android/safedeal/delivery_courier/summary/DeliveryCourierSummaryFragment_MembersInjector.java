package com.avito.android.safedeal.delivery_courier.summary;

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
public final class DeliveryCourierSummaryFragment_MembersInjector implements MembersInjector<DeliveryCourierSummaryFragment> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<DeepLinkIntentFactory> b;
    public final Provider<Analytics> c;
    public final Provider<SimpleRecyclerAdapter> d;
    public final Provider<DataAwareAdapterPresenter> e;
    public final Provider<DeepLinkFactory> f;
    public final Provider<DeliveryCourierSummaryResourceProvider> g;
    public final Provider<DeliveryCourierSummaryViewModel> h;
    public final Provider<BaseScreenPerformanceTracker> i;

    public DeliveryCourierSummaryFragment_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<Analytics> provider3, Provider<SimpleRecyclerAdapter> provider4, Provider<DataAwareAdapterPresenter> provider5, Provider<DeepLinkFactory> provider6, Provider<DeliveryCourierSummaryResourceProvider> provider7, Provider<DeliveryCourierSummaryViewModel> provider8, Provider<BaseScreenPerformanceTracker> provider9) {
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

    public static MembersInjector<DeliveryCourierSummaryFragment> create(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<Analytics> provider3, Provider<SimpleRecyclerAdapter> provider4, Provider<DataAwareAdapterPresenter> provider5, Provider<DeepLinkFactory> provider6, Provider<DeliveryCourierSummaryResourceProvider> provider7, Provider<DeliveryCourierSummaryViewModel> provider8, Provider<BaseScreenPerformanceTracker> provider9) {
        return new DeliveryCourierSummaryFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryFragment.adapterPresenter")
    public static void injectAdapterPresenter(DeliveryCourierSummaryFragment deliveryCourierSummaryFragment, DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        deliveryCourierSummaryFragment.adapterPresenter = dataAwareAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryFragment.analytics")
    public static void injectAnalytics(DeliveryCourierSummaryFragment deliveryCourierSummaryFragment, Analytics analytics) {
        deliveryCourierSummaryFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryFragment.deepLinkFactory")
    public static void injectDeepLinkFactory(DeliveryCourierSummaryFragment deliveryCourierSummaryFragment, DeepLinkFactory deepLinkFactory) {
        deliveryCourierSummaryFragment.deepLinkFactory = deepLinkFactory;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(DeliveryCourierSummaryFragment deliveryCourierSummaryFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        deliveryCourierSummaryFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryFragment.intentFactory")
    public static void injectIntentFactory(DeliveryCourierSummaryFragment deliveryCourierSummaryFragment, ActivityIntentFactory activityIntentFactory) {
        deliveryCourierSummaryFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(DeliveryCourierSummaryFragment deliveryCourierSummaryFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        deliveryCourierSummaryFragment.recyclerAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryFragment.resourceProvider")
    public static void injectResourceProvider(DeliveryCourierSummaryFragment deliveryCourierSummaryFragment, DeliveryCourierSummaryResourceProvider deliveryCourierSummaryResourceProvider) {
        deliveryCourierSummaryFragment.resourceProvider = deliveryCourierSummaryResourceProvider;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryFragment.tracker")
    public static void injectTracker(DeliveryCourierSummaryFragment deliveryCourierSummaryFragment, BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        deliveryCourierSummaryFragment.tracker = baseScreenPerformanceTracker;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryFragment.viewModel")
    public static void injectViewModel(DeliveryCourierSummaryFragment deliveryCourierSummaryFragment, DeliveryCourierSummaryViewModel deliveryCourierSummaryViewModel) {
        deliveryCourierSummaryFragment.viewModel = deliveryCourierSummaryViewModel;
    }

    public void injectMembers(DeliveryCourierSummaryFragment deliveryCourierSummaryFragment) {
        injectIntentFactory(deliveryCourierSummaryFragment, this.a.get());
        injectDeepLinkIntentFactory(deliveryCourierSummaryFragment, this.b.get());
        injectAnalytics(deliveryCourierSummaryFragment, this.c.get());
        injectRecyclerAdapter(deliveryCourierSummaryFragment, this.d.get());
        injectAdapterPresenter(deliveryCourierSummaryFragment, this.e.get());
        injectDeepLinkFactory(deliveryCourierSummaryFragment, this.f.get());
        injectResourceProvider(deliveryCourierSummaryFragment, this.g.get());
        injectViewModel(deliveryCourierSummaryFragment, this.h.get());
        injectTracker(deliveryCourierSummaryFragment, this.i.get());
    }
}
