package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableBufferExactBoundary<T, U extends Collection<? super T>, B> extends s6.a.e.d.c.a.a<T, U> {
    public final Publisher<B> b;
    public final Supplier<U> c;

    public static final class a<T, U extends Collection<? super T>, B> extends DisposableSubscriber<B> {
        public final b<T, U, B> b;

        public a(b<T, U, B> bVar) {
            this.b = bVar;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.b.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            b<T, U, B> bVar = this.b;
            bVar.cancel();
            bVar.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B b2) {
            b<T, U, B> bVar = this.b;
            Objects.requireNonNull(bVar);
            try {
                U u = bVar.c.get();
                Objects.requireNonNull(u, "The buffer supplied is null");
                U u2 = u;
                synchronized (bVar) {
                    U u3 = bVar.g;
                    if (u3 != null) {
                        bVar.g = u2;
                        bVar.fastPathEmitMax(u3, false, bVar);
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                bVar.cancel();
                bVar.downstream.onError(th);
            }
        }
    }

    public static final class b<T, U extends Collection<? super T>, B> extends QueueDrainSubscriber<T, U, U> implements FlowableSubscriber<T>, Subscription, Disposable {
        public final Supplier<U> c;
        public final Publisher<B> d;
        public Subscription e;
        public Disposable f;
        public U g;

        public b(Subscriber<? super U> subscriber, Supplier<U> supplier, Publisher<B> publisher) {
            super(subscriber, new MpscLinkedQueue());
            this.c = supplier;
            this.d = publisher;
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber, io.reactivex.rxjava3.internal.util.QueueDrain
        public boolean accept(Subscriber subscriber, Object obj) {
            this.downstream.onNext((Collection) obj);
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.f.dispose();
                this.e.cancel();
                if (enter()) {
                    this.queue.clear();
                }
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            cancel();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.g;
                if (u != null) {
                    this.g = null;
                } else {
                    return;
                }
            }
            this.queue.offer(u);
            this.done = true;
            if (enter()) {
                QueueDrainHelper.drainMaxLoop(this.queue, this.downstream, false, this, this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            cancel();
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                U u = this.g;
                if (u != null) {
                    u.add(t);
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                try {
                    U u = this.c.get();
                    Objects.requireNonNull(u, "The buffer supplied is null");
                    this.g = u;
                    a aVar = new a(this);
                    this.f = aVar;
                    this.downstream.onSubscribe(this);
                    if (!this.cancelled) {
                        subscription.request(Long.MAX_VALUE);
                        this.d.subscribe(aVar);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.cancelled = true;
                    subscription.cancel();
                    EmptySubscription.error(th, this.downstream);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }
    }

    public FlowableBufferExactBoundary(Flowable<T> flowable, Publisher<B> publisher, Supplier<U> supplier) {
        super(flowable);
        this.b = publisher;
        this.c = supplier;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super U> subscriber) {
        this.source.subscribe((FlowableSubscriber) new b(new SerializedSubscriber(subscriber), this.c, this.b));
    }
}
