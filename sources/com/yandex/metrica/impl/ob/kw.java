package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import java.io.File;
public class kw implements Runnable {
    @NonNull
    private final Context a;
    @NonNull
    private final File b;
    @NonNull
    private final aby<ln> c;

    public kw(@NonNull Context context, @NonNull File file, @NonNull aby<ln> aby) {
        this.a = context;
        this.b = file;
        this.c = aby;
    }

    @VisibleForTesting
    public void a(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.c.a(new ln(str));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b.exists()) {
            try {
                a(ax.a(this.a, this.b));
            } catch (Throwable unused) {
            }
            try {
                this.b.delete();
            } catch (Throwable unused2) {
            }
        }
    }
}
