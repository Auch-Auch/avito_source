package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
public class fi {
    @NonNull
    private final mo a;

    public fi(@NonNull mo moVar) {
        this.a = moVar;
    }

    public int a() {
        int a3 = this.a.a();
        this.a.b(a3 + 1).q();
        return a3;
    }

    public int a(int i) {
        int a3 = this.a.a(i);
        this.a.a(i, a3 + 1).q();
        return a3;
    }
}
