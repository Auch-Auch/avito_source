package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.GroupedFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.EmptyComponent;
import io.reactivex.plugins.RxJavaPlugins;
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
public final class FlowableGroupBy<T, K, V> extends s6.a.c.b.a.a<T, GroupedFlowable<K, V>> {
    public final Function<? super T, ? extends K> b;
    public final Function<? super T, ? extends V> c;
    public final int d;
    public final boolean e;
    public final Function<? super Consumer<Object>, ? extends Map<K, Object>> f;

    public static final class GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<GroupedFlowable<K, V>> implements FlowableSubscriber<T> {
        public static final Object q = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        public final Subscriber<? super GroupedFlowable<K, V>> a;
        public final Function<? super T, ? extends K> b;
        public final Function<? super T, ? extends V> c;
        public final int d;
        public final boolean e;
        public final Map<Object, b<K, V>> f;
        public final SpscLinkedArrayQueue<GroupedFlowable<K, V>> g;
        public final Queue<b<K, V>> h;
        public Subscription i;
        public final AtomicBoolean j = new AtomicBoolean();
        public final AtomicLong k = new AtomicLong();
        public final AtomicInteger l = new AtomicInteger(1);
        public Throwable m;
        public volatile boolean n;
        public boolean o;
        public boolean p;

        public GroupBySubscriber(Subscriber<? super GroupedFlowable<K, V>> subscriber, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i2, boolean z, Map<Object, b<K, V>> map, Queue<b<K, V>> queue) {
            this.a = subscriber;
            this.b = function;
            this.c = function2;
            this.d = i2;
            this.e = z;
            this.f = map;
            this.h = queue;
            this.g = new SpscLinkedArrayQueue<>(i2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.j.compareAndSet(false, true)) {
                h();
                if (this.l.decrementAndGet() == 0) {
                    this.i.cancel();
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.g.clear();
        }

        public boolean d(boolean z, boolean z2, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.j.get()) {
                spscLinkedArrayQueue.clear();
                return true;
            } else if (this.e) {
                if (!z || !z2) {
                    return false;
                }
                Throwable th = this.m;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                Throwable th2 = this.m;
                if (th2 != null) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th2);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            }
        }

        public void drain() {
            int i2;
            Throwable th;
            if (getAndIncrement() == 0) {
                int i3 = 1;
                if (this.p) {
                    SpscLinkedArrayQueue<GroupedFlowable<K, V>> spscLinkedArrayQueue = this.g;
                    Subscriber<? super GroupedFlowable<K, V>> subscriber = this.a;
                    while (!this.j.get()) {
                        boolean z = this.n;
                        if (!z || this.e || (th = this.m) == null) {
                            subscriber.onNext(null);
                            if (z) {
                                Throwable th2 = this.m;
                                if (th2 != null) {
                                    subscriber.onError(th2);
                                    return;
                                } else {
                                    subscriber.onComplete();
                                    return;
                                }
                            } else {
                                i3 = addAndGet(-i3);
                                if (i3 == 0) {
                                    return;
                                }
                            }
                        } else {
                            spscLinkedArrayQueue.clear();
                            subscriber.onError(th);
                            return;
                        }
                    }
                    return;
                }
                SpscLinkedArrayQueue<GroupedFlowable<K, V>> spscLinkedArrayQueue2 = this.g;
                Subscriber<? super GroupedFlowable<K, V>> subscriber2 = this.a;
                int i4 = 1;
                do {
                    long j2 = this.k.get();
                    long j3 = 0;
                    while (true) {
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        }
                        boolean z2 = this.n;
                        GroupedFlowable<K, V> poll = spscLinkedArrayQueue2.poll();
                        boolean z3 = poll == null;
                        if (!d(z2, z3, subscriber2, spscLinkedArrayQueue2)) {
                            if (z3) {
                                break;
                            }
                            subscriber2.onNext(poll);
                            j3++;
                        } else {
                            return;
                        }
                    }
                    if (i2 != 0 || !d(this.n, spscLinkedArrayQueue2.isEmpty(), subscriber2, spscLinkedArrayQueue2)) {
                        if (j3 != 0) {
                            if (j2 != Long.MAX_VALUE) {
                                this.k.addAndGet(-j3);
                            }
                            this.i.request(j3);
                        }
                        i4 = addAndGet(-i4);
                    } else {
                        return;
                    }
                } while (i4 != 0);
            }
        }

        public final void h() {
            if (this.h != null) {
                int i2 = 0;
                while (true) {
                    b<K, V> poll = this.h.poll();
                    if (poll == null) {
                        break;
                    }
                    c<T, K> cVar = poll.c;
                    cVar.f = true;
                    cVar.drain();
                    i2++;
                }
                if (i2 != 0) {
                    this.l.addAndGet(-i2);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.g.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.o) {
                for (b<K, V> bVar : this.f.values()) {
                    c<T, K> cVar = bVar.c;
                    cVar.f = true;
                    cVar.drain();
                }
                this.f.clear();
                Queue<b<K, V>> queue = this.h;
                if (queue != null) {
                    queue.clear();
                }
                this.o = true;
                this.n = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.o) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.o = true;
            for (b<K, V> bVar : this.f.values()) {
                c<T, K> cVar = bVar.c;
                cVar.g = th;
                cVar.f = true;
                cVar.drain();
            }
            this.f.clear();
            Queue<b<K, V>> queue = this.h;
            if (queue != null) {
                queue.clear();
            }
            this.m = th;
            this.n = true;
            drain();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: io.reactivex.internal.queue.SpscLinkedArrayQueue<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Object obj;
            if (!this.o) {
                SpscLinkedArrayQueue<GroupedFlowable<K, V>> spscLinkedArrayQueue = this.g;
                try {
                    Object apply = this.b.apply(t);
                    boolean z = false;
                    if (apply != null) {
                        obj = apply;
                    } else {
                        obj = q;
                    }
                    b<K, V> bVar = this.f.get(obj);
                    if (bVar == null) {
                        if (!this.j.get()) {
                            int i2 = this.d;
                            boolean z2 = this.e;
                            int i3 = b.d;
                            bVar = new b<>(apply, new c(i2, this, apply, z2));
                            this.f.put(obj, bVar);
                            this.l.getAndIncrement();
                            z = true;
                        } else {
                            return;
                        }
                    }
                    try {
                        Object requireNonNull = ObjectHelper.requireNonNull(this.c.apply(t), "The valueSelector returned null");
                        c<T, K> cVar = bVar.c;
                        cVar.b.offer(requireNonNull);
                        cVar.drain();
                        h();
                        if (z) {
                            spscLinkedArrayQueue.offer(bVar);
                            drain();
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.i.cancel();
                        onError(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.i.cancel();
                    onError(th2);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
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
                BackpressureHelper.add(this.k, j2);
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.p = true;
            return 2;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public GroupedFlowable<K, V> poll() {
            return this.g.poll();
        }

        public void cancel(K k2) {
            if (k2 == null) {
                k2 = (K) q;
            }
            this.f.remove(k2);
            if (this.l.decrementAndGet() == 0) {
                this.i.cancel();
                if (!this.p && getAndIncrement() == 0) {
                    this.g.clear();
                }
            }
        }
    }

    public static final class a<K, V> implements Consumer<b<K, V>> {
        public final Queue<b<K, V>> a;

        public a(Queue<b<K, V>> queue) {
            this.a = queue;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) throws Exception {
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

        @Override // io.reactivex.Flowable
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
        public final AtomicBoolean j = new AtomicBoolean();
        public boolean k;
        public int l;

        public c(int i2, GroupBySubscriber<?, K, T> groupBySubscriber, K k2, boolean z) {
            this.b = new SpscLinkedArrayQueue<>(i2);
            this.c = groupBySubscriber;
            this.a = k2;
            this.d = z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.h.compareAndSet(false, true)) {
                this.c.cancel(this.a);
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.b;
            while (spscLinkedArrayQueue.poll() != null) {
                this.l++;
            }
            h();
        }

        public boolean d(boolean z, boolean z2, Subscriber<? super T> subscriber, boolean z3, long j2) {
            if (this.h.get()) {
                while (this.b.poll() != null) {
                    j2++;
                }
                if (j2 != 0) {
                    this.c.i.request(j2);
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!z3) {
                    Throwable th = this.g;
                    if (th != null) {
                        this.b.clear();
                        subscriber.onError(th);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        subscriber.onComplete();
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    Throwable th2 = this.g;
                    if (th2 != null) {
                        subscriber.onError(th2);
                    } else {
                        subscriber.onComplete();
                    }
                    return true;
                }
            }
        }

        public void drain() {
            int i2;
            Throwable th;
            if (getAndIncrement() == 0) {
                if (this.k) {
                    SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.b;
                    Subscriber<? super T> subscriber = this.i.get();
                    int i3 = 1;
                    while (true) {
                        if (subscriber != null) {
                            if (!this.h.get()) {
                                boolean z = this.f;
                                if (!z || this.d || (th = this.g) == null) {
                                    subscriber.onNext(null);
                                    if (z) {
                                        Throwable th2 = this.g;
                                        if (th2 != null) {
                                            subscriber.onError(th2);
                                            return;
                                        } else {
                                            subscriber.onComplete();
                                            return;
                                        }
                                    }
                                } else {
                                    spscLinkedArrayQueue.clear();
                                    subscriber.onError(th);
                                    return;
                                }
                            } else {
                                return;
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
                } else {
                    SpscLinkedArrayQueue<T> spscLinkedArrayQueue2 = this.b;
                    boolean z2 = this.d;
                    Subscriber<? super T> subscriber2 = this.i.get();
                    int i4 = 1;
                    while (true) {
                        if (subscriber2 != null) {
                            long j2 = this.e.get();
                            long j3 = 0;
                            while (true) {
                                i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                                if (i2 == 0) {
                                    break;
                                }
                                boolean z3 = this.f;
                                T poll = spscLinkedArrayQueue2.poll();
                                boolean z4 = poll == null;
                                if (!d(z3, z4, subscriber2, z2, j3)) {
                                    if (z4) {
                                        j3 = j3;
                                        break;
                                    } else {
                                        subscriber2.onNext(poll);
                                        j3++;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (i2 == 0) {
                                if (!d(this.f, spscLinkedArrayQueue2.isEmpty(), subscriber2, z2, j3)) {
                                    j3 = j3;
                                } else {
                                    return;
                                }
                            }
                            if (j3 != 0) {
                                if (j2 != Long.MAX_VALUE) {
                                    this.e.addAndGet(-j3);
                                }
                                this.c.i.request(j3);
                            }
                        }
                        i4 = addAndGet(-i4);
                        if (i4 != 0) {
                            if (subscriber2 == null) {
                                subscriber2 = this.i.get();
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        }

        public void h() {
            int i2 = this.l;
            if (i2 != 0) {
                this.l = 0;
                this.c.i.request((long) i2);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            if (!this.b.isEmpty()) {
                return false;
            }
            h();
            return true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            T poll = this.b.poll();
            if (poll != null) {
                this.l++;
                return poll;
            }
            h();
            return null;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.e, j2);
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.k = true;
            return 2;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> subscriber) {
            if (this.j.compareAndSet(false, true)) {
                subscriber.onSubscribe(this);
                this.i.lazySet(subscriber);
                drain();
                return;
            }
            EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), subscriber);
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

    @Override // io.reactivex.Flowable
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
        } catch (Exception e2) {
            Exceptions.throwIfFatal(e2);
            subscriber.onSubscribe(EmptyComponent.INSTANCE);
            subscriber.onError(e2);
        }
    }
}
