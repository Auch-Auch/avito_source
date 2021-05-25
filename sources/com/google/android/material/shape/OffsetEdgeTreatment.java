package com.google.android.material.shape;

import androidx.annotation.NonNull;
public final class OffsetEdgeTreatment extends EdgeTreatment {
    public final EdgeTreatment a;
    public final float b;

    public OffsetEdgeTreatment(@NonNull EdgeTreatment edgeTreatment, float f) {
        this.a = edgeTreatment;
        this.b = f;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public boolean a() {
        return this.a.a();
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f2, float f3, @NonNull ShapePath shapePath) {
        this.a.getEdgePath(f, f2 - this.b, f3, shapePath);
    }
}
