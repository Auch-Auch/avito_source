package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.AdRequest;
import java.util.HashMap;
import java.util.Map;
public class bh implements bb {
    @NonNull
    public final fo a;

    public bh(@NonNull fo foVar) {
        this.a = foVar;
    }

    @Override // com.yandex.mobile.ads.impl.bb
    @NonNull
    public Map<String, Object> a(@NonNull Context context) {
        HashMap hashMap = new HashMap();
        AdRequest c = this.a.c();
        if (c != null) {
            hashMap.put("age", c.getAge());
            hashMap.put("context_tags", c.getContextTags());
            hashMap.put("gender", c.getGender());
            hashMap.put("location", c.getLocation());
            fz a3 = fy.a().a(context);
            Boolean g = a3 != null ? a3.g() : null;
            if (g != null) {
                hashMap.put("user_consent", g);
            }
        }
        return hashMap;
    }

    @Override // com.yandex.mobile.ads.impl.bb
    @NonNull
    public final Map<String, String> a(@NonNull bn bnVar) {
        return bnVar.b();
    }
}
