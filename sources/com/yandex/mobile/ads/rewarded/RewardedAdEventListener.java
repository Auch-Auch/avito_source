package com.yandex.mobile.ads.rewarded;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.AdRequestError;
public abstract class RewardedAdEventListener {

    public static class SimpleRewardedAdEventListener extends RewardedAdEventListener {
        @Override // com.yandex.mobile.ads.rewarded.RewardedAdEventListener
        public void onAdClosed() {
        }

        @Override // com.yandex.mobile.ads.rewarded.RewardedAdEventListener
        public void onAdDismissed() {
        }

        @Override // com.yandex.mobile.ads.rewarded.RewardedAdEventListener
        public void onAdFailedToLoad(AdRequestError adRequestError) {
        }

        @Override // com.yandex.mobile.ads.rewarded.RewardedAdEventListener
        public void onAdLeftApplication() {
        }

        @Override // com.yandex.mobile.ads.rewarded.RewardedAdEventListener
        public void onAdLoaded() {
        }

        @Override // com.yandex.mobile.ads.rewarded.RewardedAdEventListener
        public void onAdOpened() {
        }

        @Override // com.yandex.mobile.ads.rewarded.RewardedAdEventListener
        public void onAdShown() {
        }

        @Override // com.yandex.mobile.ads.rewarded.RewardedAdEventListener
        public void onRewarded(@NonNull Reward reward) {
        }
    }

    public abstract void onAdClosed();

    public abstract void onAdDismissed();

    public abstract void onAdFailedToLoad(AdRequestError adRequestError);

    public abstract void onAdLeftApplication();

    public abstract void onAdLoaded();

    public abstract void onAdOpened();

    public abstract void onAdShown();

    public abstract void onRewarded(@NonNull Reward reward);
}
