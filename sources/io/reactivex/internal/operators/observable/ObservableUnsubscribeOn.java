package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
public final class ObservableUnsubscribeOn<T> extends s6.a.c.b.c.a<T, T> {
    public final Scheduler a;

    public static final class a<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1015244841293359600L;
        public final Observer<? super T> a;
        public final Scheduler b;
        public Disposable c;

        /* renamed from: io.reactivex.internal.operators.observable.ObservableUnsubscribeOn$a$a  reason: collision with other inner class name */
        public final class RunnableC0429a implements Runnable {
            public RunnableC0429a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c.dispose();
            }
        }

        public a(Observer<? super T> observer, Scheduler scheduler) {
            this.a = observer;
            this.b = scheduler;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.b.scheduleDirect(new RunnableC0429a());
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!get()) {
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (get()) {
                RxJavaPlugins.onError(th);
            } else {
                this.a.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (!get()) {
                this.a.onNext(t);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableUnsubscribeOn(ObservableSource<T> observableSource, Scheduler scheduler) {
        super(observableSource);
        this.a = scheduler;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new a(observer, this.a));
    }
}
