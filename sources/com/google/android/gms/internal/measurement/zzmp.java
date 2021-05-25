package com.google.android.gms.internal.measurement;
public final class zzmp implements zzdv<zzms> {
    private static zzmp zza = new zzmp();
    private final zzdv<zzms> zzb;

    private zzmp(zzdv<zzms> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public static boolean zzb() {
        return ((zzms) zza.zza()).zza();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzms zza() {
        return this.zzb.zza();
    }

    public zzmp() {
        this(zzdu.zza(new zzmr()));
    }
}
