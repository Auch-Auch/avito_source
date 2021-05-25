package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableOnBackpressureBufferStrategy<T> extends s6.a.c.b.a.a<T, T> {
    public final long b;
    public final Action c;
    public final BackpressureOverflowStrategy d;

    public static final class a<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 3240706908776709697L;
        public final Subscriber<? super T> a;
        public final Action b;
        public final BackpressureOverflowStrategy c;
        public final long d;
        public final AtomicLong e = new AtomicLong();
        public final Deque<T> f = new ArrayDeque();
        public Subscription g;
        public volatile boolean h;
        public volatile boolean i;
        public Throwable j;

        public a(Subscriber<? super T> subscriber, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy, long j2) {
            this.a = subscriber;
            this.b = action;
            this.c = backpressureOverflowStrategy;
            this.d = j2;
        }

        public void a(Deque<T> deque) {
            synchronized (deque) {
                deque.clear();
            }
        }

        public void b() {
            int i2;
            boolean isEmpty;
            T poll;
            if (getAndIncrement() == 0) {
                Deque<T> deque = this.f;
                Subscriber<? super T> subscriber = this.a;
                int i3 = 1;
                do {
                    long j2 = this.e.get();
                    long j3 = 0;
                    while (true) {
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (this.h) {
                            a(deque);
                            return;
                        } else {
                            boolean z = this.i;
                            synchronized (deque) {
                                poll = deque.poll();
                            }
                            boolean z2 = poll == null;
                            if (z) {
                                Throwable th = this.j;
                                if (th != null) {
                                    a(deque);
                                    subscriber.onError(th);
                                    return;
                                } else if (z2) {
                                    subscriber.onComplete();
                                    return;
                                }
                            }
                            if (z2) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j3++;
                        }
                    }
                    if (i2 == 0) {
                        if (this.h) {
                            a(deque);
                            return;
                        }
                        boolean z3 = this.i;
                        synchronized (deque) {
                            isEmpty = deque.isEmpty();
                        }
                        if (z3) {
                            Throwable th2 = this.j;
                            if (th2 != null) {
                                a(deque);
                                subscriber.onError(th2);
                                return;
                            } else if (isEmpty) {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    }
                    if (j3 != 0) {
                        BackpressureHelper.produced(this.e, j3);
                    }
                    i3 = addAndGet(-i3);
                } while (i3 != 0);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.h = true;
            this.g.cancel();
            if (getAndIncrement() == 0) {
                a(this.f);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.i = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.i) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.j = th;
            this.i = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            boolean z;
            boolean z2;
            if (!this.i) {
                Deque<T> deque = this.f;
                synchronized (deque) {
                    z = false;
                    z2 = true;
                    if (((long) deque.size()) == this.d) {
                        int ordinal = this.c.ordinal();
                        if (ordinal == 1) {
                            deque.poll();
                            deque.offer(t);
                        } else if (ordinal == 2) {
                            deque.pollLast();
                            deque.offer(t);
                        }
                        z = true;
                    } else {
                        deque.offer(t);
                    }
                    z2 = false;
                }
                if (z) {
                    Action action = this.b;
                    if (action != null) {
                        try {
                            action.run();
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.g.cancel();
                            onError(th);
                        }
                    }
                } else if (z2) {
                    this.g.cancel();
                    onError(new MissingBackpressureException());
                } else {
                    b();
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.g, subscription)) {
                this.g = subscription;
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.e, j2);
                b();
            }
        }
    }

    public FlowableOnBackpressureBufferStrategy(Flowable<T> flowable, long j, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy) {
        super(flowable);
        this.b = j;
        this.c = action;
        this.d = backpressureOverflowStrategy;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new a(subscriber, this.c, this.d, this.b));
    }
}
