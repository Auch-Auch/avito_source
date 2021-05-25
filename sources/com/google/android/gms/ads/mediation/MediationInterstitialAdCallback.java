package com.google.android.gms.ads.mediation;
public interface MediationInterstitialAdCallback extends MediationAdCallback {
    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    void onAdFailedToShow(String str);

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdCallback
    void onAdLeftApplication();
}
