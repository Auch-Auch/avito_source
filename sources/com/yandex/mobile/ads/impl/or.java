package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.nativeads.av;
public final class or {
    private final String a;
    private final av.a b;

    public or(av.a aVar, String str) {
        this.b = aVar;
        this.a = str;
    }

    public final String a() {
        return this.a;
    }

    public final av.a b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && or.class == obj.getClass()) {
            or orVar = (or) obj;
            String str = this.a;
            if (str == null ? orVar.a != null : !str.equals(orVar.a)) {
                return false;
            }
            if (this.b == orVar.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        av.a aVar = this.b;
        if (aVar != null) {
            i = aVar.hashCode();
        }
        return hashCode + i;
    }
}
