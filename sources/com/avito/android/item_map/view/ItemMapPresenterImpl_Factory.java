package com.avito.android.item_map.view;

import com.avito.android.analytics.Analytics;
import com.avito.android.item_map.view.ItemMapView;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.find.FindLocationPresenter;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ItemMapPresenterImpl_Factory implements Factory<ItemMapPresenterImpl> {
    public final Provider<ItemMapView.ItemMapState> a;
    public final Provider<ItemMapResourceProvider> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<Analytics> d;
    public final Provider<LocationPermissionDialogPresenter> e;
    public final Provider<FindLocationPresenter> f;
    public final Provider<LocationAnalyticsInteractor> g;

    public ItemMapPresenterImpl_Factory(Provider<ItemMapView.ItemMapState> provider, Provider<ItemMapResourceProvider> provider2, Provider<SchedulersFactory3> provider3, Provider<Analytics> provider4, Provider<LocationPermissionDialogPresenter> provider5, Provider<FindLocationPresenter> provider6, Provider<LocationAnalyticsInteractor> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static ItemMapPresenterImpl_Factory create(Provider<ItemMapView.ItemMapState> provider, Provider<ItemMapResourceProvider> provider2, Provider<SchedulersFactory3> provider3, Provider<Analytics> provider4, Provider<LocationPermissionDialogPresenter> provider5, Provider<FindLocationPresenter> provider6, Provider<LocationAnalyticsInteractor> provider7) {
        return new ItemMapPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static ItemMapPresenterImpl newInstance(ItemMapView.ItemMapState itemMapState, ItemMapResourceProvider itemMapResourceProvider, SchedulersFactory3 schedulersFactory3, Analytics analytics, LocationPermissionDialogPresenter locationPermissionDialogPresenter, FindLocationPresenter findLocationPresenter, LocationAnalyticsInteractor locationAnalyticsInteractor) {
        return new ItemMapPresenterImpl(itemMapState, itemMapResourceProvider, schedulersFactory3, analytics, locationPermissionDialogPresenter, findLocationPresenter, locationAnalyticsInteractor);
    }

    @Override // javax.inject.Provider
    public ItemMapPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
