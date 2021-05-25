package com.yandex.mobile.ads.mediation.banner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.mediation.base.a;
import java.util.Map;
public abstract class MediatedBannerAdapter extends a {

    public interface MediatedBannerAdapterListener {
        void onAdClicked();

        void onAdFailedToLoad(@NonNull AdRequestError adRequestError);

        void onAdLeftApplication();

        void onAdLoaded(@NonNull View view);
    }

    public abstract void loadBanner(@NonNull Context context, @NonNull MediatedBannerAdapterListener mediatedBannerAdapterListener, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2);

    public abstract void onInvalidate();
}
