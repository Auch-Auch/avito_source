package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.List;
public final class ao {
    @NonNull
    private final aq a = aq.a();
    @NonNull
    private final ap b = new ap();

    @NonNull
    public final String a(@NonNull Context context) {
        return a(context, this.a.b());
    }

    @NonNull
    public final String b(@NonNull Context context) {
        return a(context, this.a.c());
    }

    private static String a(@NonNull Context context, @NonNull List list) {
        return TextUtils.join(",", list.subList(list.size() - Math.min(ap.a(context), list.size()), list.size()));
    }
}
