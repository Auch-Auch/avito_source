package com.google.android.material.shape;

import androidx.annotation.NonNull;
public final class MarkerEdgeTreatment extends EdgeTreatment {
    public final float a;

    public MarkerEdgeTreatment(float f) {
        this.a = f - 0.001f;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public boolean a() {
        return true;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f2, float f3, @NonNull ShapePath shapePath) {
        float sqrt = (float) ((Math.sqrt(2.0d) * ((double) this.a)) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow((double) this.a, 2.0d) - Math.pow((double) sqrt, 2.0d));
        shapePath.reset(f2 - sqrt, ((float) (-((Math.sqrt(2.0d) * ((double) this.a)) - ((double) this.a)))) + sqrt2);
        shapePath.lineTo(f2, (float) (-((Math.sqrt(2.0d) * ((double) this.a)) - ((double) this.a))));
        shapePath.lineTo(f2 + sqrt, ((float) (-((Math.sqrt(2.0d) * ((double) this.a)) - ((double) this.a)))) + sqrt2);
    }
}
