package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Map;
public final class us {
    @NonNull
    private final bu a = new bu();
    @NonNull
    private final ur b = new ur();

    @Nullable
    public final tu a(@NonNull rx rxVar) {
        String a3 = bu.a(rxVar);
        if (!TextUtils.isEmpty(a3)) {
            try {
                tt a4 = this.b.a(a3);
                if (a4 != null) {
                    boolean z = false;
                    Map<String, String> map = rxVar.c;
                    if (map != null) {
                        z = bt.b(map, rq.YMAD_RAW_VAST_ENABLED);
                    }
                    if (!z) {
                        a3 = null;
                    }
                    return new tu(a4, a3);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
