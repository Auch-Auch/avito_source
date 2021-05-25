package com.google.android.gms.internal.measurement;
public final class zzpj implements zzdv<zzpm> {
    private static zzpj zza = new zzpj();
    private final zzdv<zzpm> zzb;

    private zzpj(zzdv<zzpm> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public static boolean zzb() {
        return ((zzpm) zza.zza()).zza();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzpm zza() {
        return this.zzb.zza();
    }

    public zzpj() {
        this(zzdu.zza(new zzpl()));
    }
}
