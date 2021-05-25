package com.google.android.gms.internal.mlkit_vision_common;
public final class zzfk implements zzfs {
    private zzfs[] zza;

    public zzfk(zzfs... zzfsArr) {
        this.zza = zzfsArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfs
    public final boolean zza(Class<?> cls) {
        for (zzfs zzfs : this.zza) {
            if (zzfs.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfs
    public final zzfp zzb(Class<?> cls) {
        zzfs[] zzfsArr = this.zza;
        for (zzfs zzfs : zzfsArr) {
            if (zzfs.zza(cls)) {
                return zzfs.zzb(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
