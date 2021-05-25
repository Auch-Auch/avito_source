package com.otaliastudios.cameraview.engine.offset;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.controls.Facing;
public class Angles {
    public static final CameraLogger e = CameraLogger.create(Angles.class.getSimpleName());
    public Facing a;
    @VisibleForTesting
    public int b = 0;
    @VisibleForTesting
    public int c = 0;
    @VisibleForTesting
    public int d = 0;

    public final int a(@NonNull Reference reference, @NonNull Reference reference2) {
        if (reference == reference2) {
            return 0;
        }
        Reference reference3 = Reference.BASE;
        if (reference2 == reference3) {
            return ((360 - a(reference2, reference)) + 360) % 360;
        }
        if (reference != reference3) {
            return ((a(reference3, reference2) - a(reference3, reference)) + 360) % 360;
        }
        int ordinal = reference2.ordinal();
        if (ordinal == 1) {
            return ((360 - this.b) + 360) % 360;
        }
        if (ordinal == 2) {
            return ((360 - this.c) + 360) % 360;
        }
        if (ordinal == 3) {
            return (this.d + 360) % 360;
        }
        throw new RuntimeException("Unknown reference: " + reference2);
    }

    public final void b() {
        e.i("Angles changed:", "sensorOffset:", Integer.valueOf(this.b), "displayOffset:", Integer.valueOf(this.c), "deviceOrientation:", Integer.valueOf(this.d));
    }

    public final void c(int i) {
        if (i != 0 && i != 90 && i != 180 && i != 270) {
            throw new IllegalStateException(a.M2("This value is not sanitized: ", i));
        }
    }

    public boolean flip(@NonNull Reference reference, @NonNull Reference reference2) {
        return offset(reference, reference2, Axis.ABSOLUTE) % 180 != 0;
    }

    public int offset(@NonNull Reference reference, @NonNull Reference reference2, @NonNull Axis axis) {
        int a3 = a(reference, reference2);
        return (axis == Axis.RELATIVE_TO_SENSOR && this.a == Facing.FRONT) ? ((360 - a3) + 360) % 360 : a3;
    }

    public void setDeviceOrientation(int i) {
        c(i);
        this.d = i;
        b();
    }

    public void setDisplayOffset(int i) {
        c(i);
        this.c = i;
        b();
    }

    public void setSensorOffset(@NonNull Facing facing, int i) {
        c(i);
        this.a = facing;
        this.b = i;
        if (facing == Facing.FRONT) {
            this.b = ((360 - i) + 360) % 360;
        }
        b();
    }
}
