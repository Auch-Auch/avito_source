package com.google.android.gms.internal.mlkit_vision_face;

import kotlin.text.Typography;
public enum zzjz implements zzgf {
    UNKNOWN_EVENT_TYPE(0),
    VALIDATION_TEST(1),
    CONTINUOUS_FEEDBACK(2);
    
    private static final zzgi<zzjz> zzd = new zzjy();
    private final int zze;

    private zzjz(int i) {
        this.zze = i;
    }

    public static zzgh zzb() {
        return zzka.zza;
    }

    @Override // java.lang.Enum, java.lang.Object
    public final String toString() {
        return "<" + zzjz.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzgf
    public final int zza() {
        return this.zze;
    }
}
