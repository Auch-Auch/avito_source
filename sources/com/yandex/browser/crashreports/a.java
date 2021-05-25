package com.yandex.browser.crashreports;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.VisibleForTesting;
import android.support.annotation.WorkerThread;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
public class a {
    public static final long f = TimeUnit.SECONDS.toMillis(1);
    public final AbstractC0329a a;
    public final Handler b = new Handler(Looper.getMainLooper());
    public final Thread c = new c();
    public final AtomicBoolean d = new AtomicBoolean();
    public final Runnable e = new b();

    /* renamed from: com.yandex.browser.crashreports.a$a  reason: collision with other inner class name */
    public interface AbstractC0329a {
        @WorkerThread
        void a();
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.d.set(true);
        }
    }

    public class c extends Thread {
        public c() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            boolean z = false;
            int i = 0;
            while (!isInterrupted()) {
                if (!z) {
                    a.this.d.set(false);
                    a aVar = a.this;
                    aVar.b.post(aVar.e);
                    i = 0;
                }
                try {
                    Thread.sleep(a.f);
                    if (!a.this.d.get()) {
                        i++;
                        if (i == 4 && !Debug.isDebuggerConnected()) {
                            a.this.b();
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                } catch (InterruptedException unused) {
                    return;
                }
            }
        }
    }

    public a(AbstractC0329a aVar) {
        this.a = aVar;
    }

    public void a() {
        try {
            this.c.setName("CR-WatchDog");
        } catch (SecurityException unused) {
        }
        this.c.start();
    }

    @VisibleForTesting
    public void b() {
        this.a.a();
    }
}
