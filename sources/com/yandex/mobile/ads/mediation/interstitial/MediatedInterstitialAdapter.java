package com.yandex.mobile.ads.mediation.interstitial;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.mediation.base.a;
import java.util.Map;
public abstract class MediatedInterstitialAdapter extends a {

    public interface MediatedInterstitialAdapterListener {
        void onInterstitialClicked();

        void onInterstitialDismissed();

        void onInterstitialFailedToLoad(@NonNull AdRequestError adRequestError);

        void onInterstitialLeftApplication();

        void onInterstitialLoaded();

        void onInterstitialShown();
    }

    public abstract boolean isLoaded();

    public abstract void loadInterstitial(@NonNull Context context, @NonNull MediatedInterstitialAdapterListener mediatedInterstitialAdapterListener, @NonNull Map<String, Object> map, @NonNull Map<String, String> map2);

    public abstract void onInvalidate();

    public abstract void showInterstitial();
}
