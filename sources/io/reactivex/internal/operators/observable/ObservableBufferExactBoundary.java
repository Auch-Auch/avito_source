package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.Callable;
public final class ObservableBufferExactBoundary<T, U extends Collection<? super T>, B> extends s6.a.c.b.c.a<T, U> {
    public final ObservableSource<B> a;
    public final Callable<U> b;

    public static final class a<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {
        public final b<T, U, B> b;

        public a(b<T, U, B> bVar) {
            this.b = bVar;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.b.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            b<T, U, B> bVar = this.b;
            bVar.dispose();
            bVar.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(B b2) {
            b<T, U, B> bVar = this.b;
            Objects.requireNonNull(bVar);
            try {
                U u = (U) ((Collection) ObjectHelper.requireNonNull(bVar.b.call(), "The buffer supplied is null"));
                synchronized (bVar) {
                    U u2 = bVar.f;
                    if (u2 != null) {
                        bVar.f = u;
                        bVar.fastPathEmit(u2, false, bVar);
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                bVar.dispose();
                bVar.downstream.onError(th);
            }
        }
    }

    public static final class b<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Observer<T>, Disposable {
        public final Callable<U> b;
        public final ObservableSource<B> c;
        public Disposable d;
        public Disposable e;
        public U f;

        public b(Observer<? super U> observer, Callable<U> callable, ObservableSource<B> observableSource) {
            super(observer, new MpscLinkedQueue());
            this.b = callable;
            this.c = observableSource;
        }

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public void accept(Observer observer, Object obj) {
            this.downstream.onNext((Collection) obj);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.e.dispose();
                this.d.dispose();
                if (enter()) {
                    this.queue.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.f;
                if (u != null) {
                    this.f = null;
                } else {
                    return;
                }
            }
            this.queue.offer(u);
            this.done = true;
            if (enter()) {
                QueueDrainHelper.drainLoop(this.queue, this.downstream, false, this, this);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            dispose();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            synchronized (this) {
                U u = this.f;
                if (u != null) {
                    u.add(t);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                try {
                    this.f = (U) ((Collection) ObjectHelper.requireNonNull(this.b.call(), "The buffer supplied is null"));
                    a aVar = new a(this);
                    this.e = aVar;
                    this.downstream.onSubscribe(this);
                    if (!this.cancelled) {
                        this.c.subscribe(aVar);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.cancelled = true;
                    disposable.dispose();
                    EmptyDisposable.error(th, this.downstream);
                }
            }
        }
    }

    public ObservableBufferExactBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Callable<U> callable) {
        super(observableSource);
        this.a = observableSource2;
        this.b = callable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> observer) {
        this.source.subscribe(new b(new SerializedObserver(observer), this.b, this.a));
    }
}
