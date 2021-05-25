package com.yandex.mobile.ads.impl;

import android.support.annotation.Nullable;
public final class ot {
    private int a;
    private int b;
    @Nullable
    private String c;
    @Nullable
    private String d;

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    @Nullable
    public final String c() {
        return this.c;
    }

    @Nullable
    public final String d() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ot.class == obj.getClass()) {
            ot otVar = (ot) obj;
            if (this.a != otVar.a || this.b != otVar.b) {
                return false;
            }
            String str = this.c;
            if (str == null ? otVar.c != null : !str.equals(otVar.c)) {
                return false;
            }
            String str2 = this.d;
            String str3 = otVar.d;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = ((this.a * 31) + this.b) * 31;
        String str = this.c;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final void a(int i) {
        this.a = i;
    }

    public final void b(int i) {
        this.b = i;
    }

    public final void a(@Nullable String str) {
        this.c = str;
    }

    public final void b(@Nullable String str) {
        this.d = str;
    }
}
