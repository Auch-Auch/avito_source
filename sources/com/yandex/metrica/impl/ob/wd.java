package com.yandex.metrica.impl.ob;

import a2.g.r.g;
import android.support.annotation.NonNull;
import com.avito.android.remote.auth.AuthSource;
import java.util.HashMap;
import java.util.Map;
public class wd {
    private final Map<String, String> a;

    public wd() {
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        hashMap.put("android_id", AuthSource.SEND_ABUSE);
        hashMap.put("wakeup", "wu");
        hashMap.put("easy_collecting", "ec");
        hashMap.put("access_point", "ap");
        hashMap.put("cells_around", AuthSource.CREATE_ADVERT);
        hashMap.put("google_aid", g.a);
        hashMap.put("own_macs", "om");
        hashMap.put("sim_imei", "sm");
        hashMap.put("sim_info", "si");
        hashMap.put("wifi_around", "wa");
        hashMap.put("wifi_connected", "wc");
        hashMap.put("features_collecting", "fc");
        hashMap.put("location_collecting", "lc");
        hashMap.put("lbs_collecting", "lbs");
        hashMap.put("package_info", "pi");
        hashMap.put("permissions_collecting", "pc");
        hashMap.put("sdk_list", "sl");
        hashMap.put("socket", "s");
        hashMap.put("telephony_restricted_to_location_tracking", "trtlt");
        hashMap.put("identity_light_collecting", "ilc");
        hashMap.put("ble_collecting", "bc");
        hashMap.put("gpl_collecting", "gplc");
        hashMap.put("retry_policy", "rp");
        hashMap.put("ui_parsing", "up");
        hashMap.put("ui_collecting_for_bridge", "ucfb");
        hashMap.put("ui_event_sending", "ues");
    }

    @NonNull
    public String a(@NonNull String str) {
        return this.a.containsKey(str) ? this.a.get(str) : str;
    }
}
