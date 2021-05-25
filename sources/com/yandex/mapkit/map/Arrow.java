package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.PolylinePosition;
public interface Arrow {
    int getFillColor();

    float getLength();

    int getOutlineColor();

    float getOutlineWidth();

    @NonNull
    PolylinePosition getPosition();

    float getTriangleHeight();

    boolean isValid();

    boolean isVisible();

    void setFillColor(int i);

    void setLength(float f);

    void setOutlineColor(int i);

    void setOutlineWidth(float f);

    void setPosition(@NonNull PolylinePosition polylinePosition);

    void setTriangleHeight(float f);

    void setVisible(boolean z);
}
