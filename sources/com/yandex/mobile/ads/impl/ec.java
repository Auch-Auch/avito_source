package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.AdError;
import java.util.Map;
public final class ec {
    @NonNull
    private final Map<String, Object> a;

    public ec(@NonNull Map<String, Object> map) {
        this.a = map;
    }

    public final void a(@NonNull String str, @Nullable Object obj) {
        if (obj == null) {
            a(str);
        } else {
            this.a.put(str, obj);
        }
    }

    public final void b(@NonNull String str, @Nullable Object obj) {
        if (obj != null) {
            this.a.put(str, obj);
        }
    }

    public final void a(@NonNull String str) {
        this.a.put(str, AdError.UNDEFINED_DOMAIN);
    }

    public final void a(@NonNull Map<String, Object> map) {
        this.a.putAll(map);
    }

    @NonNull
    public final Map<String, Object> a() {
        return this.a;
    }
}
