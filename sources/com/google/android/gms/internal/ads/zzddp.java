package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
public final class zzddp implements zzden<zzddm> {
    private final ScheduledExecutorService zzflf;
    private final zzdln zzfqn;
    private final zzdvw zzgay;
    private final zzcws zzgoe;
    private String zzgrv;
    private final zzcwu zzgum;
    private final Context zzvr;

    public zzddp(zzdvw zzdvw, ScheduledExecutorService scheduledExecutorService, String str, zzcwu zzcwu, Context context, zzdln zzdln, zzcws zzcws) {
        this.zzgay = zzdvw;
        this.zzflf = scheduledExecutorService;
        this.zzgrv = str;
        this.zzgum = zzcwu;
        this.zzvr = context;
        this.zzfqn = zzdln;
        this.zzgoe = zzcws;
    }

    public final /* synthetic */ zzdvt zza(String str, List list, Bundle bundle) throws Exception {
        zzbbq zzbbq = new zzbbq();
        this.zzgoe.zzgo(str);
        zzapa zzgp = this.zzgoe.zzgp(str);
        Objects.requireNonNull(zzgp);
        zzgp.zza(ObjectWrapper.wrap(this.zzvr), this.zzgrv, bundle, (Bundle) list.get(0), this.zzfqn.zzbpb, new zzcxa(str, zzgp, zzbbq));
        return zzbbq;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzddm> zzaqs() {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcps)).booleanValue()) {
            return zzdvl.zza(new zzdut(this) { // from class: com.google.android.gms.internal.ads.zzddo
                private final zzddp zzgul;

                {
                    this.zzgul = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzdut
                public final zzdvt zzard() {
                    return this.zzgul.zzare();
                }
            }, this.zzgay);
        }
        return zzdvl.zzaf(null);
    }

    public final /* synthetic */ zzdvt zzare() {
        Map<String, List<Bundle>> zzs = this.zzgum.zzs(this.zzgrv, this.zzfqn.zzhbv);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<Bundle>> entry : zzs.entrySet()) {
            String key = entry.getKey();
            List<Bundle> value = entry.getValue();
            Bundle bundle = this.zzfqn.zzhbu.zzchc;
            arrayList.add(zzdvc.zzg(zzdvl.zza(new zzdut(this, key, value, bundle != null ? bundle.getBundle(key) : null) { // from class: com.google.android.gms.internal.ads.zzddr
                private final String zzdft;
                private final zzddp zzgul;
                private final List zzgun;
                private final Bundle zzguo;

                {
                    this.zzgul = r1;
                    this.zzdft = r2;
                    this.zzgun = r3;
                    this.zzguo = r4;
                }

                @Override // com.google.android.gms.internal.ads.zzdut
                public final zzdvt zzard() {
                    return this.zzgul.zza(this.zzdft, this.zzgun, this.zzguo);
                }
            }, this.zzgay)).zza(((Long) zzwe.zzpu().zzd(zzaat.zzcpr)).longValue(), TimeUnit.MILLISECONDS, this.zzflf).zza(Throwable.class, new zzdsl(key) { // from class: com.google.android.gms.internal.ads.zzddq
                private final String zzdgb;

                {
                    this.zzdgb = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzdsl
                public final Object apply(Object obj) {
                    Throwable th = (Throwable) obj;
                    String valueOf = String.valueOf(this.zzdgb);
                    zzbbd.zzfc(valueOf.length() != 0 ? "Error calling adapter: ".concat(valueOf) : new String("Error calling adapter: "));
                    return null;
                }
            }, this.zzgay));
        }
        return zzdvl.zzk(arrayList).zza(new Callable(arrayList) { // from class: com.google.android.gms.internal.ads.zzddt
            private final List zzgup;

            {
                this.zzgup = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                List<zzdvt> list = this.zzgup;
                JSONArray jSONArray = new JSONArray();
                for (zzdvt zzdvt : list) {
                    if (((JSONObject) zzdvt.get()) != null) {
                        jSONArray.put(zzdvt.get());
                    }
                }
                if (jSONArray.length() == 0) {
                    return null;
                }
                return new zzddm(jSONArray.toString());
            }
        }, this.zzgay);
    }
}
