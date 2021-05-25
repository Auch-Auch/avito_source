package com.google.android.gms.internal.measurement;
public final class zznt implements zzdv<zznw> {
    private static zznt zza = new zznt();
    private final zzdv<zznw> zzb;

    private zznt(zzdv<zznw> zzdv) {
        this.zzb = zzdu.zza((zzdv) zzdv);
    }

    public static boolean zzb() {
        return ((zznw) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zznw) zza.zza()).zzb();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdv
    public final /* synthetic */ zznw zza() {
        return this.zzb.zza();
    }

    public zznt() {
        this(zzdu.zza(new zznv()));
    }
}
