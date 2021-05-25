package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowableSwitchMapSingle<T, R> extends Flowable<R> {
    public final Flowable<T> b;
    public final Function<? super T, ? extends SingleSource<? extends R>> c;
    public final boolean d;

    public static final class a<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        public static final C0470a<Object> k = new C0470a<>(null);
        private static final long serialVersionUID = -5402190102429853762L;
        public final Subscriber<? super R> a;
        public final Function<? super T, ? extends SingleSource<? extends R>> b;
        public final boolean c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final AtomicLong e = new AtomicLong();
        public final AtomicReference<C0470a<R>> f = new AtomicReference<>();
        public Subscription g;
        public volatile boolean h;
        public volatile boolean i;
        public long j;

        /* renamed from: io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapSingle$a$a  reason: collision with other inner class name */
        public static final class C0470a<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            public final a<?, R> a;
            public volatile R b;

            public C0470a(a<?, R> aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onError(Throwable th) {
                a<?, R> aVar = this.a;
                if (!aVar.f.compareAndSet(this, null)) {
                    RxJavaPlugins.onError(th);
                } else if (aVar.d.tryAddThrowableOrReport(th)) {
                    if (!aVar.c) {
                        aVar.g.cancel();
                        aVar.a();
                    }
                    aVar.b();
                }
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.rxjava3.core.SingleObserver
            public void onSuccess(R r) {
                this.b = r;
                this.a.b();
            }
        }

        public a(Subscriber<? super R> subscriber, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
            this.a = subscriber;
            this.b = function;
            this.c = z;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapSingle$a$a<R>> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a() {
            C0470a<Object> aVar = k;
            C0470a<Object> aVar2 = (C0470a) this.f.getAndSet(aVar);
            if (aVar2 != null && aVar2 != aVar) {
                DisposableHelper.dispose(aVar2);
            }
        }

        public void b() {
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.a;
                AtomicThrowable atomicThrowable = this.d;
                AtomicReference<C0470a<R>> atomicReference = this.f;
                AtomicLong atomicLong = this.e;
                long j2 = this.j;
                int i2 = 1;
                while (!this.i) {
                    if (atomicThrowable.get() == null || this.c) {
                        boolean z = this.h;
                        C0470a<R> aVar = atomicReference.get();
                        boolean z2 = aVar == null;
                        if (z && z2) {
                            atomicThrowable.tryTerminateConsumer(subscriber);
                            return;
                        } else if (z2 || aVar.b == null || j2 == atomicLong.get()) {
                            this.j = j2;
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else {
                            atomicReference.compareAndSet(aVar, null);
                            subscriber.onNext(aVar.b);
                            j2++;
                        }
                    } else {
                        atomicThrowable.tryTerminateConsumer(subscriber);
                        return;
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.i = true;
            this.g.cancel();
            a();
            this.d.tryTerminateAndReport();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.h = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.d.tryAddThrowableOrReport(th)) {
                if (!this.c) {
                    a();
                }
                this.h = true;
                b();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapSingle$a$a<R>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            C0470a<R> aVar;
            C0470a<R> aVar2 = this.f.get();
            if (aVar2 != null) {
                DisposableHelper.dispose(aVar2);
            }
            try {
                Object apply = this.b.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                SingleSource singleSource = (SingleSource) apply;
                C0470a<R> aVar3 = new C0470a<>(this);
                do {
                    aVar = this.f.get();
                    if (aVar == k) {
                        return;
                    }
                } while (!this.f.compareAndSet(aVar, aVar3));
                singleSource.subscribe(aVar3);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.g.cancel();
                this.f.getAndSet(k);
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.g, subscription)) {
                this.g = subscription;
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            BackpressureHelper.add(this.e, j2);
            b();
        }
    }

    public FlowableSwitchMapSingle(Flowable<T> flowable, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        this.b = flowable;
        this.c = function;
        this.d = z;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe((FlowableSubscriber) new a(subscriber, this.c, this.d));
    }
}
