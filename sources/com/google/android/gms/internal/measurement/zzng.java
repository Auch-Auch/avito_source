package com.google.android.gms.internal.measurement;
public final class zzng implements zzdv<zznf> {
    private static zzng zza = new zzng();
    private final zzdv<zznf> zzb;

    private zzng(zzdv<zznf> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public static boolean zzb() {
        return ((zznf) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zznf) zza.zza()).zzb();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zznf zza() {
        return this.zzb.zza();
    }

    public zzng() {
        this(zzdu.zza(new zzni()));
    }
}
