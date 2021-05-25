package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Locale;
import java.util.UUID;
public class aba {
    @Nullable
    public String a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return dh.a(ax.c(str.getBytes()));
    }

    @NonNull
    public String a() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase(Locale.US);
    }
}
