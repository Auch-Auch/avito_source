package com.avito.android.delivery.suggest;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class DeliveryLocationSuggestFragment_MembersInjector implements MembersInjector<DeliveryLocationSuggestFragment> {
    public final Provider<DeliveryLocationSuggestViewModel> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;
    public final Provider<Analytics> d;
    public final Provider<Features> e;
    public final Provider<SchedulersFactory3> f;
    public final Provider<BaseScreenPerformanceTracker> g;

    public DeliveryLocationSuggestFragment_MembersInjector(Provider<DeliveryLocationSuggestViewModel> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<Analytics> provider4, Provider<Features> provider5, Provider<SchedulersFactory3> provider6, Provider<BaseScreenPerformanceTracker> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static MembersInjector<DeliveryLocationSuggestFragment> create(Provider<DeliveryLocationSuggestViewModel> provider, Provider<AdapterPresenter> provider2, Provider<ItemBinder> provider3, Provider<Analytics> provider4, Provider<Features> provider5, Provider<SchedulersFactory3> provider6, Provider<BaseScreenPerformanceTracker> provider7) {
        return new DeliveryLocationSuggestFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.avito.android.delivery.suggest.DeliveryLocationSuggestFragment.adapterPresenter")
    public static void injectAdapterPresenter(DeliveryLocationSuggestFragment deliveryLocationSuggestFragment, AdapterPresenter adapterPresenter) {
        deliveryLocationSuggestFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.delivery.suggest.DeliveryLocationSuggestFragment.analytics")
    public static void injectAnalytics(DeliveryLocationSuggestFragment deliveryLocationSuggestFragment, Analytics analytics) {
        deliveryLocationSuggestFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.delivery.suggest.DeliveryLocationSuggestFragment.features")
    public static void injectFeatures(DeliveryLocationSuggestFragment deliveryLocationSuggestFragment, Features features) {
        deliveryLocationSuggestFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.delivery.suggest.DeliveryLocationSuggestFragment.itemBinder")
    public static void injectItemBinder(DeliveryLocationSuggestFragment deliveryLocationSuggestFragment, ItemBinder itemBinder) {
        deliveryLocationSuggestFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.delivery.suggest.DeliveryLocationSuggestFragment.schedulers")
    public static void injectSchedulers(DeliveryLocationSuggestFragment deliveryLocationSuggestFragment, SchedulersFactory3 schedulersFactory3) {
        deliveryLocationSuggestFragment.schedulers = schedulersFactory3;
    }

    @InjectedFieldSignature("com.avito.android.delivery.suggest.DeliveryLocationSuggestFragment.tracker")
    public static void injectTracker(DeliveryLocationSuggestFragment deliveryLocationSuggestFragment, BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        deliveryLocationSuggestFragment.tracker = baseScreenPerformanceTracker;
    }

    @InjectedFieldSignature("com.avito.android.delivery.suggest.DeliveryLocationSuggestFragment.viewModel")
    public static void injectViewModel(DeliveryLocationSuggestFragment deliveryLocationSuggestFragment, DeliveryLocationSuggestViewModel deliveryLocationSuggestViewModel) {
        deliveryLocationSuggestFragment.viewModel = deliveryLocationSuggestViewModel;
    }

    public void injectMembers(DeliveryLocationSuggestFragment deliveryLocationSuggestFragment) {
        injectViewModel(deliveryLocationSuggestFragment, this.a.get());
        injectAdapterPresenter(deliveryLocationSuggestFragment, this.b.get());
        injectItemBinder(deliveryLocationSuggestFragment, this.c.get());
        injectAnalytics(deliveryLocationSuggestFragment, this.d.get());
        injectFeatures(deliveryLocationSuggestFragment, this.e.get());
        injectSchedulers(deliveryLocationSuggestFragment, this.f.get());
        injectTracker(deliveryLocationSuggestFragment, this.g.get());
    }
}
