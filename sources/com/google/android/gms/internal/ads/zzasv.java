package com.google.android.gms.internal.ads;

import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
public final class zzasv {
    private final int errorCode;
    private final String type;
    private String url;
    private final String zzdqg;
    private final String zzdst;
    private final boolean zzdsu;
    private final String zzdth;
    private final List<String> zzduj;
    private final String zzduk;
    private final String zzdul;
    private final boolean zzdum;
    private final String zzdun;
    private final boolean zzduo;
    private final JSONObject zzdup;

    public zzasv(JSONObject jSONObject) {
        List<String> list;
        this.url = jSONObject.optString("url");
        this.zzduk = jSONObject.optString("base_uri");
        this.zzdul = jSONObject.optString("post_parameters");
        String optString = jSONObject.optString("drt_include");
        int i = 1;
        this.zzdum = optString != null && (optString.equals("1") || optString.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
        this.zzdqg = jSONObject.optString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID);
        this.type = jSONObject.optString("type");
        String optString2 = jSONObject.optString("errors");
        if (optString2 == null) {
            list = null;
        } else {
            list = Arrays.asList(optString2.split(","));
        }
        this.zzduj = list;
        this.errorCode = jSONObject.optInt("valid", 0) == 1 ? -2 : i;
        this.zzdun = jSONObject.optString("fetched_ad");
        this.zzduo = jSONObject.optBoolean("render_test_ad_label");
        JSONObject optJSONObject = jSONObject.optJSONObject("preprocessor_flags");
        this.zzdup = optJSONObject == null ? new JSONObject() : optJSONObject;
        this.zzdst = jSONObject.optString("analytics_query_ad_event_id");
        this.zzdsu = jSONObject.optBoolean("is_analytics_logging_enabled");
        this.zzdth = jSONObject.optString("pool_key");
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getUrl() {
        return this.url;
    }

    public final List<String> zzve() {
        return this.zzduj;
    }

    public final String zzvf() {
        return this.zzduk;
    }

    public final String zzvg() {
        return this.zzdul;
    }

    public final boolean zzvh() {
        return this.zzdum;
    }

    public final JSONObject zzvi() {
        return this.zzdup;
    }

    public final String zzvj() {
        return this.zzdth;
    }
}
