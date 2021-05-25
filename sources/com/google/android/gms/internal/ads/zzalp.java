package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzalp {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final zzalq<JSONObject> zzdhs = new zzalr();
    public static final zzalo<InputStream> zzdht = zzals.zzdhu;

    public static final /* synthetic */ InputStream zze(JSONObject jSONObject) throws JSONException {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(UTF_8));
    }
}
