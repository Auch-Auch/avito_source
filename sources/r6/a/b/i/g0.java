package r6.a.b.i;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.FlowableTransformer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class g0<T> extends Flowable<T> implements FlowableTransformer<T, T> {
    public final Flowable<T> b;
    public final Predicate<? super T> c;
    public final Function<? super T, ? extends Publisher<? extends T>> d;

    public static final class a<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -3008387388867141204L;
        public final Subscriber<? super T> a;
        public final Predicate<? super T> b;
        public final Function<? super T, ? extends Publisher<? extends T>> c;
        public final C0653a<T> d;
        public Subscription e;
        public boolean f;
        public boolean g;

        /* renamed from: r6.a.b.i.g0$a$a  reason: collision with other inner class name */
        public static final class C0653a<T> extends AtomicLong implements FlowableSubscriber<T> {
            private static final long serialVersionUID = 6866823891735850338L;
            public final Subscriber<? super T> a;
            public final AtomicReference<Subscription> b = new AtomicReference<>();

            public C0653a(Subscriber<? super T> subscriber) {
                this.a = subscriber;
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                this.a.onComplete();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                this.a.onError(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(T t) {
                this.a.onNext(t);
            }

            @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.deferredSetOnce(this.b, this, subscription);
            }
        }

        public a(Subscriber<? super T> subscriber, Predicate<? super T> predicate, Function<? super T, ? extends Publisher<? extends T>> function) {
            this.a = subscriber;
            this.b = predicate;
            this.c = function;
            this.d = new C0653a<>(subscriber);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.e.cancel();
            SubscriptionHelper.cancel(this.d.b);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.g || this.f) {
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.g || this.f) {
                this.a.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.g) {
                this.g = true;
                Publisher publisher = null;
                try {
                    if (this.b.test(t)) {
                        Publisher publisher2 = (Publisher) this.c.apply(t);
                        Objects.requireNonNull(publisher2, "The selector returned a null Publisher");
                        publisher = publisher2;
                    }
                    if (publisher != null) {
                        this.e.cancel();
                        this.e = SubscriptionHelper.CANCELLED;
                        publisher.subscribe(this.d);
                    } else {
                        this.f = true;
                    }
                } catch (Throwable th) {
                    this.e.cancel();
                    this.a.onError(th);
                    return;
                }
            }
            if (this.f) {
                this.a.onNext(t);
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (compareAndSet(false, true)) {
                j--;
                this.e.request(1);
                if (j == 0) {
                    return;
                }
            }
            if (this.f) {
                this.e.request(j);
                return;
            }
            C0653a<T> aVar = this.d;
            if (aVar.b.get() == null) {
                this.e.request(j);
            }
            SubscriptionHelper.deferredRequest(aVar.b, aVar, j);
        }
    }

    public g0(Flowable<T> flowable, Predicate<? super T> predicate, Function<? super T, ? extends Publisher<? extends T>> function) {
        this.b = flowable;
        this.c = predicate;
        this.d = function;
    }

    @Override // io.reactivex.rxjava3.core.FlowableTransformer
    public Publisher<T> apply(Flowable<T> flowable) {
        return new g0(flowable, this.c, this.d);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe((FlowableSubscriber) new a(subscriber, this.c, this.d));
    }
}
