package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class oy {
    private String a;
    private List<oq> b;
    private List<ox> c;
    private oz d;
    private List<bo> e;
    @Nullable
    private List<String> f;
    private Map<String, Object> g = new HashMap();

    public final void a(List<oq> list) {
        this.b = list;
    }

    public final void b(List<ox> list) {
        this.c = list;
    }

    public final void c(List<bo> list) {
        this.e = list;
    }

    public final void d(@NonNull List<String> list) {
        this.f = list;
    }

    @Nullable
    public final List<bo> e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            oy oyVar = (oy) obj;
            String str = this.a;
            if (str == null ? oyVar.a != null : !str.equals(oyVar.a)) {
                return false;
            }
            List<oq> list = this.b;
            if (list == null ? oyVar.b != null : !list.equals(oyVar.b)) {
                return false;
            }
            List<ox> list2 = this.c;
            if (list2 == null ? oyVar.c != null : !list2.equals(oyVar.c)) {
                return false;
            }
            oz ozVar = this.d;
            if (ozVar == null ? oyVar.d != null : !ozVar.equals(oyVar.d)) {
                return false;
            }
            List<bo> list3 = this.e;
            if (list3 == null ? oyVar.e != null : !list3.equals(oyVar.e)) {
                return false;
            }
            List<String> list4 = this.f;
            if (list4 == null ? oyVar.f != null : !list4.equals(oyVar.f)) {
                return false;
            }
            Map<String, Object> map = this.g;
            Map<String, Object> map2 = oyVar.g;
            if (map != null) {
                return map.equals(map2);
            }
            if (map2 == null) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final List<String> f() {
        return this.f;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<oq> list = this.b;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<ox> list2 = this.c;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        oz ozVar = this.d;
        int hashCode4 = (hashCode3 + (ozVar != null ? ozVar.hashCode() : 0)) * 31;
        List<bo> list3 = this.e;
        int hashCode5 = (hashCode4 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<String> list4 = this.f;
        int hashCode6 = (hashCode5 + (list4 != null ? list4.hashCode() : 0)) * 31;
        Map<String, Object> map = this.g;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode6 + i;
    }

    public final void a(oz ozVar) {
        this.d = ozVar;
    }

    public final List<oq> b() {
        return this.b;
    }

    public final List<ox> c() {
        return this.c;
    }

    public final oz d() {
        return this.d;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final void a(String str, Object obj) {
        this.g.put(str, obj);
    }

    @NonNull
    public final Map<String, Object> a() {
        return this.g;
    }
}
