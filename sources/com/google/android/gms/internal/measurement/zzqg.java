package com.google.android.gms.internal.measurement;
public final class zzqg implements zzdv<zzqf> {
    private static zzqg zza = new zzqg();
    private final zzdv<zzqf> zzb;

    private zzqg(zzdv<zzqf> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public static boolean zzb() {
        return ((zzqf) zza.zza()).zza();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzqf zza() {
        return this.zzb.zza();
    }

    public zzqg() {
        this(zzdu.zza(new zzqi()));
    }
}
