package r6.a.b.i;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableConverter;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
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
public final class b<R> extends Flowable<R> implements CompletableConverter<Flowable<R>> {
    public final Completable b;
    public final Supplier<? extends Publisher<? extends R>> c;
    public final Function<? super Throwable, ? extends Publisher<? extends R>> d;

    public static final class a<R> implements CompletableObserver, Subscription {
        public final C0643a<R> a;
        public final Supplier<? extends Publisher<? extends R>> b;
        public final Function<? super Throwable, ? extends Publisher<? extends R>> c;
        public Disposable d;

        /* renamed from: r6.a.b.i.b$a$a  reason: collision with other inner class name */
        public static final class C0643a<R> extends AtomicReference<Subscription> implements FlowableSubscriber<R> {
            private static final long serialVersionUID = 314442824941893429L;
            public final Subscriber<? super R> a;
            public final AtomicLong b = new AtomicLong();

            public C0643a(Subscriber<? super R> subscriber) {
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

        public a(Subscriber<? super R> subscriber, Supplier<? extends Publisher<? extends R>> supplier, Function<? super Throwable, ? extends Publisher<? extends R>> function) {
            this.a = new C0643a<>(subscriber);
            this.b = supplier;
            this.c = function;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.d.dispose();
            SubscriptionHelper.cancel(this.a);
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onComplete() {
            try {
                Publisher publisher = (Publisher) this.b.get();
                Objects.requireNonNull(publisher, "The onCompleteHandler returned a null Publisher");
                publisher.subscribe(this.a);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.a.a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
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

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.a.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            C0643a<R> aVar = this.a;
            SubscriptionHelper.deferredRequest(aVar, aVar.b, j);
        }
    }

    public b(Completable completable, Supplier<? extends Publisher<? extends R>> supplier, Function<? super Throwable, ? extends Publisher<? extends R>> function) {
        this.b = completable;
        this.c = supplier;
        this.d = function;
    }

    @Override // io.reactivex.rxjava3.core.CompletableConverter
    public Object apply(Completable completable) {
        return new b(completable, this.c, this.d);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe(new a(subscriber, this.c, this.d));
    }
}
