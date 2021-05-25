package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableCreate<T> extends Flowable<T> {
    public final FlowableOnSubscribe<T> b;
    public final BackpressureStrategy c;

    public static abstract class a<T> extends AtomicLong implements FlowableEmitter<T>, Subscription {
        private static final long serialVersionUID = 7326289992464377023L;
        public final Subscriber<? super T> a;
        public final SequentialDisposable b = new SequentialDisposable();

        public a(Subscriber<? super T> subscriber) {
            this.a = subscriber;
        }

        public void a() {
            if (!isCancelled()) {
                try {
                    this.a.onComplete();
                } finally {
                    this.b.dispose();
                }
            }
        }

        /* JADX INFO: finally extract failed */
        public boolean b(Throwable th) {
            if (isCancelled()) {
                return false;
            }
            try {
                this.a.onError(th);
                this.b.dispose();
                return true;
            } catch (Throwable th2) {
                this.b.dispose();
                throw th2;
            }
        }

        public void c() {
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.b.dispose();
            d();
        }

        public void d() {
        }

        public boolean e(Throwable th) {
            return b(th);
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public final boolean isCancelled() {
            return this.b.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onComplete() {
            a();
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public final void onError(Throwable th) {
            if (th == null) {
                th = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
            }
            if (!e(th)) {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this, j);
                c();
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public final long requested() {
            return get();
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public final FlowableEmitter<T> serialize() {
            return new h(this);
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public final void setCancellable(Cancellable cancellable) {
            this.b.update(new CancellableDisposable(cancellable));
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public final void setDisposable(Disposable disposable) {
            this.b.update(disposable);
        }

        @Override // java.util.concurrent.atomic.AtomicLong, java.lang.Object
        public String toString() {
            return String.format("%s{%s}", getClass().getSimpleName(), super.toString());
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public final boolean tryOnError(Throwable th) {
            return e(th);
        }
    }

    public static final class b<T> extends a<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        public final SpscLinkedArrayQueue<T> c;
        public Throwable d;
        public volatile boolean e;
        public final AtomicInteger f = new AtomicInteger();

        public b(Subscriber<? super T> subscriber, int i) {
            super(subscriber);
            this.c = new SpscLinkedArrayQueue<>(i);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate.a
        public void c() {
            f();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate.a
        public void d() {
            if (this.f.getAndIncrement() == 0) {
                this.c.clear();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate.a
        public boolean e(Throwable th) {
            if (this.e || isCancelled()) {
                return false;
            }
            this.d = th;
            this.e = true;
            f();
            return true;
        }

        public void f() {
            int i;
            if (this.f.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.a;
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.c;
                int i2 = 1;
                do {
                    long j = get();
                    long j2 = 0;
                    while (true) {
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        } else if (isCancelled()) {
                            spscLinkedArrayQueue.clear();
                            return;
                        } else {
                            boolean z = this.e;
                            T poll = spscLinkedArrayQueue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                Throwable th = this.d;
                                if (th != null) {
                                    b(th);
                                    return;
                                } else {
                                    a();
                                    return;
                                }
                            } else if (z2) {
                                break;
                            } else {
                                subscriber.onNext(poll);
                                j2++;
                            }
                        }
                    }
                    if (i == 0) {
                        if (isCancelled()) {
                            spscLinkedArrayQueue.clear();
                            return;
                        }
                        boolean z3 = this.e;
                        boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                        if (z3 && isEmpty) {
                            Throwable th2 = this.d;
                            if (th2 != null) {
                                b(th2);
                                return;
                            } else {
                                a();
                                return;
                            }
                        }
                    }
                    if (j2 != 0) {
                        BackpressureHelper.produced(this, j2);
                    }
                    i2 = this.f.addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate.a, io.reactivex.rxjava3.core.Emitter
        public void onComplete() {
            this.e = true;
            f();
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onNext(T t) {
            if (!this.e && !isCancelled()) {
                if (t == null) {
                    onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
                    return;
                }
                this.c.offer(t);
                f();
            }
        }
    }

    public static final class c<T> extends g<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        public c(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate.g
        public void f() {
        }
    }

    public static final class d<T> extends g<T> {
        private static final long serialVersionUID = 338953216916120960L;

        public d(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate.g
        public void f() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    public static final class e<T> extends a<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        public final AtomicReference<T> c = new AtomicReference<>();
        public Throwable d;
        public volatile boolean e;
        public final AtomicInteger f = new AtomicInteger();

        public e(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate.a
        public void c() {
            f();
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate.a
        public void d() {
            if (this.f.getAndIncrement() == 0) {
                this.c.lazySet(null);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate.a
        public boolean e(Throwable th) {
            if (this.e || isCancelled()) {
                return false;
            }
            this.d = th;
            this.e = true;
            f();
            return true;
        }

        public void f() {
            boolean z;
            int i;
            if (this.f.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.a;
                AtomicReference<T> atomicReference = this.c;
                int i2 = 1;
                do {
                    long j = get();
                    long j2 = 0;
                    while (true) {
                        z = false;
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        } else if (isCancelled()) {
                            atomicReference.lazySet(null);
                            return;
                        } else {
                            boolean z2 = this.e;
                            T andSet = atomicReference.getAndSet(null);
                            boolean z3 = andSet == null;
                            if (z2 && z3) {
                                Throwable th = this.d;
                                if (th != null) {
                                    b(th);
                                    return;
                                } else {
                                    a();
                                    return;
                                }
                            } else if (z3) {
                                break;
                            } else {
                                subscriber.onNext(andSet);
                                j2++;
                            }
                        }
                    }
                    if (i == 0) {
                        if (isCancelled()) {
                            atomicReference.lazySet(null);
                            return;
                        }
                        boolean z4 = this.e;
                        if (atomicReference.get() == null) {
                            z = true;
                        }
                        if (z4 && z) {
                            Throwable th2 = this.d;
                            if (th2 != null) {
                                b(th2);
                                return;
                            } else {
                                a();
                                return;
                            }
                        }
                    }
                    if (j2 != 0) {
                        BackpressureHelper.produced(this, j2);
                    }
                    i2 = this.f.addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate.a, io.reactivex.rxjava3.core.Emitter
        public void onComplete() {
            this.e = true;
            f();
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onNext(T t) {
            if (!this.e && !isCancelled()) {
                if (t == null) {
                    onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
                    return;
                }
                this.c.set(t);
                f();
            }
        }
    }

    public static final class f<T> extends a<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        public f(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onNext(T t) {
            long j;
            if (!isCancelled()) {
                if (t != null) {
                    this.a.onNext(t);
                    do {
                        j = get();
                        if (j == 0) {
                            return;
                        }
                    } while (!compareAndSet(j, j - 1));
                    return;
                }
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
            }
        }
    }

    public static abstract class g<T> extends a<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        public g(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public abstract void f();

        @Override // io.reactivex.rxjava3.core.Emitter
        public final void onNext(T t) {
            if (!isCancelled()) {
                if (t == null) {
                    onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
                } else if (get() != 0) {
                    this.a.onNext(t);
                    BackpressureHelper.produced(this, 1);
                } else {
                    f();
                }
            }
        }
    }

    public static final class h<T> extends AtomicInteger implements FlowableEmitter<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        public final a<T> a;
        public final AtomicThrowable b = new AtomicThrowable();
        public final SimplePlainQueue<T> c = new SpscLinkedArrayQueue(16);
        public volatile boolean d;

        public h(a<T> aVar) {
            this.a = aVar;
        }

        public void a() {
            a<T> aVar = this.a;
            SimplePlainQueue<T> simplePlainQueue = this.c;
            AtomicThrowable atomicThrowable = this.b;
            int i = 1;
            while (!aVar.isCancelled()) {
                if (atomicThrowable.get() != null) {
                    simplePlainQueue.clear();
                    atomicThrowable.tryTerminateConsumer(aVar);
                    return;
                }
                boolean z = this.d;
                T poll = simplePlainQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    aVar.onComplete();
                    return;
                } else if (z2) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    aVar.onNext(poll);
                }
            }
            simplePlainQueue.clear();
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public boolean isCancelled() {
            return this.a.isCancelled();
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onComplete() {
            if (!this.a.isCancelled() && !this.d) {
                this.d = true;
                if (getAndIncrement() == 0) {
                    a();
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onError(Throwable th) {
            if (!tryOnError(th)) {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onNext(T t) {
            if (!this.a.isCancelled() && !this.d) {
                if (t == null) {
                    onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
                    return;
                }
                if (get() != 0 || !compareAndSet(0, 1)) {
                    SimplePlainQueue<T> simplePlainQueue = this.c;
                    synchronized (simplePlainQueue) {
                        simplePlainQueue.offer(t);
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

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public long requested() {
            return this.a.get();
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public FlowableEmitter<T> serialize() {
            return this;
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public void setCancellable(Cancellable cancellable) {
            a<T> aVar = this.a;
            Objects.requireNonNull(aVar);
            aVar.b.update(new CancellableDisposable(cancellable));
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public void setDisposable(Disposable disposable) {
            this.a.b.update(disposable);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger, java.lang.Object
        public String toString() {
            return this.a.toString();
        }

        @Override // io.reactivex.rxjava3.core.FlowableEmitter
        public boolean tryOnError(Throwable th) {
            if (this.a.isCancelled() || this.d) {
                return false;
            }
            if (th == null) {
                th = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
            }
            if (!this.b.tryAddThrowable(th)) {
                return false;
            }
            this.d = true;
            if (getAndIncrement() == 0) {
                a();
            }
            return true;
        }
    }

    public FlowableCreate(FlowableOnSubscribe<T> flowableOnSubscribe, BackpressureStrategy backpressureStrategy) {
        this.b = flowableOnSubscribe;
        this.c = backpressureStrategy;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar;
        int ordinal = this.c.ordinal();
        if (ordinal == 0) {
            aVar = new f(subscriber);
        } else if (ordinal == 1) {
            aVar = new d(subscriber);
        } else if (ordinal == 3) {
            aVar = new c(subscriber);
        } else if (ordinal != 4) {
            aVar = new b(subscriber, Flowable.bufferSize());
        } else {
            aVar = new e(subscriber);
        }
        subscriber.onSubscribe(aVar);
        try {
            this.b.subscribe(aVar);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            aVar.onError(th);
        }
    }
}
