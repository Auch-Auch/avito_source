package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.pc;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public final class wg {
    public static final Map<pc.a, String> a;
    public static final Map<pc.a, String> b;

    static {
        HashMap hashMap = new HashMap();
        pc.a aVar = pc.a.GOOGLE;
        hashMap.put(aVar, "adv_id");
        pc.a aVar2 = pc.a.HMS;
        hashMap.put(aVar2, "oaid");
        a = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(aVar, "limit_ad_tracking");
        hashMap2.put(aVar2, "limit_oaid_tracking");
        b = Collections.unmodifiableMap(hashMap2);
    }
}
