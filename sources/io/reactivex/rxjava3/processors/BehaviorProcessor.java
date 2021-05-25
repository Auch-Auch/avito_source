package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class BehaviorProcessor<T> extends FlowableProcessor<T> {
    public static final Object[] i = new Object[0];
    public static final a[] j = new a[0];
    public static final a[] k = new a[0];
    public final AtomicReference<a<T>[]> b;
    public final ReadWriteLock c;
    public final Lock d;
    public final Lock e;
    public final AtomicReference<Object> f = new AtomicReference<>();
    public final AtomicReference<Throwable> g;
    public long h;

    public static final class a<T> extends AtomicLong implements Subscription, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
        private static final long serialVersionUID = 3293175281126227086L;
        public final Subscriber<? super T> a;
        public final BehaviorProcessor<T> b;
        public boolean c;
        public boolean d;
        public AppendOnlyLinkedArrayList<Object> e;
        public boolean f;
        public volatile boolean g;
        public long h;

        public a(Subscriber<? super T> subscriber, BehaviorProcessor<T> behaviorProcessor) {
            this.a = subscriber;
            this.b = behaviorProcessor;
        }

        public void a(Object obj, long j) {
            if (!this.g) {
                if (!this.f) {
                    synchronized (this) {
                        if (!this.g) {
                            if (this.h != j) {
                                if (this.d) {
                                    AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.e;
                                    if (appendOnlyLinkedArrayList == null) {
                                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                                        this.e = appendOnlyLinkedArrayList;
                                    }
                                    appendOnlyLinkedArrayList.add(obj);
                                    return;
                                }
                                this.c = true;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    this.f = true;
                }
                test(obj);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.g) {
                this.g = true;
                this.b.f(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this, j);
            }
        }

        @Override // io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.rxjava3.functions.Predicate
        public boolean test(Object obj) {
            if (this.g) {
                return true;
            }
            if (NotificationLite.isComplete(obj)) {
                this.a.onComplete();
                return true;
            } else if (NotificationLite.isError(obj)) {
                this.a.onError(NotificationLite.getError(obj));
                return true;
            } else {
                long j = get();
                if (j != 0) {
                    this.a.onNext((Object) NotificationLite.getValue(obj));
                    if (j == Long.MAX_VALUE) {
                        return false;
                    }
                    decrementAndGet();
                    return false;
                }
                cancel();
                this.a.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                return true;
            }
        }
    }

    public BehaviorProcessor() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.c = reentrantReadWriteLock;
        this.d = reentrantReadWriteLock.readLock();
        this.e = reentrantReadWriteLock.writeLock();
        this.b = new AtomicReference<>(j);
        this.g = new AtomicReference<>();
    }

    @CheckReturnValue
    @NonNull
    public static <T> BehaviorProcessor<T> create() {
        return new BehaviorProcessor<>();
    }

    @CheckReturnValue
    @NonNull
    public static <T> BehaviorProcessor<T> createDefault(T t) {
        Objects.requireNonNull(t, "defaultValue is null");
        BehaviorProcessor<T> behaviorProcessor = new BehaviorProcessor<>();
        behaviorProcessor.f.lazySet(t);
        return behaviorProcessor;
    }

    public void f(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.b.get();
            int length = aVarArr.length;
            if (length != 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (aVarArr[i2] == aVar) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        aVarArr2 = j;
                    } else {
                        a<T>[] aVarArr3 = new a[(length - 1)];
                        System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                        System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                        aVarArr2 = aVarArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.b.compareAndSet(aVarArr, aVarArr2));
    }

    public void g(Object obj) {
        Lock lock = this.e;
        lock.lock();
        this.h++;
        this.f.lazySet(obj);
        lock.unlock();
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    @Nullable
    public Throwable getThrowable() {
        Object obj = this.f.get();
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    @CheckReturnValue
    @Nullable
    public T getValue() {
        Object obj = this.f.get();
        if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            return null;
        }
        return (T) NotificationLite.getValue(obj);
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasComplete() {
        return NotificationLite.isComplete(this.f.get());
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasSubscribers() {
        return this.b.get().length != 0;
    }

    @Override // io.reactivex.rxjava3.processors.FlowableProcessor
    @CheckReturnValue
    public boolean hasThrowable() {
        return NotificationLite.isError(this.f.get());
    }

    @CheckReturnValue
    public boolean hasValue() {
        Object obj = this.f.get();
        return obj != null && !NotificationLite.isComplete(obj) && !NotificationLite.isError(obj);
    }

    @CheckReturnValue
    public boolean offer(@NonNull T t) {
        ExceptionHelper.nullCheck(t, "offer called with a null value.");
        a<T>[] aVarArr = this.b.get();
        int length = aVarArr.length;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 < length) {
                if (aVarArr[i2].get() != 0) {
                    z = false;
                }
                if (z) {
                    return false;
                }
                i2++;
            } else {
                Object next = NotificationLite.next(t);
                g(next);
                for (a<T> aVar : aVarArr) {
                    aVar.a(next, this.h);
                }
                return true;
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.g.compareAndSet(null, ExceptionHelper.TERMINATED)) {
            Object complete = NotificationLite.complete();
            g(complete);
            for (a<T> aVar : this.b.getAndSet(k)) {
                aVar.a(complete, this.h);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(@NonNull Throwable th) {
        ExceptionHelper.nullCheck(th, "onError called with a null Throwable.");
        if (!this.g.compareAndSet(null, th)) {
            RxJavaPlugins.onError(th);
            return;
        }
        Object error = NotificationLite.error(th);
        g(error);
        for (a<T> aVar : this.b.getAndSet(k)) {
            aVar.a(error, this.h);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(@NonNull T t) {
        ExceptionHelper.nullCheck(t, "onNext called with a null value.");
        if (this.g.get() == null) {
            Object next = NotificationLite.next(t);
            g(next);
            for (a<T> aVar : this.b.get()) {
                aVar.a(next, this.h);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(@NonNull Subscription subscription) {
        if (this.g.get() != null) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(@NonNull Subscriber<? super T> subscriber) {
        boolean z;
        Object obj;
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        a<T> aVar = new a<>(subscriber, this);
        subscriber.onSubscribe(aVar);
        while (true) {
            a<T>[] aVarArr = this.b.get();
            if (aVarArr != k) {
                int length = aVarArr.length;
                a<T>[] aVarArr2 = new a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
                if (this.b.compareAndSet(aVarArr, aVarArr2)) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            Throwable th = this.g.get();
            if (th == ExceptionHelper.TERMINATED) {
                subscriber.onComplete();
            } else {
                subscriber.onError(th);
            }
        } else if (aVar.g) {
            f(aVar);
        } else if (!aVar.g) {
            synchronized (aVar) {
                if (!aVar.g) {
                    if (!aVar.c) {
                        BehaviorProcessor<T> behaviorProcessor = aVar.b;
                        Lock lock = behaviorProcessor.d;
                        lock.lock();
                        aVar.h = behaviorProcessor.h;
                        obj = behaviorProcessor.f.get();
                        lock.unlock();
                        aVar.d = obj != null;
                        aVar.c = true;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (obj != null && !aVar.test(obj)) {
                while (!aVar.g) {
                    synchronized (aVar) {
                        appendOnlyLinkedArrayList = aVar.e;
                        if (appendOnlyLinkedArrayList == null) {
                            aVar.d = false;
                            return;
                        }
                        aVar.e = null;
                    }
                    appendOnlyLinkedArrayList.forEachWhile(aVar);
                }
            }
        }
    }
}
