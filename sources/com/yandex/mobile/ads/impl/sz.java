package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpResponse;
public final class sz implements sq {
    @NonNull
    private final sq a;
    @NonNull
    private final ic b = new ic();
    @Nullable
    private final Context c;

    public sz(@Nullable Context context, @NonNull sq sqVar) {
        this.a = sqVar;
        this.c = context != null ? context.getApplicationContext() : null;
    }

    @Override // com.yandex.mobile.ads.impl.sq
    public final HttpResponse a(ry<?> ryVar, Map<String, String> map) throws IOException, sl {
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.put(rq.USER_AGENT.a(), ic.a(this.c));
        return this.a.a(ryVar, hashMap);
    }
}
