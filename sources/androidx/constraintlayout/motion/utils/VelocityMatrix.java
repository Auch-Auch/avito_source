package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.SplineSet;
public class VelocityMatrix {
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;

    public void applyTransform(float f2, float f3, int i, int i2, float[] fArr) {
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f6 = (f2 - 0.5f) * 2.0f;
        float f7 = (f3 - 0.5f) * 2.0f;
        float f8 = f4 + this.c;
        float f9 = f5 + this.d;
        float f10 = (this.a * f6) + f8;
        float f11 = (this.b * f7) + f9;
        float radians = (float) Math.toRadians((double) this.f);
        float radians2 = (float) Math.toRadians((double) this.e);
        double d2 = (double) radians;
        double sin = Math.sin(d2);
        double d3 = (double) (((float) i2) * f7);
        double cos = Math.cos(d2);
        fArr[0] = (((float) ((sin * ((double) (((float) (-i)) * f6))) - (Math.cos(d2) * d3))) * radians2) + f10;
        fArr[1] = (radians2 * ((float) ((cos * ((double) (((float) i) * f6))) - (Math.sin(d2) * d3)))) + f11;
    }

    public void clear() {
        this.e = 0.0f;
        this.d = 0.0f;
        this.c = 0.0f;
        this.b = 0.0f;
        this.a = 0.0f;
    }

    public void setRotationVelocity(SplineSet splineSet, float f2) {
        if (splineSet != null) {
            this.e = splineSet.getSlope(f2);
            this.f = splineSet.get(f2);
        }
    }

    public void setScaleVelocity(SplineSet splineSet, SplineSet splineSet2, float f2) {
        if (splineSet != null) {
            this.a = splineSet.getSlope(f2);
        }
        if (splineSet2 != null) {
            this.b = splineSet2.getSlope(f2);
        }
    }

    public void setTranslationVelocity(SplineSet splineSet, SplineSet splineSet2, float f2) {
        if (splineSet != null) {
            this.c = splineSet.getSlope(f2);
        }
        if (splineSet2 != null) {
            this.d = splineSet2.getSlope(f2);
        }
    }

    public void setRotationVelocity(KeyCycleOscillator keyCycleOscillator, float f2) {
        if (keyCycleOscillator != null) {
            this.e = keyCycleOscillator.getSlope(f2);
        }
    }

    public void setScaleVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f2) {
        if (keyCycleOscillator != null || keyCycleOscillator2 != null) {
            if (keyCycleOscillator == null) {
                this.a = keyCycleOscillator.getSlope(f2);
            }
            if (keyCycleOscillator2 == null) {
                this.b = keyCycleOscillator2.getSlope(f2);
            }
        }
    }

    public void setTranslationVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f2) {
        if (keyCycleOscillator != null) {
            this.c = keyCycleOscillator.getSlope(f2);
        }
        if (keyCycleOscillator2 != null) {
            this.d = keyCycleOscillator2.getSlope(f2);
        }
    }
}
