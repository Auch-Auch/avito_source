package com.google.android.gms.internal.measurement;
public final class zzmu implements zzdv<zzmt> {
    private static zzmu zza = new zzmu();
    private final zzdv<zzmt> zzb;

    private zzmu(zzdv<zzmt> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public static boolean zzb() {
        return ((zzmt) zza.zza()).zza();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzmt zza() {
        return this.zzb.zza();
    }

    public zzmu() {
        this(zzdu.zza(new zzmw()));
    }
}
