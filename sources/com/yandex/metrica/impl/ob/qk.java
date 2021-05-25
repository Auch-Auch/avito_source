package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.p;
import com.yandex.metrica.impl.ob.qm;
import org.json.JSONArray;
public class qk {
    @Nullable
    private Long a;
    private long b;
    private long c;
    @Nullable
    private JSONArray d;
    @Nullable
    private JSONArray e;
    @Nullable
    private p.a.EnumC0340a f;
    @Nullable
    private qm.a g;

    @Nullable
    public Long a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }

    @Nullable
    public JSONArray c() {
        return this.d;
    }

    @Nullable
    public JSONArray d() {
        return this.e;
    }

    public long e() {
        return this.c;
    }

    @Nullable
    public p.a.EnumC0340a f() {
        return this.f;
    }

    @Nullable
    public qm.a g() {
        return this.g;
    }

    public void a(@Nullable Long l) {
        this.a = l;
    }

    public void b(@Nullable JSONArray jSONArray) {
        this.e = jSONArray;
    }

    public void a(long j) {
        this.b = j;
    }

    public void b(long j) {
        this.c = j;
    }

    public void a(@Nullable JSONArray jSONArray) {
        this.d = jSONArray;
    }

    public void a(@NonNull p.a.EnumC0340a aVar) {
        this.f = aVar;
    }

    public void a(@NonNull qm.a aVar) {
        this.g = aVar;
    }
}
