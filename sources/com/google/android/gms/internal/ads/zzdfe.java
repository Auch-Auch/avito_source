package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;
public final class zzdfe implements zzdek<JSONObject> {
    private final String zzgvw;

    public zzdfe(String str) {
        this.zzgvw = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        try {
            jSONObject.put("ms", this.zzgvw);
        } catch (JSONException e) {
            zzaxy.zza("Failed putting Ad ID.", e);
        }
    }
}
