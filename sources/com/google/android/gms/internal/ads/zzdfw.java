package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzdfw implements zzden<zzdek<JSONObject>> {
    private final JSONObject zzgwi;

    public zzdfw(Context context) {
        this.zzgwi = zzatb.zzz(context);
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdek<JSONObject>> zzaqs() {
        return zzdvl.zzaf(new zzdek(this) { // from class: com.google.android.gms.internal.ads.zzdfz
            private final zzdfw zzgwj;

            {
                this.zzgwj = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzdek
            public final void zzs(Object obj) {
                this.zzgwj.zzq((JSONObject) obj);
            }
        });
    }

    public final /* synthetic */ void zzq(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", this.zzgwi);
        } catch (JSONException unused) {
            zzaxy.zzei("Failed putting version constants.");
        }
    }
}
