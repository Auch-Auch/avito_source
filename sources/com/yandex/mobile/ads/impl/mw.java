package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
public final class mw implements ms {
    private static final Object a = new Object();
    private static volatile mw b;

    @NonNull
    public static mw a() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new mw();
                }
            }
        }
        return b;
    }

    @Override // com.yandex.mobile.ads.impl.ms
    public final void a(@NonNull Context context, @NonNull mv mvVar) {
    }

    @Override // com.yandex.mobile.ads.impl.ms
    public final void b(@NonNull Context context, @NonNull mv mvVar) {
    }
}
