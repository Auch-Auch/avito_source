package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzp;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONObject;
public final class zzcpj extends zzasf {
    private final Executor zzfmk;
    private final zzatc zzgiy;
    private final zzatd zzgiz;
    private final zzble zzgja;
    private final HashMap<String, zzcpy> zzgjb;
    private final Context zzvr;

    public zzcpj(Context context, Executor executor, zzatc zzatc, zzble zzble, zzatd zzatd, HashMap<String, zzcpy> hashMap) {
        zzaat.initialize(context);
        this.zzvr = context;
        this.zzfmk = executor;
        this.zzgiy = zzatc;
        this.zzgiz = zzatd;
        this.zzgja = zzble;
        this.zzgjb = hashMap;
    }

    private static zzdvt<JSONObject> zza(zzasp zzasp, zzdpf zzdpf, zzdff zzdff) {
        zzcpn zzcpn = new zzduv(zzdff) { // from class: com.google.android.gms.internal.ads.zzcpn
            private final zzdff zzgjc;

            {
                this.zzgjc = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzgjc.zzafg().zzt(zzp.zzkp().zzd((Bundle) obj));
            }
        };
        return zzdpf.zza((zzdpf) zzdpg.GMS_SIGNALS, zzdvl.zzaf(zzasp.zzdtd)).zza(zzcpn).zzb(zzcpq.zzghg).zzauz();
    }

    @Override // com.google.android.gms.internal.ads.zzasc
    public final zzary zza(zzarw zzarw) throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzasc
    public final void zza(zzarw zzarw, zzash zzash) throws RemoteException {
    }

    public final /* synthetic */ void zzapm() {
        zzbbm.zza(this.zzgiz.zzvl(), "persistFlags");
    }

    public final zzdvt<InputStream> zzb(zzasp zzasp, int i) {
        zzalu zza = zzp.zzlc().zza(this.zzvr, zzbbg.zzyr());
        zzdff zza2 = this.zzgja.zza(zzasp, i);
        zzalm zza3 = zza.zza("google.afma.response.normalize", zzcpx.zzgjj, zzalp.zzdht);
        zzcqc zzcqc = new zzcqc(this.zzvr, zzasp.zzdpq.zzbra, this.zzgiy, zzasp.zzdqr, i);
        zzdpf zzafi = zza2.zzafi();
        zzcpy zzcpy = null;
        if (!zzacs.zzdbg.get().booleanValue()) {
            String str = zzasp.zzdth;
            if (str != null && !str.isEmpty()) {
                zzaxy.zzei("Request contained a PoolKey but split request is disabled.");
            }
        } else {
            String str2 = zzasp.zzdth;
            if (str2 != null && !str2.isEmpty() && (zzcpy = this.zzgjb.remove(zzasp.zzdth)) == null) {
                zzaxy.zzei("Request contained a PoolKey but no matching parameters were found.");
            }
        }
        if (zzcpy == null) {
            zzdvt<JSONObject> zza4 = zza(zzasp, zzafi, zza2);
            zzdvt<zzasv> zza5 = zza(zza4, zzafi, zza);
            zzdos zzauz = zzafi.zza((zzdpf) zzdpg.HTTP, zza5, zza4).zzb(new Callable(zza4, zza5) { // from class: com.google.android.gms.internal.ads.zzcpm
                private final zzdvt zzfsi;
                private final zzdvt zzgbt;

                {
                    this.zzgbt = r1;
                    this.zzfsi = r2;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new zzcqb((JSONObject) this.zzgbt.get(), (zzasv) this.zzfsi.get());
                }
            }).zzb(zzcqc).zzauz();
            return zzafi.zza((zzdpf) zzdpg.PRE_PROCESS, zza4, zza5, zzauz).zzb(new Callable(zzauz, zza4, zza5) { // from class: com.google.android.gms.internal.ads.zzcpl
                private final zzdvt zzfqe;
                private final zzdvt zzfsi;
                private final zzdvt zzgbt;

                {
                    this.zzgbt = r1;
                    this.zzfsi = r2;
                    this.zzfqe = r3;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new zzcpx((zzcqe) this.zzgbt.get(), (JSONObject) this.zzfsi.get(), (zzasv) this.zzfqe.get());
                }
            }).zza(zza3).zzauz();
        }
        zzdos zzauz2 = zzafi.zza((zzdpf) zzdpg.HTTP, zzdvl.zzaf(new zzcqb(zzcpy.zzgjh, zzcpy.zzgji))).zzb(zzcqc).zzauz();
        zzdvt<?> zzaf = zzdvl.zzaf(zzcpy);
        return zzafi.zza((zzdpf) zzdpg.PRE_PROCESS, zzauz2, zzaf).zzb(new Callable(zzauz2, zzaf) { // from class: com.google.android.gms.internal.ads.zzcpo
            private final zzdvt zzfsi;
            private final zzdvt zzgbt;

            {
                this.zzgbt = r1;
                this.zzfsi = r2;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdvt zzdvt = this.zzgbt;
                zzdvt zzdvt2 = this.zzfsi;
                return new zzcpx((zzcqe) zzdvt.get(), ((zzcpy) zzdvt2.get()).zzgjh, ((zzcpy) zzdvt2.get()).zzgji);
            }
        }).zza(zza3).zzauz();
    }

    public final zzdvt<InputStream> zzc(zzasp zzasp, int i) {
        if (!zzacs.zzdbg.get().booleanValue()) {
            return zzdvl.immediateFailedFuture(new Exception("Split request is disabled."));
        }
        zzdnd zzdnd = zzasp.zzdtg;
        if (zzdnd == null) {
            return zzdvl.immediateFailedFuture(new Exception("Pool configuration missing from request."));
        }
        if (zzdnd.zzhej == 0 || zzdnd.zzhek == 0) {
            return zzdvl.immediateFailedFuture(new Exception("Caching is disabled."));
        }
        zzalu zza = zzp.zzlc().zza(this.zzvr, zzbbg.zzyr());
        zzdff zza2 = this.zzgja.zza(zzasp, i);
        zzdpf zzafi = zza2.zzafi();
        zzdvt<JSONObject> zza3 = zza(zzasp, zzafi, zza2);
        zzdvt<zzasv> zza4 = zza(zza3, zzafi, zza);
        return zzafi.zza((zzdpf) zzdpg.GET_URL_AND_CACHE_KEY, zza3, zza4).zzb(new Callable(this, zza4, zza3) { // from class: com.google.android.gms.internal.ads.zzcpr
            private final zzdvt zzfqe;
            private final zzdvt zzfsi;
            private final zzcpj zzgjd;

            {
                this.zzgjd = r1;
                this.zzfsi = r2;
                this.zzfqe = r3;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgjd.zza(this.zzfsi, this.zzfqe);
            }
        }).zzauz();
    }

    public final zzdvt<InputStream> zzd(zzasp zzasp, int i) {
        zzalu zza = zzp.zzlc().zza(this.zzvr, zzbbg.zzyr());
        if (!zzacy.zzdbx.get().booleanValue()) {
            return zzdvl.immediateFailedFuture(new Exception("Signal collection disabled."));
        }
        zzdff zza2 = this.zzgja.zza(zzasp, i);
        zzdem<JSONObject> zzafh = zza2.zzafh();
        return zza2.zzafi().zza((zzdpf) zzdpg.GET_SIGNALS, zzdvl.zzaf(zzasp.zzdtd)).zza(new zzduv(zzafh) { // from class: com.google.android.gms.internal.ads.zzcpu
            private final zzdem zzgje;

            {
                this.zzgje = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzgje.zzt(zzp.zzkp().zzd((Bundle) obj));
            }
        }).zzw(zzdpg.JS_SIGNALS).zza(zza.zza("google.afma.request.getSignals", zzalp.zzdhs, zzalp.zzdht)).zzauz();
    }

    public final zzdvt<InputStream> zzgn(String str) {
        if (!zzacs.zzdbg.get().booleanValue()) {
            return zzdvl.immediateFailedFuture(new Exception("Split request is disabled."));
        }
        zzcpw zzcpw = new zzcpw(this);
        if (this.zzgjb.remove(str) != null) {
            return zzdvl.zzaf(zzcpw);
        }
        String valueOf = String.valueOf(str);
        return zzdvl.immediateFailedFuture(new Exception(valueOf.length() != 0 ? "URL to be removed not found for cache key: ".concat(valueOf) : new String("URL to be removed not found for cache key: ")));
    }

    private static zzdvt<zzasv> zza(zzdvt<JSONObject> zzdvt, zzdpf zzdpf, zzalu zzalu) {
        return zzdpf.zza((zzdpf) zzdpg.BUILD_URL, (zzdvt) zzdvt).zza(zzalu.zza("AFMA_getAdDictionary", zzalp.zzdhs, zzcpp.zzdhu)).zzauz();
    }

    @Override // com.google.android.gms.internal.ads.zzasc
    public final void zza(zzasp zzasp, zzasj zzasj) {
        zzdvt<InputStream> zzb = zzb(zzasp, Binder.getCallingUid());
        zza(zzb, zzasj);
        zzb.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcps
            private final zzcpj zzgjd;

            {
                this.zzgjd = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgjd.zzapm();
            }
        }, this.zzfmk);
    }

    @Override // com.google.android.gms.internal.ads.zzasc
    public final void zza(String str, zzasj zzasj) {
        zza(zzgn(str), zzasj);
    }

    @Override // com.google.android.gms.internal.ads.zzasc
    public final void zzc(zzasp zzasp, zzasj zzasj) {
        zza(zzc(zzasp, Binder.getCallingUid()), zzasj);
    }

    private final void zza(zzdvt<InputStream> zzdvt, zzasj zzasj) {
        zzdvl.zza(zzdvl.zzb(zzdvt, new zzduv(this) { // from class: com.google.android.gms.internal.ads.zzcpt
            private final zzcpj zzgjd;

            {
                this.zzgjd = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return zzdvl.zzaf(zzdlz.zzf((InputStream) obj));
            }
        }, zzbbi.zzedu), new zzcpv(this, zzasj), zzbbi.zzedz);
    }

    public final /* synthetic */ InputStream zza(zzdvt zzdvt, zzdvt zzdvt2) throws Exception {
        String zzvj = ((zzasv) zzdvt.get()).zzvj();
        this.zzgjb.put(zzvj, new zzcpy((zzasv) zzdvt.get(), (JSONObject) zzdvt2.get()));
        return new ByteArrayInputStream(zzvj.getBytes(zzdsj.UTF_8));
    }

    @Override // com.google.android.gms.internal.ads.zzasc
    public final void zzb(zzasp zzasp, zzasj zzasj) {
        zza(zzd(zzasp, Binder.getCallingUid()), zzasj);
    }
}
