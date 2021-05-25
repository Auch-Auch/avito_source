package com.avito.android.delivery.map.common;

import a2.g.r.g;
import android.graphics.Point;
import android.location.Location;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.avito_map.AvitoMap;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.AvitoMapTarget;
import com.avito.android.avito_map.AvitoMapUiSettings;
import com.avito.android.avito_map.AvitoMapView;
import com.avito.android.delivery.R;
import com.avito.android.delivery.map.common.DeliveryMapView;
import com.avito.android.delivery.map.common.marker.ClusterMarkerManager;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import com.jakewharton.rxbinding4.view.RxView;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.y;
import t6.n.z;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010>\u001a\u00020;\u0012\u0006\u0010d\u001a\u00020c\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010:\u001a\u000207¢\u0006\u0004\be\u0010fJ\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\nJ\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\nJ\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\nJ\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\nRD\u0010\u001d\u001a0\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u0018 \u0019*\u0017\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u0018\u0018\u00010\u0017¢\u0006\u0002\b\u001a0\u0017¢\u0006\u0002\b\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010,\u001a\b\u0012\u0004\u0012\u00020'0&8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\"\u00101\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020.0-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010=RD\u0010F\u001a0\u0012\f\u0012\n \u0019*\u0004\u0018\u00010'0' \u0019*\u0017\u0012\f\u0012\n \u0019*\u0004\u0018\u00010'0'\u0018\u00010\u0017¢\u0006\u0002\b\u001a0\u0017¢\u0006\u0002\b\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010\u001cR\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\"\u0010Q\u001a\b\u0012\u0004\u0012\u00020\b0&8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bO\u0010)\u001a\u0004\bP\u0010+R\u0018\u0010T\u001a\u0004\u0018\u00010\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\"\u0010[\u001a\b\u0012\u0004\u0012\u00020V0U8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\"\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00180&8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\\\u0010)\u001a\u0004\b]\u0010+R\u0016\u0010b\u001a\u00020_8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b`\u0010a¨\u0006g"}, d2 = {"Lcom/avito/android/delivery/map/common/DeliveryMapViewImpl;", "Lcom/avito/android/delivery/map/common/DeliveryMapView;", "Lcom/avito/android/avito_map/AvitoMapAttachHelper$MapAttachListener;", "Landroid/graphics/Point;", "point", "Lcom/avito/android/avito_map/AvitoMapPoint;", "fromScreenLocation", "(Landroid/graphics/Point;)Lcom/avito/android/avito_map/AvitoMapPoint;", "", "initPlatformMap", "()V", "Lcom/avito/android/delivery/map/common/DeliveryMapView$State;", "state", "render", "(Lcom/avito/android/delivery/map/common/DeliveryMapView$State;)V", "Lcom/avito/android/avito_map/AvitoMap;", "map", "onMapAttach", "(Lcom/avito/android/avito_map/AvitoMap;)V", "onMapResume", "onMapPause", "onMapDestroy", "onMapLowMemory", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/delivery/map/common/CameraCoordinatesEvent;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "c", "Lcom/jakewharton/rxrelay3/PublishRelay;", "cameraPositionRelay", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "o", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "avitoMapAttachHelper", "Lcom/avito/android/delivery/map/common/marker/ClusterMarkerManager;", "n", "Lcom/avito/android/delivery/map/common/marker/ClusterMarkerManager;", "clusterMarkerManager", "Lio/reactivex/rxjava3/core/Observable;", "", g.a, "Lio/reactivex/rxjava3/core/Observable;", "getMarkersClicks", "()Lio/reactivex/rxjava3/core/Observable;", "markersClicks", "", "Lcom/avito/android/avito_map/AvitoMapMarker;", "i", "Ljava/util/Map;", ScreenPublicConstsKt.CONTENT_TYPE_MARKERS, "j", "Lcom/avito/android/delivery/map/common/DeliveryMapView$State;", "previousState", "k", "Lcom/avito/android/avito_map/AvitoMap;", "Landroidx/fragment/app/FragmentManager;", "p", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Landroid/view/View;", AuthSource.OPEN_CHANNEL_LIST, "Landroid/view/View;", "view", "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.SEND_ABUSE, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", AuthSource.BOOKING_ORDER, "findMeButton", "d", "markersClicksRelay", "Lcom/avito/android/avito_map/AvitoMapView;", "l", "Lcom/avito/android/avito_map/AvitoMapView;", "mapView", "Lcom/avito/android/avito_map/AvitoMapBounds;", "getVisibleRegion", "()Lcom/avito/android/avito_map/AvitoMapBounds;", "visibleRegion", "f", "getFindMeClicks", "findMeClicks", "getCenter", "()Lcom/avito/android/avito_map/AvitoMapPoint;", "center", "Landroidx/lifecycle/MutableLiveData;", "", "h", "Landroidx/lifecycle/MutableLiveData;", "getMapIsReadyChanges", "()Landroidx/lifecycle/MutableLiveData;", "mapIsReadyChanges", "e", "getCameraCoordinatesObservable", "cameraCoordinatesObservable", "", "getMapViewHeight", "()I", "mapViewHeight", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/delivery/map/common/marker/ClusterMarkerManager;Lcom/avito/android/avito_map/AvitoMapAttachHelper;Landroidx/fragment/app/FragmentManager;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryMapViewImpl implements DeliveryMapView, AvitoMapAttachHelper.MapAttachListener {
    public final ProgressOverlay a;
    public final View b;
    public final PublishRelay<CameraCoordinatesEvent> c;
    public final PublishRelay<String> d;
    @NotNull
    public final Observable<CameraCoordinatesEvent> e;
    @NotNull
    public final Observable<Unit> f;
    @NotNull
    public final Observable<String> g;
    @NotNull
    public final MutableLiveData<Boolean> h = new MutableLiveData<>(Boolean.FALSE);
    public final Map<String, AvitoMapMarker> i = new LinkedHashMap();
    public DeliveryMapView.State j;
    public AvitoMap k;
    public final AvitoMapView l;
    public final View m;
    public final ClusterMarkerManager n;
    public final AvitoMapAttachHelper o;
    public final FragmentManager p;

    public DeliveryMapViewImpl(@NotNull View view, @NotNull Analytics analytics, @NotNull ClusterMarkerManager clusterMarkerManager, @NotNull AvitoMapAttachHelper avitoMapAttachHelper, @NotNull FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(clusterMarkerManager, "clusterMarkerManager");
        Intrinsics.checkNotNullParameter(avitoMapAttachHelper, "avitoMapAttachHelper");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.m = view;
        this.n = clusterMarkerManager;
        this.o = avitoMapAttachHelper;
        this.p = fragmentManager;
        View findViewById = view.findViewById(R.id.map_overlay);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.map_overlay)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        int i2 = R.id.map;
        this.a = new ProgressOverlay(viewGroup, i2, analytics, false, 0, 24, null);
        View findViewById2 = view.findViewById(R.id.find_me_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.find_me_button)");
        this.b = findViewById2;
        PublishRelay<CameraCoordinatesEvent> create = PublishRelay.create();
        this.c = create;
        PublishRelay<String> create2 = PublishRelay.create();
        this.d = create2;
        Intrinsics.checkNotNullExpressionValue(create, "cameraPositionRelay");
        this.e = create;
        this.f = RxView.clicks(findViewById2);
        Intrinsics.checkNotNullExpressionValue(create2, "markersClicksRelay");
        this.g = create2;
        View findViewById3 = view.findViewById(i2);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.avito_map.AvitoMapView");
        this.l = (AvitoMapView) findViewById3;
    }

    public static final float access$getRadius(DeliveryMapViewImpl deliveryMapViewImpl, AvitoMapBounds avitoMapBounds) {
        Objects.requireNonNull(deliveryMapViewImpl);
        float[] fArr = new float[1];
        Location.distanceBetween(avitoMapBounds.getTopLeft().getLatitude(), avitoMapBounds.getTopLeft().getLongitude(), avitoMapBounds.getBottomRight().getLatitude(), avitoMapBounds.getBottomRight().getLongitude(), fArr);
        return fArr[0];
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapView
    @Nullable
    public AvitoMapPoint fromScreenLocation(@NotNull Point point) {
        Intrinsics.checkNotNullParameter(point, "point");
        AvitoMap avitoMap = this.k;
        if (avitoMap != null) {
            return avitoMap.fromScreenLocation(point);
        }
        return null;
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapView
    @NotNull
    public Observable<CameraCoordinatesEvent> getCameraCoordinatesObservable() {
        return this.e;
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapView
    @Nullable
    public AvitoMapPoint getCenter() {
        AvitoMapTarget mapTarget;
        AvitoMap avitoMap = this.k;
        if (avitoMap == null || (mapTarget = avitoMap.getMapTarget()) == null) {
            return null;
        }
        return mapTarget.getPoint();
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapView
    @NotNull
    public Observable<Unit> getFindMeClicks() {
        return this.f;
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapView
    public int getMapViewHeight() {
        return this.l.getHeight();
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapView
    @NotNull
    public Observable<String> getMarkersClicks() {
        return this.g;
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapView
    @Nullable
    public AvitoMapBounds getVisibleRegion() {
        AvitoMap avitoMap = this.k;
        if (avitoMap != null) {
            return avitoMap.getMapBounds();
        }
        return null;
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapView
    public void initPlatformMap() {
        if (this.k == null) {
            this.o.setMapAttachedListener(this);
            this.o.attachView(R.id.map, this.m, this.p);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMapAttachHelper.MapAttachListener
    public void onMapAttach(@NotNull AvitoMap avitoMap) {
        Intrinsics.checkNotNullParameter(avitoMap, "map");
        this.k = avitoMap;
        AvitoMapUiSettings uiSettings = avitoMap.getUiSettings();
        uiSettings.isRotateGesturesEnabled(false);
        uiSettings.isTiltGesturesEnabled(false);
        avitoMap.addMoveEndListener(new AvitoMap.MapMoveEndListener(this) { // from class: com.avito.android.delivery.map.common.DeliveryMapViewImpl$onMapAttach$2
            public final /* synthetic */ DeliveryMapViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.avito_map.AvitoMap.MapMoveEndListener
            public void onMapSettled(@NotNull AvitoMapCameraPosition avitoMapCameraPosition) {
                AvitoMapBounds mapBounds;
                Intrinsics.checkNotNullParameter(avitoMapCameraPosition, "mapCameraPosition");
                AvitoMapBounds visibleRegion = this.a.getVisibleRegion();
                if (visibleRegion != null) {
                    float access$getRadius = DeliveryMapViewImpl.access$getRadius(this.a, visibleRegion);
                    AvitoMapPoint mapPoint = avitoMapCameraPosition.getMapPoint();
                    float zoomLevel = avitoMapCameraPosition.getZoomLevel();
                    AvitoMap access$getMap$p = DeliveryMapViewImpl.access$getMap$p(this.a);
                    if (access$getMap$p != null && (mapBounds = access$getMap$p.getMapBounds()) != null) {
                        PublishRelay access$getCameraPositionRelay$p = DeliveryMapViewImpl.access$getCameraPositionRelay$p(this.a);
                        AvitoMapBounds viewportBounds = avitoMapCameraPosition.getViewportBounds();
                        if (viewportBounds != null) {
                            access$getCameraPositionRelay$p.accept(new CameraCoordinatesEvent(avitoMapCameraPosition, viewportBounds, mapBounds.getTopLeft(), mapBounds.getBottomRight(), access$getRadius, DeliveryMapViewImpl.access$getClusterMarkerManager$p(this.a).getClusterRadius(mapPoint.getLatitude(), zoomLevel)));
                        }
                    }
                }
            }
        });
        avitoMap.addMarkerClickListener(new AvitoMap.MarkerClickListener(this) { // from class: com.avito.android.delivery.map.common.DeliveryMapViewImpl$onMapAttach$3
            public final /* synthetic */ DeliveryMapViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.avito_map.AvitoMap.MarkerClickListener
            public void onMarkerClicked(@Nullable Object obj) {
                if (!(obj instanceof String)) {
                    obj = null;
                }
                String str = (String) obj;
                if (str != null) {
                    Views.hide(DeliveryMapViewImpl.access$getFindMeButton$p(this.a));
                    DeliveryMapViewImpl.access$getMarkersClicksRelay$p(this.a).accept(str);
                }
            }
        });
        getMapIsReadyChanges().setValue(Boolean.TRUE);
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapView
    public void onMapDestroy() {
        this.k = null;
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapView
    public void onMapLowMemory() {
        AvitoMap avitoMap = this.k;
        if (avitoMap != null) {
            avitoMap.onLowMemory();
        }
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapView
    public void onMapPause() {
        AvitoMap avitoMap = this.k;
        if (avitoMap != null) {
            avitoMap.onStop();
        }
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapView
    public void onMapResume() {
        AvitoMap avitoMap = this.k;
        if (avitoMap != null) {
            avitoMap.onStart();
        }
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapView
    public void render(@NotNull DeliveryMapView.State state) {
        AvitoMap avitoMap;
        AvitoMap avitoMap2;
        Intrinsics.checkNotNullParameter(state, "state");
        DeliveryMapView.State state2 = this.j;
        for (DeliveryMapView.Marker marker : state2 != null ? z.minus((Set) state2.getMarkers(), (Iterable) state.getMarkers()) : y.emptySet()) {
            AvitoMapMarker remove = this.i.remove(marker.getId());
            if (!(remove == null || (avitoMap2 = this.k) == null)) {
                AvitoMap.DefaultImpls.removeMarker$default(avitoMap2, remove, false, 2, null);
            }
        }
        for (T t : state2 != null ? z.minus((Set) state.getMarkers(), (Iterable) state2.getMarkers()) : state.getMarkers()) {
            AvitoMap avitoMap3 = this.k;
            AvitoMapMarker addMarker = avitoMap3 != null ? avitoMap3.addMarker(t.getLatLng().getLatitude(), t.getLatLng().getLongitude(), t.getBitmap().getValue(), t.getAnchor(), t.getZIndex(), t.getMapIconUniqueId(), false) : null;
            if (addMarker != null) {
                addMarker.setData(t.getId());
            }
            if (addMarker != null) {
                this.i.put(t.getId(), addMarker);
            }
        }
        if (!(state.getCamera() == null || (avitoMap = this.k) == null)) {
            AvitoMapPoint point = state.getCamera().getPoint();
            if (point != null) {
                avitoMap.moveTo(point, state.getCamera().getAnimate(), state.getCamera().getZoomLevel());
            } else {
                return;
            }
        }
        if (state.getShowProgress() != null) {
            if (state.getShowProgress().booleanValue()) {
                this.a.showLoading();
            } else if (!this.a.isContentVisible()) {
                this.a.showContent();
            }
        }
        this.j = state;
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapView
    @NotNull
    public MutableLiveData<Boolean> getMapIsReadyChanges() {
        return this.h;
    }
}
