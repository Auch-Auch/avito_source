package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzid;
public final class zzib implements zzjk {
    private static final zzib zzxu = new zzib();

    private zzib() {
    }

    public static zzib zzgq() {
        return zzxu;
    }

    @Override // com.google.android.gms.internal.vision.zzjk
    public final boolean zza(Class<?> cls) {
        return zzid.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.vision.zzjk
    public final zzjl zzb(Class<?> cls) {
        if (!zzid.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (zzjl) zzid.zzd(cls.asSubclass(zzid.class)).zza(zzid.zzf.zzyj, (Object) null, (Object) null);
        } catch (Exception e) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e);
        }
    }
}
