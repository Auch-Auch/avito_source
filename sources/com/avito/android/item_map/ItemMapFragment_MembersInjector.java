package com.avito.android.item_map;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.item_map.amenity.AmenityButtonsPresenter;
import com.avito.android.item_map.view.ItemMapPresenter;
import com.avito.android.location.find.FindLocationPresenter;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ItemMapFragment_MembersInjector implements MembersInjector<ItemMapFragment> {
    public final Provider<ItemMapPresenter> a;
    public final Provider<AmenityButtonsPresenter> b;
    public final Provider<AvitoMapAttachHelper> c;
    public final Provider<Analytics> d;
    public final Provider<GraphitePrefix> e;
    public final Provider<RecyclerView.Adapter<RecyclerView.ViewHolder>> f;
    public final Provider<Features> g;
    public final Provider<ActivityIntentFactory> h;
    public final Provider<FindLocationPresenter> i;
    public final Provider<LocationPermissionDialogPresenter> j;
    public final Provider<ImplicitIntentFactory> k;

    public ItemMapFragment_MembersInjector(Provider<ItemMapPresenter> provider, Provider<AmenityButtonsPresenter> provider2, Provider<AvitoMapAttachHelper> provider3, Provider<Analytics> provider4, Provider<GraphitePrefix> provider5, Provider<RecyclerView.Adapter<RecyclerView.ViewHolder>> provider6, Provider<Features> provider7, Provider<ActivityIntentFactory> provider8, Provider<FindLocationPresenter> provider9, Provider<LocationPermissionDialogPresenter> provider10, Provider<ImplicitIntentFactory> provider11) {
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
    }

    public static MembersInjector<ItemMapFragment> create(Provider<ItemMapPresenter> provider, Provider<AmenityButtonsPresenter> provider2, Provider<AvitoMapAttachHelper> provider3, Provider<Analytics> provider4, Provider<GraphitePrefix> provider5, Provider<RecyclerView.Adapter<RecyclerView.ViewHolder>> provider6, Provider<Features> provider7, Provider<ActivityIntentFactory> provider8, Provider<FindLocationPresenter> provider9, Provider<LocationPermissionDialogPresenter> provider10, Provider<ImplicitIntentFactory> provider11) {
        return new ItemMapFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    @InjectedFieldSignature("com.avito.android.item_map.ItemMapFragment.amenityPresenter")
    public static void injectAmenityPresenter(ItemMapFragment itemMapFragment, AmenityButtonsPresenter amenityButtonsPresenter) {
        itemMapFragment.amenityPresenter = amenityButtonsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.item_map.ItemMapFragment.analytics")
    public static void injectAnalytics(ItemMapFragment itemMapFragment, Analytics analytics) {
        itemMapFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.item_map.ItemMapFragment.features")
    public static void injectFeatures(ItemMapFragment itemMapFragment, Features features) {
        itemMapFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.item_map.ItemMapFragment.findLocationPresenter")
    public static void injectFindLocationPresenter(ItemMapFragment itemMapFragment, FindLocationPresenter findLocationPresenter) {
        itemMapFragment.findLocationPresenter = findLocationPresenter;
    }

    @InjectedFieldSignature("com.avito.android.item_map.ItemMapFragment.graphitePrefix")
    public static void injectGraphitePrefix(ItemMapFragment itemMapFragment, GraphitePrefix graphitePrefix) {
        itemMapFragment.graphitePrefix = graphitePrefix;
    }

    @InjectedFieldSignature("com.avito.android.item_map.ItemMapFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(ItemMapFragment itemMapFragment, ImplicitIntentFactory implicitIntentFactory) {
        itemMapFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.item_map.ItemMapFragment.intentFactory")
    public static void injectIntentFactory(ItemMapFragment itemMapFragment, ActivityIntentFactory activityIntentFactory) {
        itemMapFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.item_map.ItemMapFragment.itemAdapter")
    public static void injectItemAdapter(ItemMapFragment itemMapFragment, RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        itemMapFragment.itemAdapter = adapter;
    }

    @InjectedFieldSignature("com.avito.android.item_map.ItemMapFragment.locationPermissionDialogPresenter")
    public static void injectLocationPermissionDialogPresenter(ItemMapFragment itemMapFragment, LocationPermissionDialogPresenter locationPermissionDialogPresenter) {
        itemMapFragment.locationPermissionDialogPresenter = locationPermissionDialogPresenter;
    }

    @InjectedFieldSignature("com.avito.android.item_map.ItemMapFragment.mapAttachHelper")
    public static void injectMapAttachHelper(ItemMapFragment itemMapFragment, AvitoMapAttachHelper avitoMapAttachHelper) {
        itemMapFragment.mapAttachHelper = avitoMapAttachHelper;
    }

    @InjectedFieldSignature("com.avito.android.item_map.ItemMapFragment.presenter")
    public static void injectPresenter(ItemMapFragment itemMapFragment, ItemMapPresenter itemMapPresenter) {
        itemMapFragment.presenter = itemMapPresenter;
    }

    public void injectMembers(ItemMapFragment itemMapFragment) {
        injectPresenter(itemMapFragment, this.a.get());
        injectAmenityPresenter(itemMapFragment, this.b.get());
        injectMapAttachHelper(itemMapFragment, this.c.get());
        injectAnalytics(itemMapFragment, this.d.get());
        injectGraphitePrefix(itemMapFragment, this.e.get());
        injectItemAdapter(itemMapFragment, this.f.get());
        injectFeatures(itemMapFragment, this.g.get());
        injectIntentFactory(itemMapFragment, this.h.get());
        injectFindLocationPresenter(itemMapFragment, this.i.get());
        injectLocationPermissionDialogPresenter(itemMapFragment, this.j.get());
        injectImplicitIntentFactory(itemMapFragment, this.k.get());
    }
}
