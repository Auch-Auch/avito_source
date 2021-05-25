package com.google.android.gms.internal.ads;
public final class zzalx implements zzbbs {
    private final /* synthetic */ zzbbq zzdew;
    private final /* synthetic */ zzakx zzdib;

    public zzalx(zzalv zzalv, zzbbq zzbbq, zzakx zzakx) {
        this.zzdew = zzbbq;
        this.zzdib = zzakx;
    }

    @Override // com.google.android.gms.internal.ads.zzbbs
    public final void run() {
        this.zzdew.setException(new zzalj("Unable to obtain a JavascriptEngine."));
        this.zzdib.release();
    }
}
