package com.google.android.gms.ads.query;

import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbbd;
import org.json.JSONException;
import org.json.JSONObject;
@KeepForSdk
public class AdInfo {
    private final QueryInfo zzhii;
    private final String zzhij;

    @KeepForSdk
    public AdInfo(QueryInfo queryInfo, String str) {
        this.zzhii = queryInfo;
        this.zzhij = str;
    }

    @KeepForSdk
    public static String getRequestId(String str) {
        if (str == null) {
            zzbbd.zzfe("adString passed to AdInfo.getRequestId() cannot be null. Returning empty string.");
            return "";
        }
        try {
            return new JSONObject(str).optString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, "");
        } catch (JSONException unused) {
            zzbbd.zzfe("Invalid adString passed to AdInfo.getRequestId(). Returning empty string.");
            return "";
        }
    }

    @KeepForSdk
    public String getAdString() {
        return this.zzhij;
    }

    @KeepForSdk
    public QueryInfo getQueryInfo() {
        return this.zzhii;
    }
}
