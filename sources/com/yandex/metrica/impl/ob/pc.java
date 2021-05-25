package com.yandex.metrica.impl.ob;
public class pc {
    public final a a;
    public final String b;
    public final Boolean c;

    public enum a {
        GOOGLE,
        HMS
    }

    public pc(a aVar, String str, Boolean bool) {
        this.a = aVar;
        this.b = str;
        this.c = bool;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("AdTrackingInfo{provider=");
        L.append(this.a);
        L.append(", advId='");
        a2.b.a.a.a.k1(L, this.b, '\'', ", limitedAdTracking=");
        L.append(this.c);
        L.append('}');
        return L.toString();
    }
}
