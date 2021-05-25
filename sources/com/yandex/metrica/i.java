package com.yandex.metrica;

import java.util.Map;
public class i {
    public String a;
    public String b;
    public Map<String, String> c;

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public Map<String, String> c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        String str = this.a;
        if (str == null ? iVar.a != null : !str.equals(iVar.a)) {
            return false;
        }
        String str2 = this.b;
        if (str2 == null ? iVar.b != null : !str2.equals(iVar.b)) {
            return false;
        }
        Map<String, String> map = this.c;
        Map<String, String> map2 = iVar.c;
        if (map != null) {
            return map.equals(map2);
        }
        if (map2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Map<String, String> map = this.c;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode2 + i;
    }

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public void a(Map<String, String> map) {
        this.c = map;
    }
}
