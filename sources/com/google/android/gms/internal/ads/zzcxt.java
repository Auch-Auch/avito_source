package com.google.android.gms.internal.ads;
public final class zzcxt implements zzcya<zzbpd> {
    private final /* synthetic */ zzcxu zzgqu;

    public zzcxt(zzcxu zzcxu) {
        this.zzgqu = zzcxu;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzcya
    public final /* synthetic */ void onSuccess(zzbpd zzbpd) {
        zzbpd zzbpd2 = zzbpd;
        synchronized (this.zzgqu) {
            this.zzgqu.zzaey = false;
            this.zzgqu.zzadq = zzbpd2.zzaim();
            zzbpd2.zzahw();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final void zzaqe() {
        synchronized (this.zzgqu) {
            this.zzgqu.zzaey = false;
        }
    }
}
