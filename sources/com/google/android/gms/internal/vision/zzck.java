package com.google.android.gms.internal.vision;

import kotlin.text.Typography;
public enum zzck implements zzih {
    CLASSIFICATION_TYPE_UNKNOWN(0),
    NO_CLASSIFICATION(1),
    ALL_CLASSIFICATIONS(2);
    
    private static final zzig<zzck> zzhq = new zzcm();
    private final int value;

    private zzck(int i) {
        this.value = i;
    }

    public static zzij zzal() {
        return zzcl.zzht;
    }

    public static zzck zzo(int i) {
        if (i == 0) {
            return CLASSIFICATION_TYPE_UNKNOWN;
        }
        if (i == 1) {
            return NO_CLASSIFICATION;
        }
        if (i != 2) {
            return null;
        }
        return ALL_CLASSIFICATIONS;
    }

    @Override // java.lang.Enum, java.lang.Object
    public final String toString() {
        return "<" + zzck.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
    }

    @Override // com.google.android.gms.internal.vision.zzih
    public final int zzak() {
        return this.value;
    }
}
