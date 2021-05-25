package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import s6.a.e.c.e;
public final class TrampolineScheduler extends Scheduler {
    public static final TrampolineScheduler b = new TrampolineScheduler();

    public static final class a implements Runnable {
        public final Runnable a;
        public final c b;
        public final long c;

        public a(Runnable runnable, c cVar, long j) {
            this.a = runnable;
            this.b = cVar;
            this.c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.b.d) {
                long now = this.b.now(TimeUnit.MILLISECONDS);
                long j = this.c;
                if (j > now) {
                    try {
                        Thread.sleep(j - now);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        RxJavaPlugins.onError(e);
                        return;
                    }
                }
                if (!this.b.d) {
                    this.a.run();
                }
            }
        }
    }

    public static final class b implements Comparable<b> {
        public final Runnable a;
        public final long b;
        public final int c;
        public volatile boolean d;

        public b(Runnable runnable, Long l, int i) {
            this.a = runnable;
            this.b = l.longValue();
            this.c = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(b bVar) {
            b bVar2 = bVar;
            int compare = Long.compare(this.b, bVar2.b);
            return compare == 0 ? Integer.compare(this.c, bVar2.c) : compare;
        }
    }

    public static final class c extends Scheduler.Worker implements Disposable {
        public final PriorityBlockingQueue<b> a = new PriorityBlockingQueue<>();
        public final AtomicInteger b = new AtomicInteger();
        public final AtomicInteger c = new AtomicInteger();
        public volatile boolean d;

        public final class a implements Runnable {
            public final b a;

            public a(b bVar) {
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.d = true;
                c.this.a.remove(this.a);
            }
        }

        public Disposable a(Runnable runnable, long j) {
            if (this.d) {
                return EmptyDisposable.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.c.incrementAndGet());
            this.a.add(bVar);
            if (this.b.getAndIncrement() != 0) {
                return new e(new a(bVar));
            }
            int i = 1;
            while (!this.d) {
                b poll = this.a.poll();
                if (poll == null) {
                    i = this.b.addAndGet(-i);
                    if (i == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!poll.d) {
                    poll.a.run();
                }
            }
            this.a.clear();
            return EmptyDisposable.INSTANCE;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.d = true;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            return a(runnable, now(TimeUnit.MILLISECONDS));
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            long millis = timeUnit.toMillis(j) + now(TimeUnit.MILLISECONDS);
            return a(new a(runnable, this, millis), millis);
        }
    }

    public static TrampolineScheduler instance() {
        return b;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return new c();
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable) {
        RxJavaPlugins.onSchedule(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            RxJavaPlugins.onSchedule(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            RxJavaPlugins.onError(e);
        }
        return EmptyDisposable.INSTANCE;
    }
}
