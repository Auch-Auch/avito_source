package com.yandex.mobile.ads.mediation.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.avito.android.BuildConfig;
import java.util.HashMap;
import java.util.Map;
public final class b {
    @NonNull
    public static Map<String, String> a(@NonNull a aVar) {
        HashMap hashMap = new HashMap();
        try {
            MediatedAdapterInfo adapterInfo = aVar.getAdapterInfo();
            a(hashMap, "mediation_adapter_version", adapterInfo.getAdapterVersion());
            a(hashMap, "mediation_network_name", adapterInfo.getNetworkName());
            a(hashMap, "mediation_network_sdk_version", adapterInfo.getNetworkSdkVersion());
        } catch (Exception unused) {
        }
        return hashMap;
    }

    private static void a(@NonNull Map<String, String> map, @NonNull String str, @Nullable String str2) {
        if (str2 == null) {
            str2 = BuildConfig.ADJUST_DEFAULT_TRACKER;
        }
        map.put(str, str2);
    }
}
