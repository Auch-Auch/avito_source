package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public final class dg {
    private static final ExecutorService a = Executors.newCachedThreadPool(new dz("YandexMobileAds.UrlTracker"));
    @NonNull
    private final Context b;
    @Nullable
    private fo c;
    @NonNull
    private final ed d;

    public static class a implements Runnable {
        @NonNull
        private final String a;
        @NonNull
        private final dp b;
        @NonNull
        private final ed c;

        public a(@NonNull String str, @NonNull dp dpVar, @NonNull ed edVar) {
            this.a = str;
            this.b = dpVar;
            this.c = edVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String a3 = this.c.a(this.a);
            if (!TextUtils.isEmpty(a3)) {
                this.b.a(a3);
            }
        }
    }

    public dg(@NonNull Context context, @NonNull fo foVar) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.c = foVar;
        this.d = new ed(applicationContext);
    }

    public final void a(@Nullable String str) {
        a(str, new dn(this.b));
    }

    public final void a(@Nullable String str, @NonNull x xVar, @NonNull dm dmVar) {
        a(str, xVar, dmVar, new cr(this.b, xVar, this.c, null));
    }

    public final void a(@Nullable String str, @NonNull x xVar, @NonNull dm dmVar, @NonNull cq cqVar) {
        a(str, new Cdo(this.b, xVar, cqVar, dmVar));
    }

    private void a(@Nullable String str, @NonNull dp dpVar) {
        if (!TextUtils.isEmpty(str)) {
            a.execute(new a(str, dpVar, this.d));
        }
    }
}
