package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAppInstallAd;
public final class zzagg extends zzaev {
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzddo;

    public zzagg(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzddo = onAppInstallAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void zza(zzaek zzaek) {
        this.zzddo.onAppInstallAdLoaded(new zzael(zzaek));
    }
}
