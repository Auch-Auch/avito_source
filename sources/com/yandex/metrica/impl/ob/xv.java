package com.yandex.metrica.impl.ob;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public enum xv {
    UNKNOWN(0),
    NETWORK(1),
    PARSE(2);
    
    private int d;

    private xv(int i) {
        this.d = i;
    }

    @Nullable
    public static xv b(Bundle bundle) {
        if (bundle.containsKey("startup_error_key_code")) {
            return a(bundle.getInt("startup_error_key_code"));
        }
        return null;
    }

    public int a() {
        return this.d;
    }

    public Bundle a(Bundle bundle) {
        bundle.putInt("startup_error_key_code", a());
        return bundle;
    }

    @NonNull
    private static xv a(int i) {
        xv xvVar = UNKNOWN;
        if (i == 1) {
            return NETWORK;
        }
        if (i != 2) {
            return xvVar;
        }
        return PARSE;
    }
}
