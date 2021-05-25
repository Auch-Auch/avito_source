package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
public class zzyv {
    @GuardedBy("InternalMobileAds.class")
    private static zzyv zzcjy;
    private final Object lock = new Object();
    @GuardedBy("lock")
    private zzxk zzcjz;
    private RewardedVideoAd zzcka;
    @NonNull
    private RequestConfiguration zzckb = new RequestConfiguration.Builder().build();
    private InitializationStatus zzckc;
    private boolean zzxi = false;

    private zzyv() {
    }

    /* access modifiers changed from: private */
    public static InitializationStatus zzd(List<zzaif> list) {
        HashMap hashMap = new HashMap();
        for (zzaif zzaif : list) {
            hashMap.put(zzaif.zzdfe, new zzain(zzaif.zzdff ? AdapterStatus.State.READY : AdapterStatus.State.NOT_READY, zzaif.description, zzaif.zzdfg));
        }
        return new zzaiq(hashMap);
    }

    @GuardedBy("lock")
    private final void zzg(Context context) {
        if (this.zzcjz == null) {
            this.zzcjz = (zzxk) new zzwb(zzwe.zzpr(), context).zzd(context, false);
        }
    }

    public static zzyv zzqt() {
        zzyv zzyv;
        synchronized (zzyv.class) {
            if (zzcjy == null) {
                zzcjy = new zzyv();
            }
            zzyv = zzcjy;
        }
        return zzyv;
    }

    public final void disableMediationAdapterInitialization(Context context) {
        synchronized (this.lock) {
            zzg(context);
            try {
                this.zzcjz.zzqg();
            } catch (RemoteException unused) {
                zzbbd.zzfc("Unable to disable mediation adapter initialization.");
            }
        }
    }

    public final InitializationStatus getInitializationStatus() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzcjz != null, "MobileAds.initialize() must be called prior to getting initialization status.");
            try {
                InitializationStatus initializationStatus = this.zzckc;
                if (initializationStatus != null) {
                    return initializationStatus;
                }
                return zzd(this.zzcjz.zzqf());
            } catch (RemoteException unused) {
                zzbbd.zzfc("Unable to get Initialization status.");
                return null;
            }
        }
    }

    @NonNull
    public final RequestConfiguration getRequestConfiguration() {
        return this.zzckb;
    }

    public final RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        synchronized (this.lock) {
            RewardedVideoAd rewardedVideoAd = this.zzcka;
            if (rewardedVideoAd != null) {
                return rewardedVideoAd;
            }
            zzaub zzaub = new zzaub(context, (zzatm) new zzwc(zzwe.zzpr(), context, new zzamr()).zzd(context, false));
            this.zzcka = zzaub;
            return zzaub;
        }
    }

    public final String getVersionString() {
        String zzhi;
        synchronized (this.lock) {
            Preconditions.checkState(this.zzcjz != null, "MobileAds.initialize() must be called prior to getting version string.");
            try {
                zzhi = zzdsw.zzhi(this.zzcjz.getVersionString());
            } catch (RemoteException e) {
                zzbbd.zzc("Unable to get version string.", e);
                return "";
            }
        }
        return zzhi;
    }

    public final void openDebugMenu(Context context, String str) {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzcjz != null, "MobileAds.initialize() must be called prior to opening debug menu.");
            try {
                this.zzcjz.zzb(ObjectWrapper.wrap(context), str);
            } catch (RemoteException e) {
                zzbbd.zzc("Unable to open debug menu.", e);
            }
        }
    }

    public final void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        synchronized (this.lock) {
            try {
                this.zzcjz.zzci(cls.getCanonicalName());
            } catch (RemoteException e) {
                zzbbd.zzc("Unable to register RtbAdapter", e);
            }
        }
    }

    public final void setAppMuted(boolean z) {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzcjz != null, "MobileAds.initialize() must be called prior to setting app muted state.");
            try {
                this.zzcjz.setAppMuted(z);
            } catch (RemoteException e) {
                zzbbd.zzc("Unable to set app mute state.", e);
            }
        }
    }

    public final void setAppVolume(float f) {
        boolean z = true;
        Preconditions.checkArgument(0.0f <= f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        synchronized (this.lock) {
            if (this.zzcjz == null) {
                z = false;
            }
            Preconditions.checkState(z, "MobileAds.initialize() must be called prior to setting the app volume.");
            try {
                this.zzcjz.setAppVolume(f);
            } catch (RemoteException e) {
                zzbbd.zzc("Unable to set app volume.", e);
            }
        }
    }

    public final void setRequestConfiguration(@NonNull RequestConfiguration requestConfiguration) {
        Preconditions.checkArgument(requestConfiguration != null, "Null passed to setRequestConfiguration.");
        synchronized (this.lock) {
            RequestConfiguration requestConfiguration2 = this.zzckb;
            this.zzckb = requestConfiguration;
            if (this.zzcjz != null) {
                if (!(requestConfiguration2.getTagForChildDirectedTreatment() == requestConfiguration.getTagForChildDirectedTreatment() && requestConfiguration2.getTagForUnderAgeOfConsent() == requestConfiguration.getTagForUnderAgeOfConsent())) {
                    zza(requestConfiguration);
                }
            }
        }
    }

    public final void zza(Context context, String str, OnInitializationCompleteListener onInitializationCompleteListener) {
        synchronized (this.lock) {
            if (!this.zzxi) {
                if (context != null) {
                    try {
                        zzamm.zztn().zzd(context, str);
                        zzg(context);
                        this.zzxi = true;
                        if (onInitializationCompleteListener != null) {
                            this.zzcjz.zza(new zza(this, onInitializationCompleteListener, null));
                        }
                        this.zzcjz.zza(new zzamr());
                        this.zzcjz.initialize();
                        this.zzcjz.zza(str, ObjectWrapper.wrap(new Runnable(this, context) { // from class: com.google.android.gms.internal.ads.zzyu
                            private final zzyv zzcjw;
                            private final Context zzcjx;

                            {
                                this.zzcjw = r1;
                                this.zzcjx = r2;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zzcjw.getRewardedVideoAdInstance(this.zzcjx);
                            }
                        }));
                        if (!(this.zzckb.getTagForChildDirectedTreatment() == -1 && this.zzckb.getTagForUnderAgeOfConsent() == -1)) {
                            zza(this.zzckb);
                        }
                        zzaat.initialize(context);
                        if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcud)).booleanValue() && !getVersionString().endsWith("0")) {
                            zzbbd.zzfc("Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.");
                            this.zzckc = new InitializationStatus(this) { // from class: com.google.android.gms.internal.ads.zzyw
                                private final zzyv zzcjw;

                                {
                                    this.zzcjw = r1;
                                }

                                @Override // com.google.android.gms.ads.initialization.InitializationStatus
                                public final Map getAdapterStatusMap() {
                                    zzyv zzyv = this.zzcjw;
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("com.google.android.gms.ads.MobileAds", new zzyy(zzyv));
                                    return hashMap;
                                }
                            };
                            if (onInitializationCompleteListener != null) {
                                zzbat.zzaah.post(new Runnable(this, onInitializationCompleteListener) { // from class: com.google.android.gms.internal.ads.zzyx
                                    private final zzyv zzcjw;
                                    private final OnInitializationCompleteListener zzckd;

                                    {
                                        this.zzcjw = r1;
                                        this.zzckd = r2;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.zzcjw.zza(this.zzckd);
                                    }
                                });
                            }
                        }
                    } catch (RemoteException e) {
                        zzbbd.zzd("MobileAdsSettingManager initialization failed", e);
                    }
                    return;
                }
                throw new IllegalArgumentException("Context cannot be null.");
            }
        }
    }

    public final float zzqd() {
        synchronized (this.lock) {
            zzxk zzxk = this.zzcjz;
            float f = 1.0f;
            if (zzxk == null) {
                return 1.0f;
            }
            try {
                f = zzxk.zzqd();
            } catch (RemoteException e) {
                zzbbd.zzc("Unable to get app volume.", e);
            }
            return f;
        }
    }

    public final boolean zzqe() {
        synchronized (this.lock) {
            zzxk zzxk = this.zzcjz;
            boolean z = false;
            if (zzxk == null) {
                return false;
            }
            try {
                z = zzxk.zzqe();
            } catch (RemoteException e) {
                zzbbd.zzc("Unable to get app mute state.", e);
            }
            return z;
        }
    }

    public class zza extends zzail {
        private final OnInitializationCompleteListener zzcke;

        private zza(OnInitializationCompleteListener onInitializationCompleteListener) {
            this.zzcke = onInitializationCompleteListener;
        }

        @Override // com.google.android.gms.internal.ads.zzaim
        public final void zze(List<zzaif> list) throws RemoteException {
            OnInitializationCompleteListener onInitializationCompleteListener = this.zzcke;
            zzyv zzyv = zzyv.this;
            onInitializationCompleteListener.onInitializationComplete(zzyv.zzd(list));
        }

        public /* synthetic */ zza(zzyv zzyv, OnInitializationCompleteListener onInitializationCompleteListener, zzyy zzyy) {
            this(onInitializationCompleteListener);
        }
    }

    @GuardedBy("lock")
    private final void zza(@NonNull RequestConfiguration requestConfiguration) {
        try {
            this.zzcjz.zza(new zzzw(requestConfiguration));
        } catch (RemoteException e) {
            zzbbd.zzc("Unable to set request configuration parcel.", e);
        }
    }

    public final /* synthetic */ void zza(OnInitializationCompleteListener onInitializationCompleteListener) {
        onInitializationCompleteListener.onInitializationComplete(this.zzckc);
    }
}
