package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class jq {
    @NonNull
    private final jy a;
    @Nullable
    private final Long b;
    @Nullable
    private final Long c;
    @Nullable
    private final Integer d;
    @Nullable
    private final Long e;
    @Nullable
    private final Boolean f;
    @Nullable
    private final Long g;
    @Nullable
    private final Long h;

    public static final class a {
        @Nullable
        public Long a;
        @NonNull
        private jy b;
        @Nullable
        private Long c;
        @Nullable
        private Long d;
        @Nullable
        private Integer e;
        @Nullable
        private Long f;
        @Nullable
        private Boolean g;
        @Nullable
        private Long h;

        private a(js jsVar) {
            this.b = jsVar.a();
            this.e = jsVar.b();
        }

        public a a(Long l) {
            this.c = l;
            return this;
        }

        public a b(Long l) {
            this.d = l;
            return this;
        }

        public a c(Long l) {
            this.f = l;
            return this;
        }

        public a d(Long l) {
            this.h = l;
            return this;
        }

        public a e(Long l) {
            this.a = l;
            return this;
        }

        public a a(Boolean bool) {
            this.g = bool;
            return this;
        }

        public jq a() {
            return new jq(this);
        }
    }

    public static final a a(js jsVar) {
        return new a(jsVar);
    }

    public long b(long j) {
        Long l = this.c;
        return l == null ? j : l.longValue();
    }

    public long c(long j) {
        Long l = this.e;
        return l == null ? j : l.longValue();
    }

    public long d(long j) {
        Long l = this.g;
        return l == null ? j : l.longValue();
    }

    public long e(long j) {
        Long l = this.h;
        return l == null ? j : l.longValue();
    }

    private jq(a aVar) {
        this.a = aVar.b;
        this.d = aVar.e;
        this.b = aVar.c;
        this.c = aVar.d;
        this.e = aVar.f;
        this.f = aVar.g;
        this.g = aVar.h;
        this.h = aVar.a;
    }

    public jy a() {
        return this.a;
    }

    public long a(long j) {
        Long l = this.b;
        return l == null ? j : l.longValue();
    }

    public int a(int i) {
        Integer num = this.d;
        return num == null ? i : num.intValue();
    }

    public boolean a(boolean z) {
        Boolean bool = this.f;
        return bool == null ? z : bool.booleanValue();
    }
}
