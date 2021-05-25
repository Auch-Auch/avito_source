package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.observers.SerializedObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableConcatMap<T, U> extends s6.a.e.d.c.c.a<T, U> {
    public final Function<? super T, ? extends ObservableSource<? extends U>> a;
    public final int b;
    public final ErrorMode c;

    public static final class a<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -6951100001833242599L;
        public final Observer<? super R> a;
        public final Function<? super T, ? extends ObservableSource<? extends R>> b;
        public final int c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final C0479a<R> e;
        public final boolean f;
        public SimpleQueue<T> g;
        public Disposable h;
        public volatile boolean i;
        public volatile boolean j;
        public volatile boolean k;
        public int l;

        /* renamed from: io.reactivex.rxjava3.internal.operators.observable.ObservableConcatMap$a$a  reason: collision with other inner class name */
        public static final class C0479a<R> extends AtomicReference<Disposable> implements Observer<R> {
            private static final long serialVersionUID = 2620149119579502636L;
            public final Observer<? super R> a;
            public final a<?, R> b;

            public C0479a(Observer<? super R> observer, a<?, R> aVar) {
                this.a = observer;
                this.b = aVar;
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onComplete() {
                a<?, R> aVar = this.b;
                aVar.i = false;
                aVar.a();
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onError(Throwable th) {
                a<?, R> aVar = this.b;
                if (aVar.d.tryAddThrowableOrReport(th)) {
                    if (!aVar.f) {
                        aVar.h.dispose();
                    }
                    aVar.i = false;
                    aVar.a();
                }
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onNext(R r) {
                this.a.onNext(r);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public a(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, boolean z) {
            this.a = observer;
            this.b = function;
            this.c = i2;
            this.f = z;
            this.e = new C0479a<>(observer, this);
        }

        public void a() {
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.a;
                SimpleQueue<T> simpleQueue = this.g;
                AtomicThrowable atomicThrowable = this.d;
                while (true) {
                    if (!this.i) {
                        if (this.k) {
                            simpleQueue.clear();
                            return;
                        } else if (this.f || ((Throwable) atomicThrowable.get()) == null) {
                            boolean z = this.j;
                            try {
                                T poll = simpleQueue.poll();
                                boolean z2 = poll == null;
                                if (z && z2) {
                                    this.k = true;
                                    atomicThrowable.tryTerminateConsumer(observer);
                                    return;
                                } else if (!z2) {
                                    try {
                                        Object apply = this.b.apply(poll);
                                        Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                                        ObservableSource observableSource = (ObservableSource) apply;
                                        if (observableSource instanceof Supplier) {
                                            try {
                                                Object obj = (Object) ((Supplier) observableSource).get();
                                                if (obj != 0 && !this.k) {
                                                    observer.onNext(obj);
                                                }
                                            } catch (Throwable th) {
                                                Exceptions.throwIfFatal(th);
                                                atomicThrowable.tryAddThrowableOrReport(th);
                                            }
                                        } else {
                                            this.i = true;
                                            observableSource.subscribe(this.e);
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.throwIfFatal(th2);
                                        this.k = true;
                                        this.h.dispose();
                                        simpleQueue.clear();
                                        atomicThrowable.tryAddThrowableOrReport(th2);
                                        atomicThrowable.tryTerminateConsumer(observer);
                                        return;
                                    }
                                }
                            } catch (Throwable th3) {
                                Exceptions.throwIfFatal(th3);
                                this.k = true;
                                this.h.dispose();
                                atomicThrowable.tryAddThrowableOrReport(th3);
                                atomicThrowable.tryTerminateConsumer(observer);
                                return;
                            }
                        } else {
                            simpleQueue.clear();
                            this.k = true;
                            atomicThrowable.tryTerminateConsumer(observer);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.k = true;
            this.h.dispose();
            C0479a<R> aVar = this.e;
            Objects.requireNonNull(aVar);
            DisposableHelper.dispose(aVar);
            this.d.tryTerminateAndReport();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.k;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.j = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (this.d.tryAddThrowableOrReport(th)) {
                this.j = true;
                a();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (this.l == 0) {
                this.g.offer(t);
            }
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.h, disposable)) {
                this.h = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.l = requestFusion;
                        this.g = queueDisposable;
                        this.j = true;
                        this.a.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.l = requestFusion;
                        this.g = queueDisposable;
                        this.a.onSubscribe(this);
                        return;
                    }
                }
                this.g = new SpscLinkedArrayQueue(this.c);
                this.a.onSubscribe(this);
            }
        }
    }

    public static final class b<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8828587559905699186L;
        public final Observer<? super U> a;
        public final Function<? super T, ? extends ObservableSource<? extends U>> b;
        public final a<U> c;
        public final int d;
        public SimpleQueue<T> e;
        public Disposable f;
        public volatile boolean g;
        public volatile boolean h;
        public volatile boolean i;
        public int j;

        public static final class a<U> extends AtomicReference<Disposable> implements Observer<U> {
            private static final long serialVersionUID = -7449079488798789337L;
            public final Observer<? super U> a;
            public final b<?, ?> b;

            public a(Observer<? super U> observer, b<?, ?> bVar) {
                this.a = observer;
                this.b = bVar;
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onComplete() {
                b<?, ?> bVar = this.b;
                bVar.g = false;
                bVar.a();
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onError(Throwable th) {
                this.b.dispose();
                this.a.onError(th);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onNext(U u) {
                this.a.onNext(u);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public b(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, int i2) {
            this.a = observer;
            this.b = function;
            this.d = i2;
            this.c = new a<>(observer, this);
        }

        public void a() {
            if (getAndIncrement() == 0) {
                while (!this.h) {
                    if (!this.g) {
                        boolean z = this.i;
                        try {
                            T poll = this.e.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.h = true;
                                this.a.onComplete();
                                return;
                            } else if (!z2) {
                                try {
                                    Object apply = this.b.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                                    ObservableSource observableSource = (ObservableSource) apply;
                                    this.g = true;
                                    observableSource.subscribe(this.c);
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    dispose();
                                    this.e.clear();
                                    this.a.onError(th);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            dispose();
                            this.e.clear();
                            this.a.onError(th2);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.e.clear();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.h = true;
            a<U> aVar = this.c;
            Objects.requireNonNull(aVar);
            DisposableHelper.dispose(aVar);
            this.f.dispose();
            if (getAndIncrement() == 0) {
                this.e.clear();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.h;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (!this.i) {
                this.i = true;
                a();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (this.i) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.i = true;
            dispose();
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (!this.i) {
                if (this.j == 0) {
                    this.e.offer(t);
                }
                a();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.j = requestFusion;
                        this.e = queueDisposable;
                        this.i = true;
                        this.a.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.j = requestFusion;
                        this.e = queueDisposable;
                        this.a.onSubscribe(this);
                        return;
                    }
                }
                this.e = new SpscLinkedArrayQueue(this.d);
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, int i, ErrorMode errorMode) {
        super(observableSource);
        this.a = function;
        this.c = errorMode;
        this.b = Math.max(8, i);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super U> observer) {
        if (!ObservableScalarXMap.tryScalarXMapSubscribe(this.source, observer, this.a)) {
            if (this.c == ErrorMode.IMMEDIATE) {
                this.source.subscribe(new b(new SerializedObserver(observer), this.a, this.b));
            } else {
                this.source.subscribe(new a(observer, this.a, this.b, this.c == ErrorMode.END));
            }
        }
    }
}
