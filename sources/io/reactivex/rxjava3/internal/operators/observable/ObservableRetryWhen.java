package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableRetryWhen<T> extends s6.a.e.d.c.c.a<T, T> {
    public final Function<? super Observable<Throwable>, ? extends ObservableSource<?>> a;

    public static final class a<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 802743776666017014L;
        public final Observer<? super T> a;
        public final AtomicInteger b = new AtomicInteger();
        public final AtomicThrowable c = new AtomicThrowable();
        public final Subject<Throwable> d;
        public final a<T>.C0492a e = new C0492a();
        public final AtomicReference<Disposable> f = new AtomicReference<>();
        public final ObservableSource<T> g;
        public volatile boolean h;

        /* renamed from: io.reactivex.rxjava3.internal.operators.observable.ObservableRetryWhen$a$a  reason: collision with other inner class name */
        public final class C0492a extends AtomicReference<Disposable> implements Observer<Object> {
            private static final long serialVersionUID = 3254781284376480842L;

            public C0492a() {
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onComplete() {
                a aVar = a.this;
                DisposableHelper.dispose(aVar.f);
                HalfSerializer.onComplete(aVar.a, aVar, aVar.c);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onError(Throwable th) {
                a aVar = a.this;
                DisposableHelper.dispose(aVar.f);
                HalfSerializer.onError(aVar.a, th, aVar, aVar.c);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onNext(Object obj) {
                a.this.a();
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public a(Observer<? super T> observer, Subject<Throwable> subject, ObservableSource<T> observableSource) {
            this.a = observer;
            this.d = subject;
            this.g = observableSource;
        }

        public void a() {
            if (this.b.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.h) {
                        this.h = true;
                        this.g.subscribe(this);
                    }
                    if (this.b.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.f);
            DisposableHelper.dispose(this.e);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f.get());
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            DisposableHelper.dispose(this.e);
            HalfSerializer.onComplete(this.a, this, this.c);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            DisposableHelper.replace(this.f, null);
            this.h = false;
            this.d.onNext(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            HalfSerializer.onNext(this.a, t, this, this.c);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.f, disposable);
        }
    }

    public ObservableRetryWhen(ObservableSource<T> observableSource, Function<? super Observable<Throwable>, ? extends ObservableSource<?>> function) {
        super(observableSource);
        this.a = function;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Subject<T> serialized = PublishSubject.create().toSerialized();
        try {
            Object apply = this.a.apply(serialized);
            Objects.requireNonNull(apply, "The handler returned a null ObservableSource");
            ObservableSource observableSource = (ObservableSource) apply;
            a aVar = new a(observer, serialized, this.source);
            observer.onSubscribe(aVar);
            observableSource.subscribe(aVar.e);
            aVar.a();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }
}
