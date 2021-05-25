package com.yandex.mobile.ads.mediation.rewarded;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.rewarded.Reward;
public final class MediatedReward implements Reward {
    private final int a;
    @NonNull
    private final String b;

    public MediatedReward(int i, @NonNull String str) {
        this.a = i;
        this.b = str;
    }

    @Override // com.yandex.mobile.ads.rewarded.Reward
    public final int getAmount() {
        return this.a;
    }

    @Override // com.yandex.mobile.ads.rewarded.Reward
    @NonNull
    public final String getType() {
        return this.b;
    }
}
