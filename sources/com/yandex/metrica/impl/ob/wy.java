package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.ads.AdError;
import com.yandex.metrica.impl.ob.cg;
import com.yandex.metrica.impl.ob.vf;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
public class wy {
    private static final Map<vf.a.b.EnumC0362a, String> a = Collections.unmodifiableMap(new HashMap<vf.a.b.EnumC0362a, String>() { // from class: com.yandex.metrica.impl.ob.wy.1
        {
            put(vf.a.b.EnumC0362a.COMPLETE, Tracker.Events.CREATIVE_COMPLETE);
            put(vf.a.b.EnumC0362a.ERROR, "error");
            put(vf.a.b.EnumC0362a.OFFLINE, "offline");
            put(vf.a.b.EnumC0362a.INCOMPATIBLE_NETWORK_TYPE, "incompatible_network_type");
        }
    });
    private static final Map<cg.a, String> b = Collections.unmodifiableMap(new HashMap<cg.a, String>() { // from class: com.yandex.metrica.impl.ob.wy.2
        {
            put(cg.a.WIFI, "wifi");
            put(cg.a.CELL, "cell");
            put(cg.a.OFFLINE, "offline");
            put(cg.a.UNDEFINED, AdError.UNDEFINED_DOMAIN);
        }
    });

    public String a(@NonNull vf.a.b bVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("id", bVar.a().a);
            jSONObject.putOpt("url", bVar.a().b);
            jSONObject.putOpt("status", a.get(bVar.b()));
            jSONObject.putOpt("code", bVar.d());
            if (!dl.a(bVar.e())) {
                jSONObject.putOpt(SDKConstants.PARAM_A2U_BODY, a(bVar.e()));
            } else if (!dl.a(bVar.h())) {
                jSONObject.putOpt(SDKConstants.PARAM_A2U_BODY, a(bVar.h()));
            }
            jSONObject.putOpt("headers", a(bVar.f()));
            jSONObject.putOpt("error", a(bVar.g()));
            jSONObject.putOpt("network_type", b.get(bVar.c()));
            return jSONObject.toString();
        } catch (Throwable th) {
            return th.toString();
        }
    }

    public String a(@NonNull vf.a.C0361a aVar) {
        try {
            return new JSONObject().put("id", aVar.a).toString();
        } catch (Throwable th) {
            return th.toString();
        }
    }

    @Nullable
    private JSONObject a(@Nullable Map<String, List<String>> map) throws JSONException {
        if (dl.a((Map) map)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!dl.a((Collection) entry.getValue())) {
                List<String> a3 = dl.a(entry.getValue(), 10);
                ArrayList arrayList = new ArrayList();
                for (String str : a3) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(dl.a(str, 100));
                    }
                }
                jSONObject.putOpt(key, TextUtils.join(",", arrayList));
            }
        }
        return jSONObject;
    }

    @Nullable
    private String a(@NonNull byte[] bArr) {
        return Base64.encodeToString(bArr, 0);
    }

    @Nullable
    private String a(@Nullable Throwable th) {
        if (th == null) {
            return null;
        }
        return th.toString() + "\n" + Log.getStackTraceString(th);
    }
}
