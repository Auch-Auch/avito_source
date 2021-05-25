package com.yandex.mobile.ads.impl;
public class oz {
    private String a;
    private boolean b;

    public final void a(String str) {
        this.a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            oz ozVar = (oz) obj;
            if (this.b != ozVar.b) {
                return false;
            }
            String str = this.a;
            String str2 = ozVar.a;
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
        String str = this.a;
        return ((str != null ? str.hashCode() : 0) * 31) + (this.b ? 1 : 0);
    }

    public final void a(boolean z) {
        this.b = z;
    }

    public final String a() {
        return this.a;
    }
}
