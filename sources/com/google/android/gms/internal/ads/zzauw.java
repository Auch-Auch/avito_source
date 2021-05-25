package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzauw {
    private final Context zzaai;
    private final zzaul zzdvh;

    public zzauw(Context context, String str) {
        this.zzaai = context.getApplicationContext();
        this.zzdvh = zzwe.zzpr().zzc(context, str, new zzamr());
    }

    public final Bundle getAdMetadata() {
        try {
            return this.zzdvh.getAdMetadata();
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            return new Bundle();
        }
    }

    public final String getMediationAdapterClassName() {
        try {
            return this.zzdvh.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            return "";
        }
    }

    @Nullable
    public final ResponseInfo getResponseInfo() {
        zzyf zzyf;
        try {
            zzyf = this.zzdvh.zzkg();
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            zzyf = null;
        }
        return ResponseInfo.zza(zzyf);
    }

    @Nullable
    public final RewardItem getRewardItem() {
        try {
            zzaug zzqw = this.zzdvh.zzqw();
            if (zzqw == null) {
                return null;
            }
            return new zzauz(zzqw);
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final boolean isLoaded() {
        try {
            return this.zzdvh.isLoaded();
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        try {
            this.zzdvh.zza(new zzzu(onAdMetadataChangedListener));
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        try {
            this.zzdvh.zza(new zzzt(onPaidEventListener));
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            this.zzdvh.zza(new zzavc(serverSideVerificationOptions));
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback) {
        try {
            this.zzdvh.zza(new zzauy(rewardedAdCallback));
            this.zzdvh.zzh(ObjectWrapper.wrap(activity));
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzyo zzyo, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            this.zzdvh.zza(zzvh.zza(this.zzaai, zzyo), new zzavd(rewardedAdLoadCallback));
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        try {
            this.zzdvh.zza(new zzauy(rewardedAdCallback));
            this.zzdvh.zza(ObjectWrapper.wrap(activity), z);
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }
}
