package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
public final class gp implements gl, gm {
    private static final Object a = new Object();
    @Nullable
    private final String b;
    @Nullable
    private final String c;
    @NonNull
    private final gm d;
    @NonNull
    private final Map<gl, Object> e = new WeakHashMap();

    public gp(@Nullable String str, @Nullable String str2, @NonNull gm gmVar) {
        this.b = str;
        this.c = str2;
        this.d = gmVar;
    }

    @Override // com.yandex.mobile.ads.impl.gm
    public final void a(@NonNull gl glVar) {
        synchronized (a) {
            this.e.put(glVar, null);
            this.d.a(this);
        }
    }

    @Override // com.yandex.mobile.ads.impl.gm
    public final void b(@NonNull gl glVar) {
        synchronized (a) {
            this.e.remove(glVar);
            if (this.e.isEmpty()) {
                this.d.b(this);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.gl
    public final void a(@NonNull Map<String, String> map) {
        synchronized (a) {
            HashMap hashMap = new HashMap(map);
            a("yandex_mobile_metrica_uuid", this.b, hashMap);
            a("yandex_mobile_metrica_get_ad_url", this.c, hashMap);
            for (gl glVar : this.e.keySet()) {
                glVar.a(hashMap);
            }
            this.e.clear();
        }
    }

    private static void a(@NonNull String str, @Nullable String str2, @NonNull Map<String, String> map) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    @Override // com.yandex.mobile.ads.impl.gl
    public final void a(@NonNull String str) {
        synchronized (a) {
            for (gl glVar : this.e.keySet()) {
                glVar.a(str);
            }
            this.e.clear();
        }
    }
}
