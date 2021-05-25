package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;
public final class zzchc {
    private final zzbfy zzbpp;
    private final zzbbg zzdpq;
    private final zzeg zzenn;
    private final Executor zzfmk;
    private final zzb zzgbm;
    private final zzchh zzgck = new zzchh(null);
    private final zzahl zzgcl;
    private zzdvt<zzbfq> zzgcm;
    private final Context zzvr;

    public zzchc(zzchm zzchm) {
        this.zzvr = zzchm.zza(zzchm);
        this.zzfmk = zzchm.zzb(zzchm);
        this.zzenn = zzchm.zzc(zzchm);
        this.zzdpq = zzchm.zzd(zzchm);
        this.zzgbm = zzchm.zze(zzchm);
        this.zzbpp = zzchm.zzf(zzchm);
        this.zzgcl = new zzahl();
    }

    public final synchronized void destroy() {
        zzdvt<zzbfq> zzdvt = this.zzgcm;
        if (zzdvt != null) {
            zzdvl.zza(zzdvt, new zzchd(this), this.zzfmk);
            this.zzgcm = null;
        }
    }

    public final synchronized void zza(String str, zzahf<Object> zzahf) {
        zzdvt<zzbfq> zzdvt = this.zzgcm;
        if (zzdvt != null) {
            zzdvl.zza(zzdvt, new zzchg(this, str, zzahf), this.zzfmk);
        }
    }

    public final synchronized void zzang() {
        zzdvt<zzbfq> zzb = zzdvl.zzb(zzbfy.zza(this.zzvr, this.zzdpq, (String) zzwe.zzpu().zzd(zzaat.zzcrk), this.zzenn, this.zzgbm), new zzdsl(this) { // from class: com.google.android.gms.internal.ads.zzchb
            private final zzchc zzgcj;

            {
                this.zzgcj = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzdsl
            public final Object apply(Object obj) {
                return this.zzgcj.zzm((zzbfq) obj);
            }
        }, this.zzfmk);
        this.zzgcm = zzb;
        zzbbm.zza(zzb, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzb(String str, zzahf<Object> zzahf) {
        zzdvt<zzbfq> zzdvt = this.zzgcm;
        if (zzdvt != null) {
            zzdvl.zza(zzdvt, new zzchf(this, str, zzahf), this.zzfmk);
        }
    }

    public final synchronized zzdvt<JSONObject> zzc(String str, JSONObject jSONObject) {
        zzdvt<zzbfq> zzdvt = this.zzgcm;
        if (zzdvt == null) {
            return zzdvl.zzaf(null);
        }
        return zzdvl.zzb(zzdvt, new zzduv(this, str, jSONObject) { // from class: com.google.android.gms.internal.ads.zzche
            private final String zzdft;
            private final zzchc zzgcj;
            private final JSONObject zzgcn;

            {
                this.zzgcj = r1;
                this.zzdft = r2;
                this.zzgcn = r3;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzgcj.zza(this.zzdft, this.zzgcn, (zzbfq) obj);
            }
        }, this.zzfmk);
    }

    public final /* synthetic */ zzbfq zzm(zzbfq zzbfq) {
        zzbfq.zza("/result", this.zzgcl);
        zzbhc zzabe = zzbfq.zzabe();
        zzchh zzchh = this.zzgck;
        zzabe.zza(null, zzchh, zzchh, zzchh, zzchh, false, null, new zza(this.zzvr, null, null), null, null);
        return zzbfq;
    }

    public final synchronized void zza(String str, Map<String, ?> map) {
        zzdvt<zzbfq> zzdvt = this.zzgcm;
        if (zzdvt != null) {
            zzdvl.zza(zzdvt, new zzchi(this, str, map), this.zzfmk);
        }
    }

    public final <T> void zza(WeakReference<T> weakReference, String str, zzahf<T> zzahf) {
        zza(str, new zzchl(this, weakReference, str, zzahf, null));
    }

    public final /* synthetic */ zzdvt zza(String str, JSONObject jSONObject, zzbfq zzbfq) throws Exception {
        return this.zzgcl.zza(zzbfq, str, jSONObject);
    }
}
