package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;
public final class FlowableRangeLong extends Flowable<Long> {
    public final long b;
    public final long c;

    public static abstract class a extends BasicQueueSubscription<Long> {
        private static final long serialVersionUID = -2252972430506210021L;
        public final long a;
        public long b;
        public volatile boolean c;

        public a(long j, long j2) {
            this.b = j;
            this.a = j2;
        }

        public abstract void a();

        public abstract void b(long j);

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.c = true;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public final void clear() {
            this.b = this.a;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.b == this.a;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public Object poll() throws Throwable {
            long j = this.b;
            if (j == this.a) {
                return null;
            }
            this.b = 1 + j;
            return Long.valueOf(j);
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

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            return i & 1;
        }
    }

    public static final class b extends a {
        private static final long serialVersionUID = 2587302975077663557L;
        public final ConditionalSubscriber<? super Long> d;

        public b(ConditionalSubscriber<? super Long> conditionalSubscriber, long j, long j2) {
            super(j, j2);
            this.d = conditionalSubscriber;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableRangeLong.a
        public void a() {
            long j = this.a;
            ConditionalSubscriber<? super Long> conditionalSubscriber = this.d;
            for (long j2 = this.b; j2 != j; j2++) {
                if (!this.c) {
                    conditionalSubscriber.tryOnNext(Long.valueOf(j2));
                } else {
                    return;
                }
            }
            if (!this.c) {
                conditionalSubscriber.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableRangeLong.a
        public void b(long j) {
            long j2 = this.a;
            long j3 = this.b;
            ConditionalSubscriber<? super Long> conditionalSubscriber = this.d;
            do {
                long j4 = 0;
                while (true) {
                    if (j4 == j || j3 == j2) {
                        if (j3 != j2) {
                            j = get();
                            if (j4 == j) {
                                this.b = j3;
                                j = addAndGet(-j4);
                            }
                        } else if (!this.c) {
                            conditionalSubscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.c) {
                        if (conditionalSubscriber.tryOnNext(Long.valueOf(j3))) {
                            j4++;
                        }
                        j3++;
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }
    }

    public static final class c extends a {
        private static final long serialVersionUID = 2587302975077663557L;
        public final Subscriber<? super Long> d;

        public c(Subscriber<? super Long> subscriber, long j, long j2) {
            super(j, j2);
            this.d = subscriber;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableRangeLong.a
        public void a() {
            long j = this.a;
            Subscriber<? super Long> subscriber = this.d;
            for (long j2 = this.b; j2 != j; j2++) {
                if (!this.c) {
                    subscriber.onNext(Long.valueOf(j2));
                } else {
                    return;
                }
            }
            if (!this.c) {
                subscriber.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableRangeLong.a
        public void b(long j) {
            long j2 = this.a;
            long j3 = this.b;
            Subscriber<? super Long> subscriber = this.d;
            do {
                long j4 = 0;
                while (true) {
                    if (j4 == j || j3 == j2) {
                        if (j3 != j2) {
                            j = get();
                            if (j4 == j) {
                                this.b = j3;
                                j = addAndGet(-j4);
                            }
                        } else if (!this.c) {
                            subscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.c) {
                        subscriber.onNext(Long.valueOf(j3));
                        j4++;
                        j3++;
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }
    }

    public FlowableRangeLong(long j, long j2) {
        this.b = j;
        this.c = j + j2;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe(new b((ConditionalSubscriber) subscriber, this.b, this.c));
        } else {
            subscriber.onSubscribe(new c(subscriber, this.b, this.c));
        }
    }
}
