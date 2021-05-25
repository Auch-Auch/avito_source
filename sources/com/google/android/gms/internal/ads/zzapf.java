package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzapf extends zzaoz {
    private MediationRewardedAd zzdkr;
    private final RtbAdapter zzdll;
    private MediationInterstitialAd zzdlm;
    private String zzdln = "";

    public zzapf(RtbAdapter rtbAdapter) {
        this.zzdll = rtbAdapter;
    }

    private static boolean zzc(zzvc zzvc) {
        if (zzvc.zzcgy) {
            return true;
        }
        zzwe.zzpq();
        return zzbat.zzym();
    }

    private final Bundle zzd(zzvc zzvc) {
        Bundle bundle;
        Bundle bundle2 = zzvc.zzchc;
        if (bundle2 == null || (bundle = bundle2.getBundle(this.zzdll.getClass().getName())) == null) {
            return new Bundle();
        }
        return bundle;
    }

    private static Bundle zzdt(String str) throws RemoteException {
        String valueOf = String.valueOf(str);
        zzbbd.zzfe(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e) {
            zzbbd.zzc("", e);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapa
    public final zzyg getVideoController() {
        RtbAdapter rtbAdapter = this.zzdll;
        if (!(rtbAdapter instanceof zza)) {
            return null;
        }
        try {
            return ((zza) rtbAdapter).getVideoController();
        } catch (Throwable th) {
            zzbbd.zzc("", th);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapa
    public final void zza(String str, String str2, zzvc zzvc, IObjectWrapper iObjectWrapper, zzaoo zzaoo, zzana zzana, zzvj zzvj) throws RemoteException {
        try {
            this.zzdll.loadBannerAd(new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdt(str2), zzd(zzvc), zzc(zzvc), zzvc.zznb, zzvc.zzadj, zzvc.zzadk, zza(str2, zzvc), zzb.zza(zzvj.width, zzvj.height, zzvj.zzacx), this.zzdln), new zzapi(this, zzaoo, zzana));
        } catch (Throwable th) {
            throw a.A1("Adapter failed to render banner ad.", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapa
    public final void zza(String[] strArr, Bundle[] bundleArr) {
    }

    @Override // com.google.android.gms.internal.ads.zzapa
    public final boolean zzaa(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationRewardedAd mediationRewardedAd = this.zzdkr;
        if (mediationRewardedAd == null) {
            return false;
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzbbd.zzc("", th);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapa
    public final void zzb(String str, String str2, zzvc zzvc, IObjectWrapper iObjectWrapper, zzaov zzaov, zzana zzana) throws RemoteException {
        try {
            this.zzdll.loadRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdt(str2), zzd(zzvc), zzc(zzvc), zzvc.zznb, zzvc.zzadj, zzvc.zzadk, zza(str2, zzvc), this.zzdln), zza(zzaov, zzana));
        } catch (Throwable th) {
            throw a.A1("Adapter failed to render rewarded interstitial ad.", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapa
    public final void zzdr(String str) {
        this.zzdln = str;
    }

    @Override // com.google.android.gms.internal.ads.zzapa
    public final zzapo zztw() throws RemoteException {
        return zzapo.zza(this.zzdll.getVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzapa
    public final zzapo zztx() throws RemoteException {
        return zzapo.zza(this.zzdll.getSDKVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzapa
    public final void zzy(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzapa
    public final boolean zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationInterstitialAd mediationInterstitialAd = this.zzdlm;
        if (mediationInterstitialAd == null) {
            return false;
        }
        try {
            mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzbbd.zzc("", th);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapa
    public final void zza(String str, String str2, zzvc zzvc, IObjectWrapper iObjectWrapper, zzaop zzaop, zzana zzana) throws RemoteException {
        try {
            this.zzdll.loadInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdt(str2), zzd(zzvc), zzc(zzvc), zzvc.zznb, zzvc.zzadj, zzvc.zzadk, zza(str2, zzvc), this.zzdln), new zzaph(this, zzaop, zzana));
        } catch (Throwable th) {
            throw a.A1("Adapter failed to render interstitial ad.", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapa
    public final void zza(String str, String str2, zzvc zzvc, IObjectWrapper iObjectWrapper, zzaov zzaov, zzana zzana) throws RemoteException {
        try {
            this.zzdll.loadRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdt(str2), zzd(zzvc), zzc(zzvc), zzvc.zznb, zzvc.zzadj, zzvc.zzadk, zza(str2, zzvc), this.zzdln), zza(zzaov, zzana));
        } catch (Throwable th) {
            throw a.A1("Adapter failed to render rewarded ad.", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapa
    public final void zza(String str, String str2, zzvc zzvc, IObjectWrapper iObjectWrapper, zzaou zzaou, zzana zzana) throws RemoteException {
        try {
            this.zzdll.loadNativeAd(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdt(str2), zzd(zzvc), zzc(zzvc), zzvc.zznb, zzvc.zzadj, zzvc.zzadk, zza(str2, zzvc), this.zzdln), new zzapk(this, zzaou, zzana));
        } catch (Throwable th) {
            throw a.A1("Adapter failed to render rewarded ad.", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapa
    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzvj zzvj, zzapb zzapb) throws RemoteException {
        AdFormat adFormat;
        try {
            zzapj zzapj = new zzapj(this, zzapb);
            RtbAdapter rtbAdapter = this.zzdll;
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
                        c = 3;
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
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                adFormat = AdFormat.BANNER;
            } else if (c == 1) {
                adFormat = AdFormat.INTERSTITIAL;
            } else if (c == 2) {
                adFormat = AdFormat.REWARDED;
            } else if (c == 3) {
                adFormat = AdFormat.NATIVE;
            } else {
                throw new IllegalArgumentException("Internal Error");
            }
            MediationConfiguration mediationConfiguration = new MediationConfiguration(adFormat, bundle2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(mediationConfiguration);
            rtbAdapter.collectSignals(new RtbSignalData((Context) ObjectWrapper.unwrap(iObjectWrapper), arrayList, bundle, zzb.zza(zzvj.width, zzvj.height, zzvj.zzacx)), zzapj);
        } catch (Throwable th) {
            throw a.A1("Error generating signals for RTB", th);
        }
    }

    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> zza(zzaov zzaov, zzana zzana) {
        return new zzapm(this, zzaov, zzana);
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
