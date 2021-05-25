package r6.a.a.h;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
public final class s<T> extends Flowable<T> {
    public final Callable<T> b;

    public static final class a<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -231033913007168200L;
        public final ConditionalSubscriber<? super T> a;
        public final Callable<T> b;
        public volatile boolean c;

        public a(ConditionalSubscriber<? super T> conditionalSubscriber, Callable<T> callable) {
            this.a = conditionalSubscriber;
            this.b = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.c = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return false;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            return (T) ObjectHelper.requireNonNull(this.b.call(), "The callable returned a null value");
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    Callable<T> callable = this.b;
                    while (!this.c) {
                        try {
                            this.a.tryOnNext(ObjectHelper.requireNonNull(callable.call(), "The callable returned a null value"));
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.a.onError(th);
                            return;
                        }
                    }
                    return;
                }
                Callable<T> callable2 = this.b;
                do {
                    long j2 = 0;
                    while (true) {
                        if (j2 != j) {
                            if (!this.c) {
                                try {
                                    if (this.a.tryOnNext(ObjectHelper.requireNonNull(callable2.call(), "The callable returned a null value"))) {
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

        @Override // io.reactivex.internal.fuseable.QueueFuseable
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
        public final Callable<T> b;
        public volatile boolean c;

        public b(Subscriber<? super T> subscriber, Callable<T> callable) {
            this.a = subscriber;
            this.b = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.c = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return false;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            return (T) ObjectHelper.requireNonNull(this.b.call(), "The callable returned a null value");
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    Callable<T> callable = this.b;
                    while (!this.c) {
                        try {
                            this.a.onNext(ObjectHelper.requireNonNull(callable.call(), "The callable returned a null value"));
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.a.onError(th);
                            return;
                        }
                    }
                    return;
                }
                Callable<T> callable2 = this.b;
                do {
                    long j2 = 0;
                    while (true) {
                        if (j2 != j) {
                            if (!this.c) {
                                try {
                                    this.a.onNext(ObjectHelper.requireNonNull(callable2.call(), "The callable returned a null value"));
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

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 4) == 0) {
                return i & 1;
            }
            return 0;
        }
    }

    public s(Callable<T> callable) {
        this.b = callable;
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
