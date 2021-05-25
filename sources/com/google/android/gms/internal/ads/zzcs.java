package com.google.android.gms.internal.ads;

import kotlin.text.Typography;
public enum zzcs implements zzegu {
    UNKNOWN_PROTO(0),
    AFMA_SIGNALS(1),
    UNITY_SIGNALS(2),
    PARTNER_SIGNALS(3);
    
    private static final zzegt<zzcs> zzes = new zzcr();
    private final int value;

    private zzcs(int i) {
        this.value = i;
    }

    public static zzcs zzo(int i) {
        if (i == 0) {
            return UNKNOWN_PROTO;
        }
        if (i == 1) {
            return AFMA_SIGNALS;
        }
        if (i == 2) {
            return UNITY_SIGNALS;
        }
        if (i != 3) {
            return null;
        }
        return PARTNER_SIGNALS;
    }

    public static zzegw zzw() {
        return zzct.zzeu;
    }

    @Override // java.lang.Enum, java.lang.Object
    public final String toString() {
        return "<" + zzcs.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
    }

    @Override // com.google.android.gms.internal.ads.zzegu
    public final int zzv() {
        return this.value;
    }
}
