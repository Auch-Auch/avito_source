package com.yandex.mapkit.map.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.ConflictResolutionMode;
import com.yandex.mapkit.map.Sublayer;
import com.yandex.mapkit.map.SublayerFeatureFilter;
import com.yandex.mapkit.map.SublayerFeatureType;
import com.yandex.runtime.NativeObject;
public class SublayerBinding implements Sublayer {
    private final NativeObject nativeObject;

    public SublayerBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.mapkit.map.Sublayer
    @NonNull
    public native SublayerFeatureType getFeatureType();

    @Override // com.yandex.mapkit.map.Sublayer
    @NonNull
    public native SublayerFeatureFilter getFilter();

    @Override // com.yandex.mapkit.map.Sublayer
    @NonNull
    public native String getLayerId();

    @Override // com.yandex.mapkit.map.Sublayer
    @NonNull
    public native ConflictResolutionMode getModeAgainstLabels();

    @Override // com.yandex.mapkit.map.Sublayer
    @NonNull
    public native ConflictResolutionMode getModeAgainstPlacemarks();

    @Override // com.yandex.mapkit.map.Sublayer
    public native boolean isValid();

    @Override // com.yandex.mapkit.map.Sublayer
    public native boolean isVisible();

    @Override // com.yandex.mapkit.map.Sublayer
    public native void setFeatureType(@NonNull SublayerFeatureType sublayerFeatureType);

    @Override // com.yandex.mapkit.map.Sublayer
    public native void setLayerId(@NonNull String str);

    @Override // com.yandex.mapkit.map.Sublayer
    public native void setModeAgainstLabels(@NonNull ConflictResolutionMode conflictResolutionMode);

    @Override // com.yandex.mapkit.map.Sublayer
    public native void setModeAgainstPlacemarks(@NonNull ConflictResolutionMode conflictResolutionMode);

    @Override // com.yandex.mapkit.map.Sublayer
    public native void setVisible(boolean z);
}
