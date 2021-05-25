package com.avito.android.advert_core.map;

import com.avito.android.avito_map.AvitoMap;
import com.avito.android.avito_map.AvitoMapTarget;
import com.avito.android.developments_catalog.remote.model.MapPreview;
import com.avito.android.item_map.remote.model.AmenityPin;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Coordinates;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0007¢\u0006\u0004\b\u001a\u0010\u0015J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/avito/android/advert_core/map/MapPresenterImpl;", "Lcom/avito/android/advert_core/map/MapPresenter;", "Lcom/avito/android/avito_map/AvitoMap$MapClickListener;", "Lcom/avito/android/advert_core/map/MapView;", "view", "Lcom/avito/android/advert_core/map/MapItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert_core/map/MapView;Lcom/avito/android/advert_core/map/MapItem;I)V", "Lcom/avito/android/avito_map/AvitoMapTarget;", "mapTarget", "onMapClicked", "(Lcom/avito/android/avito_map/AvitoMapTarget;)V", "Lcom/avito/android/advert_core/map/MapPreviewRouter;", "router", "attachRouter", "(Lcom/avito/android/advert_core/map/MapPreviewRouter;)V", "detachRouter", "()V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/map/MapItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/map/MapPreviewRouter;", "<init>", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class MapPresenterImpl implements MapPresenter, AvitoMap.MapClickListener {
    public MapPreviewRouter a;
    public MapItem b;

    @Override // com.avito.android.advert_core.map.MapPresenter
    public void attachRouter(@Nullable MapPreviewRouter mapPreviewRouter) {
        this.a = mapPreviewRouter;
    }

    @Override // com.avito.android.advert_core.map.MapPresenter
    public void detachRouter() {
        this.a = null;
    }

    @Override // com.avito.android.avito_map.AvitoMap.MapClickListener
    public void onMapClicked(@NotNull AvitoMapTarget avitoMapTarget) {
        MapPreviewRouter mapPreviewRouter;
        Intrinsics.checkNotNullParameter(avitoMapTarget, "mapTarget");
        MapItem mapItem = this.b;
        if (mapItem != null && (mapPreviewRouter = this.a) != null) {
            mapPreviewRouter.mapPreviewClicked(mapItem.getItemId(), mapItem.getAddress(), mapItem.getCoords(), mapItem.getTitle(), mapItem.getAmenityButtons());
        }
    }

    public void bindView(@NotNull MapView mapView, @NotNull MapItem mapItem, int i) {
        Intrinsics.checkNotNullParameter(mapView, "view");
        Intrinsics.checkNotNullParameter(mapItem, "item");
        this.b = mapItem;
        Coordinates coords = mapItem.getCoords();
        MapPreview mapPreview = mapItem.getMapPreview();
        List<AmenityPin> pins = mapPreview != null ? mapPreview.getPins() : null;
        if (pins == null) {
            pins = CollectionsKt__CollectionsKt.emptyList();
        }
        MapPreview mapPreview2 = mapItem.getMapPreview();
        String header = mapPreview2 != null ? mapPreview2.getHeader() : null;
        MapPreview mapPreview3 = mapItem.getMapPreview();
        String objects = mapPreview3 != null ? mapPreview3.getObjects() : null;
        MapPreview mapPreview4 = mapItem.getMapPreview();
        mapView.setMap(coords, pins, this, header, objects, mapPreview4 != null ? mapPreview4.getDistance() : null);
    }
}
