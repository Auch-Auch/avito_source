package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.schedulers.NewThreadWorker;
import io.reactivex.rxjava3.internal.schedulers.SchedulerWhen;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
public abstract class Scheduler {
    public static final long a;

    public static abstract class Worker implements Disposable {

        public final class a implements Runnable, SchedulerRunnableIntrospection {
            @NonNull
            public final Runnable a;
            @NonNull
            public final SequentialDisposable b;
            public final long c;
            public long d;
            public long e;
            public long f;

            public a(long j, @NonNull Runnable runnable, long j2, @NonNull SequentialDisposable sequentialDisposable, long j3) {
                this.a = runnable;
                this.b = sequentialDisposable;
                this.c = j3;
                this.e = j2;
                this.f = j;
            }

            @Override // io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection
            public Runnable getWrappedRunnable() {
                return this.a;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.a.run();
                if (!this.b.isDisposed()) {
                    Worker worker = Worker.this;
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    long now = worker.now(timeUnit);
                    long j2 = Scheduler.a;
                    long j3 = this.e;
                    if (now + j2 >= j3) {
                        long j4 = this.c;
                        if (now < j3 + j4 + j2) {
                            long j5 = this.f;
                            long j6 = this.d + 1;
                            this.d = j6;
                            j = (j6 * j4) + j5;
                            this.e = now;
                            this.b.replace(Worker.this.schedule(this, j - now, timeUnit));
                        }
                    }
                    long j7 = this.c;
                    j = now + j7;
                    long j8 = this.d + 1;
                    this.d = j8;
                    this.f = j - (j7 * j8);
                    this.e = now;
                    this.b.replace(Worker.this.schedule(this, j - now, timeUnit));
                }
            }
        }

        public long now(@NonNull TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            return schedule(runnable, 0, TimeUnit.NANOSECONDS);
        }

        @NonNull
        public abstract Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit);

        @NonNull
        public Disposable schedulePeriodically(@NonNull Runnable runnable, long j, long j2, @NonNull TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
            long nanos = timeUnit.toNanos(j2);
            long now = now(TimeUnit.NANOSECONDS);
            Disposable schedule = schedule(new a(timeUnit.toNanos(j) + now, onSchedule, now, sequentialDisposable2, nanos), j, timeUnit);
            if (schedule == EmptyDisposable.INSTANCE) {
                return schedule;
            }
            sequentialDisposable.replace(schedule);
            return sequentialDisposable2;
        }
    }

    public static final class a implements Disposable, Runnable, SchedulerRunnableIntrospection {
        @NonNull
        public final Runnable a;
        @NonNull
        public final Worker b;
        @Nullable
        public Thread c;

        public a(@NonNull Runnable runnable, @NonNull Worker worker) {
            this.a = runnable;
            this.b = worker;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (this.c == Thread.currentThread()) {
                Worker worker = this.b;
                if (worker instanceof NewThreadWorker) {
                    ((NewThreadWorker) worker).shutdown();
                    return;
                }
            }
            this.b.dispose();
        }

        @Override // io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection
        public Runnable getWrappedRunnable() {
            return this.a;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c = Thread.currentThread();
            try {
                this.a.run();
                dispose();
                this.c = null;
            } catch (Throwable th) {
                dispose();
                this.c = null;
                throw th;
            }
        }
    }

    public static final class b implements Disposable, Runnable, SchedulerRunnableIntrospection {
        @NonNull
        public final Runnable a;
        @NonNull
        public final Worker b;
        public volatile boolean c;

        public b(@NonNull Runnable runnable, @NonNull Worker worker) {
            this.a = runnable;
            this.b = worker;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.c = true;
            this.b.dispose();
        }

        @Override // io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection
        public Runnable getWrappedRunnable() {
            return this.a;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.c) {
                try {
                    this.a.run();
                } catch (Throwable th) {
                    dispose();
                    RxJavaPlugins.onError(th);
                    throw th;
                }
            }
        }
    }

    static {
        long j;
        long longValue = Long.getLong("rx3.scheduler.drift-tolerance", 15).longValue();
        String property = System.getProperty("rx3.scheduler.drift-tolerance-unit", "minutes");
        if ("seconds".equalsIgnoreCase(property)) {
            j = TimeUnit.SECONDS.toNanos(longValue);
        } else if ("milliseconds".equalsIgnoreCase(property)) {
            j = TimeUnit.MILLISECONDS.toNanos(longValue);
        } else {
            j = TimeUnit.MINUTES.toNanos(longValue);
        }
        a = j;
    }

    public static long clockDriftTolerance() {
        return a;
    }

    @NonNull
    public abstract Worker createWorker();

    public long now(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable) {
        return scheduleDirect(runnable, 0, TimeUnit.NANOSECONDS);
    }

    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j, long j2, @NonNull TimeUnit timeUnit) {
        Worker createWorker = createWorker();
        b bVar = new b(RxJavaPlugins.onSchedule(runnable), createWorker);
        Disposable schedulePeriodically = createWorker.schedulePeriodically(bVar, j, j2, timeUnit);
        return schedulePeriodically == EmptyDisposable.INSTANCE ? schedulePeriodically : bVar;
    }

    public void shutdown() {
    }

    public void start() {
    }

    @NonNull
    public <S extends Scheduler & Disposable> S when(@NonNull Function<Flowable<Flowable<Completable>>, Completable> function) {
        Objects.requireNonNull(function, "combine is null");
        return new SchedulerWhen(function, this);
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
        Worker createWorker = createWorker();
        a aVar = new a(RxJavaPlugins.onSchedule(runnable), createWorker);
        createWorker.schedule(aVar, j, timeUnit);
        return aVar;
    }
}
