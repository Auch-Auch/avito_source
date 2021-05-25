package com.facebook.imagepipeline.common;

import com.facebook.common.util.HashCodeUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public class RotationOptions {
    public static final int NO_ROTATION = 0;
    public static final int ROTATE_180 = 180;
    public static final int ROTATE_270 = 270;
    public static final int ROTATE_90 = 90;
    public static final RotationOptions c = new RotationOptions(-1, false);
    public static final RotationOptions d = new RotationOptions(-2, false);
    public static final RotationOptions e = new RotationOptions(-1, true);
    public final int a;
    public final boolean b;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RotationAngle {
    }

    public RotationOptions(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    public static RotationOptions autoRotate() {
        return c;
    }

    public static RotationOptions autoRotateAtRenderTime() {
        return e;
    }

    public static RotationOptions disableRotation() {
        return d;
    }

    public static RotationOptions forceRotation(int i) {
        return new RotationOptions(i, false);
    }

    public boolean canDeferUntilRendered() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RotationOptions)) {
            return false;
        }
        RotationOptions rotationOptions = (RotationOptions) obj;
        if (this.a == rotationOptions.a && this.b == rotationOptions.b) {
            return true;
        }
        return false;
    }

    public int getForcedAngle() {
        if (!useImageMetadata()) {
            return this.a;
        }
        throw new IllegalStateException("Rotation is set to use EXIF");
    }

    public int hashCode() {
        return HashCodeUtil.hashCode(Integer.valueOf(this.a), Boolean.valueOf(this.b));
    }

    public boolean rotationEnabled() {
        return this.a != -2;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.a), Boolean.valueOf(this.b));
    }

    public boolean useImageMetadata() {
        return this.a == -1;
    }
}
