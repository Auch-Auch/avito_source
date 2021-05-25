package com.google.android.gms.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.rewarded.RewardItem;
public interface OnUserEarnedRewardListener {
    void onUserEarnedReward(@NonNull RewardItem rewardItem);
}
