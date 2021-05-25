package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableFlatMapSingle<T, R> extends s6.a.e.d.c.c.a<T, R> {
    public final Function<? super T, ? extends SingleSource<? extends R>> a;
    public final boolean b;

    public static final class a<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8600231336733376951L;
        public final Observer<? super R> a;
        public final boolean b;
        public final CompositeDisposable c = new CompositeDisposable();
        public final AtomicInteger d = new AtomicInteger(1);
        public final AtomicThrowable e = new AtomicThrowable();
        public final Function<? super T, ? extends SingleSource<? extends R>> f;
        public final AtomicReference<SpscLinkedArrayQueue<R>> g = new AtomicReference<>();
        public Disposable h;
        public volatile boolean i;

        /* renamed from: io.reactivex.rxjava3.internal.operators.observable.ObservableFlatMapSingle$a$a  reason: collision with other inner class name */
        public final class C0487a extends AtomicReference<Disposable> implements SingleObserver<R>, Disposable {
            private static final long serialVersionUID = -502562646270949838L;

            public C0487a() {
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onError(Throwable th) {
                a aVar = a.this;
                aVar.c.delete(this);
                if (aVar.e.tryAddThrowableOrReport(th)) {
                    if (!aVar.b) {
                        aVar.h.dispose();
                        aVar.c.dispose();
                    }
                    aVar.d.decrementAndGet();
                    aVar.a();
                }
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(R r) {
                a aVar = a.this;
                aVar.c.delete(this);
                if (aVar.get() == 0) {
                    boolean z = false;
                    if (aVar.compareAndSet(0, 1)) {
                        aVar.a.onNext(r);
                        if (aVar.d.decrementAndGet() == 0) {
                            z = true;
                        }
                        SpscLinkedArrayQueue<R> spscLinkedArrayQueue = aVar.g.get();
                        if (!z || (spscLinkedArrayQueue != null && !spscLinkedArrayQueue.isEmpty())) {
                            if (aVar.decrementAndGet() == 0) {
                                return;
                            }
                            aVar.b();
                        }
                        aVar.e.tryTerminateConsumer(aVar.a);
                        return;
                    }
                }
                SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = aVar.g.get();
                if (spscLinkedArrayQueue2 == null) {
                    spscLinkedArrayQueue2 = new SpscLinkedArrayQueue<>(Observable.bufferSize());
                    if (!aVar.g.compareAndSet(null, spscLinkedArrayQueue2)) {
                        spscLinkedArrayQueue2 = aVar.g.get();
                    }
                }
                synchronized (spscLinkedArrayQueue2) {
                    spscLinkedArrayQueue2.offer(r);
                }
                aVar.d.decrementAndGet();
                if (aVar.getAndIncrement() != 0) {
                    return;
                }
                aVar.b();
            }
        }

        public a(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
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
                        this.e.tryTerminateConsumer(this.a);
                        return;
                    } else if (z) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        observer.onNext(poll);
                    }
                } else {
                    SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = this.g.get();
                    if (spscLinkedArrayQueue2 != null) {
                        spscLinkedArrayQueue2.clear();
                    }
                    this.e.tryTerminateConsumer(observer);
                    return;
                }
            }
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue3 = this.g.get();
            if (spscLinkedArrayQueue3 != null) {
                spscLinkedArrayQueue3.clear();
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.i = true;
            this.h.dispose();
            this.c.dispose();
            this.e.tryTerminateAndReport();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.i;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.d.decrementAndGet();
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            this.d.decrementAndGet();
            if (this.e.tryAddThrowableOrReport(th)) {
                if (!this.b) {
                    this.c.dispose();
                }
                a();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            try {
                Object apply = this.f.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                SingleSource singleSource = (SingleSource) apply;
                this.d.getAndIncrement();
                C0487a aVar = new C0487a();
                if (!this.i && this.c.add(aVar)) {
                    singleSource.subscribe(aVar);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.h.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.h, disposable)) {
                this.h = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapSingle(ObservableSource<T> observableSource, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        super(observableSource);
        this.a = function;
        this.b = z;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        this.source.subscribe(new a(observer, this.a, this.b));
    }
}
