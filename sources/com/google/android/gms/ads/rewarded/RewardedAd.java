package com.google.android.gms.ads.rewarded;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzauw;
public final class RewardedAd {
    private final zzauw zzhim;

    public RewardedAd(Context context, String str) {
        Preconditions.checkNotNull(context, "context cannot be null");
        Preconditions.checkNotNull(str, "adUnitID cannot be null");
        this.zzhim = new zzauw(context, str);
    }

    public final Bundle getAdMetadata() {
        return this.zzhim.getAdMetadata();
    }

    @Deprecated
    public final String getMediationAdapterClassName() {
        return this.zzhim.getMediationAdapterClassName();
    }

    @Nullable
    public final ResponseInfo getResponseInfo() {
        return this.zzhim.getResponseInfo();
    }

    @Nullable
    public final RewardItem getRewardItem() {
        return this.zzhim.getRewardItem();
    }

    public final boolean isLoaded() {
        return this.zzhim.isLoaded();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(AdRequest adRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.zzhim.zza(adRequest.zzdp(), rewardedAdLoadCallback);
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzhim.setOnAdMetadataChangedListener(onAdMetadataChangedListener);
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        this.zzhim.setOnPaidEventListener(onPaidEventListener);
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.zzhim.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback) {
        this.zzhim.show(activity, rewardedAdCallback);
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(PublisherAdRequest publisherAdRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.zzhim.zza(publisherAdRequest.zzdp(), rewardedAdLoadCallback);
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        this.zzhim.show(activity, rewardedAdCallback, z);
    }
}
