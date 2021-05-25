package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.mobile.ads.impl.dh;
import com.yandex.mobile.ads.impl.hv;
import java.lang.ref.WeakReference;
public final class di {
    @NonNull
    private final Context a;
    @NonNull
    private final dh b;
    @NonNull
    private final mv c = new a(this);
    @NonNull
    private final ms d = mt.a();

    @VisibleForTesting
    public static class a implements mv {
        @Nullable
        private WeakReference<Activity> a;
        @NonNull
        private final di b;

        public a(@NonNull di diVar) {
            this.b = diVar;
        }

        @Override // com.yandex.mobile.ads.impl.mv
        public final void a(@NonNull Activity activity) {
            WeakReference<Activity> weakReference = this.a;
            if (weakReference != null && activity.equals(weakReference.get())) {
                this.b.d();
            }
        }

        @Override // com.yandex.mobile.ads.impl.mv
        public final void b(@NonNull Activity activity) {
            if (this.a == null) {
                this.a = new WeakReference<>(activity);
            }
        }
    }

    public di(@NonNull Context context, @NonNull fo foVar, @NonNull dk dkVar) {
        this.a = context.getApplicationContext();
        this.b = new dh(context, foVar, dkVar);
    }

    public final void a() {
        this.b.a(dh.a.WEBVIEW);
    }

    public final void b() {
        this.b.b(dh.a.WEBVIEW);
    }

    public final void c() {
        this.d.a(this.a, this.c);
        this.b.a(dh.a.BROWSER);
    }

    public final void d() {
        this.b.b(dh.a.BROWSER);
        this.d.b(this.a, this.c);
    }

    public final void e() {
        this.d.a(this.a, this.c);
    }

    public final void f() {
        this.d.b(this.a, this.c);
    }

    public final void a(@NonNull hv.a aVar) {
        this.b.a(aVar);
    }
}
