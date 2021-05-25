package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class bu {
    @NonNull
    private final ca a = new ca();

    @Nullable
    public static String a(@NonNull rx rxVar) {
        byte[] bArr = rxVar.b;
        if (bArr != null) {
            return ca.a(bArr);
        }
        return null;
    }
}
