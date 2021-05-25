package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
public final class zzabr extends zzabp {
    private final OnCustomRenderedAdLoadedListener zzcjl;

    public zzabr(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzcjl = onCustomRenderedAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzabq
    public final void zza(zzabl zzabl) {
        this.zzcjl.onCustomRenderedAdLoaded(new zzabm(zzabl));
    }
}
