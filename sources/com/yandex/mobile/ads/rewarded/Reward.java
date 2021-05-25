package com.yandex.mobile.ads.rewarded;

import android.support.annotation.NonNull;
public interface Reward {
    int getAmount();

    @NonNull
    String getType();
}
