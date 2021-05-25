package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Polyline;
public interface PolylineMapObject extends MapObject {
    float getDashLength();

    float getDashOffset();

    float getGapLength();

    @NonNull
    Polyline getGeometry();

    int getOutlineColor();

    float getOutlineWidth();

    int getStrokeColor();

    float getStrokeWidth();

    boolean isGeodesic();

    void setDashLength(float f);

    void setDashOffset(float f);

    void setGapLength(float f);

    void setGeodesic(boolean z);

    void setGeometry(@NonNull Polyline polyline);

    void setOutlineColor(int i);

    void setOutlineWidth(float f);

    void setStrokeColor(int i);

    void setStrokeWidth(float f);
}
