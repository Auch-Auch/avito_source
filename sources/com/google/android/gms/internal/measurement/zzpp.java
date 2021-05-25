package com.google.android.gms.internal.measurement;
public final class zzpp implements zzdv<zzps> {
    private static zzpp zza = new zzpp();
    private final zzdv<zzps> zzb;

    private zzpp(zzdv<zzps> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public static boolean zzb() {
        return ((zzps) zza.zza()).zza();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzps zza() {
        return this.zzb.zza();
    }

    public zzpp() {
        this(zzdu.zza(new zzpr()));
    }
}
