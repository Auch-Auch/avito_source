package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;
public final class FlowableRange extends Flowable<Integer> {
    public final int b;
    public final int c;

    public static abstract class a extends BasicQueueSubscription<Integer> {
        private static final long serialVersionUID = -2252972430506210021L;
        public final int a;
        public int b;
        public volatile boolean c;

        public a(int i, int i2) {
            this.b = i;
            this.a = i2;
        }

        public abstract void a();

        public abstract void b(long j);

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.c = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.b = this.a;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.b == this.a;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public Object poll() throws Exception {
            int i = this.b;
            if (i == this.a) {
                return null;
            }
            this.b = i + 1;
            return Integer.valueOf(i);
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    a();
                } else {
                    b(j);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            return i & 1;
        }
    }

    public static final class b extends a {
        private static final long serialVersionUID = 2587302975077663557L;
        public final ConditionalSubscriber<? super Integer> d;

        public b(ConditionalSubscriber<? super Integer> conditionalSubscriber, int i, int i2) {
            super(i, i2);
            this.d = conditionalSubscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.a
        public void a() {
            int i = this.a;
            ConditionalSubscriber<? super Integer> conditionalSubscriber = this.d;
            for (int i2 = this.b; i2 != i; i2++) {
                if (!this.c) {
                    conditionalSubscriber.tryOnNext(Integer.valueOf(i2));
                } else {
                    return;
                }
            }
            if (!this.c) {
                conditionalSubscriber.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.a
        public void b(long j) {
            int i = this.a;
            int i2 = this.b;
            ConditionalSubscriber<? super Integer> conditionalSubscriber = this.d;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == j || i2 == i) {
                        if (i2 != i) {
                            j = get();
                            if (j2 == j) {
                                this.b = i2;
                                j = addAndGet(-j2);
                            }
                        } else if (!this.c) {
                            conditionalSubscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.c) {
                        if (conditionalSubscriber.tryOnNext(Integer.valueOf(i2))) {
                            j2++;
                        }
                        i2++;
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }
    }

    public static final class c extends a {
        private static final long serialVersionUID = 2587302975077663557L;
        public final Subscriber<? super Integer> d;

        public c(Subscriber<? super Integer> subscriber, int i, int i2) {
            super(i, i2);
            this.d = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.a
        public void a() {
            int i = this.a;
            Subscriber<? super Integer> subscriber = this.d;
            for (int i2 = this.b; i2 != i; i2++) {
                if (!this.c) {
                    subscriber.onNext(Integer.valueOf(i2));
                } else {
                    return;
                }
            }
            if (!this.c) {
                subscriber.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.a
        public void b(long j) {
            int i = this.a;
            int i2 = this.b;
            Subscriber<? super Integer> subscriber = this.d;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == j || i2 == i) {
                        if (i2 != i) {
                            j = get();
                            if (j2 == j) {
                                this.b = i2;
                                j = addAndGet(-j2);
                            }
                        } else if (!this.c) {
                            subscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.c) {
                        subscriber.onNext(Integer.valueOf(i2));
                        j2++;
                        i2++;
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }
    }

    public FlowableRange(int i, int i2) {
        this.b = i;
        this.c = i + i2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Integer> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe(new b((ConditionalSubscriber) subscriber, this.b, this.c));
        } else {
            subscriber.onSubscribe(new c(subscriber, this.b, this.c));
        }
    }
}
