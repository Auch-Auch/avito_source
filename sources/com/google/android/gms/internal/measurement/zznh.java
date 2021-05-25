package com.google.android.gms.internal.measurement;
public final class zznh implements zzdv<zznk> {
    private static zznh zza = new zznh();
    private final zzdv<zznk> zzb;

    private zznh(zzdv<zznk> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public static boolean zzb() {
        return ((zznk) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zznk) zza.zza()).zzb();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zznk zza() {
        return this.zzb.zza();
    }

    public zznh() {
        this(zzdu.zza(new zznj()));
    }
}
