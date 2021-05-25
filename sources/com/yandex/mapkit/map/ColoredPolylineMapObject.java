package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Polyline;
import com.yandex.mapkit.geometry.PolylinePosition;
import com.yandex.mapkit.geometry.Subpolyline;
import java.util.List;
public interface ColoredPolylineMapObject extends MapObject {
    @NonNull
    Arrow addArrow(@NonNull PolylinePosition polylinePosition, float f, int i);

    void addArrowTapListener(@NonNull ArrowTapListener arrowTapListener);

    @NonNull
    List<Arrow> arrows();

    float getArcApproximationStep();

    @NonNull
    Polyline getGeometry();

    float getGradientLength();

    int getOutlineColor();

    float getOutlineWidth();

    float getStrokeWidth();

    float getTurnRadius();

    void hide(@NonNull Subpolyline subpolyline);

    void hide(@NonNull List<Subpolyline> list);

    boolean isInnerOutlineEnabled();

    void removeArrowTapListener(@NonNull ArrowTapListener arrowTapListener);

    void select(int i, @NonNull Subpolyline subpolyline);

    void setArcApproximationStep(float f);

    void setColors(@NonNull List<Integer> list);

    void setColors(@NonNull List<Integer> list, @NonNull List<Double> list2);

    void setGeometry(@NonNull Polyline polyline);

    void setGradientLength(float f);

    void setInnerOutlineEnabled(boolean z);

    void setOutlineColor(int i);

    void setOutlineWidth(float f);

    void setPaletteColor(int i, int i2);

    void setStrokeWidth(float f);

    void setTurnRadius(float f);
}
