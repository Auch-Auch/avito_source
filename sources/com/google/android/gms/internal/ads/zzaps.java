package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.zzp;
public final class zzaps implements Runnable {
    private final /* synthetic */ zzapq zzdlx;
    private final /* synthetic */ AdOverlayInfoParcel zzdmf;

    public zzaps(zzapq zzapq, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzdlx = zzapq;
        this.zzdmf = adOverlayInfoParcel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzp.zzko();
        zzn.zza(this.zzdlx.zzdly, this.zzdmf, true);
    }
}
