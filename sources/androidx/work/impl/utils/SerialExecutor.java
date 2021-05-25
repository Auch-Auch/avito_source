package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
public class SerialExecutor implements Executor {
    public final ArrayDeque<a> a = new ArrayDeque<>();
    public final Executor b;
    public final Object c = new Object();
    public volatile Runnable d;

    public static class a implements Runnable {
        public final SerialExecutor a;
        public final Runnable b;

        public a(@NonNull SerialExecutor serialExecutor, @NonNull Runnable runnable) {
            this.a = serialExecutor;
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.run();
            } finally {
                this.a.a();
            }
        }
    }

    public SerialExecutor(@NonNull Executor executor) {
        this.b = executor;
    }

    public void a() {
        synchronized (this.c) {
            a poll = this.a.poll();
            this.d = poll;
            if (poll != null) {
                this.b.execute(this.d);
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        synchronized (this.c) {
            this.a.add(new a(this, runnable));
            if (this.d == null) {
                a();
            }
        }
    }

    @NonNull
    @VisibleForTesting
    public Executor getDelegatedExecutor() {
        return this.b;
    }

    public boolean hasPendingTasks() {
        boolean z;
        synchronized (this.c) {
            z = !this.a.isEmpty();
        }
        return z;
    }
}
