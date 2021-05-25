package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.NonNull;
import java.util.List;
public class wu {
    @NonNull
    public final String a;
    @NonNull
    public final List<String> b;

    public wu(@NonNull String str, @NonNull List<String> list) {
        this.a = str;
        this.b = list;
    }

    public String toString() {
        StringBuilder L = a.L("SdkItem{name='");
        a.k1(L, this.a, '\'', ", classes=");
        L.append(this.b);
        L.append('}');
        return L.toString();
    }
}
