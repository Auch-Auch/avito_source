package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import com.avito.android.util.preferences.db_preferences.Types;
import com.yandex.mobile.ads.nativeads.z;
public final class la extends kv<String, String> {
    @NonNull
    private final qk a = new qk();

    /* access modifiers changed from: private */
    @NonNull
    public oq<String> a(@NonNull String str, @NonNull String str2) {
        if ("review_count".equals(str)) {
            try {
                str2 = this.a.a(str2);
            } catch (z unused) {
            }
        }
        return kv.a(str, Types.STRING, str2);
    }
}
