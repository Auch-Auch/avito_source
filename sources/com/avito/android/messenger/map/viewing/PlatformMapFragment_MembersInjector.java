package com.avito.android.messenger.map.viewing;

import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.find.FindLocationPresenter;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.map.viewing.view.PlatformMapView;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SchedulersFactory3;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PlatformMapFragment_MembersInjector implements MembersInjector<PlatformMapFragment> {
    public final Provider<PlatformMapView> a;
    public final Provider<ViewModelFactory> b;
    public final Provider<ImplicitIntentFactory> c;
    public final Provider<DeepLinkIntentFactory> d;
    public final Provider<PlatformMapPresenter> e;
    public final Provider<LocationPermissionDialogPresenter> f;
    public final Provider<FindLocationPresenter> g;
    public final Provider<LocationAnalyticsInteractor> h;
    public final Provider<SchedulersFactory3> i;

    public PlatformMapFragment_MembersInjector(Provider<PlatformMapView> provider, Provider<ViewModelFactory> provider2, Provider<ImplicitIntentFactory> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<PlatformMapPresenter> provider5, Provider<LocationPermissionDialogPresenter> provider6, Provider<FindLocationPresenter> provider7, Provider<LocationAnalyticsInteractor> provider8, Provider<SchedulersFactory3> provider9) {
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

    public static MembersInjector<PlatformMapFragment> create(Provider<PlatformMapView> provider, Provider<ViewModelFactory> provider2, Provider<ImplicitIntentFactory> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<PlatformMapPresenter> provider5, Provider<LocationPermissionDialogPresenter> provider6, Provider<FindLocationPresenter> provider7, Provider<LocationAnalyticsInteractor> provider8, Provider<SchedulersFactory3> provider9) {
        return new PlatformMapFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @InjectedFieldSignature("com.avito.android.messenger.map.viewing.PlatformMapFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(PlatformMapFragment platformMapFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        platformMapFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.messenger.map.viewing.PlatformMapFragment.findLocationPresenter")
    public static void injectFindLocationPresenter(PlatformMapFragment platformMapFragment, FindLocationPresenter findLocationPresenter) {
        platformMapFragment.findLocationPresenter = findLocationPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.map.viewing.PlatformMapFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(PlatformMapFragment platformMapFragment, ImplicitIntentFactory implicitIntentFactory) {
        platformMapFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.messenger.map.viewing.PlatformMapFragment.locationAnalyticsInteractor")
    public static void injectLocationAnalyticsInteractor(PlatformMapFragment platformMapFragment, LocationAnalyticsInteractor locationAnalyticsInteractor) {
        platformMapFragment.locationAnalyticsInteractor = locationAnalyticsInteractor;
    }

    @InjectedFieldSignature("com.avito.android.messenger.map.viewing.PlatformMapFragment.locationPermissionDialogPresenter")
    public static void injectLocationPermissionDialogPresenter(PlatformMapFragment platformMapFragment, LocationPermissionDialogPresenter locationPermissionDialogPresenter) {
        platformMapFragment.locationPermissionDialogPresenter = locationPermissionDialogPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.map.viewing.PlatformMapFragment.mapView")
    public static void injectMapView(PlatformMapFragment platformMapFragment, PlatformMapView platformMapView) {
        platformMapFragment.mapView = platformMapView;
    }

    @InjectedFieldSignature("com.avito.android.messenger.map.viewing.PlatformMapFragment.presenter")
    public static void injectPresenter(PlatformMapFragment platformMapFragment, PlatformMapPresenter platformMapPresenter) {
        platformMapFragment.presenter = platformMapPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.map.viewing.PlatformMapFragment.schedulers")
    public static void injectSchedulers(PlatformMapFragment platformMapFragment, SchedulersFactory3 schedulersFactory3) {
        platformMapFragment.schedulers = schedulersFactory3;
    }

    @InjectedFieldSignature("com.avito.android.messenger.map.viewing.PlatformMapFragment.viewModelFactory")
    public static void injectViewModelFactory(PlatformMapFragment platformMapFragment, ViewModelFactory viewModelFactory) {
        platformMapFragment.viewModelFactory = viewModelFactory;
    }

    public void injectMembers(PlatformMapFragment platformMapFragment) {
        injectMapView(platformMapFragment, this.a.get());
        injectViewModelFactory(platformMapFragment, this.b.get());
        injectImplicitIntentFactory(platformMapFragment, this.c.get());
        injectDeepLinkIntentFactory(platformMapFragment, this.d.get());
        injectPresenter(platformMapFragment, this.e.get());
        injectLocationPermissionDialogPresenter(platformMapFragment, this.f.get());
        injectFindLocationPresenter(platformMapFragment, this.g.get());
        injectLocationAnalyticsInteractor(platformMapFragment, this.h.get());
        injectSchedulers(platformMapFragment, this.i.get());
    }
}
