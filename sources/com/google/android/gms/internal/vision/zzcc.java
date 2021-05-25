package com.google.android.gms.internal.vision;

import kotlin.text.Typography;
public enum zzcc implements zzih {
    ROTATION_0(0),
    ROTATION_90(1),
    ROTATION_180(2),
    ROTATION_270(3);
    
    private static final zzig<zzcc> zzhq = new zzce();
    private final int value;

    private zzcc(int i) {
        this.value = i;
    }

    public static zzij zzal() {
        return zzcd.zzht;
    }

    public static zzcc zzi(int i) {
        if (i == 0) {
            return ROTATION_0;
        }
        if (i == 1) {
            return ROTATION_90;
        }
        if (i == 2) {
            return ROTATION_180;
        }
        if (i != 3) {
            return null;
        }
        return ROTATION_270;
    }

    @Override // java.lang.Enum, java.lang.Object
    public final String toString() {
        return "<" + zzcc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
    }

    @Override // com.google.android.gms.internal.vision.zzih
    public final int zzak() {
        return this.value;
    }
}
