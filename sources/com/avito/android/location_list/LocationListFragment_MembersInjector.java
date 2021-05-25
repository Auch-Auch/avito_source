package com.avito.android.location_list;

import com.avito.android.analytics.Analytics;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class LocationListFragment_MembersInjector implements MembersInjector<LocationListFragment> {
    public final Provider<Analytics> a;
    public final Provider<LocationListInteractor> b;
    public final Provider<LocationListPresenter> c;
    public final Provider<AdapterPresenter> d;
    public final Provider<ItemBinder> e;
    public final Provider<ImplicitIntentFactory> f;
    public final Provider<LocationPermissionDialogPresenter> g;

    public LocationListFragment_MembersInjector(Provider<Analytics> provider, Provider<LocationListInteractor> provider2, Provider<LocationListPresenter> provider3, Provider<AdapterPresenter> provider4, Provider<ItemBinder> provider5, Provider<ImplicitIntentFactory> provider6, Provider<LocationPermissionDialogPresenter> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static MembersInjector<LocationListFragment> create(Provider<Analytics> provider, Provider<LocationListInteractor> provider2, Provider<LocationListPresenter> provider3, Provider<AdapterPresenter> provider4, Provider<ItemBinder> provider5, Provider<ImplicitIntentFactory> provider6, Provider<LocationPermissionDialogPresenter> provider7) {
        return new LocationListFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @InjectedFieldSignature("com.avito.android.location_list.LocationListFragment.adapterPresenter")
    public static void injectAdapterPresenter(LocationListFragment locationListFragment, AdapterPresenter adapterPresenter) {
        locationListFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.location_list.LocationListFragment.analytics")
    public static void injectAnalytics(LocationListFragment locationListFragment, Analytics analytics) {
        locationListFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.location_list.LocationListFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(LocationListFragment locationListFragment, ImplicitIntentFactory implicitIntentFactory) {
        locationListFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.location_list.LocationListFragment.interactor")
    public static void injectInteractor(LocationListFragment locationListFragment, LocationListInteractor locationListInteractor) {
        locationListFragment.interactor = locationListInteractor;
    }

    @InjectedFieldSignature("com.avito.android.location_list.LocationListFragment.itemBinder")
    public static void injectItemBinder(LocationListFragment locationListFragment, ItemBinder itemBinder) {
        locationListFragment.itemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.location_list.LocationListFragment.locationPermissionDialogPresenter")
    public static void injectLocationPermissionDialogPresenter(LocationListFragment locationListFragment, LocationPermissionDialogPresenter locationPermissionDialogPresenter) {
        locationListFragment.locationPermissionDialogPresenter = locationPermissionDialogPresenter;
    }

    @InjectedFieldSignature("com.avito.android.location_list.LocationListFragment.presenter")
    public static void injectPresenter(LocationListFragment locationListFragment, LocationListPresenter locationListPresenter) {
        locationListFragment.presenter = locationListPresenter;
    }

    public void injectMembers(LocationListFragment locationListFragment) {
        injectAnalytics(locationListFragment, this.a.get());
        injectInteractor(locationListFragment, this.b.get());
        injectPresenter(locationListFragment, this.c.get());
        injectAdapterPresenter(locationListFragment, this.d.get());
        injectItemBinder(locationListFragment, this.e.get());
        injectImplicitIntentFactory(locationListFragment, this.f.get());
        injectLocationPermissionDialogPresenter(locationListFragment, this.g.get());
    }
}
