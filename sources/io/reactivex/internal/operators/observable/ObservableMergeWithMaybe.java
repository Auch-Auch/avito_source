package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableMergeWithMaybe<T> extends s6.a.c.b.c.a<T, T> {
    public final MaybeSource<? extends T> a;

    public static final class a<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -4592979584110982903L;
        public final Observer<? super T> a;
        public final AtomicReference<Disposable> b = new AtomicReference<>();
        public final C0424a<T> c = new C0424a<>(this);
        public final AtomicThrowable d = new AtomicThrowable();
        public volatile SimplePlainQueue<T> e;
        public T f;
        public volatile boolean g;
        public volatile boolean h;
        public volatile int i;

        /* renamed from: io.reactivex.internal.operators.observable.ObservableMergeWithMaybe$a$a  reason: collision with other inner class name */
        public static final class C0424a<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            public final a<T> a;

            public C0424a(a<T> aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                a<T> aVar = this.a;
                aVar.i = 2;
                aVar.a();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                a<T> aVar = this.a;
                if (aVar.d.addThrowable(th)) {
                    DisposableHelper.dispose(aVar.b);
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
                    observer.onError(this.d.terminate());
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

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.g = true;
            DisposableHelper.dispose(this.b);
            DisposableHelper.dispose(this.c);
            if (getAndIncrement() == 0) {
                this.e = null;
                this.f = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.b.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.h = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.d.addThrowable(th)) {
                DisposableHelper.dispose(this.c);
                a();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
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

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.b, disposable);
        }
    }

    public ObservableMergeWithMaybe(Observable<T> observable, MaybeSource<? extends T> maybeSource) {
        super(observable);
        this.a = maybeSource;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        a aVar = new a(observer);
        observer.onSubscribe(aVar);
        this.source.subscribe(aVar);
        this.a.subscribe(aVar.c);
    }
}
