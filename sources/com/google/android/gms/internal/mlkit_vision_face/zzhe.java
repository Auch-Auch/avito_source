package com.google.android.gms.internal.mlkit_vision_face;
public final class zzhe implements zzhm {
    private zzhm[] zza;

    public zzhe(zzhm... zzhmArr) {
        this.zza = zzhmArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzhm
    public final boolean zza(Class<?> cls) {
        for (zzhm zzhm : this.zza) {
            if (zzhm.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzhm
    public final zzhj zzb(Class<?> cls) {
        zzhm[] zzhmArr = this.zza;
        for (zzhm zzhm : zzhmArr) {
            if (zzhm.zza(cls)) {
                return zzhm.zzb(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
