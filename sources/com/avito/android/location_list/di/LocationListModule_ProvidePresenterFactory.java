package com.avito.android.location_list.di;

import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.find.FindDetectLocationPresenter;
import com.avito.android.location_list.LocationListInteractor;
import com.avito.android.location_list.LocationListPresenter;
import com.avito.android.location_list.analytics.LocationListAnalyticsInteractor;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class LocationListModule_ProvidePresenterFactory implements Factory<LocationListPresenter> {
    public final LocationListModule a;
    public final Provider<LocationListInteractor> b;
    public final Provider<LocationListAnalyticsInteractor> c;
    public final Provider<SchedulersFactory3> d;
    public final Provider<FindDetectLocationPresenter> e;
    public final Provider<AdapterPresenter> f;
    public final Provider<LocationPermissionDialogPresenter> g;
    public final Provider<LocationAnalyticsInteractor> h;

    public LocationListModule_ProvidePresenterFactory(LocationListModule locationListModule, Provider<LocationListInteractor> provider, Provider<LocationListAnalyticsInteractor> provider2, Provider<SchedulersFactory3> provider3, Provider<FindDetectLocationPresenter> provider4, Provider<AdapterPresenter> provider5, Provider<LocationPermissionDialogPresenter> provider6, Provider<LocationAnalyticsInteractor> provider7) {
        this.a = locationListModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
    }

    public static LocationListModule_ProvidePresenterFactory create(LocationListModule locationListModule, Provider<LocationListInteractor> provider, Provider<LocationListAnalyticsInteractor> provider2, Provider<SchedulersFactory3> provider3, Provider<FindDetectLocationPresenter> provider4, Provider<AdapterPresenter> provider5, Provider<LocationPermissionDialogPresenter> provider6, Provider<LocationAnalyticsInteractor> provider7) {
        return new LocationListModule_ProvidePresenterFactory(locationListModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static LocationListPresenter providePresenter(LocationListModule locationListModule, LocationListInteractor locationListInteractor, LocationListAnalyticsInteractor locationListAnalyticsInteractor, SchedulersFactory3 schedulersFactory3, FindDetectLocationPresenter findDetectLocationPresenter, AdapterPresenter adapterPresenter, LocationPermissionDialogPresenter locationPermissionDialogPresenter, LocationAnalyticsInteractor locationAnalyticsInteractor) {
        return (LocationListPresenter) Preconditions.checkNotNullFromProvides(locationListModule.providePresenter(locationListInteractor, locationListAnalyticsInteractor, schedulersFactory3, findDetectLocationPresenter, adapterPresenter, locationPermissionDialogPresenter, locationAnalyticsInteractor));
    }

    @Override // javax.inject.Provider
    public LocationListPresenter get() {
        return providePresenter(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get());
    }
}
