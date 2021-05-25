package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Solo;
import hu.akarnokd.rxjava2.util.SpscOneQueue;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class f4<T> extends Solo<T> {
    public final Solo<T> b;
    public final Scheduler c;

    public static final class a<T> extends BasicIntQueueSubscription<T> implements Subscriber<T>, Runnable {
        private static final long serialVersionUID = -658564450611526565L;
        public final Subscriber<? super T> a;
        public final Scheduler.Worker b;
        public Subscription c;
        public volatile boolean d;
        public Throwable e;
        public SimpleQueue<T> f;
        public volatile boolean g;
        public volatile boolean h;
        public int i;
        public boolean j;

        public a(Subscriber<? super T> subscriber, Scheduler.Worker worker) {
            this.a = subscriber;
            this.b = worker;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.g) {
                this.g = true;
                this.c.cancel();
                this.b.dispose();
                if (getAndIncrement() == 0) {
                    this.f.clear();
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f.clear();
        }

        public void d() {
            if (getAndIncrement() == 0) {
                this.b.schedule(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.f.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.d = true;
            d();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.e = th;
            this.d = true;
            d();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.i == 0) {
                this.f.offer(t);
            }
            d();
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.i = requestFusion;
                        this.f = queueSubscription;
                        this.d = true;
                        this.a.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.i = requestFusion;
                        this.f = queueSubscription;
                        this.a.onSubscribe(this);
                        subscription.request(Long.MAX_VALUE);
                        return;
                    }
                }
                this.f = new SpscOneQueue();
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            return this.f.poll();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                this.h = true;
                d();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.j = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            SimpleQueue<T> simpleQueue = this.f;
            int i2 = 1;
            while (!this.g) {
                boolean z = this.d;
                if (this.h) {
                    if (!this.j) {
                        try {
                            T poll = simpleQueue.poll();
                            if (!(poll == null)) {
                                this.a.onNext(poll);
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            simpleQueue.clear();
                            this.a.onError(th);
                            this.b.dispose();
                            return;
                        }
                    } else if (!simpleQueue.isEmpty()) {
                        this.a.onNext(null);
                    }
                }
                if (z) {
                    Throwable th2 = this.e;
                    if (th2 != null) {
                        this.a.onError(th2);
                        this.b.dispose();
                        return;
                    } else if (simpleQueue.isEmpty()) {
                        this.a.onComplete();
                        this.b.dispose();
                        return;
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
            simpleQueue.clear();
        }
    }

    public f4(Solo<T> solo, Scheduler scheduler) {
        this.b = solo;
        this.c = scheduler;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new a(subscriber, this.c.createWorker()));
    }
}
