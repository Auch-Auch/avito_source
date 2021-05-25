package com.yandex.mobile.ads.mediation.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.mediation.base.a;
import java.util.Map;
public abstract class MediatedNativeAdapter extends a {
    public abstract void loadAd(@NonNull Context context, @NonNull MediatedNativeAdapterListener mediatedNativeAdapterListener, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2);
}
