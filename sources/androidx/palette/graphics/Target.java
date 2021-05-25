package androidx.palette.graphics;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.maps.android.heatmaps.WeightedLatLng;
public final class Target {
    public static final Target DARK_MUTED;
    public static final Target DARK_VIBRANT;
    public static final Target LIGHT_MUTED;
    public static final Target LIGHT_VIBRANT;
    public static final Target MUTED;
    public static final Target VIBRANT;
    public final float[] a;
    public final float[] b;
    public final float[] c;
    public boolean d = true;

    static {
        Target target = new Target();
        LIGHT_VIBRANT = target;
        float[] fArr = target.b;
        fArr[0] = 0.55f;
        fArr[1] = 0.74f;
        c(target);
        Target target2 = new Target();
        VIBRANT = target2;
        b(target2);
        c(target2);
        Target target3 = new Target();
        DARK_VIBRANT = target3;
        float[] fArr2 = target3.b;
        fArr2[1] = 0.26f;
        fArr2[2] = 0.45f;
        c(target3);
        Target target4 = new Target();
        LIGHT_MUTED = target4;
        float[] fArr3 = target4.b;
        fArr3[0] = 0.55f;
        fArr3[1] = 0.74f;
        a(target4);
        Target target5 = new Target();
        MUTED = target5;
        b(target5);
        a(target5);
        Target target6 = new Target();
        DARK_MUTED = target6;
        float[] fArr4 = target6.b;
        fArr4[1] = 0.26f;
        fArr4[2] = 0.45f;
        a(target6);
    }

    public Target() {
        float[] fArr = new float[3];
        this.a = fArr;
        float[] fArr2 = new float[3];
        this.b = fArr2;
        float[] fArr3 = new float[3];
        this.c = fArr3;
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = 1.0f;
        fArr2[0] = 0.0f;
        fArr2[1] = 0.5f;
        fArr2[2] = 1.0f;
        fArr3[0] = 0.24f;
        fArr3[1] = 0.52f;
        fArr3[2] = 0.24f;
    }

    public static void a(Target target) {
        float[] fArr = target.a;
        fArr[1] = 0.3f;
        fArr[2] = 0.4f;
    }

    public static void b(Target target) {
        float[] fArr = target.b;
        fArr[0] = 0.3f;
        fArr[1] = 0.5f;
        fArr[2] = 0.7f;
    }

    public static void c(Target target) {
        float[] fArr = target.a;
        fArr[0] = 0.35f;
        fArr[1] = 1.0f;
    }

    public float getLightnessWeight() {
        return this.c[1];
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getMaximumLightness() {
        return this.b[2];
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getMaximumSaturation() {
        return this.a[2];
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getMinimumLightness() {
        return this.b[0];
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getMinimumSaturation() {
        return this.a[0];
    }

    public float getPopulationWeight() {
        return this.c[2];
    }

    public float getSaturationWeight() {
        return this.c[0];
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getTargetLightness() {
        return this.b[1];
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getTargetSaturation() {
        return this.a[1];
    }

    public boolean isExclusive() {
        return this.d;
    }

    public static final class Builder {
        public final Target a;

        public Builder() {
            this.a = new Target();
        }

        @NonNull
        public Target build() {
            return this.a;
        }

        @NonNull
        public Builder setExclusive(boolean z) {
            this.a.d = z;
            return this;
        }

        @NonNull
        public Builder setLightnessWeight(@FloatRange(from = 0.0d) float f) {
            this.a.c[1] = f;
            return this;
        }

        @NonNull
        public Builder setMaximumLightness(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            this.a.b[2] = f;
            return this;
        }

        @NonNull
        public Builder setMaximumSaturation(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            this.a.a[2] = f;
            return this;
        }

        @NonNull
        public Builder setMinimumLightness(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            this.a.b[0] = f;
            return this;
        }

        @NonNull
        public Builder setMinimumSaturation(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            this.a.a[0] = f;
            return this;
        }

        @NonNull
        public Builder setPopulationWeight(@FloatRange(from = 0.0d) float f) {
            this.a.c[2] = f;
            return this;
        }

        @NonNull
        public Builder setSaturationWeight(@FloatRange(from = 0.0d) float f) {
            this.a.c[0] = f;
            return this;
        }

        @NonNull
        public Builder setTargetLightness(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            this.a.b[1] = f;
            return this;
        }

        @NonNull
        public Builder setTargetSaturation(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            this.a.a[1] = f;
            return this;
        }

        public Builder(@NonNull Target target) {
            this.a = new Target(target);
        }
    }

    public Target(@NonNull Target target) {
        float[] fArr = new float[3];
        this.a = fArr;
        float[] fArr2 = new float[3];
        this.b = fArr2;
        float[] fArr3 = new float[3];
        this.c = fArr3;
        System.arraycopy(target.a, 0, fArr, 0, fArr.length);
        System.arraycopy(target.b, 0, fArr2, 0, fArr2.length);
        System.arraycopy(target.c, 0, fArr3, 0, fArr3.length);
    }
}
