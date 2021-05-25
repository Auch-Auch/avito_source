package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
public final class zzdxc {
    private final zzecb zzhqx;

    private zzdxc(zzecb zzecb) {
        this.zzhqx = zzecb;
    }

    public static final zzdxc zza(zzecb zzecb) throws GeneralSecurityException {
        if (zzecb != null && zzecb.zzbbn() > 0) {
            return new zzdxc(zzecb);
        }
        throw new GeneralSecurityException("empty keyset");
    }

    public final String toString() {
        return zzdxq.zzb(this.zzhqx).toString();
    }

    public final zzecb zzaxx() {
        return this.zzhqx;
    }
}
