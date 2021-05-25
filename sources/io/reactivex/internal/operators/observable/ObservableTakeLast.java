package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;
public final class ObservableTakeLast<T> extends s6.a.c.b.c.a<T, T> {
    public final int a;

    public static final class a<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = 7240042530241604978L;
        public final Observer<? super T> a;
        public final int b;
        public Disposable c;
        public volatile boolean d;

        public a(Observer<? super T> observer, int i) {
            this.a = observer;
            this.b = i;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.d) {
                this.d = true;
                this.c.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Observer<? super T> observer = this.a;
            while (!this.d) {
                Object obj = (Object) poll();
                if (obj != 0) {
                    observer.onNext(obj);
                } else if (!this.d) {
                    observer.onComplete();
                    return;
                } else {
                    return;
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.b == size()) {
                poll();
            }
            offer(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLast(ObservableSource<T> observableSource, int i) {
        super(observableSource);
        this.a = i;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new a(observer, this.a));
    }
}
