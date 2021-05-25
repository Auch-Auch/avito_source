package com.avito.android.delivery.map.common;

import a2.g.r.g;
import android.graphics.Bitmap;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.delivery.map.common.DeliveryMapView;
import com.avito.android.delivery.map.common.marker.DeliveryMapMarkerIconFactory;
import com.avito.android.delivery.map.common.marker.Marker;
import com.avito.android.delivery.map.common.marker.MarkerLabelManager;
import com.avito.android.delivery.map.common.marker.MarkersKt;
import com.avito.android.delivery.utils.CoordinatesKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.map.MarkerItem;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.n.y;
import t6.n.z;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0006\u0010v\u001a\u00020s\u0012\u0006\u0010~\u001a\u00020{\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010z\u001a\u00020w¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\tJ\u001d\u0010\u0016\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\"\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0005H\u0016¢\u0006\u0004\b$\u0010\tJ\u000f\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010\tJ\u000f\u0010&\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010\tJ\u0017\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u000eH\u0016¢\u0006\u0004\b(\u0010\u0011J\u000f\u0010)\u001a\u00020\u0005H\u0014¢\u0006\u0004\b)\u0010\tJ\u0017\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0005H\u0016¢\u0006\u0004\b.\u0010\tJ\u0017\u0010/\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u000eH\u0002¢\u0006\u0004\b/\u0010\u0011J-\u00102\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u000e2\n\b\u0002\u00100\u001a\u0004\u0018\u00010 2\b\b\u0002\u00101\u001a\u00020\u0018H\u0002¢\u0006\u0004\b2\u00103J\u0015\u00105\u001a\u0004\u0018\u000104*\u00020\u0014H\u0002¢\u0006\u0004\b5\u00106R$\u0010=\u001a\u0002072\u0006\u00108\u001a\u0002078\u0002@BX\u000e¢\u0006\f\n\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010IR\u0016\u0010M\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u001c\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u001c0N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010LR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\"\u0010]\u001a\b\u0012\u0004\u0012\u00020\u001c0X8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\"\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00180^8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR\"\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00050X8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bd\u0010Z\u001a\u0004\be\u0010\\R\u001c\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00140N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bg\u0010PR(\u0010l\u001a\u0004\u0018\u00010\u00142\b\u00108\u001a\u0004\u0018\u00010\u00148\u0002@BX\u000e¢\u0006\f\n\u0004\bi\u0010j\"\u0004\bK\u0010kR\"\u0010o\u001a\b\u0012\u0004\u0012\u0002070X8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bm\u0010Z\u001a\u0004\bn\u0010\\R\"\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00140X8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bp\u0010Z\u001a\u0004\bq\u0010\\R\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010~\u001a\u00020{8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b|\u0010}R\u001a\u0010\u0001\u001a\u0004\u0018\u000108\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b5\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/delivery/map/common/DeliveryMapViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/delivery/map/common/DeliveryMapViewModel;", "Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerIconFactory;", "factory", "", "attachIconFactory", "(Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerIconFactory;)V", "detachIconFactory", "()V", "Lcom/avito/android/delivery/map/common/CameraCoordinatesEvent;", "event", "onNewCameraCoordinates", "(Lcom/avito/android/delivery/map/common/CameraCoordinatesEvent;)V", "Lcom/avito/android/avito_map/AvitoMapPoint;", "point", "onNewLocation", "(Lcom/avito/android/avito_map/AvitoMapPoint;)V", "onFindMeClick", "", "Lcom/avito/android/delivery/map/common/marker/Marker;", "actualMarkers", "onNewMarkers", "(Ljava/util/List;)V", "", "ready", "onMapIsReady", "(Z)V", "", "markerId", "", "latDiff", "", "zoomLevel", "onMarkerClick", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Float;)V", "clearSelection", "showProgress", "showContent", "latLng", "moveCamera", "onCleared", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "mapAttachHelper", "setMapAttachHelper", "(Lcom/avito/android/avito_map/AvitoMapAttachHelper;)V", "requestLocationFromServer", "c", "zoom", "animate", "e", "(Lcom/avito/android/avito_map/AvitoMapPoint;Ljava/lang/Float;Z)V", "Lcom/avito/android/delivery/map/common/DeliveryMapView$Marker$Bitmap;", "d", "(Lcom/avito/android/delivery/map/common/marker/Marker;)Lcom/avito/android/delivery/map/common/DeliveryMapView$Marker$Bitmap;", "Lcom/avito/android/delivery/map/common/DeliveryMapView$State;", "value", "k", "Lcom/avito/android/delivery/map/common/DeliveryMapView$State;", "setViewState", "(Lcom/avito/android/delivery/map/common/DeliveryMapView$State;)V", "viewState", "Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerIconFactory;", "iconFactory", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/delivery/map/common/DeliveryMapResourceProvider;", VKApiConst.VERSION, "Lcom/avito/android/delivery/map/common/DeliveryMapResourceProvider;", "resourceProvider", "Lcom/avito/android/avito_map/AvitoMapBounds;", "Lcom/avito/android/avito_map/AvitoMapBounds;", "projection", "f", "Z", "moveCameraOnNewLocation", "", "i", "Ljava/util/Set;", "labels", "l", "mapIsReady", "Lio/reactivex/rxjava3/disposables/Disposable;", "n", "Lio/reactivex/rxjava3/disposables/Disposable;", "locationDisposable", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", VKApiConst.Q, "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getSnackBarEvents", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "snackBarEvents", "Landroidx/lifecycle/MutableLiveData;", "p", "Landroidx/lifecycle/MutableLiveData;", "getRequestLocationEvents", "()Landroidx/lifecycle/MutableLiveData;", "requestLocationEvents", "s", "getSelectedMarkerDisappearedEvents", "selectedMarkerDisappearedEvents", "h", ScreenPublicConstsKt.CONTENT_TYPE_MARKERS, "j", "Lcom/avito/android/delivery/map/common/marker/Marker;", "(Lcom/avito/android/delivery/map/common/marker/Marker;)V", "selectedMarker", "o", "getViewStateChanges", "viewStateChanges", "r", "getMarkerClicks", "markerClicks", "Lcom/avito/android/delivery/map/common/DeliveryLocationInteractor;", "t", "Lcom/avito/android/delivery/map/common/DeliveryLocationInteractor;", "locationInteractor", "Lcom/avito/android/delivery/map/common/marker/MarkerLabelManager;", "w", "Lcom/avito/android/delivery/map/common/marker/MarkerLabelManager;", "markerLabelManager", "Lcom/avito/android/util/SchedulersFactory3;", "u", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "cameraPosition", g.a, "Lcom/avito/android/avito_map/AvitoMapPoint;", "userLatLng", "<init>", "(Lcom/avito/android/delivery/map/common/DeliveryLocationInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/delivery/map/common/DeliveryMapResourceProvider;Lcom/avito/android/delivery/map/common/marker/MarkerLabelManager;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryMapViewModelImpl extends ViewModel implements DeliveryMapViewModel {
    public DeliveryMapMarkerIconFactory c;
    public AvitoMapCameraPosition d;
    public AvitoMapBounds e;
    public boolean f = true;
    public AvitoMapPoint g;
    public Set<? extends Marker> h = y.emptySet();
    public Set<String> i = y.emptySet();
    public Marker j;
    public DeliveryMapView.State k = new DeliveryMapView.State(y.emptySet(), null, null, 4, null);
    public boolean l;
    public final CompositeDisposable m = new CompositeDisposable();
    public Disposable n;
    @NotNull
    public final SingleLiveEvent<DeliveryMapView.State> o = new SingleLiveEvent<>();
    @NotNull
    public final MutableLiveData<Boolean> p = new MutableLiveData<>();
    @NotNull
    public final SingleLiveEvent<String> q = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<Marker> r = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<Unit> s = new SingleLiveEvent<>();
    public final DeliveryLocationInteractor t;
    public final SchedulersFactory3 u;
    public final DeliveryMapResourceProvider v;
    public final MarkerLabelManager w;

    public static final class a<T> implements Consumer<LoadingState<? super Coordinates>> {
        public final /* synthetic */ DeliveryMapViewModelImpl a;

        public a(DeliveryMapViewModelImpl deliveryMapViewModelImpl) {
            this.a = deliveryMapViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super Coordinates> loadingState) {
            LoadingState<? super Coordinates> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                this.a.c(CoordinatesKt.toAvitoMapPoint((Coordinates) ((LoadingState.Loaded) loadingState2).getData()));
            } else if (loadingState2 instanceof LoadingState.Error) {
                Logs.error$default(((LoadingState.Error) loadingState2).getError().toString(), null, 2, null);
                DeliveryMapViewModelImpl.access$onRequestLocationError(this.a);
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryMapViewModelImpl a;

        public b(DeliveryMapViewModelImpl deliveryMapViewModelImpl) {
            this.a = deliveryMapViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            DeliveryMapViewModelImpl.access$onRequestLocationError(this.a);
        }
    }

    public DeliveryMapViewModelImpl(@NotNull DeliveryLocationInteractor deliveryLocationInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull DeliveryMapResourceProvider deliveryMapResourceProvider, @NotNull MarkerLabelManager markerLabelManager) {
        Intrinsics.checkNotNullParameter(deliveryLocationInteractor, "locationInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(deliveryMapResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(markerLabelManager, "markerLabelManager");
        this.t = deliveryLocationInteractor;
        this.u = schedulersFactory3;
        this.v = deliveryMapResourceProvider;
        this.w = markerLabelManager;
        getRequestLocationEvents().setValue(Boolean.TRUE);
    }

    public static final void access$onRequestLocationError(DeliveryMapViewModelImpl deliveryMapViewModelImpl) {
        if (!(deliveryMapViewModelImpl.d != null)) {
            deliveryMapViewModelImpl.e(new AvitoMapPoint(60.830908d, 84.223165d), Float.valueOf(1.0f), true);
        } else {
            deliveryMapViewModelImpl.showContent();
        }
        deliveryMapViewModelImpl.getSnackBarEvents().postValue(deliveryMapViewModelImpl.v.getLocationNotFoundMessage());
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapViewModel
    public void attachIconFactory(@NotNull DeliveryMapMarkerIconFactory deliveryMapMarkerIconFactory) {
        Intrinsics.checkNotNullParameter(deliveryMapMarkerIconFactory, "factory");
        this.c = deliveryMapMarkerIconFactory;
    }

    public final void c(AvitoMapPoint avitoMapPoint) {
        Bitmap icon;
        CameraUpdateEvent cameraUpdateEvent;
        this.g = avitoMapPoint;
        DeliveryMapMarkerIconFactory deliveryMapMarkerIconFactory = this.c;
        if (!(deliveryMapMarkerIconFactory == null || (icon = deliveryMapMarkerIconFactory.getIcon(new MarkerItem.MyLocation())) == null)) {
            DeliveryMapView.Marker.Bitmap bitmap = new DeliveryMapView.Marker.Bitmap(icon, false, false, null, 14, null);
            bitmap.setMapIconUniqueId(MarkersKt.ICON_ID_MY_LOCATION);
            DeliveryMapView.Marker marker = new DeliveryMapView.Marker("user_marker_id", avitoMapPoint, bitmap, AvitoMapMarker.Anchor.CENTER, 0.0f);
            SingleLiveEvent<DeliveryMapView.State> viewStateChanges = getViewStateChanges();
            Set<DeliveryMapView.Marker> markers = this.k.getMarkers();
            ArrayList arrayList = new ArrayList();
            for (T t2 : markers) {
                if (true ^ Intrinsics.areEqual(t2.getId(), "user_marker_id")) {
                    arrayList.add(t2);
                }
            }
            Set plus = z.plus(CollectionsKt___CollectionsKt.toSet(arrayList), marker);
            if (this.f) {
                cameraUpdateEvent = new CameraUpdateEvent(this.d != null, null, avitoMapPoint, Float.valueOf(12.0f), 2, null);
            } else {
                cameraUpdateEvent = null;
            }
            viewStateChanges.setValue(new DeliveryMapView.State(plus, cameraUpdateEvent, Boolean.FALSE));
            this.f = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.avito.android.delivery.map.common.DeliveryMapView$Marker] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.avito.android.delivery.map.common.DeliveryMapViewModel
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clearSelection() {
        /*
            r11 = this;
            java.util.Set<? extends com.avito.android.delivery.map.common.marker.Marker> r0 = r11.h
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x0029
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.avito.android.delivery.map.common.marker.Marker r3 = (com.avito.android.delivery.map.common.marker.Marker) r3
            java.lang.String r3 = r3.getId()
            com.avito.android.delivery.map.common.marker.Marker r4 = r11.j
            if (r4 == 0) goto L_0x0021
            java.lang.String r4 = r4.getId()
            goto L_0x0022
        L_0x0021:
            r4 = r2
        L_0x0022:
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 == 0) goto L_0x0006
            goto L_0x002a
        L_0x0029:
            r1 = r2
        L_0x002a:
            com.avito.android.delivery.map.common.marker.Marker r1 = (com.avito.android.delivery.map.common.marker.Marker) r1
            r11.f(r2)
            com.avito.android.delivery.map.common.DeliveryMapView$State r0 = r11.k
            java.util.Set r0 = r0.getMarkers()
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = t6.n.e.collectionSizeOrDefault(r0, r3)
            r2.<init>(r3)
            java.util.Iterator r0 = r0.iterator()
        L_0x0044:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0080
            java.lang.Object r3 = r0.next()
            com.avito.android.delivery.map.common.DeliveryMapView$Marker r3 = (com.avito.android.delivery.map.common.DeliveryMapView.Marker) r3
            if (r1 == 0) goto L_0x007c
            java.lang.String r4 = r3.getId()
            java.lang.String r5 = r1.getId()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r4 == 0) goto L_0x007c
            com.avito.android.delivery.map.common.DeliveryMapView$Marker r4 = new com.avito.android.delivery.map.common.DeliveryMapView$Marker
            java.lang.String r6 = r1.getId()
            com.avito.android.avito_map.AvitoMapPoint r7 = r1.getLatLng()
            com.avito.android.delivery.map.common.DeliveryMapView$Marker$Bitmap r8 = r11.d(r1)
            if (r8 == 0) goto L_0x007b
            com.avito.android.avito_map.AvitoMapMarker$Anchor r9 = r3.getAnchor()
            r10 = 0
            r5 = r4
            r5.<init>(r6, r7, r8, r9, r10)
            r3 = r4
            goto L_0x007c
        L_0x007b:
            return
        L_0x007c:
            r2.add(r3)
            goto L_0x0044
        L_0x0080:
            java.util.Set r5 = kotlin.collections.CollectionsKt___CollectionsKt.toSet(r2)
            r6 = 0
            r7 = 0
            r8 = 4
            r9 = 0
            com.avito.android.delivery.map.common.DeliveryMapView$State r0 = new com.avito.android.delivery.map.common.DeliveryMapView$State
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            r11.k = r0
            com.avito.android.util.architecture_components.SingleLiveEvent r1 = r11.getViewStateChanges()
            r1.setValue(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.delivery.map.common.DeliveryMapViewModelImpl.clearSelection():void");
    }

    public final DeliveryMapView.Marker.Bitmap d(Marker marker) {
        Bitmap icon;
        Bitmap icon2;
        Bitmap icon3;
        Bitmap icon4;
        Bitmap icon5;
        if (marker instanceof Marker.Pin) {
            String id = marker.getId();
            Marker marker2 = this.j;
            if (Intrinsics.areEqual(id, marker2 != null ? marker2.getId() : null)) {
                DeliveryMapMarkerIconFactory deliveryMapMarkerIconFactory = this.c;
                if (deliveryMapMarkerIconFactory == null || (icon5 = deliveryMapMarkerIconFactory.getIcon(new MarkerItem.Pin(true, null, null, 6, null))) == null) {
                    return null;
                }
                DeliveryMapView.Marker.Bitmap bitmap = new DeliveryMapView.Marker.Bitmap(icon5, false, true, null, 10, null);
                String format = String.format(MarkersKt.ICON_ID_PIN_SELECTED, Arrays.copyOf(new Object[]{((Marker.Pin) marker).getHint(), Boolean.valueOf(bitmap.getSelected())}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(this, *args)");
                bitmap.setMapIconUniqueId(format);
                return bitmap;
            }
            if (this.i.contains(marker.getId())) {
                Marker.Pin pin = (Marker.Pin) marker;
                if (pin.getHint() != null) {
                    DeliveryMapMarkerIconFactory deliveryMapMarkerIconFactory2 = this.c;
                    if (deliveryMapMarkerIconFactory2 == null || (icon4 = deliveryMapMarkerIconFactory2.getIcon(new MarkerItem.PinWithLabel(pin.getHint(), null, null, 6, null))) == null) {
                        return null;
                    }
                    DeliveryMapView.Marker.Bitmap bitmap2 = new DeliveryMapView.Marker.Bitmap(icon4, true, false, null, 12, null);
                    String format2 = String.format(MarkersKt.ICON_ID_PIN_WITH_LABEL, Arrays.copyOf(new Object[]{pin.getHint(), Boolean.valueOf(bitmap2.getSelected())}, 2));
                    Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(this, *args)");
                    bitmap2.setMapIconUniqueId(format2);
                    return bitmap2;
                }
            }
            DeliveryMapMarkerIconFactory deliveryMapMarkerIconFactory3 = this.c;
            if (deliveryMapMarkerIconFactory3 == null || (icon3 = deliveryMapMarkerIconFactory3.getIcon(new MarkerItem.Pin(false, null, null, 7, null))) == null) {
                return null;
            }
            DeliveryMapView.Marker.Bitmap bitmap3 = new DeliveryMapView.Marker.Bitmap(icon3, false, false, null, 14, null);
            bitmap3.setMapIconUniqueId(MarkersKt.ICON_ID_PIN_DEFAULT);
            return bitmap3;
        } else if (marker instanceof Marker.Cluster) {
            if (this.i.contains(marker.getId())) {
                Marker.Cluster cluster = (Marker.Cluster) marker;
                if (cluster.getHint() != null) {
                    DeliveryMapMarkerIconFactory deliveryMapMarkerIconFactory4 = this.c;
                    if (deliveryMapMarkerIconFactory4 == null || (icon2 = deliveryMapMarkerIconFactory4.getIcon(new MarkerItem.ClusterWithLabel(cluster.getHint(), cluster.getCount()))) == null) {
                        return null;
                    }
                    DeliveryMapView.Marker.Bitmap bitmap4 = new DeliveryMapView.Marker.Bitmap(icon2, true, false, null, 12, null);
                    String format3 = String.format(MarkersKt.ICON_ID_CLUSTER_WITH_LABEL, Arrays.copyOf(new Object[]{cluster.getHint(), cluster.getCount()}, 2));
                    Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(this, *args)");
                    bitmap4.setMapIconUniqueId(format3);
                    return bitmap4;
                }
            }
            DeliveryMapMarkerIconFactory deliveryMapMarkerIconFactory5 = this.c;
            if (deliveryMapMarkerIconFactory5 != null) {
                Marker.Cluster cluster2 = (Marker.Cluster) marker;
                Bitmap icon6 = deliveryMapMarkerIconFactory5.getIcon(new MarkerItem.Cluster(cluster2.getCount()));
                if (icon6 != null) {
                    DeliveryMapView.Marker.Bitmap bitmap5 = new DeliveryMapView.Marker.Bitmap(icon6, false, false, null, 14, null);
                    String format4 = String.format(MarkersKt.ICON_ID_CLUSTER_DEFAULT, Arrays.copyOf(new Object[]{cluster2.getCount()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format4, "java.lang.String.format(this, *args)");
                    bitmap5.setMapIconUniqueId(format4);
                    return bitmap5;
                }
            }
            return null;
        } else if (marker instanceof Marker.User) {
            DeliveryMapMarkerIconFactory deliveryMapMarkerIconFactory6 = this.c;
            if (deliveryMapMarkerIconFactory6 == null || (icon = deliveryMapMarkerIconFactory6.getIcon(new MarkerItem.MyLocation())) == null) {
                return null;
            }
            return new DeliveryMapView.Marker.Bitmap(icon, false, false, null, 14, null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapViewModel
    public void detachIconFactory() {
        this.c = null;
    }

    public final void e(AvitoMapPoint avitoMapPoint, Float f2, boolean z) {
        DeliveryMapView.State state = new DeliveryMapView.State(this.k.getMarkers(), new CameraUpdateEvent(z, null, avitoMapPoint, f2, 2, null), Boolean.FALSE);
        this.k = state;
        getViewStateChanges().setValue(state);
    }

    public final void f(Marker marker) {
        this.j = null;
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapViewModel
    public void moveCamera(@NotNull AvitoMapPoint avitoMapPoint) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "latLng");
        e(avitoMapPoint, Float.valueOf(12.0f), false);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.m.clear();
        Disposable disposable = this.n;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapViewModel
    public void onFindMeClick() {
        this.f = true;
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapViewModel
    public void onMapIsReady(boolean z) {
        this.l = z;
        if (z) {
            AvitoMapCameraPosition avitoMapCameraPosition = this.d;
            if (avitoMapCameraPosition != null) {
                e(avitoMapCameraPosition.getMapPoint(), Float.valueOf(avitoMapCameraPosition.getZoomLevel()), false);
            }
            getViewStateChanges().setValue(this.k);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5, types: [com.avito.android.delivery.map.common.DeliveryMapView$Marker] */
    /* JADX WARN: Type inference failed for: r6v7, types: [com.avito.android.delivery.map.common.DeliveryMapView$Marker] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // com.avito.android.delivery.map.common.DeliveryMapViewModel
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMarkerClick(@org.jetbrains.annotations.NotNull java.lang.String r16, @org.jetbrains.annotations.Nullable java.lang.Double r17, @org.jetbrains.annotations.Nullable java.lang.Float r18) {
        /*
        // Method dump skipped, instructions count: 322
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.delivery.map.common.DeliveryMapViewModelImpl.onMarkerClick(java.lang.String, java.lang.Double, java.lang.Float):void");
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapViewModel
    public void onNewCameraCoordinates(@NotNull CameraCoordinatesEvent cameraCoordinatesEvent) {
        Intrinsics.checkNotNullParameter(cameraCoordinatesEvent, "event");
        this.d = cameraCoordinatesEvent.getCameraPosition();
        this.e = cameraCoordinatesEvent.getProjection();
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapViewModel
    public void onNewLocation(@NotNull AvitoMapPoint avitoMapPoint) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "point");
        if (this.l) {
            getRequestLocationEvents().setValue(Boolean.FALSE);
            c(avitoMapPoint);
        }
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapViewModel
    public void onNewMarkers(@NotNull List<? extends Marker> list) {
        Set<String> set;
        List<? extends Marker> plus;
        List<? extends Marker> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "actualMarkers");
        AvitoMapPoint avitoMapPoint = this.g;
        if (!(avitoMapPoint == null || (plus = CollectionsKt___CollectionsKt.plus((Collection<? extends Marker.User>) list2, new Marker.User("user_marker_id", avitoMapPoint))) == null)) {
            list2 = plus;
        }
        Set<? extends Marker> set2 = CollectionsKt___CollectionsKt.toSet(list2);
        this.h = set2;
        Marker marker = this.j;
        if (marker != null && !set2.contains(marker)) {
            f(null);
            getSelectedMarkerDisappearedEvents().postValue(Unit.INSTANCE);
        }
        AvitoMapCameraPosition avitoMapCameraPosition = this.d;
        if ((avitoMapCameraPosition != null ? avitoMapCameraPosition.getZoomLevel() : 12.0f) > 10.0f) {
            MarkerLabelManager markerLabelManager = this.w;
            AvitoMapBounds avitoMapBounds = this.e;
            Set<? extends Marker> set3 = this.h;
            ArrayList arrayList = new ArrayList();
            for (T t2 : set3) {
                if (t2.hasLabel()) {
                    arrayList.add(t2);
                }
            }
            set = markerLabelManager.getLabels(avitoMapBounds, arrayList);
        } else {
            set = y.emptySet();
        }
        this.i = set;
        Set<? extends Marker> set4 = this.h;
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(set4, 10));
        for (T t3 : set4) {
            String id = t3.getId();
            AvitoMapPoint latLng = t3.getLatLng();
            DeliveryMapView.Marker.Bitmap d2 = d(t3);
            if (d2 != null) {
                arrayList2.add(new DeliveryMapView.Marker(id, latLng, d2, t3.getAnchor(), 0.0f));
            } else {
                return;
            }
        }
        DeliveryMapView.State state = new DeliveryMapView.State(CollectionsKt___CollectionsKt.toSet(arrayList2), null, null, 4, null);
        this.k = state;
        getViewStateChanges().setValue(state);
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapViewModel
    public void requestLocationFromServer() {
        this.n = this.t.getLocation().observeOn(this.u.mainThread()).subscribe(new a(this), new b(this));
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapViewModel
    public void setMapAttachHelper(@NotNull AvitoMapAttachHelper avitoMapAttachHelper) {
        Intrinsics.checkNotNullParameter(avitoMapAttachHelper, "mapAttachHelper");
        this.w.setMapAttachHelper(avitoMapAttachHelper);
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapViewModel
    public void showContent() {
        DeliveryMapView.State state = new DeliveryMapView.State(this.k.getMarkers(), this.k.getCamera(), Boolean.FALSE);
        this.k = state;
        getViewStateChanges().setValue(state);
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapViewModel
    public void showProgress() {
        DeliveryMapView.State state = new DeliveryMapView.State(this.k.getMarkers(), null, Boolean.TRUE);
        this.k = state;
        getViewStateChanges().setValue(state);
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapViewModel
    @NotNull
    public SingleLiveEvent<Marker> getMarkerClicks() {
        return this.r;
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapViewModel
    @NotNull
    public MutableLiveData<Boolean> getRequestLocationEvents() {
        return this.p;
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapViewModel
    @NotNull
    public SingleLiveEvent<Unit> getSelectedMarkerDisappearedEvents() {
        return this.s;
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapViewModel
    @NotNull
    public SingleLiveEvent<String> getSnackBarEvents() {
        return this.q;
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapViewModel
    @NotNull
    public SingleLiveEvent<DeliveryMapView.State> getViewStateChanges() {
        return this.o;
    }
}
