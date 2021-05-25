package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.view.View;
public final class iw {

    public interface a {
        boolean h();
    }

    public static <T extends View & a> boolean a(@NonNull T t) {
        return t.h() && t.hasWindowFocus() && !eg.d(t);
    }
}
