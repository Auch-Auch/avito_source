package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Nono;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class a0<T> extends Flowable<T> {
    public final Nono b;
    public final Function<? super Throwable, ? extends Publisher<? extends T>> c;
    public final Callable<? extends Publisher<? extends T>> d;

    public static final class a<T> extends AtomicReference<Subscription> implements Subscriber<Void>, Subscription {
        private static final long serialVersionUID = -1838187298176717779L;
        public final Subscriber<? super T> a;
        public final Function<? super Throwable, ? extends Publisher<? extends T>> b;
        public final Callable<? extends Publisher<? extends T>> c;
        public final AtomicLong d = new AtomicLong();
        public Subscription e;

        /* renamed from: r6.a.a.b.a0$a$a  reason: collision with other inner class name */
        public final class C0550a implements Subscriber<T> {
            public final Subscriber<? super T> a;

            public C0550a() {
                this.a = a.this.a;
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

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                a aVar = a.this;
                SubscriptionHelper.deferredSetOnce(aVar, aVar.d, subscription);
            }
        }

        public a(Subscriber<? super T> subscriber, Function<? super Throwable, ? extends Publisher<? extends T>> function, Callable<? extends Publisher<? extends T>> callable) {
            this.a = subscriber;
            this.b = function;
            this.c = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.e.cancel();
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            try {
                ((Publisher) ObjectHelper.requireNonNull(this.c.call(), "The onCompleteMapper returned a null Nono")).subscribe(new C0550a());
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            try {
                ((Publisher) ObjectHelper.requireNonNull(this.b.apply(th), "The onErrorMapper returned a null Nono")).subscribe(new C0550a());
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.a.onError(th2);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // org.reactivestreams.Subscriber
        public void onNext(Void r1) {
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this, this.d, j);
        }
    }

    public a0(Nono nono, Function<? super Throwable, ? extends Publisher<? extends T>> function, Callable<? extends Publisher<? extends T>> callable) {
        this.b = nono;
        this.c = function;
        this.d = callable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new a(subscriber, this.c, this.d));
    }
}
