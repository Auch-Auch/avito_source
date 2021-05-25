package com.avito.android.advert_core.map.google;

import a2.a.a.g.g.a.a;
import android.content.Context;
import com.avito.android.advert_core.map.MapLiteModeView;
import com.avito.android.advert_core.map.MapLiteModeViewKt;
import com.avito.android.avito_map.AvitoMap;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.AvitoMapUiSettings;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactory;
import com.avito.android.avito_map.google.AvitoGoogleMap;
import com.avito.android.item_map.remote.model.AmenityPin;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.item.details.ParameterId;
import com.avito.android.remote.model.Coordinates;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.h;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b$\u0010%J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/avito/android/advert_core/map/google/GoogleMapLiteModeViewImpl;", "Lcom/avito/android/advert_core/map/MapLiteModeView;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "Lcom/avito/android/remote/model/Coordinates;", ParameterId.COORDS, "", "Lcom/avito/android/item_map/remote/model/AmenityPin;", "pins", "Lcom/avito/android/avito_map/AvitoMap$MapClickListener;", "clickListener", "", "bindView", "(Lcom/avito/android/remote/model/Coordinates;Ljava/util/List;Lcom/avito/android/avito_map/AvitoMap$MapClickListener;)V", "Lcom/google/android/gms/maps/GoogleMap;", "googleMap", "onMapReady", "(Lcom/google/android/gms/maps/GoogleMap;)V", "c", "Ljava/util/List;", "Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;", "f", "Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;", "markerIconFactory", "Lcom/avito/android/avito_map/google/AvitoGoogleMap;", AuthSource.SEND_ABUSE, "Lcom/avito/android/avito_map/google/AvitoGoogleMap;", "avitoMap", "Lcom/avito/android/avito_map/AvitoMapPoint;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/avito_map/AvitoMapPoint;", "Lcom/google/android/gms/maps/MapView;", "e", "Lcom/google/android/gms/maps/MapView;", "mapView", "d", "Lcom/avito/android/avito_map/AvitoMap$MapClickListener;", "<init>", "(Lcom/google/android/gms/maps/MapView;Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class GoogleMapLiteModeViewImpl implements MapLiteModeView, OnMapReadyCallback {
    public AvitoGoogleMap a;
    public AvitoMapPoint b;
    public List<AmenityPin> c;
    public AvitoMap.MapClickListener d;
    public final MapView e;
    public final AmenityMarkerIconFactory f;

    public GoogleMapLiteModeViewImpl(@NotNull MapView mapView, @Nullable AmenityMarkerIconFactory amenityMarkerIconFactory) {
        Intrinsics.checkNotNullParameter(mapView, "mapView");
        this.e = mapView;
        this.f = amenityMarkerIconFactory;
        this.c = CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // com.avito.android.advert_core.map.MapLiteModeView
    public void bindView(@NotNull Coordinates coordinates, @NotNull List<AmenityPin> list, @NotNull AvitoMap.MapClickListener mapClickListener) {
        Intrinsics.checkNotNullParameter(coordinates, ParameterId.COORDS);
        Intrinsics.checkNotNullParameter(list, "pins");
        Intrinsics.checkNotNullParameter(mapClickListener, "clickListener");
        this.b = new AvitoMapPoint(coordinates.getLatitude(), coordinates.getLongitude());
        this.d = mapClickListener;
        this.c = list;
        if (this.a == null) {
            this.e.onCreate(null);
            this.e.getMapAsync(this);
        }
    }

    @Override // com.google.android.gms.maps.OnMapReadyCallback
    public void onMapReady(@Nullable GoogleMap googleMap) {
        AvitoMapPoint avitoMapPoint;
        MapsInitializer.initialize(this.e.getContext());
        if (googleMap != null) {
            Context context = this.e.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mapView.context");
            this.a = new AvitoGoogleMap(googleMap, context);
            googleMap.setMapType(1);
            AvitoGoogleMap avitoGoogleMap = this.a;
            if (avitoGoogleMap != null && (avitoMapPoint = this.b) != null) {
                avitoGoogleMap.addMarker(avitoMapPoint, AvitoMapMarker.Type.MARKER_PIN_DEFAULT_RED, AvitoMapMarker.Anchor.CENTER, Float.valueOf(1.0f));
                if (this.c.isEmpty()) {
                    avitoGoogleMap.moveTo(avitoMapPoint, false, Float.valueOf(16.0f));
                } else {
                    List<AvitoMapPoint> mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(avitoMapPoint);
                    List<AmenityPin> list = this.c;
                    ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(MapLiteModeViewKt.toAvitoMapPoint(it.next().getCoordinates()));
                    }
                    h.addAll(mutableListOf, arrayList);
                    avitoGoogleMap.moveToPointsWithPadding(mutableListOf, 0, false);
                    AvitoMap.DefaultImpls.zoomTo$default(avitoGoogleMap, avitoGoogleMap.getMapTarget().getZoomLevel() - 1.0f, false, null, 6, null);
                    this.e.post(new a(this, avitoGoogleMap));
                }
                AvitoMapUiSettings uiSettings = avitoGoogleMap.getUiSettings();
                uiSettings.isMyLocationButtonEnabled(false);
                uiSettings.isRotateGesturesEnabled(false);
                uiSettings.isTiltGesturesEnabled(false);
                uiSettings.isCompassEnabled(false);
                uiSettings.isMapToolbarEnabled(false);
                avitoGoogleMap.addMapClickListener(this.d);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GoogleMapLiteModeViewImpl(MapView mapView, AmenityMarkerIconFactory amenityMarkerIconFactory, int i, j jVar) {
        this(mapView, (i & 2) != 0 ? null : amenityMarkerIconFactory);
    }
}
