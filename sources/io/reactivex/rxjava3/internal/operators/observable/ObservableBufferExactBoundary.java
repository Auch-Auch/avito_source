package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.observers.QueueDrainObserver;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.Collection;
import java.util.Objects;
public final class ObservableBufferExactBoundary<T, U extends Collection<? super T>, B> extends s6.a.e.d.c.c.a<T, U> {
    public final ObservableSource<B> a;
    public final Supplier<U> b;

    public static final class a<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {
        public final b<T, U, B> b;

        public a(b<T, U, B> bVar) {
            this.b = bVar;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.b.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            b<T, U, B> bVar = this.b;
            bVar.dispose();
            bVar.downstream.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(B b2) {
            b<T, U, B> bVar = this.b;
            Objects.requireNonNull(bVar);
            try {
                U u = bVar.b.get();
                Objects.requireNonNull(u, "The buffer supplied is null");
                U u2 = u;
                synchronized (bVar) {
                    U u3 = bVar.f;
                    if (u3 != null) {
                        bVar.f = u2;
                        bVar.fastPathEmit(u3, false, bVar);
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
        public final Supplier<U> b;
        public final ObservableSource<B> c;
        public Disposable d;
        public Disposable e;
        public U f;

        public b(Observer<? super U> observer, Supplier<U> supplier, ObservableSource<B> observableSource) {
            super(observer, new MpscLinkedQueue());
            this.b = supplier;
            this.c = observableSource;
        }

        @Override // io.reactivex.rxjava3.internal.observers.QueueDrainObserver, io.reactivex.rxjava3.internal.util.ObservableQueueDrain
        public void accept(Observer observer, Object obj) {
            this.downstream.onNext((Collection) obj);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
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

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.rxjava3.core.Observer
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

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            dispose();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            synchronized (this) {
                U u = this.f;
                if (u != null) {
                    u.add(t);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                try {
                    U u = this.b.get();
                    Objects.requireNonNull(u, "The buffer supplied is null");
                    this.f = u;
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

    public ObservableBufferExactBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Supplier<U> supplier) {
        super(observableSource);
        this.a = observableSource2;
        this.b = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super U> observer) {
        this.source.subscribe(new b(new SerializedObserver(observer), this.b, this.a));
    }
}
