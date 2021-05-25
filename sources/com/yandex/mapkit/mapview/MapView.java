package com.yandex.mapkit.mapview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.ScreenPoint;
import com.yandex.mapkit.ScreenRect;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.Map;
import com.yandex.mapkit.map.MapWindow;
import com.yandex.mapkit.map.PointOfView;
import com.yandex.mapkit.map.SizeChangedListener;
import com.yandex.mapkit.map.VisibleRegion;
import com.yandex.mapkit.map.ZoomFocusPointMode;
import com.yandex.mapkit.map.internal.MapWindowBinding;
import com.yandex.runtime.view.PlatformGLTextureView;
import com.yandex.runtime.view.PlatformGLView;
import com.yandex.runtime.view.PlatformGLViewFactory;
public class MapView extends RelativeLayout {
    private MapWindowBinding mapWindow;
    private PlatformGLView platformGLView;

    public MapView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        this.mapWindow = (MapWindowBinding) MapKitFactory.getInstance().createMapWindow(this.platformGLView);
        addView(this.platformGLView.getView(), new RelativeLayout.LayoutParams(-1, -1));
    }

    public void addSizeChangedListener(SizeChangedListener sizeChangedListener) {
        this.mapWindow.addSizeChangedListener(sizeChangedListener);
    }

    public double getFieldOfViewY() {
        return this.mapWindow.getFieldOfViewY();
    }

    public ScreenRect getFocusRect() {
        return this.mapWindow.getFocusRect();
    }

    public VisibleRegion getFocusRegion() {
        return this.mapWindow.getFocusRegion();
    }

    public Map getMap() {
        return this.mapWindow.getMap();
    }

    public MapWindow getMapWindow() {
        return this.mapWindow;
    }

    public PointOfView getPointOfView() {
        return this.mapWindow.getPointOfView();
    }

    public float getScaleFactor() {
        return this.mapWindow.getScaleFactor();
    }

    public Bitmap getScreenshot() {
        PlatformGLView platformGLView2 = this.platformGLView;
        if (platformGLView2 instanceof PlatformGLTextureView) {
            return ((PlatformGLTextureView) platformGLView2).getBitmap();
        }
        return null;
    }

    public ScreenPoint getZoomFocusPoint() {
        return this.mapWindow.getZoomFocusPoint();
    }

    public ZoomFocusPointMode getZoomFocusPointMode() {
        return this.mapWindow.getZoomFocusPointMode();
    }

    public int height() {
        return this.mapWindow.height();
    }

    public boolean isValid() {
        return this.mapWindow.isValid();
    }

    public void onMemoryWarning() {
        this.platformGLView.onMemoryWarning();
    }

    public void onStart() {
        this.platformGLView.start();
        this.platformGLView.resume();
    }

    public void onStop() {
        this.platformGLView.pause();
        this.platformGLView.stop();
    }

    public void removeSizeChangedListener(SizeChangedListener sizeChangedListener) {
        this.mapWindow.removeSizeChangedListener(sizeChangedListener);
    }

    public Point screenToWorld(ScreenPoint screenPoint) {
        return this.mapWindow.screenToWorld(screenPoint);
    }

    public void setFieldOfViewY(double d) {
        this.mapWindow.setFieldOfViewY(d);
    }

    public void setFocusRect(ScreenRect screenRect) {
        this.mapWindow.setFocusRect(screenRect);
    }

    public void setMaxFps(float f) {
        this.mapWindow.setMaxFps(f);
    }

    public void setNoninteractive(boolean z) {
        this.platformGLView.setNoninteractive(z);
    }

    public void setPointOfView(PointOfView pointOfView) {
        this.mapWindow.setPointOfView(pointOfView);
    }

    public void setScaleFactor(float f) {
        this.mapWindow.setScaleFactor(f);
    }

    public void setZoomFocusPoint(ScreenPoint screenPoint) {
        this.mapWindow.setZoomFocusPoint(screenPoint);
    }

    public void setZoomFocusPointMode(ZoomFocusPointMode zoomFocusPointMode) {
        this.mapWindow.setZoomFocusPointMode(zoomFocusPointMode);
    }

    public void startPerformanceMetricsCapture() {
        this.mapWindow.startPerformanceMetricsCapture();
    }

    public String stopPerformanceMetricsCapture() {
        return this.mapWindow.stopPerformanceMetricsCapture();
    }

    public int width() {
        return this.mapWindow.width();
    }

    public ScreenPoint worldToScreen(Point point) {
        return this.mapWindow.worldToScreen(point);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (!isInEditMode()) {
            MapKitFactory.initialize(context);
            this.platformGLView = PlatformGLViewFactory.getPlatformGLView(context, PlatformGLViewFactory.convertAttributeSet(context, attributeSet));
            init(context);
        }
    }
}
