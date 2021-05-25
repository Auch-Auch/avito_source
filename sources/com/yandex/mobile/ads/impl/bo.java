package com.yandex.mobile.ads.impl;
public class bo {
    private long a;
    private String b;
    private int c;

    public final void a(long j) {
        this.a = j;
    }

    public final String b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            bo boVar = (bo) obj;
            if (this.a != boVar.a || this.c != boVar.c) {
                return false;
            }
            String str = this.b;
            String str2 = boVar.b;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.a;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.b;
        return ((i + (str != null ? str.hashCode() : 0)) * 31) + this.c;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final long a() {
        return this.a;
    }
}
