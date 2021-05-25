package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.Nullable;
@Deprecated
public class oq {
    @Nullable
    public final String a;
    @Nullable
    public final String b;

    public oq(@Nullable String str, @Nullable String str2) {
        this.a = str;
        this.b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        oq oqVar = (oq) obj;
        String str = this.a;
        if (str == null ? oqVar.a != null : !str.equals(oqVar.a)) {
            return false;
        }
        String str2 = this.b;
        String str3 = oqVar.b;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder L = a.L("AppMetricaDeviceIdentifiers{deviceID='");
        a.k1(L, this.a, '\'', ", deviceIDHash='");
        L.append(this.b);
        L.append('\'');
        L.append('}');
        return L.toString();
    }
}
