package com.google.android.gms.internal.measurement;
public final class zzns implements zzdv<zznr> {
    private static zzns zza = new zzns();
    private final zzdv<zznr> zzb;

    private zzns(zzdv<zznr> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public static boolean zzb() {
        return ((zznr) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zznr) zza.zza()).zzb();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zznr zza() {
        return this.zzb.zza();
    }

    public zzns() {
        this(zzdu.zza(new zznu()));
    }
}
