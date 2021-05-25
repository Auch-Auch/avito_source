package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzib;
public final class zzhz implements zzjk {
    private static final zzhz zza = new zzhz();

    private zzhz() {
    }

    public static zzhz zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final zzjh zzb(Class<?> cls) {
        if (!zzib.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (zzjh) zzib.zza((Class<zzib>) cls.asSubclass(zzib.class)).zza(zzib.zzf.zzc, (Object) null, (Object) null);
        } catch (Exception e) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final boolean zza(Class<?> cls) {
        return zzib.class.isAssignableFrom(cls);
    }
}
