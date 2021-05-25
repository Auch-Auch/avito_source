package com.google.android.gms.internal.ads;
public final class zzbsl implements zzelo<String> {
    private final zzelx<zzbqq> zzeyg;
    private final zzbsg zzfsm;

    private zzbsl(zzbsg zzbsg, zzelx<zzbqq> zzelx) {
        this.zzfsm = zzbsg;
        this.zzeyg = zzelx;
    }

    public static String zza(zzbsg zzbsg, zzbqq zzbqq) {
        return (String) zzelu.zza(zzbqq.zzwc(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static zzbsl zzb(zzbsg zzbsg, zzelx<zzbqq> zzelx) {
        return new zzbsl(zzbsg, zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zza(this.zzfsm, this.zzeyg.get());
    }
}
