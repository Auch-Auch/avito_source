package com.yandex.metrica.impl.ob;
public class fs extends fb {
    public fs(String str, String str2) {
        super(str, str2);
    }

    @Override // com.yandex.metrica.impl.ob.fb
    public String c() {
        return toString();
    }

    @Override // com.yandex.metrica.impl.ob.fb
    public String toString() {
        return b();
    }
}
