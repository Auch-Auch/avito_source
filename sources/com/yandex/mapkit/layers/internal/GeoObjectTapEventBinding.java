package com.yandex.mapkit.layers.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.GeoObject;
import com.yandex.mapkit.layers.GeoObjectTapEvent;
import com.yandex.runtime.NativeObject;
public class GeoObjectTapEventBinding implements GeoObjectTapEvent {
    private final NativeObject nativeObject;

    public GeoObjectTapEventBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.mapkit.layers.GeoObjectTapEvent
    @NonNull
    public native GeoObject getGeoObject();

    @Override // com.yandex.mapkit.layers.GeoObjectTapEvent
    public native boolean isSelected();

    @Override // com.yandex.mapkit.layers.GeoObjectTapEvent
    public native boolean isValid();

    @Override // com.yandex.mapkit.layers.GeoObjectTapEvent
    public native void setSelected(boolean z);
}
