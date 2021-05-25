package com.google.android.material.transition;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.transition.PathMotion;
public final class MaterialArcMotion extends PathMotion {
    @Override // androidx.transition.PathMotion
    @NonNull
    public Path getPath(float f, float f2, float f3, float f4) {
        PointF pointF;
        Path path = new Path();
        path.moveTo(f, f2);
        if (f2 > f4) {
            pointF = new PointF(f3, f2);
        } else {
            pointF = new PointF(f, f4);
        }
        path.quadTo(pointF.x, pointF.y, f3, f4);
        return path;
    }
}
