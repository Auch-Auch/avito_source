package com.google.android.gms.internal.measurement;
public final class zzmi implements zzdv<zzmh> {
    private static zzmi zza = new zzmi();
    private final zzdv<zzmh> zzb;

    private zzmi(zzdv<zzmh> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public static boolean zzb() {
        return ((zzmh) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzmh) zza.zza()).zzb();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzmh zza() {
        return this.zzb.zza();
    }

    public zzmi() {
        this(zzdu.zza(new zzmk()));
    }
}
