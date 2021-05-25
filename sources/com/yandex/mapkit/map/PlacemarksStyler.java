package com.yandex.mapkit.map;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import java.util.List;
public interface PlacemarksStyler {
    boolean isValid();

    void setScaleFunction(@NonNull List<PointF> list);
}
