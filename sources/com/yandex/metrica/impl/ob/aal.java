package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import org.json.JSONObject;
public class aal {
    @NonNull
    private final aai a;
    private final aak b;

    public aal(@NonNull aai aai, boolean z) {
        this(aai, new aak(z));
    }

    public void a(@NonNull JSONObject jSONObject) {
        this.b.b();
        this.a.a(jSONObject);
    }

    @VisibleForTesting
    public aal(@NonNull aai aai, @NonNull aak aak) {
        this.a = aai;
        this.b = aak;
        aak.a();
    }

    public void a(@NonNull String str) {
        this.b.b();
        this.a.a(str);
    }

    public void a(boolean z) {
        this.b.a(z);
    }
}
