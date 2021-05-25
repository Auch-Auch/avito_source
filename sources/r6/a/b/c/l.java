package r6.a.b.c;

import io.reactivex.Scheduler;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.TimeUnit;
public final class l extends Scheduler {
    public final io.reactivex.Scheduler b;

    public static final class a extends Scheduler.Worker {
        public final Scheduler.Worker a;

        public a(Scheduler.Worker worker) {
            this.a = worker;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.a.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.a.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public long now(TimeUnit timeUnit) {
            return this.a.now(timeUnit);
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public Disposable schedule(Runnable runnable) {
            return c.a(this.a.schedule(runnable));
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public Disposable schedulePeriodically(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            return c.a(this.a.schedulePeriodically(runnable, j, j2, timeUnit));
        }

        @Override // io.reactivex.rxjava3.core.Scheduler.Worker
        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            return c.a(this.a.schedule(runnable, j, timeUnit));
        }
    }

    public l(io.reactivex.Scheduler scheduler) {
        this.b = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Scheduler.Worker createWorker() {
        return new a(this.b.createWorker());
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public long now(TimeUnit timeUnit) {
        return this.b.now(timeUnit);
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Disposable scheduleDirect(Runnable runnable) {
        return c.a(this.b.scheduleDirect(runnable));
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return c.a(this.b.schedulePeriodicallyDirect(runnable, j, j2, timeUnit));
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public void shutdown() {
        this.b.shutdown();
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public void start() {
        this.b.start();
    }

    @Override // io.reactivex.rxjava3.core.Scheduler
    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        return c.a(this.b.scheduleDirect(runnable, j, timeUnit));
    }
}
