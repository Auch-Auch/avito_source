package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.List;
import java.util.Map;
public final class bn {
    @NonNull
    private final String a;
    @NonNull
    private final Map<String, String> b;
    @Nullable
    private final List<String> c;
    @Nullable
    private final List<String> d;
    @Nullable
    private final List<String> e;

    public static class a {
        @NonNull
        private final String a;
        @NonNull
        private final Map<String, String> b;
        @Nullable
        private List<String> c;
        @Nullable
        private List<String> d;
        @Nullable
        private List<String> e;

        public a(@NonNull String str, @NonNull Map<String, String> map) {
            this.a = str;
            this.b = map;
        }

        @NonNull
        public final bn a() {
            return new bn(this, (byte) 0);
        }

        @NonNull
        public final a b(@Nullable List<String> list) {
            this.d = list;
            return this;
        }

        @NonNull
        public final a c(@Nullable List<String> list) {
            this.e = list;
            return this;
        }

        @NonNull
        public final a a(@Nullable List<String> list) {
            this.c = list;
            return this;
        }
    }

    public /* synthetic */ bn(a aVar, byte b2) {
        this(aVar);
    }

    @NonNull
    public final String a() {
        return this.a;
    }

    @NonNull
    public final Map<String, String> b() {
        return this.b;
    }

    @Nullable
    public final List<String> c() {
        return this.c;
    }

    @Nullable
    public final List<String> d() {
        return this.d;
    }

    @Nullable
    public final List<String> e() {
        return this.e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && bn.class == obj.getClass()) {
            bn bnVar = (bn) obj;
            if (!this.a.equals(bnVar.a) || !this.b.equals(bnVar.b)) {
                return false;
            }
            List<String> list = this.c;
            if (list == null ? bnVar.c != null : !list.equals(bnVar.c)) {
                return false;
            }
            List<String> list2 = this.d;
            if (list2 == null ? bnVar.d != null : !list2.equals(bnVar.d)) {
                return false;
            }
            List<String> list3 = this.e;
            if (list3 != null) {
                return list3.equals(bnVar.e);
            }
            if (bnVar.e == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        List<String> list = this.c;
        int i = 0;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<String> list2 = this.d;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<String> list3 = this.e;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return hashCode3 + i;
    }

    private bn(@NonNull a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
    }
}
