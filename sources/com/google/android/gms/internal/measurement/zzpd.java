package com.google.android.gms.internal.measurement;
public final class zzpd implements zzdv<zzpg> {
    private static zzpd zza = new zzpd();
    private final zzdv<zzpg> zzb;

    private zzpd(zzdv<zzpg> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public static boolean zzb() {
        return ((zzpg) zza.zza()).zza();
    }

    public static double zzc() {
        return ((zzpg) zza.zza()).zzb();
    }

    public static long zzd() {
        return ((zzpg) zza.zza()).zzc();
    }

    public static long zze() {
        return ((zzpg) zza.zza()).zzd();
    }

    public static String zzf() {
        return ((zzpg) zza.zza()).zze();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzpg zza() {
        return this.zzb.zza();
    }

    public zzpd() {
        this(zzdu.zza(new zzpf()));
    }
}
