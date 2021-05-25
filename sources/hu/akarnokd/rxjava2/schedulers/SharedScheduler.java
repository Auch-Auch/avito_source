package hu.akarnokd.rxjava2.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
public final class SharedScheduler extends Scheduler {
    public final Scheduler.Worker b;

    public static final class a extends Scheduler.Worker {
        public final Scheduler.Worker a;
        public final CompositeDisposable b = new CompositeDisposable();

        /* renamed from: hu.akarnokd.rxjava2.schedulers.SharedScheduler$a$a  reason: collision with other inner class name */
        public static final class RunnableC0369a extends AtomicReference<DisposableContainer> implements Runnable, Disposable {
            private static final long serialVersionUID = 4949851341419870956L;
            public final AtomicReference<Disposable> a = new AtomicReference<>();
            public final Runnable b;

            public RunnableC0369a(Runnable runnable, DisposableContainer disposableContainer) {
                this.b = runnable;
                lazySet(disposableContainer);
            }

            public void a() {
                Disposable disposable;
                DisposableContainer disposableContainer = (DisposableContainer) get();
                if (disposableContainer != null && compareAndSet(disposableContainer, null)) {
                    disposableContainer.delete(this);
                }
                do {
                    disposable = this.a.get();
                    if (disposable == DisposableHelper.DISPOSED) {
                        return;
                    }
                } while (!this.a.compareAndSet(disposable, this));
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableContainer disposableContainer = (DisposableContainer) getAndSet(null);
                if (disposableContainer != null) {
                    disposableContainer.delete(this);
                }
                DisposableHelper.dispose(this.a);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return get() == null;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.b.run();
                } finally {
                    a();
                }
            }
        }

        public a(Scheduler.Worker worker) {
            this.a = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // io.reactivex.Scheduler.Worker
        public long now(TimeUnit timeUnit) {
            return this.a.now(timeUnit);
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            Disposable disposable;
            if (isDisposed() || this.a.isDisposed()) {
                return Disposables.disposed();
            }
            RunnableC0369a aVar = new RunnableC0369a(runnable, this.b);
            this.b.add(aVar);
            if (j <= 0) {
                disposable = this.a.schedule(aVar);
            } else {
                disposable = this.a.schedule(aVar, j, timeUnit);
            }
            Disposable disposable2 = aVar.a.get();
            if (disposable2 != aVar) {
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (disposable2 == disposableHelper) {
                    disposable.dispose();
                } else if (!aVar.a.compareAndSet(disposable2, disposable) && aVar.a.get() == disposableHelper) {
                    disposable.dispose();
                }
            }
            return aVar;
        }
    }

    public SharedScheduler(Scheduler scheduler) {
        this.b = scheduler.createWorker();
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        return new a(this.b);
    }

    @Override // io.reactivex.Scheduler
    public long now(TimeUnit timeUnit) {
        return this.b.now(timeUnit);
    }

    @Override // io.reactivex.Scheduler
    public Disposable scheduleDirect(Runnable runnable) {
        return this.b.schedule(runnable);
    }

    @Override // io.reactivex.Scheduler
    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.b.schedulePeriodically(runnable, j, j2, timeUnit);
    }

    @Override // io.reactivex.Scheduler
    public void shutdown() {
        this.b.dispose();
    }

    @Override // io.reactivex.Scheduler
    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.b.schedule(runnable, j, timeUnit);
    }

    public SharedScheduler(Scheduler.Worker worker) {
        this.b = worker;
    }
}
