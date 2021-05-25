package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.mapkit.ScreenPoint;
import com.yandex.mapkit.ScreenRect;
import com.yandex.mapkit.geometry.Point;
public interface MapWindow {
    void addSizeChangedListener(@NonNull SizeChangedListener sizeChangedListener);

    double getFieldOfViewY();

    @Nullable
    ScreenRect getFocusRect();

    @NonNull
    VisibleRegion getFocusRegion();

    @NonNull
    Map getMap();

    @NonNull
    PointOfView getPointOfView();

    float getScaleFactor();

    @Nullable
    ScreenPoint getZoomFocusPoint();

    @NonNull
    ZoomFocusPointMode getZoomFocusPointMode();

    int height();

    boolean isValid();

    void onMemoryWarning();

    void removeSizeChangedListener(@NonNull SizeChangedListener sizeChangedListener);

    @Nullable
    Point screenToWorld(@NonNull ScreenPoint screenPoint);

    void setFieldOfViewY(double d);

    void setFocusRect(@Nullable ScreenRect screenRect);

    void setMaxFps(float f);

    void setPointOfView(@NonNull PointOfView pointOfView);

    void setScaleFactor(float f);

    void setZoomFocusPoint(@Nullable ScreenPoint screenPoint);

    void setZoomFocusPointMode(@NonNull ZoomFocusPointMode zoomFocusPointMode);

    void startPerformanceMetricsCapture();

    @NonNull
    String stopPerformanceMetricsCapture();

    int width();

    @Nullable
    ScreenPoint worldToScreen(@NonNull Point point);
}
