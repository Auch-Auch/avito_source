package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.CounterConfiguration;
public class ge {
    @Nullable
    private final String a;
    @NonNull
    private final String b;
    @Nullable
    private final Integer c;
    @Nullable
    private final String d;
    @NonNull
    private final CounterConfiguration.a e;

    public ge(@Nullable String str, @NonNull String str2, @Nullable Integer num, @Nullable String str3, @NonNull CounterConfiguration.a aVar) {
        this.a = str;
        this.b = str2;
        this.c = num;
        this.d = str3;
        this.e = aVar;
    }

    @Nullable
    public String a() {
        return this.a;
    }

    @NonNull
    public String b() {
        return this.b;
    }

    @Nullable
    public Integer c() {
        return this.c;
    }

    @Nullable
    public String d() {
        return this.d;
    }

    @NonNull
    public CounterConfiguration.a e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ge geVar = (ge) obj;
        String str = this.a;
        if (str == null ? geVar.a != null : !str.equals(geVar.a)) {
            return false;
        }
        if (!this.b.equals(geVar.b)) {
            return false;
        }
        Integer num = this.c;
        if (num == null ? geVar.c != null : !num.equals(geVar.c)) {
            return false;
        }
        String str2 = this.d;
        if (str2 == null ? geVar.d != null : !str2.equals(geVar.d)) {
            return false;
        }
        if (this.e == geVar.e) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int B0 = a.B0(this.b, (str != null ? str.hashCode() : 0) * 31, 31);
        Integer num = this.c;
        int hashCode = (B0 + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.d;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return this.e.hashCode() + ((hashCode + i) * 31);
    }

    public String toString() {
        StringBuilder L = a.L("ClientDescription{mApiKey='");
        a.k1(L, this.a, '\'', ", mPackageName='");
        a.k1(L, this.b, '\'', ", mProcessID=");
        L.append(this.c);
        L.append(", mProcessSessionID='");
        a.k1(L, this.d, '\'', ", mReporterType=");
        L.append(this.e);
        L.append('}');
        return L.toString();
    }

    @NonNull
    public static ge a(@NonNull et etVar) {
        return new ge(etVar.h().e(), etVar.g().i(), etVar.g().f(), etVar.g().g(), etVar.h().r());
    }
}
