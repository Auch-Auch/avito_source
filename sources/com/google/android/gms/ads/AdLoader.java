package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzadm;
import com.google.android.gms.internal.ads.zzagc;
import com.google.android.gms.internal.ads.zzagf;
import com.google.android.gms.internal.ads.zzagg;
import com.google.android.gms.internal.ads.zzagi;
import com.google.android.gms.internal.ads.zzagk;
import com.google.android.gms.internal.ads.zzamr;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzuy;
import com.google.android.gms.internal.ads.zzvh;
import com.google.android.gms.internal.ads.zzvj;
import com.google.android.gms.internal.ads.zzwe;
import com.google.android.gms.internal.ads.zzwm;
import com.google.android.gms.internal.ads.zzwr;
import com.google.android.gms.internal.ads.zzyo;
public class AdLoader {
    private final zzvh zzacs;
    private final zzwm zzact;
    private final Context zzvr;

    public AdLoader(Context context, zzwm zzwm) {
        this(context, zzwm, zzvh.zzchm);
    }

    private final void zza(zzyo zzyo) {
        try {
            this.zzact.zzb(zzvh.zza(this.zzvr, zzyo));
        } catch (RemoteException e) {
            zzbbd.zzc("Failed to load ad.", e);
        }
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        try {
            return this.zzact.zzkf();
        } catch (RemoteException e) {
            zzbbd.zzd("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.zzact.isLoading();
        } catch (RemoteException e) {
            zzbbd.zzd("Failed to check if ad is loading.", e);
            return false;
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        zza(adRequest.zzdp());
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAds(AdRequest adRequest, int i) {
        try {
            this.zzact.zza(zzvh.zza(this.zzvr, adRequest.zzdp()), i);
        } catch (RemoteException e) {
            zzbbd.zzc("Failed to load ads.", e);
        }
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzdp());
    }

    private AdLoader(Context context, zzwm zzwm, zzvh zzvh) {
        this.zzvr = context;
        this.zzact = zzwm;
        this.zzacs = zzvh;
    }

    public static class Builder {
        private final zzwr zzacr;
        private final Context zzvr;

        public Builder(Context context, String str) {
            this((Context) Preconditions.checkNotNull(context, "context cannot be null"), zzwe.zzpr().zzb(context, str, new zzamr()));
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.zzvr, this.zzacr.zzqc());
            } catch (RemoteException e) {
                zzbbd.zzc("Failed to build AdLoader.", e);
                return null;
            }
        }

        @Deprecated
        public Builder forAppInstallAd(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.zzacr.zza(new zzagg(onAppInstallAdLoadedListener));
            } catch (RemoteException e) {
                zzbbd.zzd("Failed to add app install ad listener", e);
            }
            return this;
        }

        @Deprecated
        public Builder forContentAd(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.zzacr.zza(new zzagf(onContentAdLoadedListener));
            } catch (RemoteException e) {
                zzbbd.zzd("Failed to add content ad listener", e);
            }
            return this;
        }

        public Builder forCustomTemplateAd(String str, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            zzagc zzagc = new zzagc(onCustomTemplateAdLoadedListener, onCustomClickListener);
            try {
                this.zzacr.zza(str, zzagc.zzst(), zzagc.zzsu());
            } catch (RemoteException e) {
                zzbbd.zzd("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder forPublisherAdView(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener, AdSize... adSizeArr) {
            if (adSizeArr == null || adSizeArr.length <= 0) {
                throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
            }
            try {
                this.zzacr.zza(new zzagi(onPublisherAdViewLoadedListener), new zzvj(this.zzvr, adSizeArr));
            } catch (RemoteException e) {
                zzbbd.zzd("Failed to add publisher banner ad listener", e);
            }
            return this;
        }

        public Builder forUnifiedNativeAd(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
            try {
                this.zzacr.zza(new zzagk(onUnifiedNativeAdLoadedListener));
            } catch (RemoteException e) {
                zzbbd.zzd("Failed to add google native ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.zzacr.zzb(new zzuy(adListener));
            } catch (RemoteException e) {
                zzbbd.zzd("Failed to set AdListener.", e);
            }
            return this;
        }

        @KeepForSdk
        @Deprecated
        public Builder withCorrelator(@NonNull Correlator correlator) {
            return this;
        }

        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.zzacr.zza(new zzadm(nativeAdOptions));
            } catch (RemoteException e) {
                zzbbd.zzd("Failed to specify native ad options", e);
            }
            return this;
        }

        public Builder withPublisherAdViewOptions(PublisherAdViewOptions publisherAdViewOptions) {
            try {
                this.zzacr.zza(publisherAdViewOptions);
            } catch (RemoteException e) {
                zzbbd.zzd("Failed to specify DFP banner ad options", e);
            }
            return this;
        }

        private Builder(Context context, zzwr zzwr) {
            this.zzvr = context;
            this.zzacr = zzwr;
        }
    }
}
