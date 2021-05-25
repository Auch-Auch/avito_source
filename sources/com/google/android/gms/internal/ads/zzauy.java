package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdCallback;
public final class zzauy extends zzaup {
    private final RewardedAdCallback zzdvi;

    public zzauy(RewardedAdCallback rewardedAdCallback) {
        this.zzdvi = rewardedAdCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzaum
    public final void onRewardedAdClosed() {
        RewardedAdCallback rewardedAdCallback = this.zzdvi;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaum
    public final void onRewardedAdFailedToShow(int i) {
        RewardedAdCallback rewardedAdCallback = this.zzdvi;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdFailedToShow(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaum
    public final void onRewardedAdOpened() {
        RewardedAdCallback rewardedAdCallback = this.zzdvi;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaum
    public final void zza(zzaug zzaug) {
        RewardedAdCallback rewardedAdCallback = this.zzdvi;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onUserEarnedReward(new zzauz(zzaug));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaum
    public final void zzd(zzuw zzuw) {
        RewardedAdCallback rewardedAdCallback = this.zzdvi;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdFailedToShow(zzuw.zzpf());
        }
    }
}
