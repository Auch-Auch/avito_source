package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends s6.a.c.b.c.a<T, U> {
    public final Callable<U> a;
    public final ObservableSource<? extends Open> b;
    public final Function<? super Open, ? extends ObservableSource<? extends Close>> c;

    public static final class a<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -8466418554264089604L;
        public final Observer<? super C> a;
        public final Callable<C> b;
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

        /* renamed from: io.reactivex.internal.operators.observable.ObservableBufferBoundary$a$a  reason: collision with other inner class name */
        public static final class C0414a<Open> extends AtomicReference<Disposable> implements Observer<Open>, Disposable {
            private static final long serialVersionUID = -8498650778633225126L;
            public final a<?, ?, Open, ?> a;

            public C0414a(a<?, ?, Open, ?> aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return get() == DisposableHelper.DISPOSED;
            }

            @Override // io.reactivex.Observer
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

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                lazySet(DisposableHelper.DISPOSED);
                a<?, ?, Open, ?> aVar = this.a;
                DisposableHelper.dispose(aVar.f);
                aVar.e.delete(this);
                aVar.onError(th);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: java.util.Map<java.lang.Long, C extends java.util.Collection<? super T>> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.Observer
            public void onNext(Open open) {
                a<?, ?, Open, ?> aVar = this.a;
                Objects.requireNonNull(aVar);
                try {
                    Collection collection = (Collection) ObjectHelper.requireNonNull(aVar.b.call(), "The bufferSupplier returned a null Collection");
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(aVar.d.apply(open), "The bufferClose returned a null ObservableSource");
                    long j = aVar.k;
                    aVar.k = 1 + j;
                    synchronized (aVar) {
                        Map<Long, C> map = aVar.l;
                        if (map != 0) {
                            map.put(Long.valueOf(j), collection);
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

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public a(Observer<? super C> observer, ObservableSource<? extends Open> observableSource, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Callable<C> callable) {
            this.a = observer;
            this.b = callable;
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
                        observer.onError(this.g.terminate());
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
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

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f.get());
        }

        @Override // io.reactivex.Observer
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

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.g.addThrowable(th)) {
                this.e.dispose();
                synchronized (this) {
                    this.l = null;
                }
                this.h = true;
                b();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
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

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this.f, disposable)) {
                C0414a aVar = new C0414a(this);
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

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.a.a(this, this.b);
            }
        }

        @Override // io.reactivex.Observer
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

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                lazySet(disposableHelper);
                disposable.dispose();
                this.a.a(this, this.b);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableBufferBoundary(ObservableSource<T> observableSource, ObservableSource<? extends Open> observableSource2, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Callable<U> callable) {
        super(observableSource);
        this.b = observableSource2;
        this.c = function;
        this.a = callable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> observer) {
        a aVar = new a(observer, this.b, this.c, this.a);
        observer.onSubscribe(aVar);
        this.source.subscribe(aVar);
    }
}
