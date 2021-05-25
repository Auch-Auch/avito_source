package com.google.mlkit.common.sdkinternal;

import a2.j.h.a.c.o;
import a2.j.h.a.c.p;
import androidx.annotation.GuardedBy;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;
@KeepForSdk
public class TaskQueue {
    public final Object a = new Object();
    @GuardedBy("lock")
    public boolean b;
    @GuardedBy("lock")
    public final Queue<a> c = new ArrayDeque();
    public final AtomicReference<Thread> d = new AtomicReference<>();

    public static class a {
        public final Executor a;
        public final Runnable b;

        public a(Executor executor, Runnable runnable, o oVar) {
            this.a = executor;
            this.b = runnable;
        }
    }

    public final void a() {
        synchronized (this.a) {
            if (this.c.isEmpty()) {
                this.b = false;
                return;
            }
            a remove = this.c.remove();
            try {
                remove.a.execute(new p(this, remove.b));
            } catch (RejectedExecutionException unused) {
                a();
            }
        }
    }

    @KeepForSdk
    public void checkIsRunningOnCurrentThread() {
        Preconditions.checkState(Thread.currentThread().equals(this.d.get()));
    }

    @KeepForSdk
    public void submit(Executor executor, Runnable runnable) {
        synchronized (this.a) {
            if (this.b) {
                this.c.add(new a(executor, runnable, null));
                return;
            }
            this.b = true;
            try {
                executor.execute(new p(this, runnable));
            } catch (RejectedExecutionException unused) {
                a();
            }
        }
    }
}
