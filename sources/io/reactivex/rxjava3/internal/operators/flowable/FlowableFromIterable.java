package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Iterator;
import java.util.Objects;
import org.reactivestreams.Subscriber;
public final class FlowableFromIterable<T> extends Flowable<T> {
    public final Iterable<? extends T> b;

    public static abstract class a<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        public Iterator<? extends T> a;
        public volatile boolean b;
        public boolean c;

        public a(Iterator<? extends T> it) {
            this.a = it;
        }

        public abstract void a();

        public abstract void b(long j);

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.b = true;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public final void clear() {
            this.a = null;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            Iterator<? extends T> it = this.a;
            if (it == null) {
                return true;
            }
            if (!this.c || it.hasNext()) {
                return false;
            }
            this.a = null;
            return true;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public final T poll() {
            Iterator<? extends T> it = this.a;
            if (it == null) {
                return null;
            }
            if (!this.c) {
                this.c = true;
            } else if (!it.hasNext()) {
                return null;
            }
            T t = (T) this.a.next();
            Objects.requireNonNull(t, "Iterator.next() returned a null value");
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

    public static final class b<T> extends a<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        public final ConditionalSubscriber<? super T> d;

        public b(ConditionalSubscriber<? super T> conditionalSubscriber, Iterator<? extends T> it) {
            super(it);
            this.d = conditionalSubscriber;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableFromIterable.a
        public void a() {
            Iterator<? extends T> it = this.a;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.d;
            while (!this.b) {
                try {
                    Object obj = (Object) it.next();
                    if (!this.b) {
                        if (obj == 0) {
                            conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        conditionalSubscriber.tryOnNext(obj);
                        if (!this.b) {
                            try {
                                if (!it.hasNext()) {
                                    if (!this.b) {
                                        conditionalSubscriber.onComplete();
                                        return;
                                    }
                                    return;
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                conditionalSubscriber.onError(th);
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    conditionalSubscriber.onError(th2);
                    return;
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableFromIterable.a
        public void b(long j) {
            Iterator<? extends T> it = this.a;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.d;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == j) {
                        j = get();
                        if (j2 == j) {
                            j = addAndGet(-j2);
                        }
                    } else if (!this.b) {
                        try {
                            Object obj = (Object) it.next();
                            if (!this.b) {
                                if (obj == 0) {
                                    conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                                    return;
                                }
                                boolean tryOnNext = conditionalSubscriber.tryOnNext(obj);
                                if (!this.b) {
                                    try {
                                        if (!it.hasNext()) {
                                            if (!this.b) {
                                                conditionalSubscriber.onComplete();
                                                return;
                                            }
                                            return;
                                        } else if (tryOnNext) {
                                            j2++;
                                        }
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        conditionalSubscriber.onError(th);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            conditionalSubscriber.onError(th2);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }
    }

    public static final class c<T> extends a<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        public final Subscriber<? super T> d;

        public c(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
            super(it);
            this.d = subscriber;
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableFromIterable.a
        public void a() {
            Iterator<? extends T> it = this.a;
            Subscriber<? super T> subscriber = this.d;
            while (!this.b) {
                try {
                    Object obj = (Object) it.next();
                    if (!this.b) {
                        if (obj == 0) {
                            subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        subscriber.onNext(obj);
                        if (!this.b) {
                            try {
                                if (!it.hasNext()) {
                                    if (!this.b) {
                                        subscriber.onComplete();
                                        return;
                                    }
                                    return;
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                subscriber.onError(th);
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    subscriber.onError(th2);
                    return;
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableFromIterable.a
        public void b(long j) {
            Iterator<? extends T> it = this.a;
            Subscriber<? super T> subscriber = this.d;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == j) {
                        j = get();
                        if (j2 == j) {
                            j = addAndGet(-j2);
                        }
                    } else if (!this.b) {
                        try {
                            Object obj = (Object) it.next();
                            if (!this.b) {
                                if (obj == 0) {
                                    subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                                    return;
                                }
                                subscriber.onNext(obj);
                                if (!this.b) {
                                    try {
                                        if (it.hasNext()) {
                                            j2++;
                                        } else if (!this.b) {
                                            subscriber.onComplete();
                                            return;
                                        } else {
                                            return;
                                        }
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        subscriber.onError(th);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            subscriber.onError(th2);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }
    }

    public FlowableFromIterable(Iterable<? extends T> iterable) {
        this.b = iterable;
    }

    public static <T> void subscribe(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
        try {
            if (!it.hasNext()) {
                EmptySubscription.complete(subscriber);
            } else if (subscriber instanceof ConditionalSubscriber) {
                subscriber.onSubscribe(new b((ConditionalSubscriber) subscriber, it));
            } else {
                subscriber.onSubscribe(new c(subscriber, it));
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            subscribe(subscriber, this.b.iterator());
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
