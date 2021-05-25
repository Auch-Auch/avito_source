package com.google.android.gms.ads.mediation;
public interface MediationNativeAdCallback extends MediationAdCallback {
    void onAdLeftApplication();

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    void onVideoComplete();

    void onVideoMute();

    void onVideoPause();

    void onVideoPlay();

    void onVideoUnmute();
}
