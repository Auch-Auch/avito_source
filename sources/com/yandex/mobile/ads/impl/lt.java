package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.yandex.mobile.ads.nativeads.al;
import com.yandex.mobile.ads.nativeads.j;
import java.util.HashMap;
import java.util.Map;
public final class lt {
    @NonNull
    private final ls a;
    @NonNull
    private final al b;

    public lt(@NonNull al alVar, @NonNull j jVar, @NonNull lu luVar) {
        this.b = alVar;
        this.a = new ls(jVar, luVar);
    }

    @NonNull
    public final Map<String, lm> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("age", ls.a(this.b.b()));
        hashMap.put(SDKConstants.PARAM_A2U_BODY, ls.a(this.b.c()));
        hashMap.put("call_to_action", ls.a(this.b.d()));
        TextView e = this.b.e();
        lo loVar = null;
        mc mcVar = e != null ? new mc(e) : null;
        hashMap.put("close_button", mcVar != null ? new lo(mcVar) : null);
        hashMap.put("domain", ls.a(this.b.f()));
        hashMap.put("favicon", this.a.a(this.b.g()));
        hashMap.put("feedback", this.a.b(this.b.h()));
        hashMap.put("icon", this.a.a(this.b.i()));
        hashMap.put("media", this.a.a(this.b.j(), this.b.k()));
        View m = this.b.m();
        mi miVar = m != null ? new mi(m) : null;
        if (miVar != null) {
            loVar = new lo(miVar);
        }
        hashMap.put("rating", loVar);
        hashMap.put("review_count", ls.a(this.b.n()));
        hashMap.put("price", ls.a(this.b.l()));
        hashMap.put("sponsored", ls.a(this.b.o()));
        hashMap.put("title", ls.a(this.b.p()));
        hashMap.put("warning", ls.a(this.b.q()));
        return hashMap;
    }
}
