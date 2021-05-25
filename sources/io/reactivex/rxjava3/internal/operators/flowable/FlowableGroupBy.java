package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.flowables.GroupedFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.EmptyComponent;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableGroupBy<T, K, V> extends s6.a.e.d.c.a.a<T, GroupedFlowable<K, V>> {
    public final Function<? super T, ? extends K> b;
    public final Function<? super T, ? extends V> c;
    public final int d;
    public final boolean e;
    public final Function<? super Consumer<Object>, ? extends Map<K, Object>> f;

    public static final class a<K, V> implements Consumer<b<K, V>> {
        public final Queue<b<K, V>> a;

        public a(Queue<b<K, V>> queue) {
            this.a = queue;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Object obj) throws Throwable {
            this.a.offer((b) obj);
        }
    }

    public static final class b<K, T> extends GroupedFlowable<K, T> {
        public static final /* synthetic */ int d = 0;
        public final c<T, K> c;

        public b(K k, c<T, K> cVar) {
            super(k);
            this.c = cVar;
        }

        @Override // io.reactivex.rxjava3.core.Flowable
        public void subscribeActual(Subscriber<? super T> subscriber) {
            this.c.subscribe(subscriber);
        }
    }

    public static final class c<T, K> extends BasicIntQueueSubscription<T> implements Publisher<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        public final K a;
        public final SpscLinkedArrayQueue<T> b;
        public final GroupBySubscriber<?, K, T> c;
        public final boolean d;
        public final AtomicLong e = new AtomicLong();
        public volatile boolean f;
        public Throwable g;
        public final AtomicBoolean h = new AtomicBoolean();
        public final AtomicReference<Subscriber<? super T>> i = new AtomicReference<>();
        public int j;
        public final AtomicInteger k = new AtomicInteger();
        public final AtomicBoolean l = new AtomicBoolean();

        public c(int i2, GroupBySubscriber<?, K, T> groupBySubscriber, K k2, boolean z) {
            this.b = new SpscLinkedArrayQueue<>(i2);
            this.c = groupBySubscriber;
            this.a = k2;
            this.d = z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.h.compareAndSet(false, true)) {
                if ((this.k.get() & 2) == 0 && this.l.compareAndSet(false, true)) {
                    this.c.cancel(this.a);
                }
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.b;
            while (spscLinkedArrayQueue.poll() != null) {
                this.j++;
            }
            j();
        }

        public boolean d(boolean z, boolean z2, Subscriber<? super T> subscriber, boolean z3, long j2, boolean z4) {
            if (this.h.get()) {
                while (this.b.poll() != null) {
                    j2++;
                }
                h(j2, z4);
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!z3) {
                    Throwable th = this.g;
                    if (th != null) {
                        this.b.clear();
                        this.h.lazySet(true);
                        subscriber.onError(th);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        this.h.lazySet(true);
                        subscriber.onComplete();
                        h(j2, z4);
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    this.h.lazySet(true);
                    Throwable th2 = this.g;
                    if (th2 != null) {
                        subscriber.onError(th2);
                    } else {
                        subscriber.onComplete();
                        h(j2, z4);
                    }
                    return true;
                }
            }
        }

        public void drain() {
            int i2;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.b;
                boolean z = this.d;
                AtomicBoolean atomicBoolean = this.h;
                Subscriber<? super T> subscriber = this.i.get();
                int i3 = 1;
                while (true) {
                    if (atomicBoolean.get()) {
                        long j2 = 0;
                        while (this.b.poll() != null) {
                            j2++;
                        }
                        h(j2, false);
                    } else if (subscriber != null) {
                        long j3 = this.e.get();
                        long j4 = 0;
                        while (true) {
                            i2 = (j4 > j3 ? 1 : (j4 == j3 ? 0 : -1));
                            if (i2 == 0) {
                                break;
                            }
                            boolean z2 = this.f;
                            T poll = spscLinkedArrayQueue.poll();
                            boolean z3 = poll == null;
                            if (d(z2, z3, subscriber, z, j4, !z3)) {
                                continue;
                                break;
                            } else if (z3) {
                                j4 = j4;
                                break;
                            } else {
                                subscriber.onNext(poll);
                                j4++;
                            }
                        }
                        if (i2 == 0) {
                            if (d(this.f, spscLinkedArrayQueue.isEmpty(), subscriber, z, j4, false)) {
                                continue;
                            } else {
                                j4 = j4;
                            }
                        }
                        if (j4 != 0) {
                            BackpressureHelper.produced(this.e, j4);
                            i(j4);
                        }
                    }
                    i3 = addAndGet(-i3);
                    if (i3 != 0) {
                        if (subscriber == null) {
                            subscriber = this.i.get();
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public void h(long j2, boolean z) {
            if (z) {
                j2++;
            }
            if (j2 != 0) {
                i(j2);
            }
        }

        public void i(long j2) {
            if ((this.k.get() & 2) == 0) {
                this.c.b(j2);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            if (this.b.isEmpty()) {
                j();
                return true;
            }
            j();
            return false;
        }

        public void j() {
            int i2 = this.j;
            if (i2 != 0) {
                this.j = 0;
                i((long) i2);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            T poll = this.b.poll();
            if (poll != null) {
                this.j++;
                return poll;
            }
            j();
            return null;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.e, j2);
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            return 0;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> subscriber) {
            int i2;
            do {
                i2 = this.k.get();
                if ((i2 & 1) != 0) {
                    EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), subscriber);
                    return;
                }
            } while (!this.k.compareAndSet(i2, i2 | 1));
            subscriber.onSubscribe(this);
            this.i.lazySet(subscriber);
            if (this.h.get()) {
                this.i.lazySet(null);
            } else {
                drain();
            }
        }
    }

    public FlowableGroupBy(Flowable<T> flowable, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z, Function<? super Consumer<Object>, ? extends Map<K, Object>> function3) {
        super(flowable);
        this.b = function;
        this.c = function2;
        this.d = i;
        this.e = z;
        this.f = function3;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super GroupedFlowable<K, V>> subscriber) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Map map;
        try {
            if (this.f == null) {
                concurrentLinkedQueue = null;
                map = new ConcurrentHashMap();
            } else {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                map = (Map) this.f.apply(new a(concurrentLinkedQueue));
            }
            this.source.subscribe((FlowableSubscriber) new GroupBySubscriber(subscriber, this.b, this.c, this.d, this.e, map, concurrentLinkedQueue));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            subscriber.onSubscribe(EmptyComponent.INSTANCE);
            subscriber.onError(th);
        }
    }

    public static final class GroupBySubscriber<T, K, V> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        public static final Object o = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        public final Subscriber<? super GroupedFlowable<K, V>> a;
        public final Function<? super T, ? extends K> b;
        public final Function<? super T, ? extends V> c;
        public final int d;
        public final int e;
        public final boolean f;
        public final Map<Object, b<K, V>> g;
        public final Queue<b<K, V>> h;
        public Subscription i;
        public final AtomicBoolean j = new AtomicBoolean();
        public long k;
        public final AtomicInteger l = new AtomicInteger(1);
        public final AtomicLong m = new AtomicLong();
        public boolean n;

        public GroupBySubscriber(Subscriber<? super GroupedFlowable<K, V>> subscriber, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i2, boolean z, Map<Object, b<K, V>> map, Queue<b<K, V>> queue) {
            this.a = subscriber;
            this.b = function;
            this.c = function2;
            this.d = i2;
            this.e = i2 - (i2 >> 2);
            this.f = z;
            this.g = map;
            this.h = queue;
        }

        public final void a() {
            if (this.h != null) {
                int i2 = 0;
                while (true) {
                    b<K, V> poll = this.h.poll();
                    if (poll == null) {
                        break;
                    }
                    c<T, K> cVar = poll.c;
                    boolean compareAndSet = cVar.l.compareAndSet(false, true);
                    cVar.f = true;
                    cVar.drain();
                    if (compareAndSet) {
                        i2++;
                    }
                }
                if (i2 != 0) {
                    this.l.addAndGet(-i2);
                }
            }
        }

        public void b(long j2) {
            long j3;
            long addCap;
            AtomicLong atomicLong = this.m;
            int i2 = this.e;
            do {
                j3 = atomicLong.get();
                addCap = BackpressureHelper.addCap(j3, j2);
            } while (!atomicLong.compareAndSet(j3, addCap));
            while (true) {
                long j4 = (long) i2;
                if (addCap >= j4) {
                    if (atomicLong.compareAndSet(addCap, addCap - j4)) {
                        this.i.request(j4);
                    }
                    addCap = atomicLong.get();
                } else {
                    return;
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.j.compareAndSet(false, true)) {
                a();
                if (this.l.decrementAndGet() == 0) {
                    this.i.cancel();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.n) {
                for (b<K, V> bVar : this.g.values()) {
                    c<T, K> cVar = bVar.c;
                    cVar.f = true;
                    cVar.drain();
                }
                this.g.clear();
                a();
                this.n = true;
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.n) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.n = true;
            for (b<K, V> bVar : this.g.values()) {
                c<T, K> cVar = bVar.c;
                cVar.g = th;
                cVar.f = true;
                cVar.drain();
            }
            this.g.clear();
            a();
            this.a.onError(th);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupBy$GroupBySubscriber<T, K, V> */
        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Object obj;
            boolean z;
            if (!this.n) {
                try {
                    Object apply = this.b.apply(t);
                    if (apply != null) {
                        obj = apply;
                    } else {
                        obj = o;
                    }
                    b<K, V> bVar = this.g.get(obj);
                    boolean z2 = false;
                    if (bVar != null) {
                        z = false;
                    } else if (!this.j.get()) {
                        int i2 = this.d;
                        boolean z3 = this.f;
                        int i3 = b.d;
                        bVar = new b<>(apply, new c(i2, this, apply, z3));
                        this.g.put(obj, bVar);
                        this.l.getAndIncrement();
                        z = true;
                    } else {
                        return;
                    }
                    try {
                        Object nullCheck = ExceptionHelper.nullCheck(this.c.apply(t), "The valueSelector returned a null value.");
                        c<T, K> cVar = bVar.c;
                        cVar.b.offer(nullCheck);
                        cVar.drain();
                        a();
                        if (!z) {
                            return;
                        }
                        if (this.k != get()) {
                            this.k++;
                            this.a.onNext(bVar);
                            c<T, K> cVar2 = bVar.c;
                            if (cVar2.k.get() == 0 && cVar2.k.compareAndSet(0, 2)) {
                                z2 = true;
                            }
                            if (z2) {
                                cancel(apply);
                                c<T, K> cVar3 = bVar.c;
                                cVar3.f = true;
                                cVar3.drain();
                                b(1);
                                return;
                            }
                            return;
                        }
                        this.i.cancel();
                        onError(new MissingBackpressureException(a2.b.a.a.a.V2("Unable to emit a new group (#", this.k, ") due to lack of requests. Please make sure the downstream can always accept a new group as well as each group is consumed in order for the whole operator to be able to proceed.")));
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.i.cancel();
                        if (z) {
                            if (this.k != get()) {
                                this.a.onNext(bVar);
                            } else {
                                MissingBackpressureException missingBackpressureException = new MissingBackpressureException(a2.b.a.a.a.V2("Unable to emit a new group (#", this.k, ") due to lack of requests. Please make sure the downstream can always accept a new group as well as each group is consumed in order for the whole operator to be able to proceed."));
                                missingBackpressureException.initCause(th);
                                onError(missingBackpressureException);
                                return;
                            }
                        }
                        onError(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.i.cancel();
                    onError(th2);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.i, subscription)) {
                this.i = subscription;
                this.a.onSubscribe(this);
                subscription.request((long) this.d);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this, j2);
            }
        }

        public void cancel(K k2) {
            if (k2 == null) {
                k2 = (K) o;
            }
            if (this.g.remove(k2) != null && this.l.decrementAndGet() == 0) {
                this.i.cancel();
            }
        }
    }
}
