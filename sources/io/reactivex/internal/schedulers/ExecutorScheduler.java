package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import io.reactivex.schedulers.Schedulers;
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
    public static final Scheduler d = Schedulers.single();
    public final boolean b;
    @NonNull
    public final Executor c;

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

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(null) != null) {
                this.a.dispose();
                this.b.dispose();
            }
        }

        @Override // io.reactivex.schedulers.SchedulerRunnableIntrospection
        public Runnable getWrappedRunnable() {
            Runnable runnable = (Runnable) get();
            return runnable != null ? runnable : Functions.EMPTY_RUNNABLE;
        }

        @Override // io.reactivex.disposables.Disposable
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
                    lazySet(null);
                    this.a.lazySet(DisposableHelper.DISPOSED);
                    this.b.lazySet(DisposableHelper.DISPOSED);
                    throw th;
                }
            }
        }
    }

    public ExecutorScheduler(@NonNull Executor executor, boolean z) {
        this.c = executor;
        this.b = z;
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return new ExecutorWorker(this.c, this.b);
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable) {
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        try {
            if (this.c instanceof ExecutorService) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(onSchedule);
                scheduledDirectTask.setFuture(((ExecutorService) this.c).submit(scheduledDirectTask));
                return scheduledDirectTask;
            } else if (this.b) {
                ExecutorWorker.b bVar = new ExecutorWorker.b(onSchedule, null);
                this.c.execute(bVar);
                return bVar;
            } else {
                ExecutorWorker.a aVar = new ExecutorWorker.a(onSchedule);
                this.c.execute(aVar);
                return aVar;
            }
        } catch (RejectedExecutionException e) {
            RxJavaPlugins.onError(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        if (!(this.c instanceof ScheduledExecutorService)) {
            return super.schedulePeriodicallyDirect(runnable, j, j2, timeUnit);
        }
        try {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(RxJavaPlugins.onSchedule(runnable));
            scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) this.c).scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e) {
            RxJavaPlugins.onError(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j, TimeUnit timeUnit) {
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        if (this.c instanceof ScheduledExecutorService) {
            try {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(onSchedule);
                scheduledDirectTask.setFuture(((ScheduledExecutorService) this.c).schedule(scheduledDirectTask, j, timeUnit));
                return scheduledDirectTask;
            } catch (RejectedExecutionException e) {
                RxJavaPlugins.onError(e);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            b bVar = new b(onSchedule);
            bVar.a.replace(d.scheduleDirect(new a(bVar), j, timeUnit));
            return bVar;
        }
    }

    public static final class ExecutorWorker extends Scheduler.Worker implements Runnable {
        public final boolean a;
        public final Executor b;
        public final MpscLinkedQueue<Runnable> c;
        public volatile boolean d;
        public final AtomicInteger e = new AtomicInteger();
        public final CompositeDisposable f = new CompositeDisposable();

        public static final class a extends AtomicBoolean implements Runnable, Disposable {
            private static final long serialVersionUID = -2421395018820541164L;
            public final Runnable a;

            public a(Runnable runnable) {
                this.a = runnable;
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                lazySet(true);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return get();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!get()) {
                    boolean z = true;
                    try {
                        this.a.run();
                    } finally {
                        lazySet(z);
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

            @Override // io.reactivex.disposables.Disposable
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

            @Override // io.reactivex.disposables.Disposable
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

        public ExecutorWorker(Executor executor, boolean z) {
            this.b = executor;
            this.c = new MpscLinkedQueue<>();
            this.a = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.d) {
                this.d = true;
                this.f.dispose();
                if (this.e.getAndIncrement() == 0) {
                    this.c.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            r1 = r3.e.addAndGet(-r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
            if (r1 != 0) goto L_0x0003;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
            if (r3.d == false) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            r0.clear();
         */
        @Override // java.lang.Runnable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
                io.reactivex.internal.queue.MpscLinkedQueue<java.lang.Runnable> r0 = r3.c
                r1 = 1
            L_0x0003:
                boolean r2 = r3.d
                if (r2 == 0) goto L_0x000b
                r0.clear()
                return
            L_0x000b:
                java.lang.Object r2 = r0.poll()
                java.lang.Runnable r2 = (java.lang.Runnable) r2
                if (r2 != 0) goto L_0x0025
                boolean r2 = r3.d
                if (r2 == 0) goto L_0x001b
                r0.clear()
                return
            L_0x001b:
                java.util.concurrent.atomic.AtomicInteger r2 = r3.e
                int r1 = -r1
                int r1 = r2.addAndGet(r1)
                if (r1 != 0) goto L_0x0003
                return
            L_0x0025:
                r2.run()
                boolean r2 = r3.d
                if (r2 == 0) goto L_0x000b
                r0.clear()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.ExecutorScheduler.ExecutorWorker.run():void");
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            Disposable disposable;
            if (this.d) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
            if (this.a) {
                disposable = new b(onSchedule, this.f);
                this.f.add(disposable);
            } else {
                disposable = new a(onSchedule);
            }
            this.c.offer(disposable);
            if (this.e.getAndIncrement() == 0) {
                try {
                    this.b.execute(this);
                } catch (RejectedExecutionException e2) {
                    this.d = true;
                    this.c.clear();
                    RxJavaPlugins.onError(e2);
                    return EmptyDisposable.INSTANCE;
                }
            }
            return disposable;
        }

        @Override // io.reactivex.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            if (j <= 0) {
                return schedule(runnable);
            }
            if (this.d) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new c(sequentialDisposable2, RxJavaPlugins.onSchedule(runnable)), this.f);
            this.f.add(scheduledRunnable);
            Executor executor = this.b;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.setFuture(((ScheduledExecutorService) executor).schedule((Callable) scheduledRunnable, j, timeUnit));
                } catch (RejectedExecutionException e2) {
                    this.d = true;
                    RxJavaPlugins.onError(e2);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.setFuture(new s6.a.c.c.b(ExecutorScheduler.d.scheduleDirect(scheduledRunnable, j, timeUnit)));
            }
            sequentialDisposable.replace(scheduledRunnable);
            return sequentialDisposable2;
        }
    }
}
