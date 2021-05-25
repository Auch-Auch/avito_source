package com.my.target.mediation;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.nativeads.banners.NativeBanner;
import java.util.List;
public interface MediationNativeBannerAdAdapter extends MediationAdapter {

    public interface MediationNativeBannerAdListener {
        void onClick(@NonNull MediationNativeBannerAdAdapter mediationNativeBannerAdAdapter);

        void onLoad(@NonNull NativeBanner nativeBanner, @NonNull MediationNativeBannerAdAdapter mediationNativeBannerAdAdapter);

        void onNoAd(@NonNull String str, @NonNull MediationNativeBannerAdAdapter mediationNativeBannerAdAdapter);

        void onShow(@NonNull MediationNativeBannerAdAdapter mediationNativeBannerAdAdapter);
    }

    @Nullable
    View getIconView(@NonNull Context context);

    void load(@NonNull MediationNativeBannerAdConfig mediationNativeBannerAdConfig, @NonNull MediationNativeBannerAdListener mediationNativeBannerAdListener, @NonNull Context context);

    void registerView(@NonNull View view, @Nullable List<View> list, int i);

    void unregisterView();
}
