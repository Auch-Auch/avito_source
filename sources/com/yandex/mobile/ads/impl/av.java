package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.hv;
import java.util.HashMap;
public final class av {
    @NonNull
    private final cs a;
    private boolean b;
    private boolean c;

    public av(@NonNull cs csVar) {
        this.a = csVar;
    }

    public final void a() {
        this.b = false;
        this.c = false;
    }

    public final void b() {
        if (!this.b) {
            this.b = true;
            this.a.a(hv.b.IMPRESSION_TRACKING_START);
        }
    }

    public final void c() {
        if (!this.c) {
            this.c = true;
            HashMap hashMap = new HashMap();
            hashMap.put("failure_tracked", Boolean.FALSE);
            this.a.a(hv.b.IMPRESSION_TRACKING_SUCCESS, hashMap);
        }
    }
}
