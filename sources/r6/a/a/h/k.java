package r6.a.a.h;

import hu.akarnokd.rxjava2.operators.FlowableAsyncEmitter;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Cancellable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class k<T, S> extends Flowable<T> {
    public final Callable<S> b;
    public final BiFunction<? super S, ? super FlowableAsyncEmitter<T>, ? extends S> c;
    public final Consumer<? super S> d;

    public static final class a extends AtomicReference<Cancellable> {
        public static final Cancellable a = new C0594a();
        private static final long serialVersionUID = -8193511349691432602L;

        /* renamed from: r6.a.a.h.k$a$a  reason: collision with other inner class name */
        public static class C0594a implements Cancellable {
            @Override // io.reactivex.functions.Cancellable
            public void cancel() throws Exception {
            }
        }

        public void a(Cancellable cancellable) {
            if (cancellable != null) {
                try {
                    cancellable.cancel();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }

    public static final class b<T, S> extends AtomicInteger implements Subscription, FlowableAsyncEmitter<T> {
        private static final long serialVersionUID = -2460374219999425947L;
        public final Subscriber<? super T> a;
        public final AtomicInteger b = new AtomicInteger();
        public final AtomicLong c = new AtomicLong();
        public final a d = new a();
        public final BiFunction<? super S, ? super FlowableAsyncEmitter<T>, ? extends S> e;
        public final Consumer<? super S> f;
        public final AtomicThrowable g = new AtomicThrowable();
        public volatile S h;
        public T i;
        public volatile int j;
        public volatile boolean k;
        public volatile boolean l;
        public long m;

        public b(Subscriber<? super T> subscriber, S s, BiFunction<? super S, ? super FlowableAsyncEmitter<T>, ? extends S> biFunction, Consumer<? super S> consumer) {
            this.a = subscriber;
            this.h = s;
            this.e = biFunction;
            this.f = consumer;
        }

        public void a() {
            try {
                this.f.accept(this.h);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }

        public void b() {
            if (getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.a;
                long j2 = this.m;
                AtomicLong atomicLong = this.c;
                int i2 = 1;
                while (!this.l) {
                    boolean z = this.k;
                    int i3 = this.j;
                    if (!z || i3 != 4) {
                        int i4 = i3 & -5;
                        if (i4 == 1) {
                            if (j2 != atomicLong.get()) {
                                T t = this.i;
                                this.i = null;
                                subscriber.onNext(t);
                                j2++;
                                if ((i3 & 4) != 0) {
                                    this.j = 4;
                                } else {
                                    this.j = 0;
                                    c();
                                }
                            }
                        } else if (i4 == 2) {
                            if ((i3 & 4) != 0) {
                                this.j = 4;
                            } else {
                                this.j = 0;
                                c();
                            }
                        }
                        this.m = j2;
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        Throwable terminate = this.g.terminate();
                        if (terminate != null) {
                            subscriber.onError(terminate);
                        } else {
                            subscriber.onComplete();
                        }
                        a aVar = this.d;
                        aVar.a((Cancellable) aVar.getAndSet(a.a));
                        a();
                        return;
                    }
                }
                a();
            }
        }

        public void c() {
            if (this.b.getAndIncrement() == 0) {
                while (!this.l) {
                    try {
                        this.h = (S) this.e.apply(this.h, this);
                        if (this.b.decrementAndGet() == 0) {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        onError(th);
                        return;
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.l = true;
            a aVar = this.d;
            aVar.a((Cancellable) aVar.getAndSet(a.a));
            if (getAndIncrement() == 0) {
                a();
            }
        }

        @Override // hu.akarnokd.rxjava2.operators.FlowableAsyncEmitter
        public boolean isCancelled() {
            return this.l;
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            this.j |= 4;
            this.k = true;
            b();
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable th) {
            if (this.g.addThrowable(th)) {
                this.j |= 4;
                this.k = true;
                b();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t) {
            if (t != null) {
                this.i = t;
                this.j = 1;
                b();
                return;
            }
            onError(new NullPointerException("value is null"));
        }

        @Override // hu.akarnokd.rxjava2.operators.FlowableAsyncEmitter
        public void onNothing() {
            this.i = null;
            this.j = 2;
            b();
        }

        @Override // hu.akarnokd.rxjava2.operators.FlowableAsyncEmitter
        public boolean replaceCancellable(Cancellable cancellable) {
            Cancellable cancellable2;
            a aVar = this.d;
            do {
                cancellable2 = (Cancellable) aVar.get();
                if (cancellable2 == a.a) {
                    aVar.a(cancellable);
                    return false;
                }
            } while (!aVar.compareAndSet(cancellable2, cancellable));
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            BackpressureHelper.add(this.c, j2);
            b();
        }

        @Override // hu.akarnokd.rxjava2.operators.FlowableAsyncEmitter
        public boolean setCancellable(Cancellable cancellable) {
            Cancellable cancellable2;
            a aVar = this.d;
            do {
                cancellable2 = (Cancellable) aVar.get();
                if (cancellable2 == a.a) {
                    aVar.a(cancellable);
                    return false;
                }
            } while (!aVar.compareAndSet(cancellable2, cancellable));
            aVar.a(cancellable2);
            return true;
        }
    }

    public k(Callable<S> callable, BiFunction<? super S, ? super FlowableAsyncEmitter<T>, ? extends S> biFunction, Consumer<? super S> consumer) {
        this.b = callable;
        this.c = biFunction;
        this.d = consumer;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            b bVar = new b(subscriber, this.b.call(), this.c, this.d);
            subscriber.onSubscribe(bVar);
            bVar.c();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
