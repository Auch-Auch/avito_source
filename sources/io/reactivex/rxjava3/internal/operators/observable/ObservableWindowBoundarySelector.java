package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableWindowBoundarySelector<T, B, V> extends s6.a.e.d.c.c.a<T, Observable<T>> {
    public final ObservableSource<B> a;
    public final Function<? super B, ? extends ObservableSource<V>> b;
    public final int c;

    public static final class a<T, B, V> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 8646217640096099753L;
        public final Observer<? super Observable<T>> a;
        public final ObservableSource<B> b;
        public final Function<? super B, ? extends ObservableSource<V>> c;
        public final int d;
        public final CompositeDisposable e;
        public final c<B> f;
        public final List<UnicastSubject<T>> g;
        public final SimplePlainQueue<Object> h = new MpscLinkedQueue();
        public final AtomicLong i;
        public final AtomicBoolean j;
        public volatile boolean k;
        public volatile boolean l;
        public volatile boolean m;
        public final AtomicThrowable n;
        public Disposable o;

        /* renamed from: io.reactivex.rxjava3.internal.operators.observable.ObservableWindowBoundarySelector$a$a  reason: collision with other inner class name */
        public static final class C0495a<T, V> extends Observable<T> implements Observer<V>, Disposable {
            public final a<T, ?, V> a;
            public final UnicastSubject<T> b;
            public final AtomicReference<Disposable> c = new AtomicReference<>();
            public final AtomicBoolean d = new AtomicBoolean();

            public C0495a(a<T, ?, V> aVar, UnicastSubject<T> unicastSubject) {
                this.a = aVar;
                this.b = unicastSubject;
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this.c);
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public boolean isDisposed() {
                return this.c.get() == DisposableHelper.DISPOSED;
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onComplete() {
                a<T, ?, V> aVar = this.a;
                aVar.h.offer(this);
                aVar.a();
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onError(Throwable th) {
                if (isDisposed()) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                a<T, ?, V> aVar = this.a;
                aVar.o.dispose();
                c<B> cVar = aVar.f;
                Objects.requireNonNull(cVar);
                DisposableHelper.dispose(cVar);
                aVar.e.dispose();
                if (aVar.n.tryAddThrowableOrReport(th)) {
                    aVar.l = true;
                    aVar.a();
                }
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onNext(V v) {
                if (DisposableHelper.dispose(this.c)) {
                    a<T, ?, V> aVar = this.a;
                    aVar.h.offer(this);
                    aVar.a();
                }
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this.c, disposable);
            }

            @Override // io.reactivex.rxjava3.core.Observable
            public void subscribeActual(Observer<? super T> observer) {
                this.b.subscribe(observer);
                this.d.set(true);
            }
        }

        public static final class b<B> {
            public final B a;

            public b(B b) {
                this.a = b;
            }
        }

        public static final class c<B> extends AtomicReference<Disposable> implements Observer<B> {
            private static final long serialVersionUID = -3326496781427702834L;
            public final a<?, B, ?> a;

            public c(a<?, B, ?> aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onComplete() {
                a<?, B, ?> aVar = this.a;
                aVar.m = true;
                aVar.a();
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onError(Throwable th) {
                a<?, B, ?> aVar = this.a;
                aVar.o.dispose();
                aVar.e.dispose();
                if (aVar.n.tryAddThrowableOrReport(th)) {
                    aVar.l = true;
                    aVar.a();
                }
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onNext(B b) {
                a<?, B, ?> aVar = this.a;
                aVar.h.offer(new b(b));
                aVar.a();
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public a(Observer<? super Observable<T>> observer, ObservableSource<B> observableSource, Function<? super B, ? extends ObservableSource<V>> function, int i2) {
            this.a = observer;
            this.b = observableSource;
            this.c = function;
            this.d = i2;
            this.e = new CompositeDisposable();
            this.g = new ArrayList();
            this.i = new AtomicLong(1);
            this.j = new AtomicBoolean();
            this.n = new AtomicThrowable();
            this.f = new c<>(this);
            new AtomicLong();
        }

        public void a() {
            if (getAndIncrement() == 0) {
                Observer<? super Observable<T>> observer = this.a;
                SimplePlainQueue<Object> simplePlainQueue = this.h;
                List<UnicastSubject<T>> list = this.g;
                int i2 = 1;
                while (true) {
                    if (this.k) {
                        simplePlainQueue.clear();
                        list.clear();
                    } else {
                        boolean z = this.l;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = false;
                        boolean z3 = poll == null;
                        if (z && (z3 || this.n.get() != null)) {
                            b(observer);
                            this.k = true;
                        } else if (!z3) {
                            if (poll instanceof b) {
                                if (!this.j.get()) {
                                    try {
                                        Object apply = this.c.apply(((b) poll).a);
                                        Objects.requireNonNull(apply, "The closingIndicator returned a null ObservableSource");
                                        ObservableSource observableSource = (ObservableSource) apply;
                                        this.i.getAndIncrement();
                                        UnicastSubject<T> create = UnicastSubject.create(this.d, this);
                                        C0495a aVar = new C0495a(this, create);
                                        observer.onNext(aVar);
                                        if (!aVar.d.get() && aVar.d.compareAndSet(false, true)) {
                                            z2 = true;
                                        }
                                        if (z2) {
                                            create.onComplete();
                                        } else {
                                            list.add(create);
                                            this.e.add(aVar);
                                            observableSource.subscribe(aVar);
                                        }
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        this.o.dispose();
                                        c<B> cVar = this.f;
                                        Objects.requireNonNull(cVar);
                                        DisposableHelper.dispose(cVar);
                                        this.e.dispose();
                                        Exceptions.throwIfFatal(th);
                                        this.n.tryAddThrowableOrReport(th);
                                        this.l = true;
                                    }
                                }
                            } else if (poll instanceof C0495a) {
                                UnicastSubject<T> unicastSubject = ((C0495a) poll).b;
                                list.remove(unicastSubject);
                                this.e.delete((Disposable) poll);
                                unicastSubject.onComplete();
                            } else {
                                for (UnicastSubject<T> unicastSubject2 : list) {
                                    unicastSubject2.onNext(poll);
                                }
                            }
                        } else if (this.m && list.size() == 0) {
                            this.o.dispose();
                            c<B> cVar2 = this.f;
                            Objects.requireNonNull(cVar2);
                            DisposableHelper.dispose(cVar2);
                            this.e.dispose();
                            b(observer);
                            this.k = true;
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        public void b(Observer<?> observer) {
            Throwable terminate = this.n.terminate();
            if (terminate == null) {
                for (UnicastSubject<T> unicastSubject : this.g) {
                    unicastSubject.onComplete();
                }
                observer.onComplete();
            } else if (terminate != ExceptionHelper.TERMINATED) {
                for (UnicastSubject<T> unicastSubject2 : this.g) {
                    unicastSubject2.onError(terminate);
                }
                observer.onError(terminate);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (!this.j.compareAndSet(false, true)) {
                return;
            }
            if (this.i.decrementAndGet() == 0) {
                this.o.dispose();
                c<B> cVar = this.f;
                Objects.requireNonNull(cVar);
                DisposableHelper.dispose(cVar);
                this.e.dispose();
                this.n.tryTerminateAndReport();
                this.k = true;
                a();
                return;
            }
            c<B> cVar2 = this.f;
            Objects.requireNonNull(cVar2);
            DisposableHelper.dispose(cVar2);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.j.get();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            c<B> cVar = this.f;
            Objects.requireNonNull(cVar);
            DisposableHelper.dispose(cVar);
            this.e.dispose();
            this.l = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            c<B> cVar = this.f;
            Objects.requireNonNull(cVar);
            DisposableHelper.dispose(cVar);
            this.e.dispose();
            if (this.n.tryAddThrowableOrReport(th)) {
                this.l = true;
                a();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            this.h.offer(t);
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.o, disposable)) {
                this.o = disposable;
                this.a.onSubscribe(this);
                this.b.subscribe(this.f);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.i.decrementAndGet() == 0) {
                this.o.dispose();
                c<B> cVar = this.f;
                Objects.requireNonNull(cVar);
                DisposableHelper.dispose(cVar);
                this.e.dispose();
                this.n.tryTerminateAndReport();
                this.k = true;
                a();
            }
        }
    }

    public ObservableWindowBoundarySelector(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Function<? super B, ? extends ObservableSource<V>> function, int i) {
        super(observableSource);
        this.a = observableSource2;
        this.b = function;
        this.c = i;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        this.source.subscribe(new a(observer, this.a, this.b, this.c));
    }
}
