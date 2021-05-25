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
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableWindowBoundarySelector<T, B, V> extends s6.a.c.b.c.a<T, Observable<T>> {
    public final ObservableSource<B> a;
    public final Function<? super B, ? extends ObservableSource<V>> b;
    public final int c;

    public static final class a<T, V> extends DisposableObserver<V> {
        public final c<T, ?, V> b;
        public final UnicastSubject<T> c;
        public boolean d;

        public a(c<T, ?, V> cVar, UnicastSubject<T> unicastSubject) {
            this.b = cVar;
            this.c = unicastSubject;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.d) {
                this.d = true;
                c<T, ?, V> cVar = this.b;
                cVar.e.delete(this);
                cVar.queue.offer((U) new d(this.c, null));
                if (cVar.enter()) {
                    cVar.a();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.d = true;
            c<T, ?, V> cVar = this.b;
            cVar.f.dispose();
            cVar.e.dispose();
            cVar.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(V v) {
            dispose();
            onComplete();
        }
    }

    public static final class b<T, B> extends DisposableObserver<B> {
        public final c<T, B, ?> b;

        public b(c<T, B, ?> cVar) {
            this.b = cVar;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.b.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            c<T, B, ?> cVar = this.b;
            cVar.f.dispose();
            cVar.e.dispose();
            cVar.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(B b2) {
            c<T, B, ?> cVar = this.b;
            cVar.queue.offer((U) new d(null, b2));
            if (cVar.enter()) {
                cVar.a();
            }
        }
    }

    public static final class c<T, B, V> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {
        public final ObservableSource<B> b;
        public final Function<? super B, ? extends ObservableSource<V>> c;
        public final int d;
        public final CompositeDisposable e;
        public Disposable f;
        public final AtomicReference<Disposable> g = new AtomicReference<>();
        public final List<UnicastSubject<T>> h;
        public final AtomicLong i;
        public final AtomicBoolean j;

        public c(Observer<? super Observable<T>> observer, ObservableSource<B> observableSource, Function<? super B, ? extends ObservableSource<V>> function, int i2) {
            super(observer, new MpscLinkedQueue());
            AtomicLong atomicLong = new AtomicLong();
            this.i = atomicLong;
            this.j = new AtomicBoolean();
            this.b = observableSource;
            this.c = function;
            this.d = i2;
            this.e = new CompositeDisposable();
            this.h = new ArrayList();
            atomicLong.lazySet(1);
        }

        public void a() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.queue;
            Observer<? super V> observer = this.downstream;
            List<UnicastSubject<T>> list = this.h;
            int i2 = 1;
            while (true) {
                boolean z = this.done;
                Object poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    this.e.dispose();
                    DisposableHelper.dispose(this.g);
                    Throwable th = this.error;
                    if (th != null) {
                        for (UnicastSubject<T> unicastSubject : list) {
                            unicastSubject.onError(th);
                        }
                    } else {
                        for (UnicastSubject<T> unicastSubject2 : list) {
                            unicastSubject2.onComplete();
                        }
                    }
                    list.clear();
                    return;
                } else if (z2) {
                    i2 = leave(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else if (poll instanceof d) {
                    d dVar = (d) poll;
                    UnicastSubject<T> unicastSubject3 = dVar.a;
                    if (unicastSubject3 != null) {
                        if (list.remove(unicastSubject3)) {
                            dVar.a.onComplete();
                            if (this.i.decrementAndGet() == 0) {
                                this.e.dispose();
                                DisposableHelper.dispose(this.g);
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.j.get()) {
                        UnicastSubject<T> create = UnicastSubject.create(this.d);
                        list.add(create);
                        observer.onNext(create);
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.c.apply(dVar.b), "The ObservableSource supplied is null");
                            a aVar = new a(this, create);
                            if (this.e.add(aVar)) {
                                this.i.getAndIncrement();
                                observableSource.subscribe(aVar);
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.j.set(true);
                            observer.onError(th2);
                        }
                    }
                } else {
                    for (UnicastSubject<T> unicastSubject4 : list) {
                        unicastSubject4.onNext((T) NotificationLite.getValue(poll));
                    }
                }
            }
        }

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public void accept(Observer<? super Observable<T>> observer, Object obj) {
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.j.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.g);
                if (this.i.decrementAndGet() == 0) {
                    this.f.dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.j.get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                if (enter()) {
                    a();
                }
                if (this.i.decrementAndGet() == 0) {
                    this.e.dispose();
                }
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            if (enter()) {
                a();
            }
            if (this.i.decrementAndGet() == 0) {
                this.e.dispose();
            }
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (fastEnter()) {
                for (UnicastSubject<T> unicastSubject : this.h) {
                    unicastSubject.onNext(t);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer((U) NotificationLite.next(t));
                if (!enter()) {
                    return;
                }
            }
            a();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                this.downstream.onSubscribe(this);
                if (!this.j.get()) {
                    b bVar = new b(this);
                    if (this.g.compareAndSet(null, bVar)) {
                        this.b.subscribe(bVar);
                    }
                }
            }
        }
    }

    public static final class d<T, B> {
        public final UnicastSubject<T> a;
        public final B b;

        public d(UnicastSubject<T> unicastSubject, B b2) {
            this.a = unicastSubject;
            this.b = b2;
        }
    }

    public ObservableWindowBoundarySelector(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Function<? super B, ? extends ObservableSource<V>> function, int i) {
        super(observableSource);
        this.a = observableSource2;
        this.b = function;
        this.c = i;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        this.source.subscribe(new c(new SerializedObserver(observer), this.a, this.b, this.c));
    }
}
