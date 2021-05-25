package com.avito.android.item_map;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.NotificationCenterIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.google.GoogleAvitoMapAttachHelper;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.item_map.amenity.AmenityButtonsPresenter;
import com.avito.android.item_map.di.DaggerItemMapComponent;
import com.avito.android.item_map.di.ItemMapComponent;
import com.avito.android.item_map.di.ItemMapDependencies;
import com.avito.android.item_map.view.ItemMapPresenter;
import com.avito.android.item_map.view.ItemMapView;
import com.avito.android.item_map.view.ItemMapViewBottomSheetAdapter;
import com.avito.android.item_map.view.ItemMapViewImpl;
import com.avito.android.location.find.FindLocationPresenter;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.GeoReference;
import com.avito.android.ui.ActivityInteractor;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Kundle;
import com.avito.android.util.Logs;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004\u0001\u0001B\b¢\u0006\u0005\b\u0001\u0010\u0016J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u0016J\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u0016J\u000f\u0010\u001b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001b\u0010\u0016J\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\nJ\u000f\u0010\u001e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\u0016J\u000f\u0010\u001f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010\u0016J\u0019\u0010\"\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\bH\u0016¢\u0006\u0004\b$\u0010\u0016J\u000f\u0010%\u001a\u00020\bH\u0016¢\u0006\u0004\b%\u0010\u0016J\u0017\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0006@\u0006X.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u0002088\u0006@\u0006X.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010@\u001a\u00020?8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER(\u0010H\u001a\b\u0012\u0004\u0012\u00020G0F8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010O\u001a\u00020N8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\"\u0010Z\u001a\u00020Y8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010a\u001a\u00020`8\u0006@\u0006X.¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u0010n\u001a\u00020g8\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010p\u001a\u00020o8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\"\u0010w\u001a\u00020v8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R&\u0010~\u001a\u00020}8\u0006@\u0006X.¢\u0006\u0016\n\u0004\b~\u0010\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/item_map/ItemMapFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/ui/ActivityInteractor;", "Lcom/avito/android/item_map/view/ItemMapPresenter$Router;", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Subscriber;", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onResume", "onPause", "finishScreen", "onDestroyView", "outState", "onSaveInstanceState", "findLocation", "onClickLocationSnackbar", "", "error", "onLocationNotFound", "(Ljava/lang/String;)V", "onNotPermissionGranted", "openOsmUrl", "Lcom/avito/android/avito_map/AvitoMapPoint;", "itemCoordinates", "createRoute", "(Lcom/avito/android/avito_map/AvitoMapPoint;)V", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "mapAttachHelper", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "getMapAttachHelper", "()Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "setMapAttachHelper", "(Lcom/avito/android/avito_map/AvitoMapAttachHelper;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/location/find/FindLocationPresenter;", "findLocationPresenter", "Lcom/avito/android/location/find/FindLocationPresenter;", "getFindLocationPresenter", "()Lcom/avito/android/location/find/FindLocationPresenter;", "setFindLocationPresenter", "(Lcom/avito/android/location/find/FindLocationPresenter;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getItemAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setItemAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "locationPermissionDialogPresenter", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "getLocationPermissionDialogPresenter", "()Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "setLocationPermissionDialogPresenter", "(Lcom/avito/android/permissions/LocationPermissionDialogPresenter;)V", "Lcom/avito/android/item_map/view/ItemMapViewImpl;", "k", "Lcom/avito/android/item_map/view/ItemMapViewImpl;", "itemMapViewImpl", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "l", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", "Lcom/avito/android/item_map/view/ItemMapPresenter;", "presenter", "Lcom/avito/android/item_map/view/ItemMapPresenter;", "getPresenter", "()Lcom/avito/android/item_map/view/ItemMapPresenter;", "setPresenter", "(Lcom/avito/android/item_map/view/ItemMapPresenter;)V", "Lcom/avito/android/item_map/amenity/AmenityButtonsPresenter;", "amenityPresenter", "Lcom/avito/android/item_map/amenity/AmenityButtonsPresenter;", "getAmenityPresenter", "()Lcom/avito/android/item_map/amenity/AmenityButtonsPresenter;", "setAmenityPresenter", "(Lcom/avito/android/item_map/amenity/AmenityButtonsPresenter;)V", "Lcom/avito/android/analytics/grafana/GraphitePrefix;", "graphitePrefix", "Lcom/avito/android/analytics/grafana/GraphitePrefix;", "getGraphitePrefix", "()Lcom/avito/android/analytics/grafana/GraphitePrefix;", "setGraphitePrefix", "(Lcom/avito/android/analytics/grafana/GraphitePrefix;)V", "Lcom/avito/android/item_map/view/ItemMapView$ItemMapState;", "j", "Lcom/avito/android/item_map/view/ItemMapView$ItemMapState;", "state", "<init>", "Companion", "StoreFragment", "item-map_release"}, k = 1, mv = {1, 4, 2})
public final class ItemMapFragment extends TabBaseFragment implements ActivityInteractor, ItemMapPresenter.Router, LocationPermissionDialogPresenter.Subscriber, LocationPermissionDialogPresenter.Router {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public AmenityButtonsPresenter amenityPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public Features features;
    @Inject
    public FindLocationPresenter findLocationPresenter;
    @Inject
    public GraphitePrefix graphitePrefix;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public RecyclerView.Adapter<RecyclerView.ViewHolder> itemAdapter;
    public ItemMapView.ItemMapState j = new ItemMapView.ItemMapState(null, false, null, null, null, 0.0f, null, null, false, false, false, null, 4095, null);
    public ItemMapViewImpl k;
    @NotNull
    public NavigationState l = new NavigationState(false);
    @Inject
    public LocationPermissionDialogPresenter locationPermissionDialogPresenter;
    @Inject
    public AvitoMapAttachHelper mapAttachHelper;
    @Inject
    public ItemMapPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/item_map/ItemMapFragment$Companion;", "", "Lcom/avito/android/item_map/ItemMapArguments;", "args", "Lcom/avito/android/item_map/ItemMapFragment;", "newInstance", "(Lcom/avito/android/item_map/ItemMapArguments;)Lcom/avito/android/item_map/ItemMapFragment;", "<init>", "()V", "item-map_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final ItemMapFragment newInstance(@NotNull ItemMapArguments itemMapArguments) {
            Intrinsics.checkNotNullParameter(itemMapArguments, "args");
            ItemMapFragment itemMapFragment = new ItemMapFragment();
            Bundle bundle = new Bundle(1);
            bundle.putParcelable(ItemMapActivityKt.EXTRA_ITEM_MAP_ARGS, ItemMapFragment.access$toState(itemMapFragment, itemMapArguments));
            Unit unit = Unit.INSTANCE;
            itemMapFragment.setArguments(bundle);
            return itemMapFragment;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/item_map/ItemMapFragment$StoreFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/avito/android/item_map/view/ItemMapView$ItemMapState;", AuthSource.SEND_ABUSE, "Lcom/avito/android/item_map/view/ItemMapView$ItemMapState;", "getItemMapState$item_map_release", "()Lcom/avito/android/item_map/view/ItemMapView$ItemMapState;", "setItemMapState$item_map_release", "(Lcom/avito/android/item_map/view/ItemMapView$ItemMapState;)V", "itemMapState", "Lcom/avito/android/util/Kundle;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/Kundle;", "getAmenityState$item_map_release", "()Lcom/avito/android/util/Kundle;", "setAmenityState$item_map_release", "(Lcom/avito/android/util/Kundle;)V", "amenityState", "<init>", "()V", "item-map_release"}, k = 1, mv = {1, 4, 2})
    public static final class StoreFragment extends Fragment {
        @Nullable
        public ItemMapView.ItemMapState a;
        @Nullable
        public Kundle b;

        @Nullable
        public final Kundle getAmenityState$item_map_release() {
            return this.b;
        }

        @Nullable
        public final ItemMapView.ItemMapState getItemMapState$item_map_release() {
            return this.a;
        }

        @Override // androidx.fragment.app.Fragment
        public void onCreate(@Nullable Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
        }

        public final void setAmenityState$item_map_release(@Nullable Kundle kundle) {
            this.b = kundle;
        }

        public final void setItemMapState$item_map_release(@Nullable ItemMapView.ItemMapState itemMapState) {
            this.a = itemMapState;
        }
    }

    public static final ItemMapView.ItemMapState access$toState(ItemMapFragment itemMapFragment, ItemMapArguments itemMapArguments) {
        Objects.requireNonNull(itemMapFragment);
        Coordinates itemCoordinates = itemMapArguments.getItemCoordinates();
        ItemMapView.BottomSheetState bottomSheetState = null;
        AvitoMapPoint avitoMapPoint = itemCoordinates != null ? new AvitoMapPoint(itemCoordinates.getLatitude(), itemCoordinates.getLongitude()) : null;
        boolean hasFindMeButton = itemMapArguments.getHasFindMeButton();
        Coordinates myCoordinates = itemMapArguments.getMyCoordinates();
        AvitoMapPoint avitoMapPoint2 = myCoordinates != null ? new AvitoMapPoint(myCoordinates.getLatitude(), myCoordinates.getLongitude()) : null;
        String title = itemMapArguments.getTitle();
        if (itemMapArguments.getHasBottomSheet()) {
            String address = itemMapArguments.getAddress();
            if (address == null) {
                address = "";
            }
            List<GeoReference> geoReference = itemMapArguments.getGeoReference();
            if (geoReference == null) {
                geoReference = CollectionsKt__CollectionsKt.emptyList();
            }
            bottomSheetState = new ItemMapView.BottomSheetState(address, geoReference, 3);
        }
        return new ItemMapView.ItemMapState(avitoMapPoint, hasFindMeButton, avitoMapPoint2, title, bottomSheetState, 0.0f, null, new ItemMapView.AmenityButtonsState(itemMapArguments.getItemId(), itemMapArguments.getAmenityButtons()), itemMapArguments.getShowMeOnMap(), itemMapArguments.getHasCreateRouteButton(), itemMapArguments.getShouldTrackMapMovement(), itemMapArguments.getFromPage(), 96, null);
    }

    @Override // com.avito.android.item_map.view.ItemMapPresenter.Router
    public void createRoute(@NotNull AvitoMapPoint avitoMapPoint) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "itemCoordinates");
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=" + avitoMapPoint.getLatitude() + ',' + avitoMapPoint.getLongitude())));
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter.Router
    public void findLocation() {
        ItemMapPresenter itemMapPresenter = this.presenter;
        if (itemMapPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        itemMapPresenter.subscribeFindLocation(requireActivity);
    }

    @Override // com.avito.android.item_map.view.ItemMapPresenter.Router
    public void finishScreen() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (!features2.getItemMapWithoutActivity().invoke().booleanValue() || (getActivity() instanceof ItemMapActivity)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        finish();
    }

    @NotNull
    public final AmenityButtonsPresenter getAmenityPresenter() {
        AmenityButtonsPresenter amenityButtonsPresenter = this.amenityPresenter;
        if (amenityButtonsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("amenityPresenter");
        }
        return amenityButtonsPresenter;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final FindLocationPresenter getFindLocationPresenter() {
        FindLocationPresenter findLocationPresenter2 = this.findLocationPresenter;
        if (findLocationPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("findLocationPresenter");
        }
        return findLocationPresenter2;
    }

    @NotNull
    public final GraphitePrefix getGraphitePrefix() {
        GraphitePrefix graphitePrefix2 = this.graphitePrefix;
        if (graphitePrefix2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("graphitePrefix");
        }
        return graphitePrefix2;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    @NotNull
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> getItemAdapter() {
        RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = this.itemAdapter;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
        }
        return adapter;
    }

    @NotNull
    public final LocationPermissionDialogPresenter getLocationPermissionDialogPresenter() {
        LocationPermissionDialogPresenter locationPermissionDialogPresenter2 = this.locationPermissionDialogPresenter;
        if (locationPermissionDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
        }
        return locationPermissionDialogPresenter2;
    }

    @NotNull
    public final AvitoMapAttachHelper getMapAttachHelper() {
        AvitoMapAttachHelper avitoMapAttachHelper = this.mapAttachHelper;
        if (avitoMapAttachHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapAttachHelper");
        }
        return avitoMapAttachHelper;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    @NotNull
    public NavigationState getNavigationState() {
        return this.l;
    }

    @NotNull
    public final ItemMapPresenter getPresenter() {
        ItemMapPresenter itemMapPresenter = this.presenter;
        if (itemMapPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return itemMapPresenter;
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter.Subscriber
    public void onClickLocationSnackbar() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        startActivity(implicitIntentFactory2.createAppSettingsIntent());
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        ItemMapView.ItemMapState itemMapState;
        super.onCreate(bundle);
        StoreFragment storeFragment = (StoreFragment) getChildFragmentManager().findFragmentByTag("store_fragment");
        if (storeFragment == null) {
            getChildFragmentManager().beginTransaction().add(new StoreFragment(), "store_fragment").commit();
        }
        Kundle kundle = null;
        if (storeFragment == null || (itemMapState = storeFragment.getItemMapState$item_map_release()) == null) {
            Bundle arguments = getArguments();
            itemMapState = arguments != null ? (ItemMapView.ItemMapState) arguments.getParcelable(ItemMapActivityKt.EXTRA_ITEM_MAP_ARGS) : null;
        }
        if (itemMapState != null) {
            this.j = itemMapState;
            if (storeFragment != null) {
                kundle = storeFragment.getAmenityState$item_map_release();
            }
            ItemMapComponent.Builder withFragment = DaggerItemMapComponent.builder().dependencies((ItemMapDependencies) ComponentDependenciesKt.getDependencies(ItemMapDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).savedState(this.j).withActivityInteractor(this).withFragment(this);
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            ItemMapComponent.Builder savedAmenityState = withFragment.withActivity(requireActivity).savedAmenityState(kundle);
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            ItemMapComponent.Builder context = savedAmenityState.context(requireContext);
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            context.resources(resources).build().inject(this);
            return;
        }
        throw new IllegalArgumentException("State not provided");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.item_map_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = this.itemAdapter;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
        }
        Objects.requireNonNull(adapter, "null cannot be cast to non-null type com.avito.android.item_map.view.ItemMapViewBottomSheetAdapter");
        ItemMapViewImpl itemMapViewImpl = new ItemMapViewImpl(inflate, (ItemMapViewBottomSheetAdapter) adapter, this.j);
        this.k = itemMapViewImpl;
        if (itemMapViewImpl != null) {
            AvitoMapAttachHelper avitoMapAttachHelper = this.mapAttachHelper;
            if (avitoMapAttachHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mapAttachHelper");
            }
            avitoMapAttachHelper.setMapAttachedListener(itemMapViewImpl);
            ItemMapPresenter itemMapPresenter = this.presenter;
            if (itemMapPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            itemMapPresenter.attachView(itemMapViewImpl);
            AmenityButtonsPresenter amenityButtonsPresenter = this.amenityPresenter;
            if (amenityButtonsPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("amenityPresenter");
            }
            amenityButtonsPresenter.attachMapView(itemMapViewImpl);
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        AmenityButtonsPresenter amenityButtonsPresenter = this.amenityPresenter;
        if (amenityButtonsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("amenityPresenter");
        }
        amenityButtonsPresenter.detachViews();
        ItemMapPresenter itemMapPresenter = this.presenter;
        if (itemMapPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        itemMapPresenter.detachView();
        ItemMapPresenter itemMapPresenter2 = this.presenter;
        if (itemMapPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        itemMapPresenter2.onDestroyMap();
        super.onDestroyView();
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter.Subscriber
    public void onLocationNotFound(@Nullable String str) {
        ItemMapPresenter itemMapPresenter = this.presenter;
        if (itemMapPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        itemMapPresenter.findLocationError(str);
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter.Subscriber
    public void onNotPermissionGranted() {
        ItemMapPresenter itemMapPresenter = this.presenter;
        if (itemMapPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        itemMapPresenter.subscribeOnNotPermissionGranted();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        if (this.j.getShowMeOnMap()) {
            FindLocationPresenter findLocationPresenter2 = this.findLocationPresenter;
            if (findLocationPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("findLocationPresenter");
            }
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            findLocationPresenter2.unregisterLocationReceiver(requireContext);
        }
        ItemMapPresenter itemMapPresenter = this.presenter;
        if (itemMapPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        itemMapPresenter.sendScreenExitAfterCoordinatesResolve();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.j.getShowMeOnMap()) {
            FindLocationPresenter findLocationPresenter2 = this.findLocationPresenter;
            if (findLocationPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("findLocationPresenter");
            }
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            findLocationPresenter2.registerLocationReceiver(requireContext);
        }
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        StoreFragment storeFragment = (StoreFragment) getChildFragmentManager().findFragmentByTag("store_fragment");
        if (storeFragment != null) {
            ItemMapPresenter itemMapPresenter = this.presenter;
            if (itemMapPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            storeFragment.setItemMapState$item_map_release(itemMapPresenter.onSaveState());
            AmenityButtonsPresenter amenityButtonsPresenter = this.amenityPresenter;
            if (amenityButtonsPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("amenityPresenter");
            }
            storeFragment.setAmenityState$item_map_release(amenityButtonsPresenter.onSaveState());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        LocationPermissionDialogPresenter locationPermissionDialogPresenter2 = this.locationPermissionDialogPresenter;
        if (locationPermissionDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
        }
        locationPermissionDialogPresenter2.attachRouter(this);
        LocationPermissionDialogPresenter locationPermissionDialogPresenter3 = this.locationPermissionDialogPresenter;
        if (locationPermissionDialogPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
        }
        locationPermissionDialogPresenter3.setSubscriber(this);
        ItemMapPresenter itemMapPresenter = this.presenter;
        if (itemMapPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        itemMapPresenter.attachRouter(this);
        ItemMapPresenter itemMapPresenter2 = this.presenter;
        if (itemMapPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        itemMapPresenter2.onStartMap();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        LocationPermissionDialogPresenter locationPermissionDialogPresenter2 = this.locationPermissionDialogPresenter;
        if (locationPermissionDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
        }
        locationPermissionDialogPresenter2.detachRouter();
        LocationPermissionDialogPresenter locationPermissionDialogPresenter3 = this.locationPermissionDialogPresenter;
        if (locationPermissionDialogPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
        }
        locationPermissionDialogPresenter3.detachSubscriber();
        ItemMapPresenter itemMapPresenter = this.presenter;
        if (itemMapPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        itemMapPresenter.detachRouter();
        ItemMapPresenter itemMapPresenter2 = this.presenter;
        if (itemMapPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        itemMapPresenter2.onStopMap();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        try {
            AvitoMapAttachHelper avitoMapAttachHelper = this.mapAttachHelper;
            if (avitoMapAttachHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mapAttachHelper");
            }
            int i = R.id.map;
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            avitoMapAttachHelper.attachView(i, view, childFragmentManager);
        } catch (Exception e) {
            StringBuilder L = a.L("Can't init yandex maps due to ");
            L.append(e.getLocalizedMessage());
            Logs.error$default(L.toString(), null, 2, null);
            ItemMapViewImpl itemMapViewImpl = this.k;
            if (itemMapViewImpl != null) {
                GoogleAvitoMapAttachHelper googleAvitoMapAttachHelper = new GoogleAvitoMapAttachHelper();
                this.mapAttachHelper = googleAvitoMapAttachHelper;
                if (googleAvitoMapAttachHelper == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mapAttachHelper");
                }
                googleAvitoMapAttachHelper.setMapAttachedListener(itemMapViewImpl);
                AvitoMapAttachHelper avitoMapAttachHelper2 = this.mapAttachHelper;
                if (avitoMapAttachHelper2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mapAttachHelper");
                }
                int i2 = R.id.map;
                FragmentManager childFragmentManager2 = getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "childFragmentManager");
                avitoMapAttachHelper2.attachView(i2, view, childFragmentManager2);
            }
        }
    }

    @Override // com.avito.android.item_map.view.ItemMapPresenter.Router
    public void openOsmUrl() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        Uri parse = Uri.parse(getString(R.string.osm_url));
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(getString(R.string.osm_url))");
        startActivity(NotificationCenterIntentFactory.DefaultImpls.promoIntent$default(activityIntentFactory, parse, false, false, 6, null));
    }

    public final void setAmenityPresenter(@NotNull AmenityButtonsPresenter amenityButtonsPresenter) {
        Intrinsics.checkNotNullParameter(amenityButtonsPresenter, "<set-?>");
        this.amenityPresenter = amenityButtonsPresenter;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setFindLocationPresenter(@NotNull FindLocationPresenter findLocationPresenter2) {
        Intrinsics.checkNotNullParameter(findLocationPresenter2, "<set-?>");
        this.findLocationPresenter = findLocationPresenter2;
    }

    public final void setGraphitePrefix(@NotNull GraphitePrefix graphitePrefix2) {
        Intrinsics.checkNotNullParameter(graphitePrefix2, "<set-?>");
        this.graphitePrefix = graphitePrefix2;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setItemAdapter(@NotNull RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "<set-?>");
        this.itemAdapter = adapter;
    }

    public final void setLocationPermissionDialogPresenter(@NotNull LocationPermissionDialogPresenter locationPermissionDialogPresenter2) {
        Intrinsics.checkNotNullParameter(locationPermissionDialogPresenter2, "<set-?>");
        this.locationPermissionDialogPresenter = locationPermissionDialogPresenter2;
    }

    public final void setMapAttachHelper(@NotNull AvitoMapAttachHelper avitoMapAttachHelper) {
        Intrinsics.checkNotNullParameter(avitoMapAttachHelper, "<set-?>");
        this.mapAttachHelper = avitoMapAttachHelper;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    public void setNavigationState(@NotNull NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(navigationState, "<set-?>");
        this.l = navigationState;
    }

    public final void setPresenter(@NotNull ItemMapPresenter itemMapPresenter) {
        Intrinsics.checkNotNullParameter(itemMapPresenter, "<set-?>");
        this.presenter = itemMapPresenter;
    }
}
