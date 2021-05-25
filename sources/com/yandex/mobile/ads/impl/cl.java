package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
public final class cl {
    @NonNull
    private final ck a;
    @NonNull
    private final b b;
    @NonNull
    private final Handler c = new Handler(Looper.getMainLooper());
    private boolean d;

    public final class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (cl.this.d) {
                return;
            }
            if (cl.this.a.a()) {
                cl.this.d = true;
                cl.this.b.a();
                return;
            }
            cl.this.c.postDelayed(new a(), 300);
        }

        public /* synthetic */ a(cl clVar, byte b) {
            this();
        }
    }

    public interface b {
        void a();
    }

    public cl(@NonNull ck ckVar, @NonNull b bVar) {
        this.a = ckVar;
        this.b = bVar;
    }

    public final void a() {
        this.c.post(new a(this, (byte) 0));
    }

    public final void b() {
        this.c.removeCallbacksAndMessages(null);
    }
}
