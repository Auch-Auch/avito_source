package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Solo;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.LongConsumer;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class o3<T> extends Solo<T> {
    public final Solo<T> b;
    public final Consumer<? super T> c;
    public final Consumer<? super T> d;
    public final Consumer<? super Throwable> e;
    public final Action f;
    public final Action g;
    public final Consumer<? super Subscription> h;
    public final LongConsumer i;
    public final Action j;

    public final class a extends f<T> implements Subscriber<T> {
        public final Subscriber<? super T> a;
        public Subscription b;
        public QueueSubscription<T> c;
        public boolean d;
        public int e;

        public a(Subscriber<? super T> subscriber) {
            this.a = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            try {
                o3.this.j.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            this.b.cancel();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.c.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.c.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.d) {
                this.d = true;
                try {
                    o3.this.f.run();
                    this.a.onComplete();
                    try {
                        o3.this.g.run();
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        RxJavaPlugins.onError(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.a.onError(th2);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.d = true;
            try {
                o3.this.e.accept(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                th = new CompositeException(th, th2);
            }
            this.a.onError(th);
            try {
                o3.this.g.run();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(th3);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.d) {
                return;
            }
            if (this.e != 0) {
                this.a.onNext(null);
                return;
            }
            try {
                o3.this.c.accept(t);
                this.a.onNext(t);
                try {
                    o3.this.d.accept(t);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.b.cancel();
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.b.cancel();
                onError(th2);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.b, subscription)) {
                this.b = subscription;
                if (subscription instanceof QueueSubscription) {
                    this.c = (QueueSubscription) subscription;
                }
                try {
                    o3.this.h.accept(subscription);
                    this.a.onSubscribe(this);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    subscription.cancel();
                    this.a.onSubscribe(EmptySubscription.INSTANCE);
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            T poll = this.c.poll();
            if (poll != null) {
                o3.this.c.accept(poll);
                o3.this.d.accept(poll);
            } else if (this.e == 1) {
                o3.this.f.run();
                o3.this.g.run();
            }
            return poll;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            try {
                o3.this.i.accept(j);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            this.b.request(j);
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            QueueSubscription<T> queueSubscription = this.c;
            if (queueSubscription == null) {
                return 0;
            }
            int requestFusion = queueSubscription.requestFusion(i);
            this.e = requestFusion;
            return requestFusion;
        }
    }

    public o3(Solo<T> solo, Consumer<? super T> consumer, Consumer<? super T> consumer2, Consumer<? super Throwable> consumer3, Action action, Action action2, Consumer<? super Subscription> consumer4, LongConsumer longConsumer, Action action3) {
        this.b = solo;
        this.c = consumer;
        this.d = consumer2;
        this.e = consumer3;
        this.f = action;
        this.g = action2;
        this.h = consumer4;
        this.i = longConsumer;
        this.j = action3;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Solo
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new a(subscriber));
    }
}
