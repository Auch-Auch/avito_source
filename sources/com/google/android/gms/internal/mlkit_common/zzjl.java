package com.google.android.gms.internal.mlkit_common;

import kotlin.text.Typography;
public enum zzjl implements zzfv {
    UNKNOWN_EVENT_TYPE(0),
    VALIDATION_TEST(1),
    CONTINUOUS_FEEDBACK(2);
    
    private static final zzfu<zzjl> zzd = new zzjo();
    private final int zze;

    private zzjl(int i) {
        this.zze = i;
    }

    public static zzfx zzb() {
        return zzjn.zza;
    }

    @Override // java.lang.Enum, java.lang.Object
    public final String toString() {
        return "<" + zzjl.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzfv
    public final int zza() {
        return this.zze;
    }
}
