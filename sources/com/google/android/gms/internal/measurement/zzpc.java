package com.google.android.gms.internal.measurement;
public final class zzpc implements zzdv<zzpb> {
    private static zzpc zza = new zzpc();
    private final zzdv<zzpb> zzb;

    private zzpc(zzdv<zzpb> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public static boolean zzb() {
        return ((zzpb) zza.zza()).zza();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zzpb zza() {
        return this.zzb.zza();
    }

    public zzpc() {
        this(zzdu.zza(new zzpe()));
    }
}
