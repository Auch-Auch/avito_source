package com.google.android.gms.internal.ads;
public final class zzsu implements zzrh {
    private final /* synthetic */ zzss zzbuu;

    public zzsu(zzss zzss) {
        this.zzbuu = zzss;
    }

    @Override // com.google.android.gms.internal.ads.zzrh
    public final void zzp(boolean z) {
        if (z) {
            this.zzbuu.connect();
        } else {
            this.zzbuu.disconnect();
        }
    }
}
