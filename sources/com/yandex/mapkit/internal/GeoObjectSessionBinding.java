package com.yandex.mapkit.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.GeoObjectSession;
import com.yandex.runtime.NativeObject;
public class GeoObjectSessionBinding implements GeoObjectSession {
    private final NativeObject nativeObject;

    public GeoObjectSessionBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.mapkit.GeoObjectSession
    public native void cancel();

    @Override // com.yandex.mapkit.GeoObjectSession
    public native void retry(@NonNull GeoObjectSession.GeoObjectListener geoObjectListener);
}
