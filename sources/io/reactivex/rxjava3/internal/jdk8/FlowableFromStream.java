package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import org.reactivestreams.Subscriber;
public final class FlowableFromStream<T> extends Flowable<T> {
    public final Stream<T> b;

    public static abstract class a<T> extends AtomicLong implements QueueSubscription<T> {
        private static final long serialVersionUID = -9082954702547571853L;
        public Iterator<T> a;
        public AutoCloseable b;
        public volatile boolean c;
        public boolean d;

        public a(Iterator<T> it, AutoCloseable autoCloseable) {
            this.a = it;
            this.b = autoCloseable;
        }

        public abstract void a(long j);

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.c = true;
            request(1);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.a = null;
            AutoCloseable autoCloseable = this.b;
            this.b = null;
            if (autoCloseable != null) {
                FlowableFromStream.f(autoCloseable);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            Iterator<T> it = this.a;
            if (it == null) {
                return true;
            }
            if (!this.d || it.hasNext()) {
                return false;
            }
            clear();
            return true;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean offer(@NonNull T t) {
            throw new UnsupportedOperationException();
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            Iterator<T> it = this.a;
            if (it == null) {
                return null;
            }
            if (!this.d) {
                this.d = true;
            } else if (!it.hasNext()) {
                clear();
                return null;
            }
            T next = this.a.next();
            Objects.requireNonNull(next, "The Stream's Iterator.next() returned a null value");
            return next;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
                a(j);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            lazySet(Long.MAX_VALUE);
            return 1;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean offer(@NonNull T t, @NonNull T t2) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class b<T> extends a<T> {
        private static final long serialVersionUID = -9082954702547571853L;
        public final ConditionalSubscriber<? super T> e;

        public b(ConditionalSubscriber<? super T> conditionalSubscriber, Iterator<T> it, AutoCloseable autoCloseable) {
            super(it, autoCloseable);
            this.e = conditionalSubscriber;
        }

        @Override // io.reactivex.rxjava3.internal.jdk8.FlowableFromStream.a
        public void a(long j) {
            Iterator<T> it = this.a;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.e;
            long j2 = 0;
            while (!this.c) {
                try {
                    T next = it.next();
                    Objects.requireNonNull(next, "The Stream's Iterator returned a null value");
                    if (conditionalSubscriber.tryOnNext(next)) {
                        j2++;
                    }
                    if (this.c) {
                        continue;
                    } else {
                        try {
                            if (!it.hasNext()) {
                                conditionalSubscriber.onComplete();
                                this.c = true;
                            } else if (j2 != j) {
                                continue;
                            } else {
                                j = get();
                                if (j2 != j) {
                                    continue;
                                } else if (!compareAndSet(j, 0)) {
                                    j = get();
                                } else {
                                    return;
                                }
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            conditionalSubscriber.onError(th);
                            this.c = true;
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    conditionalSubscriber.onError(th2);
                    this.c = true;
                }
            }
            clear();
        }
    }

    public static final class c<T> extends a<T> {
        private static final long serialVersionUID = -9082954702547571853L;
        public final Subscriber<? super T> e;

        public c(Subscriber<? super T> subscriber, Iterator<T> it, AutoCloseable autoCloseable) {
            super(it, autoCloseable);
            this.e = subscriber;
        }

        @Override // io.reactivex.rxjava3.internal.jdk8.FlowableFromStream.a
        public void a(long j) {
            Iterator<T> it = this.a;
            Subscriber<? super T> subscriber = this.e;
            long j2 = 0;
            while (!this.c) {
                try {
                    T next = it.next();
                    Objects.requireNonNull(next, "The Stream's Iterator returned a null value");
                    subscriber.onNext(next);
                    if (this.c) {
                        continue;
                    } else {
                        try {
                            if (!it.hasNext()) {
                                subscriber.onComplete();
                                this.c = true;
                            } else {
                                j2++;
                                if (j2 != j) {
                                    continue;
                                } else {
                                    j = get();
                                    if (j2 != j) {
                                        continue;
                                    } else if (!compareAndSet(j, 0)) {
                                        j = get();
                                    } else {
                                        return;
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            subscriber.onError(th);
                            this.c = true;
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    subscriber.onError(th2);
                    this.c = true;
                }
            }
            clear();
        }
    }

    public FlowableFromStream(Stream<T> stream) {
        this.b = stream;
    }

    public static void f(AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
    }

    public static <T> void subscribeStream(Subscriber<? super T> subscriber, Stream<T> stream) {
        try {
            Iterator<T> it = stream.iterator();
            if (!it.hasNext()) {
                EmptySubscription.complete(subscriber);
                f(stream);
            } else if (subscriber instanceof ConditionalSubscriber) {
                subscriber.onSubscribe(new b((ConditionalSubscriber) subscriber, it, stream));
            } else {
                subscriber.onSubscribe(new c(subscriber, it, stream));
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
            f(stream);
        }
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        subscribeStream(subscriber, this.b);
    }
}
