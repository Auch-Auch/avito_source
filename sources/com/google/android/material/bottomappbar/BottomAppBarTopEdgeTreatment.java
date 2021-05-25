package com.google.android.material.bottomappbar;

import a2.b.a.a.a;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    public float a;
    public float b;
    public float c;
    public float d;
    public float e = 0.0f;

    public BottomAppBarTopEdgeTreatment(float f, float f2, float f3) {
        this.b = f;
        this.a = f2;
        b(f3);
    }

    public void b(@FloatRange(from = 0.0d) float f) {
        if (f >= 0.0f) {
            this.d = f;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f2, float f3, @NonNull ShapePath shapePath) {
        float f4 = this.c;
        if (f4 == 0.0f) {
            shapePath.lineTo(f, 0.0f);
            return;
        }
        float f5 = ((this.b * 2.0f) + f4) / 2.0f;
        float f6 = f3 * this.a;
        float f7 = f2 + this.e;
        float b2 = a.b(1.0f, f3, f5, this.d * f3);
        if (b2 / f5 >= 1.0f) {
            shapePath.lineTo(f, 0.0f);
            return;
        }
        float f8 = f5 + f6;
        float f9 = b2 + f6;
        float sqrt = (float) Math.sqrt((double) ((f8 * f8) - (f9 * f9)));
        float f10 = f7 - sqrt;
        float f11 = f7 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan((double) (sqrt / f9)));
        float f12 = 90.0f - degrees;
        shapePath.lineTo(f10, 0.0f);
        float f13 = f6 * 2.0f;
        shapePath.addArc(f10 - f6, 0.0f, f10 + f6, f13, 270.0f, degrees);
        shapePath.addArc(f7 - f5, (-f5) - b2, f7 + f5, f5 - b2, 180.0f - f12, (f12 * 2.0f) - 180.0f);
        shapePath.addArc(f11 - f6, 0.0f, f11 + f6, f13, 270.0f - degrees, degrees);
        shapePath.lineTo(f, 0.0f);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getFabDiameter() {
        return this.c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getHorizontalOffset() {
        return this.e;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFabDiameter(float f) {
        this.c = f;
    }
}
