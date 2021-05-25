package com.yandex.mapkit.map.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Polyline;
import com.yandex.mapkit.map.PolylineMapObject;
import com.yandex.runtime.NativeObject;
public class PolylineMapObjectBinding extends MapObjectBinding implements PolylineMapObject {
    public PolylineMapObjectBinding(NativeObject nativeObject) {
        super(nativeObject);
    }

    @Override // com.yandex.mapkit.map.PolylineMapObject
    public native float getDashLength();

    @Override // com.yandex.mapkit.map.PolylineMapObject
    public native float getDashOffset();

    @Override // com.yandex.mapkit.map.PolylineMapObject
    public native float getGapLength();

    @Override // com.yandex.mapkit.map.PolylineMapObject
    @NonNull
    public native Polyline getGeometry();

    @Override // com.yandex.mapkit.map.PolylineMapObject
    public native int getOutlineColor();

    @Override // com.yandex.mapkit.map.PolylineMapObject
    public native float getOutlineWidth();

    @Override // com.yandex.mapkit.map.PolylineMapObject
    public native int getStrokeColor();

    @Override // com.yandex.mapkit.map.PolylineMapObject
    public native float getStrokeWidth();

    @Override // com.yandex.mapkit.map.PolylineMapObject
    public native boolean isGeodesic();

    @Override // com.yandex.mapkit.map.PolylineMapObject
    public native void setDashLength(float f);

    @Override // com.yandex.mapkit.map.PolylineMapObject
    public native void setDashOffset(float f);

    @Override // com.yandex.mapkit.map.PolylineMapObject
    public native void setGapLength(float f);

    @Override // com.yandex.mapkit.map.PolylineMapObject
    public native void setGeodesic(boolean z);

    @Override // com.yandex.mapkit.map.PolylineMapObject
    public native void setGeometry(@NonNull Polyline polyline);

    @Override // com.yandex.mapkit.map.PolylineMapObject
    public native void setOutlineColor(int i);

    @Override // com.yandex.mapkit.map.PolylineMapObject
    public native void setOutlineWidth(float f);

    @Override // com.yandex.mapkit.map.PolylineMapObject
    public native void setStrokeColor(int i);

    @Override // com.yandex.mapkit.map.PolylineMapObject
    public native void setStrokeWidth(float f);
}
