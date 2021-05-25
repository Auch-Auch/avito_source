package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class js {
    @NonNull
    private final jy a;
    @Nullable
    private final Integer b;

    public static final class a {
        @NonNull
        private jy a;
        @Nullable
        private Integer b;

        private a(jy jyVar) {
            this.a = jyVar;
        }

        public a a(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        public js a() {
            return new js(this);
        }
    }

    public static final a a(jy jyVar) {
        return new a(jyVar);
    }

    @Nullable
    public Integer b() {
        return this.b;
    }

    private js(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
    }

    @NonNull
    public jy a() {
        return this.a;
    }
}
