package com.avito.android.vas_performance.ui;

import com.avito.android.analytics.Analytics;
import com.avito.android.vas_performance.LegacyVisualVasViewModel;
import com.avito.android.vas_performance.tracker.VisualVasTracker;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class LegacyVisualVasFragment_MembersInjector implements MembersInjector<LegacyVisualVasFragment> {
    public final Provider<ItemBinder> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<Set<ItemPresenter<?, ?>>> c;
    public final Provider<LegacyVisualVasViewModel> d;
    public final Provider<Analytics> e;
    public final Provider<VisualVasTracker> f;

    public LegacyVisualVasFragment_MembersInjector(Provider<ItemBinder> provider, Provider<AdapterPresenter> provider2, Provider<Set<ItemPresenter<?, ?>>> provider3, Provider<LegacyVisualVasViewModel> provider4, Provider<Analytics> provider5, Provider<VisualVasTracker> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<LegacyVisualVasFragment> create(Provider<ItemBinder> provider, Provider<AdapterPresenter> provider2, Provider<Set<ItemPresenter<?, ?>>> provider3, Provider<LegacyVisualVasViewModel> provider4, Provider<Analytics> provider5, Provider<VisualVasTracker> provider6) {
        return new LegacyVisualVasFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.LegacyVisualVasFragment.adapterPresenter")
    public static void injectAdapterPresenter(LegacyVisualVasFragment legacyVisualVasFragment, AdapterPresenter adapterPresenter) {
        legacyVisualVasFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.LegacyVisualVasFragment.analytics")
    public static void injectAnalytics(LegacyVisualVasFragment legacyVisualVasFragment, Analytics analytics) {
        legacyVisualVasFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.LegacyVisualVasFragment.itemBinder")
    public static void injectItemBinder(LegacyVisualVasFragment legacyVisualVasFragment, ItemBinder itemBinder) {
        legacyVisualVasFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.LegacyVisualVasFragment.itemPresenterSet")
    public static void injectItemPresenterSet(LegacyVisualVasFragment legacyVisualVasFragment, Set<ItemPresenter<?, ?>> set) {
        legacyVisualVasFragment.itemPresenterSet = set;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.LegacyVisualVasFragment.tracker")
    public static void injectTracker(LegacyVisualVasFragment legacyVisualVasFragment, VisualVasTracker visualVasTracker) {
        legacyVisualVasFragment.tracker = visualVasTracker;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.LegacyVisualVasFragment.viewModel")
    public static void injectViewModel(LegacyVisualVasFragment legacyVisualVasFragment, LegacyVisualVasViewModel legacyVisualVasViewModel) {
        legacyVisualVasFragment.viewModel = legacyVisualVasViewModel;
    }

    public void injectMembers(LegacyVisualVasFragment legacyVisualVasFragment) {
        injectItemBinder(legacyVisualVasFragment, this.a.get());
        injectAdapterPresenter(legacyVisualVasFragment, this.b.get());
        injectItemPresenterSet(legacyVisualVasFragment, this.c.get());
        injectViewModel(legacyVisualVasFragment, this.d.get());
        injectAnalytics(legacyVisualVasFragment, this.e.get());
        injectTracker(legacyVisualVasFragment, this.f.get());
    }
}
