package com.yandex.mapkit.map.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.geometry.Polyline;
import com.yandex.mapkit.geometry.PolylinePosition;
import com.yandex.mapkit.geometry.Subpolyline;
import com.yandex.mapkit.map.Arrow;
import com.yandex.mapkit.map.ArrowTapListener;
import com.yandex.mapkit.map.ColoredPolylineMapObject;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.subscription.Subscription;
import java.util.List;
public class ColoredPolylineMapObjectBinding extends MapObjectBinding implements ColoredPolylineMapObject {
    private Subscription<ArrowTapListener> arrowTapListenerSubscription = new Subscription<ArrowTapListener>() { // from class: com.yandex.mapkit.map.internal.ColoredPolylineMapObjectBinding.1
        public NativeObject createNativeListener(ArrowTapListener arrowTapListener) {
            return ColoredPolylineMapObjectBinding.createArrowTapListener(arrowTapListener);
        }
    };

    public ColoredPolylineMapObjectBinding(NativeObject nativeObject) {
        super(nativeObject);
    }

    /* access modifiers changed from: private */
    public static native NativeObject createArrowTapListener(ArrowTapListener arrowTapListener);

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    @NonNull
    public native Arrow addArrow(@NonNull PolylinePosition polylinePosition, float f, int i);

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native void addArrowTapListener(@NonNull ArrowTapListener arrowTapListener);

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    @NonNull
    public native List<Arrow> arrows();

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native float getArcApproximationStep();

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    @NonNull
    public native Polyline getGeometry();

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native float getGradientLength();

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native int getOutlineColor();

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native float getOutlineWidth();

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native float getStrokeWidth();

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native float getTurnRadius();

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native void hide(@NonNull Subpolyline subpolyline);

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native void hide(@NonNull List<Subpolyline> list);

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native boolean isInnerOutlineEnabled();

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native void removeArrowTapListener(@NonNull ArrowTapListener arrowTapListener);

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native void select(int i, @NonNull Subpolyline subpolyline);

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native void setArcApproximationStep(float f);

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native void setColors(@NonNull List<Integer> list);

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native void setColors(@NonNull List<Integer> list, @NonNull List<Double> list2);

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native void setGeometry(@NonNull Polyline polyline);

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native void setGradientLength(float f);

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native void setInnerOutlineEnabled(boolean z);

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native void setOutlineColor(int i);

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native void setOutlineWidth(float f);

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native void setPaletteColor(int i, int i2);

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native void setStrokeWidth(float f);

    @Override // com.yandex.mapkit.map.ColoredPolylineMapObject
    public native void setTurnRadius(float f);
}
