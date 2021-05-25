package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Window;
import android.widget.RelativeLayout;
public final class j implements l {
    @Override // com.yandex.mobile.ads.impl.l
    @Nullable
    public final k a(@NonNull Context context, @NonNull RelativeLayout relativeLayout, @Nullable ResultReceiver resultReceiver, @NonNull n nVar, @NonNull Intent intent, @NonNull Window window) {
        String stringExtra = intent.getStringExtra("extra_browser_url");
        if (!TextUtils.isEmpty(stringExtra)) {
            return new i(context, relativeLayout, nVar, window, stringExtra);
        }
        return null;
    }
}
