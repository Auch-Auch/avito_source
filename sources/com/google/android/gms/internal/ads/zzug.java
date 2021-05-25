package com.google.android.gms.internal.ads;

import kotlin.text.Typography;
public enum zzug implements zzegu {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_UNKNOWN(1000);
    
    private static final zzegt<zzug> zzes = new zzuj();
    private final int value;

    private zzug(int i) {
        this.value = i;
    }

    public static zzug zzcg(int i) {
        if (i == 0) {
            return ENUM_FALSE;
        }
        if (i == 1) {
            return ENUM_TRUE;
        }
        if (i != 1000) {
            return null;
        }
        return ENUM_UNKNOWN;
    }

    public static zzegw zzw() {
        return zzui.zzeu;
    }

    @Override // java.lang.Enum, java.lang.Object
    public final String toString() {
        return "<" + zzug.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
    }

    @Override // com.google.android.gms.internal.ads.zzegu
    public final int zzv() {
        return this.value;
    }
}
