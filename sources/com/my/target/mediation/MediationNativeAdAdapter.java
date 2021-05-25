package com.my.target.mediation;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.nativeads.banners.NativePromoBanner;
import java.util.List;
public interface MediationNativeAdAdapter extends MediationAdapter {

    public interface MediationNativeAdListener {
        void onClick(@NonNull MediationNativeAdAdapter mediationNativeAdAdapter);

        void onLoad(@NonNull NativePromoBanner nativePromoBanner, @NonNull MediationNativeAdAdapter mediationNativeAdAdapter);

        void onNoAd(@NonNull String str, @NonNull MediationNativeAdAdapter mediationNativeAdAdapter);

        void onShow(@NonNull MediationNativeAdAdapter mediationNativeAdAdapter);

        void onVideoComplete(@NonNull MediationNativeAdAdapter mediationNativeAdAdapter);

        void onVideoPause(@NonNull MediationNativeAdAdapter mediationNativeAdAdapter);

        void onVideoPlay(@NonNull MediationNativeAdAdapter mediationNativeAdAdapter);
    }

    @Nullable
    View getMediaView(@NonNull Context context);

    void load(@NonNull MediationNativeAdConfig mediationNativeAdConfig, @NonNull MediationNativeAdListener mediationNativeAdListener, @NonNull Context context);

    void registerView(@NonNull View view, @Nullable List<View> list, int i);

    void unregisterView();
}
