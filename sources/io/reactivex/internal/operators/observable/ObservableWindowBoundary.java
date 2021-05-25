package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableWindowBoundary<T, B> extends s6.a.c.b.c.a<T, Observable<T>> {
    public final ObservableSource<B> a;
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
                DisposableHelper.dispose(bVar.d);
                bVar.i = true;
                bVar.a();
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
            DisposableHelper.dispose(bVar.d);
            if (bVar.g.addThrowable(th)) {
                bVar.i = true;
                bVar.a();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(B b2) {
            if (!this.c) {
                b<T, B> bVar = this.b;
                bVar.f.offer(b.k);
                bVar.a();
            }
        }
    }

    public static final class b<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        public static final Object k = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        public final Observer<? super Observable<T>> a;
        public final int b;
        public final a<T, B> c = new a<>(this);
        public final AtomicReference<Disposable> d = new AtomicReference<>();
        public final AtomicInteger e = new AtomicInteger(1);
        public final MpscLinkedQueue<Object> f = new MpscLinkedQueue<>();
        public final AtomicThrowable g = new AtomicThrowable();
        public final AtomicBoolean h = new AtomicBoolean();
        public volatile boolean i;
        public UnicastSubject<T> j;

        public b(Observer<? super Observable<T>> observer, int i2) {
            this.a = observer;
            this.b = i2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: io.reactivex.subjects.UnicastSubject<T> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a() {
            if (getAndIncrement() == 0) {
                Observer<? super Observable<T>> observer = this.a;
                MpscLinkedQueue<Object> mpscLinkedQueue = this.f;
                AtomicThrowable atomicThrowable = this.g;
                int i2 = 1;
                while (this.e.get() != 0) {
                    UnicastSubject<T> unicastSubject = this.j;
                    boolean z = this.i;
                    if (!z || atomicThrowable.get() == null) {
                        Object poll = mpscLinkedQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate == null) {
                                if (unicastSubject != 0) {
                                    this.j = null;
                                    unicastSubject.onComplete();
                                }
                                observer.onComplete();
                                return;
                            }
                            if (unicastSubject != 0) {
                                this.j = null;
                                unicastSubject.onError(terminate);
                            }
                            observer.onError(terminate);
                            return;
                        } else if (z2) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else if (poll != k) {
                            unicastSubject.onNext(poll);
                        } else {
                            if (unicastSubject != 0) {
                                this.j = null;
                                unicastSubject.onComplete();
                            }
                            if (!this.h.get()) {
                                UnicastSubject<T> create = UnicastSubject.create(this.b, this);
                                this.j = create;
                                this.e.getAndIncrement();
                                observer.onNext(create);
                            }
                        }
                    } else {
                        mpscLinkedQueue.clear();
                        Throwable terminate2 = atomicThrowable.terminate();
                        if (unicastSubject != 0) {
                            this.j = null;
                            unicastSubject.onError(terminate2);
                        }
                        observer.onError(terminate2);
                        return;
                    }
                }
                mpscLinkedQueue.clear();
                this.j = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.h.compareAndSet(false, true)) {
                this.c.dispose();
                if (this.e.decrementAndGet() == 0) {
                    DisposableHelper.dispose(this.d);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.h.get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.c.dispose();
            this.i = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.c.dispose();
            if (this.g.addThrowable(th)) {
                this.i = true;
                a();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.f.offer(t);
            a();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this.d, disposable)) {
                this.f.offer(k);
                a();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.e.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.d);
            }
        }
    }

    public ObservableWindowBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, int i) {
        super(observableSource);
        this.a = observableSource2;
        this.b = i;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        b bVar = new b(observer, this.b);
        observer.onSubscribe(bVar);
        this.a.subscribe(bVar.c);
        this.source.subscribe(bVar);
    }
}
