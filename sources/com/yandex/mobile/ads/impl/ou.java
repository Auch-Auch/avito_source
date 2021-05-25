package com.yandex.mobile.ads.impl;

import android.support.annotation.Nullable;
import java.util.List;
public final class ou {
    @Nullable
    private final List<pa> a;
    @Nullable
    private final dk b;
    @Nullable
    private final String c;
    @Nullable
    private final String d;

    public ou(@Nullable List<pa> list, @Nullable dk dkVar, @Nullable String str, @Nullable String str2) {
        this.a = list;
        this.b = dkVar;
        this.c = str;
        this.d = str2;
    }

    @Nullable
    public final List<pa> a() {
        return this.a;
    }

    @Nullable
    public final dk b() {
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
        if (obj != null && ou.class == obj.getClass()) {
            ou ouVar = (ou) obj;
            List<pa> list = this.a;
            if (list == null ? ouVar.a != null : !list.equals(ouVar.a)) {
                return false;
            }
            dk dkVar = this.b;
            if (dkVar == null ? ouVar.b != null : !dkVar.equals(ouVar.b)) {
                return false;
            }
            String str = this.c;
            if (str == null ? ouVar.c != null : !str.equals(ouVar.c)) {
                return false;
            }
            String str2 = this.d;
            String str3 = ouVar.d;
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
        List<pa> list = this.a;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        dk dkVar = this.b;
        int hashCode2 = (hashCode + (dkVar != null ? dkVar.hashCode() : 0)) * 31;
        String str = this.c;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }
}
