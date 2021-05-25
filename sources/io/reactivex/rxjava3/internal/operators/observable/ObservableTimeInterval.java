package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.concurrent.TimeUnit;
public final class ObservableTimeInterval<T> extends s6.a.e.d.c.c.a<T, Timed<T>> {
    public final Scheduler a;
    public final TimeUnit b;

    public static final class a<T> implements Observer<T>, Disposable {
        public final Observer<? super Timed<T>> a;
        public final TimeUnit b;
        public final Scheduler c;
        public long d;
        public Disposable e;

        public a(Observer<? super Timed<T>> observer, TimeUnit timeUnit, Scheduler scheduler) {
            this.a = observer;
            this.c = scheduler;
            this.b = timeUnit;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.e.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.e.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            long now = this.c.now(this.b);
            long j = this.d;
            this.d = now;
            this.a.onNext(new Timed(t, now - j, this.b));
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.d = this.c.now(this.b);
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableTimeInterval(ObservableSource<T> observableSource, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.a = scheduler;
        this.b = timeUnit;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Timed<T>> observer) {
        this.source.subscribe(new a(observer, this.b, this.a));
    }
}
