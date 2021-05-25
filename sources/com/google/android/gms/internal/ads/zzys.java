package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;
public final class zzys {
    private final zzvh zzacs;
    private AppEventListener zzbnw;
    private boolean zzbox;
    private zzwu zzbun;
    private String zzbuo;
    private final zzamr zzbuq;
    private zzut zzcgq;
    private AdListener zzcgu;
    private AdMetadataListener zzchk;
    private OnCustomRenderedAdLoadedListener zzcjl;
    @Nullable
    private OnPaidEventListener zzcjo;
    private RewardedVideoAdListener zzcjt;
    private boolean zzcju;
    private final Context zzvr;

    public zzys(Context context) {
        this(context, zzvh.zzchm, null);
    }

    private final void zzcr(String str) {
        if (this.zzbun == null) {
            throw new IllegalStateException(a.s2(a.q0(str, 63), "The ad unit ID must be set on InterstitialAd before ", str, " is called."));
        }
    }

    public final AdListener getAdListener() {
        return this.zzcgu;
    }

    public final Bundle getAdMetadata() {
        try {
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                return zzwu.getAdMetadata();
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
        return new Bundle();
    }

    public final String getAdUnitId() {
        return this.zzbuo;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzbnw;
    }

    public final String getMediationAdapterClassName() {
        try {
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                return zzwu.zzkf();
            }
            return null;
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzcjl;
    }

    public final ResponseInfo getResponseInfo() {
        zzyf zzyf = null;
        try {
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                zzyf = zzwu.zzkg();
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zza(zzyf);
    }

    public final boolean isLoaded() {
        try {
            zzwu zzwu = this.zzbun;
            if (zzwu == null) {
                return false;
            }
            return zzwu.isReady();
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final boolean isLoading() {
        try {
            zzwu zzwu = this.zzbun;
            if (zzwu == null) {
                return false;
            }
            return zzwu.isLoading();
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final void setAdListener(AdListener adListener) {
        try {
            this.zzcgu = adListener;
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                zzwu.zza(adListener != null ? new zzuy(adListener) : null);
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        try {
            this.zzchk = adMetadataListener;
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                zzwu.zza(adMetadataListener != null ? new zzvd(adMetadataListener) : null);
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAdUnitId(String str) {
        if (this.zzbuo == null) {
            this.zzbuo = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzbnw = appEventListener;
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                zzwu.zza(appEventListener != null ? new zzvn(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setImmersiveMode(boolean z) {
        try {
            this.zzbox = z;
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                zzwu.setImmersiveMode(z);
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.zzcjl = onCustomRenderedAdLoadedListener;
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                zzwu.zza(onCustomRenderedAdLoadedListener != null ? new zzabr(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        try {
            this.zzcjo = onPaidEventListener;
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                zzwu.zza(new zzzt(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.zzcjt = rewardedVideoAdListener;
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                zzwu.zza(rewardedVideoAdListener != null ? new zzatw(rewardedVideoAdListener) : null);
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void show() {
        try {
            zzcr("show");
            this.zzbun.showInterstitial();
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzyo zzyo) {
        try {
            if (this.zzbun == null) {
                if (this.zzbuo == null) {
                    zzcr("loadAd");
                }
                zzvj zzpj = this.zzcju ? zzvj.zzpj() : new zzvj();
                zzvr zzpr = zzwe.zzpr();
                Context context = this.zzvr;
                zzwu zzwu = (zzwu) new zzvz(zzpr, context, zzpj, this.zzbuo, this.zzbuq).zzd(context, false);
                this.zzbun = zzwu;
                if (this.zzcgu != null) {
                    zzwu.zza(new zzuy(this.zzcgu));
                }
                if (this.zzcgq != null) {
                    this.zzbun.zza(new zzuv(this.zzcgq));
                }
                if (this.zzchk != null) {
                    this.zzbun.zza(new zzvd(this.zzchk));
                }
                if (this.zzbnw != null) {
                    this.zzbun.zza(new zzvn(this.zzbnw));
                }
                if (this.zzcjl != null) {
                    this.zzbun.zza(new zzabr(this.zzcjl));
                }
                if (this.zzcjt != null) {
                    this.zzbun.zza(new zzatw(this.zzcjt));
                }
                this.zzbun.zza(new zzzt(this.zzcjo));
                this.zzbun.setImmersiveMode(this.zzbox);
            }
            if (this.zzbun.zza(zzvh.zza(this.zzvr, zzyo))) {
                this.zzbuq.zzf(zzyo.zzqn());
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zzd(boolean z) {
        this.zzcju = true;
    }

    public zzys(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzvh.zzchm, publisherInterstitialAd);
    }

    @VisibleForTesting
    private zzys(Context context, zzvh zzvh, PublisherInterstitialAd publisherInterstitialAd) {
        this.zzbuq = new zzamr();
        this.zzvr = context;
        this.zzacs = zzvh;
    }

    public final void zza(zzut zzut) {
        try {
            this.zzcgq = zzut;
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                zzwu.zza(zzut != null ? new zzuv(zzut) : null);
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }
}
