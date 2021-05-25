package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class ch implements ce<String> {
    @Nullable
    private static String a(@NonNull rx rxVar) {
        if (rxVar.b == null) {
            return null;
        }
        try {
            return new String(rxVar.b, sp.a(rxVar.c));
        } catch (Exception unused) {
            return new String(rxVar.b);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.yandex.mobile.ads.impl.ce
    @Nullable
    public final /* synthetic */ String b(@NonNull rx rxVar) {
        return a(rxVar);
    }
}
