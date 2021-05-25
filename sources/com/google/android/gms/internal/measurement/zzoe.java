package com.google.android.gms.internal.measurement;
public final class zzoe implements zzdv<zzod> {
    private static zzoe zza = new zzoe();
    private final zzdv<zzod> zzb;

    private zzoe(zzdv<zzod> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public static boolean zzb() {
        return ((zzod) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzod) zza.zza()).zzb();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzod zza() {
        return this.zzb.zza();
    }

    public zzoe() {
        this(zzdu.zza(new zzog()));
    }
}
