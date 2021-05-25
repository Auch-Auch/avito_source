package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
public final class zzavj extends zzaus {
    private final RewardedInterstitialAdLoadCallback zzdvo;
    private final zzavi zzdvp;

    public zzavj(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzavi zzavi) {
        this.zzdvo = rewardedInterstitialAdLoadCallback;
        this.zzdvp = zzavi;
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final void onRewardedAdFailedToLoad(int i) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zzdvo;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onRewardedInterstitialAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final void onRewardedAdLoaded() {
        zzavi zzavi;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zzdvo;
        if (rewardedInterstitialAdLoadCallback != null && (zzavi = this.zzdvp) != null) {
            rewardedInterstitialAdLoadCallback.onRewardedInterstitialAdLoaded(zzavi);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final void zze(zzuw zzuw) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zzdvo;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onRewardedInterstitialAdFailedToLoad(zzuw.zzpg());
        }
    }
}
