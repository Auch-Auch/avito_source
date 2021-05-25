package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class SingleFlatMapPublisher<T, R> extends Flowable<R> {
    public final SingleSource<T> b;
    public final Function<? super T, ? extends Publisher<? extends R>> c;

    public SingleFlatMapPublisher(SingleSource<T> singleSource, Function<? super T, ? extends Publisher<? extends R>> function) {
        this.b = singleSource;
        this.c = function;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe(new a(subscriber, this.c));
    }

    public static final class a<S, T> extends AtomicLong implements SingleObserver<S>, FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 7759721921468635667L;
        public final Subscriber<? super T> a;
        public final Function<? super S, ? extends Publisher<? extends T>> b;
        public final AtomicReference<Subscription> c = new AtomicReference<>();
        public Disposable d;

        public a(Subscriber<? super T> subscriber, Function<? super S, ? extends Publisher<? extends T>> function) {
            this.a = subscriber;
            this.b = function;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.d.dispose();
            SubscriptionHelper.cancel(this.c);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.d = disposable;
            this.a.onSubscribe(this);
        }

        @Override // io.reactivex.rxjava3.core.SingleObserver
        public void onSuccess(S s) {
            try {
                Object apply = this.b.apply(s);
                Objects.requireNonNull(apply, "the mapper returned a null Publisher");
                Publisher publisher = (Publisher) apply;
                if (this.c.get() != SubscriptionHelper.CANCELLED) {
                    publisher.subscribe(this);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.c, this, j);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.c, this, subscription);
        }
    }
}
