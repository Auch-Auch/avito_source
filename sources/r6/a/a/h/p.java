package r6.a.a.h;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class p<T> extends Flowable<T> implements FlowableTransformer<T, T> {
    public final Publisher<T> b;
    public final int c;
    public final long d;
    public final TimeUnit e;
    public final Scheduler f;
    public final Consumer<? super T> g;

    public static final class a<T> extends AtomicInteger implements Subscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 2264324530873250941L;
        public final Subscriber<? super T> a;
        public final AtomicLong b = new AtomicLong();
        public final int c;
        public final long d;
        public final TimeUnit e;
        public final Scheduler.Worker f;
        public final Consumer<? super T> g;
        public Subscription h;
        public final ArrayDeque<Object> i = new ArrayDeque<>();
        public volatile boolean j;
        public Throwable k;
        public volatile boolean l;

        public a(Subscriber<? super T> subscriber, int i2, long j2, TimeUnit timeUnit, Scheduler.Worker worker, Consumer<? super T> consumer) {
            this.a = subscriber;
            this.c = i2 << 1;
            this.d = j2;
            this.e = timeUnit;
            this.f = worker;
            this.g = consumer;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: r6.a.a.h.p$a<T> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a() {
            Object poll;
            while (true) {
                synchronized (this) {
                    if (!this.i.isEmpty()) {
                        this.i.poll();
                        poll = this.i.poll();
                    } else {
                        return;
                    }
                }
                c(poll);
            }
        }

        public void b() {
            int i2;
            boolean isEmpty;
            Object poll;
            if (getAndIncrement() == 0) {
                int i3 = 1;
                do {
                    long j2 = this.b.get();
                    long j3 = 0;
                    while (true) {
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (this.l) {
                            a();
                            return;
                        } else {
                            boolean z = this.j;
                            synchronized (this) {
                                poll = this.i.poll() != null ? this.i.poll() : null;
                            }
                            boolean z2 = poll == null;
                            if (z && z2) {
                                Throwable th = this.k;
                                if (th != null) {
                                    this.a.onError(th);
                                } else {
                                    this.a.onComplete();
                                }
                                this.f.dispose();
                                return;
                            } else if (z2) {
                                break;
                            } else {
                                this.a.onNext(poll);
                                j3++;
                            }
                        }
                    }
                    if (i2 == 0) {
                        if (this.l) {
                            a();
                            return;
                        }
                        boolean z3 = this.j;
                        synchronized (this) {
                            isEmpty = this.i.isEmpty();
                        }
                        if (z3 && isEmpty) {
                            Throwable th2 = this.k;
                            if (th2 != null) {
                                this.a.onError(th2);
                            } else {
                                this.a.onComplete();
                            }
                            this.f.dispose();
                            return;
                        }
                    }
                    i3 = addAndGet(-i3);
                } while (i3 != 0);
            }
        }

        public void c(T t) {
            if (t != null) {
                try {
                    this.g.accept(t);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.l = true;
            this.h.cancel();
            this.f.dispose();
            if (getAndIncrement() == 0) {
                a();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.j = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.k = th;
            this.j = true;
            b();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: r6.a.a.h.p$a<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Object obj;
            synchronized (this) {
                if (this.i.size() == this.c) {
                    this.i.poll();
                    obj = this.i.poll();
                } else {
                    obj = null;
                }
                this.i.offer(Long.valueOf(this.f.now(this.e)));
                this.i.offer(t);
            }
            c(obj);
            this.f.schedule(this, this.d, this.e);
            b();
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
                BackpressureHelper.add(this.b, j2);
                b();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: r6.a.a.h.p$a<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            while (!this.l) {
                boolean z2 = this.j;
                Object obj = null;
                synchronized (this) {
                    Long l2 = (Long) this.i.peek();
                    z = l2 == null;
                    if (!z) {
                        if (l2.longValue() <= this.f.now(this.e) - this.d) {
                            this.i.poll();
                            obj = this.i.poll();
                        } else {
                            return;
                        }
                    }
                }
                c(obj);
                if (z) {
                    if (z2) {
                        b();
                        return;
                    }
                    return;
                }
            }
        }
    }

    public p(Publisher<T> publisher, int i, long j, TimeUnit timeUnit, Scheduler scheduler, Consumer<? super T> consumer) {
        this.b = publisher;
        this.c = i;
        this.d = j;
        this.e = timeUnit;
        this.f = scheduler;
        this.g = consumer;
    }

    @Override // io.reactivex.FlowableTransformer
    public Publisher<T> apply(Flowable<T> flowable) {
        return new p(flowable, this.c, this.d, this.e, this.f, this.g);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new a(subscriber, this.c, this.d, this.e, this.f.createWorker(), this.g));
    }
}
