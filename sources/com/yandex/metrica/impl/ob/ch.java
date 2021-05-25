package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.metrica.PreloadInfo;
import org.json.JSONObject;
public class ch {
    private PreloadInfo a;

    public ch(PreloadInfo preloadInfo, @NonNull abl abl) {
        if (preloadInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(preloadInfo.getTrackingId())) {
            this.a = preloadInfo;
        } else if (abl.c()) {
            abl.c("Required field \"PreloadInfo.trackingId\" is empty!\nThis preload info will be skipped.");
        }
    }

    public String a() {
        if (this.a == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preloadInfo", b());
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    @Nullable
    public JSONObject b() {
        if (this.a == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackingId", this.a.getTrackingId());
            if (!this.a.getAdditionalParams().isEmpty()) {
                jSONObject.put("additionalParams", new JSONObject(this.a.getAdditionalParams()));
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
