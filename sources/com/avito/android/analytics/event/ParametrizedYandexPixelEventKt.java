package com.avito.android.analytics.event;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"serp-core_release"}, k = 2, mv = {1, 4, 2})
public final class ParametrizedYandexPixelEventKt {
    public static final Map access$createParams(String str, String str2, String str3, boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("as", "6_" + str + '-' + str2 + "-rtb");
        linkedHashMap.put("e", str3);
        linkedHashMap.put("i", z ? "1" : "0");
        return linkedHashMap;
    }
}
