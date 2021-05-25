package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableMergeWithCompletable<T> extends s6.a.e.d.c.c.a<T, T> {
    public final CompletableSource a;

    public static final class a<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -4592979584110982903L;
        public final Observer<? super T> a;
        public final AtomicReference<Disposable> b = new AtomicReference<>();
        public final C0488a c = new C0488a(this);
        public final AtomicThrowable d = new AtomicThrowable();
        public volatile boolean e;
        public volatile boolean f;

        /* renamed from: io.reactivex.rxjava3.internal.operators.observable.ObservableMergeWithCompletable$a$a  reason: collision with other inner class name */
        public static final class C0488a extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -2935427570954647017L;
            public final a<?> a;

            public C0488a(a<?> aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onComplete() {
                a<?> aVar = this.a;
                aVar.f = true;
                if (aVar.e) {
                    HalfSerializer.onComplete(aVar.a, aVar, aVar.d);
                }
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onError(Throwable th) {
                a<?> aVar = this.a;
                DisposableHelper.dispose(aVar.b);
                HalfSerializer.onError(aVar.a, th, aVar, aVar.d);
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public a(Observer<? super T> observer) {
            this.a = observer;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.b);
            DisposableHelper.dispose(this.c);
            this.d.tryTerminateAndReport();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.b.get());
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.e = true;
            if (this.f) {
                HalfSerializer.onComplete(this.a, this, this.d);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.c);
            HalfSerializer.onError(this.a, th, this, this.d);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            HalfSerializer.onNext(this.a, t, this, this.d);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.b, disposable);
        }
    }

    public ObservableMergeWithCompletable(Observable<T> observable, CompletableSource completableSource) {
        super(observable);
        this.a = completableSource;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        a aVar = new a(observer);
        observer.onSubscribe(aVar);
        this.source.subscribe(aVar);
        this.a.subscribe(aVar.c);
    }
}
