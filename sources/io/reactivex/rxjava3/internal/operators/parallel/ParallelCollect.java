package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class ParallelCollect<T, C> extends ParallelFlowable<C> {
    public final ParallelFlowable<? extends T> a;
    public final Supplier<? extends C> b;
    public final BiConsumer<? super C, ? super T> c;

    public static final class a<T, C> extends DeferredScalarSubscriber<T, C> {
        private static final long serialVersionUID = -4767392946044436228L;
        public final BiConsumer<? super C, ? super T> a;
        public C b;
        public boolean c;

        public a(Subscriber<? super C> subscriber, C c2, BiConsumer<? super C, ? super T> biConsumer) {
            super(subscriber);
            this.b = c2;
            this.a = biConsumer;
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber, io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.c) {
                this.c = true;
                C c2 = this.b;
                this.b = null;
                complete(c2);
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.c) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.c = true;
            this.b = null;
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.c) {
                try {
                    this.a.accept(this.b, t);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.DeferredScalarSubscriber, io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public ParallelCollect(ParallelFlowable<? extends T> parallelFlowable, Supplier<? extends C> supplier, BiConsumer<? super C, ? super T> biConsumer) {
        this.a = parallelFlowable;
        this.b = supplier;
        this.c = biConsumer;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.a.parallelism();
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super C>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<? super Object>[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                try {
                    Object obj = this.b.get();
                    Objects.requireNonNull(obj, "The initialSupplier returned a null value");
                    subscriberArr2[i] = new a(subscriberArr[i], obj, this.c);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    for (Subscriber<? super C> subscriber : subscriberArr) {
                        EmptySubscription.error(th, subscriber);
                    }
                    return;
                }
            }
            this.a.subscribe(subscriberArr2);
        }
    }
}
