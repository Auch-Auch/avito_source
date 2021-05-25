package com.yandex.mapkit.map.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Circle;
import com.yandex.mapkit.map.CircleMapObject;
import com.yandex.runtime.NativeObject;
public class CircleMapObjectBinding extends MapObjectBinding implements CircleMapObject {
    public CircleMapObjectBinding(NativeObject nativeObject) {
        super(nativeObject);
    }

    @Override // com.yandex.mapkit.map.CircleMapObject
    public native int getFillColor();

    @Override // com.yandex.mapkit.map.CircleMapObject
    @NonNull
    public native Circle getGeometry();

    @Override // com.yandex.mapkit.map.CircleMapObject
    public native int getStrokeColor();

    @Override // com.yandex.mapkit.map.CircleMapObject
    public native float getStrokeWidth();

    @Override // com.yandex.mapkit.map.CircleMapObject
    public native boolean isGeodesic();

    @Override // com.yandex.mapkit.map.CircleMapObject
    public native void setFillColor(int i);

    @Override // com.yandex.mapkit.map.CircleMapObject
    public native void setGeodesic(boolean z);

    @Override // com.yandex.mapkit.map.CircleMapObject
    public native void setGeometry(@NonNull Circle circle);

    @Override // com.yandex.mapkit.map.CircleMapObject
    public native void setStrokeColor(int i);

    @Override // com.yandex.mapkit.map.CircleMapObject
    public native void setStrokeWidth(float f);
}
