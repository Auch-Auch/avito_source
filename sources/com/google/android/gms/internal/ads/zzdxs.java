package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
public final class zzdxs {
    public static final String zzhrt = new zzdxv().getKeyType();
    public static final String zzhru = new zzdyc().getKeyType();
    private static final String zzhrv = new zzdyb().getKeyType();
    private static final String zzhrw = new zzdyi().getKeyType();
    private static final String zzhrx = new zzdym().getKeyType();
    private static final String zzhry = new zzdyh().getKeyType();
    private static final String zzhrz = new zzdyr().getKeyType();
    @Deprecated
    private static final zzeco zzhsa;
    @Deprecated
    private static final zzeco zzhsb;
    @Deprecated
    private static final zzeco zzhsc;

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
        zzdzo.zzayg();
        zzdxm.zza((zzdwx) new zzdxv(), true);
        zzdxm.zza((zzdwx) new zzdyb(), true);
        zzdxm.zza((zzdwx) new zzdyc(), true);
        zzdxm.zza((zzdwx) new zzdyh(), true);
        zzdxm.zza((zzdwx) new zzdyi(), true);
        zzdxm.zza((zzdwx) new zzdym(), true);
        zzdxm.zza((zzdwx) new zzdyr(), true);
        zzdxm.zza(new zzdxr());
    }
}
