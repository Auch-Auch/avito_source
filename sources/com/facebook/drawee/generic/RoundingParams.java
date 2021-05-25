package com.facebook.drawee.generic;

import androidx.annotation.ColorInt;
import com.facebook.common.internal.Preconditions;
import java.util.Arrays;
import javax.annotation.Nullable;
public class RoundingParams {
    public RoundingMethod a = RoundingMethod.BITMAP_ONLY;
    public boolean b = false;
    @Nullable
    public float[] c = null;
    public int d = 0;
    public float e = 0.0f;
    public int f = 0;
    public float g = 0.0f;
    public boolean h = false;
    public boolean i = false;

    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public static RoundingParams asCircle() {
        return new RoundingParams().setRoundAsCircle(true);
    }

    public static RoundingParams fromCornersRadii(float f2, float f3, float f4, float f5) {
        return new RoundingParams().setCornersRadii(f2, f3, f4, f5);
    }

    public static RoundingParams fromCornersRadius(float f2) {
        return new RoundingParams().setCornersRadius(f2);
    }

    public final float[] a() {
        if (this.c == null) {
            this.c = new float[8];
        }
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.b == roundingParams.b && this.d == roundingParams.d && Float.compare(roundingParams.e, this.e) == 0 && this.f == roundingParams.f && Float.compare(roundingParams.g, this.g) == 0 && this.a == roundingParams.a && this.h == roundingParams.h && this.i == roundingParams.i) {
            return Arrays.equals(this.c, roundingParams.c);
        }
        return false;
    }

    public int getBorderColor() {
        return this.f;
    }

    public float getBorderWidth() {
        return this.e;
    }

    @Nullable
    public float[] getCornersRadii() {
        return this.c;
    }

    public int getOverlayColor() {
        return this.d;
    }

    public float getPadding() {
        return this.g;
    }

    public boolean getPaintFilterBitmap() {
        return this.i;
    }

    public boolean getRoundAsCircle() {
        return this.b;
    }

    public RoundingMethod getRoundingMethod() {
        return this.a;
    }

    public boolean getScaleDownInsideBorders() {
        return this.h;
    }

    public int hashCode() {
        RoundingMethod roundingMethod = this.a;
        int i2 = 0;
        int hashCode = (((roundingMethod != null ? roundingMethod.hashCode() : 0) * 31) + (this.b ? 1 : 0)) * 31;
        float[] fArr = this.c;
        int hashCode2 = (((hashCode + (fArr != null ? Arrays.hashCode(fArr) : 0)) * 31) + this.d) * 31;
        float f2 = this.e;
        int floatToIntBits = (((hashCode2 + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31) + this.f) * 31;
        float f3 = this.g;
        if (f3 != 0.0f) {
            i2 = Float.floatToIntBits(f3);
        }
        return ((((floatToIntBits + i2) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0);
    }

    public RoundingParams setBorder(@ColorInt int i2, float f2) {
        Preconditions.checkArgument(f2 >= 0.0f, "the border width cannot be < 0");
        this.e = f2;
        this.f = i2;
        return this;
    }

    public RoundingParams setBorderColor(@ColorInt int i2) {
        this.f = i2;
        return this;
    }

    public RoundingParams setBorderWidth(float f2) {
        Preconditions.checkArgument(f2 >= 0.0f, "the border width cannot be < 0");
        this.e = f2;
        return this;
    }

    public RoundingParams setCornersRadii(float f2, float f3, float f4, float f5) {
        float[] a3 = a();
        a3[1] = f2;
        a3[0] = f2;
        a3[3] = f3;
        a3[2] = f3;
        a3[5] = f4;
        a3[4] = f4;
        a3[7] = f5;
        a3[6] = f5;
        return this;
    }

    public RoundingParams setCornersRadius(float f2) {
        Arrays.fill(a(), f2);
        return this;
    }

    public RoundingParams setOverlayColor(@ColorInt int i2) {
        this.d = i2;
        this.a = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public RoundingParams setPadding(float f2) {
        Preconditions.checkArgument(f2 >= 0.0f, "the padding cannot be < 0");
        this.g = f2;
        return this;
    }

    public RoundingParams setPaintFilterBitmap(boolean z) {
        this.i = z;
        return this;
    }

    public RoundingParams setRoundAsCircle(boolean z) {
        this.b = z;
        return this;
    }

    public RoundingParams setRoundingMethod(RoundingMethod roundingMethod) {
        this.a = roundingMethod;
        return this;
    }

    public RoundingParams setScaleDownInsideBorders(boolean z) {
        this.h = z;
        return this;
    }

    public static RoundingParams fromCornersRadii(float[] fArr) {
        return new RoundingParams().setCornersRadii(fArr);
    }

    public RoundingParams setCornersRadii(float[] fArr) {
        Preconditions.checkNotNull(fArr);
        Preconditions.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
        System.arraycopy(fArr, 0, a(), 0, 8);
        return this;
    }
}
