package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
public final class kl {
    @NonNull
    private final ke a;

    public kl(@NonNull ke keVar) {
        this.a = keVar;
    }

    @NonNull
    public static kk a(@NonNull x xVar, @NonNull View view, boolean z, boolean z2) {
        Context context = view.getContext();
        kd a3 = ke.a(xVar, view, z);
        if (z2) {
            return new kj(a3);
        }
        return new ki(context, a3);
    }
}
