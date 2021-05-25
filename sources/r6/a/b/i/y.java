package r6.a.b.i;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Objects;
import org.reactivestreams.Subscriber;
public final class y<T> extends Flowable<T> {
    public final Supplier<T> b;

    public static final class a<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -231033913007168200L;
        public final ConditionalSubscriber<? super T> a;
        public final Supplier<T> b;
        public volatile boolean c;

        public a(ConditionalSubscriber<? super T> conditionalSubscriber, Supplier<T> supplier) {
            this.a = conditionalSubscriber;
            this.b = supplier;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.c = true;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return false;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() throws Throwable {
            T t = this.b.get();
            Objects.requireNonNull(t, "The supplier returned a null value");
            return t;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    Supplier<T> supplier = this.b;
                    while (!this.c) {
                        try {
                            T t = supplier.get();
                            Objects.requireNonNull(t, "The supplier returned a null value");
                            this.a.tryOnNext(t);
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.a.onError(th);
                            return;
                        }
                    }
                    return;
                }
                Supplier<T> supplier2 = this.b;
                do {
                    long j2 = 0;
                    while (true) {
                        if (j2 != j) {
                            if (!this.c) {
                                try {
                                    T t2 = supplier2.get();
                                    Objects.requireNonNull(t2, "The supplier returned a null value");
                                    if (this.a.tryOnNext(t2)) {
                                        j2++;
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    this.a.onError(th2);
                                    return;
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

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 4) == 0) {
                return i & 1;
            }
            return 0;
        }
    }

    public static final class b<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -231033913007168200L;
        public final Subscriber<? super T> a;
        public final Supplier<T> b;
        public volatile boolean c;

        public b(Subscriber<? super T> subscriber, Supplier<T> supplier) {
            this.a = subscriber;
            this.b = supplier;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.c = true;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return false;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public T poll() throws Throwable {
            T t = this.b.get();
            Objects.requireNonNull(t, "The supplier returned a null value");
            return t;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    Supplier<T> supplier = this.b;
                    while (!this.c) {
                        try {
                            T t = supplier.get();
                            Objects.requireNonNull(t, "The supplier returned a null value");
                            this.a.onNext(t);
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.a.onError(th);
                            return;
                        }
                    }
                    return;
                }
                Supplier<T> supplier2 = this.b;
                do {
                    long j2 = 0;
                    while (true) {
                        if (j2 != j) {
                            if (!this.c) {
                                try {
                                    T t2 = supplier2.get();
                                    Objects.requireNonNull(t2, "The supplier returned a null value");
                                    this.a.onNext(t2);
                                    j2++;
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    this.a.onError(th2);
                                    return;
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

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 4) == 0) {
                return i & 1;
            }
            return 0;
        }
    }

    public y(Supplier<T> supplier) {
        this.b = supplier;
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
