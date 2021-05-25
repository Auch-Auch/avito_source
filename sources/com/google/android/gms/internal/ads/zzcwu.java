package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzcwu {
    private final Executor executor;
    private JSONObject zzgeb;
    private final Map<String, zzcwx> zzgpk = new ConcurrentHashMap();
    private final Map<String, Map<String, List<zzcwx>>> zzgpl = new ConcurrentHashMap();

    public zzcwu(Executor executor2) {
        this.executor = executor2;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzapx */
    public final synchronized void zzaqa() {
        JSONArray optJSONArray;
        JSONObject zzws = zzp.zzkt().zzwj().zzxe().zzws();
        if (zzws != null) {
            try {
                JSONArray optJSONArray2 = zzws.optJSONArray("ad_unit_id_settings");
                this.zzgeb = zzws.optJSONObject("ad_unit_patterns");
                if (optJSONArray2 != null) {
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        JSONObject jSONObject = optJSONArray2.getJSONObject(i);
                        String optString = jSONObject.optString("ad_unit_id", "");
                        String optString2 = jSONObject.optString("format", "");
                        ArrayList arrayList = new ArrayList();
                        JSONObject optJSONObject = jSONObject.optJSONObject("mediation_config");
                        if (!(optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("ad_networks")) == null)) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                                ArrayList arrayList2 = new ArrayList();
                                if (jSONObject2 != null) {
                                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                                    Bundle bundle = new Bundle();
                                    if (optJSONObject2 != null) {
                                        Iterator<String> keys = optJSONObject2.keys();
                                        while (keys.hasNext()) {
                                            String next = keys.next();
                                            bundle.putString(next, optJSONObject2.optString(next, ""));
                                        }
                                    }
                                    JSONArray optJSONArray3 = jSONObject2.optJSONArray("rtb_adapters");
                                    if (optJSONArray3 != null) {
                                        ArrayList arrayList3 = new ArrayList();
                                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                                            String optString3 = optJSONArray3.optString(i3, "");
                                            if (!TextUtils.isEmpty(optString3)) {
                                                arrayList3.add(optString3);
                                            }
                                        }
                                        int size = arrayList3.size();
                                        int i4 = 0;
                                        while (i4 < size) {
                                            Object obj = arrayList3.get(i4);
                                            i4++;
                                            String str = (String) obj;
                                            zzgq(str);
                                            if (this.zzgpk.get(str) != null) {
                                                arrayList2.add(new zzcwx(str, optString2, bundle));
                                            }
                                        }
                                    }
                                }
                                arrayList.addAll(arrayList2);
                            }
                        }
                        if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString)) {
                            Map<String, List<zzcwx>> map = this.zzgpl.get(optString2);
                            if (map == null) {
                                map = new ConcurrentHashMap<>();
                            }
                            this.zzgpl.put(optString2, map);
                            List<zzcwx> list = map.get(optString);
                            if (list == null) {
                                list = new ArrayList<>();
                            }
                            list.addAll(arrayList);
                            map.put(optString, list);
                        }
                    }
                }
            } catch (JSONException e) {
                zzaxy.zza("Malformed config loading JSON.", e);
            }
        }
    }

    public final void zzanu() {
        zzp.zzkt().zzwj().zzb(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcwt
            private final zzcwu zzgpj;

            {
                this.zzgpj = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgpj.zzapz();
            }
        });
        this.executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcww
            private final zzcwu zzgpj;

            {
                this.zzgpj = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgpj.zzapy();
            }
        });
    }

    public final /* synthetic */ void zzapz() {
        this.executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcwv
            private final zzcwu zzgpj;

            {
                this.zzgpj = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgpj.zzaqa();
            }
        });
    }

    public final void zzgq(String str) {
        if (!TextUtils.isEmpty(str) && !this.zzgpk.containsKey(str)) {
            this.zzgpk.put(str, new zzcwx(str, "", new Bundle()));
        }
    }

    public final Map<String, List<Bundle>> zzs(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return Collections.emptyMap();
        }
        Map<String, List<zzcwx>> map = this.zzgpl.get(str);
        if (map == null) {
            return Collections.emptyMap();
        }
        List<zzcwx> list = map.get(str2);
        if (list == null) {
            list = map.get(zzcjn.zza(this.zzgeb, str2, str));
        }
        if (list == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        for (zzcwx zzcwx : list) {
            String str3 = zzcwx.zzfqh;
            if (!hashMap.containsKey(str3)) {
                hashMap.put(str3, new ArrayList());
            }
            ((List) hashMap.get(str3)).add(zzcwx.zzeqc);
        }
        return hashMap;
    }
}
