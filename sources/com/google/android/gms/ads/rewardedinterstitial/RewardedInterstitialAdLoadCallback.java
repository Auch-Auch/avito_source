package com.google.android.gms.ads.rewardedinterstitial;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.LoadAdError;
public class RewardedInterstitialAdLoadCallback {
    @Deprecated
    public void onRewardedInterstitialAdFailedToLoad(int i) {
    }

    public void onRewardedInterstitialAdFailedToLoad(LoadAdError loadAdError) {
    }

    public void onRewardedInterstitialAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
    }
}
