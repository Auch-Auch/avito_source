package com.avito.android.search.map.view;

import a2.g.r.g;
import android.graphics.Bitmap;
import com.avito.android.avito_map.AvitoMap;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.AvitoMapTarget;
import com.avito.android.avito_map.AvitoMapUiSettings;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.map.action.MapViewAction;
import com.avito.android.search.map.interactor.MapAreaConverter;
import com.avito.android.search.map.metric.SearchMapTracker;
import com.avito.android.search.map.view.MarkerItem;
import com.avito.android.search.map.view.resolvers.MarkerAnchorResolver;
import com.avito.android.search.map.view.resolvers.MarkerAnchorResolverImpl;
import com.avito.android.search.map.view.resolvers.MarkerZIndexResolver;
import com.avito.android.search.map.view.resolvers.MarkerZIndexResolverImpl;
import com.google.android.gms.maps.model.LatLng;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.z;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u0010[\u001a\u00020X\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u0010L\u001a\u00020I¢\u0006\u0004\b\\\u0010]J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0018H\u0016¢\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R$\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020*\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\"\u00108\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020*058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010/R\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00030C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010/R\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u001c\u0010Q\u001a\b\u0012\u0004\u0012\u00020N0M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010/R\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010Z¨\u0006^"}, d2 = {"Lcom/avito/android/search/map/view/MapInteractorImpl;", "Lcom/avito/android/search/map/view/MapInteractor;", "Lio/reactivex/rxjava3/core/Observable;", "", "mapSettles", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/search/map/action/MapViewAction;", "mapActions", "", "Lcom/avito/android/search/map/view/MarkerItem;", "items", "setMarkerItems", "(Ljava/util/List;)V", "myLocation", "setMyLocation", "(Lcom/avito/android/search/map/view/MarkerItem;)V", "Lcom/google/android/gms/maps/model/LatLngBounds;", "bounds", "", "animate", "setLatLngBounds", "(Lcom/google/android/gms/maps/model/LatLngBounds;Z)V", "Lcom/google/android/gms/maps/model/LatLng;", "latLng", "", "zoom", "setLatLngZoom", "(Lcom/google/android/gms/maps/model/LatLng;FZ)V", VKApiConst.POSITION, "animatedByCenteredPin", "zoomLevel", "setLatLng", "(Lcom/google/android/gms/maps/model/LatLng;ZLjava/lang/Float;)V", "zoomTo", "(F)V", "getCurrentZoom", "()Ljava/lang/Float;", "Lcom/avito/android/search/map/view/resolvers/MarkerAnchorResolver;", "e", "Lcom/avito/android/search/map/view/resolvers/MarkerAnchorResolver;", "anchorResolver", "Lkotlin/Pair;", "Lcom/avito/android/avito_map/AvitoMapMarker;", "c", "Lkotlin/Pair;", "myLocationItem", "j", "Z", "firstTimeSettle", "Lcom/avito/android/avito_map/AvitoMap;", "d", "Lcom/avito/android/avito_map/AvitoMap;", "avitoMap", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "itemsWithMarkers", "Lcom/avito/android/search/map/view/MarkerIconFactory;", "l", "Lcom/avito/android/search/map/view/MarkerIconFactory;", "iconFactory", "Lcom/avito/android/search/map/metric/SearchMapTracker;", "n", "Lcom/avito/android/search/map/metric/SearchMapTracker;", "mapTracker", "h", "forcedCenterCoordinates", "Lcom/jakewharton/rxrelay3/PublishRelay;", "i", "Lcom/jakewharton/rxrelay3/PublishRelay;", "mapSettlingRelay", g.a, "isAfterGesture", "Lcom/avito/android/search/map/view/MapAsyncProvider;", "o", "Lcom/avito/android/search/map/view/MapAsyncProvider;", "mapAsyncProvider", "", "", AuthSource.BOOKING_ORDER, "Ljava/util/Set;", "itemsWithMarkersIds", "Lcom/avito/android/search/map/view/resolvers/MarkerZIndexResolver;", "f", "Lcom/avito/android/search/map/view/resolvers/MarkerZIndexResolver;", "zIndexResolver", "k", "forceZoomAction", "Lcom/avito/android/search/map/interactor/MapAreaConverter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/search/map/interactor/MapAreaConverter;", "mapAreaConverter", "<init>", "(Lcom/avito/android/search/map/view/MarkerIconFactory;Lcom/avito/android/search/map/interactor/MapAreaConverter;Lcom/avito/android/search/map/metric/SearchMapTracker;Lcom/avito/android/search/map/view/MapAsyncProvider;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class MapInteractorImpl implements MapInteractor {
    public Map<MarkerItem, AvitoMapMarker> a = new LinkedHashMap();
    public final Set<String> b = new LinkedHashSet();
    public Pair<? extends MarkerItem, ? extends AvitoMapMarker> c;
    public AvitoMap d;
    public final MarkerAnchorResolver e = new MarkerAnchorResolverImpl();
    public final MarkerZIndexResolver f = new MarkerZIndexResolverImpl();
    public boolean g;
    public boolean h;
    public final PublishRelay<Unit> i;
    public boolean j;
    public boolean k;
    public final MarkerIconFactory l;
    public final MapAreaConverter m;
    public final SearchMapTracker n;
    public final MapAsyncProvider o;

    public static final class a<T> implements ObservableOnSubscribe<MapViewAction> {
        public final /* synthetic */ MapInteractorImpl a;

        /* renamed from: com.avito.android.search.map.view.MapInteractorImpl$a$a  reason: collision with other inner class name */
        public static final class C0158a implements Cancellable {
            public final /* synthetic */ a a;

            public C0158a(a aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                MapInteractorImpl.access$clean(this.a.a);
            }
        }

        public static final class b extends Lambda implements Function1<AvitoMap, Unit> {
            public final /* synthetic */ a a;
            public final /* synthetic */ ObservableEmitter b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(a aVar, ObservableEmitter observableEmitter) {
                super(1);
                this.a = aVar;
                this.b = observableEmitter;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(AvitoMap avitoMap) {
                AvitoMap avitoMap2 = avitoMap;
                Intrinsics.checkNotNullParameter(avitoMap2, "it");
                this.a.a.n.trackMapLoaded();
                this.a.a.d = avitoMap2;
                AvitoMapUiSettings uiSettings = avitoMap2.getUiSettings();
                uiSettings.isRotateGesturesEnabled(false);
                uiSettings.isTiltGesturesEnabled(false);
                uiSettings.isCompassEnabled(false);
                uiSettings.isMyLocationButtonEnabled(false);
                avitoMap2.setMaxZoomPreference(18.0f);
                avitoMap2.setMinZoomPreference(2.0f);
                avitoMap2.distinctSameMoveEvent(true);
                this.b.onNext(MapViewAction.MapInitialized.INSTANCE);
                this.b.onNext(MapViewAction.MapSettledFirstTime.INSTANCE);
                avitoMap2.addMoveEndListener(new MapInteractorImpl$mapActions$1$2$2(this));
                avitoMap2.addMoveStartListener(new MapInteractorImpl$mapActions$1$2$3(this));
                avitoMap2.addMarkerClickListener(new MapInteractorImpl$mapActions$1$2$4(this));
                avitoMap2.addMapClickListener(new MapInteractorImpl$mapActions$1$2$5(this));
                return Unit.INSTANCE;
            }
        }

        public a(MapInteractorImpl mapInteractorImpl) {
            this.a = mapInteractorImpl;
        }

        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<MapViewAction> observableEmitter) {
            observableEmitter.onNext(MapViewAction.MapInitializationStarted.INSTANCE);
            observableEmitter.setCancellable(new C0158a(this));
            this.a.n.startMapLoading();
            this.a.o.provideMap(new b(this, observableEmitter));
        }
    }

    public MapInteractorImpl(@NotNull MarkerIconFactory markerIconFactory, @NotNull MapAreaConverter mapAreaConverter, @NotNull SearchMapTracker searchMapTracker, @NotNull MapAsyncProvider mapAsyncProvider) {
        Intrinsics.checkNotNullParameter(markerIconFactory, "iconFactory");
        Intrinsics.checkNotNullParameter(mapAreaConverter, "mapAreaConverter");
        Intrinsics.checkNotNullParameter(searchMapTracker, "mapTracker");
        Intrinsics.checkNotNullParameter(mapAsyncProvider, "mapAsyncProvider");
        this.l = markerIconFactory;
        this.m = mapAreaConverter;
        this.n = searchMapTracker;
        this.o = mapAsyncProvider;
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.i = create;
        this.j = true;
    }

    public static final void access$clean(MapInteractorImpl mapInteractorImpl) {
        AvitoMap avitoMap = mapInteractorImpl.d;
        if (avitoMap != null) {
            avitoMap.clearMoveStartListeners();
            avitoMap.clearMoveEndListeners();
            avitoMap.onStop();
        }
        mapInteractorImpl.a.clear();
        mapInteractorImpl.b.clear();
        mapInteractorImpl.d = null;
    }

    @Override // com.avito.android.search.map.view.MapInteractor
    @Nullable
    public Float getCurrentZoom() {
        AvitoMapCameraPosition mapCameraPosition;
        AvitoMap avitoMap = this.d;
        if (avitoMap == null || (mapCameraPosition = avitoMap.getMapCameraPosition()) == null) {
            return null;
        }
        return Float.valueOf(mapCameraPosition.getZoomLevel());
    }

    @Override // com.avito.android.search.map.view.MapInteractor
    @NotNull
    public Observable<MapViewAction> mapActions() {
        Observable<MapViewAction> create = Observable.create(new a(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…\n            }\n\n        }");
        return create;
    }

    @Override // com.avito.android.search.map.view.MapInteractor
    @NotNull
    public Observable<Unit> mapSettles() {
        return this.i;
    }

    @Override // com.avito.android.search.map.view.MapInteractor
    public void setLatLng(@NotNull LatLng latLng, boolean z, @Nullable Float f2) {
        AvitoMapTarget mapTarget;
        Intrinsics.checkNotNullParameter(latLng, VKApiConst.POSITION);
        this.h = z;
        AvitoMap avitoMap = this.d;
        if (avitoMap != null) {
            AvitoMapPoint avitoMapPoint = new AvitoMapPoint(latLng.latitude, latLng.longitude);
            if (f2 == null) {
                AvitoMap avitoMap2 = this.d;
                f2 = (avitoMap2 == null || (mapTarget = avitoMap2.getMapTarget()) == null) ? null : Float.valueOf(mapTarget.getZoomLevel());
            }
            avitoMap.moveTo(avitoMapPoint, true, Float.valueOf(f2 != null ? f2.floatValue() : 15.0f));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x008b  */
    @Override // com.avito.android.search.map.view.MapInteractor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setLatLngBounds(@org.jetbrains.annotations.NotNull com.google.android.gms.maps.model.LatLngBounds r9, boolean r10) {
        /*
            r8 = this;
            java.lang.String r0 = "bounds"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.avito.android.search.map.interactor.MapAreaConverter r0 = r8.m
            com.avito.android.avito_map.AvitoMapBounds r9 = com.avito.android.avito_map.google.AvitoGoogleMapKt.toAvitoMapBounds(r9)
            com.avito.android.avito_map.AvitoMapBounds r9 = r0.convertBoundsFromVisible(r9)
            if (r9 == 0) goto L_0x003a
            com.avito.android.avito_map.AvitoMapPoint r0 = r9.getTopLeft()
            double r0 = r0.getLatitude()
            com.avito.android.avito_map.AvitoMapPoint r2 = r9.getBottomRight()
            double r2 = r2.getLatitude()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0039
            com.avito.android.avito_map.AvitoMapPoint r0 = r9.getTopLeft()
            double r0 = r0.getLongitude()
            com.avito.android.avito_map.AvitoMapPoint r2 = r9.getBottomRight()
            double r2 = r2.getLongitude()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x003a
        L_0x0039:
            return
        L_0x003a:
            if (r9 == 0) goto L_0x00a5
            com.avito.android.avito_map.AvitoMap r0 = r8.d
            if (r0 == 0) goto L_0x00a5
            com.avito.android.avito_map.AvitoMapCameraPosition r0 = r0.getMapCameraPosition()
            if (r0 == 0) goto L_0x00a5
            com.avito.android.avito_map.AvitoMapBounds r0 = r0.getViewportBounds()
            if (r0 == 0) goto L_0x00a5
            com.avito.android.avito_map.AvitoMap r1 = r8.d
            if (r1 == 0) goto L_0x00a5
            r2 = 0
            if (r10 == 0) goto L_0x0092
            com.avito.android.avito_map.AvitoMapPoint r10 = r0.getTopLeft()
            com.avito.android.avito_map.AvitoMapPoint r3 = r9.getTopLeft()
            double r4 = r10.getLongitude()
            double r6 = r3.getLongitude()
            r10 = 1
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x006a
            r3 = 1
            goto L_0x006b
        L_0x006a:
            r3 = 0
        L_0x006b:
            if (r3 == 0) goto L_0x0088
            com.avito.android.avito_map.AvitoMapPoint r0 = r0.getBottomRight()
            com.avito.android.avito_map.AvitoMapPoint r3 = r9.getBottomRight()
            double r4 = r0.getLongitude()
            double r6 = r3.getLongitude()
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0083
            r0 = 1
            goto L_0x0084
        L_0x0083:
            r0 = 0
        L_0x0084:
            if (r0 == 0) goto L_0x0088
            r0 = 1
            goto L_0x0089
        L_0x0088:
            r0 = 0
        L_0x0089:
            if (r0 != 0) goto L_0x0095
            boolean r0 = r8.j
            r10 = r10 ^ r0
            r1.moveToBounds(r9, r10, r2)
            goto L_0x0095
        L_0x0092:
            r1.moveToBounds(r9, r2, r2)
        L_0x0095:
            boolean r9 = r8.j
            if (r9 == 0) goto L_0x00a5
            com.avito.android.search.map.metric.SearchMapTracker r9 = r8.n
            r9.trackMapPreparing()
            com.jakewharton.rxrelay3.PublishRelay<kotlin.Unit> r9 = r8.i
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            r9.accept(r10)
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.search.map.view.MapInteractorImpl.setLatLngBounds(com.google.android.gms.maps.model.LatLngBounds, boolean):void");
    }

    @Override // com.avito.android.search.map.view.MapInteractor
    public void setLatLngZoom(@NotNull LatLng latLng, float f2, boolean z) {
        Intrinsics.checkNotNullParameter(latLng, "latLng");
        AvitoMap avitoMap = this.d;
        if (avitoMap != null) {
            avitoMap.moveTo(new AvitoMapPoint(latLng.latitude, latLng.longitude), z, Float.valueOf(f2));
        }
    }

    @Override // com.avito.android.search.map.view.MapInteractor
    public void setMarkerItems(@NotNull List<? extends MarkerItem> list) {
        MarkerItem markerItem;
        Bitmap icon;
        boolean z;
        String str;
        AvitoMapMarker avitoMapMarker;
        Intrinsics.checkNotNullParameter(list, "items");
        HashSet hashSet = CollectionsKt___CollectionsKt.toHashSet(list);
        Set<MarkerItem> keySet = this.a.keySet();
        if (!Intrinsics.areEqual(keySet, hashSet)) {
            List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) CollectionsKt___CollectionsKt.minus((Iterable) list, (Iterable) keySet));
            ArrayList<MarkerItem> arrayList = new ArrayList();
            for (Object obj : mutableList) {
                MarkerItem markerItem2 = (MarkerItem) obj;
                if (markerItem2 instanceof MarkerWithId) {
                    for (T t : this.b) {
                        if (Intrinsics.areEqual(t, ((MarkerWithId) markerItem2).getId())) {
                            Iterator<T> it = this.a.keySet().iterator();
                            while (true) {
                                str = null;
                                if (!it.hasNext()) {
                                    break;
                                }
                                T next = it.next();
                                T t2 = next;
                                if (!(t2 instanceof MarkerItem.Pin)) {
                                    t2 = null;
                                }
                                T t3 = t2;
                                if (t3 != null) {
                                    str = t3.getId();
                                }
                                if (Intrinsics.areEqual(str, t)) {
                                    str = next;
                                    break;
                                }
                            }
                            MarkerItem markerItem3 = (MarkerItem) str;
                            if (!(markerItem3 == null || (avitoMapMarker = this.a.get(markerItem3)) == null)) {
                                this.a.remove(markerItem3);
                                this.a.put(markerItem2, avitoMapMarker);
                            }
                        }
                    }
                    z = this.b.contains(((MarkerWithId) markerItem2).getId());
                } else {
                    z = false;
                }
                if (z) {
                    arrayList.add(obj);
                }
            }
            for (MarkerItem markerItem4 : arrayList) {
                AvitoMapMarker avitoMapMarker2 = this.a.get(markerItem4);
                if (avitoMapMarker2 != null) {
                    Bitmap icon2 = this.l.getIcon(markerItem4);
                    if (icon2 == null) {
                        break;
                    }
                    avitoMapMarker2.changeIcon(icon2, markerItem4.getMapId(), this.f.resolveZIndex(markerItem4), this.e.resolveAnchor(markerItem4));
                    avitoMapMarker2.setData(markerItem4);
                }
            }
            Set<MarkerItem> minus = z.minus((Set) this.a.keySet(), (Iterable) hashSet);
            Set minus2 = z.minus((Set) hashSet, (Iterable) this.a.keySet());
            CollectionsKt___CollectionsKt.reversed(minus2);
            AvitoMap avitoMap = this.d;
            if (avitoMap != null) {
                Iterator it2 = minus2.iterator();
                while (it2.hasNext() && (icon = this.l.getIcon((markerItem = (MarkerItem) it2.next()))) != null) {
                    float resolveZIndex = this.f.resolveZIndex(markerItem);
                    AvitoMapMarker addMarker = avitoMap.addMarker(markerItem.getCoordinates().latitude, markerItem.getCoordinates().longitude, icon, this.e.resolveAnchor(markerItem), resolveZIndex, markerItem.getMapId(), true);
                    addMarker.setZIndex(resolveZIndex);
                    addMarker.setData(markerItem);
                    this.a.put(markerItem, addMarker);
                    if (markerItem instanceof MarkerItem.Pin) {
                        this.b.add(((MarkerItem.Pin) markerItem).getId());
                    }
                }
            }
            AvitoMap avitoMap2 = this.d;
            if (avitoMap2 != null) {
                for (MarkerItem markerItem5 : minus) {
                    AvitoMapMarker remove = this.a.remove(markerItem5);
                    if (remove != null) {
                        avitoMap2.removeMarker(remove, true);
                    }
                    if (markerItem5 instanceof MarkerItem.Pin) {
                        this.b.remove(((MarkerItem.Pin) markerItem5).getId());
                    }
                }
            }
        }
    }

    @Override // com.avito.android.search.map.view.MapInteractor
    public void setMyLocation(@NotNull MarkerItem markerItem) {
        AvitoMapMarker avitoMapMarker;
        AvitoMap avitoMap;
        Pair<? extends MarkerItem, ? extends AvitoMapMarker> pair;
        AvitoMapMarker avitoMapMarker2;
        Intrinsics.checkNotNullParameter(markerItem, "myLocation");
        Pair<? extends MarkerItem, ? extends AvitoMapMarker> pair2 = this.c;
        if ((!Intrinsics.areEqual(pair2 != null ? (MarkerItem) pair2.getFirst() : null, markerItem)) || !((pair = this.c) == null || (avitoMapMarker2 = (AvitoMapMarker) pair.getSecond()) == null || avitoMapMarker2.isVisible())) {
            Pair<? extends MarkerItem, ? extends AvitoMapMarker> pair3 = this.c;
            if (!(pair3 == null || (avitoMapMarker = (AvitoMapMarker) pair3.getSecond()) == null || (avitoMap = this.d) == null)) {
                AvitoMap.DefaultImpls.removeMarker$default(avitoMap, avitoMapMarker, false, 2, null);
            }
            this.c = null;
            AvitoMap avitoMap2 = this.d;
            if (avitoMap2 != null) {
                double d2 = markerItem.getCoordinates().latitude;
                double d3 = markerItem.getCoordinates().longitude;
                Bitmap icon = this.l.getIcon(markerItem);
                if (icon != null) {
                    this.c = new Pair<>(markerItem, AvitoMap.DefaultImpls.addMarker$default(avitoMap2, d2, d3, icon, this.e.resolveAnchor(markerItem), this.f.resolveZIndex(markerItem), markerItem.getMapId(), false, 64, null));
                }
            }
        }
    }

    @Override // com.avito.android.search.map.view.MapInteractor
    public void zoomTo(float f2) {
        this.k = true;
        AvitoMap avitoMap = this.d;
        if (avitoMap != null) {
            avitoMap.zoomTo(f2, true, AvitoMap.AnimationLength.DEFAULT);
        }
    }
}
