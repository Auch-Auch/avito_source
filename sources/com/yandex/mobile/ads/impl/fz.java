package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class fz {
    private final int a;
    private final long b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    @Nullable
    private final Boolean l;
    @Nullable
    private final Boolean m;
    @Nullable
    private final String n;
    @Nullable
    private final String o;
    @Nullable
    private final Boolean p;

    public static class a {
        private int a;
        private long b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        @Nullable
        private Boolean l;
        @Nullable
        private Boolean m;
        @Nullable
        private String n;
        @Nullable
        private Boolean o;
        @Nullable
        private String p;

        @NonNull
        public final fz a() {
            return new fz(this, (byte) 0);
        }

        @NonNull
        public final a b(boolean z) {
            this.j = z;
            return this;
        }

        @NonNull
        public final a c(boolean z) {
            this.i = z;
            return this;
        }

        @NonNull
        public final a d(boolean z) {
            this.h = z;
            return this;
        }

        @NonNull
        public final a e(boolean z) {
            this.d = z;
            return this;
        }

        @NonNull
        public final a f(boolean z) {
            this.e = z;
            return this;
        }

        @NonNull
        public final a g(boolean z) {
            this.f = z;
            return this;
        }

        @NonNull
        public final a h(boolean z) {
            this.g = z;
            return this;
        }

        @NonNull
        public final a i(boolean z) {
            this.k = z;
            return this;
        }

        @NonNull
        public final a a(int i2) {
            this.a = i2;
            return this;
        }

        @NonNull
        public final a b(@Nullable String str) {
            this.p = str;
            return this;
        }

        @NonNull
        public final a c(@Nullable Boolean bool) {
            this.l = bool;
            return this;
        }

        @NonNull
        public final a a(long j2) {
            this.b = j2;
            return this;
        }

        @NonNull
        public final a b(@Nullable Boolean bool) {
            this.o = bool;
            return this;
        }

        @NonNull
        public final a a(boolean z) {
            this.c = z;
            return this;
        }

        @NonNull
        public final a a(@Nullable String str) {
            this.n = str;
            return this;
        }

        @NonNull
        public final a a(@Nullable Boolean bool) {
            this.m = bool;
            return this;
        }
    }

    public /* synthetic */ fz(a aVar, byte b2) {
        this(aVar);
    }

    public final int a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.i;
    }

    @Nullable
    public final Boolean e() {
        return this.l;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && fz.class == obj.getClass()) {
            fz fzVar = (fz) obj;
            if (this.b != fzVar.b || this.a != fzVar.a || this.c != fzVar.c || this.d != fzVar.d || this.e != fzVar.e || this.f != fzVar.f || this.g != fzVar.g || this.h != fzVar.h || this.i != fzVar.i || this.j != fzVar.j || this.k != fzVar.k) {
                return false;
            }
            Boolean bool = this.l;
            if (bool == null ? fzVar.l != null : !bool.equals(fzVar.l)) {
                return false;
            }
            Boolean bool2 = this.m;
            if (bool2 == null ? fzVar.m != null : !bool2.equals(fzVar.m)) {
                return false;
            }
            String str = this.n;
            if (str == null ? fzVar.n != null : !str.equals(fzVar.n)) {
                return false;
            }
            String str2 = this.o;
            if (str2 == null ? fzVar.o != null : !str2.equals(fzVar.o)) {
                return false;
            }
            Boolean bool3 = this.p;
            if (bool3 != null) {
                return bool3.equals(fzVar.p);
            }
            if (fzVar.p == null) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final String f() {
        return this.n;
    }

    @Nullable
    public final Boolean g() {
        return this.p;
    }

    public final boolean h() {
        return this.h;
    }

    public final int hashCode() {
        long j2 = this.b;
        int i2 = ((((((((((((((((((((((int) (j2 ^ (j2 >>> 32))) * 31) + this.a) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + (this.j ? 1 : 0)) * 31) + (this.k ? 1 : 0)) * 31;
        Boolean bool = this.l;
        int i3 = 0;
        int hashCode = (i2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.m;
        int hashCode2 = (hashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        String str = this.n;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.o;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool3 = this.p;
        if (bool3 != null) {
            i3 = bool3.hashCode();
        }
        return hashCode4 + i3;
    }

    public final boolean i() {
        return this.d;
    }

    public final boolean j() {
        return this.e;
    }

    public final boolean k() {
        return this.f;
    }

    public final boolean l() {
        return this.g;
    }

    @Nullable
    public final String m() {
        return this.o;
    }

    @Nullable
    public final Boolean n() {
        return this.m;
    }

    public final boolean o() {
        return this.j;
    }

    public final boolean p() {
        return this.k;
    }

    private fz(@NonNull a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.n = aVar.n;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.m = aVar.m;
        this.o = aVar.p;
        this.p = aVar.o;
        this.h = aVar.h;
        this.i = aVar.i;
        this.l = aVar.l;
        this.j = aVar.j;
        this.k = aVar.k;
    }
}
