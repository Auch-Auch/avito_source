package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import org.json.JSONArray;
public class rs extends z<JSONArray> {
    @NonNull
    private final Cdo a;

    public rs(@Nullable y<JSONArray> yVar, @NonNull Cdo doVar) {
        super(yVar);
        this.a = doVar;
    }

    /* renamed from: a */
    public void b(@Nullable JSONArray jSONArray) {
        if (jSONArray != null) {
            this.a.a((Cdo) jSONArray);
        }
    }
}
