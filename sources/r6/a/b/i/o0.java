package r6.a.b.i;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeConverter;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class o0<T, R> extends Flowable<R> implements MaybeConverter<T, Flowable<R>> {
    public final Maybe<T> b;
    public final Function<? super T, ? extends Publisher<? extends R>> c;
    public final Function<? super Throwable, ? extends Publisher<? extends R>> d;
    public final Supplier<? extends Publisher<? extends R>> e;

    public static final class a<T, R> implements MaybeObserver<T>, Subscription {
        public final C0658a<R> a;
        public final Function<? super T, ? extends Publisher<? extends R>> b;
        public final Function<? super Throwable, ? extends Publisher<? extends R>> c;
        public final Supplier<? extends Publisher<? extends R>> d;
        public Disposable e;

        /* renamed from: r6.a.b.i.o0$a$a  reason: collision with other inner class name */
        public static final class C0658a<R> extends AtomicReference<Subscription> implements FlowableSubscriber<R> {
            private static final long serialVersionUID = 314442824941893429L;
            public final Subscriber<? super R> a;
            public final AtomicLong b = new AtomicLong();

            public C0658a(Subscriber<? super R> subscriber) {
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

        public a(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, Function<? super Throwable, ? extends Publisher<? extends R>> function2, Supplier<? extends Publisher<? extends R>> supplier) {
            this.a = new C0658a<>(subscriber);
            this.b = function;
            this.c = function2;
            this.d = supplier;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.e.dispose();
            SubscriptionHelper.cancel(this.a);
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            try {
                Publisher publisher = (Publisher) this.d.get();
                Objects.requireNonNull(publisher, "The onCompleteHandler returned a null Publisher");
                publisher.subscribe(this.a);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.a.a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
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

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.a.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.MaybeObserver, io.reactivex.rxjava3.core.SingleObserver
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
            C0658a<R> aVar = this.a;
            SubscriptionHelper.deferredRequest(aVar, aVar.b, j);
        }
    }

    public o0(Maybe<T> maybe, Function<? super T, ? extends Publisher<? extends R>> function, Function<? super Throwable, ? extends Publisher<? extends R>> function2, Supplier<? extends Publisher<? extends R>> supplier) {
        this.b = maybe;
        this.c = function;
        this.d = function2;
        this.e = supplier;
    }

    @Override // io.reactivex.rxjava3.core.MaybeConverter
    public Object apply(Maybe maybe) {
        return new o0(maybe, this.c, this.d, this.e);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe(new a(subscriber, this.c, this.d, this.e));
    }
}
