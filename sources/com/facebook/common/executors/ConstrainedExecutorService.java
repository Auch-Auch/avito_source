package com.facebook.common.executors;

import com.facebook.common.logging.FLog;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
public class ConstrainedExecutorService extends AbstractExecutorService {
    public static final Class<?> h = ConstrainedExecutorService.class;
    public final String a;
    public final Executor b;
    public volatile int c;
    public final BlockingQueue<Runnable> d;
    public final b e;
    public final AtomicInteger f;
    public final AtomicInteger g;

    public class b implements Runnable {
        public b(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            int decrementAndGet;
            boolean isEmpty;
            try {
                Runnable poll = ConstrainedExecutorService.this.d.poll();
                if (poll != null) {
                    poll.run();
                } else {
                    Class<?> cls = ConstrainedExecutorService.h;
                    FLog.v(ConstrainedExecutorService.h, "%s: Worker has nothing to run", ConstrainedExecutorService.this.a);
                }
                if (isEmpty) {
                    Class<?> cls2 = ConstrainedExecutorService.h;
                    FLog.v(ConstrainedExecutorService.h, "%s: worker finished; %d workers left", ConstrainedExecutorService.this.a, Integer.valueOf(decrementAndGet));
                }
            } finally {
                decrementAndGet = ConstrainedExecutorService.this.f.decrementAndGet();
                if (!ConstrainedExecutorService.this.d.isEmpty()) {
                    ConstrainedExecutorService.this.a();
                } else {
                    Class<?> cls3 = ConstrainedExecutorService.h;
                    FLog.v(ConstrainedExecutorService.h, "%s: worker finished; %d workers left", ConstrainedExecutorService.this.a, Integer.valueOf(decrementAndGet));
                }
            }
        }
    }

    public ConstrainedExecutorService(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i > 0) {
            this.a = str;
            this.b = executor;
            this.c = i;
            this.d = blockingQueue;
            this.e = new b(null);
            this.f = new AtomicInteger(0);
            this.g = new AtomicInteger(0);
            return;
        }
        throw new IllegalArgumentException("max concurrency must be > 0");
    }

    public static ConstrainedExecutorService newConstrainedExecutor(String str, int i, int i2, Executor executor) {
        return new ConstrainedExecutorService(str, i, executor, new LinkedBlockingQueue(i2));
    }

    public final void a() {
        int i = this.f.get();
        while (i < this.c) {
            int i2 = i + 1;
            if (this.f.compareAndSet(i, i2)) {
                FLog.v(h, "%s: starting worker %d of %d", this.a, Integer.valueOf(i2), Integer.valueOf(this.c));
                this.b.execute(this.e);
                return;
            }
            FLog.v(h, "%s: race in startWorkerIfNeeded; retrying", this.a);
            i = this.f.get();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Objects.requireNonNull(runnable, "runnable parameter is null");
        if (this.d.offer(runnable)) {
            int size = this.d.size();
            int i = this.g.get();
            if (size > i && this.g.compareAndSet(i, size)) {
                FLog.v(h, "%s: max pending work in queue = %d", this.a, Integer.valueOf(size));
            }
            a();
            return;
        }
        throw new RejectedExecutionException(this.a + " queue is full, size=" + this.d.size());
    }

    public boolean isIdle() {
        return this.d.isEmpty() && this.f.get() == 0;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }
}
