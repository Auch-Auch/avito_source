package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.mobile.ads.MobileAds;
import com.yandex.mobile.ads.impl.fz;
import org.json.JSONException;
import org.json.JSONObject;
public final class cg implements ce<fz> {
    @NonNull
    private final ce<String> a = new ch();
    @NonNull
    private final de b = new de();

    @Nullable
    private static fz a(@NonNull String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean optBoolean = jSONObject.optBoolean("autograb_enabled");
            boolean optBoolean2 = jSONObject.optBoolean("custom_click_handling_enabled");
            boolean optBoolean3 = jSONObject.optBoolean("legacy_visibility_logic_enabled");
            boolean optBoolean4 = jSONObject.optBoolean("url_correction_enabled");
            Boolean valueOf = jSONObject.has("visibility_error_indicator_enabled") ? Boolean.valueOf(jSONObject.optBoolean("visibility_error_indicator_enabled")) : null;
            String optString = jSONObject.optString("mraid_controller", null);
            boolean optBoolean5 = jSONObject.optBoolean("sensitive_mode_disabled");
            Boolean valueOf2 = jSONObject.has("mediation_sensitive_mode_disabled") ? Boolean.valueOf(jSONObject.optBoolean("mediation_sensitive_mode_disabled")) : null;
            boolean optBoolean6 = jSONObject.optBoolean("mrc_visibility_tracking_enabled");
            boolean optBoolean7 = jSONObject.optBoolean("custom_user_agent_enabled");
            boolean optBoolean8 = jSONObject.optBoolean("fused_location_provider_disabled");
            boolean optBoolean9 = jSONObject.optBoolean("lock_screen_enabled");
            long optLong = jSONObject.optLong("reload_timeout");
            return new fz.a().h(optBoolean).a(jSONObject.optInt("ad_ids_storage_size")).a(System.currentTimeMillis() + (optLong > 0 ? optLong * 1000 : 86400000)).a(optString).a(optBoolean2).a(valueOf).b(MobileAds.getLibraryVersion()).g(optBoolean9).b(valueOf2).d(optBoolean6).c(optBoolean5).e(optBoolean7).f(optBoolean8).c(fy.a().e()).b(optBoolean4).i(optBoolean3).a();
        } catch (JSONException unused) {
            return null;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.yandex.mobile.ads.impl.ce
    @Nullable
    public final /* synthetic */ fz b(@NonNull rx rxVar) {
        String b2 = this.a.b(rxVar);
        if (!TextUtils.isEmpty(b2)) {
            return a(b2);
        }
        return null;
    }
}
