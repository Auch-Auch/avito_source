package com.avito.android.avito_map.yandex;

import com.avito.android.avito_map.AvitoMapUiSettings;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mapkit.map.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/avito_map/yandex/YandexAvitoMapUiSettings;", "Lcom/avito/android/avito_map/AvitoMapUiSettings;", "", "enable", "", "isMapToolbarEnabled", "(Z)V", "isRotateGesturesEnabled", "isZoomControlsEnabled", "isZoomGesturesEnabled", "isFastTapEnabled", "isMyLocationButtonEnabled", "isCompassEnabled", "isTiltGesturesEnabled", "isMoveGesturesEnabled", "isDarkModeEnabled", "Lcom/yandex/mapkit/map/Map;", AuthSource.SEND_ABUSE, "Lcom/yandex/mapkit/map/Map;", "getMap", "()Lcom/yandex/mapkit/map/Map;", "map", "<init>", "(Lcom/yandex/mapkit/map/Map;)V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
public final class YandexAvitoMapUiSettings implements AvitoMapUiSettings {
    @NotNull
    public final Map a;

    public YandexAvitoMapUiSettings(@NotNull Map map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.a = map;
    }

    @NotNull
    public final Map getMap() {
        return this.a;
    }

    @Override // com.avito.android.avito_map.AvitoMapUiSettings
    public void isCompassEnabled(boolean z) {
    }

    @Override // com.avito.android.avito_map.AvitoMapUiSettings
    public void isDarkModeEnabled(boolean z) {
        this.a.setNightModeEnabled(z);
    }

    @Override // com.avito.android.avito_map.AvitoMapUiSettings
    public void isFastTapEnabled(boolean z) {
        this.a.setFastTapEnabled(z);
    }

    @Override // com.avito.android.avito_map.AvitoMapUiSettings
    public void isMapToolbarEnabled(boolean z) {
    }

    @Override // com.avito.android.avito_map.AvitoMapUiSettings
    public void isMoveGesturesEnabled(boolean z) {
        this.a.setScrollGesturesEnabled(z);
    }

    @Override // com.avito.android.avito_map.AvitoMapUiSettings
    public void isMyLocationButtonEnabled(boolean z) {
    }

    @Override // com.avito.android.avito_map.AvitoMapUiSettings
    public void isRotateGesturesEnabled(boolean z) {
        this.a.setRotateGesturesEnabled(z);
    }

    @Override // com.avito.android.avito_map.AvitoMapUiSettings
    public void isTiltGesturesEnabled(boolean z) {
        this.a.setTiltGesturesEnabled(z);
    }

    @Override // com.avito.android.avito_map.AvitoMapUiSettings
    public void isZoomControlsEnabled(boolean z) {
    }

    @Override // com.avito.android.avito_map.AvitoMapUiSettings
    public void isZoomGesturesEnabled(boolean z) {
        this.a.setZoomGesturesEnabled(z);
    }
}
