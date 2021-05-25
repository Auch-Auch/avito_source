package com.yandex.mobile.ads.mediation.rewarded;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.mediation.base.a;
import java.util.Map;
public abstract class MediatedRewardedAdapter extends a {
    public abstract boolean isLoaded();

    public abstract void loadRewardedAd(@NonNull Context context, @NonNull MediatedRewardedAdapterListener mediatedRewardedAdapterListener, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2);

    public abstract void onInvalidate();

    public abstract void showRewardedAd();
}
