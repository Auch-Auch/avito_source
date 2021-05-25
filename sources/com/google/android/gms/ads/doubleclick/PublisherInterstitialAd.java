package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzys;
public final class PublisherInterstitialAd {
    private final zzys zzadf;

    public PublisherInterstitialAd(Context context) {
        this.zzadf = new zzys(context, this);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.zzadf.getAdListener();
    }

    public final String getAdUnitId() {
        return this.zzadf.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.zzadf.getAppEventListener();
    }

    @Deprecated
    public final String getMediationAdapterClassName() {
        return this.zzadf.getMediationAdapterClassName();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzadf.getOnCustomRenderedAdLoadedListener();
    }

    @Nullable
    public final ResponseInfo getResponseInfo() {
        return this.zzadf.getResponseInfo();
    }

    public final boolean isLoaded() {
        return this.zzadf.isLoaded();
    }

    public final boolean isLoading() {
        return this.zzadf.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzadf.zza(publisherAdRequest.zzdp());
    }

    public final void setAdListener(AdListener adListener) {
        this.zzadf.setAdListener(adListener);
    }

    public final void setAdUnitId(String str) {
        this.zzadf.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.zzadf.setAppEventListener(appEventListener);
    }

    @KeepForSdk
    @Deprecated
    public final void setCorrelator(Correlator correlator) {
    }

    public final void setImmersiveMode(boolean z) {
        this.zzadf.setImmersiveMode(z);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzadf.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public final void show() {
        this.zzadf.show();
    }
}
