package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzdgk implements zzdek<JSONObject> {
    private Bundle zzgwp;

    public zzdgk(Bundle bundle) {
        this.zzgwp = bundle;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (this.zzgwp != null) {
            try {
                zzbab.zzb(zzbab.zzb(jSONObject2, "device"), "play_store").put("parental_controls", zzp.zzkp().zzd(this.zzgwp));
            } catch (JSONException unused) {
                zzaxy.zzei("Failed putting parental controls bundle.");
            }
        }
    }
}
