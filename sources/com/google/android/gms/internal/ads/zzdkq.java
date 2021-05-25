package com.google.android.gms.internal.ads;
public final class zzdkq implements zzcya<zzchu> {
    private final /* synthetic */ zzdkr zzgzx;

    public zzdkq(zzdkr zzdkr) {
        this.zzgzx = zzdkr;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzcya
    public final /* synthetic */ void onSuccess(zzchu zzchu) {
        zzchu zzchu2 = zzchu;
        synchronized (this.zzgzx) {
            this.zzgzx.zzgzw = zzchu2;
            this.zzgzx.zzgzw.zzahw();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final void zzaqe() {
        synchronized (this.zzgzx) {
            this.zzgzx.zzgzw = null;
        }
    }
}
