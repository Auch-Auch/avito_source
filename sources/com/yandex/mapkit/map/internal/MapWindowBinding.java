package com.yandex.mapkit.map.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.mapkit.ScreenPoint;
import com.yandex.mapkit.ScreenRect;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.Map;
import com.yandex.mapkit.map.MapWindow;
import com.yandex.mapkit.map.PointOfView;
import com.yandex.mapkit.map.SizeChangedListener;
import com.yandex.mapkit.map.VisibleRegion;
import com.yandex.mapkit.map.ZoomFocusPointMode;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.subscription.Subscription;
public class MapWindowBinding implements MapWindow {
    private final NativeObject nativeObject;
    private Subscription<SizeChangedListener> sizeChangedListenerSubscription = new Subscription<SizeChangedListener>() { // from class: com.yandex.mapkit.map.internal.MapWindowBinding.1
        public NativeObject createNativeListener(SizeChangedListener sizeChangedListener) {
            return MapWindowBinding.createSizeChangedListener(sizeChangedListener);
        }
    };

    public MapWindowBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    /* access modifiers changed from: private */
    public static native NativeObject createSizeChangedListener(SizeChangedListener sizeChangedListener);

    @Override // com.yandex.mapkit.map.MapWindow
    public native void addSizeChangedListener(@NonNull SizeChangedListener sizeChangedListener);

    @Override // com.yandex.mapkit.map.MapWindow
    public native double getFieldOfViewY();

    @Override // com.yandex.mapkit.map.MapWindow
    @Nullable
    public native ScreenRect getFocusRect();

    @Override // com.yandex.mapkit.map.MapWindow
    @NonNull
    public native VisibleRegion getFocusRegion();

    @Override // com.yandex.mapkit.map.MapWindow
    @NonNull
    public native Map getMap();

    @Override // com.yandex.mapkit.map.MapWindow
    @NonNull
    public native PointOfView getPointOfView();

    @Override // com.yandex.mapkit.map.MapWindow
    public native float getScaleFactor();

    @Override // com.yandex.mapkit.map.MapWindow
    @Nullable
    public native ScreenPoint getZoomFocusPoint();

    @Override // com.yandex.mapkit.map.MapWindow
    @NonNull
    public native ZoomFocusPointMode getZoomFocusPointMode();

    @Override // com.yandex.mapkit.map.MapWindow
    public native int height();

    @Override // com.yandex.mapkit.map.MapWindow
    public native boolean isValid();

    @Override // com.yandex.mapkit.map.MapWindow
    public native void onMemoryWarning();

    @Override // com.yandex.mapkit.map.MapWindow
    public native void removeSizeChangedListener(@NonNull SizeChangedListener sizeChangedListener);

    @Override // com.yandex.mapkit.map.MapWindow
    @Nullable
    public native Point screenToWorld(@NonNull ScreenPoint screenPoint);

    @Override // com.yandex.mapkit.map.MapWindow
    public native void setFieldOfViewY(double d);

    @Override // com.yandex.mapkit.map.MapWindow
    public native void setFocusRect(@Nullable ScreenRect screenRect);

    @Override // com.yandex.mapkit.map.MapWindow
    public native void setMaxFps(float f);

    @Override // com.yandex.mapkit.map.MapWindow
    public native void setPointOfView(@NonNull PointOfView pointOfView);

    @Override // com.yandex.mapkit.map.MapWindow
    public native void setScaleFactor(float f);

    @Override // com.yandex.mapkit.map.MapWindow
    public native void setZoomFocusPoint(@Nullable ScreenPoint screenPoint);

    @Override // com.yandex.mapkit.map.MapWindow
    public native void setZoomFocusPointMode(@NonNull ZoomFocusPointMode zoomFocusPointMode);

    @Override // com.yandex.mapkit.map.MapWindow
    public native void startPerformanceMetricsCapture();

    @Override // com.yandex.mapkit.map.MapWindow
    @NonNull
    public native String stopPerformanceMetricsCapture();

    @Override // com.yandex.mapkit.map.MapWindow
    public native int width();

    @Override // com.yandex.mapkit.map.MapWindow
    @Nullable
    public native ScreenPoint worldToScreen(@NonNull Point point);
}
