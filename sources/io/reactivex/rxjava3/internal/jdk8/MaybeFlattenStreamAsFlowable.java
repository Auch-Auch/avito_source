package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import org.reactivestreams.Subscriber;
public final class MaybeFlattenStreamAsFlowable<T, R> extends Flowable<R> {
    public final Maybe<T> b;
    public final Function<? super T, ? extends Stream<? extends R>> c;

    public static final class a<T, R> extends BasicIntQueueSubscription<R> implements MaybeObserver<T>, SingleObserver<T> {
        private static final long serialVersionUID = 7363336003027148283L;
        public final Subscriber<? super R> a;
        public final Function<? super T, ? extends Stream<? extends R>> b;
        public final AtomicLong c = new AtomicLong();
        public Disposable d;
        public volatile Iterator<? extends R> e;
        public AutoCloseable f;
        public boolean g;
        public volatile boolean h;
        public boolean i;
        public long j;

        public a(Subscriber<? super R> subscriber, Function<? super T, ? extends Stream<? extends R>> function) {
            this.a = subscriber;
            this.b = function;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.h = true;
            this.d.dispose();
            if (!this.i) {
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.e = null;
            AutoCloseable autoCloseable = this.f;
            this.f = null;
            if (autoCloseable != null) {
                try {
                    autoCloseable.close();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.a;
                long j2 = this.j;
                long j3 = this.c.get();
                Iterator<? extends R> it = this.e;
                int i2 = 1;
                while (true) {
                    if (this.h) {
                        clear();
                    } else if (this.i) {
                        if (it != null) {
                            subscriber.onNext(null);
                            subscriber.onComplete();
                        }
                    } else if (!(it == null || j2 == j3)) {
                        try {
                            Object obj = (Object) it.next();
                            if (!this.h) {
                                subscriber.onNext(obj);
                                j2++;
                                if (!this.h) {
                                    try {
                                        boolean hasNext = it.hasNext();
                                        if (!this.h && !hasNext) {
                                            subscriber.onComplete();
                                            this.h = true;
                                        }
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        subscriber.onError(th);
                                        this.h = true;
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            subscriber.onError(th2);
                            this.h = true;
                        }
                    }
                    this.j = j2;
                    i2 = addAndGet(-i2);
                    if (i2 != 0) {
                        j3 = this.c.get();
                        if (it == null) {
                            it = this.e;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            Iterator<? extends R> it = this.e;
            if (it == null) {
                return true;
            }
            if (!this.g || it.hasNext()) {
                return false;
            }
            clear();
            return true;
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onError(@NonNull Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onSubscribe(@NonNull Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(@NonNull T t) {
            try {
                Object apply = this.b.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null Stream");
                Stream stream = (Stream) apply;
                Iterator<T> it = stream.iterator();
                if (!it.hasNext()) {
                    this.a.onComplete();
                    try {
                        stream.close();
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        RxJavaPlugins.onError(th);
                    }
                } else {
                    this.e = it;
                    this.f = stream;
                    drain();
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.a.onError(th2);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public R poll() throws Throwable {
            Iterator<? extends R> it = this.e;
            if (it == null) {
                return null;
            }
            if (!this.g) {
                this.g = true;
            } else if (!it.hasNext()) {
                clear();
                return null;
            }
            return (R) it.next();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.c, j2);
                drain();
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.i = true;
            return 2;
        }
    }

    public MaybeFlattenStreamAsFlowable(Maybe<T> maybe, Function<? super T, ? extends Stream<? extends R>> function) {
        this.b = maybe;
        this.c = function;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(@NonNull Subscriber<? super R> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }
}
