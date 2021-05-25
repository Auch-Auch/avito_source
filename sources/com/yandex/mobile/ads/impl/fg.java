package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import com.yandex.mobile.ads.impl.iw;
import com.yandex.mobile.ads.impl.iw.a;
import java.lang.ref.WeakReference;
public final class fg<T extends View & iw.a> {
    @NonNull
    private final T a;
    @NonNull
    private final Handler b = new Handler(Looper.getMainLooper());
    @NonNull
    private final ff c;
    @NonNull
    private final fh d;
    @Nullable
    private Runnable e;

    @VisibleForTesting
    public static class a<T extends View & iw.a> implements Runnable {
        @NonNull
        private final WeakReference<fh> a;
        @NonNull
        private final WeakReference<T> b;
        @NonNull
        private final Handler c;
        @NonNull
        private final ff d;

        public a(@NonNull T t, @NonNull fh fhVar, @NonNull Handler handler, @NonNull ff ffVar) {
            this.b = new WeakReference<>(t);
            this.a = new WeakReference<>(fhVar);
            this.c = handler;
            this.d = ffVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            T t = this.b.get();
            fh fhVar = this.a.get();
            if (t != null && fhVar != null) {
                fhVar.a(ff.a(t));
                this.c.postDelayed(this, 200);
            }
        }
    }

    public fg(@NonNull T t, @NonNull ff ffVar, @NonNull fh fhVar) {
        this.a = t;
        this.c = ffVar;
        this.d = fhVar;
    }

    public final void a() {
        if (this.e == null) {
            a aVar = new a(this.a, this.d, this.b, this.c);
            this.e = aVar;
            this.b.post(aVar);
        }
    }

    public final void b() {
        this.b.removeCallbacksAndMessages(null);
        this.e = null;
    }
}
