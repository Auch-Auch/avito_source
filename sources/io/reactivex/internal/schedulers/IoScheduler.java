package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
public final class IoScheduler extends Scheduler {
    public static final long KEEP_ALIVE_TIME_DEFAULT = 60;
    public static final RxThreadFactory d;
    public static final RxThreadFactory e;
    public static final long f = Long.getLong("rx2.io-keep-alive-time", 60).longValue();
    public static final TimeUnit g = TimeUnit.SECONDS;
    public static final c h;
    public static final a i;
    public final ThreadFactory b;
    public final AtomicReference<a> c;

    public static final class a implements Runnable {
        public final long a;
        public final ConcurrentLinkedQueue<c> b;
        public final CompositeDisposable c;
        public final ScheduledExecutorService d;
        public final Future<?> e;
        public final ThreadFactory f;

        public a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0;
            this.a = nanos;
            this.b = new ConcurrentLinkedQueue<>();
            this.c = new CompositeDisposable();
            this.f = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, IoScheduler.e);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.d = scheduledExecutorService;
            this.e = scheduledFuture;
        }

        public void a() {
            this.c.dispose();
            Future<?> future = this.e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.b.isEmpty()) {
                long nanoTime = System.nanoTime();
                Iterator<c> it = this.b.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.c > nanoTime) {
                        return;
                    }
                    if (this.b.remove(next)) {
                        this.c.remove(next);
                    }
                }
            }
        }
    }

    public static final class b extends Scheduler.Worker {
        public final CompositeDisposable a;
        public final a b;
        public final c c;
        public final AtomicBoolean d = new AtomicBoolean();

        public b(a aVar) {
            c cVar;
            c cVar2;
            this.b = aVar;
            this.a = new CompositeDisposable();
            if (aVar.c.isDisposed()) {
                cVar = IoScheduler.h;
            } else {
                while (true) {
                    if (aVar.b.isEmpty()) {
                        cVar2 = new c(aVar.f);
                        aVar.c.add(cVar2);
                        break;
                    }
                    cVar2 = aVar.b.poll();
                    if (cVar2 != null) {
                        break;
                    }
                }
                cVar = cVar2;
            }
            this.c = cVar;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.d.compareAndSet(false, true)) {
                this.a.dispose();
                a aVar = this.b;
                c cVar = this.c;
                Objects.requireNonNull(aVar);
                cVar.c = System.nanoTime() + aVar.a;
                aVar.b.offer(cVar);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d.get();
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            if (this.a.isDisposed()) {
                return EmptyDisposable.INSTANCE;
            }
            return this.c.scheduleActual(runnable, j, timeUnit, this.a);
        }
    }

    public static final class c extends NewThreadWorker {
        public long c = 0;

        public c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        h = cVar;
        cVar.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxCachedThreadScheduler", max);
        d = rxThreadFactory;
        e = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        a aVar = new a(0, null, rxThreadFactory);
        i = aVar;
        aVar.a();
    }

    public IoScheduler() {
        this(d);
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return new b(this.c.get());
    }

    @Override // io.reactivex.Scheduler
    public void shutdown() {
        a aVar;
        a aVar2;
        do {
            aVar = this.c.get();
            aVar2 = i;
            if (aVar == aVar2) {
                return;
            }
        } while (!this.c.compareAndSet(aVar, aVar2));
        aVar.a();
    }

    public int size() {
        return this.c.get().c.size();
    }

    @Override // io.reactivex.Scheduler
    public void start() {
        a aVar = new a(f, g, this.b);
        if (!this.c.compareAndSet(i, aVar)) {
            aVar.a();
        }
    }

    public IoScheduler(ThreadFactory threadFactory) {
        this.b = threadFactory;
        this.c = new AtomicReference<>(i);
        start();
    }
}
