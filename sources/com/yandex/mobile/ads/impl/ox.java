package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.nativeads.NativeAdType;
import java.util.List;
public class ox {
    private ou a;
    private NativeAdType b;
    private List<oq> c;
    private bo d;
    @Nullable
    private String e;
    @Nullable
    private String f;
    private String g;
    private pg h;
    private pg i;

    public final ou a() {
        return this.a;
    }

    public final NativeAdType b() {
        return this.b;
    }

    public final List<oq> c() {
        return this.c;
    }

    public final bo d() {
        return this.d;
    }

    @Nullable
    public final String e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ox oxVar = (ox) obj;
            ou ouVar = this.a;
            if (ouVar == null ? oxVar.a != null : !ouVar.equals(oxVar.a)) {
                return false;
            }
            if (this.b != oxVar.b) {
                return false;
            }
            List<oq> list = this.c;
            if (list == null ? oxVar.c != null : !list.equals(oxVar.c)) {
                return false;
            }
            bo boVar = this.d;
            if (boVar == null ? oxVar.d != null : !boVar.equals(oxVar.d)) {
                return false;
            }
            String str = this.e;
            if (str == null ? oxVar.e != null : !str.equals(oxVar.e)) {
                return false;
            }
            String str2 = this.f;
            if (str2 == null ? oxVar.f != null : !str2.equals(oxVar.f)) {
                return false;
            }
            String str3 = this.g;
            if (str3 == null ? oxVar.g != null : !str3.equals(oxVar.g)) {
                return false;
            }
            pg pgVar = this.h;
            if (pgVar == null ? oxVar.h != null : !pgVar.equals(oxVar.h)) {
                return false;
            }
            pg pgVar2 = this.i;
            if (pgVar2 != null) {
                return pgVar2.equals(oxVar.i);
            }
            if (oxVar.i == null) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final String f() {
        return this.e;
    }

    public final String g() {
        return this.g;
    }

    public int hashCode() {
        ou ouVar = this.a;
        int i2 = 0;
        int hashCode = (ouVar != null ? ouVar.hashCode() : 0) * 31;
        NativeAdType nativeAdType = this.b;
        int hashCode2 = (hashCode + (nativeAdType != null ? nativeAdType.hashCode() : 0)) * 31;
        List<oq> list = this.c;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        bo boVar = this.d;
        int hashCode4 = (hashCode3 + (boVar != null ? boVar.hashCode() : 0)) * 31;
        String str = this.e;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.g;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31;
        pg pgVar = this.h;
        int hashCode8 = (hashCode7 + (pgVar != null ? pgVar.hashCode() : 0)) * 31;
        pg pgVar2 = this.i;
        if (pgVar2 != null) {
            i2 = pgVar2.hashCode();
        }
        return hashCode8 + i2;
    }

    public final void a(List<oq> list) {
        this.c = list;
    }

    @Nullable
    public final oq b(@NonNull String str) {
        List<oq> list = this.c;
        if (list == null) {
            return null;
        }
        for (oq oqVar : list) {
            if (oqVar.a().equals(str)) {
                return oqVar;
            }
        }
        return null;
    }

    public final void c(@Nullable String str) {
        this.e = str;
    }

    public final void d(@Nullable String str) {
        this.f = str;
    }

    public final void e(String str) {
        this.g = str;
    }

    public final void a(@Nullable ou ouVar) {
        if (ouVar != null) {
            this.a = ouVar;
        }
    }

    public final void a(bo boVar) {
        this.d = boVar;
    }

    public final void a(pg pgVar) {
        this.h = pgVar;
    }

    public final void b(pg pgVar) {
        this.i = pgVar;
    }

    public final void a(String str) {
        NativeAdType nativeAdType;
        NativeAdType[] values = NativeAdType.values();
        int i2 = 0;
        while (true) {
            if (i2 >= 3) {
                nativeAdType = null;
                break;
            }
            nativeAdType = values[i2];
            if (nativeAdType.getValue().equals(str)) {
                break;
            }
            i2++;
        }
        this.b = nativeAdType;
    }
}
