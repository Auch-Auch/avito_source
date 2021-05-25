package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
public final class zzdzo {
    @Deprecated
    private static final zzeco zzhsa;
    @Deprecated
    private static final zzeco zzhsb;
    @Deprecated
    private static final zzeco zzhsc;
    private static final String zzhtd = new zzdzk().getKeyType();

    static {
        zzeco zzbcl = zzeco.zzbcl();
        zzhsa = zzbcl;
        zzhsb = zzbcl;
        zzhsc = zzbcl;
        try {
            zzayg();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zzayg() throws GeneralSecurityException {
        zzdxm.zza((zzdwx) new zzdzk(), true);
        zzdxm.zza((zzdwx) new zzdzf(), true);
        zzdxm.zza(new zzdzn());
    }
}
