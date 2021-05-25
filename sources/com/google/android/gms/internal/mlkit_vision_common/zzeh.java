package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
public final class zzeh implements zzfs {
    private static final zzeh zza = new zzeh();

    private zzeh() {
    }

    public static zzeh zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfs
    public final zzfp zzb(Class<?> cls) {
        if (!zzej.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (zzfp) zzej.zza((Class<zzej>) cls.asSubclass(zzej.class)).zza(zzej.zzf.zzc, (Object) null, (Object) null);
        } catch (Exception e) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfs
    public final boolean zza(Class<?> cls) {
        return zzej.class.isAssignableFrom(cls);
    }
}
