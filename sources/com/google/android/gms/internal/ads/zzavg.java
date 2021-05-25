package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
public final class zzavg extends zzaup {
    private FullScreenContentCallback zzdvl;
    private OnUserEarnedRewardListener zzdvm;

    @Override // com.google.android.gms.internal.ads.zzaum
    public final void onRewardedAdClosed() {
        FullScreenContentCallback fullScreenContentCallback = this.zzdvl;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdDismissedFullScreenContent();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaum
    public final void onRewardedAdFailedToShow(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzaum
    public final void onRewardedAdOpened() {
        FullScreenContentCallback fullScreenContentCallback = this.zzdvl;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdShowedFullScreenContent();
        }
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zzdvl = fullScreenContentCallback;
    }

    public final void zza(OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzdvm = onUserEarnedRewardListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaum
    public final void zzd(zzuw zzuw) {
        FullScreenContentCallback fullScreenContentCallback = this.zzdvl;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdFailedToShowFullScreenContent(zzuw.zzpf());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaum
    public final void zza(zzaug zzaug) {
        OnUserEarnedRewardListener onUserEarnedRewardListener = this.zzdvm;
        if (onUserEarnedRewardListener != null) {
            onUserEarnedRewardListener.onUserEarnedReward(new zzauz(zzaug));
        }
    }
}
