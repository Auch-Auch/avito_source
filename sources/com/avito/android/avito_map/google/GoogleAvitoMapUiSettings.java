package com.avito.android.avito_map.google;

import android.content.Context;
import com.avito.android.avito_map.AvitoMapUiSettings;
import com.avito.android.avito_map.R;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.MapStyleOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/avito_map/google/GoogleAvitoMapUiSettings;", "Lcom/avito/android/avito_map/AvitoMapUiSettings;", "", "enable", "", "isMapToolbarEnabled", "(Z)V", "isRotateGesturesEnabled", "isZoomControlsEnabled", "isZoomGesturesEnabled", "isFastTapEnabled", "isMyLocationButtonEnabled", "isCompassEnabled", "isTiltGesturesEnabled", "isMoveGesturesEnabled", "isDarkModeEnabled", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/google/android/gms/maps/GoogleMap;", AuthSource.BOOKING_ORDER, "Lcom/google/android/gms/maps/GoogleMap;", "getMap", "()Lcom/google/android/gms/maps/GoogleMap;", "map", "Lcom/google/android/gms/maps/UiSettings;", AuthSource.SEND_ABUSE, "Lcom/google/android/gms/maps/UiSettings;", "getSettings", "()Lcom/google/android/gms/maps/UiSettings;", "settings", "<init>", "(Lcom/google/android/gms/maps/GoogleMap;Landroid/content/Context;)V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
public final class GoogleAvitoMapUiSettings implements AvitoMapUiSettings {
    @Nullable
    public final UiSettings a;
    @Nullable
    public final GoogleMap b;
    @NotNull
    public final Context c;

    public GoogleAvitoMapUiSettings(@Nullable GoogleMap googleMap, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = googleMap;
        this.c = context;
        this.a = googleMap != null ? googleMap.getUiSettings() : null;
    }

    @NotNull
    public final Context getContext() {
        return this.c;
    }

    @Nullable
    public final GoogleMap getMap() {
        return this.b;
    }

    @Nullable
    public final UiSettings getSettings() {
        return this.a;
    }

    @Override // com.avito.android.avito_map.AvitoMapUiSettings
    public void isCompassEnabled(boolean z) {
        UiSettings uiSettings = this.a;
        if (uiSettings != null) {
            uiSettings.setCompassEnabled(z);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMapUiSettings
    public void isDarkModeEnabled(boolean z) {
        MapStyleOptions loadRawResourceStyle = MapStyleOptions.loadRawResourceStyle(this.c, z ? R.raw.google_mapstyle_dark : R.raw.google_mapstyle_light);
        GoogleMap googleMap = this.b;
        if (googleMap != null) {
            googleMap.setMapStyle(loadRawResourceStyle);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMapUiSettings
    public void isFastTapEnabled(boolean z) {
    }

    @Override // com.avito.android.avito_map.AvitoMapUiSettings
    public void isMapToolbarEnabled(boolean z) {
        UiSettings uiSettings = this.a;
        if (uiSettings != null) {
            uiSettings.setMapToolbarEnabled(z);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMapUiSettings
    public void isMoveGesturesEnabled(boolean z) {
        UiSettings uiSettings = this.a;
        if (uiSettings != null) {
            uiSettings.setScrollGesturesEnabled(z);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMapUiSettings
    public void isMyLocationButtonEnabled(boolean z) {
        UiSettings uiSettings = this.a;
        if (uiSettings != null) {
            uiSettings.setMyLocationButtonEnabled(z);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMapUiSettings
    public void isRotateGesturesEnabled(boolean z) {
        UiSettings uiSettings = this.a;
        if (uiSettings != null) {
            uiSettings.setRotateGesturesEnabled(z);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMapUiSettings
    public void isTiltGesturesEnabled(boolean z) {
        UiSettings uiSettings = this.a;
        if (uiSettings != null) {
            uiSettings.setTiltGesturesEnabled(z);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMapUiSettings
    public void isZoomControlsEnabled(boolean z) {
        UiSettings uiSettings = this.a;
        if (uiSettings != null) {
            uiSettings.setZoomControlsEnabled(z);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMapUiSettings
    public void isZoomGesturesEnabled(boolean z) {
        UiSettings uiSettings = this.a;
        if (uiSettings != null) {
            uiSettings.setZoomGesturesEnabled(z);
        }
    }
}
