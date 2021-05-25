package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.AdRequest;
import java.util.HashMap;
import java.util.Map;
public final class cv {
    @NonNull
    private final cx a = new cx();
    @NonNull
    private final cz b = new cz();

    @NonNull
    public static Map<String, Object> a(@Nullable AdRequest adRequest) {
        ec ecVar = new ec(new HashMap());
        if (adRequest != null) {
            Map<String, String> parameters = adRequest.getParameters();
            ec ecVar2 = new ec(new HashMap());
            if (parameters != null) {
                ecVar2.b("adapter_network_name", parameters.get("adapter_network_name"));
                ecVar2.b("adapter_version", parameters.get("adapter_version"));
                ecVar2.b("adapter_network_sdk_version", parameters.get("adapter_network_sdk_version"));
            }
            Map<String, Object> a3 = ecVar2.a();
            ec ecVar3 = new ec(new HashMap());
            if (parameters != null) {
                ecVar3.b("plugin_type", parameters.get("plugin_type"));
                ecVar3.b("plugin_version", parameters.get("plugin_version"));
            }
            Map<String, Object> a4 = ecVar3.a();
            ecVar.a(a3);
            ecVar.a(a4);
        }
        return ecVar.a();
    }
}
