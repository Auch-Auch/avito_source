package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;
public final class zzccv {
    private Bundle extras;
    private zzado zzdcu;
    private List<zzzc> zzddi = Collections.emptyList();
    private List<?> zzeqk;
    private double zzeqp;
    private float zzera;
    @Nullable
    private IObjectWrapper zzfpg;
    private int zzfxr;
    private zzyg zzfxs;
    private View zzfxt;
    private zzzc zzfxu;
    private zzbfq zzfxv;
    @Nullable
    private zzbfq zzfxw;
    private View zzfxx;
    private IObjectWrapper zzfxy;
    private zzadw zzfxz;
    private zzadw zzfya;
    private String zzfyb;
    private SimpleArrayMap<String, zzadi> zzfyc = new SimpleArrayMap<>();
    private SimpleArrayMap<String, String> zzfyd = new SimpleArrayMap<>();
    @Nullable
    private String zzfye;

    private final synchronized void setMediaContentAspectRatio(float f) {
        this.zzera = f;
    }

    private static <T> T zzat(@Nullable IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return (T) ObjectWrapper.unwrap(iObjectWrapper);
    }

    private final synchronized String zzgc(String str) {
        return this.zzfyd.get(str);
    }

    public final synchronized void destroy() {
        zzbfq zzbfq = this.zzfxv;
        if (zzbfq != null) {
            zzbfq.destroy();
            this.zzfxv = null;
        }
        zzbfq zzbfq2 = this.zzfxw;
        if (zzbfq2 != null) {
            zzbfq2.destroy();
            this.zzfxw = null;
        }
        this.zzfpg = null;
        this.zzfyc.clear();
        this.zzfyd.clear();
        this.zzfxs = null;
        this.zzdcu = null;
        this.zzfxt = null;
        this.zzeqk = null;
        this.extras = null;
        this.zzfxx = null;
        this.zzfxy = null;
        this.zzfxz = null;
        this.zzfya = null;
        this.zzfyb = null;
    }

    public final synchronized String getAdvertiser() {
        return zzgc("advertiser");
    }

    public final synchronized String getBody() {
        return zzgc(SDKConstants.PARAM_A2U_BODY);
    }

    public final synchronized String getCallToAction() {
        return zzgc("call_to_action");
    }

    public final synchronized String getCustomTemplateId() {
        return this.zzfyb;
    }

    public final synchronized Bundle getExtras() {
        if (this.extras == null) {
            this.extras = new Bundle();
        }
        return this.extras;
    }

    public final synchronized String getHeadline() {
        return zzgc("headline");
    }

    public final synchronized List<?> getImages() {
        return this.zzeqk;
    }

    public final synchronized float getMediaContentAspectRatio() {
        return this.zzera;
    }

    public final synchronized List<zzzc> getMuteThisAdReasons() {
        return this.zzddi;
    }

    public final synchronized String getPrice() {
        return zzgc("price");
    }

    public final synchronized double getStarRating() {
        return this.zzeqp;
    }

    public final synchronized String getStore() {
        return zzgc("store");
    }

    public final synchronized zzyg getVideoController() {
        return this.zzfxs;
    }

    public final synchronized void setImages(List<zzadi> list) {
        this.zzeqk = list;
    }

    public final synchronized void setStarRating(double d) {
        this.zzeqp = d;
    }

    public final synchronized void zza(zzado zzado) {
        this.zzdcu = zzado;
    }

    public final synchronized void zzac(View view) {
        this.zzfxx = view;
    }

    public final synchronized int zzaln() {
        return this.zzfxr;
    }

    public final synchronized View zzalo() {
        return this.zzfxt;
    }

    @Nullable
    public final zzadw zzalp() {
        List<?> list = this.zzeqk;
        if (!(list == null || list.size() == 0)) {
            Object obj = this.zzeqk.get(0);
            if (obj instanceof IBinder) {
                return zzadv.zzo((IBinder) obj);
            }
        }
        return null;
    }

    @Nullable
    public final synchronized zzzc zzalq() {
        return this.zzfxu;
    }

    public final synchronized View zzalr() {
        return this.zzfxx;
    }

    public final synchronized zzbfq zzals() {
        return this.zzfxv;
    }

    @Nullable
    public final synchronized zzbfq zzalt() {
        return this.zzfxw;
    }

    @Nullable
    public final synchronized IObjectWrapper zzalu() {
        return this.zzfpg;
    }

    public final synchronized SimpleArrayMap<String, zzadi> zzalv() {
        return this.zzfyc;
    }

    @Nullable
    public final synchronized String zzalw() {
        return this.zzfye;
    }

    public final synchronized SimpleArrayMap<String, String> zzalx() {
        return this.zzfyd;
    }

    public final synchronized void zzas(IObjectWrapper iObjectWrapper) {
        this.zzfpg = iObjectWrapper;
    }

    public final synchronized void zzb(zzyg zzyg) {
        this.zzfxs = zzyg;
    }

    public final synchronized void zzdy(int i) {
        this.zzfxr = i;
    }

    public final synchronized void zzga(String str) {
        this.zzfyb = str;
    }

    public final synchronized void zzgb(@Nullable String str) {
        this.zzfye = str;
    }

    public final synchronized void zzh(List<zzzc> list) {
        this.zzddi = list;
    }

    public final synchronized void zzi(zzbfq zzbfq) {
        this.zzfxv = zzbfq;
    }

    public final synchronized void zzj(zzbfq zzbfq) {
        this.zzfxw = zzbfq;
    }

    public final synchronized void zzn(String str, String str2) {
        if (str2 == null) {
            this.zzfyd.remove(str);
        } else {
            this.zzfyd.put(str, str2);
        }
    }

    public final synchronized zzadw zzsh() {
        return this.zzfxz;
    }

    public final synchronized zzado zzsi() {
        return this.zzdcu;
    }

    public final synchronized IObjectWrapper zzsj() {
        return this.zzfxy;
    }

    public final synchronized zzadw zzsk() {
        return this.zzfya;
    }

    public final synchronized void zza(@Nullable zzzc zzzc) {
        this.zzfxu = zzzc;
    }

    public final synchronized void zzb(zzadw zzadw) {
        this.zzfya = zzadw;
    }

    public static zzccv zzb(zzanj zzanj) {
        try {
            return zza(zza(zzanj.getVideoController(), zzanj), zzanj.zzsi(), (View) zzat(zzanj.zzua()), zzanj.getHeadline(), zzanj.getImages(), zzanj.getBody(), zzanj.getExtras(), zzanj.getCallToAction(), (View) zzat(zzanj.zzub()), zzanj.zzsj(), zzanj.getStore(), zzanj.getPrice(), zzanj.getStarRating(), zzanj.zzsh(), zzanj.getAdvertiser(), zzanj.getMediaContentAspectRatio());
        } catch (RemoteException e) {
            zzbbd.zzd("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    public final synchronized void zza(zzadw zzadw) {
        this.zzfxz = zzadw;
    }

    public final synchronized void zza(String str, zzadi zzadi) {
        if (zzadi == null) {
            this.zzfyc.remove(str);
        } else {
            this.zzfyc.put(str, zzadi);
        }
    }

    public static zzccv zza(zzani zzani) {
        try {
            zzccw zza = zza(zzani.getVideoController(), (zzanj) null);
            zzado zzsi = zzani.zzsi();
            String headline = zzani.getHeadline();
            List<?> images = zzani.getImages();
            String body = zzani.getBody();
            Bundle extras2 = zzani.getExtras();
            String callToAction = zzani.getCallToAction();
            IObjectWrapper zzsj = zzani.zzsj();
            String advertiser = zzani.getAdvertiser();
            zzadw zzsk = zzani.zzsk();
            zzccv zzccv = new zzccv();
            zzccv.zzfxr = 1;
            zzccv.zzfxs = zza;
            zzccv.zzdcu = zzsi;
            zzccv.zzfxt = (View) zzat(zzani.zzua());
            zzccv.zzn("headline", headline);
            zzccv.zzeqk = images;
            zzccv.zzn(SDKConstants.PARAM_A2U_BODY, body);
            zzccv.extras = extras2;
            zzccv.zzn("call_to_action", callToAction);
            zzccv.zzfxx = (View) zzat(zzani.zzub());
            zzccv.zzfxy = zzsj;
            zzccv.zzn("advertiser", advertiser);
            zzccv.zzfya = zzsk;
            return zzccv;
        } catch (RemoteException e) {
            zzbbd.zzd("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    public static zzccv zzb(zzand zzand) {
        try {
            return zza(zza(zzand.getVideoController(), (zzanj) null), zzand.zzsi(), (View) zzat(zzand.zzua()), zzand.getHeadline(), zzand.getImages(), zzand.getBody(), zzand.getExtras(), zzand.getCallToAction(), (View) zzat(zzand.zzub()), zzand.zzsj(), zzand.getStore(), zzand.getPrice(), zzand.getStarRating(), zzand.zzsh(), null, 0.0f);
        } catch (RemoteException e) {
            zzbbd.zzd("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzccv zza(zzand zzand) {
        try {
            zzccw zza = zza(zzand.getVideoController(), (zzanj) null);
            zzado zzsi = zzand.zzsi();
            String headline = zzand.getHeadline();
            List<?> images = zzand.getImages();
            String body = zzand.getBody();
            Bundle extras2 = zzand.getExtras();
            String callToAction = zzand.getCallToAction();
            IObjectWrapper zzsj = zzand.zzsj();
            String store = zzand.getStore();
            String price = zzand.getPrice();
            double starRating = zzand.getStarRating();
            zzadw zzsh = zzand.zzsh();
            zzccv zzccv = new zzccv();
            zzccv.zzfxr = 2;
            zzccv.zzfxs = zza;
            zzccv.zzdcu = zzsi;
            zzccv.zzfxt = (View) zzat(zzand.zzua());
            zzccv.zzn("headline", headline);
            zzccv.zzeqk = images;
            zzccv.zzn(SDKConstants.PARAM_A2U_BODY, body);
            zzccv.extras = extras2;
            zzccv.zzn("call_to_action", callToAction);
            zzccv.zzfxx = (View) zzat(zzand.zzub());
            zzccv.zzfxy = zzsj;
            zzccv.zzn("store", store);
            zzccv.zzn("price", price);
            zzccv.zzeqp = starRating;
            zzccv.zzfxz = zzsh;
            return zzccv;
        } catch (RemoteException e) {
            zzbbd.zzd("Failed to get native ad from app install ad mapper", e);
            return null;
        }
    }

    public static zzccv zzb(zzani zzani) {
        try {
            return zza(zza(zzani.getVideoController(), (zzanj) null), zzani.zzsi(), (View) zzat(zzani.zzua()), zzani.getHeadline(), zzani.getImages(), zzani.getBody(), zzani.getExtras(), zzani.getCallToAction(), (View) zzat(zzani.zzub()), zzani.zzsj(), null, null, -1.0d, zzani.zzsk(), zzani.getAdvertiser(), 0.0f);
        } catch (RemoteException e) {
            zzbbd.zzd("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    private static zzccv zza(zzyg zzyg, zzado zzado, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzadw zzadw, String str6, float f) {
        zzccv zzccv = new zzccv();
        zzccv.zzfxr = 6;
        zzccv.zzfxs = zzyg;
        zzccv.zzdcu = zzado;
        zzccv.zzfxt = view;
        zzccv.zzn("headline", str);
        zzccv.zzeqk = list;
        zzccv.zzn(SDKConstants.PARAM_A2U_BODY, str2);
        zzccv.extras = bundle;
        zzccv.zzn("call_to_action", str3);
        zzccv.zzfxx = view2;
        zzccv.zzfxy = iObjectWrapper;
        zzccv.zzn("store", str4);
        zzccv.zzn("price", str5);
        zzccv.zzeqp = d;
        zzccv.zzfxz = zzadw;
        zzccv.zzn("advertiser", str6);
        zzccv.setMediaContentAspectRatio(f);
        return zzccv;
    }

    private static zzccw zza(zzyg zzyg, @Nullable zzanj zzanj) {
        if (zzyg == null) {
            return null;
        }
        return new zzccw(zzyg, zzanj);
    }
}
