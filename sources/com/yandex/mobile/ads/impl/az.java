package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
public final class az {
    @NonNull
    public static ay a(@NonNull Context context, @NonNull fo foVar, @NonNull cs csVar, @NonNull ba baVar, @NonNull String str) {
        fz a = fy.a().a(context);
        if (a == null || !a.h()) {
            return new aw(context, foVar, csVar, baVar, str);
        }
        return new ax(context, foVar, csVar, baVar, str);
    }
}
