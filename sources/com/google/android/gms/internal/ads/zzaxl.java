package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzaxl {
    private String zzdqt;
    private final long zzdyf;
    private final List<String> zzdyg = new ArrayList();
    private final List<String> zzdyh = new ArrayList();
    private final Map<String, zzamp> zzdyi = new HashMap();
    private String zzdyj;
    private JSONObject zzdyk;
    private boolean zzdyl;

    public zzaxl(String str, long j) {
        JSONObject optJSONObject;
        this.zzdyl = false;
        this.zzdqt = str;
        this.zzdyf = j;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.zzdyk = jSONObject;
                if (jSONObject.optInt("status", -1) != 1) {
                    this.zzdyl = false;
                    zzbbd.zzfe("App settings could not be fetched successfully.");
                    return;
                }
                this.zzdyl = true;
                this.zzdyj = this.zzdyk.optString("app_id");
                JSONArray optJSONArray = this.zzdyk.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("format");
                        String optString2 = jSONObject2.optString("ad_unit_id");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!TextUtils.isEmpty(optString2)) {
                                if ("interstitial".equalsIgnoreCase(optString)) {
                                    this.zzdyh.add(optString2);
                                } else if ("rewarded".equalsIgnoreCase(optString) && (optJSONObject = jSONObject2.optJSONObject("mediation_config")) != null) {
                                    this.zzdyi.put(optString2, new zzamp(optJSONObject));
                                }
                            }
                        }
                    }
                }
                JSONArray optJSONArray2 = this.zzdyk.optJSONArray("persistable_banner_ad_unit_ids");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        this.zzdyg.add(optJSONArray2.optString(i2));
                    }
                }
            } catch (JSONException e) {
                zzbbd.zzd("Exception occurred while processing app setting json", e);
                zzp.zzkt().zza(e, "AppSettings.parseAppSettingsJson");
            }
        }
    }

    public final long zzwn() {
        return this.zzdyf;
    }

    public final boolean zzwo() {
        return this.zzdyl;
    }

    public final String zzwp() {
        return this.zzdqt;
    }

    public final String zzwq() {
        return this.zzdyj;
    }

    public final Map<String, zzamp> zzwr() {
        return this.zzdyi;
    }

    public final JSONObject zzws() {
        return this.zzdyk;
    }
}
