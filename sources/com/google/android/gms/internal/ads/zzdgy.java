package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzdgy implements zzdek<JSONObject> {
    private final Map<String, Object> zzgwu;

    public zzdgy(Map<String, Object> map) {
        this.zzgwu = map;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        try {
            jSONObject.put("video_decoders", zzp.zzkp().zzj(this.zzgwu));
        } catch (JSONException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzaxy.zzei(valueOf.length() != 0 ? "Could not encode video decoder properties: ".concat(valueOf) : new String("Could not encode video decoder properties: "));
        }
    }
}
