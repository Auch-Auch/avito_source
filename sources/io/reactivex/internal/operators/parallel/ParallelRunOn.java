package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class ParallelRunOn<T> extends ParallelFlowable<T> {
    public final ParallelFlowable<? extends T> a;
    public final Scheduler b;
    public final int c;

    public static abstract class a<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 9222303586456402150L;
        public final int a;
        public final int b;
        public final SpscArrayQueue<T> c;
        public final Scheduler.Worker d;
        public Subscription e;
        public volatile boolean f;
        public Throwable g;
        public final AtomicLong h = new AtomicLong();
        public volatile boolean i;
        public int j;

        public a(int i2, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            this.a = i2;
            this.c = spscArrayQueue;
            this.b = i2 - (i2 >> 2);
            this.d = worker;
        }

        public final void a() {
            if (getAndIncrement() == 0) {
                this.d.schedule(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (!this.i) {
                this.i = true;
                this.e.cancel();
                this.d.dispose();
                if (getAndIncrement() == 0) {
                    this.c.clear();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (!this.f) {
                this.f = true;
                a();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.g = th;
            this.f = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (!this.f) {
                if (!this.c.offer(t)) {
                    this.e.cancel();
                    onError(new MissingBackpressureException("Queue is full?!"));
                    return;
                }
                a();
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.h, j2);
                a();
            }
        }
    }

    public final class b implements SchedulerMultiWorkerSupport.WorkerCallback {
        public final Subscriber<? super T>[] a;
        public final Subscriber<T>[] b;

        public b(Subscriber<? super T>[] subscriberArr, Subscriber<T>[] subscriberArr2) {
            this.a = subscriberArr;
            this.b = subscriberArr2;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport.WorkerCallback
        public void onWorker(int i, Scheduler.Worker worker) {
            ParallelRunOn.this.a(i, this.a, this.b, worker);
        }
    }

    public static final class c<T> extends a<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        public final ConditionalSubscriber<? super T> k;

        public c(ConditionalSubscriber<? super T> conditionalSubscriber, int i, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            super(i, spscArrayQueue, worker);
            this.k = conditionalSubscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.k.onSubscribe(this);
                subscription.request((long) this.a);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Throwable th;
            int i2 = this.j;
            SpscArrayQueue<T> spscArrayQueue = this.c;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.k;
            int i3 = this.b;
            int i4 = 1;
            while (true) {
                long j = this.h.get();
                long j2 = 0;
                while (true) {
                    i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i == 0) {
                        break;
                    } else if (this.i) {
                        spscArrayQueue.clear();
                        return;
                    } else {
                        boolean z = this.f;
                        if (!z || (th = this.g) == null) {
                            T poll = spscArrayQueue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                conditionalSubscriber.onComplete();
                                this.d.dispose();
                                return;
                            } else if (z2) {
                                break;
                            } else {
                                if (conditionalSubscriber.tryOnNext(poll)) {
                                    j2++;
                                }
                                i2++;
                                if (i2 == i3) {
                                    this.e.request((long) i2);
                                    i2 = 0;
                                }
                            }
                        } else {
                            spscArrayQueue.clear();
                            conditionalSubscriber.onError(th);
                            this.d.dispose();
                            return;
                        }
                    }
                }
                if (i == 0) {
                    if (this.i) {
                        spscArrayQueue.clear();
                        return;
                    } else if (this.f) {
                        Throwable th2 = this.g;
                        if (th2 != null) {
                            spscArrayQueue.clear();
                            conditionalSubscriber.onError(th2);
                            this.d.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            conditionalSubscriber.onComplete();
                            this.d.dispose();
                            return;
                        }
                    }
                }
                if (!(j2 == 0 || j == Long.MAX_VALUE)) {
                    this.h.addAndGet(-j2);
                }
                int i5 = get();
                if (i5 == i4) {
                    this.j = i2;
                    i4 = addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                } else {
                    i4 = i5;
                }
            }
        }
    }

    public static final class d<T> extends a<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        public final Subscriber<? super T> k;

        public d(Subscriber<? super T> subscriber, int i, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            super(i, spscArrayQueue, worker);
            this.k = subscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.k.onSubscribe(this);
                subscription.request((long) this.a);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Throwable th;
            int i2 = this.j;
            SpscArrayQueue<T> spscArrayQueue = this.c;
            Subscriber<? super T> subscriber = this.k;
            int i3 = this.b;
            int i4 = 1;
            while (true) {
                long j = this.h.get();
                long j2 = 0;
                while (true) {
                    i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i == 0) {
                        break;
                    } else if (this.i) {
                        spscArrayQueue.clear();
                        return;
                    } else {
                        boolean z = this.f;
                        if (!z || (th = this.g) == null) {
                            T poll = spscArrayQueue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                subscriber.onComplete();
                                this.d.dispose();
                                return;
                            } else if (z2) {
                                break;
                            } else {
                                subscriber.onNext(poll);
                                j2++;
                                i2++;
                                if (i2 == i3) {
                                    this.e.request((long) i2);
                                    i2 = 0;
                                }
                            }
                        } else {
                            spscArrayQueue.clear();
                            subscriber.onError(th);
                            this.d.dispose();
                            return;
                        }
                    }
                }
                if (i == 0) {
                    if (this.i) {
                        spscArrayQueue.clear();
                        return;
                    } else if (this.f) {
                        Throwable th2 = this.g;
                        if (th2 != null) {
                            spscArrayQueue.clear();
                            subscriber.onError(th2);
                            this.d.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            subscriber.onComplete();
                            this.d.dispose();
                            return;
                        }
                    }
                }
                if (!(j2 == 0 || j == Long.MAX_VALUE)) {
                    this.h.addAndGet(-j2);
                }
                int i5 = get();
                if (i5 == i4) {
                    this.j = i2;
                    i4 = addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                } else {
                    i4 = i5;
                }
            }
        }
    }

    public ParallelRunOn(ParallelFlowable<? extends T> parallelFlowable, Scheduler scheduler, int i) {
        this.a = parallelFlowable;
        this.b = scheduler;
        this.c = i;
    }

    public void a(int i, Subscriber<? super T>[] subscriberArr, Subscriber<T>[] subscriberArr2, Scheduler.Worker worker) {
        Subscriber<? super T> subscriber = subscriberArr[i];
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.c);
        if (subscriber instanceof ConditionalSubscriber) {
            subscriberArr2[i] = new c((ConditionalSubscriber) subscriber, this.c, spscArrayQueue, worker);
        } else {
            subscriberArr2[i] = new d(subscriber, this.c, spscArrayQueue, worker);
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.a.parallelism();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<T>[] subscriberArr2 = new Subscriber[length];
            Scheduler scheduler = this.b;
            if (scheduler instanceof SchedulerMultiWorkerSupport) {
                ((SchedulerMultiWorkerSupport) scheduler).createWorkers(length, new b(subscriberArr, subscriberArr2));
            } else {
                for (int i = 0; i < length; i++) {
                    a(i, subscriberArr, subscriberArr2, this.b.createWorker());
                }
            }
            this.a.subscribe(subscriberArr2);
        }
    }
}
