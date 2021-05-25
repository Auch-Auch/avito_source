package com.avito.android.vas_performance.ui;

import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.vas_performance.tracker.VisualVasTracker;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class VisualVasFragment_MembersInjector implements MembersInjector<VisualVasFragment> {
    public final Provider<ItemBinder> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<Set<ItemPresenter<?, ?>>> c;
    public final Provider<VisualVasViewModel> d;
    public final Provider<DeepLinkIntentFactory> e;
    public final Provider<Analytics> f;
    public final Provider<VisualVasTracker> g;

    public VisualVasFragment_MembersInjector(Provider<ItemBinder> provider, Provider<AdapterPresenter> provider2, Provider<Set<ItemPresenter<?, ?>>> provider3, Provider<VisualVasViewModel> provider4, Provider<DeepLinkIntentFactory> provider5, Provider<Analytics> provider6, Provider<VisualVasTracker> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static MembersInjector<VisualVasFragment> create(Provider<ItemBinder> provider, Provider<AdapterPresenter> provider2, Provider<Set<ItemPresenter<?, ?>>> provider3, Provider<VisualVasViewModel> provider4, Provider<DeepLinkIntentFactory> provider5, Provider<Analytics> provider6, Provider<VisualVasTracker> provider7) {
        return new VisualVasFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.VisualVasFragment.adapterPresenter")
    public static void injectAdapterPresenter(VisualVasFragment visualVasFragment, AdapterPresenter adapterPresenter) {
        visualVasFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.VisualVasFragment.analytics")
    public static void injectAnalytics(VisualVasFragment visualVasFragment, Analytics analytics) {
        visualVasFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.VisualVasFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(VisualVasFragment visualVasFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        visualVasFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.VisualVasFragment.itemBinder")
    public static void injectItemBinder(VisualVasFragment visualVasFragment, ItemBinder itemBinder) {
        visualVasFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.VisualVasFragment.itemPresenterSet")
    public static void injectItemPresenterSet(VisualVasFragment visualVasFragment, Set<ItemPresenter<?, ?>> set) {
        visualVasFragment.itemPresenterSet = set;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.VisualVasFragment.tracker")
    public static void injectTracker(VisualVasFragment visualVasFragment, VisualVasTracker visualVasTracker) {
        visualVasFragment.tracker = visualVasTracker;
    }

    @InjectedFieldSignature("com.avito.android.vas_performance.ui.VisualVasFragment.viewModel")
    public static void injectViewModel(VisualVasFragment visualVasFragment, VisualVasViewModel visualVasViewModel) {
        visualVasFragment.viewModel = visualVasViewModel;
    }

    public void injectMembers(VisualVasFragment visualVasFragment) {
        injectItemBinder(visualVasFragment, this.a.get());
        injectAdapterPresenter(visualVasFragment, this.b.get());
        injectItemPresenterSet(visualVasFragment, this.c.get());
        injectViewModel(visualVasFragment, this.d.get());
        injectDeepLinkIntentFactory(visualVasFragment, this.e.get());
        injectAnalytics(visualVasFragment, this.f.get());
        injectTracker(visualVasFragment, this.g.get());
    }
}
