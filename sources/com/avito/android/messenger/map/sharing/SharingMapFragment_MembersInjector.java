package com.avito.android.messenger.map.sharing;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.find.FindLocationPresenter;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SchedulersFactory3;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class SharingMapFragment_MembersInjector implements MembersInjector<SharingMapFragment> {
    public final Provider<SharingMapPresenter> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<Features> c;
    public final Provider<Analytics> d;
    public final Provider<FindLocationPresenter> e;
    public final Provider<LocationPermissionDialogPresenter> f;
    public final Provider<LocationAnalyticsInteractor> g;
    public final Provider<ImplicitIntentFactory> h;
    public final Provider<SchedulersFactory3> i;

    public SharingMapFragment_MembersInjector(Provider<SharingMapPresenter> provider, Provider<ActivityIntentFactory> provider2, Provider<Features> provider3, Provider<Analytics> provider4, Provider<FindLocationPresenter> provider5, Provider<LocationPermissionDialogPresenter> provider6, Provider<LocationAnalyticsInteractor> provider7, Provider<ImplicitIntentFactory> provider8, Provider<SchedulersFactory3> provider9) {
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

    public static MembersInjector<SharingMapFragment> create(Provider<SharingMapPresenter> provider, Provider<ActivityIntentFactory> provider2, Provider<Features> provider3, Provider<Analytics> provider4, Provider<FindLocationPresenter> provider5, Provider<LocationPermissionDialogPresenter> provider6, Provider<LocationAnalyticsInteractor> provider7, Provider<ImplicitIntentFactory> provider8, Provider<SchedulersFactory3> provider9) {
        return new SharingMapFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @InjectedFieldSignature("com.avito.android.messenger.map.sharing.SharingMapFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(SharingMapFragment sharingMapFragment, ActivityIntentFactory activityIntentFactory) {
        sharingMapFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.messenger.map.sharing.SharingMapFragment.analytics")
    public static void injectAnalytics(SharingMapFragment sharingMapFragment, Analytics analytics) {
        sharingMapFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.messenger.map.sharing.SharingMapFragment.features")
    public static void injectFeatures(SharingMapFragment sharingMapFragment, Features features) {
        sharingMapFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.messenger.map.sharing.SharingMapFragment.findLocationPresenter")
    public static void injectFindLocationPresenter(SharingMapFragment sharingMapFragment, FindLocationPresenter findLocationPresenter) {
        sharingMapFragment.findLocationPresenter = findLocationPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.map.sharing.SharingMapFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(SharingMapFragment sharingMapFragment, ImplicitIntentFactory implicitIntentFactory) {
        sharingMapFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.messenger.map.sharing.SharingMapFragment.locationAnalyticsInteractor")
    public static void injectLocationAnalyticsInteractor(SharingMapFragment sharingMapFragment, LocationAnalyticsInteractor locationAnalyticsInteractor) {
        sharingMapFragment.locationAnalyticsInteractor = locationAnalyticsInteractor;
    }

    @InjectedFieldSignature("com.avito.android.messenger.map.sharing.SharingMapFragment.locationPermissionDialogPresenter")
    public static void injectLocationPermissionDialogPresenter(SharingMapFragment sharingMapFragment, LocationPermissionDialogPresenter locationPermissionDialogPresenter) {
        sharingMapFragment.locationPermissionDialogPresenter = locationPermissionDialogPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.map.sharing.SharingMapFragment.presenter")
    public static void injectPresenter(SharingMapFragment sharingMapFragment, SharingMapPresenter sharingMapPresenter) {
        sharingMapFragment.presenter = sharingMapPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.map.sharing.SharingMapFragment.schedulers")
    public static void injectSchedulers(SharingMapFragment sharingMapFragment, SchedulersFactory3 schedulersFactory3) {
        sharingMapFragment.schedulers = schedulersFactory3;
    }

    public void injectMembers(SharingMapFragment sharingMapFragment) {
        injectPresenter(sharingMapFragment, this.a.get());
        injectActivityIntentFactory(sharingMapFragment, this.b.get());
        injectFeatures(sharingMapFragment, this.c.get());
        injectAnalytics(sharingMapFragment, this.d.get());
        injectFindLocationPresenter(sharingMapFragment, this.e.get());
        injectLocationPermissionDialogPresenter(sharingMapFragment, this.f.get());
        injectLocationAnalyticsInteractor(sharingMapFragment, this.g.get());
        injectImplicitIntentFactory(sharingMapFragment, this.h.get());
        injectSchedulers(sharingMapFragment, this.i.get());
    }
}
