package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class lg {
    @NonNull
    public Integer a(@Nullable Boolean bool) {
        if (Boolean.TRUE.equals(bool)) {
            return 1;
        }
        if (Boolean.FALSE.equals(bool)) {
            return 0;
        }
        return -1;
    }
}
