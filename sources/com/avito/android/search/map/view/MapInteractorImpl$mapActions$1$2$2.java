package com.avito.android.search.map.view;

import com.avito.android.avito_map.AvitoMap;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.google.AvitoGoogleMapKt;
import com.avito.android.search.map.action.MapViewAction;
import com.avito.android.search.map.view.MapInteractorImpl;
import com.google.android.gms.maps.model.LatLngBounds;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/avito/android/search/map/view/MapInteractorImpl$mapActions$1$2$2", "Lcom/avito/android/avito_map/AvitoMap$MapMoveEndListener;", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "mapCameraPosition", "", "onMapSettled", "(Lcom/avito/android/avito_map/AvitoMapCameraPosition;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class MapInteractorImpl$mapActions$1$2$2 implements AvitoMap.MapMoveEndListener {
    public final /* synthetic */ MapInteractorImpl.a.b a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public MapInteractorImpl$mapActions$1$2$2(MapInteractorImpl.a.b bVar) {
        this.a = bVar;
    }

    @Override // com.avito.android.avito_map.AvitoMap.MapMoveEndListener
    public void onMapSettled(@NotNull AvitoMapCameraPosition avitoMapCameraPosition) {
        AvitoMapCameraPosition mapCameraPosition;
        AvitoMapBounds viewportBounds;
        Intrinsics.checkNotNullParameter(avitoMapCameraPosition, "mapCameraPosition");
        if (this.a.a.a.h) {
            this.a.a.a.h = false;
            return;
        }
        AvitoMap avitoMap = this.a.a.a.d;
        if (avitoMap != null && (mapCameraPosition = avitoMap.getMapCameraPosition()) != null && (viewportBounds = mapCameraPosition.getViewportBounds()) != null) {
            float zoomLevel = mapCameraPosition.getZoomLevel();
            AvitoMapBounds convertBoundsToVisible = this.a.a.a.m.convertBoundsToVisible(viewportBounds);
            if (convertBoundsToVisible != null) {
                LatLngBounds latLngBounds = AvitoGoogleMapKt.toLatLngBounds(convertBoundsToVisible);
                if (this.a.a.a.g) {
                    this.a.b.onNext(new MapViewAction.MapGestureMovedEnd(latLngBounds, zoomLevel));
                }
                if (!(this.a.a.a.j) || (this.a.a.a.g)) {
                    this.a.b.onNext(new MapViewAction.MapMoved(latLngBounds, zoomLevel));
                }
                this.a.a.a.j = false;
            }
        }
    }
}
