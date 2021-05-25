package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ExecutorScheduler extends Scheduler {
    public static final Scheduler e = Schedulers.single();
    public final boolean b;
    public final boolean c;
    @NonNull
    public final Executor d;

    public final class a implements Runnable {
        public final b a;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = this.a;
            bVar.b.replace(ExecutorScheduler.this.scheduleDirect(bVar));
        }
    }

    public static final class b extends AtomicReference<Runnable> implements Runnable, Disposable, SchedulerRunnableIntrospection {
        private static final long serialVersionUID = -4101336210206799084L;
        public final SequentialDisposable a = new SequentialDisposable();
        public final SequentialDisposable b = new SequentialDisposable();

        public b(Runnable runnable) {
            super(runnable);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (getAndSet(null) != null) {
                this.a.dispose();
                this.b.dispose();
            }
        }

        @Override // io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection
        public Runnable getWrappedRunnable() {
            Runnable runnable = (Runnable) get();
            return runnable != null ? runnable : Functions.EMPTY_RUNNABLE;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() == null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = (Runnable) get();
            if (runnable != null) {
                try {
                    runnable.run();
                    lazySet(null);
                    SequentialDisposable sequentialDisposable = this.a;
                    DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                    sequentialDisposable.lazySet(disposableHelper);
                    this.b.lazySet(disposableHelper);
                } catch (Throwable th) {
                    RxJavaPlugins.onError(th);
                    throw th;
                }
            }
        }
    }

    public ExecutorScheduler(@NonNull Executor executor, boolean z, boolean z2) {
        this.d = executor;
        this.b = z;
        this.c = z2;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return new ExecutorWorker(this.d, this.b, this.c);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable) {
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        try {
            if (this.d instanceof ExecutorService) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(onSchedule);
                scheduledDirectTask.setFuture(((ExecutorService) this.d).submit(scheduledDirectTask));
                return scheduledDirectTask;
            } else if (this.b) {
                ExecutorWorker.b bVar = new ExecutorWorker.b(onSchedule, null);
                this.d.execute(bVar);
                return bVar;
            } else {
                ExecutorWorker.a aVar = new ExecutorWorker.a(onSchedule);
                this.d.execute(aVar);
                return aVar;
            }
        } catch (RejectedExecutionException e2) {
            RxJavaPlugins.onError(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        if (!(this.d instanceof ScheduledExecutorService)) {
            return super.schedulePeriodicallyDirect(runnable, j, j2, timeUnit);
        }
        try {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(RxJavaPlugins.onSchedule(runnable));
            scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) this.d).scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            RxJavaPlugins.onError(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j, TimeUnit timeUnit) {
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        if (this.d instanceof ScheduledExecutorService) {
            try {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(onSchedule);
                scheduledDirectTask.setFuture(((ScheduledExecutorService) this.d).schedule(scheduledDirectTask, j, timeUnit));
                return scheduledDirectTask;
            } catch (RejectedExecutionException e2) {
                RxJavaPlugins.onError(e2);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            b bVar = new b(onSchedule);
            bVar.a.replace(e.scheduleDirect(new a(bVar), j, timeUnit));
            return bVar;
        }
    }

    public static final class ExecutorWorker extends Scheduler.Worker implements Runnable {
        public final boolean a;
        public final boolean b;
        public final Executor c;
        public final MpscLinkedQueue<Runnable> d;
        public volatile boolean e;
        public final AtomicInteger f = new AtomicInteger();
        public final CompositeDisposable g = new CompositeDisposable();

        public static final class a extends AtomicBoolean implements Runnable, Disposable {
            private static final long serialVersionUID = -2421395018820541164L;
            public final Runnable a;

            public a(Runnable runnable) {
                this.a = runnable;
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public void dispose() {
                lazySet(true);
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public boolean isDisposed() {
                return get();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!get()) {
                    try {
                        this.a.run();
                        lazySet(true);
                    } catch (Throwable th) {
                        lazySet(true);
                        throw th;
                    }
                }
            }
        }

        public static final class b extends AtomicInteger implements Runnable, Disposable {
            private static final long serialVersionUID = -3603436687413320876L;
            public final Runnable a;
            public final DisposableContainer b;
            public volatile Thread c;

            public b(Runnable runnable, DisposableContainer disposableContainer) {
                this.a = runnable;
                this.b = disposableContainer;
            }

            public void a() {
                DisposableContainer disposableContainer = this.b;
                if (disposableContainer != null) {
                    disposableContainer.delete(this);
                }
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public void dispose() {
                while (true) {
                    int i = get();
                    if (i < 2) {
                        if (i == 0) {
                            if (compareAndSet(0, 4)) {
                                a();
                                return;
                            }
                        } else if (compareAndSet(1, 3)) {
                            Thread thread = this.c;
                            if (thread != null) {
                                thread.interrupt();
                                this.c = null;
                            }
                            set(4);
                            a();
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public boolean isDisposed() {
                return get() >= 2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get() == 0) {
                    this.c = Thread.currentThread();
                    if (compareAndSet(0, 1)) {
                        try {
                            this.a.run();
                            this.c = null;
                            if (compareAndSet(1, 2)) {
                                a();
                                return;
                            }
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                        } catch (Throwable th) {
                            this.c = null;
                            if (!compareAndSet(1, 2)) {
                                while (get() == 3) {
                                    Thread.yield();
                                }
                                Thread.interrupted();
                            } else {
                                a();
                            }
                            throw th;
                        }
                    } else {
                        this.c = null;
                    }
                }
            }
        }

        public final class c implements Runnable {
            public final SequentialDisposable a;
            public final Runnable b;

            public c(SequentialDisposable sequentialDisposable, Runnable runnable) {
                this.a = sequentialDisposable;
                this.b = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.replace(ExecutorWorker.this.schedule(this.b));
            }
        }

        public ExecutorWorker(Executor executor, boolean z, boolean z2) {
            this.c = executor;
            this.d = new MpscLinkedQueue<>();
            this.a = z;
            this.b = z2;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (!this.e) {
                this.e = true;
                this.g.dispose();
                if (this.f.getAndIncrement() == 0) {
                    this.d.clear();
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.e;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
            if (r3.e == false) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0044, code lost:
            r0.clear();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
            r1 = r3.f.addAndGet(-r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
            if (r1 != 0) goto L_0x0030;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        @Override // java.lang.Runnable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
                boolean r0 = r3.b
                if (r0 == 0) goto L_0x002d
                io.reactivex.rxjava3.internal.queue.MpscLinkedQueue<java.lang.Runnable> r0 = r3.d
                boolean r1 = r3.e
                if (r1 == 0) goto L_0x000e
                r0.clear()
                goto L_0x005c
            L_0x000e:
                java.lang.Object r1 = r0.poll()
                java.lang.Runnable r1 = (java.lang.Runnable) r1
                r1.run()
                boolean r1 = r3.e
                if (r1 == 0) goto L_0x001f
                r0.clear()
                goto L_0x005c
            L_0x001f:
                java.util.concurrent.atomic.AtomicInteger r0 = r3.f
                int r0 = r0.decrementAndGet()
                if (r0 == 0) goto L_0x005c
                java.util.concurrent.Executor r0 = r3.c
                r0.execute(r3)
                goto L_0x005c
            L_0x002d:
                io.reactivex.rxjava3.internal.queue.MpscLinkedQueue<java.lang.Runnable> r0 = r3.d
                r1 = 1
            L_0x0030:
                boolean r2 = r3.e
                if (r2 == 0) goto L_0x0038
                r0.clear()
                goto L_0x005c
            L_0x0038:
                java.lang.Object r2 = r0.poll()
                java.lang.Runnable r2 = (java.lang.Runnable) r2
                if (r2 != 0) goto L_0x0052
                boolean r2 = r3.e
                if (r2 == 0) goto L_0x0048
                r0.clear()
                goto L_0x005c
            L_0x0048:
                java.util.concurrent.atomic.AtomicInteger r2 = r3.f
                int r1 = -r1
                int r1 = r2.addAndGet(r1)
                if (r1 != 0) goto L_0x0030
                goto L_0x005c
            L_0x0052:
                r2.run()
                boolean r2 = r3.e
                if (r2 == 0) goto L_0x0038
                r0.clear()
            L_0x005c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler.ExecutorWorker.run():void");
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            Disposable disposable;
            if (this.e) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
            if (this.a) {
                disposable = new b(onSchedule, this.g);
                this.g.add(disposable);
            } else {
                disposable = new a(onSchedule);
            }
            this.d.offer(disposable);
            if (this.f.getAndIncrement() == 0) {
                try {
                    this.c.execute(this);
                } catch (RejectedExecutionException e2) {
                    this.e = true;
                    this.d.clear();
                    RxJavaPlugins.onError(e2);
                    return EmptyDisposable.INSTANCE;
                }
            }
            return disposable;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            if (j <= 0) {
                return schedule(runnable);
            }
            if (this.e) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new c(sequentialDisposable2, RxJavaPlugins.onSchedule(runnable)), this.g);
            this.g.add(scheduledRunnable);
            Executor executor = this.c;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.setFuture(((ScheduledExecutorService) executor).schedule((Callable) scheduledRunnable, j, timeUnit));
                } catch (RejectedExecutionException e2) {
                    this.e = true;
                    RxJavaPlugins.onError(e2);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.setFuture(new s6.a.e.d.d.b(ExecutorScheduler.e.scheduleDirect(scheduledRunnable, j, timeUnit)));
            }
            sequentialDisposable.replace(scheduledRunnable);
            return sequentialDisposable2;
        }
    }
}
