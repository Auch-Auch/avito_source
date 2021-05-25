package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableWindowBoundarySupplier<T, B> extends s6.a.c.b.c.a<T, Observable<T>> {
    public final Callable<? extends ObservableSource<B>> a;
    public final int b;

    public static final class a<T, B> extends DisposableObserver<B> {
        public final b<T, B> b;
        public boolean c;

        public a(b<T, B> bVar) {
            this.b = bVar;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.c) {
                this.c = true;
                b<T, B> bVar = this.b;
                bVar.i.dispose();
                bVar.j = true;
                bVar.b();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.c) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.c = true;
            b<T, B> bVar = this.b;
            bVar.i.dispose();
            if (bVar.f.addThrowable(th)) {
                bVar.j = true;
                bVar.b();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(B b2) {
            if (!this.c) {
                this.c = true;
                dispose();
                b<T, B> bVar = this.b;
                bVar.c.compareAndSet(this, null);
                bVar.e.offer(b.m);
                bVar.b();
            }
        }
    }

    public static final class b<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        public static final a<Object, Object> l = new a<>(null);
        public static final Object m = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        public final Observer<? super Observable<T>> a;
        public final int b;
        public final AtomicReference<a<T, B>> c = new AtomicReference<>();
        public final AtomicInteger d = new AtomicInteger(1);
        public final MpscLinkedQueue<Object> e = new MpscLinkedQueue<>();
        public final AtomicThrowable f = new AtomicThrowable();
        public final AtomicBoolean g = new AtomicBoolean();
        public final Callable<? extends ObservableSource<B>> h;
        public Disposable i;
        public volatile boolean j;
        public UnicastSubject<T> k;

        public b(Observer<? super Observable<T>> observer, int i2, Callable<? extends ObservableSource<B>> callable) {
            this.a = observer;
            this.b = i2;
            this.h = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier$a<T, B>> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a() {
            a<Object, Object> aVar = l;
            Disposable disposable = (Disposable) this.c.getAndSet(aVar);
            if (disposable != null && disposable != aVar) {
                disposable.dispose();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: io.reactivex.subjects.UnicastSubject<T> */
        /* JADX WARN: Multi-variable type inference failed */
        public void b() {
            if (getAndIncrement() == 0) {
                Observer<? super Observable<T>> observer = this.a;
                MpscLinkedQueue<Object> mpscLinkedQueue = this.e;
                AtomicThrowable atomicThrowable = this.f;
                int i2 = 1;
                while (this.d.get() != 0) {
                    UnicastSubject<T> unicastSubject = this.k;
                    boolean z = this.j;
                    if (!z || atomicThrowable.get() == null) {
                        Object poll = mpscLinkedQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate == null) {
                                if (unicastSubject != 0) {
                                    this.k = null;
                                    unicastSubject.onComplete();
                                }
                                observer.onComplete();
                                return;
                            }
                            if (unicastSubject != 0) {
                                this.k = null;
                                unicastSubject.onError(terminate);
                            }
                            observer.onError(terminate);
                            return;
                        } else if (z2) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else if (poll != m) {
                            unicastSubject.onNext(poll);
                        } else {
                            if (unicastSubject != 0) {
                                this.k = null;
                                unicastSubject.onComplete();
                            }
                            if (!this.g.get()) {
                                UnicastSubject<T> create = UnicastSubject.create(this.b, this);
                                this.k = create;
                                this.d.getAndIncrement();
                                try {
                                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.h.call(), "The other Callable returned a null ObservableSource");
                                    a<T, B> aVar = new a<>(this);
                                    if (this.c.compareAndSet(null, aVar)) {
                                        observableSource.subscribe(aVar);
                                        observer.onNext(create);
                                    }
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    atomicThrowable.addThrowable(th);
                                    this.j = true;
                                }
                            }
                        }
                    } else {
                        mpscLinkedQueue.clear();
                        Throwable terminate2 = atomicThrowable.terminate();
                        if (unicastSubject != 0) {
                            this.k = null;
                            unicastSubject.onError(terminate2);
                        }
                        observer.onError(terminate2);
                        return;
                    }
                }
                mpscLinkedQueue.clear();
                this.k = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.g.compareAndSet(false, true)) {
                a();
                if (this.d.decrementAndGet() == 0) {
                    this.i.dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.g.get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            a();
            this.j = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            a();
            if (this.f.addThrowable(th)) {
                this.j = true;
                b();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.e.offer(t);
            b();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.i, disposable)) {
                this.i = disposable;
                this.a.onSubscribe(this);
                this.e.offer(m);
                b();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.d.decrementAndGet() == 0) {
                this.i.dispose();
            }
        }
    }

    public ObservableWindowBoundarySupplier(ObservableSource<T> observableSource, Callable<? extends ObservableSource<B>> callable, int i) {
        super(observableSource);
        this.a = callable;
        this.b = i;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        this.source.subscribe(new b(observer, this.b, this.a));
    }
}
