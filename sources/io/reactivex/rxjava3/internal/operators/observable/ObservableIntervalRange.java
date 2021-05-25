package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableIntervalRange extends Observable<Long> {
    public final Scheduler a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final TimeUnit f;

    public static final class a extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 1891866368734007884L;
        public final Observer<? super Long> a;
        public final long b;
        public long c;

        public a(Observer<? super Long> observer, long j, long j2) {
            this.a = observer;
            this.c = j;
            this.b = j2;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!isDisposed()) {
                long j = this.c;
                this.a.onNext(Long.valueOf(j));
                if (j == this.b) {
                    if (!isDisposed()) {
                        this.a.onComplete();
                    }
                    DisposableHelper.dispose(this);
                    return;
                }
                this.c = j + 1;
            }
        }
    }

    public ObservableIntervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, Scheduler scheduler) {
        this.d = j3;
        this.e = j4;
        this.f = timeUnit;
        this.a = scheduler;
        this.b = j;
        this.c = j2;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Long> observer) {
        a aVar = new a(observer, this.b, this.c);
        observer.onSubscribe(aVar);
        Scheduler scheduler = this.a;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker createWorker = scheduler.createWorker();
            DisposableHelper.setOnce(aVar, createWorker);
            createWorker.schedulePeriodically(aVar, this.d, this.e, this.f);
            return;
        }
        DisposableHelper.setOnce(aVar, scheduler.schedulePeriodicallyDirect(aVar, this.d, this.e, this.f));
    }
}
