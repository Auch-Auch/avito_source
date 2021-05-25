package com.google.android.gms.ads.mediation;
public interface MediationBannerAdCallback extends MediationAdCallback {
    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdCallback, com.google.android.gms.ads.mediation.MediationNativeAdCallback
    void onAdLeftApplication();
}
