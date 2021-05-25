package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import com.avito.android.remote.model.Navigation;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzcmi {
    private boolean enabled = true;
    private final Executor executor;
    private final zzbbg zzbop;
    private final Context zzcle;
    private final Executor zzfmk;
    private final ScheduledExecutorService zzfnh;
    private boolean zzggb = false;
    @GuardedBy("this")
    private boolean zzggc = false;
    private final long zzggd;
    private final zzbbq<Boolean> zzgge = new zzbbq<>();
    private final WeakReference<Context> zzggf;
    private final zzcji zzggg;
    private final zzcls zzggh;
    private Map<String, zzaif> zzggi = new ConcurrentHashMap();

    public zzcmi(Executor executor2, Context context, WeakReference<Context> weakReference, Executor executor3, zzcji zzcji, ScheduledExecutorService scheduledExecutorService, zzcls zzcls, zzbbg zzbbg) {
        this.zzggg = zzcji;
        this.zzcle = context;
        this.zzggf = weakReference;
        this.executor = executor3;
        this.zzfnh = scheduledExecutorService;
        this.zzfmk = executor2;
        this.zzggh = zzcls;
        this.zzbop = zzbbg;
        this.zzggd = zzp.zzkw().elapsedRealtime();
        zza("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    /* access modifiers changed from: private */
    public final void zza(String str, boolean z, String str2, int i) {
        this.zzggi.put(str, new zzaif(str, z, i, str2));
    }

    private final synchronized zzdvt<String> zzaoz() {
        String zzwp = zzp.zzkt().zzwj().zzxe().zzwp();
        if (!TextUtils.isEmpty(zzwp)) {
            return zzdvl.zzaf(zzwp);
        }
        zzbbq zzbbq = new zzbbq();
        zzp.zzkt().zzwj().zzb(new Runnable(this, zzbbq) { // from class: com.google.android.gms.internal.ads.zzcmj
            private final zzcmi zzgfz;
            private final zzbbq zzggj;

            {
                this.zzgfz = r1;
                this.zzggj = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgfz.zza(this.zzggj);
            }
        });
        return zzbbq;
    }

    /* access modifiers changed from: private */
    public final void zzgl(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject(Navigation.CONFIG);
            for (Iterator<String> keys = jSONObject.keys(); keys.hasNext(); keys = keys) {
                String next = keys.next();
                Object obj = new Object();
                zzbbq zzbbq = new zzbbq();
                zzdvt zza = zzdvl.zza(zzbbq, ((Long) zzwe.zzpu().zzd(zzaat.zzcqa)).longValue(), TimeUnit.SECONDS, this.zzfnh);
                this.zzggh.zzgj(next);
                long elapsedRealtime = zzp.zzkw().elapsedRealtime();
                zza.addListener(new Runnable(this, obj, zzbbq, next, elapsedRealtime) { // from class: com.google.android.gms.internal.ads.zzcml
                    private final Object zzdij;
                    private final String zzgef;
                    private final zzcmi zzgfz;
                    private final zzbbq zzggk;
                    private final long zzggl;

                    {
                        this.zzgfz = r1;
                        this.zzdij = r2;
                        this.zzggk = r3;
                        this.zzgef = r4;
                        this.zzggl = r5;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzgfz.zza(this.zzdij, this.zzggk, this.zzgef, this.zzggl);
                    }
                }, this.executor);
                arrayList.add(zza);
                zzcmr zzcmr = new zzcmr(this, obj, next, elapsedRealtime, zzbbq);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray("data");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("format", "");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                }
                            }
                            arrayList2.add(new zzaip(optString, bundle));
                        }
                    } catch (JSONException unused) {
                    }
                }
                zza(next, false, "", 0);
                try {
                    this.zzfmk.execute(new Runnable(this, this.zzggg.zzd(next, new JSONObject()), zzcmr, arrayList2, next) { // from class: com.google.android.gms.internal.ads.zzcmn
                        private final String zzeng;
                        private final zzcmi zzgfz;
                        private final zzdlx zzggm;
                        private final zzaih zzggn;
                        private final List zzggo;

                        {
                            this.zzgfz = r1;
                            this.zzggm = r2;
                            this.zzggn = r3;
                            this.zzggo = r4;
                            this.zzeng = r5;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzgfz.zza(this.zzggm, this.zzggn, this.zzggo, this.zzeng);
                        }
                    });
                } catch (zzdlr unused2) {
                    try {
                        zzcmr.onInitializationFailed("Failed to create Adapter.");
                    } catch (RemoteException e) {
                        zzbbd.zzc("", e);
                    }
                }
            }
            zzdvl.zzj(arrayList).zza(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzcmo
                private final zzcmi zzgfz;

                {
                    this.zzgfz = r1;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zzgfz.zzapa();
                }
            }, this.executor);
        } catch (JSONException e2) {
            zzaxy.zza("Malformed CLD response", e2);
        }
    }

    public final void disable() {
        this.enabled = false;
    }

    public final void zzaox() {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcpy)).booleanValue() && !zzacp.zzdaz.get().booleanValue()) {
            if (this.zzbop.zzedr >= ((Integer) zzwe.zzpu().zzd(zzaat.zzcpz)).intValue() && this.enabled) {
                if (!this.zzggb) {
                    synchronized (this) {
                        if (!this.zzggb) {
                            this.zzggh.zzaou();
                            this.zzgge.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcmk
                                private final zzcmi zzgfz;

                                {
                                    this.zzgfz = r1;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.zzgfz.zzapc();
                                }
                            }, this.executor);
                            this.zzggb = true;
                            zzdvt<String> zzaoz = zzaoz();
                            this.zzfnh.schedule(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcmm
                                private final zzcmi zzgfz;

                                {
                                    this.zzgfz = r1;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.zzgfz.zzapb();
                                }
                            }, ((Long) zzwe.zzpu().zzd(zzaat.zzcqb)).longValue(), TimeUnit.SECONDS);
                            zzdvl.zza(zzaoz, new zzcmp(this), this.executor);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        if (!this.zzggb) {
            zza("com.google.android.gms.ads.MobileAds", true, "", 0);
            this.zzgge.set(Boolean.FALSE);
            this.zzggb = true;
        }
    }

    public final List<zzaif> zzaoy() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzggi.keySet()) {
            zzaif zzaif = this.zzggi.get(str);
            arrayList.add(new zzaif(str, zzaif.zzdff, zzaif.zzdfg, zzaif.description));
        }
        return arrayList;
    }

    public final /* synthetic */ Object zzapa() throws Exception {
        this.zzgge.set(Boolean.TRUE);
        return null;
    }

    public final /* synthetic */ void zzapb() {
        synchronized (this) {
            if (!this.zzggc) {
                zza("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (zzp.zzkw().elapsedRealtime() - this.zzggd));
                this.zzgge.setException(new Exception());
            }
        }
    }

    public final /* synthetic */ void zzapc() {
        this.zzggh.zzaov();
    }

    public final void zzb(zzaim zzaim) {
        this.zzgge.addListener(new Runnable(this, zzaim) { // from class: com.google.android.gms.internal.ads.zzcmh
            private final zzcmi zzgfz;
            private final zzaim zzgga;

            {
                this.zzgfz = r1;
                this.zzgga = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgfz.zzc(this.zzgga);
            }
        }, this.zzfmk);
    }

    public final /* synthetic */ void zzc(zzaim zzaim) {
        try {
            zzaim.zze(zzaoy());
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
        }
    }

    public final /* synthetic */ void zza(zzdlx zzdlx, zzaih zzaih, List list, String str) {
        try {
            Context context = this.zzggf.get();
            if (context == null) {
                context = this.zzcle;
            }
            zzdlx.zza(context, zzaih, list);
        } catch (zzdlr unused) {
            try {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 74);
                sb.append("Failed to initialize adapter. ");
                sb.append(str);
                sb.append(" does not implement the initialize() method.");
                zzaih.onInitializationFailed(sb.toString());
            } catch (RemoteException e) {
                zzbbd.zzc("", e);
            }
        }
    }

    public final /* synthetic */ void zza(Object obj, zzbbq zzbbq, String str, long j) {
        synchronized (obj) {
            if (!zzbbq.isDone()) {
                zza(str, false, "Timeout.", (int) (zzp.zzkw().elapsedRealtime() - j));
                this.zzggh.zzr(str, "timeout");
                zzbbq.set(Boolean.FALSE);
            }
        }
    }

    public final /* synthetic */ void zza(zzbbq zzbbq) {
        this.executor.execute(new Runnable(this, zzbbq) { // from class: com.google.android.gms.internal.ads.zzcmq
            private final zzcmi zzgfz;
            private final zzbbq zzggj;

            {
                this.zzgfz = r1;
                this.zzggj = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbbq zzbbq2 = this.zzggj;
                String zzwp = zzp.zzkt().zzwj().zzxe().zzwp();
                if (!TextUtils.isEmpty(zzwp)) {
                    zzbbq2.set(zzwp);
                } else {
                    zzbbq2.setException(new Exception());
                }
            }
        });
    }
}
