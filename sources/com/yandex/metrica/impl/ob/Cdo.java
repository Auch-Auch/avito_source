package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.r;
import org.json.JSONArray;
/* renamed from: com.yandex.metrica.impl.ob.do  reason: invalid class name */
public class Cdo extends at<JSONArray> {
    public Cdo() {
        this(r.a.a);
    }

    /* renamed from: a */
    public boolean b(@NonNull JSONArray jSONArray) {
        return this.a.b() || this.a.a(this.b);
    }

    @VisibleForTesting
    public Cdo(long j) {
        super(j);
    }
}
