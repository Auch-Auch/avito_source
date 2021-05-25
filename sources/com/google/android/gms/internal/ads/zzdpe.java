package com.google.android.gms.internal.ads;
public final class zzdpe implements zzdvi<O> {
    private final /* synthetic */ zzdos zzhhb;
    private final /* synthetic */ zzdox zzhhc;

    public zzdpe(zzdox zzdox, zzdos zzdos) {
        this.zzhhc = zzdox;
        this.zzhhb = zzdos;
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void onSuccess(O o) {
        this.zzhhc.zzhgu.zzhgp.zzc(this.zzhhb);
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        this.zzhhc.zzhgu.zzhgp.zza(this.zzhhb, th);
    }
}
