package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;
public final class zzdgb implements zzdek<JSONObject> {
    private String zzgwl;
    private String zzgwm;

    public zzdgb(String str, String str2) {
        this.zzgwl = str;
        this.zzgwm = str2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        try {
            JSONObject zzb = zzbab.zzb(jSONObject, "pii");
            zzb.put("doritos", this.zzgwl);
            zzb.put("doritos_v2", this.zzgwm);
        } catch (JSONException unused) {
            zzaxy.zzei("Failed putting doritos string.");
        }
    }
}
