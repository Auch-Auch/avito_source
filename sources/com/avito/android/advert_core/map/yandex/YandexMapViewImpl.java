package com.avito.android.advert_core.map.yandex;

import android.view.View;
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.map.MapLiteModeView;
import com.avito.android.advert_core.map.MapView;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactory;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert_core/map/yandex/YandexMapViewImpl;", "Lcom/avito/android/advert_core/map/MapView;", "Lcom/avito/android/advert_core/map/MapLiteModeView;", VKApiConst.VERSION, "Lcom/avito/android/advert_core/map/MapLiteModeView;", "getLiteModeMapView", "()Lcom/avito/android/advert_core/map/MapLiteModeView;", "liteModeMapView", "Landroid/view/View;", "view", "Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;", "markerIconFactory", "<init>", "(Landroid/view/View;Lcom/avito/android/avito_map/amenity/AmenityMarkerIconFactory;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class YandexMapViewImpl extends MapView {
    @NotNull
    public final MapLiteModeView v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public YandexMapViewImpl(@NotNull View view, @NotNull AmenityMarkerIconFactory amenityMarkerIconFactory) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(amenityMarkerIconFactory, "markerIconFactory");
        View findViewById = view.findViewById(R.id.developments_catalog_yandex_map);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.d…ments_catalog_yandex_map)");
        this.v = new YandexMapLiteModeViewImpl((com.yandex.mapkit.mapview.MapView) findViewById, amenityMarkerIconFactory);
    }

    @Override // com.avito.android.advert_core.map.MapView
    @NotNull
    public MapLiteModeView getLiteModeMapView() {
        return this.v;
    }
}
