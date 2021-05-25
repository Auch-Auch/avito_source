package io.reactivex.rxjava3.internal.operators.mixed;

import androidx.appcompat.app.AppCompatDelegateImpl;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableConcatMapSingle<T, R> extends Observable<R> {
    public final ObservableSource<T> a;
    public final Function<? super T, ? extends SingleSource<? extends R>> b;
    public final ErrorMode c;
    public final int d;

    public static final class a<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -9140123220065488293L;
        public final Observer<? super R> a;
        public final Function<? super T, ? extends SingleSource<? extends R>> b;
        public final AtomicThrowable c = new AtomicThrowable();
        public final C0473a<R> d = new C0473a<>(this);
        public final SimplePlainQueue<T> e;
        public final ErrorMode f;
        public Disposable g;
        public volatile boolean h;
        public volatile boolean i;
        public R j;
        public volatile int k;

        /* renamed from: io.reactivex.rxjava3.internal.operators.mixed.ObservableConcatMapSingle$a$a  reason: collision with other inner class name */
        public static final class C0473a<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            public final a<?, R> a;

            public C0473a(a<?, R> aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onError(Throwable th) {
                a<?, R> aVar = this.a;
                if (aVar.c.tryAddThrowableOrReport(th)) {
                    if (aVar.f != ErrorMode.END) {
                        aVar.g.dispose();
                    }
                    aVar.k = 0;
                    aVar.a();
                }
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(R r) {
                a<?, R> aVar = this.a;
                aVar.j = r;
                aVar.k = 2;
                aVar.a();
            }
        }

        public a(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, int i2, ErrorMode errorMode) {
            this.a = observer;
            this.b = function;
            this.f = errorMode;
            this.e = new SpscLinkedArrayQueue(i2);
        }

        public void a() {
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.a;
                ErrorMode errorMode = this.f;
                SimplePlainQueue<T> simplePlainQueue = this.e;
                AtomicThrowable atomicThrowable = this.c;
                int i2 = 1;
                while (true) {
                    if (this.i) {
                        simplePlainQueue.clear();
                        this.j = null;
                    } else {
                        int i3 = this.k;
                        if (atomicThrowable.get() == null || !(errorMode == ErrorMode.IMMEDIATE || (errorMode == ErrorMode.BOUNDARY && i3 == 0))) {
                            boolean z = false;
                            if (i3 == 0) {
                                boolean z2 = this.h;
                                T poll = simplePlainQueue.poll();
                                if (poll == null) {
                                    z = true;
                                }
                                if (z2 && z) {
                                    atomicThrowable.tryTerminateConsumer(observer);
                                    return;
                                } else if (!z) {
                                    try {
                                        Object apply = this.b.apply(poll);
                                        Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                                        SingleSource singleSource = (SingleSource) apply;
                                        this.k = 1;
                                        singleSource.subscribe(this.d);
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        this.g.dispose();
                                        simplePlainQueue.clear();
                                        atomicThrowable.tryAddThrowableOrReport(th);
                                        atomicThrowable.tryTerminateConsumer(observer);
                                        return;
                                    }
                                }
                            } else if (i3 == 2) {
                                R r = this.j;
                                this.j = null;
                                observer.onNext(r);
                                this.k = 0;
                            }
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
                simplePlainQueue.clear();
                this.j = null;
                atomicThrowable.tryTerminateConsumer(observer);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.i = true;
            this.g.dispose();
            C0473a<R> aVar = this.d;
            Objects.requireNonNull(aVar);
            DisposableHelper.dispose(aVar);
            this.c.tryTerminateAndReport();
            if (getAndIncrement() == 0) {
                this.e.clear();
                this.j = null;
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.i;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.h = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (this.c.tryAddThrowableOrReport(th)) {
                if (this.f == ErrorMode.IMMEDIATE) {
                    C0473a<R> aVar = this.d;
                    Objects.requireNonNull(aVar);
                    DisposableHelper.dispose(aVar);
                }
                this.h = true;
                a();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            this.e.offer(t);
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.g, disposable)) {
                this.g = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapSingle(ObservableSource<T> observableSource, Function<? super T, ? extends SingleSource<? extends R>> function, ErrorMode errorMode, int i) {
        this.a = observableSource;
        this.b = function;
        this.c = errorMode;
        this.d = i;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        if (!AppCompatDelegateImpl.i.i2(this.a, this.b, observer)) {
            this.a.subscribe(new a(observer, this.b, this.d, this.c));
        }
    }
}
