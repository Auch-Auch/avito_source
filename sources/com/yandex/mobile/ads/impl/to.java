package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Map;
public final class to {
    @NonNull
    private final String a;
    @NonNull
    private final String b;
    @NonNull
    private final String c;
    @Nullable
    private final Map<String, String> d;

    public static final class a {
        @NonNull
        private final String a;
        @NonNull
        private final String b;
        @NonNull
        private final String c;
        @Nullable
        private Map<String, String> d;

        public a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @NonNull
        public final to a() {
            return new to(this, (byte) 0);
        }

        @NonNull
        public final a a(@Nullable Map<String, String> map) {
            this.d = map;
            return this;
        }
    }

    public /* synthetic */ to(a aVar, byte b2) {
        this(aVar);
    }

    @NonNull
    public final String a() {
        return this.a;
    }

    @NonNull
    public final String b() {
        return this.b;
    }

    @NonNull
    public final String c() {
        return this.c;
    }

    @Nullable
    public final Map<String, String> d() {
        return this.d;
    }

    private to(@NonNull a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
    }
}
