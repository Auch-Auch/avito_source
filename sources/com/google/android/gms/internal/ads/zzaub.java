package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.dynamic.ObjectWrapper;
public final class zzaub implements RewardedVideoAd {
    private final Object lock = new Object();
    @NonNull
    private final zzatm zzdvc;
    private final zzatw zzdvd = new zzatw(null);
    private String zzdve;
    private String zzdvf;
    private final Context zzvr;

    public zzaub(Context context, @Nullable zzatm zzatm) {
        this.zzdvc = zzatm == null ? new zzzs() : zzatm;
        this.zzvr = context.getApplicationContext();
    }

    private final void zza(String str, zzyo zzyo) {
        synchronized (this.lock) {
            zzatm zzatm = this.zzdvc;
            if (zzatm != null) {
                try {
                    zzatm.zza(zzvh.zza(this.zzvr, zzyo, str));
                } catch (RemoteException e) {
                    zzbbd.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void destroy() {
        destroy(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final Bundle getAdMetadata() {
        synchronized (this.lock) {
            zzatm zzatm = this.zzdvc;
            if (zzatm != null) {
                try {
                    return zzatm.getAdMetadata();
                } catch (RemoteException e) {
                    zzbbd.zze("#007 Could not call remote method.", e);
                }
            }
            return new Bundle();
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getCustomData() {
        String str;
        synchronized (this.lock) {
            str = this.zzdvf;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getMediationAdapterClassName() {
        try {
            zzatm zzatm = this.zzdvc;
            if (zzatm != null) {
                return zzatm.getMediationAdapterClassName();
            }
            return null;
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final ResponseInfo getResponseInfo() {
        zzyf zzyf = null;
        try {
            zzatm zzatm = this.zzdvc;
            if (zzatm != null) {
                zzyf = zzatm.zzkg();
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zza(zzyf);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.lock) {
            rewardedVideoAdListener = this.zzdvd.getRewardedVideoAdListener();
        }
        return rewardedVideoAdListener;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getUserId() {
        String str;
        synchronized (this.lock) {
            str = this.zzdve;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final boolean isLoaded() {
        synchronized (this.lock) {
            zzatm zzatm = this.zzdvc;
            if (zzatm == null) {
                return false;
            }
            try {
                return zzatm.isLoaded();
            } catch (RemoteException e) {
                zzbbd.zze("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void loadAd(String str, AdRequest adRequest) {
        zza(str, adRequest.zzdp());
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void pause() {
        pause(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void resume() {
        resume(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        synchronized (this.lock) {
            zzatm zzatm = this.zzdvc;
            if (zzatm != null) {
                try {
                    zzatm.zza(new zzvd(adMetadataListener));
                } catch (RemoteException e) {
                    zzbbd.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setCustomData(String str) {
        synchronized (this.lock) {
            zzatm zzatm = this.zzdvc;
            if (zzatm != null) {
                try {
                    zzatm.setCustomData(str);
                    this.zzdvf = str;
                } catch (RemoteException e) {
                    zzbbd.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setImmersiveMode(boolean z) {
        synchronized (this.lock) {
            zzatm zzatm = this.zzdvc;
            if (zzatm != null) {
                try {
                    zzatm.setImmersiveMode(z);
                } catch (RemoteException e) {
                    zzbbd.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.lock) {
            this.zzdvd.setRewardedVideoAdListener(rewardedVideoAdListener);
            zzatm zzatm = this.zzdvc;
            if (zzatm != null) {
                try {
                    zzatm.zza(this.zzdvd);
                } catch (RemoteException e) {
                    zzbbd.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setUserId(String str) {
        synchronized (this.lock) {
            this.zzdve = str;
            zzatm zzatm = this.zzdvc;
            if (zzatm != null) {
                try {
                    zzatm.setUserId(str);
                } catch (RemoteException e) {
                    zzbbd.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void show() {
        synchronized (this.lock) {
            zzatm zzatm = this.zzdvc;
            if (zzatm != null) {
                try {
                    zzatm.show();
                } catch (RemoteException e) {
                    zzbbd.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void destroy(Context context) {
        synchronized (this.lock) {
            this.zzdvd.setRewardedVideoAdListener(null);
            zzatm zzatm = this.zzdvc;
            if (zzatm != null) {
                try {
                    zzatm.zzl(ObjectWrapper.wrap(context));
                } catch (RemoteException e) {
                    zzbbd.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void loadAd(String str, PublisherAdRequest publisherAdRequest) {
        zza(str, publisherAdRequest.zzdp());
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void pause(Context context) {
        synchronized (this.lock) {
            zzatm zzatm = this.zzdvc;
            if (zzatm != null) {
                try {
                    zzatm.zzj(ObjectWrapper.wrap(context));
                } catch (RemoteException e) {
                    zzbbd.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void resume(Context context) {
        synchronized (this.lock) {
            zzatm zzatm = this.zzdvc;
            if (zzatm != null) {
                try {
                    zzatm.zzk(ObjectWrapper.wrap(context));
                } catch (RemoteException e) {
                    zzbbd.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }
}
