package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzace;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbg;
import com.google.android.gms.internal.ads.zzdee;
import com.google.android.gms.internal.ads.zzvc;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
public final class zzq {
    private final String zzbqq;
    private final Map<String, String> zzbqr = new TreeMap();
    private String zzbqs;
    private String zzbqt;
    private final Context zzvr;

    public zzq(Context context, String str) {
        this.zzvr = context.getApplicationContext();
        this.zzbqq = str;
    }

    public final String getQuery() {
        return this.zzbqs;
    }

    public final void zza(zzvc zzvc, zzbbg zzbbg) {
        this.zzbqs = zzvc.zzcha.zzbqs;
        Bundle bundle = zzvc.zzchc;
        Bundle bundle2 = bundle != null ? bundle.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle2 != null) {
            String str = zzace.zzczl.get();
            for (String str2 : bundle2.keySet()) {
                if (str.equals(str2)) {
                    this.zzbqt = bundle2.getString(str2);
                } else if (str2.startsWith("csa_")) {
                    this.zzbqr.put(str2.substring(4), bundle2.getString(str2));
                }
            }
            this.zzbqr.put("SDKVersion", zzbbg.zzbra);
            if (zzace.zzczj.get().booleanValue()) {
                try {
                    Bundle zza = zzdee.zza(this.zzvr, new JSONArray(zzace.zzczk.get()));
                    for (String str3 : zza.keySet()) {
                        this.zzbqr.put(str3, zza.get(str3).toString());
                    }
                } catch (JSONException e) {
                    zzbbd.zzc("Flag gads:afs:csa_tcf_data_to_collect not a valid JSON array", e);
                }
            }
        }
    }

    public final String zzlo() {
        return this.zzbqt;
    }

    public final String zzlp() {
        return this.zzbqq;
    }

    public final Map<String, String> zzlq() {
        return this.zzbqr;
    }
}
