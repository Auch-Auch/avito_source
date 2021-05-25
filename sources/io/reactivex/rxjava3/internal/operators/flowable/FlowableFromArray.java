package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Objects;
import org.reactivestreams.Subscriber;
public final class FlowableFromArray<T> extends Flowable<T> {
    public final T[] b;

    public static final class a<T> extends c<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        public final ConditionalSubscriber<? super T> d;

        public a(ConditionalSubscriber<? super T> conditionalSubscriber, T[] tArr) {
            super(tArr);
            this.d = conditionalSubscriber;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableFromArray.c
        public void a() {
            T[] tArr = this.a;
            int length = tArr.length;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.d;
            for (int i = this.b; i != length; i++) {
                if (!this.c) {
                    T t = tArr[i];
                    if (t == null) {
                        conditionalSubscriber.onError(new NullPointerException(a2.b.a.a.a.Q2("The element at index ", i, " is null")));
                        return;
                    } else {
                        conditionalSubscriber.tryOnNext(t);
                    }
                } else {
                    return;
                }
            }
            if (!this.c) {
                conditionalSubscriber.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableFromArray.c
        public void b(long j) {
            T[] tArr = this.a;
            int length = tArr.length;
            int i = this.b;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.d;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == j || i == length) {
                        if (i != length) {
                            j = get();
                            if (j2 == j) {
                                this.b = i;
                                j = addAndGet(-j2);
                            }
                        } else if (!this.c) {
                            conditionalSubscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.c) {
                        T t = tArr[i];
                        if (t == null) {
                            conditionalSubscriber.onError(new NullPointerException(a2.b.a.a.a.Q2("The element at index ", i, " is null")));
                            return;
                        }
                        if (conditionalSubscriber.tryOnNext(t)) {
                            j2++;
                        }
                        i++;
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }
    }

    public static final class b<T> extends c<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        public final Subscriber<? super T> d;

        public b(Subscriber<? super T> subscriber, T[] tArr) {
            super(tArr);
            this.d = subscriber;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableFromArray.c
        public void a() {
            T[] tArr = this.a;
            int length = tArr.length;
            Subscriber<? super T> subscriber = this.d;
            for (int i = this.b; i != length; i++) {
                if (!this.c) {
                    T t = tArr[i];
                    if (t == null) {
                        subscriber.onError(new NullPointerException(a2.b.a.a.a.Q2("The element at index ", i, " is null")));
                        return;
                    } else {
                        subscriber.onNext(t);
                    }
                } else {
                    return;
                }
            }
            if (!this.c) {
                subscriber.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableFromArray.c
        public void b(long j) {
            T[] tArr = this.a;
            int length = tArr.length;
            int i = this.b;
            Subscriber<? super T> subscriber = this.d;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == j || i == length) {
                        if (i != length) {
                            j = get();
                            if (j2 == j) {
                                this.b = i;
                                j = addAndGet(-j2);
                            }
                        } else if (!this.c) {
                            subscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.c) {
                        T t = tArr[i];
                        if (t == null) {
                            subscriber.onError(new NullPointerException(a2.b.a.a.a.Q2("The element at index ", i, " is null")));
                            return;
                        }
                        subscriber.onNext(t);
                        j2++;
                        i++;
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }
    }

    public static abstract class c<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        public final T[] a;
        public int b;
        public volatile boolean c;

        public c(T[] tArr) {
            this.a = tArr;
        }

        public abstract void a();

        public abstract void b(long j);

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.c = true;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public final void clear() {
            this.b = this.a.length;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.b == this.a.length;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public final T poll() {
            int i = this.b;
            T[] tArr = this.a;
            if (i == tArr.length) {
                return null;
            }
            this.b = i + 1;
            T t = tArr[i];
            Objects.requireNonNull(t, "array element is null");
            return t;
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

    public FlowableFromArray(T[] tArr) {
        this.b = tArr;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe(new a((ConditionalSubscriber) subscriber, this.b));
        } else {
            subscriber.onSubscribe(new b(subscriber, this.b));
        }
    }
}
