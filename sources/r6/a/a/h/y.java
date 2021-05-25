package r6.a.a.h;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class y<T, R> extends Flowable<R> implements FlowableTransformer<T, R> {
    public final Publisher<T> b;
    public final Function<? super T, ? extends Publisher<? extends R>> c;
    public final int d;
    public final int e;

    public static final class a<T, R> extends AtomicInteger implements Subscriber<T>, Subscription {
        private static final long serialVersionUID = 6801374887555723721L;
        public final Subscriber<? super R> a;
        public final Function<? super T, ? extends Publisher<? extends R>> b;
        public final int c;
        public final int d;
        public final ArrayDeque<C0597a<T, R>> e = new ArrayDeque<>();
        public final AtomicLong f = new AtomicLong();
        public final AtomicThrowable g = new AtomicThrowable();
        public Subscription h;
        public volatile boolean i;
        public volatile boolean j;
        public volatile long k;
        public final C0597a<T, R>[] l;
        public long m;

        /* renamed from: r6.a.a.h.y$a$a  reason: collision with other inner class name */
        public static final class C0597a<T, R> extends AtomicReference<Subscription> implements Subscriber<R> {
            private static final long serialVersionUID = 4011255448052082638L;
            public final a<T, R> a;
            public final int b;
            public final int c;
            public final SimplePlainQueue<R> d;
            public long e;
            public volatile boolean f;

            public C0597a(a<T, R> aVar, int i) {
                this.a = aVar;
                this.b = i;
                this.c = i - (i >> 2);
                this.d = new SpscArrayQueue(i);
            }

            public void a(long j) {
                long j2 = this.e + j;
                if (j2 >= ((long) this.c)) {
                    this.e = 0;
                    ((Subscription) get()).request(j2);
                    return;
                }
                this.e = j2;
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                this.f = true;
                this.a.c();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a<T, R> aVar = this.a;
                if (aVar.g.compareAndSet(null, th)) {
                    aVar.h.cancel();
                    aVar.a();
                    aVar.i = true;
                    aVar.c();
                    return;
                }
                RxJavaPlugins.onError(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(R r) {
                this.d.offer(r);
                this.a.c();
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request((long) this.b);
                }
            }
        }

        public a(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i2, int i3) {
            this.a = subscriber;
            this.b = function;
            this.c = i2;
            this.d = i3;
            this.l = new C0597a[i2];
        }

        public void a() {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                arrayList.addAll(this.e);
                this.e.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C0597a aVar = (C0597a) it.next();
                Objects.requireNonNull(aVar);
                SubscriptionHelper.cancel(aVar);
            }
        }

        public void b() {
            Arrays.fill(this.l, (Object) null);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:83:0x0129, code lost:
            if (r8.f == false) goto L_0x0135;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x012f, code lost:
            if (r12.isEmpty() == false) goto L_0x0135;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x0131, code lost:
            d(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x0139, code lost:
            if (r13 == 0) goto L_0x013e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x013b, code lost:
            r8.a(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x013e, code lost:
            r14 = r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c() {
            /*
            // Method dump skipped, instructions count: 375
            */
            throw new UnsupportedOperationException("Method not decompiled: r6.a.a.h.y.a.c():void");
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.j) {
                this.j = true;
                this.h.cancel();
                a();
                if (getAndIncrement() == 0) {
                    b();
                }
            }
        }

        public void d(C0597a<T, R> aVar) {
            synchronized (this) {
                this.e.remove(aVar);
                this.k++;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.i = true;
            c();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.g.compareAndSet(null, th)) {
                a();
                this.i = true;
                c();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            boolean z;
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null Publisher");
                C0597a<T, R> aVar = new C0597a<>(this, this.d);
                synchronized (this) {
                    if (this.j) {
                        z = false;
                    } else {
                        C0597a<T, R> poll = this.e.size() == this.c ? this.e.poll() : null;
                        this.e.offer(aVar);
                        this.k++;
                        if (poll != null) {
                            SubscriptionHelper.cancel(poll);
                        }
                        z = true;
                    }
                }
                if (z) {
                    publisher.subscribe(aVar);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.h.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.h, subscription)) {
                this.h = subscription;
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.f, j2);
                c();
            }
        }
    }

    public y(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2) {
        this.b = publisher;
        this.c = function;
        this.d = i;
        this.e = i2;
    }

    @Override // io.reactivex.FlowableTransformer
    public Publisher<R> apply(Flowable<T> flowable) {
        return new y(flowable, this.c, this.d, this.e);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe(new a(subscriber, this.c, this.d, this.e));
    }
}
