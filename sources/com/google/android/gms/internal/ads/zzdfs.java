package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;
public final class zzdfs implements zzdek<JSONObject> {
    private JSONObject zzgwe;

    public zzdfs(JSONObject jSONObject) {
        this.zzgwe = jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        try {
            jSONObject.put("cache_state", this.zzgwe);
        } catch (JSONException unused) {
            zzaxy.zzei("Unable to get cache_state");
        }
    }
}
