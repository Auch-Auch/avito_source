package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MuteThisAdListener;
public final class zzxs extends zzxq {
    private final MuteThisAdListener zzciz;

    public zzxs(MuteThisAdListener muteThisAdListener) {
        this.zzciz = muteThisAdListener;
    }

    @Override // com.google.android.gms.internal.ads.zzxr
    public final void onAdMuted() {
        this.zzciz.onAdMuted();
    }
}
