package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Locale;
public final class ga {
    @NonNull
    private final ge a = new ge();
    @NonNull
    private final gc b = new gc();

    @Nullable
    public final String a(@NonNull Context context) {
        return this.a.a(context).name().toLowerCase(Locale.US);
    }
}
