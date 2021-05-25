package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Polygon;
import com.yandex.runtime.image.AnimatedImageProvider;
public interface PolygonMapObject extends MapObject {
    int getFillColor();

    @NonNull
    Polygon getGeometry();

    int getStrokeColor();

    float getStrokeWidth();

    boolean isGeodesic();

    void resetAnimatedImage();

    void setAnimatedImage(@NonNull AnimatedImageProvider animatedImageProvider, float f);

    void setFillColor(int i);

    void setGeodesic(boolean z);

    void setGeometry(@NonNull Polygon polygon);

    void setStrokeColor(int i);

    void setStrokeWidth(float f);
}
