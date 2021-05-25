package com.google.android.gms.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzut;
import com.google.android.gms.internal.ads.zzys;
public final class InterstitialAd {
    private final zzys zzadf;

    public InterstitialAd(Context context) {
        this.zzadf = new zzys(context);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.zzadf.getAdListener();
    }

    public final Bundle getAdMetadata() {
        return this.zzadf.getAdMetadata();
    }

    public final String getAdUnitId() {
        return this.zzadf.getAdUnitId();
    }

    @Deprecated
    public final String getMediationAdapterClassName() {
        return this.zzadf.getMediationAdapterClassName();
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
    public final void loadAd(AdRequest adRequest) {
        this.zzadf.zza(adRequest.zzdp());
    }

    public final void setAdListener(AdListener adListener) {
        this.zzadf.setAdListener(adListener);
        if (adListener != null && (adListener instanceof zzut)) {
            this.zzadf.zza((zzut) adListener);
        } else if (adListener == null) {
            this.zzadf.zza((zzut) null);
        }
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        this.zzadf.setAdMetadataListener(adMetadataListener);
    }

    public final void setAdUnitId(String str) {
        this.zzadf.setAdUnitId(str);
    }

    public final void setImmersiveMode(boolean z) {
        this.zzadf.setImmersiveMode(z);
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        this.zzadf.setOnPaidEventListener(onPaidEventListener);
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzadf.setRewardedVideoAdListener(rewardedVideoAdListener);
    }

    public final void show() {
        this.zzadf.show();
    }

    public final void zzd(boolean z) {
        this.zzadf.zzd(true);
    }
}
