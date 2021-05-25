package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public final class ObservableCreate<T> extends Observable<T> {
    public final ObservableOnSubscribe<T> a;

    public static final class a<T> extends AtomicReference<Disposable> implements ObservableEmitter<T>, Disposable {
        private static final long serialVersionUID = -3434801548987643227L;
        public final Observer<? super T> a;

        public a(Observer<? super T> observer) {
            this.a = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.ObservableEmitter, io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            if (!isDisposed()) {
                try {
                    this.a.onComplete();
                } finally {
                    DisposableHelper.dispose(this);
                }
            }
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable th) {
            if (!tryOnError(th)) {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t) {
            if (t == null) {
                NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                if (!tryOnError(nullPointerException)) {
                    RxJavaPlugins.onError(nullPointerException);
                }
            } else if (!isDisposed()) {
                this.a.onNext(t);
            }
        }

        @Override // io.reactivex.ObservableEmitter
        public ObservableEmitter<T> serialize() {
            return new b(this);
        }

        @Override // io.reactivex.ObservableEmitter
        public void setCancellable(Cancellable cancellable) {
            DisposableHelper.set(this, new CancellableDisposable(cancellable));
        }

        @Override // io.reactivex.ObservableEmitter
        public void setDisposable(Disposable disposable) {
            DisposableHelper.set(this, disposable);
        }

        @Override // java.util.concurrent.atomic.AtomicReference, java.lang.Object
        public String toString() {
            return String.format("%s{%s}", a.class.getSimpleName(), super.toString());
        }

        /* JADX INFO: finally extract failed */
        @Override // io.reactivex.ObservableEmitter
        public boolean tryOnError(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.a.onError(th);
                DisposableHelper.dispose(this);
                return true;
            } catch (Throwable th2) {
                DisposableHelper.dispose(this);
                throw th2;
            }
        }
    }

    public static final class b<T> extends AtomicInteger implements ObservableEmitter<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        public final ObservableEmitter<T> a;
        public final AtomicThrowable b = new AtomicThrowable();
        public final SpscLinkedArrayQueue<T> c = new SpscLinkedArrayQueue<>(16);
        public volatile boolean d;

        public b(ObservableEmitter<T> observableEmitter) {
            this.a = observableEmitter;
        }

        public void a() {
            ObservableEmitter<T> observableEmitter = this.a;
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.c;
            AtomicThrowable atomicThrowable = this.b;
            int i = 1;
            while (!observableEmitter.isDisposed()) {
                if (atomicThrowable.get() != null) {
                    spscLinkedArrayQueue.clear();
                    observableEmitter.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z = this.d;
                T poll = spscLinkedArrayQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    observableEmitter.onComplete();
                    return;
                } else if (z2) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    observableEmitter.onNext(poll);
                }
            }
            spscLinkedArrayQueue.clear();
        }

        @Override // io.reactivex.ObservableEmitter, io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.a.isDisposed();
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            if (!this.a.isDisposed() && !this.d) {
                this.d = true;
                if (getAndIncrement() == 0) {
                    a();
                }
            }
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable th) {
            if (!tryOnError(th)) {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t) {
            if (!this.a.isDisposed() && !this.d) {
                if (t == null) {
                    NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                    if (!tryOnError(nullPointerException)) {
                        RxJavaPlugins.onError(nullPointerException);
                        return;
                    }
                    return;
                }
                if (get() != 0 || !compareAndSet(0, 1)) {
                    SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.c;
                    synchronized (spscLinkedArrayQueue) {
                        spscLinkedArrayQueue.offer(t);
                    }
                    if (getAndIncrement() != 0) {
                        return;
                    }
                } else {
                    this.a.onNext(t);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                a();
            }
        }

        @Override // io.reactivex.ObservableEmitter
        public ObservableEmitter<T> serialize() {
            return this;
        }

        @Override // io.reactivex.ObservableEmitter
        public void setCancellable(Cancellable cancellable) {
            this.a.setCancellable(cancellable);
        }

        @Override // io.reactivex.ObservableEmitter
        public void setDisposable(Disposable disposable) {
            this.a.setDisposable(disposable);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger, java.lang.Object
        public String toString() {
            return this.a.toString();
        }

        @Override // io.reactivex.ObservableEmitter
        public boolean tryOnError(Throwable th) {
            if (this.a.isDisposed() || this.d) {
                return false;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (!this.b.addThrowable(th)) {
                return false;
            }
            this.d = true;
            if (getAndIncrement() == 0) {
                a();
            }
            return true;
        }
    }

    public ObservableCreate(ObservableOnSubscribe<T> observableOnSubscribe) {
        this.a = observableOnSubscribe;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        a aVar = new a(observer);
        observer.onSubscribe(aVar);
        try {
            this.a.subscribe(aVar);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            if (!aVar.tryOnError(th)) {
                RxJavaPlugins.onError(th);
            }
        }
    }
}
