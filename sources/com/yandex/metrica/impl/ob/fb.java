package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class fb {
    @NonNull
    private final String a;
    @Nullable
    private final String b;

    public fb(@NonNull String str, @Nullable String str2) {
        this.a = str;
        this.b = str2;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.a + "_" + dl.b(this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        fb fbVar = (fb) obj;
        String str = this.a;
        if (str == null ? fbVar.a != null : !str.equals(fbVar.a)) {
            return false;
        }
        String str2 = this.b;
        String str3 = fbVar.b;
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
        return this.a + "_" + this.b;
    }
}
