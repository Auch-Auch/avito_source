package com.avito.android.delivery.map.start_ordering;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.delivery.map.common.DeliveryMapViewModel;
import com.avito.android.delivery.map.common.marker.ClusterMarkerManager;
import com.avito.android.delivery.map.common.marker.DeliveryMapMarkerIconFactory;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewModel;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.find.FindLocationPresenter;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class DeliveryRdsStartOrderingFragment_MembersInjector implements MembersInjector<DeliveryRdsStartOrderingFragment> {
    public final Provider<DeliveryRdsStartOrderingViewModel> a;
    public final Provider<Analytics> b;
    public final Provider<ClusterMarkerManager> c;
    public final Provider<DeliveryMapViewModel> d;
    public final Provider<AdapterPresenter> e;
    public final Provider<ItemBinder> f;
    public final Provider<DeliveryRdsPointInfoViewModel> g;
    public final Provider<AttributedTextFormatter> h;
    public final Provider<ActivityIntentFactory> i;
    public final Provider<SchedulersFactory3> j;
    public final Provider<LocationPermissionDialogPresenter> k;
    public final Provider<AvitoMapAttachHelper> l;
    public final Provider<AccountStateProvider> m;
    public final Provider<DeliveryMapMarkerIconFactory> n;
    public final Provider<LocationPermissionDialogPresenter> o;
    public final Provider<FindLocationPresenter> p;
    public final Provider<LocationAnalyticsInteractor> q;
    public final Provider<ImplicitIntentFactory> r;
    public final Provider<BaseScreenPerformanceTracker> s;

    public DeliveryRdsStartOrderingFragment_MembersInjector(Provider<DeliveryRdsStartOrderingViewModel> provider, Provider<Analytics> provider2, Provider<ClusterMarkerManager> provider3, Provider<DeliveryMapViewModel> provider4, Provider<AdapterPresenter> provider5, Provider<ItemBinder> provider6, Provider<DeliveryRdsPointInfoViewModel> provider7, Provider<AttributedTextFormatter> provider8, Provider<ActivityIntentFactory> provider9, Provider<SchedulersFactory3> provider10, Provider<LocationPermissionDialogPresenter> provider11, Provider<AvitoMapAttachHelper> provider12, Provider<AccountStateProvider> provider13, Provider<DeliveryMapMarkerIconFactory> provider14, Provider<LocationPermissionDialogPresenter> provider15, Provider<FindLocationPresenter> provider16, Provider<LocationAnalyticsInteractor> provider17, Provider<ImplicitIntentFactory> provider18, Provider<BaseScreenPerformanceTracker> provider19) {
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
        this.k = provider11;
        this.l = provider12;
        this.m = provider13;
        this.n = provider14;
        this.o = provider15;
        this.p = provider16;
        this.q = provider17;
        this.r = provider18;
        this.s = provider19;
    }

    public static MembersInjector<DeliveryRdsStartOrderingFragment> create(Provider<DeliveryRdsStartOrderingViewModel> provider, Provider<Analytics> provider2, Provider<ClusterMarkerManager> provider3, Provider<DeliveryMapViewModel> provider4, Provider<AdapterPresenter> provider5, Provider<ItemBinder> provider6, Provider<DeliveryRdsPointInfoViewModel> provider7, Provider<AttributedTextFormatter> provider8, Provider<ActivityIntentFactory> provider9, Provider<SchedulersFactory3> provider10, Provider<LocationPermissionDialogPresenter> provider11, Provider<AvitoMapAttachHelper> provider12, Provider<AccountStateProvider> provider13, Provider<DeliveryMapMarkerIconFactory> provider14, Provider<LocationPermissionDialogPresenter> provider15, Provider<FindLocationPresenter> provider16, Provider<LocationAnalyticsInteractor> provider17, Provider<ImplicitIntentFactory> provider18, Provider<BaseScreenPerformanceTracker> provider19) {
        return new DeliveryRdsStartOrderingFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19);
    }

    @InjectedFieldSignature("com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment.accountState")
    public static void injectAccountState(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, AccountStateProvider accountStateProvider) {
        deliveryRdsStartOrderingFragment.accountState = accountStateProvider;
    }

    @InjectedFieldSignature("com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment.adapterPresenter")
    public static void injectAdapterPresenter(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, AdapterPresenter adapterPresenter) {
        deliveryRdsStartOrderingFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment.analytics")
    public static void injectAnalytics(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, Analytics analytics) {
        deliveryRdsStartOrderingFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment.attributedTextFormatter")
    public static void injectAttributedTextFormatter(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, AttributedTextFormatter attributedTextFormatter) {
        deliveryRdsStartOrderingFragment.attributedTextFormatter = attributedTextFormatter;
    }

    @InjectedFieldSignature("com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment.avitoMapAttachHelper")
    public static void injectAvitoMapAttachHelper(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, AvitoMapAttachHelper avitoMapAttachHelper) {
        deliveryRdsStartOrderingFragment.avitoMapAttachHelper = avitoMapAttachHelper;
    }

    @InjectedFieldSignature("com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment.clusterMarkerManager")
    public static void injectClusterMarkerManager(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, ClusterMarkerManager clusterMarkerManager) {
        deliveryRdsStartOrderingFragment.clusterMarkerManager = clusterMarkerManager;
    }

    @InjectedFieldSignature("com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment.findLocationPresenter")
    public static void injectFindLocationPresenter(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, FindLocationPresenter findLocationPresenter) {
        deliveryRdsStartOrderingFragment.findLocationPresenter = findLocationPresenter;
    }

    @InjectedFieldSignature("com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment.iconFactory")
    public static void injectIconFactory(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, DeliveryMapMarkerIconFactory deliveryMapMarkerIconFactory) {
        deliveryRdsStartOrderingFragment.iconFactory = deliveryMapMarkerIconFactory;
    }

    @InjectedFieldSignature("com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, ImplicitIntentFactory implicitIntentFactory) {
        deliveryRdsStartOrderingFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment.intentFactory")
    public static void injectIntentFactory(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, ActivityIntentFactory activityIntentFactory) {
        deliveryRdsStartOrderingFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment.itemBinder")
    public static void injectItemBinder(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, ItemBinder itemBinder) {
        deliveryRdsStartOrderingFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment.locationAnalyticsInteractor")
    public static void injectLocationAnalyticsInteractor(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, LocationAnalyticsInteractor locationAnalyticsInteractor) {
        deliveryRdsStartOrderingFragment.locationAnalyticsInteractor = locationAnalyticsInteractor;
    }

    @InjectedFieldSignature("com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment.locationPermissionDialogPresenter")
    public static void injectLocationPermissionDialogPresenter(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, LocationPermissionDialogPresenter locationPermissionDialogPresenter) {
        deliveryRdsStartOrderingFragment.locationPermissionDialogPresenter = locationPermissionDialogPresenter;
    }

    @InjectedFieldSignature("com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment.locationPermissionPresenter")
    public static void injectLocationPermissionPresenter(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, LocationPermissionDialogPresenter locationPermissionDialogPresenter) {
        deliveryRdsStartOrderingFragment.locationPermissionPresenter = locationPermissionDialogPresenter;
    }

    @InjectedFieldSignature("com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment.mapViewModel")
    public static void injectMapViewModel(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, DeliveryMapViewModel deliveryMapViewModel) {
        deliveryRdsStartOrderingFragment.mapViewModel = deliveryMapViewModel;
    }

    @InjectedFieldSignature("com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment.pointInfoViewModel")
    public static void injectPointInfoViewModel(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, DeliveryRdsPointInfoViewModel deliveryRdsPointInfoViewModel) {
        deliveryRdsStartOrderingFragment.pointInfoViewModel = deliveryRdsPointInfoViewModel;
    }

    @InjectedFieldSignature("com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment.schedulers")
    public static void injectSchedulers(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, SchedulersFactory3 schedulersFactory3) {
        deliveryRdsStartOrderingFragment.schedulers = schedulersFactory3;
    }

    @InjectedFieldSignature("com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment.startOrderingViewModel")
    public static void injectStartOrderingViewModel(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, DeliveryRdsStartOrderingViewModel deliveryRdsStartOrderingViewModel) {
        deliveryRdsStartOrderingFragment.startOrderingViewModel = deliveryRdsStartOrderingViewModel;
    }

    @InjectedFieldSignature("com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment.tracker")
    public static void injectTracker(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        deliveryRdsStartOrderingFragment.tracker = baseScreenPerformanceTracker;
    }

    public void injectMembers(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment) {
        injectStartOrderingViewModel(deliveryRdsStartOrderingFragment, this.a.get());
        injectAnalytics(deliveryRdsStartOrderingFragment, this.b.get());
        injectClusterMarkerManager(deliveryRdsStartOrderingFragment, this.c.get());
        injectMapViewModel(deliveryRdsStartOrderingFragment, this.d.get());
        injectAdapterPresenter(deliveryRdsStartOrderingFragment, this.e.get());
        injectItemBinder(deliveryRdsStartOrderingFragment, this.f.get());
        injectPointInfoViewModel(deliveryRdsStartOrderingFragment, this.g.get());
        injectAttributedTextFormatter(deliveryRdsStartOrderingFragment, this.h.get());
        injectIntentFactory(deliveryRdsStartOrderingFragment, this.i.get());
        injectSchedulers(deliveryRdsStartOrderingFragment, this.j.get());
        injectLocationPermissionPresenter(deliveryRdsStartOrderingFragment, this.k.get());
        injectAvitoMapAttachHelper(deliveryRdsStartOrderingFragment, this.l.get());
        injectAccountState(deliveryRdsStartOrderingFragment, this.m.get());
        injectIconFactory(deliveryRdsStartOrderingFragment, this.n.get());
        injectLocationPermissionDialogPresenter(deliveryRdsStartOrderingFragment, this.o.get());
        injectFindLocationPresenter(deliveryRdsStartOrderingFragment, this.p.get());
        injectLocationAnalyticsInteractor(deliveryRdsStartOrderingFragment, this.q.get());
        injectImplicitIntentFactory(deliveryRdsStartOrderingFragment, this.r.get());
        injectTracker(deliveryRdsStartOrderingFragment, this.s.get());
    }
}
