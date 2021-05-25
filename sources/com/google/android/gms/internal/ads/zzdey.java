package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzdey implements zzdek<JSONObject> {
    private final AdvertisingIdClient.Info zzgvs;
    private final String zzgvt;

    public zzdey(AdvertisingIdClient.Info info, String str) {
        this.zzgvs = info;
        this.zzgvt = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        try {
            JSONObject zzb = zzbab.zzb(jSONObject, "pii");
            AdvertisingIdClient.Info info = this.zzgvs;
            if (info == null || TextUtils.isEmpty(info.getId())) {
                zzb.put("pdid", this.zzgvt);
                zzb.put("pdidtype", "ssaid");
                return;
            }
            zzb.put("rdid", this.zzgvs.getId());
            zzb.put("is_lat", this.zzgvs.isLimitAdTrackingEnabled());
            zzb.put("idtype", "adid");
        } catch (JSONException e) {
            zzaxy.zza("Failed putting Ad ID.", e);
        }
    }
}
