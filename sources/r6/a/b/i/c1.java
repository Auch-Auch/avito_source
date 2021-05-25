package r6.a.b.i;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleConverter;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class c1<T, R> extends Flowable<R> implements SingleConverter<T, Flowable<R>> {
    public final Single<T> b;
    public final Function<? super T, ? extends Publisher<? extends R>> c;
    public final Function<? super Throwable, ? extends Publisher<? extends R>> d;

    public static final class a<T, R> implements SingleObserver<T>, Subscription {
        public final C0646a<R> a;
        public final Function<? super T, ? extends Publisher<? extends R>> b;
        public final Function<? super Throwable, ? extends Publisher<? extends R>> c;
        public Disposable d;

        /* renamed from: r6.a.b.i.c1$a$a  reason: collision with other inner class name */
        public static final class C0646a<R> extends AtomicReference<Subscription> implements FlowableSubscriber<R> {
            private static final long serialVersionUID = 314442824941893429L;
            public final Subscriber<? super R> a;
            public final AtomicLong b = new AtomicLong();

            public C0646a(Subscriber<? super R> subscriber) {
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
            public void onNext(R r) {
                this.a.onNext(r);
            }

            @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.deferredSetOnce(this, this.b, subscription);
            }
        }

        public a(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, Function<? super Throwable, ? extends Publisher<? extends R>> function2) {
            this.a = new C0646a<>(subscriber);
            this.b = function;
            this.c = function2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.d.dispose();
            SubscriptionHelper.cancel(this.a);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onError(Throwable th) {
            try {
                Publisher publisher = (Publisher) this.c.apply(th);
                Objects.requireNonNull(publisher, "The onErrorHandler returned a null Publisher");
                publisher.subscribe(this.a);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.a.a.onError(th2);
            }
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.a.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(T t) {
            try {
                Publisher publisher = (Publisher) this.b.apply(t);
                Objects.requireNonNull(publisher, "The onSuccessHandler returned a null Publisher");
                publisher.subscribe(this.a);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.a.a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            C0646a<R> aVar = this.a;
            SubscriptionHelper.deferredRequest(aVar, aVar.b, j);
        }
    }

    public c1(Single<T> single, Function<? super T, ? extends Publisher<? extends R>> function, Function<? super Throwable, ? extends Publisher<? extends R>> function2) {
        this.b = single;
        this.c = function;
        this.d = function2;
    }

    @Override // io.reactivex.rxjava3.core.SingleConverter
    public Object apply(Single single) {
        return new c1(single, this.c, this.d);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe(new a(subscriber, this.c, this.d));
    }
}
