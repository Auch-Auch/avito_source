package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
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
public final class ObservableConcatMapScheduler<T, U> extends s6.a.e.d.c.c.a<T, U> {
    public final Function<? super T, ? extends ObservableSource<? extends U>> a;
    public final int b;
    public final ErrorMode c;
    public final Scheduler d;

    public static final class a<T, R> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -6951100001833242599L;
        public final Observer<? super R> a;
        public final Function<? super T, ? extends ObservableSource<? extends R>> b;
        public final int c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final C0480a<R> e;
        public final boolean f;
        public final Scheduler.Worker g;
        public SimpleQueue<T> h;
        public Disposable i;
        public volatile boolean j;
        public volatile boolean k;
        public volatile boolean l;
        public int m;

        /* renamed from: io.reactivex.rxjava3.internal.operators.observable.ObservableConcatMapScheduler$a$a  reason: collision with other inner class name */
        public static final class C0480a<R> extends AtomicReference<Disposable> implements Observer<R> {
            private static final long serialVersionUID = 2620149119579502636L;
            public final Observer<? super R> a;
            public final a<?, R> b;

            public C0480a(Observer<? super R> observer, a<?, R> aVar) {
                this.a = observer;
                this.b = aVar;
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onComplete() {
                a<?, R> aVar = this.b;
                aVar.j = false;
                aVar.a();
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onError(Throwable th) {
                a<?, R> aVar = this.b;
                if (aVar.d.tryAddThrowableOrReport(th)) {
                    if (!aVar.f) {
                        aVar.i.dispose();
                    }
                    aVar.j = false;
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

        public a(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, boolean z, Scheduler.Worker worker) {
            this.a = observer;
            this.b = function;
            this.c = i2;
            this.f = z;
            this.e = new C0480a<>(observer, this);
            this.g = worker;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                this.g.schedule(this);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.l = true;
            this.i.dispose();
            C0480a<R> aVar = this.e;
            Objects.requireNonNull(aVar);
            DisposableHelper.dispose(aVar);
            this.g.dispose();
            this.d.tryTerminateAndReport();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.l;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.k = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (this.d.tryAddThrowableOrReport(th)) {
                this.k = true;
                a();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (this.m == 0) {
                this.h.offer(t);
            }
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.i, disposable)) {
                this.i = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.m = requestFusion;
                        this.h = queueDisposable;
                        this.k = true;
                        this.a.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.m = requestFusion;
                        this.h = queueDisposable;
                        this.a.onSubscribe(this);
                        return;
                    }
                }
                this.h = new SpscLinkedArrayQueue(this.c);
                this.a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Observer<? super R> observer = this.a;
            SimpleQueue<T> simpleQueue = this.h;
            AtomicThrowable atomicThrowable = this.d;
            while (true) {
                if (!this.j) {
                    if (this.l) {
                        simpleQueue.clear();
                        return;
                    } else if (this.f || ((Throwable) atomicThrowable.get()) == null) {
                        boolean z = this.k;
                        try {
                            T poll = simpleQueue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.l = true;
                                atomicThrowable.tryTerminateConsumer(observer);
                                this.g.dispose();
                                return;
                            } else if (!z2) {
                                try {
                                    Object apply = this.b.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                                    ObservableSource observableSource = (ObservableSource) apply;
                                    if (observableSource instanceof Supplier) {
                                        try {
                                            Object obj = (Object) ((Supplier) observableSource).get();
                                            if (obj != 0 && !this.l) {
                                                observer.onNext(obj);
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.throwIfFatal(th);
                                            atomicThrowable.tryAddThrowableOrReport(th);
                                        }
                                    } else {
                                        this.j = true;
                                        observableSource.subscribe(this.e);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    this.l = true;
                                    this.i.dispose();
                                    simpleQueue.clear();
                                    atomicThrowable.tryAddThrowableOrReport(th2);
                                    atomicThrowable.tryTerminateConsumer(observer);
                                    this.g.dispose();
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            this.l = true;
                            this.i.dispose();
                            atomicThrowable.tryAddThrowableOrReport(th3);
                            atomicThrowable.tryTerminateConsumer(observer);
                            this.g.dispose();
                            return;
                        }
                    } else {
                        simpleQueue.clear();
                        this.l = true;
                        atomicThrowable.tryTerminateConsumer(observer);
                        this.g.dispose();
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public static final class b<T, U> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 8828587559905699186L;
        public final Observer<? super U> a;
        public final Function<? super T, ? extends ObservableSource<? extends U>> b;
        public final a<U> c;
        public final int d;
        public final Scheduler.Worker e;
        public SimpleQueue<T> f;
        public Disposable g;
        public volatile boolean h;
        public volatile boolean i;
        public volatile boolean j;
        public int k;

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
                bVar.h = false;
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

        public b(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, int i2, Scheduler.Worker worker) {
            this.a = observer;
            this.b = function;
            this.d = i2;
            this.c = new a<>(observer, this);
            this.e = worker;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                this.e.schedule(this);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.i = true;
            a<U> aVar = this.c;
            Objects.requireNonNull(aVar);
            DisposableHelper.dispose(aVar);
            this.g.dispose();
            this.e.dispose();
            if (getAndIncrement() == 0) {
                this.f.clear();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.i;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (!this.j) {
                this.j = true;
                a();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (this.j) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.j = true;
            dispose();
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (!this.j) {
                if (this.k == 0) {
                    this.f.offer(t);
                }
                a();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.g, disposable)) {
                this.g = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.k = requestFusion;
                        this.f = queueDisposable;
                        this.j = true;
                        this.a.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.k = requestFusion;
                        this.f = queueDisposable;
                        this.a.onSubscribe(this);
                        return;
                    }
                }
                this.f = new SpscLinkedArrayQueue(this.d);
                this.a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.i) {
                if (!this.h) {
                    boolean z = this.j;
                    try {
                        T poll = this.f.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.i = true;
                            this.a.onComplete();
                            this.e.dispose();
                            return;
                        } else if (!z2) {
                            try {
                                Object apply = this.b.apply(poll);
                                Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                                ObservableSource observableSource = (ObservableSource) apply;
                                this.h = true;
                                observableSource.subscribe(this.c);
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                dispose();
                                this.f.clear();
                                this.a.onError(th);
                                this.e.dispose();
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        dispose();
                        this.f.clear();
                        this.a.onError(th2);
                        this.e.dispose();
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.f.clear();
        }
    }

    public ObservableConcatMapScheduler(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, int i, ErrorMode errorMode, Scheduler scheduler) {
        super(observableSource);
        this.a = function;
        this.c = errorMode;
        this.b = Math.max(8, i);
        this.d = scheduler;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super U> observer) {
        if (this.c == ErrorMode.IMMEDIATE) {
            this.source.subscribe(new b(new SerializedObserver(observer), this.a, this.b, this.d.createWorker()));
        } else {
            this.source.subscribe(new a(observer, this.a, this.b, this.c == ErrorMode.END, this.d.createWorker()));
        }
    }
}
