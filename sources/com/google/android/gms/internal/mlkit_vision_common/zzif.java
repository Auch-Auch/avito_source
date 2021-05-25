package com.google.android.gms.internal.mlkit_vision_common;

import kotlin.text.Typography;
public enum zzif implements zzel {
    UNKNOWN_EVENT_TYPE(0),
    VALIDATION_TEST(1),
    CONTINUOUS_FEEDBACK(2);
    
    private static final zzeo<zzif> zzd = new zzie();
    private final int zze;

    private zzif(int i) {
        this.zze = i;
    }

    public static zzen zzb() {
        return zzig.zza;
    }

    @Override // java.lang.Enum, java.lang.Object
    public final String toString() {
        return "<" + zzif.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzel
    public final int zza() {
        return this.zze;
    }
}
