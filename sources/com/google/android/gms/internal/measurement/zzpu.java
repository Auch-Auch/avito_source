package com.google.android.gms.internal.measurement;
public final class zzpu implements zzdv<zzpt> {
    private static zzpu zza = new zzpu();
    private final zzdv<zzpt> zzb;

    private zzpu(zzdv<zzpt> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public static boolean zzb() {
        return ((zzpt) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzpt) zza.zza()).zzb();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzpt zza() {
        return this.zzb.zza();
    }

    public zzpu() {
        this(zzdu.zza(new zzpw()));
    }
}
