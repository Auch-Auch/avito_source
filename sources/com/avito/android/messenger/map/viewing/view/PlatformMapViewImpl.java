package com.avito.android.messenger.map.viewing.view;

import a2.g.r.g;
import android.content.Context;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentManager;
import com.avito.android.avito_map.AvitoMap;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.avito_map.AvitoMapBoundsBuilder;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.avito_map.AvitoMapMoveReason;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.AvitoMapUiSettings;
import com.avito.android.avito_map.PointsWithOffset;
import com.avito.android.avito_map.clustering.Cluster;
import com.avito.android.avito_map.clustering.ClusterItem;
import com.avito.android.avito_map.clustering.ClusterManager;
import com.avito.android.avito_map.clustering.view.ClusterRenderer;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.common.v2.Renderer;
import com.avito.android.messenger.map.MapBottomSheet;
import com.avito.android.messenger.map.MapBottomSheetImpl;
import com.avito.android.messenger.map.viewing.view.PlatformMapView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BackingField;
import com.avito.android.util.Logs;
import com.avito.android.util.ToastsKt;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jakewharton.rxrelay3.BehaviorRelay;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.bottom_sheet.BottomSheet;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B+\b\u0007\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\b\b\u0002\u0010y\u001a\u00020\u001a\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010l\u001a\u00020i¢\u0006\u0004\bz\u0010{J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\f\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\tH\u0017¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u000fJ!\u0010\u0017\u001a\u00020\u00052\b\b\u0001\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\"\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0005058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\"\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b;\u0010\u001c\u001a\u0004\b<\u0010=R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020?0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010%R\u0016\u0010C\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u00103R\"\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00050\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bD\u0010%\u001a\u0004\bE\u0010FR9\u0010O\u001a\u0004\u0018\u00010\t*\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010H\u001a\u0004\u0018\u00010\t8V@VX\u0002¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00050\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bP\u0010%\u001a\u0004\bQ\u0010FR\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020#0S8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u00100R\u0016\u0010b\u001a\u00020_8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b`\u0010aR\u001c\u0010e\u001a\b\u0012\u0004\u0012\u00020c058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bd\u00109R\"\u0010h\u001a\b\u0012\u0004\u0012\u00020?0\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bf\u0010%\u001a\u0004\bg\u0010FR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\"\u0010s\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bq\u0010%\u001a\u0004\br\u0010FR\u001e\u0010x\u001a\n u*\u0004\u0018\u00010t0t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bv\u0010w¨\u0006|"}, d2 = {"Lcom/avito/android/messenger/map/viewing/view/PlatformMapViewImpl;", "Lcom/avito/android/messenger/map/viewing/view/PlatformMapView;", "Lcom/avito/android/avito_map/AvitoMapAttachHelper$MapAttachListener;", "Lcom/avito/android/avito_map/AvitoMap;", "map", "", "onMapAttach", "(Lcom/avito/android/avito_map/AvitoMap;)V", "Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;", "Lcom/avito/android/messenger/map/viewing/view/PlatformMapView$State;", "prevState", "curState", "doRender", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;Lcom/avito/android/messenger/map/viewing/view/PlatformMapView$State;Lcom/avito/android/messenger/map/viewing/view/PlatformMapView$State;)V", "onStart", "()V", "onStop", "onDestroy", "onLowMemory", "showFindLocationError", "", "stringId", "duration", "showError", "(II)V", "Lcom/jakewharton/rxrelay3/BehaviorRelay;", "", g.a, "Lcom/jakewharton/rxrelay3/BehaviorRelay;", "mapIsReadyRelay", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/View;", "rootView", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/messenger/map/viewing/view/Pin;", "i", "Lcom/jakewharton/rxrelay3/PublishRelay;", "pinClicksRelay", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "w", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "mapAttachHelper", "Lcom/avito/android/avito_map/AvitoMapMarker;", "t", "Lcom/avito/android/avito_map/AvitoMapMarker;", "userLocationMarker", "u", "Z", "ignoreOnCameraIdleEvent", "r", "I", "mapCenterOffset", "Lio/reactivex/rxjava3/core/Observable;", "p", "Lio/reactivex/rxjava3/core/Observable;", "getCreateRouteButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "createRouteButtonClicks", "h", "getMapIsReady", "()Lcom/jakewharton/rxrelay3/BehaviorRelay;", "mapIsReady", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "l", "cameraPositionRelay", VKApiConst.Q, "latLngBoundsPadding", "o", "getFindLocationClicks", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "findLocationClicks", "<set-?>", AuthSource.SEND_ABUSE, "Lkotlin/properties/ReadWriteProperty;", "getLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;)Lcom/avito/android/messenger/map/viewing/view/PlatformMapView$State;", "setLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;Lcom/avito/android/messenger/map/viewing/view/PlatformMapView$State;)V", "lastRenderedState", "k", "getCameraDraggingStartedStream", "cameraDraggingStartedStream", "Lcom/avito/android/avito_map/clustering/ClusterManager;", "f", "Lcom/avito/android/avito_map/clustering/ClusterManager;", "pinClusterManager", "c", "Lcom/avito/android/avito_map/AvitoMap;", "Lcom/avito/android/messenger/map/MapBottomSheet;", "e", "Lcom/avito/android/messenger/map/MapBottomSheet;", "bottomSheet", "s", "renderedInitialState", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "TAG", "Lru/avito/component/bottom_sheet/BottomSheet$Visibility;", "getBottomSheetVisibilityStream", "bottomSheetVisibilityStream", "n", "getCameraPosition", "cameraPosition", "Landroidx/fragment/app/FragmentManager;", "x", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "d", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "findLocationButton", "j", "getPinClicks", "pinClicks", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.OPEN_CHANNEL_LIST, "Landroid/content/Context;", "context", "lockBottomSheet", "<init>", "(Landroid/view/View;ZLcom/avito/android/avito_map/AvitoMapAttachHelper;Landroidx/fragment/app/FragmentManager;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PlatformMapViewImpl implements PlatformMapView, AvitoMapAttachHelper.MapAttachListener {
    public static final /* synthetic */ KProperty[] y = {Reflection.mutableProperty2(new MutablePropertyReference2Impl(PlatformMapViewImpl.class, "lastRenderedState", "getLastRenderedState(Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;)Lcom/avito/android/messenger/map/viewing/view/PlatformMapView$State;", 0))};
    @Nullable
    public final ReadWriteProperty a;
    public final String b;
    public AvitoMap c;
    public final FloatingActionButton d;
    public final MapBottomSheet e;
    public ClusterManager<Pin> f;
    public final BehaviorRelay<Boolean> g;
    @NotNull
    public final BehaviorRelay<Boolean> h;
    public final PublishRelay<Pin> i;
    @NotNull
    public final PublishRelay<Pin> j;
    @NotNull
    public final PublishRelay<Unit> k;
    public final PublishRelay<AvitoMapCameraPosition> l;
    public final Context m;
    @NotNull
    public final PublishRelay<AvitoMapCameraPosition> n;
    @NotNull
    public final PublishRelay<Unit> o;
    @NotNull
    public final Observable<Unit> p;
    public final int q;
    public final int r;
    public boolean s;
    public AvitoMapMarker t;
    public boolean u;
    public final View v;
    public final AvitoMapAttachHelper w;
    public final FragmentManager x;

    public static final class a<T extends ClusterItem> implements ClusterManager.OnClusterItemClickListener<Pin> {
        public final /* synthetic */ PlatformMapViewImpl a;
        public final /* synthetic */ AvitoMap b;

        public a(PlatformMapViewImpl platformMapViewImpl, AvitoMap avitoMap) {
            this.a = platformMapViewImpl;
            this.b = avitoMap;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.android.avito_map.clustering.ClusterItem] */
        @Override // com.avito.android.avito_map.clustering.ClusterManager.OnClusterItemClickListener
        public boolean onClusterItemClick(Pin pin) {
            AvitoMapPoint position;
            Pin pin2 = pin;
            ClusterRenderer<T> renderer = PlatformMapViewImpl.access$getPinClusterManager$p(this.a).getRenderer();
            Objects.requireNonNull(renderer, "null cannot be cast to non-null type com.avito.android.messenger.map.viewing.view.PinRenderer");
            AvitoMapMarker marker = ((PinRenderer) renderer).getMarker(pin2);
            if (!(marker == null || (position = marker.getPosition()) == null)) {
                this.b.moveTo(position, true, null);
            }
            this.a.i.accept(pin2);
            return true;
        }
    }

    public static final class b<T extends ClusterItem> implements ClusterManager.OnClusterClickListener<Pin> {
        public final /* synthetic */ PlatformMapViewImpl a;
        public final /* synthetic */ AvitoMap b;

        public b(PlatformMapViewImpl platformMapViewImpl, AvitoMap avitoMap) {
            this.a = platformMapViewImpl;
            this.b = avitoMap;
        }

        @Override // com.avito.android.avito_map.clustering.ClusterManager.OnClusterClickListener
        public final boolean onClusterClick(Cluster<Pin> cluster) {
            Pair<Integer, Integer> size;
            Integer second;
            Pair<Integer, Integer> size2;
            Integer first;
            PlatformMapViewImpl platformMapViewImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(cluster, "cluster");
            int i = this.a.q;
            AvitoMap avitoMap = platformMapViewImpl.c;
            int i2 = 0;
            int intValue = (avitoMap == null || (size2 = avitoMap.getSize()) == null || (first = size2.getFirst()) == null) ? 0 : first.intValue();
            AvitoMap avitoMap2 = platformMapViewImpl.c;
            if (!(avitoMap2 == null || (size = avitoMap2.getSize()) == null || (second = size.getSecond()) == null)) {
                i2 = second.intValue();
            }
            AvitoMapBoundsBuilder avitoMapBoundsBuilder = new AvitoMapBoundsBuilder(intValue, i2);
            Collection<Pin> items = cluster.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "items");
            for (T t : items) {
                Intrinsics.checkNotNullExpressionValue(t, "it");
                avitoMapBoundsBuilder.addPoint(t.getPosition());
            }
            avitoMapBoundsBuilder.addOffset(i);
            AvitoMapBounds build = avitoMapBoundsBuilder.build();
            if (build != null) {
                this.b.moveTo(build, true);
            }
            return true;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ PlatformMapViewImpl a;
        public final /* synthetic */ AvitoMap b;

        public c(PlatformMapViewImpl platformMapViewImpl, AvitoMap avitoMap) {
            this.a = platformMapViewImpl;
            this.b = avitoMap;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AvitoMapMarker avitoMapMarker = this.a.t;
            if (avitoMapMarker != null) {
                this.b.moveTo(avitoMapMarker.getPosition(), true, null);
            }
            this.a.getFindLocationClicks().accept(Unit.INSTANCE);
        }
    }

    @Inject
    public PlatformMapViewImpl(@NotNull View view, boolean z, @NotNull AvitoMapAttachHelper avitoMapAttachHelper, @NotNull FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(avitoMapAttachHelper, "mapAttachHelper");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.v = view;
        this.w = avitoMapAttachHelper;
        this.x = fragmentManager;
        this.a = new BackingField(null);
        this.b = "PlatformMapView";
        View findViewById = view.findViewById(R.id.messenger_platform_map_location_button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.google.android.material.floatingactionbutton.FloatingActionButton");
        this.d = (FloatingActionButton) findViewById;
        MapBottomSheetImpl mapBottomSheetImpl = new MapBottomSheetImpl(view, com.avito.android.lib.design.avito.R.style.Avito_Button_DefaultMedium, R.string.messenger_platform_map_create_route_button, z);
        this.e = mapBottomSheetImpl;
        BehaviorRelay<Boolean> createDefault = BehaviorRelay.createDefault(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(createDefault, "BehaviorRelay.createDefault(false)");
        this.g = createDefault;
        this.h = createDefault;
        PublishRelay<Pin> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.i = create;
        this.j = create;
        PublishRelay<Unit> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.k = create2;
        PublishRelay<AvitoMapCameraPosition> create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.l = create3;
        this.m = view.getContext();
        this.n = create3;
        PublishRelay<Unit> create4 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create4, "PublishRelay.create()");
        this.o = create4;
        this.p = mapBottomSheetImpl.getActionButtonClicks();
        this.q = view.getResources().getDimensionPixelSize(R.dimen.messenger_platform_map_lat_lng_bounds_padding);
        this.r = view.getResources().getDimensionPixelSize(R.dimen.messenger_platform_map_center_offset);
        this.u = true;
        avitoMapAttachHelper.setMapAttachedListener(this);
        avitoMapAttachHelper.attachView(R.id.messenger_platform_map_map_view, view, fragmentManager);
    }

    public static final AvitoMapBounds access$getLatLngBoundsCameraUpdate(PlatformMapViewImpl platformMapViewImpl, Cluster cluster, int i2) {
        Pair<Integer, Integer> size;
        Integer second;
        Pair<Integer, Integer> size2;
        Integer first;
        Objects.requireNonNull(platformMapViewImpl);
        AvitoMap avitoMap = platformMapViewImpl.c;
        int i3 = 0;
        int intValue = (avitoMap == null || (size2 = avitoMap.getSize()) == null || (first = size2.getFirst()) == null) ? 0 : first.intValue();
        AvitoMap avitoMap2 = platformMapViewImpl.c;
        if (!(avitoMap2 == null || (size = avitoMap2.getSize()) == null || (second = size.getSecond()) == null)) {
            i3 = second.intValue();
        }
        AvitoMapBoundsBuilder avitoMapBoundsBuilder = new AvitoMapBoundsBuilder(intValue, i3);
        Collection<Pin> items = cluster.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "items");
        for (Pin pin : items) {
            Intrinsics.checkNotNullExpressionValue(pin, "it");
            avitoMapBoundsBuilder.addPoint(pin.getPosition());
        }
        avitoMapBoundsBuilder.addOffset(i2);
        return avitoMapBoundsBuilder.build();
    }

    public static final /* synthetic */ ClusterManager access$getPinClusterManager$p(PlatformMapViewImpl platformMapViewImpl) {
        ClusterManager<Pin> clusterManager = platformMapViewImpl.f;
        if (clusterManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinClusterManager");
        }
        return clusterManager;
    }

    @Override // com.avito.android.messenger.map.viewing.view.PlatformMapView
    @NotNull
    public Observable<BottomSheet.Visibility> getBottomSheetVisibilityStream() {
        return this.e.getVisibilityStream();
    }

    @Override // com.avito.android.messenger.map.viewing.view.PlatformMapView
    @NotNull
    public Observable<Unit> getCreateRouteButtonClicks() {
        return this.p;
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.Renderer
    @Nullable
    public PlatformMapView.State getLastRenderedState(@NotNull Renderer<PlatformMapView.State> renderer) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        return (PlatformMapView.State) this.a.getValue(renderer, y[0]);
    }

    @Override // com.avito.android.messenger.map.viewing.view.PlatformMapView
    public void onDestroy() {
        this.c = null;
    }

    @Override // com.avito.android.messenger.map.viewing.view.PlatformMapView
    public void onLowMemory() {
        AvitoMap avitoMap = this.c;
        if (avitoMap != null) {
            avitoMap.onLowMemory();
        }
    }

    @Override // com.avito.android.avito_map.AvitoMapAttachHelper.MapAttachListener
    public void onMapAttach(@NotNull AvitoMap avitoMap) {
        Intrinsics.checkNotNullParameter(avitoMap, "map");
        this.c = avitoMap;
        ClusterManager<Pin> clusterManager = new ClusterManager<>(this.v.getContext(), avitoMap);
        this.f = clusterManager;
        if (clusterManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinClusterManager");
        }
        Context context = this.v.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        ClusterManager<Pin> clusterManager2 = this.f;
        if (clusterManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinClusterManager");
        }
        PinRenderer pinRenderer = new PinRenderer(context, avitoMap, clusterManager2);
        pinRenderer.setMinClusterSize(3);
        clusterManager.setRenderer(pinRenderer);
        avitoMap.setPadding(0, 0, this.r * 2, 0);
        AvitoMapUiSettings uiSettings = avitoMap.getUiSettings();
        uiSettings.isRotateGesturesEnabled(false);
        uiSettings.isTiltGesturesEnabled(false);
        ClusterManager<Pin> clusterManager3 = this.f;
        if (clusterManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinClusterManager");
        }
        avitoMap.addMarkerExactClickListener(clusterManager3);
        ClusterManager<Pin> clusterManager4 = this.f;
        if (clusterManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinClusterManager");
        }
        clusterManager4.setOnClusterItemClickListener(new a(this, avitoMap));
        ClusterManager<Pin> clusterManager5 = this.f;
        if (clusterManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pinClusterManager");
        }
        clusterManager5.setOnClusterClickListener(new b(this, avitoMap));
        avitoMap.addMoveStartListener(new AvitoMap.MapMoveStartListener(this) { // from class: com.avito.android.messenger.map.viewing.view.PlatformMapViewImpl$onMapAttach$5
            public final /* synthetic */ PlatformMapViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.avito_map.AvitoMap.MapMoveStartListener
            public void onMapMoveStarted(@NotNull AvitoMapMoveReason avitoMapMoveReason) {
                Intrinsics.checkNotNullParameter(avitoMapMoveReason, "reason");
                if (avitoMapMoveReason == AvitoMapMoveReason.GESTURE) {
                    Logs.verbose$default(this.a.b, "OnCameraMoveStarted.REASON_GESTURE", null, 4, null);
                    this.a.getCameraDraggingStartedStream().accept(Unit.INSTANCE);
                }
            }
        });
        avitoMap.addMoveEndListener(new AvitoMap.MapMoveEndListener(this, avitoMap) { // from class: com.avito.android.messenger.map.viewing.view.PlatformMapViewImpl$onMapAttach$6
            public final /* synthetic */ PlatformMapViewImpl a;
            public final /* synthetic */ AvitoMap b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.avito.android.avito_map.AvitoMap.MapMoveEndListener
            public void onMapSettled(@NotNull AvitoMapCameraPosition avitoMapCameraPosition) {
                Intrinsics.checkNotNullParameter(avitoMapCameraPosition, "mapCameraPosition");
                Logs.verbose$default(this.a.b, "onCameraIdle()", null, 4, null);
                PlatformMapViewImpl.access$getPinClusterManager$p(this.a).onMapSettled(avitoMapCameraPosition);
                if (this.a.u) {
                    Logs.verbose$default(this.a.b, "onCameraIdle(), ignoring", null, 4, null);
                    this.a.u = false;
                    return;
                }
                Logs.verbose$default(this.a.b, "onCameraIdle(), sending event", null, 4, null);
                this.a.l.accept(this.b.getMapCameraPosition());
            }
        });
        this.d.setOnClickListener(new c(this, avitoMap));
        this.g.accept(Boolean.TRUE);
    }

    @Override // com.avito.android.messenger.map.viewing.view.PlatformMapView
    public void onStart() {
        AvitoMap avitoMap = this.c;
        if (avitoMap != null) {
            avitoMap.onStart();
        }
    }

    @Override // com.avito.android.messenger.map.viewing.view.PlatformMapView
    public void onStop() {
        AvitoMap avitoMap = this.c;
        if (avitoMap != null) {
            avitoMap.onStop();
        }
    }

    public void render(@NotNull PlatformMapView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        PlatformMapView.DefaultImpls.render(this, state);
    }

    public void setLastRenderedState(@NotNull Renderer<PlatformMapView.State> renderer, @Nullable PlatformMapView.State state) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        this.a.setValue(renderer, y[0], state);
    }

    @Override // com.avito.android.messenger.map.viewing.view.PlatformMapView
    public void showError(@StringRes int i2, int i3) {
        Context context = this.m;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ToastsKt.showToast(context, i2, i3).show();
    }

    @Override // com.avito.android.messenger.map.viewing.view.PlatformMapView
    public void showFindLocationError() {
        PlatformMapView.DefaultImpls.showError$default(this, com.avito.android.geo.R.string.location_not_found, 0, 2, null);
    }

    @MainThread
    public void doRender(@NotNull Renderer<PlatformMapView.State> renderer, @Nullable PlatformMapView.State state, @NotNull PlatformMapView.State state2) {
        Pair<Integer, Integer> size;
        Integer second;
        Pair<Integer, Integer> size2;
        Integer first;
        AvitoMapPoint mapPoint;
        AvitoMap avitoMap;
        Intrinsics.checkNotNullParameter(renderer, "$this$doRender");
        Intrinsics.checkNotNullParameter(state2, "curState");
        if (state == null || (!Intrinsics.areEqual(state2.getPins(), state.getPins()))) {
            ClusterManager<Pin> clusterManager = this.f;
            if (clusterManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pinClusterManager");
            }
            clusterManager.clearItems();
            ClusterManager<Pin> clusterManager2 = this.f;
            if (clusterManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pinClusterManager");
            }
            clusterManager2.addItems(state2.getPins());
            ClusterManager<Pin> clusterManager3 = this.f;
            if (clusterManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pinClusterManager");
            }
            clusterManager3.cluster();
        }
        MapBottomSheet.State state3 = null;
        if (state == null || (!Intrinsics.areEqual(state2.getUserPoint(), state.getUserPoint()))) {
            if (state2.getUserPoint() != null) {
                AvitoMapPoint userPoint = state2.getUserPoint();
                AvitoMapMarker avitoMapMarker = this.t;
                if (avitoMapMarker != null) {
                    avitoMapMarker.setPosition(userPoint);
                } else {
                    AvitoMap avitoMap2 = this.c;
                    this.t = avitoMap2 != null ? avitoMap2.addMarker(userPoint, AvitoMapMarker.Type.MARKER_MY_LOCATION_RED, AvitoMapMarker.Anchor.CENTER, Float.valueOf(1.0f)) : null;
                }
            } else {
                AvitoMapMarker avitoMapMarker2 = this.t;
                if (!(avitoMapMarker2 == null || (avitoMap = this.c) == null)) {
                    AvitoMap.DefaultImpls.removeMarker$default(avitoMap, avitoMapMarker2, false, 2, null);
                }
            }
        }
        if ((!this.s || state2.getForceMoveCamera()) && state2.getCameraUpdate() != null) {
            if (state2.getCameraUpdate().getCameraPosition() != null) {
                AvitoMapCameraPosition cameraPosition = state2.getCameraUpdate().getCameraPosition();
                if (cameraPosition != null && (mapPoint = cameraPosition.getMapPoint()) != null) {
                    AvitoMapCameraPosition cameraPosition2 = state2.getCameraUpdate().getCameraPosition();
                    Float valueOf = cameraPosition2 != null ? Float.valueOf(cameraPosition2.getZoomLevel()) : null;
                    AvitoMap avitoMap3 = this.c;
                    if (avitoMap3 != null) {
                        avitoMap3.moveTo(mapPoint, false, valueOf);
                    }
                } else {
                    return;
                }
            } else if (state2.getCameraUpdate().getBounds() != null) {
                AvitoMapBounds bounds = state2.getCameraUpdate().getBounds();
                if (bounds != null) {
                    AvitoMap avitoMap4 = this.c;
                    if (avitoMap4 != null) {
                        avitoMap4.moveTo(bounds, false);
                    }
                } else {
                    return;
                }
            } else if (state2.getCameraUpdate().getBoundsByPoints() != null) {
                PointsWithOffset boundsByPoints = state2.getCameraUpdate().getBoundsByPoints();
                if (boundsByPoints != null) {
                    AvitoMap avitoMap5 = this.c;
                    int intValue = (avitoMap5 == null || (size2 = avitoMap5.getSize()) == null || (first = size2.getFirst()) == null) ? 0 : first.intValue();
                    AvitoMap avitoMap6 = this.c;
                    AvitoMapBoundsBuilder avitoMapBoundsBuilder = new AvitoMapBoundsBuilder(intValue, (avitoMap6 == null || (size = avitoMap6.getSize()) == null || (second = size.getSecond()) == null) ? 0 : second.intValue());
                    Iterator<T> it = boundsByPoints.getPoints().iterator();
                    while (it.hasNext()) {
                        avitoMapBoundsBuilder.addPoint(it.next());
                    }
                    avitoMapBoundsBuilder.addOffset(boundsByPoints.getOffset());
                    AvitoMapBounds build = avitoMapBoundsBuilder.build();
                    if (build != null) {
                        AvitoMap avitoMap7 = this.c;
                        if (avitoMap7 != null) {
                            avitoMap7.moveTo(build, false);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.u = true;
            this.s = true;
        }
        MapBottomSheet mapBottomSheet = this.e;
        if (state != null) {
            state3 = state.getBottomSheetState();
        }
        mapBottomSheet.render(state3, state2.getBottomSheetState());
    }

    @Override // com.avito.android.messenger.map.viewing.view.PlatformMapView
    @NotNull
    public PublishRelay<Unit> getCameraDraggingStartedStream() {
        return this.k;
    }

    @Override // com.avito.android.messenger.map.viewing.view.PlatformMapView
    @NotNull
    public PublishRelay<AvitoMapCameraPosition> getCameraPosition() {
        return this.n;
    }

    @Override // com.avito.android.messenger.map.viewing.view.PlatformMapView
    @NotNull
    public PublishRelay<Unit> getFindLocationClicks() {
        return this.o;
    }

    @Override // com.avito.android.messenger.map.viewing.view.PlatformMapView
    @NotNull
    public BehaviorRelay<Boolean> getMapIsReady() {
        return this.h;
    }

    @Override // com.avito.android.messenger.map.viewing.view.PlatformMapView
    @NotNull
    public PublishRelay<Pin> getPinClicks() {
        return this.j;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlatformMapViewImpl(View view, boolean z, AvitoMapAttachHelper avitoMapAttachHelper, FragmentManager fragmentManager, int i2, j jVar) {
        this(view, (i2 & 2) != 0 ? false : z, avitoMapAttachHelper, fragmentManager);
    }
}
