package com.avito.android.vas_performance.ui;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.vas_performance.LegacyPerformanceVasViewModel;
import com.avito.android.vas_performance.tracker.PerformanceVasTracker;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class LegacyPerformanceVasFragment_MembersInjector implements MembersInjector<LegacyPerformanceVasFragment> {
    public final Provider<ItemBinder> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<LegacyPerformanceVasViewModel> c;
    public final Provider<Set<ItemPresenter<?, ?>>> d;
    public final Provider<Analytics> e;
    public final Provider<PerformanceVasTracker> f;
    public final Provider<DeepLinkIntentFactory> g;

    public LegacyPerformanceVasFragment_MembersInjector(Provider<ItemBinder> provider, Provider<AdapterPresenter> provider2, Provider<LegacyPerformanceVasViewModel> provider3, Provider<Set<ItemPresenter<?, ?>>> provider4, Provider<Analytics> provider5, Provider<PerformanceVasTracker> provider6, Provider<DeepLinkIntentFactory> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static MembersInjector<LegacyPerformanceVasFragment> create(Provider<ItemBinder> provider, Provider<AdapterPresenter> provider2, Provider<LegacyPerformanceVasViewModel> provider3, Provider<Set<ItemPresenter<?, ?>>> provider4, Provider<Analytics> provider5, Provider<PerformanceVasTracker> provider6, Provider<DeepLinkIntentFactory> provider7) {
        return new LegacyPerformanceVasFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.LegacyPerformanceVasFragment.adapterPresenter")
    public static void injectAdapterPresenter(LegacyPerformanceVasFragment legacyPerformanceVasFragment, AdapterPresenter adapterPresenter) {
        legacyPerformanceVasFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.LegacyPerformanceVasFragment.analytics")
    public static void injectAnalytics(LegacyPerformanceVasFragment legacyPerformanceVasFragment, Analytics analytics) {
        legacyPerformanceVasFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.LegacyPerformanceVasFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(LegacyPerformanceVasFragment legacyPerformanceVasFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        legacyPerformanceVasFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.LegacyPerformanceVasFragment.itemBinder")
    public static void injectItemBinder(LegacyPerformanceVasFragment legacyPerformanceVasFragment, ItemBinder itemBinder) {
        legacyPerformanceVasFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.LegacyPerformanceVasFragment.itemPresenterSet")
    public static void injectItemPresenterSet(LegacyPerformanceVasFragment legacyPerformanceVasFragment, Set<ItemPresenter<?, ?>> set) {
        legacyPerformanceVasFragment.itemPresenterSet = set;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.LegacyPerformanceVasFragment.tracker")
    public static void injectTracker(LegacyPerformanceVasFragment legacyPerformanceVasFragment, PerformanceVasTracker performanceVasTracker) {
        legacyPerformanceVasFragment.tracker = performanceVasTracker;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.LegacyPerformanceVasFragment.viewModel")
    public static void injectViewModel(LegacyPerformanceVasFragment legacyPerformanceVasFragment, LegacyPerformanceVasViewModel legacyPerformanceVasViewModel) {
        legacyPerformanceVasFragment.viewModel = legacyPerformanceVasViewModel;
    }

    public void injectMembers(LegacyPerformanceVasFragment legacyPerformanceVasFragment) {
        injectItemBinder(legacyPerformanceVasFragment, this.a.get());
        injectAdapterPresenter(legacyPerformanceVasFragment, this.b.get());
        injectViewModel(legacyPerformanceVasFragment, this.c.get());
        injectItemPresenterSet(legacyPerformanceVasFragment, this.d.get());
        injectAnalytics(legacyPerformanceVasFragment, this.e.get());
        injectTracker(legacyPerformanceVasFragment, this.f.get());
        injectDeepLinkIntentFactory(legacyPerformanceVasFragment, this.g.get());
    }
}
