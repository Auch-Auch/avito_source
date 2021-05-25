package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Circle;
public interface CircleMapObject extends MapObject {
    int getFillColor();

    @NonNull
    Circle getGeometry();

    int getStrokeColor();

    float getStrokeWidth();

    boolean isGeodesic();

    void setFillColor(int i);

    void setGeodesic(boolean z);

    void setGeometry(@NonNull Circle circle);

    void setStrokeColor(int i);

    void setStrokeWidth(float f);
}
