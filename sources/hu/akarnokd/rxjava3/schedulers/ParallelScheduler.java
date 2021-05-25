package hu.akarnokd.rxjava3.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.schedulers.RxThreadFactory;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
public final class ParallelScheduler extends Scheduler {
    public static final ScheduledExecutorService[] g = new ScheduledExecutorService[0];
    public static final ScheduledExecutorService h;
    public final ThreadFactory b;
    public final int c;
    public final boolean d;
    public final AtomicReference<ScheduledExecutorService[]> e;
    public int f;

    static {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        h = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.shutdownNow();
    }

    public ParallelScheduler() {
        this(Runtime.getRuntime().availableProcessors());
    }

    public ScheduledExecutorService a() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = this.e.get();
        if (scheduledExecutorServiceArr.length == 0) {
            return h;
        }
        int i = this.f;
        if (i >= this.c) {
            i = 0;
        }
        this.f = i + 1;
        return scheduledExecutorServiceArr[i];
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker createWorker() {
        if (this.d) {
            return new b(a());
        }
        return new a(a());
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Disposable scheduleDirect(Runnable runnable) {
        ScheduledExecutorService a3 = a();
        if (a3 == h) {
            return EmptyDisposable.INSTANCE;
        }
        try {
            return s6.a.e.c.b.b(a3.submit(RxJavaPlugins.onSchedule(runnable)));
        } catch (RejectedExecutionException unused) {
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        ScheduledExecutorService a3 = a();
        if (a3 == h) {
            return EmptyDisposable.INSTANCE;
        }
        try {
            return s6.a.e.c.b.b(a3.scheduleAtFixedRate(RxJavaPlugins.onSchedule(runnable), j, j2, timeUnit));
        } catch (RejectedExecutionException unused) {
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public void shutdown() {
        while (true) {
            ScheduledExecutorService[] scheduledExecutorServiceArr = this.e.get();
            ScheduledExecutorService[] scheduledExecutorServiceArr2 = g;
            if (scheduledExecutorServiceArr == scheduledExecutorServiceArr2) {
                return;
            }
            if (this.e.compareAndSet(scheduledExecutorServiceArr, scheduledExecutorServiceArr2)) {
                for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
                    scheduledExecutorService.shutdownNow();
                }
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public void start() {
        ScheduledExecutorService[] scheduledExecutorServiceArr;
        ScheduledExecutorService[] scheduledExecutorServiceArr2 = null;
        do {
            scheduledExecutorServiceArr = this.e.get();
            int i = 0;
            if (scheduledExecutorServiceArr != g) {
                if (scheduledExecutorServiceArr2 != null) {
                    int length = scheduledExecutorServiceArr2.length;
                    while (i < length) {
                        scheduledExecutorServiceArr2[i].shutdownNow();
                        i++;
                    }
                    return;
                }
                return;
            } else if (scheduledExecutorServiceArr2 == null) {
                int i2 = this.c;
                ScheduledExecutorService[] scheduledExecutorServiceArr3 = new ScheduledExecutorService[i2];
                while (i < i2) {
                    scheduledExecutorServiceArr3[i] = Executors.newSingleThreadScheduledExecutor(this.b);
                    i++;
                }
                scheduledExecutorServiceArr2 = scheduledExecutorServiceArr3;
            }
        } while (!this.e.compareAndSet(scheduledExecutorServiceArr, scheduledExecutorServiceArr2));
    }

    public ParallelScheduler(String str) {
        this(Runtime.getRuntime().availableProcessors(), new RxThreadFactory(str));
    }

    public ParallelScheduler(int i) {
        this(i, true);
    }

    public static final class a extends Scheduler.Worker {
        public final ScheduledExecutorService a;
        public volatile boolean b;

        /* renamed from: hu.akarnokd.rxjava3.schedulers.ParallelScheduler$a$a  reason: collision with other inner class name */
        public final class CallableC0370a implements Callable<Object>, Disposable {
            public final Runnable a;
            public volatile boolean b;

            public CallableC0370a(Runnable runnable) {
                this.a = runnable;
            }

            @Override // java.util.concurrent.Callable
            public Object call() throws Exception {
                if (this.b || a.this.b) {
                    return null;
                }
                try {
                    this.a.run();
                    return null;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                    return null;
                }
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public void dispose() {
                this.b = true;
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public boolean isDisposed() {
                return this.b;
            }
        }

        public a(ScheduledExecutorService scheduledExecutorService) {
            this.a = scheduledExecutorService;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.b = true;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.b;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public Disposable schedule(Runnable runnable) {
            if (!this.b) {
                try {
                    CallableC0370a aVar = new CallableC0370a(RxJavaPlugins.onSchedule(runnable));
                    this.a.submit(aVar);
                    return aVar;
                } catch (RejectedExecutionException unused) {
                }
            }
            return EmptyDisposable.INSTANCE;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (!this.b) {
                try {
                    CallableC0370a aVar = new CallableC0370a(RxJavaPlugins.onSchedule(runnable));
                    this.a.schedule(aVar, j, timeUnit);
                    return aVar;
                } catch (RejectedExecutionException unused) {
                }
            }
            return EmptyDisposable.INSTANCE;
        }
    }

    public ParallelScheduler(int i, boolean z) {
        this(i, z, 5);
    }

    public ParallelScheduler(int i, boolean z, int i2) {
        this(i, z, i2, "RxParallelScheduler");
    }

    public static final class b extends Scheduler.Worker {
        public final ScheduledExecutorService a;
        public final CompositeDisposable b = new CompositeDisposable();

        public static final class a extends AtomicReference<DisposableContainer> implements Callable<Object>, Disposable {
            public static final Future<?> c;
            public static final Future<?> d;
            private static final long serialVersionUID = 4949851341419870956L;
            public final AtomicReference<Future<?>> a = new AtomicReference<>();
            public final Runnable b;

            static {
                Runnable runnable = Functions.EMPTY_RUNNABLE;
                FutureTask futureTask = new FutureTask(runnable, null);
                c = futureTask;
                futureTask.cancel(false);
                FutureTask futureTask2 = new FutureTask(runnable, null);
                d = futureTask2;
                futureTask2.cancel(false);
            }

            public a(Runnable runnable, DisposableContainer disposableContainer) {
                this.b = runnable;
                lazySet(disposableContainer);
            }

            public void a(Future<?> future) {
                Future<?> future2 = this.a.get();
                if (future2 != c) {
                    Future<?> future3 = d;
                    if (future2 == future3) {
                        future.cancel(true);
                    } else if (!this.a.compareAndSet(future2, future) && this.a.get() == future3) {
                        future.cancel(true);
                    }
                }
            }

            @Override // java.util.concurrent.Callable
            public Object call() {
                Future<?> future;
                try {
                    this.b.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
                DisposableContainer disposableContainer = (DisposableContainer) get();
                if (disposableContainer != null && compareAndSet(disposableContainer, null)) {
                    disposableContainer.delete(this);
                }
                do {
                    future = this.a.get();
                    if (future == d) {
                        break;
                    }
                } while (!this.a.compareAndSet(future, c));
                return null;
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public void dispose() {
                Future<?> future;
                Future<?> andSet;
                DisposableContainer disposableContainer = (DisposableContainer) getAndSet(null);
                if (disposableContainer != null) {
                    disposableContainer.delete(this);
                }
                Future<?> future2 = this.a.get();
                Future<?> future3 = c;
                if (future2 != future3 && future2 != (future = d) && (andSet = this.a.getAndSet(future)) != null && andSet != future3 && andSet != future) {
                    andSet.cancel(true);
                }
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public boolean isDisposed() {
                return get() == null;
            }
        }

        public b(ScheduledExecutorService scheduledExecutorService) {
            this.a = scheduledExecutorService;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.b.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public Disposable schedule(Runnable runnable) {
            if (!isDisposed()) {
                a aVar = new a(RxJavaPlugins.onSchedule(runnable), this.b);
                if (this.b.add(aVar)) {
                    try {
                        aVar.a(this.a.submit(aVar));
                        return aVar;
                    } catch (RejectedExecutionException unused) {
                    }
                }
            }
            return EmptyDisposable.INSTANCE;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (!isDisposed()) {
                a aVar = new a(RxJavaPlugins.onSchedule(runnable), this.b);
                if (this.b.add(aVar)) {
                    try {
                        aVar.a(this.a.schedule(aVar, j, timeUnit));
                        return aVar;
                    } catch (RejectedExecutionException unused) {
                    }
                }
            }
            return EmptyDisposable.INSTANCE;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ParallelScheduler(int i, boolean z, int i2, String str) {
        this(i, new RxThreadFactory(str, i2), z);
        if (i2 < 1 || i2 > 10) {
            throw new IllegalArgumentException("priority out of range");
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledExecutorService a3 = a();
        if (a3 == h) {
            return EmptyDisposable.INSTANCE;
        }
        try {
            return s6.a.e.c.b.b(a3.schedule(RxJavaPlugins.onSchedule(runnable), j, timeUnit));
        } catch (RejectedExecutionException unused) {
            return EmptyDisposable.INSTANCE;
        }
    }

    public ParallelScheduler(int i, ThreadFactory threadFactory) {
        this(i, threadFactory, true);
    }

    public ParallelScheduler(int i, ThreadFactory threadFactory, boolean z) {
        if (i > 0) {
            this.c = i;
            this.b = threadFactory;
            this.d = z;
            this.e = new AtomicReference<>(g);
            start();
            return;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.M2("parallelism > 0 required but it was ", i));
    }
}
