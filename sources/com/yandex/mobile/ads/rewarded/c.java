package com.yandex.mobile.ads.rewarded;

import android.support.annotation.NonNull;
public final class c implements Reward {
    private final int a;
    @NonNull
    private final String b;

    public c(int i, @NonNull String str) {
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
