package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
public class aac implements zq {
    private final int a;

    public aac(int i) {
        this.a = i;
    }

    @Override // com.yandex.metrica.impl.ob.zq
    public void a(@NonNull aad aad) {
        if (aad.a.length() > this.a) {
            int length = aad.a.length();
            int i = this.a;
            int i2 = length - i;
            String substring = aad.a.substring(0, i);
            aad.a = substring;
            aad.c = Integer.valueOf(substring.length() + i2);
        }
    }
}
