package com.avito.android.advert_core.map.yandex;

import a2.a.a.g.g.b.a;
import com.avito.android.advert_core.map.MapLiteModeView;
import com.avito.android.advert_core.map.MapLiteModeViewKt;
import com.avito.android.avito_map.AvitoMap;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.AvitoMapUiSettings;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactory;
import com.avito.android.avito_map.yandex.AvitoYandexMap;
import com.avito.android.item_map.remote.model.AmenityPin;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.item.details.ParameterId;
import com.avito.android.remote.model.Coordinates;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.mapview.MapView;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u001f\u0010 J-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/avito/android/advert_core/map/yandex/YandexMapLiteModeViewImpl;", "Lcom/avito/android/advert_core/map/MapLiteModeView;", "Lcom/avito/android/remote/model/Coordinates;", ParameterId.COORDS, "", "Lcom/avito/android/item_map/remote/model/AmenityPin;", "pins", "Lcom/avito/android/avito_map/AvitoMap$MapClickListener;", "clickListener", "", "bindView", "(Lcom/avito/android/remote/model/Coordinates;Ljava/util/List;Lcom/avito/android/avito_map/AvitoMap$MapClickListener;)V", "Lcom/yandex/mapkit/mapview/MapView;", "e", "Lcom/yandex/mapkit/mapview/MapView;", "mapView", "Lcom/avito/android/avito_map/yandex/AvitoYandexMap;", AuthSource.SEND_ABUSE, "Lcom/avito/android/avito_map/yandex/AvitoYandexMap;", "avitoMap", "Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;", "f", "Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;", "markerIconFactory", "d", "Lcom/avito/android/avito_map/AvitoMap$MapClickListener;", "Lcom/avito/android/avito_map/AvitoMapPoint;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/avito_map/AvitoMapPoint;", "c", "Ljava/util/List;", "<init>", "(Lcom/yandex/mapkit/mapview/MapView;Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class YandexMapLiteModeViewImpl implements MapLiteModeView {
    public AvitoYandexMap a;
    public AvitoMapPoint b;
    public List<AmenityPin> c;
    public AvitoMap.MapClickListener d;
    public final MapView e;
    public final AmenityMarkerIconFactory f;

    public YandexMapLiteModeViewImpl(@NotNull MapView mapView, @Nullable AmenityMarkerIconFactory amenityMarkerIconFactory) {
        Intrinsics.checkNotNullParameter(mapView, "mapView");
        this.e = mapView;
        this.f = amenityMarkerIconFactory;
        this.c = CollectionsKt__CollectionsKt.emptyList();
        MapKitFactory.initialize(mapView.getContext());
    }

    @Override // com.avito.android.advert_core.map.MapLiteModeView
    public void bindView(@NotNull Coordinates coordinates, @NotNull List<AmenityPin> list, @NotNull AvitoMap.MapClickListener mapClickListener) {
        AvitoMapPoint avitoMapPoint;
        Intrinsics.checkNotNullParameter(coordinates, ParameterId.COORDS);
        Intrinsics.checkNotNullParameter(list, "pins");
        Intrinsics.checkNotNullParameter(mapClickListener, "clickListener");
        this.b = new AvitoMapPoint(coordinates.getLatitude(), coordinates.getLongitude());
        this.d = mapClickListener;
        this.c = list;
        if (this.a == null) {
            this.e.onStart();
            MapKitFactory.getInstance().onStart();
            AvitoYandexMap avitoYandexMap = new AvitoYandexMap(this.e);
            this.a = avitoYandexMap;
            if (avitoYandexMap != null && (avitoMapPoint = this.b) != null) {
                avitoYandexMap.addMarker(avitoMapPoint, AvitoMapMarker.Type.MARKER_PIN_DEFAULT_RED, AvitoMapMarker.Anchor.CENTER, Float.valueOf(1.0f));
                if (this.c.isEmpty()) {
                    avitoYandexMap.moveTo(avitoMapPoint, false, Float.valueOf(16.0f));
                } else {
                    List<AvitoMapPoint> mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(avitoMapPoint);
                    List<AmenityPin> list2 = this.c;
                    ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list2, 10));
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(MapLiteModeViewKt.toAvitoMapPoint(it.next().getCoordinates()));
                    }
                    h.addAll(mutableListOf, arrayList);
                    avitoYandexMap.moveToPointsWithPadding(mutableListOf, 0, false);
                    AvitoMap.DefaultImpls.zoomTo$default(avitoYandexMap, avitoYandexMap.getMapTarget().getZoomLevel() - 1.0f, false, null, 6, null);
                    this.e.post(new a(this, avitoYandexMap));
                }
                AvitoMapUiSettings uiSettings = avitoYandexMap.getUiSettings();
                uiSettings.isMyLocationButtonEnabled(false);
                uiSettings.isRotateGesturesEnabled(false);
                uiSettings.isTiltGesturesEnabled(false);
                uiSettings.isCompassEnabled(false);
                uiSettings.isMapToolbarEnabled(false);
                uiSettings.isZoomGesturesEnabled(false);
                uiSettings.isFastTapEnabled(false);
                uiSettings.isMoveGesturesEnabled(false);
                avitoYandexMap.addMapClickListener(this.d);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ YandexMapLiteModeViewImpl(MapView mapView, AmenityMarkerIconFactory amenityMarkerIconFactory, int i, j jVar) {
        this(mapView, (i & 2) != 0 ? null : amenityMarkerIconFactory);
    }
}
