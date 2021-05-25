package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public enum ap {
    UNKNOWN(0),
    FIRST_OCCURRENCE(1),
    NON_FIRST_OCCURENCE(2);
    
    public final int d;

    private ap(int i) {
        this.d = i;
    }

    @NonNull
    public static ap a(@Nullable Integer num) {
        if (num != null) {
            ap[] values = values();
            for (int i = 0; i < 3; i++) {
                ap apVar = values[i];
                if (apVar.d == num.intValue()) {
                    return apVar;
                }
            }
        }
        return UNKNOWN;
    }
}
