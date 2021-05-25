package com.yandex.mapkit.map.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Polygon;
import com.yandex.mapkit.map.PolygonMapObject;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.image.AnimatedImageProvider;
public class PolygonMapObjectBinding extends MapObjectBinding implements PolygonMapObject {
    public PolygonMapObjectBinding(NativeObject nativeObject) {
        super(nativeObject);
    }

    @Override // com.yandex.mapkit.map.PolygonMapObject
    public native int getFillColor();

    @Override // com.yandex.mapkit.map.PolygonMapObject
    @NonNull
    public native Polygon getGeometry();

    @Override // com.yandex.mapkit.map.PolygonMapObject
    public native int getStrokeColor();

    @Override // com.yandex.mapkit.map.PolygonMapObject
    public native float getStrokeWidth();

    @Override // com.yandex.mapkit.map.PolygonMapObject
    public native boolean isGeodesic();

    @Override // com.yandex.mapkit.map.PolygonMapObject
    public native void resetAnimatedImage();

    @Override // com.yandex.mapkit.map.PolygonMapObject
    public native void setAnimatedImage(@NonNull AnimatedImageProvider animatedImageProvider, float f);

    @Override // com.yandex.mapkit.map.PolygonMapObject
    public native void setFillColor(int i);

    @Override // com.yandex.mapkit.map.PolygonMapObject
    public native void setGeodesic(boolean z);

    @Override // com.yandex.mapkit.map.PolygonMapObject
    public native void setGeometry(@NonNull Polygon polygon);

    @Override // com.yandex.mapkit.map.PolygonMapObject
    public native void setStrokeColor(int i);

    @Override // com.yandex.mapkit.map.PolygonMapObject
    public native void setStrokeWidth(float f);
}
