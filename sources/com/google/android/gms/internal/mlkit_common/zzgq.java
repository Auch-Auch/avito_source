package com.google.android.gms.internal.mlkit_common;
public final class zzgq implements zzgy {
    private zzgy[] zza;

    public zzgq(zzgy... zzgyArr) {
        this.zza = zzgyArr;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    public final boolean zza(Class<?> cls) {
        for (zzgy zzgy : this.zza) {
            if (zzgy.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzgy
    public final zzgz zzb(Class<?> cls) {
        zzgy[] zzgyArr = this.zza;
        for (zzgy zzgy : zzgyArr) {
            if (zzgy.zza(cls)) {
                return zzgy.zzb(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
