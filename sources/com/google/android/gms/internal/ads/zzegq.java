package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
public final class zzegq implements zzeia {
    private static final zzegq zzifr = new zzegq();

    private zzegq() {
    }

    public static zzegq zzbfs() {
        return zzifr;
    }

    @Override // com.google.android.gms.internal.ads.zzeia
    public final boolean zze(Class<?> cls) {
        return zzegp.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzeia
    public final zzehx zzf(Class<?> cls) {
        if (!zzegp.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (zzehx) zzegp.zzd(cls.asSubclass(zzegp.class)).zza(zzegp.zze.zzify, (Object) null, (Object) null);
        } catch (Exception e) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e);
        }
    }
}
