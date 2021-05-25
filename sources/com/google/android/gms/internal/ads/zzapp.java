package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
public final class zzapp implements zzo {
    private final /* synthetic */ zzapq zzdlx;

    public zzapp(zzapq zzapq) {
        this.zzdlx = zzapq;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
        zzbbd.zzef("AdMobCustomTabsAdapter overlay is paused.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
        zzbbd.zzef("AdMobCustomTabsAdapter overlay is resumed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzui() {
        zzbbd.zzef("AdMobCustomTabsAdapter overlay is closed.");
        this.zzdlx.zzdlz.onAdClosed(this.zzdlx);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzuj() {
        zzbbd.zzef("Opening AdMobCustomTabsAdapter overlay.");
        this.zzdlx.zzdlz.onAdOpened(this.zzdlx);
    }
}
