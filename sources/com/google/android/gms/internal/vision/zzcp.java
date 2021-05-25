package com.google.android.gms.internal.vision;

import kotlin.text.Typography;
public enum zzcp implements zzih {
    LANDMARK_TYPE_UNKNOWN(0),
    NO_LANDMARK(1),
    ALL_LANDMARKS(2),
    CONTOUR_LANDMARKS(3);
    
    private static final zzig<zzcp> zzhq = new zzcr();
    private final int value;

    private zzcp(int i) {
        this.value = i;
    }

    public static zzij zzal() {
        return zzcq.zzht;
    }

    public static zzcp zzq(int i) {
        if (i == 0) {
            return LANDMARK_TYPE_UNKNOWN;
        }
        if (i == 1) {
            return NO_LANDMARK;
        }
        if (i == 2) {
            return ALL_LANDMARKS;
        }
        if (i != 3) {
            return null;
        }
        return CONTOUR_LANDMARKS;
    }

    @Override // java.lang.Enum, java.lang.Object
    public final String toString() {
        return "<" + zzcp.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
    }

    @Override // com.google.android.gms.internal.vision.zzih
    public final int zzak() {
        return this.value;
    }
}
