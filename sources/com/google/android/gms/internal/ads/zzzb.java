package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.gms.ads.query.QueryInfo;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzzb {
    private final String zzbqs;
    private final Bundle zzckg;

    public zzzb(String str, Bundle bundle) {
        this.zzbqs = str;
        this.zzckg = bundle;
    }

    public static String zza(QueryInfo queryInfo) {
        String str = zzwe.zzpy().get(queryInfo);
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, "");
        } catch (JSONException unused) {
            return "";
        }
    }

    public final String getQuery() {
        return this.zzbqs;
    }

    public final Bundle getQueryBundle() {
        return this.zzckg;
    }
}
