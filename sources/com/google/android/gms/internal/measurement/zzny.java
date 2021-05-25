package com.google.android.gms.internal.measurement;
public final class zzny implements zzdv<zznx> {
    private static zzny zza = new zzny();
    private final zzdv<zznx> zzb;

    private zzny(zzdv<zznx> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public static boolean zzb() {
        return ((zznx) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zznx) zza.zza()).zzb();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zznx zza() {
        return this.zzb.zza();
    }

    public zzny() {
        this(zzdu.zza(new zzoa()));
    }
}
