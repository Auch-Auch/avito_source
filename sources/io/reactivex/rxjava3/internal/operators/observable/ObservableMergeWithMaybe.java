package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableMergeWithMaybe<T> extends s6.a.e.d.c.c.a<T, T> {
    public final MaybeSource<? extends T> a;

    public static final class a<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -4592979584110982903L;
        public final Observer<? super T> a;
        public final AtomicReference<Disposable> b = new AtomicReference<>();
        public final C0489a<T> c = new C0489a<>(this);
        public final AtomicThrowable d = new AtomicThrowable();
        public volatile SimplePlainQueue<T> e;
        public T f;
        public volatile boolean g;
        public volatile boolean h;
        public volatile int i;

        /* renamed from: io.reactivex.rxjava3.internal.operators.observable.ObservableMergeWithMaybe$a$a  reason: collision with other inner class name */
        public static final class C0489a<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            public final a<T> a;

            public C0489a(a<T> aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
            public void onComplete() {
                a<T> aVar = this.a;
                aVar.i = 2;
                aVar.a();
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
            public void onError(Throwable th) {
                a<T> aVar = this.a;
                if (aVar.d.tryAddThrowableOrReport(th)) {
                    DisposableHelper.dispose(aVar.b);
                    aVar.a();
                }
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(T t) {
                a<T> aVar = this.a;
                if (aVar.compareAndSet(0, 1)) {
                    aVar.a.onNext(t);
                    aVar.i = 2;
                } else {
                    aVar.f = t;
                    aVar.i = 1;
                    if (aVar.getAndIncrement() != 0) {
                        return;
                    }
                }
                aVar.b();
            }
        }

        public a(Observer<? super T> observer) {
            this.a = observer;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        public void b() {
            Observer<? super T> observer = this.a;
            int i2 = 1;
            while (!this.g) {
                if (this.d.get() != null) {
                    this.f = null;
                    this.e = null;
                    this.d.tryTerminateConsumer(observer);
                    return;
                }
                int i3 = this.i;
                if (i3 == 1) {
                    T t = this.f;
                    this.f = null;
                    this.i = 2;
                    observer.onNext(t);
                    i3 = 2;
                }
                boolean z = this.h;
                SimplePlainQueue<T> simplePlainQueue = this.e;
                T poll = simplePlainQueue != null ? simplePlainQueue.poll() : null;
                boolean z2 = poll == null;
                if (z && z2 && i3 == 2) {
                    this.e = null;
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
            }
            this.f = null;
            this.e = null;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.g = true;
            DisposableHelper.dispose(this.b);
            DisposableHelper.dispose(this.c);
            this.d.tryTerminateAndReport();
            if (getAndIncrement() == 0) {
                this.e = null;
                this.f = null;
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.b.get());
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            this.h = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(Throwable th) {
            if (this.d.tryAddThrowableOrReport(th)) {
                DisposableHelper.dispose(this.c);
                a();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onNext(T t) {
            if (compareAndSet(0, 1)) {
                this.a.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.e;
                if (spscLinkedArrayQueue == null) {
                    spscLinkedArrayQueue = new SpscLinkedArrayQueue(Observable.bufferSize());
                    this.e = spscLinkedArrayQueue;
                }
                spscLinkedArrayQueue.offer(t);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.b, disposable);
        }
    }

    public ObservableMergeWithMaybe(Observable<T> observable, MaybeSource<? extends T> maybeSource) {
        super(observable);
        this.a = maybeSource;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        a aVar = new a(observer);
        observer.onSubscribe(aVar);
        this.source.subscribe(aVar);
        this.a.subscribe(aVar.c);
    }
}
