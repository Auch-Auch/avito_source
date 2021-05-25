package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
public enum jy {
    FOREGROUND(0),
    BACKGROUND(1);
    
    private final int c;

    private jy(int i) {
        this.c = i;
    }

    public int a() {
        return this.c;
    }

    @NonNull
    public static jy a(Integer num) {
        int intValue;
        jy jyVar = FOREGROUND;
        return (num == null || (intValue = num.intValue()) == 0 || intValue != 1) ? jyVar : BACKGROUND;
    }
}
