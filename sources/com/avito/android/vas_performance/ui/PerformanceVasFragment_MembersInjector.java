package com.avito.android.vas_performance.ui;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.vas_performance.PerformanceVasViewModel;
import com.avito.android.vas_performance.tracker.PerformanceVasTracker;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class PerformanceVasFragment_MembersInjector implements MembersInjector<PerformanceVasFragment> {
    public final Provider<ItemBinder> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<PerformanceVasViewModel> c;
    public final Provider<Analytics> d;
    public final Provider<DeepLinkIntentFactory> e;
    public final Provider<Set<ItemPresenter<?, ?>>> f;
    public final Provider<PerformanceVasTracker> g;

    public PerformanceVasFragment_MembersInjector(Provider<ItemBinder> provider, Provider<AdapterPresenter> provider2, Provider<PerformanceVasViewModel> provider3, Provider<Analytics> provider4, Provider<DeepLinkIntentFactory> provider5, Provider<Set<ItemPresenter<?, ?>>> provider6, Provider<PerformanceVasTracker> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static MembersInjector<PerformanceVasFragment> create(Provider<ItemBinder> provider, Provider<AdapterPresenter> provider2, Provider<PerformanceVasViewModel> provider3, Provider<Analytics> provider4, Provider<DeepLinkIntentFactory> provider5, Provider<Set<ItemPresenter<?, ?>>> provider6, Provider<PerformanceVasTracker> provider7) {
        return new PerformanceVasFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.PerformanceVasFragment.adapterPresenter")
    public static void injectAdapterPresenter(PerformanceVasFragment performanceVasFragment, AdapterPresenter adapterPresenter) {
        performanceVasFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.PerformanceVasFragment.analytics")
    public static void injectAnalytics(PerformanceVasFragment performanceVasFragment, Analytics analytics) {
        performanceVasFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.PerformanceVasFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(PerformanceVasFragment performanceVasFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        performanceVasFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.PerformanceVasFragment.itemBinder")
    public static void injectItemBinder(PerformanceVasFragment performanceVasFragment, ItemBinder itemBinder) {
        performanceVasFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.PerformanceVasFragment.itemPresenterSet")
    public static void injectItemPresenterSet(PerformanceVasFragment performanceVasFragment, Set<ItemPresenter<?, ?>> set) {
        performanceVasFragment.itemPresenterSet = set;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.PerformanceVasFragment.tracker")
    public static void injectTracker(PerformanceVasFragment performanceVasFragment, PerformanceVasTracker performanceVasTracker) {
        performanceVasFragment.tracker = performanceVasTracker;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.PerformanceVasFragment.viewModel")
    public static void injectViewModel(PerformanceVasFragment performanceVasFragment, PerformanceVasViewModel performanceVasViewModel) {
        performanceVasFragment.viewModel = performanceVasViewModel;
    }

    public void injectMembers(PerformanceVasFragment performanceVasFragment) {
        injectItemBinder(performanceVasFragment, this.a.get());
        injectAdapterPresenter(performanceVasFragment, this.b.get());
        injectViewModel(performanceVasFragment, this.c.get());
        injectAnalytics(performanceVasFragment, this.d.get());
        injectDeepLinkIntentFactory(performanceVasFragment, this.e.get());
        injectItemPresenterSet(performanceVasFragment, this.f.get());
        injectTracker(performanceVasFragment, this.g.get());
    }
}
