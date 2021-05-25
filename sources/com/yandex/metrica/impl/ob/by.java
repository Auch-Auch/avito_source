package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
public class by extends acx {
    @NonNull
    private final Executor a;
    private Executor b;
    private final BlockingQueue<a> c = new LinkedBlockingQueue();
    private final Object d = new Object();
    private final Object e = new Object();
    private volatile a f;
    @NonNull
    private sd g;
    @NonNull
    private final mq h;

    public static class a {
        @NonNull
        public final ca a;
        @NonNull
        private final String b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.b.equals(((a) obj).b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        private a(@NonNull ca caVar) {
            this.a = caVar;
            this.b = caVar.n();
        }
    }

    public by(@NonNull Context context, @NonNull Executor executor, @NonNull mq mqVar) {
        this.a = executor;
        this.h = mqVar;
        this.b = new acp();
        this.g = new sd(context);
    }

    public void a(ca caVar) {
        synchronized (this.d) {
            a aVar = new a(caVar);
            if (c() && !a(aVar)) {
                aVar.a.C();
                this.c.offer(aVar);
            }
        }
    }

    @VisibleForTesting
    @NonNull
    public cd b(@NonNull ca caVar) {
        return new cd(this.g, new se(new sf(this.h, caVar.E()), caVar.F()), caVar, this, "NetworkTaskQueue");
    }

    @VisibleForTesting
    public Executor c(ca caVar) {
        if (caVar.o()) {
            return this.a;
        }
        return this.b;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ca caVar = null;
        while (c()) {
            try {
                synchronized (this.e) {
                }
                this.f = this.c.take();
                caVar = this.f.a;
                c(caVar).execute(b(caVar));
                synchronized (this.e) {
                    this.f = null;
                    if (caVar != null) {
                        caVar.D();
                    }
                }
            } catch (InterruptedException unused) {
                synchronized (this.e) {
                    this.f = null;
                    if (caVar != null) {
                        caVar.D();
                    }
                }
            } catch (Throwable th) {
                synchronized (this.e) {
                    this.f = null;
                    if (caVar != null) {
                        caVar.D();
                    }
                    throw th;
                }
            }
        }
    }

    public void a() {
        synchronized (this.e) {
            a aVar = this.f;
            if (aVar != null) {
                aVar.a.w();
                aVar.a.D();
            }
            while (!this.c.isEmpty()) {
                try {
                    this.c.take().a.D();
                } catch (InterruptedException unused) {
                }
            }
            b();
        }
    }

    private boolean a(a aVar) {
        return this.c.contains(aVar) || aVar.equals(this.f);
    }
}
