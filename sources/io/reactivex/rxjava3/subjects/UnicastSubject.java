package io.reactivex.rxjava3.subjects;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
public final class UnicastSubject<T> extends Subject<T> {
    public final SpscLinkedArrayQueue<T> a;
    public final AtomicReference<Observer<? super T>> b = new AtomicReference<>();
    public final AtomicReference<Runnable> c;
    public final boolean d;
    public volatile boolean e;
    public volatile boolean f;
    public Throwable g;
    public final AtomicBoolean h = new AtomicBoolean();
    public final BasicIntQueueDisposable<T> i = new a();
    public boolean j;

    public final class a extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        public a() {
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            UnicastSubject.this.a.clear();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            if (!UnicastSubject.this.e) {
                UnicastSubject.this.e = true;
                UnicastSubject.this.e();
                UnicastSubject.this.b.lazySet(null);
                if (UnicastSubject.this.i.getAndIncrement() == 0) {
                    UnicastSubject.this.b.lazySet(null);
                    UnicastSubject unicastSubject = UnicastSubject.this;
                    if (!unicastSubject.j) {
                        unicastSubject.a.clear();
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return UnicastSubject.this.e;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return UnicastSubject.this.a.isEmpty();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            return UnicastSubject.this.a.poll();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            UnicastSubject.this.j = true;
            return 2;
        }
    }

    public UnicastSubject(int i2, Runnable runnable, boolean z) {
        this.a = new SpscLinkedArrayQueue<>(i2);
        this.c = new AtomicReference<>(runnable);
        this.d = z;
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastSubject<T> create() {
        return new UnicastSubject<>(Observable.bufferSize(), null, true);
    }

    public void e() {
        Runnable runnable = this.c.get();
        if (runnable != null && this.c.compareAndSet(runnable, null)) {
            runnable.run();
        }
    }

    public void f() {
        if (this.i.getAndIncrement() == 0) {
            Observer<? super T> observer = this.b.get();
            int i2 = 1;
            int i3 = 1;
            while (observer == null) {
                i3 = this.i.addAndGet(-i3);
                if (i3 != 0) {
                    observer = this.b.get();
                } else {
                    return;
                }
            }
            if (this.j) {
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.a;
                boolean z = !this.d;
                while (!this.e) {
                    boolean z2 = this.f;
                    if (!z || !z2 || !g(spscLinkedArrayQueue, observer)) {
                        observer.onNext(null);
                        if (z2) {
                            this.b.lazySet(null);
                            Throwable th = this.g;
                            if (th != null) {
                                observer.onError(th);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        } else {
                            i2 = this.i.addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
                this.b.lazySet(null);
                return;
            }
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue2 = this.a;
            boolean z3 = !this.d;
            boolean z4 = true;
            int i4 = 1;
            while (!this.e) {
                boolean z5 = this.f;
                T poll = this.a.poll();
                boolean z7 = poll == null;
                if (z5) {
                    if (z3 && z4) {
                        if (!g(spscLinkedArrayQueue2, observer)) {
                            z4 = false;
                        } else {
                            return;
                        }
                    }
                    if (z7) {
                        this.b.lazySet(null);
                        Throwable th2 = this.g;
                        if (th2 != null) {
                            observer.onError(th2);
                            return;
                        } else {
                            observer.onComplete();
                            return;
                        }
                    }
                }
                if (z7) {
                    i4 = this.i.addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                } else {
                    observer.onNext(poll);
                }
            }
            this.b.lazySet(null);
            spscLinkedArrayQueue2.clear();
        }
    }

    public boolean g(SimpleQueue<T> simpleQueue, Observer<? super T> observer) {
        Throwable th = this.g;
        if (th == null) {
            return false;
        }
        this.b.lazySet(null);
        simpleQueue.clear();
        observer.onError(th);
        return true;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    @Nullable
    public Throwable getThrowable() {
        if (this.f) {
            return this.g;
        }
        return null;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasComplete() {
        return this.f && this.g == null;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasObservers() {
        return this.b.get() != null;
    }

    @Override // io.reactivex.rxjava3.subjects.Subject
    @CheckReturnValue
    public boolean hasThrowable() {
        return this.f && this.g != null;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onComplete() {
        if (!this.f && !this.e) {
            this.f = true;
            e();
            f();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onError(Throwable th) {
        ExceptionHelper.nullCheck(th, "onError called with a null Throwable.");
        if (this.f || this.e) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.g = th;
        this.f = true;
        e();
        f();
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onNext(T t) {
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        if (!this.f && !this.e) {
            this.a.offer(t);
            f();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.f || this.e) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        if (this.h.get() || !this.h.compareAndSet(false, true)) {
            EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), observer);
            return;
        }
        observer.onSubscribe(this.i);
        this.b.lazySet(observer);
        if (this.e) {
            this.b.lazySet(null);
        } else {
            f();
        }
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastSubject<T> create(int i2) {
        ObjectHelper.verifyPositive(i2, "capacityHint");
        return new UnicastSubject<>(i2, null, true);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastSubject<T> create(int i2, @NonNull Runnable runnable) {
        ObjectHelper.verifyPositive(i2, "capacityHint");
        Objects.requireNonNull(runnable, "onTerminate");
        return new UnicastSubject<>(i2, runnable, true);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastSubject<T> create(int i2, @NonNull Runnable runnable, boolean z) {
        ObjectHelper.verifyPositive(i2, "capacityHint");
        Objects.requireNonNull(runnable, "onTerminate");
        return new UnicastSubject<>(i2, runnable, z);
    }

    @CheckReturnValue
    @NonNull
    public static <T> UnicastSubject<T> create(boolean z) {
        return new UnicastSubject<>(Observable.bufferSize(), null, z);
    }
}
