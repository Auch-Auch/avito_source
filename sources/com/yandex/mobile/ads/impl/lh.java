package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.avito.android.BuildConfig;
public final class lh implements lc<String> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.lc
    public final /* bridge */ /* synthetic */ boolean a(@NonNull String str) {
        return a(str);
    }

    public static boolean a(@NonNull String str) {
        return !(TextUtils.isEmpty(str) || BuildConfig.ADJUST_DEFAULT_TRACKER.equals(str));
    }
}
