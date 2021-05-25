package com.google.android.gms.internal.ads;
public final class zzdkn implements zzcya<zzchu> {
    private final /* synthetic */ zzdkl zzgzt;

    public zzdkn(zzdkl zzdkl) {
        this.zzgzt = zzdkl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzcya
    public final /* synthetic */ void onSuccess(zzchu zzchu) {
        zzchu zzchu2 = zzchu;
        synchronized (this.zzgzt) {
            this.zzgzt.zzgzw = zzchu2;
            this.zzgzt.zzgzw.zzahw();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final void zzaqe() {
        synchronized (this.zzgzt) {
            this.zzgzt.zzgzw = null;
        }
    }
}
