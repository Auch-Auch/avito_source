package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.maps.android.heatmaps.WeightedLatLng;
import java.util.Arrays;
public final class RelativeCornerSize implements CornerSize {
    public final float a;

    public RelativeCornerSize(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.a = f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof RelativeCornerSize) && this.a == ((RelativeCornerSize) obj).a) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.shape.CornerSize
    public float getCornerSize(@NonNull RectF rectF) {
        return rectF.height() * this.a;
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getRelativePercent() {
        return this.a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a)});
    }
}
