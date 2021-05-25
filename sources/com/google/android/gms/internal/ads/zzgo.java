package com.google.android.gms.internal.ads;

import kotlin.text.Typography;
public enum zzgo implements zzegu {
    UNSUPPORTED(0),
    ARM7(2),
    X86(4),
    ARM64(5),
    X86_64(6);
    
    private static final zzegt<zzgo> zzes = new zzgn();
    private final int value;

    private zzgo(int i) {
        this.value = i;
    }

    @Override // java.lang.Enum, java.lang.Object
    public final String toString() {
        return "<" + zzgo.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
    }

    @Override // com.google.android.gms.internal.ads.zzegu
    public final int zzv() {
        return this.value;
    }
}
