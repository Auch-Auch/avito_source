package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.appopen.AppOpenAdPresentationCallback;
public final class zzse extends zzsm {
    private final AppOpenAdPresentationCallback zzbum;

    public zzse(AppOpenAdPresentationCallback appOpenAdPresentationCallback) {
        this.zzbum = appOpenAdPresentationCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzsj
    public final void onAppOpenAdClosed() {
        this.zzbum.onAppOpenAdClosed();
    }
}
