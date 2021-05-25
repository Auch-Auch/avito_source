package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.internal.AnalyticsEvents;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzanq extends zzamy {
    private final Object zzdkn;
    private zzanr zzdko;
    private zzaua zzdkp;
    private IObjectWrapper zzdkq;
    private MediationRewardedAd zzdkr;

    public zzanq(@NonNull MediationAdapter mediationAdapter) {
        this.zzdkn = mediationAdapter;
    }

    private final Bundle zzd(zzvc zzvc) {
        Bundle bundle;
        Bundle bundle2 = zzvc.zzchc;
        if (bundle2 == null || (bundle = bundle2.getBundle(this.zzdkn.getClass().getName())) == null) {
            return new Bundle();
        }
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void destroy() throws RemoteException {
        Object obj = this.zzdkn;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onDestroy();
            } catch (Throwable th) {
                throw a.A1("", th);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final Bundle getInterstitialAdapterInfo() {
        Object obj = this.zzdkn;
        if (obj instanceof zzbif) {
            return ((zzbif) obj).getInterstitialAdapterInfo();
        }
        String canonicalName = zzbif.class.getCanonicalName();
        String canonicalName2 = this.zzdkn.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName2).length() + String.valueOf(canonicalName).length() + 22);
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbbd.zzfe(sb.toString());
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final zzyg getVideoController() {
        Object obj = this.zzdkn;
        if (!(obj instanceof zza)) {
            return null;
        }
        try {
            return ((zza) obj).getVideoController();
        } catch (Throwable th) {
            zzbbd.zzc("", th);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final boolean isInitialized() throws RemoteException {
        Object obj = this.zzdkn;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbbd.zzef("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.zzdkn).isInitialized();
            } catch (Throwable th) {
                throw a.A1("", th);
            }
        } else if (obj instanceof Adapter) {
            return this.zzdkp != null;
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdkn.getClass().getCanonicalName();
            StringBuilder K = a.K(a.q0(canonicalName3, a.q0(canonicalName2, a.q0(canonicalName, 26))), canonicalName, " or ", canonicalName2, " #009 Class mismatch: ");
            K.append(canonicalName3);
            zzbbd.zzfe(K.toString());
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void pause() throws RemoteException {
        Object obj = this.zzdkn;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onPause();
            } catch (Throwable th) {
                throw a.A1("", th);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void resume() throws RemoteException {
        Object obj = this.zzdkn;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onResume();
            } catch (Throwable th) {
                throw a.A1("", th);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Object obj = this.zzdkn;
        if (!(obj instanceof OnImmersiveModeUpdatedListener)) {
            String canonicalName = OnImmersiveModeUpdatedListener.class.getCanonicalName();
            String canonicalName2 = this.zzdkn.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName2).length() + String.valueOf(canonicalName).length() + 22);
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbbd.zzef(sb.toString());
            return;
        }
        try {
            ((OnImmersiveModeUpdatedListener) obj).onImmersiveModeUpdated(z);
        } catch (Throwable th) {
            zzbbd.zzc("", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void showInterstitial() throws RemoteException {
        if (this.zzdkn instanceof MediationInterstitialAdapter) {
            zzbbd.zzef("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zzdkn).showInterstitial();
            } catch (Throwable th) {
                throw a.A1("", th);
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdkn.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(a.q0(canonicalName2, a.q0(canonicalName, 22)));
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbbd.zzfe(sb.toString());
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void showVideo() throws RemoteException {
        Object obj = this.zzdkn;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbbd.zzef("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.zzdkn).showVideo();
            } catch (Throwable th) {
                throw a.A1("", th);
            }
        } else if (obj instanceof Adapter) {
            MediationRewardedAd mediationRewardedAd = this.zzdkr;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(this.zzdkq));
            } else {
                zzbbd.zzfc("Can not show null mediated rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdkn.getClass().getCanonicalName();
            StringBuilder K = a.K(a.q0(canonicalName3, a.q0(canonicalName2, a.q0(canonicalName, 26))), canonicalName, " or ", canonicalName2, " #009 Class mismatch: ");
            K.append(canonicalName3);
            zzbbd.zzfe(K.toString());
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zza(IObjectWrapper iObjectWrapper, zzvj zzvj, zzvc zzvc, String str, zzana zzana) throws RemoteException {
        zza(iObjectWrapper, zzvj, zzvc, str, null, zzana);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzb(IObjectWrapper iObjectWrapper, zzvc zzvc, String str, zzana zzana) throws RemoteException {
        if (this.zzdkn instanceof Adapter) {
            zzbbd.zzef("Requesting rewarded ad from adapter.");
            try {
                ((Adapter) this.zzdkn).loadRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zza(str, zzvc, (String) null), zzd(zzvc), zzc(zzvc), zzvc.zznb, zzvc.zzadj, zzvc.zzadk, zza(str, zzvc), ""), zza(zzana));
            } catch (Exception e) {
                zzbbd.zzc("", e);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zzdkn.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName2).length() + String.valueOf(canonicalName).length() + 22);
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbbd.zzfe(sb.toString());
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzc(IObjectWrapper iObjectWrapper, zzvc zzvc, String str, zzana zzana) throws RemoteException {
        if (this.zzdkn instanceof Adapter) {
            zzbbd.zzef("Requesting rewarded interstitial ad from adapter.");
            try {
                ((Adapter) this.zzdkn).loadRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zza(str, zzvc, (String) null), zzd(zzvc), zzc(zzvc), zzvc.zznb, zzvc.zzadj, zzvc.zzadk, zza(str, zzvc), ""), zza(zzana));
            } catch (Exception e) {
                zzbbd.zzc("", e);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zzdkn.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName2).length() + String.valueOf(canonicalName).length() + 22);
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbbd.zzfe(sb.toString());
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        Object obj = this.zzdkn;
        if (obj instanceof OnContextChangedListener) {
            ((OnContextChangedListener) obj).onContextChanged(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.zzdkn instanceof Adapter) {
            zzbbd.zzef("Show rewarded ad from adapter.");
            MediationRewardedAd mediationRewardedAd = this.zzdkr;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            } else {
                zzbbd.zzfc("Can not show null mediation rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zzdkn.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName2).length() + String.valueOf(canonicalName).length() + 22);
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbbd.zzfe(sb.toString());
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final IObjectWrapper zzto() throws RemoteException {
        Object obj = this.zzdkn;
        if (obj instanceof MediationBannerAdapter) {
            try {
                return ObjectWrapper.wrap(((MediationBannerAdapter) obj).getBannerView());
            } catch (Throwable th) {
                throw a.A1("", th);
            }
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdkn.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(a.q0(canonicalName2, a.q0(canonicalName, 22)));
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbbd.zzfe(sb.toString());
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final zzand zztp() {
        NativeAdMapper zzuc = this.zzdko.zzuc();
        if (zzuc instanceof NativeAppInstallAdMapper) {
            return new zzant((NativeAppInstallAdMapper) zzuc);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final zzani zztq() {
        NativeAdMapper zzuc = this.zzdko.zzuc();
        if (zzuc instanceof NativeContentAdMapper) {
            return new zzanw((NativeContentAdMapper) zzuc);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final Bundle zztr() {
        Object obj = this.zzdkn;
        if (obj instanceof zzbig) {
            return ((zzbig) obj).zztr();
        }
        String canonicalName = zzbig.class.getCanonicalName();
        String canonicalName2 = this.zzdkn.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName2).length() + String.valueOf(canonicalName).length() + 22);
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzbbd.zzfe(sb.toString());
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final Bundle zzts() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final boolean zztt() {
        return this.zzdkn instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final zzaes zztu() {
        NativeCustomTemplateAd zzue = this.zzdko.zzue();
        if (zzue instanceof zzaet) {
            return ((zzaet) zzue).zzsp();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final zzanj zztv() {
        UnifiedNativeAdMapper zzud = this.zzdko.zzud();
        if (zzud != null) {
            return new zzaol(zzud);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final zzapo zztw() {
        Object obj = this.zzdkn;
        if (!(obj instanceof Adapter)) {
            return null;
        }
        return zzapo.zza(((Adapter) obj).getVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final zzapo zztx() {
        Object obj = this.zzdkn;
        if (!(obj instanceof Adapter)) {
            return null;
        }
        return zzapo.zza(((Adapter) obj).getSDKVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zza(IObjectWrapper iObjectWrapper, zzvj zzvj, zzvc zzvc, String str, String str2, zzana zzana) throws RemoteException {
        Date date;
        AdSize zza;
        if (this.zzdkn instanceof MediationBannerAdapter) {
            zzbbd.zzef("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzdkn;
                Bundle bundle = null;
                HashSet hashSet = zzvc.zzcgx != null ? new HashSet(zzvc.zzcgx) : null;
                if (zzvc.zzcgv == -1) {
                    date = null;
                } else {
                    date = new Date(zzvc.zzcgv);
                }
                zzann zzann = new zzann(date, zzvc.zzcgw, hashSet, zzvc.zznb, zzc(zzvc), zzvc.zzadj, zzvc.zzchh, zzvc.zzadk, zza(str, zzvc));
                Bundle bundle2 = zzvc.zzchc;
                if (bundle2 != null) {
                    bundle = bundle2.getBundle(mediationBannerAdapter.getClass().getName());
                }
                if (zzvj.zzchu) {
                    zza = zzb.zza(zzvj.width, zzvj.height);
                } else {
                    zza = zzb.zza(zzvj.width, zzvj.height, zzvj.zzacx);
                }
                mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzanr(zzana), zza(str, zzvc, str2), zza, zzann, bundle);
            } catch (Throwable th) {
                throw a.A1("", th);
            }
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdkn.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(a.q0(canonicalName2, a.q0(canonicalName, 22)));
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbbd.zzfe(sb.toString());
            throw new RemoteException();
        }
    }

    public zzanq(@NonNull Adapter adapter) {
        this.zzdkn = adapter;
    }

    private static boolean zzc(zzvc zzvc) {
        if (zzvc.zzcgy) {
            return true;
        }
        zzwe.zzpq();
        return zzbat.zzym();
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zza(IObjectWrapper iObjectWrapper, zzvc zzvc, String str, zzana zzana) throws RemoteException {
        zza(iObjectWrapper, zzvc, str, (String) null, zzana);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zza(IObjectWrapper iObjectWrapper, zzvc zzvc, String str, String str2, zzana zzana) throws RemoteException {
        Date date;
        if (this.zzdkn instanceof MediationInterstitialAdapter) {
            zzbbd.zzef("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzdkn;
                Bundle bundle = null;
                HashSet hashSet = zzvc.zzcgx != null ? new HashSet(zzvc.zzcgx) : null;
                if (zzvc.zzcgv == -1) {
                    date = null;
                } else {
                    date = new Date(zzvc.zzcgv);
                }
                zzann zzann = new zzann(date, zzvc.zzcgw, hashSet, zzvc.zznb, zzc(zzvc), zzvc.zzadj, zzvc.zzchh, zzvc.zzadk, zza(str, zzvc));
                Bundle bundle2 = zzvc.zzchc;
                if (bundle2 != null) {
                    bundle = bundle2.getBundle(mediationInterstitialAdapter.getClass().getName());
                }
                mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzanr(zzana), zza(str, zzvc, str2), zzann, bundle);
            } catch (Throwable th) {
                throw a.A1("", th);
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdkn.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(a.q0(canonicalName2, a.q0(canonicalName, 22)));
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbbd.zzfe(sb.toString());
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zza(IObjectWrapper iObjectWrapper, zzvc zzvc, String str, String str2, zzana zzana, zzadm zzadm, List<String> list) throws RemoteException {
        Date date;
        Object obj = this.zzdkn;
        if (obj instanceof MediationNativeAdapter) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) obj;
                Bundle bundle = null;
                HashSet hashSet = zzvc.zzcgx != null ? new HashSet(zzvc.zzcgx) : null;
                if (zzvc.zzcgv == -1) {
                    date = null;
                } else {
                    date = new Date(zzvc.zzcgv);
                }
                zzanv zzanv = new zzanv(date, zzvc.zzcgw, hashSet, zzvc.zznb, zzc(zzvc), zzvc.zzadj, zzadm, list, zzvc.zzchh, zzvc.zzadk, zza(str, zzvc));
                Bundle bundle2 = zzvc.zzchc;
                if (bundle2 != null) {
                    bundle = bundle2.getBundle(mediationNativeAdapter.getClass().getName());
                }
                this.zzdko = new zzanr(zzana);
                mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.unwrap(iObjectWrapper), this.zzdko, zza(str, zzvc, str2), zzanv, bundle);
            } catch (Throwable th) {
                throw a.A1("", th);
            }
        } else {
            String canonicalName = MediationNativeAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdkn.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(a.q0(canonicalName2, a.q0(canonicalName, 22)));
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbbd.zzfe(sb.toString());
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zza(IObjectWrapper iObjectWrapper, zzvc zzvc, String str, zzaua zzaua, String str2) throws RemoteException {
        Bundle bundle;
        zzann zzann;
        Date date;
        Object obj = this.zzdkn;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbbd.zzef("Initialize rewarded video adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzdkn;
                Bundle bundle2 = null;
                Bundle zza = zza(str2, zzvc, (String) null);
                if (zzvc != null) {
                    HashSet hashSet = zzvc.zzcgx != null ? new HashSet(zzvc.zzcgx) : null;
                    if (zzvc.zzcgv == -1) {
                        date = null;
                    } else {
                        date = new Date(zzvc.zzcgv);
                    }
                    zzann zzann2 = new zzann(date, zzvc.zzcgw, hashSet, zzvc.zznb, zzc(zzvc), zzvc.zzadj, zzvc.zzchh, zzvc.zzadk, zza(str2, zzvc));
                    Bundle bundle3 = zzvc.zzchc;
                    if (bundle3 != null) {
                        bundle2 = bundle3.getBundle(mediationRewardedVideoAdAdapter.getClass().getName());
                    }
                    bundle = bundle2;
                    zzann = zzann2;
                } else {
                    zzann = null;
                    bundle = null;
                }
                mediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), zzann, str, new zzauf(zzaua), zza, bundle);
            } catch (Throwable th) {
                throw a.A1("", th);
            }
        } else if (obj instanceof Adapter) {
            this.zzdkq = iObjectWrapper;
            this.zzdkp = zzaua;
            zzaua.zzaf(ObjectWrapper.wrap(obj));
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdkn.getClass().getCanonicalName();
            StringBuilder K = a.K(a.q0(canonicalName3, a.q0(canonicalName2, a.q0(canonicalName, 26))), canonicalName, " or ", canonicalName2, " #009 Class mismatch: ");
            K.append(canonicalName3);
            zzbbd.zzfe(K.toString());
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zza(IObjectWrapper iObjectWrapper, zzaua zzaua, List<String> list) throws RemoteException {
        if (this.zzdkn instanceof InitializableMediationRewardedVideoAdAdapter) {
            zzbbd.zzef("Initialize rewarded video adapter.");
            try {
                InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.zzdkn;
                ArrayList arrayList = new ArrayList();
                for (String str : list) {
                    arrayList.add(zza(str, (zzvc) null, (String) null));
                }
                initializableMediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzauf(zzaua), arrayList);
            } catch (Throwable th) {
                zzbbd.zzd("Could not initialize rewarded video adapter.", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = InitializableMediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdkn.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName2).length() + String.valueOf(canonicalName).length() + 22);
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbbd.zzfe(sb.toString());
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zza(zzvc zzvc, String str) throws RemoteException {
        zza(zzvc, str, (String) null);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zza(zzvc zzvc, String str, String str2) throws RemoteException {
        Date date;
        Object obj = this.zzdkn;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbbd.zzef("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzdkn;
                Bundle bundle = null;
                HashSet hashSet = zzvc.zzcgx != null ? new HashSet(zzvc.zzcgx) : null;
                if (zzvc.zzcgv == -1) {
                    date = null;
                } else {
                    date = new Date(zzvc.zzcgv);
                }
                zzann zzann = new zzann(date, zzvc.zzcgw, hashSet, zzvc.zznb, zzc(zzvc), zzvc.zzadj, zzvc.zzchh, zzvc.zzadk, zza(str, zzvc));
                Bundle bundle2 = zzvc.zzchc;
                if (bundle2 != null) {
                    bundle = bundle2.getBundle(mediationRewardedVideoAdAdapter.getClass().getName());
                }
                mediationRewardedVideoAdAdapter.loadAd(zzann, zza(str, zzvc, str2), bundle);
            } catch (Throwable th) {
                throw a.A1("", th);
            }
        } else if (obj instanceof Adapter) {
            zzb(this.zzdkq, zzvc, str, new zzanu((Adapter) obj, this.zzdkp));
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdkn.getClass().getCanonicalName();
            StringBuilder K = a.K(a.q0(canonicalName3, a.q0(canonicalName2, a.q0(canonicalName, 26))), canonicalName, " or ", canonicalName2, " #009 Class mismatch: ");
            K.append(canonicalName3);
            zzbbd.zzfe(K.toString());
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zza(IObjectWrapper iObjectWrapper, zzaih zzaih, List<zzaip> list) throws RemoteException {
        AdFormat adFormat;
        if (this.zzdkn instanceof Adapter) {
            zzanp zzanp = new zzanp(this, zzaih);
            ArrayList arrayList = new ArrayList();
            for (zzaip zzaip : list) {
                String str = zzaip.zzdfi;
                str.hashCode();
                char c = 65535;
                switch (str.hashCode()) {
                    case -1396342996:
                        if (str.equals("banner")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1052618729:
                        if (str.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)) {
                            c = 1;
                            break;
                        }
                        break;
                    case -239580146:
                        if (str.equals("rewarded")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 604727084:
                        if (str.equals("interstitial")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        adFormat = AdFormat.BANNER;
                        break;
                    case 1:
                        adFormat = AdFormat.NATIVE;
                        break;
                    case 2:
                        adFormat = AdFormat.REWARDED;
                        break;
                    case 3:
                        adFormat = AdFormat.INTERSTITIAL;
                        break;
                    default:
                        throw new RemoteException();
                }
                arrayList.add(new MediationConfiguration(adFormat, zzaip.extras));
            }
            ((Adapter) this.zzdkn).initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), zzanp, arrayList);
            return;
        }
        throw new RemoteException();
    }

    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> zza(zzana zzana) {
        return new zzans(this, zzana);
    }

    private final Bundle zza(String str, zzvc zzvc, String str2) throws RemoteException {
        String valueOf = String.valueOf(str);
        zzbbd.zzef(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                bundle = bundle2;
            }
            if (this.zzdkn instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzvc != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzvc.zzadj);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
        } catch (Throwable th) {
            throw a.A1("", th);
        }
    }

    @Nullable
    private static String zza(String str, zzvc zzvc) {
        String str2 = zzvc.zzadl;
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return str2;
        }
    }
}
