package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.MobileAds;
import java.util.Map;
public final class hv {
    @NonNull
    private final String a;
    @NonNull
    private final Map<String, Object> b;

    public interface a {
        @NonNull
        Map<String, Object> a();
    }

    public enum b {
        AD_LOADING_RESULT("ad_loading_result"),
        ADAPTER_AUTO_REFRESH("adapter_auto_refresh"),
        ADAPTER_INVALID("adapter_invalid"),
        ADAPTER_REQUEST("adapter_request"),
        ADAPTER_RESPONSE("adapter_response"),
        REQUEST("ad_request"),
        RESPONSE("ad_response"),
        BLOCKS_INFO_REQUEST("blocks_info_request"),
        BLOCKS_INFO_RESPONSE("blocks_info_response"),
        VAST_REQUEST("vast_request"),
        VAST_RESPONSE("vast_response"),
        VAST_WRAPPER_REQUEST("vast_wrapper_request"),
        VAST_WRAPPER_RESPONSE("vast_wrapper_response"),
        VMAP_REQUEST("vmap_request"),
        VMAP_RESPONSE("vmap_response"),
        RENDERING_START("rendering_start"),
        IMPRESSION_TRACKING_START("impression_tracking_start"),
        IMPRESSION_TRACKING_SUCCESS("impression_tracking_success"),
        IMPRESSION_TRACKING_FAILURE("impression_tracking_failure"),
        FORCED_IMPRESSION_TRACKING_FAILURE("forced_impression_tracking_failure"),
        AD_UNIT_IMPRESSION_TRACKING_START("ad_unit_impression_tracking_start"),
        AD_UNIT_IMPRESSION_TRACKING_SUCCESS("ad_unit_impression_tracking_success"),
        AD_UNIT_IMPRESSION_TRACKING_FAILURE("ad_unit_impression_tracking_failure"),
        AD_UNIT_FORCED_IMPRESSION_TRACKING_FAILURE("forced_ad_unit_impression_tracking_failure"),
        ADAPTER_ACTION("adapter_action"),
        CLICK("click"),
        CLOSE("close"),
        FEEDBACK("feedback"),
        DEEPLINK("deeplink"),
        SHORTCUT("shortcut"),
        REQUIRED_ASSET_MISSING("required_asset_missing"),
        BINDING_FAILURE("binding_failure"),
        RETURNED_TO_APP("returned_to_app"),
        REWARD("reward"),
        JS_ERROR("js_error");
        
        private final String J;

        private b(String str) {
            this.J = str;
        }

        @NonNull
        public final String a() {
            return this.J;
        }
    }

    public enum c {
        SUCCESS("success"),
        ERROR("error"),
        NO_ADS("no_ads"),
        FILTERED("filtered");
        
        private final String e;

        private c(String str) {
            this.e = str;
        }

        @NonNull
        public final String a() {
            return this.e;
        }
    }

    public hv(@NonNull b bVar, @NonNull Map<String, Object> map) {
        map.put("sdk_version", MobileAds.getLibraryVersion());
        this.b = map;
        this.a = bVar.a();
    }

    @NonNull
    public final Map<String, Object> a() {
        return this.b;
    }

    @NonNull
    public final String b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || hv.class != obj.getClass()) {
            return false;
        }
        hv hvVar = (hv) obj;
        if (!this.a.equals(hvVar.a)) {
            return false;
        }
        return this.b.equals(hvVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }
}
