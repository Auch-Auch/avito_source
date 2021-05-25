package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgd;
public final class zzgb implements zzhm {
    private static final zzgb zza = new zzgb();

    private zzgb() {
    }

    public static zzgb zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzhm
    public final zzhj zzb(Class<?> cls) {
        if (!zzgd.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (zzhj) zzgd.zza((Class<zzgd>) cls.asSubclass(zzgd.class)).zza(zzgd.zzf.zzc, (Object) null, (Object) null);
        } catch (Exception e) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzhm
    public final boolean zza(Class<?> cls) {
        return zzgd.class.isAssignableFrom(cls);
    }
}
