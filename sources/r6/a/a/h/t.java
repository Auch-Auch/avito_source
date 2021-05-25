package r6.a.a.h;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;
public final class t<T> extends Flowable<T> {
    public final T b;

    public static final class a<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -231033913007168200L;
        public final ConditionalSubscriber<? super T> a;
        public T b;
        public volatile boolean c;

        public a(ConditionalSubscriber<? super T> conditionalSubscriber, T t) {
            this.a = conditionalSubscriber;
            this.b = t;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.c = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.b = null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.b == null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            return this.b;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    T t = this.b;
                    while (!this.c) {
                        this.a.tryOnNext(t);
                    }
                    return;
                }
                T t2 = this.b;
                do {
                    long j2 = 0;
                    while (true) {
                        if (j2 != j) {
                            if (!this.c) {
                                if (this.a.tryOnNext(t2)) {
                                    j2++;
                                }
                            } else {
                                return;
                            }
                        } else if (!this.c) {
                            j = get();
                            if (j2 == j) {
                                j = addAndGet(-j2);
                            }
                        } else {
                            return;
                        }
                    }
                } while (j != 0);
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return i & 1;
        }
    }

    public static final class b<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -231033913007168200L;
        public final Subscriber<? super T> a;
        public T b;
        public volatile boolean c;

        public b(Subscriber<? super T> subscriber, T t) {
            this.a = subscriber;
            this.b = t;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.c = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.b = null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.b == null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            return this.b;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    T t = this.b;
                    while (!this.c) {
                        this.a.onNext(t);
                    }
                    return;
                }
                T t2 = this.b;
                do {
                    long j2 = 0;
                    while (true) {
                        if (j2 != j) {
                            if (!this.c) {
                                this.a.onNext(t2);
                                j2++;
                            } else {
                                return;
                            }
                        } else if (!this.c) {
                            j = get();
                            if (j2 == j) {
                                j = addAndGet(-j2);
                            }
                        } else {
                            return;
                        }
                    }
                } while (j != 0);
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return i & 1;
        }
    }

    public t(T t) {
        this.b = t;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe(new a((ConditionalSubscriber) subscriber, this.b));
        } else {
            subscriber.onSubscribe(new b(subscriber, this.b));
        }
    }
}
