package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.mobile.ads.impl.hv;
import com.yandex.mobile.ads.nativeads.z;
import org.json.JSONException;
public final class po implements ce<oy> {
    private final bu a = new bu();
    @NonNull
    private final pp b;

    public po(@NonNull Context context) {
        this.b = new pp(context);
    }

    @Nullable
    private oy a(@NonNull String str) {
        try {
            oy a3 = this.b.a(str);
            try {
                a3.a("status", hv.c.SUCCESS);
                return a3;
            } catch (z | JSONException unused) {
                return a3;
            }
        } catch (z | JSONException unused2) {
            return null;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.yandex.mobile.ads.impl.ce
    @Nullable
    public final /* synthetic */ oy b(@NonNull rx rxVar) {
        String a3 = bu.a(rxVar);
        if (!TextUtils.isEmpty(a3)) {
            return a(a3);
        }
        return null;
    }
}
