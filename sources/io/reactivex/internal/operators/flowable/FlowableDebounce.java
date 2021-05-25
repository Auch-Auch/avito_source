package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableDebounce<T, U> extends s6.a.c.b.a.a<T, T> {
    public final Function<? super T, ? extends Publisher<U>> b;

    public static final class a<T, U> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 6725975399620862591L;
        public final Subscriber<? super T> a;
        public final Function<? super T, ? extends Publisher<U>> b;
        public Subscription c;
        public final AtomicReference<Disposable> d = new AtomicReference<>();
        public volatile long e;
        public boolean f;

        /* renamed from: io.reactivex.internal.operators.flowable.FlowableDebounce$a$a  reason: collision with other inner class name */
        public static final class C0378a<T, U> extends DisposableSubscriber<U> {
            public final a<T, U> b;
            public final long c;
            public final T d;
            public boolean e;
            public final AtomicBoolean f = new AtomicBoolean();

            public C0378a(a<T, U> aVar, long j, T t) {
                this.b = aVar;
                this.c = j;
                this.d = t;
            }

            public void a() {
                if (this.f.compareAndSet(false, true)) {
                    a<T, U> aVar = this.b;
                    long j = this.c;
                    T t = this.d;
                    if (j != aVar.e) {
                        return;
                    }
                    if (aVar.get() != 0) {
                        aVar.a.onNext(t);
                        BackpressureHelper.produced(aVar, 1);
                        return;
                    }
                    aVar.cancel();
                    aVar.a.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                if (!this.e) {
                    this.e = true;
                    a();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                if (this.e) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.e = true;
                a<T, U> aVar = this.b;
                DisposableHelper.dispose(aVar.d);
                aVar.a.onError(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(U u) {
                if (!this.e) {
                    this.e = true;
                    cancel();
                    a();
                }
            }
        }

        public a(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<U>> function) {
            this.a = subscriber;
            this.b = function;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.c.cancel();
            DisposableHelper.dispose(this.d);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.f) {
                this.f = true;
                Disposable disposable = this.d.get();
                if (!DisposableHelper.isDisposed(disposable)) {
                    C0378a aVar = (C0378a) disposable;
                    if (aVar != null) {
                        aVar.a();
                    }
                    DisposableHelper.dispose(this.d);
                    this.a.onComplete();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.d);
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.f) {
                long j = this.e + 1;
                this.e = j;
                Disposable disposable = this.d.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                try {
                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.b.apply(t), "The publisher supplied is null");
                    C0378a aVar = new C0378a(this, j, t);
                    if (this.d.compareAndSet(disposable, aVar)) {
                        publisher.subscribe(aVar);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    this.a.onError(th);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this, j);
            }
        }
    }

    public FlowableDebounce(Flowable<T> flowable, Function<? super T, ? extends Publisher<U>> function) {
        super(flowable);
        this.b = function;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new a(new SerializedSubscriber(subscriber), this.b));
    }
}
