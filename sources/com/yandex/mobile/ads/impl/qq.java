package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
public final class qq {
    private static final Object a = new Object();
    @Nullable
    private static volatile qq b;
    @NonNull
    private final rg c;
    @Nullable
    private String[] d;

    private qq(@NonNull Context context) {
        this.c = new rg(context);
    }

    public static qq a(@NonNull Context context) {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new qq(context.getApplicationContext());
                }
            }
        }
        return b;
    }

    @NonNull
    public final String[] a() {
        if (this.d == null) {
            ArrayList arrayList = new ArrayList();
            if (this.c.a("com.android.launcher.permission.INSTALL_SHORTCUT") && this.c.a("com.android.launcher.permission.UNINSTALL_SHORTCUT")) {
                arrayList.add("shortcut");
            }
            this.d = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return this.d;
    }
}
