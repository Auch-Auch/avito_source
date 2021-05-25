package io.reactivex.rxjava3.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import s6.a.e.c.e;
public final class TestScheduler extends Scheduler {
    public final Queue<b> b = new PriorityBlockingQueue(11);
    public long c;
    public volatile long d;

    public static final class b implements Comparable<b> {
        public final long a;
        public final Runnable b;
        public final a c;
        public final long d;

        public b(a aVar, long j, Runnable runnable, long j2) {
            this.a = j;
            this.b = runnable;
            this.c = aVar;
            this.d = j2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(b bVar) {
            b bVar2 = bVar;
            long j = this.a;
            long j2 = bVar2.a;
            if (j == j2) {
                return Long.compare(this.d, bVar2.d);
            }
            return Long.compare(j, j2);
        }

        @Override // java.lang.Object
        public String toString() {
            return String.format("TimedRunnable(time = %d, run = %s)", Long.valueOf(this.a), this.b.toString());
        }
    }

    public TestScheduler() {
    }

    public final void a(long j) {
        while (true) {
            b peek = this.b.peek();
            if (peek == null) {
                break;
            }
            long j2 = peek.a;
            if (j2 > j) {
                break;
            }
            if (j2 == 0) {
                j2 = this.d;
            }
            this.d = j2;
            this.b.remove(peek);
            if (!peek.c.a) {
                peek.b.run();
            }
        }
        this.d = j;
    }

    public void advanceTimeBy(long j, TimeUnit timeUnit) {
        advanceTimeTo(timeUnit.toNanos(j) + this.d, TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long j, TimeUnit timeUnit) {
        a(timeUnit.toNanos(j));
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    @NonNull
    public Scheduler.Worker createWorker() {
        return new a();
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public long now(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.d, TimeUnit.NANOSECONDS);
    }

    public void triggerActions() {
        a(this.d);
    }

    public TestScheduler(long j, TimeUnit timeUnit) {
        this.d = timeUnit.toNanos(j);
    }

    public final class a extends Scheduler.Worker {
        public volatile boolean a;

        /* renamed from: io.reactivex.rxjava3.schedulers.TestScheduler$a$a  reason: collision with other inner class name */
        public final class RunnableC0503a implements Runnable {
            public final b a;

            public RunnableC0503a(b bVar) {
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                TestScheduler.this.b.remove(this.a);
            }
        }

        public a() {
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.a = true;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.a;
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public long now(@NonNull TimeUnit timeUnit) {
            return TestScheduler.this.now(timeUnit);
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j, @NonNull TimeUnit timeUnit) {
            if (this.a) {
                return EmptyDisposable.INSTANCE;
            }
            long nanos = timeUnit.toNanos(j) + TestScheduler.this.d;
            TestScheduler testScheduler = TestScheduler.this;
            long j2 = testScheduler.c;
            testScheduler.c = 1 + j2;
            b bVar = new b(this, nanos, runnable, j2);
            testScheduler.b.add(bVar);
            return new e(new RunnableC0503a(bVar));
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            if (this.a) {
                return EmptyDisposable.INSTANCE;
            }
            TestScheduler testScheduler = TestScheduler.this;
            long j = testScheduler.c;
            testScheduler.c = 1 + j;
            b bVar = new b(this, 0, runnable, j);
            testScheduler.b.add(bVar);
            return new e(new RunnableC0503a(bVar));
        }
    }
}
