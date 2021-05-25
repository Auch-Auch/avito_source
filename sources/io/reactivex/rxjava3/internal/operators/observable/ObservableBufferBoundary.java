package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends s6.a.e.d.c.c.a<T, U> {
    public final Supplier<U> a;
    public final ObservableSource<? extends Open> b;
    public final Function<? super Open, ? extends ObservableSource<? extends Close>> c;

    public static final class a<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -8466418554264089604L;
        public final Observer<? super C> a;
        public final Supplier<C> b;
        public final ObservableSource<? extends Open> c;
        public final Function<? super Open, ? extends ObservableSource<? extends Close>> d;
        public final CompositeDisposable e = new CompositeDisposable();
        public final AtomicReference<Disposable> f = new AtomicReference<>();
        public final AtomicThrowable g = new AtomicThrowable();
        public volatile boolean h;
        public final SpscLinkedArrayQueue<C> i = new SpscLinkedArrayQueue<>(Observable.bufferSize());
        public volatile boolean j;
        public long k;
        public Map<Long, C> l = new LinkedHashMap();

        /* renamed from: io.reactivex.rxjava3.internal.operators.observable.ObservableBufferBoundary$a$a  reason: collision with other inner class name */
        public static final class C0478a<Open> extends AtomicReference<Disposable> implements Observer<Open>, Disposable {
            private static final long serialVersionUID = -8498650778633225126L;
            public final a<?, ?, Open, ?> a;

            public C0478a(a<?, ?, Open, ?> aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public boolean isDisposed() {
                return get() == DisposableHelper.DISPOSED;
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onComplete() {
                lazySet(DisposableHelper.DISPOSED);
                a<?, ?, Open, ?> aVar = this.a;
                aVar.e.delete(this);
                if (aVar.e.size() == 0) {
                    DisposableHelper.dispose(aVar.f);
                    aVar.h = true;
                    aVar.b();
                }
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onError(Throwable th) {
                lazySet(DisposableHelper.DISPOSED);
                a<?, ?, Open, ?> aVar = this.a;
                DisposableHelper.dispose(aVar.f);
                aVar.e.delete(this);
                aVar.onError(th);
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onNext(Open open) {
                a<?, ?, Open, ?> aVar = this.a;
                Objects.requireNonNull(aVar);
                try {
                    C c = aVar.b.get();
                    Objects.requireNonNull(c, "The bufferSupplier returned a null Collection");
                    C c2 = c;
                    Object apply = aVar.d.apply(open);
                    Objects.requireNonNull(apply, "The bufferClose returned a null ObservableSource");
                    ObservableSource observableSource = (ObservableSource) apply;
                    long j = aVar.k;
                    aVar.k = 1 + j;
                    synchronized (aVar) {
                        Map<Long, C> map = aVar.l;
                        if (map != null) {
                            map.put(Long.valueOf(j), c2);
                            b bVar = new b(aVar, j);
                            aVar.e.add(bVar);
                            observableSource.subscribe(bVar);
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    DisposableHelper.dispose(aVar.f);
                    aVar.onError(th);
                }
            }

            @Override // io.reactivex.rxjava3.core.Observer
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public a(Observer<? super C> observer, ObservableSource<? extends Open> observableSource, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Supplier<C> supplier) {
            this.a = observer;
            this.b = supplier;
            this.c = observableSource;
            this.d = function;
        }

        public void a(b<T, C> bVar, long j2) {
            boolean z;
            this.e.delete(bVar);
            if (this.e.size() == 0) {
                DisposableHelper.dispose(this.f);
                z = true;
            } else {
                z = false;
            }
            synchronized (this) {
                Map<Long, C> map = this.l;
                if (map != null) {
                    this.i.offer(map.remove(Long.valueOf(j2)));
                } else {
                    return;
                }
            }
            if (z) {
                this.h = true;
            }
            b();
        }

        public void b() {
            if (getAndIncrement() == 0) {
                Observer<? super C> observer = this.a;
                SpscLinkedArrayQueue<C> spscLinkedArrayQueue = this.i;
                int i2 = 1;
                while (!this.j) {
                    boolean z = this.h;
                    if (!z || this.g.get() == null) {
                        C poll = spscLinkedArrayQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            observer.onComplete();
                            return;
                        } else if (z2) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else {
                            observer.onNext(poll);
                        }
                    } else {
                        spscLinkedArrayQueue.clear();
                        this.g.tryTerminateConsumer(observer);
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (DisposableHelper.dispose(this.f)) {
                this.j = true;
                this.e.dispose();
                synchronized (this) {
                    this.l = null;
                }
                if (getAndIncrement() != 0) {
                    this.i.clear();
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f.get());
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.e.dispose();
            synchronized (this) {
                Map<Long, C> map = this.l;
                if (map != null) {
                    for (C c2 : map.values()) {
                        this.i.offer(c2);
                    }
                    this.l = null;
                    this.h = true;
                    b();
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (this.g.tryAddThrowableOrReport(th)) {
                this.e.dispose();
                synchronized (this) {
                    this.l = null;
                }
                this.h = true;
                b();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            synchronized (this) {
                Map<Long, C> map = this.l;
                if (map != null) {
                    for (C c2 : map.values()) {
                        c2.add(t);
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this.f, disposable)) {
                C0478a aVar = new C0478a(this);
                this.e.add(aVar);
                this.c.subscribe(aVar);
            }
        }
    }

    public static final class b<T, C extends Collection<? super T>> extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = -8498650778633225126L;
        public final a<T, C, ?, ?> a;
        public final long b;

        public b(a<T, C, ?, ?> aVar, long j) {
            this.a = aVar;
            this.b = j;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.a.a(this, this.b);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                a<T, C, ?, ?> aVar = this.a;
                DisposableHelper.dispose(aVar.f);
                aVar.e.delete(this);
                aVar.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(Object obj) {
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                lazySet(disposableHelper);
                disposable.dispose();
                this.a.a(this, this.b);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableBufferBoundary(ObservableSource<T> observableSource, ObservableSource<? extends Open> observableSource2, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Supplier<U> supplier) {
        super(observableSource);
        this.b = observableSource2;
        this.c = function;
        this.a = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super U> observer) {
        a aVar = new a(observer, this.b, this.c, this.a);
        observer.onSubscribe(aVar);
        this.source.subscribe(aVar);
    }
}
