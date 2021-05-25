package com.avito.android.search.filter;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.search.filter.adapter.BubblesSelectItemPresenter;
import com.avito.android.search.filter.groupSelect.GroupSelectDialogFactory;
import com.avito.android.search.filter.tracker.FiltersTracker;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class FiltersFragment_MembersInjector implements MembersInjector<FiltersFragment> {
    public final Provider<FiltersPresenter> a;
    public final Provider<FiltersInteractor> b;
    public final Provider<Features> c;
    public final Provider<SimpleRecyclerAdapter> d;
    public final Provider<ActivityIntentFactory> e;
    public final Provider<MultiselectDialogFactory> f;
    public final Provider<SelectDialogFactory> g;
    public final Provider<GroupSelectDialogFactory> h;
    public final Provider<Analytics> i;
    public final Provider<FiltersTracker> j;
    public final Provider<BubblesSelectItemPresenter> k;
    public final Provider<LocationPermissionDialogPresenter> l;
    public final Provider<ImplicitIntentFactory> m;

    public FiltersFragment_MembersInjector(Provider<FiltersPresenter> provider, Provider<FiltersInteractor> provider2, Provider<Features> provider3, Provider<SimpleRecyclerAdapter> provider4, Provider<ActivityIntentFactory> provider5, Provider<MultiselectDialogFactory> provider6, Provider<SelectDialogFactory> provider7, Provider<GroupSelectDialogFactory> provider8, Provider<Analytics> provider9, Provider<FiltersTracker> provider10, Provider<BubblesSelectItemPresenter> provider11, Provider<LocationPermissionDialogPresenter> provider12, Provider<ImplicitIntentFactory> provider13) {
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
    }

    public static MembersInjector<FiltersFragment> create(Provider<FiltersPresenter> provider, Provider<FiltersInteractor> provider2, Provider<Features> provider3, Provider<SimpleRecyclerAdapter> provider4, Provider<ActivityIntentFactory> provider5, Provider<MultiselectDialogFactory> provider6, Provider<SelectDialogFactory> provider7, Provider<GroupSelectDialogFactory> provider8, Provider<Analytics> provider9, Provider<FiltersTracker> provider10, Provider<BubblesSelectItemPresenter> provider11, Provider<LocationPermissionDialogPresenter> provider12, Provider<ImplicitIntentFactory> provider13) {
        return new FiltersFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    @InjectedFieldSignature("com.avito.android.search.filter.FiltersFragment.analytics")
    public static void injectAnalytics(FiltersFragment filtersFragment, Analytics analytics) {
        filtersFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.search.filter.FiltersFragment.bubblesSelectItemPresenter")
    public static void injectBubblesSelectItemPresenter(FiltersFragment filtersFragment, BubblesSelectItemPresenter bubblesSelectItemPresenter) {
        filtersFragment.bubblesSelectItemPresenter = bubblesSelectItemPresenter;
    }

    @InjectedFieldSignature("com.avito.android.search.filter.FiltersFragment.features")
    public static void injectFeatures(FiltersFragment filtersFragment, Features features) {
        filtersFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.search.filter.FiltersFragment.groupSelectDialogFactory")
    public static void injectGroupSelectDialogFactory(FiltersFragment filtersFragment, GroupSelectDialogFactory groupSelectDialogFactory) {
        filtersFragment.groupSelectDialogFactory = groupSelectDialogFactory;
    }

    @InjectedFieldSignature("com.avito.android.search.filter.FiltersFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(FiltersFragment filtersFragment, ImplicitIntentFactory implicitIntentFactory) {
        filtersFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.search.filter.FiltersFragment.intentFactory")
    public static void injectIntentFactory(FiltersFragment filtersFragment, ActivityIntentFactory activityIntentFactory) {
        filtersFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.search.filter.FiltersFragment.interactor")
    public static void injectInteractor(FiltersFragment filtersFragment, FiltersInteractor filtersInteractor) {
        filtersFragment.interactor = filtersInteractor;
    }

    @InjectedFieldSignature("com.avito.android.search.filter.FiltersFragment.locationPermissionDialogPresenter")
    public static void injectLocationPermissionDialogPresenter(FiltersFragment filtersFragment, LocationPermissionDialogPresenter locationPermissionDialogPresenter) {
        filtersFragment.locationPermissionDialogPresenter = locationPermissionDialogPresenter;
    }

    @InjectedFieldSignature("com.avito.android.search.filter.FiltersFragment.multiselectDialogFactory")
    public static void injectMultiselectDialogFactory(FiltersFragment filtersFragment, MultiselectDialogFactory multiselectDialogFactory) {
        filtersFragment.multiselectDialogFactory = multiselectDialogFactory;
    }

    @InjectedFieldSignature("com.avito.android.search.filter.FiltersFragment.presenter")
    public static void injectPresenter(FiltersFragment filtersFragment, FiltersPresenter filtersPresenter) {
        filtersFragment.presenter = filtersPresenter;
    }

    @InjectedFieldSignature("com.avito.android.search.filter.FiltersFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(FiltersFragment filtersFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        filtersFragment.recyclerAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.search.filter.FiltersFragment.selectDialogFactory")
    public static void injectSelectDialogFactory(FiltersFragment filtersFragment, SelectDialogFactory selectDialogFactory) {
        filtersFragment.selectDialogFactory = selectDialogFactory;
    }

    @InjectedFieldSignature("com.avito.android.search.filter.FiltersFragment.tracker")
    public static void injectTracker(FiltersFragment filtersFragment, FiltersTracker filtersTracker) {
        filtersFragment.tracker = filtersTracker;
    }

    public void injectMembers(FiltersFragment filtersFragment) {
        injectPresenter(filtersFragment, this.a.get());
        injectInteractor(filtersFragment, this.b.get());
        injectFeatures(filtersFragment, this.c.get());
        injectRecyclerAdapter(filtersFragment, this.d.get());
        injectIntentFactory(filtersFragment, this.e.get());
        injectMultiselectDialogFactory(filtersFragment, this.f.get());
        injectSelectDialogFactory(filtersFragment, this.g.get());
        injectGroupSelectDialogFactory(filtersFragment, this.h.get());
        injectAnalytics(filtersFragment, this.i.get());
        injectTracker(filtersFragment, this.j.get());
        injectBubblesSelectItemPresenter(filtersFragment, this.k.get());
        injectLocationPermissionDialogPresenter(filtersFragment, this.l.get());
        injectImplicitIntentFactory(filtersFragment, this.m.get());
    }
}
