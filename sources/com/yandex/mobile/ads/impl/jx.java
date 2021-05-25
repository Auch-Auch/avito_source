package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Window;
import android.widget.RelativeLayout;
public final class jx implements l {
    @Override // com.yandex.mobile.ads.impl.l
    @Nullable
    public final k a(@NonNull Context context, @NonNull RelativeLayout relativeLayout, @Nullable ResultReceiver resultReceiver, @NonNull n nVar, @NonNull Intent intent, @NonNull Window window) {
        jv a = jv.a();
        x<String> b = a.b();
        fo c = a.c();
        String p = b != null ? b.p() : null;
        if (TextUtils.isEmpty(p)) {
            return null;
        }
        return new jw(context, relativeLayout, new dl(context, a(intent), resultReceiver), nVar, window, new ka(b, p, c));
    }

    private static boolean a(@NonNull Intent intent) {
        try {
            return intent.getBooleanExtra("extra_interstitial_isShouldOpenLinksInApp", false);
        } catch (Exception unused) {
            return false;
        }
    }
}
