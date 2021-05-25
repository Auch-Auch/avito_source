package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzdfm implements zzdek<JSONObject> {
    private String zzgwc;

    public zzdfm(String str) {
        this.zzgwc = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        try {
            JSONObject zzb = zzbab.zzb(jSONObject, "pii");
            if (!TextUtils.isEmpty(this.zzgwc)) {
                zzb.put("attok", this.zzgwc);
            }
        } catch (JSONException e) {
            zzaxy.zza("Failed putting attestation token.", e);
        }
    }
}
