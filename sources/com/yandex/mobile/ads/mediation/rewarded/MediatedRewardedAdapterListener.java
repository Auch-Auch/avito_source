package com.yandex.mobile.ads.mediation.rewarded;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.AdRequestError;
public interface MediatedRewardedAdapterListener {
    void onRewarded(@Nullable MediatedReward mediatedReward);

    void onRewardedAdClicked();

    void onRewardedAdDismissed();

    void onRewardedAdFailedToLoad(@NonNull AdRequestError adRequestError);

    void onRewardedAdLeftApplication();

    void onRewardedAdLoaded();

    void onRewardedAdShown();
}
