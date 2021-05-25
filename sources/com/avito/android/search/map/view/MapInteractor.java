package com.avito.android.search.map.view;

import com.avito.android.search.map.action.MapViewAction;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00162\b\b\u0002\u0010\u001d\u001a\u00020\u00122\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0018H&¢\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/avito/android/search/map/view/MapInteractor;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/search/map/action/MapViewAction;", "mapActions", "()Lio/reactivex/rxjava3/core/Observable;", "", "mapSettles", "", "Lcom/avito/android/search/map/view/MarkerItem;", "items", "setMarkerItems", "(Ljava/util/List;)V", "myLocation", "setMyLocation", "(Lcom/avito/android/search/map/view/MarkerItem;)V", "Lcom/google/android/gms/maps/model/LatLngBounds;", "bounds", "", "animate", "setLatLngBounds", "(Lcom/google/android/gms/maps/model/LatLngBounds;Z)V", "Lcom/google/android/gms/maps/model/LatLng;", "latLng", "", "zoom", "setLatLngZoom", "(Lcom/google/android/gms/maps/model/LatLng;FZ)V", VKApiConst.POSITION, "animatedByCenteredPin", "zoomLevel", "setLatLng", "(Lcom/google/android/gms/maps/model/LatLng;ZLjava/lang/Float;)V", "zoomTo", "(F)V", "getCurrentZoom", "()Ljava/lang/Float;", "map_release"}, k = 1, mv = {1, 4, 2})
public interface MapInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void setLatLng$default(MapInteractor mapInteractor, LatLng latLng, boolean z, Float f, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                if ((i & 4) != 0) {
                    f = null;
                }
                mapInteractor.setLatLng(latLng, z, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setLatLng");
        }
    }

    @Nullable
    Float getCurrentZoom();

    @NotNull
    Observable<MapViewAction> mapActions();

    @NotNull
    Observable<Unit> mapSettles();

    void setLatLng(@NotNull LatLng latLng, boolean z, @Nullable Float f);

    void setLatLngBounds(@NotNull LatLngBounds latLngBounds, boolean z);

    void setLatLngZoom(@NotNull LatLng latLng, float f, boolean z);

    void setMarkerItems(@NotNull List<? extends MarkerItem> list);

    void setMyLocation(@NotNull MarkerItem markerItem);

    void zoomTo(float f);
}
