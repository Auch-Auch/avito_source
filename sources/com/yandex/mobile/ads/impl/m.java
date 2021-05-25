package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Window;
import android.widget.RelativeLayout;
import java.util.HashMap;
import java.util.Map;
public final class m {
    @NonNull
    private static final Object a = new Object();
    private static volatile m b;
    @NonNull
    private final Map<String, l> c = new HashMap();

    private m() {
        a("window_type_browser", new j());
    }

    @NonNull
    public static m a() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new m();
                }
            }
        }
        return b;
    }

    public final synchronized void a(@NonNull String str, @NonNull l lVar) {
        if (!this.c.containsKey(str)) {
            this.c.put(str, lVar);
        }
    }

    @Nullable
    public final synchronized k a(@NonNull Context context, @NonNull RelativeLayout relativeLayout, @Nullable ResultReceiver resultReceiver, @NonNull n nVar, @NonNull Intent intent, @NonNull Window window) {
        l lVar;
        String stringExtra = intent.getStringExtra("window_type");
        if (stringExtra == null || (lVar = this.c.get(stringExtra)) == null) {
            return null;
        }
        return lVar.a(context, relativeLayout, resultReceiver, nVar, intent, window);
    }
}
