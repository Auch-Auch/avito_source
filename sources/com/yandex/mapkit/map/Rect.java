package com.yandex.mapkit.map;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class Rect implements Serializable {
    private PointF max;
    private PointF min;

    public Rect(@NonNull PointF pointF, @NonNull PointF pointF2) {
        if (pointF == null) {
            throw new IllegalArgumentException("Required field \"min\" cannot be null");
        } else if (pointF2 != null) {
            this.min = pointF;
            this.max = pointF2;
        } else {
            throw new IllegalArgumentException("Required field \"max\" cannot be null");
        }
    }

    @NonNull
    public PointF getMax() {
        return this.max;
    }

    @NonNull
    public PointF getMin() {
        return this.min;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.min = archive.add(this.min, false);
        this.max = archive.add(this.max, false);
    }

    public Rect() {
    }
}
