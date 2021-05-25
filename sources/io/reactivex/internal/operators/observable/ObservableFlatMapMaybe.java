package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableFlatMapMaybe<T, R> extends s6.a.c.b.c.a<T, R> {
    public final Function<? super T, ? extends MaybeSource<? extends R>> a;
    public final boolean b;

    public static final class a<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8600231336733376951L;
        public final Observer<? super R> a;
        public final boolean b;
        public final CompositeDisposable c = new CompositeDisposable();
        public final AtomicInteger d = new AtomicInteger(1);
        public final AtomicThrowable e = new AtomicThrowable();
        public final Function<? super T, ? extends MaybeSource<? extends R>> f;
        public final AtomicReference<SpscLinkedArrayQueue<R>> g = new AtomicReference<>();
        public Disposable h;
        public volatile boolean i;

        /* renamed from: io.reactivex.internal.operators.observable.ObservableFlatMapMaybe$a$a  reason: collision with other inner class name */
        public final class C0421a extends AtomicReference<Disposable> implements MaybeObserver<R>, Disposable {
            private static final long serialVersionUID = -502562646270949838L;

            public C0421a() {
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                a aVar = a.this;
                aVar.c.delete(this);
                if (aVar.get() == 0) {
                    boolean z = false;
                    if (aVar.compareAndSet(0, 1)) {
                        if (aVar.d.decrementAndGet() == 0) {
                            z = true;
                        }
                        SpscLinkedArrayQueue<R> spscLinkedArrayQueue = aVar.g.get();
                        if (z && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                            Throwable terminate = aVar.e.terminate();
                            if (terminate != null) {
                                aVar.a.onError(terminate);
                                return;
                            } else {
                                aVar.a.onComplete();
                                return;
                            }
                        } else if (aVar.decrementAndGet() != 0) {
                            aVar.b();
                            return;
                        } else {
                            return;
                        }
                    }
                }
                aVar.d.decrementAndGet();
                aVar.a();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                a aVar = a.this;
                aVar.c.delete(this);
                if (aVar.e.addThrowable(th)) {
                    if (!aVar.b) {
                        aVar.h.dispose();
                        aVar.c.dispose();
                    }
                    aVar.d.decrementAndGet();
                    aVar.a();
                    return;
                }
                RxJavaPlugins.onError(th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(R r) {
                SpscLinkedArrayQueue<R> spscLinkedArrayQueue;
                a aVar = a.this;
                aVar.c.delete(this);
                if (aVar.get() == 0) {
                    boolean z = false;
                    if (aVar.compareAndSet(0, 1)) {
                        aVar.a.onNext(r);
                        if (aVar.d.decrementAndGet() == 0) {
                            z = true;
                        }
                        SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = aVar.g.get();
                        if (!z || (spscLinkedArrayQueue2 != null && !spscLinkedArrayQueue2.isEmpty())) {
                            if (aVar.decrementAndGet() == 0) {
                                return;
                            }
                            aVar.b();
                        }
                        Throwable terminate = aVar.e.terminate();
                        if (terminate != null) {
                            aVar.a.onError(terminate);
                            return;
                        } else {
                            aVar.a.onComplete();
                            return;
                        }
                    }
                }
                do {
                    spscLinkedArrayQueue = aVar.g.get();
                    if (spscLinkedArrayQueue != null) {
                        break;
                    }
                    spscLinkedArrayQueue = new SpscLinkedArrayQueue<>(Observable.bufferSize());
                } while (!aVar.g.compareAndSet(null, spscLinkedArrayQueue));
                synchronized (spscLinkedArrayQueue) {
                    spscLinkedArrayQueue.offer(r);
                }
                aVar.d.decrementAndGet();
                if (aVar.getAndIncrement() != 0) {
                    return;
                }
                aVar.b();
            }
        }

        public a(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
            this.a = observer;
            this.f = function;
            this.b = z;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        public void b() {
            Observer<? super R> observer = this.a;
            AtomicInteger atomicInteger = this.d;
            AtomicReference<SpscLinkedArrayQueue<R>> atomicReference = this.g;
            int i2 = 1;
            while (!this.i) {
                if (this.b || ((Throwable) this.e.get()) == null) {
                    boolean z = false;
                    boolean z2 = atomicInteger.get() == 0;
                    SpscLinkedArrayQueue<R> spscLinkedArrayQueue = atomicReference.get();
                    R poll = spscLinkedArrayQueue != null ? spscLinkedArrayQueue.poll() : null;
                    if (poll == null) {
                        z = true;
                    }
                    if (z2 && z) {
                        Throwable terminate = this.e.terminate();
                        if (terminate != null) {
                            observer.onError(terminate);
                            return;
                        } else {
                            observer.onComplete();
                            return;
                        }
                    } else if (z) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        observer.onNext(poll);
                    }
                } else {
                    Throwable terminate2 = this.e.terminate();
                    SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = this.g.get();
                    if (spscLinkedArrayQueue2 != null) {
                        spscLinkedArrayQueue2.clear();
                    }
                    observer.onError(terminate2);
                    return;
                }
            }
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue3 = this.g.get();
            if (spscLinkedArrayQueue3 != null) {
                spscLinkedArrayQueue3.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.i = true;
            this.h.dispose();
            this.c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.i;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.d.decrementAndGet();
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.d.decrementAndGet();
            if (this.e.addThrowable(th)) {
                if (!this.b) {
                    this.c.dispose();
                }
                a();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.f.apply(t), "The mapper returned a null MaybeSource");
                this.d.getAndIncrement();
                C0421a aVar = new C0421a();
                if (!this.i && this.c.add(aVar)) {
                    maybeSource.subscribe(aVar);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.h.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.h, disposable)) {
                this.h = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapMaybe(ObservableSource<T> observableSource, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        super(observableSource);
        this.a = function;
        this.b = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe(new a(observer, this.a, this.b));
    }
}
