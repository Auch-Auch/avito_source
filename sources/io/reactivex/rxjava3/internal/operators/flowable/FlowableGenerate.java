package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableGenerate<T, S> extends Flowable<T> {
    public final Supplier<S> b;
    public final BiFunction<S, Emitter<T>, S> c;
    public final Consumer<? super S> d;

    public static final class a<T, S> extends AtomicLong implements Emitter<T>, Subscription {
        private static final long serialVersionUID = 7565982551505011832L;
        public final Subscriber<? super T> a;
        public final BiFunction<S, ? super Emitter<T>, S> b;
        public final Consumer<? super S> c;
        public S d;
        public volatile boolean e;
        public boolean f;
        public boolean g;

        public a(Subscriber<? super T> subscriber, BiFunction<S, ? super Emitter<T>, S> biFunction, Consumer<? super S> consumer, S s) {
            this.a = subscriber;
            this.b = biFunction;
            this.c = consumer;
            this.d = s;
        }

        public final void a(S s) {
            try {
                this.c.accept(s);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.e) {
                this.e = true;
                if (BackpressureHelper.add(this, 1) == 0) {
                    S s = this.d;
                    this.d = null;
                    a(s);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onComplete() {
            if (!this.f) {
                this.f = true;
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (th == null) {
                th = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
            }
            this.f = true;
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.Emitter
        public void onNext(T t) {
            if (this.f) {
                return;
            }
            if (this.g) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t == null) {
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
            } else {
                this.g = true;
                this.a.onNext(t);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
                S s = this.d;
                BiFunction<S, ? super Emitter<T>, S> biFunction = this.b;
                do {
                    long j2 = 0;
                    while (true) {
                        if (j2 == j) {
                            j = get();
                            if (j2 == j) {
                                this.d = s;
                                j = addAndGet(-j2);
                            }
                        } else if (this.e) {
                            this.d = null;
                            a(s);
                            return;
                        } else {
                            this.g = false;
                            try {
                                s = biFunction.apply(s, this);
                                if (this.f) {
                                    this.e = true;
                                    this.d = null;
                                    a(s);
                                    return;
                                }
                                j2++;
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.e = true;
                                this.d = null;
                                onError(th);
                                a(s);
                                return;
                            }
                        }
                    }
                } while (j != 0);
            }
        }
    }

    public FlowableGenerate(Supplier<S> supplier, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.b = supplier;
        this.c = biFunction;
        this.d = consumer;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            subscriber.onSubscribe(new a(subscriber, this.c, this.d, this.b.get()));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
