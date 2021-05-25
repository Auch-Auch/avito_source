package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
public class adq implements adw<String> {
    private final String a;

    public adq(@NonNull String str) {
        this.a = str;
    }

    public adu a(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            return adu.a(this);
        }
        return adu.a(this, this.a + " is empty.");
    }
}
