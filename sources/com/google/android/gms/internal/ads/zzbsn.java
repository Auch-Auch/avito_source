package com.google.android.gms.internal.ads;
public final class zzbsn implements zzelo<zzdln> {
    private final zzbsg zzfsm;

    private zzbsn(zzbsg zzbsg) {
        this.zzfsm = zzbsg;
    }

    public static zzbsn zzm(zzbsg zzbsg) {
        return new zzbsn(zzbsg);
    }

    public static zzdln zzn(zzbsg zzbsg) {
        return (zzdln) zzelu.zza(zzbsg.zzajf(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zzn(this.zzfsm);
    }
}
