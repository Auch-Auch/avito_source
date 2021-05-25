package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscriber;
public final class MaybeMergeArray<T> extends Flowable<T> {
    public final MaybeSource<? extends T>[] b;

    public static final class a<T> extends ConcurrentLinkedQueue<T> implements d<T> {
        private static final long serialVersionUID = -4025173261791142821L;
        public int a;
        public final AtomicInteger b = new AtomicInteger();

        @Override // io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray.d
        public void drop() {
            poll();
        }

        @Override // io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray.d
        public int e() {
            return this.a;
        }

        @Override // io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray.d
        public int f() {
            return this.b.get();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray.d, io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            T t = (T) super.poll();
            if (t != null) {
                this.a++;
            }
            return t;
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean offer(T t) {
            this.b.getAndIncrement();
            return super.offer(t);
        }
    }

    public static final class b<T> extends BasicIntQueueSubscription<T> implements MaybeObserver<T> {
        private static final long serialVersionUID = -660395290758764731L;
        public final Subscriber<? super T> a;
        public final CompositeDisposable b = new CompositeDisposable();
        public final AtomicLong c = new AtomicLong();
        public final d<Object> d;
        public final AtomicThrowable e = new AtomicThrowable();
        public final int f;
        public volatile boolean g;
        public boolean h;
        public long i;

        public b(Subscriber<? super T> subscriber, int i2, d<Object> dVar) {
            this.a = subscriber;
            this.f = i2;
            this.d = dVar;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.g) {
                this.g = true;
                this.b.dispose();
                if (getAndIncrement() == 0) {
                    this.d.clear();
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.d.clear();
        }

        public void drain() {
            int i2;
            if (getAndIncrement() == 0) {
                int i3 = 1;
                if (this.h) {
                    Subscriber<? super T> subscriber = this.a;
                    d<Object> dVar = this.d;
                    int i4 = 1;
                    while (!this.g) {
                        Throwable th = (Throwable) this.e.get();
                        if (th != null) {
                            dVar.clear();
                            subscriber.onError(th);
                            return;
                        }
                        boolean z = dVar.f() == this.f;
                        if (!dVar.isEmpty()) {
                            subscriber.onNext(null);
                        }
                        if (z) {
                            subscriber.onComplete();
                            return;
                        }
                        i4 = addAndGet(-i4);
                        if (i4 == 0) {
                            return;
                        }
                    }
                    dVar.clear();
                    return;
                }
                Subscriber<? super T> subscriber2 = this.a;
                d<Object> dVar2 = this.d;
                long j = this.i;
                do {
                    long j2 = this.c.get();
                    while (true) {
                        i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (this.g) {
                            dVar2.clear();
                            return;
                        } else if (((Throwable) this.e.get()) != null) {
                            dVar2.clear();
                            this.e.tryTerminateConsumer(this.a);
                            return;
                        } else if (dVar2.e() == this.f) {
                            subscriber2.onComplete();
                            return;
                        } else {
                            Object poll = dVar2.poll();
                            if (poll == null) {
                                break;
                            } else if (poll != NotificationLite.COMPLETE) {
                                subscriber2.onNext(poll);
                                j++;
                            }
                        }
                    }
                    if (i2 == 0) {
                        if (((Throwable) this.e.get()) != null) {
                            dVar2.clear();
                            this.e.tryTerminateConsumer(this.a);
                            return;
                        }
                        while (dVar2.peek() == NotificationLite.COMPLETE) {
                            dVar2.drop();
                        }
                        if (dVar2.e() == this.f) {
                            subscriber2.onComplete();
                            return;
                        }
                    }
                    this.i = j;
                    i3 = addAndGet(-i3);
                } while (i3 != 0);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.d.isEmpty();
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.d.offer(NotificationLite.COMPLETE);
            drain();
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onError(Throwable th) {
            if (this.e.tryAddThrowableOrReport(th)) {
                this.b.dispose();
                this.d.offer(NotificationLite.COMPLETE);
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.b.add(disposable);
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T t) {
            this.d.offer(t);
            drain();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            T t;
            do {
                t = (T) this.d.poll();
            } while (t == NotificationLite.COMPLETE);
            return t;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.c, j);
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.h = true;
            return 2;
        }
    }

    public interface d<T> extends SimpleQueue<T> {
        void drop();

        int e();

        int f();

        T peek();

        @Override // java.util.Queue, io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray.d, io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        T poll();
    }

    public MaybeMergeArray(MaybeSource<? extends T>[] maybeSourceArr) {
        this.b = maybeSourceArr;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        d dVar;
        MaybeSource[] maybeSourceArr = this.b;
        int length = maybeSourceArr.length;
        if (length <= Flowable.bufferSize()) {
            dVar = new c(length);
        } else {
            dVar = new a();
        }
        b bVar = new b(subscriber, length, dVar);
        subscriber.onSubscribe(bVar);
        AtomicThrowable atomicThrowable = bVar.e;
        for (MaybeSource maybeSource : maybeSourceArr) {
            if (!bVar.g && atomicThrowable.get() == null) {
                maybeSource.subscribe(bVar);
            } else {
                return;
            }
        }
    }

    public static final class c<T> extends AtomicReferenceArray<T> implements d<T> {
        private static final long serialVersionUID = -7969063454040569579L;
        public final AtomicInteger a = new AtomicInteger();
        public int b;

        public c(int i) {
            super(i);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            while (poll() != null && !isEmpty()) {
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray.d
        public void drop() {
            int i = this.b;
            lazySet(i, null);
            this.b = i + 1;
        }

        @Override // io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray.d
        public int e() {
            return this.b;
        }

        @Override // io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray.d
        public int f() {
            return this.a.get();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.b == this.a.get();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean offer(T t) {
            Objects.requireNonNull(t, "value is null");
            int andIncrement = this.a.getAndIncrement();
            if (andIncrement >= length()) {
                return false;
            }
            lazySet(andIncrement, t);
            return true;
        }

        @Override // io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray.d
        public T peek() {
            int i = this.b;
            if (i == length()) {
                return null;
            }
            return (T) get(i);
        }

        @Override // io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray.d, java.util.Queue, io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            int i = this.b;
            if (i == length()) {
                return null;
            }
            AtomicInteger atomicInteger = this.a;
            do {
                T t = (T) get(i);
                if (t != null) {
                    this.b = i + 1;
                    lazySet(i, null);
                    return t;
                }
            } while (atomicInteger.get() != i);
            return null;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException();
        }
    }
}
