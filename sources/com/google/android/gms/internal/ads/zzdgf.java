package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzdgf implements zzdek<JSONObject> {
    private List<String> zzdqh;

    public zzdgf(List<String> list) {
        this.zzdqh = list;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        try {
            jSONObject.put("eid", TextUtils.join(",", this.zzdqh));
        } catch (JSONException unused) {
            zzaxy.zzei("Failed putting experiment ids.");
        }
    }
}
