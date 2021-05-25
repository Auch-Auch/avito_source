package com.google.android.gms.internal.measurement;
public final class zznn implements zzdv<zznq> {
    private static zznn zza = new zznn();
    private final zzdv<zznq> zzb;

    private zznn(zzdv<zznq> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public static boolean zzb() {
        return ((zznq) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zznq) zza.zza()).zzb();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zznq zza() {
        return this.zzb.zza();
    }

    public zznn() {
        this(zzdu.zza(new zznp()));
    }
}
