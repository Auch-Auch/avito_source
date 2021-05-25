package com.avito.android.delivery.summary;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class DeliveryRdsSummaryFragment_MembersInjector implements MembersInjector<DeliveryRdsSummaryFragment> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<DeepLinkIntentFactory> b;
    public final Provider<Analytics> c;
    public final Provider<SimpleRecyclerAdapter> d;
    public final Provider<DataAwareAdapterPresenter> e;
    public final Provider<DeliveryRdsSummaryViewModel> f;
    public final Provider<AttributedTextFormatter> g;
    public final Provider<BaseScreenPerformanceTracker> h;

    public DeliveryRdsSummaryFragment_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<Analytics> provider3, Provider<SimpleRecyclerAdapter> provider4, Provider<DataAwareAdapterPresenter> provider5, Provider<DeliveryRdsSummaryViewModel> provider6, Provider<AttributedTextFormatter> provider7, Provider<BaseScreenPerformanceTracker> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static MembersInjector<DeliveryRdsSummaryFragment> create(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<Analytics> provider3, Provider<SimpleRecyclerAdapter> provider4, Provider<DataAwareAdapterPresenter> provider5, Provider<DeliveryRdsSummaryViewModel> provider6, Provider<AttributedTextFormatter> provider7, Provider<BaseScreenPerformanceTracker> provider8) {
        return new DeliveryRdsSummaryFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @InjectedFieldSignature("com.avito.android.delivery.summary.DeliveryRdsSummaryFragment.adapterPresenter")
    public static void injectAdapterPresenter(DeliveryRdsSummaryFragment deliveryRdsSummaryFragment, DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        deliveryRdsSummaryFragment.adapterPresenter = dataAwareAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.delivery.summary.DeliveryRdsSummaryFragment.analytics")
    public static void injectAnalytics(DeliveryRdsSummaryFragment deliveryRdsSummaryFragment, Analytics analytics) {
        deliveryRdsSummaryFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.delivery.summary.DeliveryRdsSummaryFragment.attributedTextFormatter")
    public static void injectAttributedTextFormatter(DeliveryRdsSummaryFragment deliveryRdsSummaryFragment, AttributedTextFormatter attributedTextFormatter) {
        deliveryRdsSummaryFragment.attributedTextFormatter = attributedTextFormatter;
    }

    @InjectedFieldSignature("com.avito.android.delivery.summary.DeliveryRdsSummaryFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(DeliveryRdsSummaryFragment deliveryRdsSummaryFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        deliveryRdsSummaryFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.delivery.summary.DeliveryRdsSummaryFragment.intentFactory")
    public static void injectIntentFactory(DeliveryRdsSummaryFragment deliveryRdsSummaryFragment, ActivityIntentFactory activityIntentFactory) {
        deliveryRdsSummaryFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.delivery.summary.DeliveryRdsSummaryFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(DeliveryRdsSummaryFragment deliveryRdsSummaryFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        deliveryRdsSummaryFragment.recyclerAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.delivery.summary.DeliveryRdsSummaryFragment.tracker")
    public static void injectTracker(DeliveryRdsSummaryFragment deliveryRdsSummaryFragment, BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        deliveryRdsSummaryFragment.tracker = baseScreenPerformanceTracker;
    }

    @InjectedFieldSignature("com.avito.android.delivery.summary.DeliveryRdsSummaryFragment.viewModel")
    public static void injectViewModel(DeliveryRdsSummaryFragment deliveryRdsSummaryFragment, DeliveryRdsSummaryViewModel deliveryRdsSummaryViewModel) {
        deliveryRdsSummaryFragment.viewModel = deliveryRdsSummaryViewModel;
    }

    public void injectMembers(DeliveryRdsSummaryFragment deliveryRdsSummaryFragment) {
        injectIntentFactory(deliveryRdsSummaryFragment, this.a.get());
        injectDeepLinkIntentFactory(deliveryRdsSummaryFragment, this.b.get());
        injectAnalytics(deliveryRdsSummaryFragment, this.c.get());
        injectRecyclerAdapter(deliveryRdsSummaryFragment, this.d.get());
        injectAdapterPresenter(deliveryRdsSummaryFragment, this.e.get());
        injectViewModel(deliveryRdsSummaryFragment, this.f.get());
        injectAttributedTextFormatter(deliveryRdsSummaryFragment, this.g.get());
        injectTracker(deliveryRdsSummaryFragment, this.h.get());
    }
}
