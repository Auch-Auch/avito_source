package com.yandex.metrica.impl.ob;

import android.support.annotation.Nullable;
public class adz implements adw<Integer> {
    public adu a(@Nullable Integer num) {
        if (num == null || num.intValue() > 0) {
            return adu.a(this);
        }
        return adu.a(this, "Invalid quantity value " + num);
    }
}
