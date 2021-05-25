package com.google.android.gms.internal.vision;

import kotlin.text.Typography;
public enum zzct implements zzih {
    MODE_TYPE_UNKNOWN(0),
    FAST(1),
    ACCURATE(2),
    SELFIE(3);
    
    private static final zzig<zzct> zzhq = new zzcs();
    private final int value;

    private zzct(int i) {
        this.value = i;
    }

    public static zzij zzal() {
        return zzcu.zzht;
    }

    public static zzct zzr(int i) {
        if (i == 0) {
            return MODE_TYPE_UNKNOWN;
        }
        if (i == 1) {
            return FAST;
        }
        if (i == 2) {
            return ACCURATE;
        }
        if (i != 3) {
            return null;
        }
        return SELFIE;
    }

    @Override // java.lang.Enum, java.lang.Object
    public final String toString() {
        return "<" + zzct.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
    }

    @Override // com.google.android.gms.internal.vision.zzih
    public final int zzak() {
        return this.value;
    }
}
