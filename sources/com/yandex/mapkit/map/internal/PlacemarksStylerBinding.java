package com.yandex.mapkit.map.internal;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import com.yandex.mapkit.map.PlacemarksStyler;
import com.yandex.runtime.NativeObject;
import java.util.List;
public class PlacemarksStylerBinding implements PlacemarksStyler {
    private final NativeObject nativeObject;

    public PlacemarksStylerBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.mapkit.map.PlacemarksStyler
    public native boolean isValid();

    @Override // com.yandex.mapkit.map.PlacemarksStyler
    public native void setScaleFunction(@NonNull List<PointF> list);
}
