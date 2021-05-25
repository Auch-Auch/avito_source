package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSequenceEqual;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
public final class FlowableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {
    public final Publisher<? extends T> a;
    public final Publisher<? extends T> b;
    public final BiPredicate<? super T, ? super T> c;
    public final int d;

    public static final class a<T> extends AtomicInteger implements Disposable, FlowableSequenceEqual.b {
        private static final long serialVersionUID = -6178010334400373240L;
        public final SingleObserver<? super Boolean> a;
        public final BiPredicate<? super T, ? super T> b;
        public final FlowableSequenceEqual.c<T> c;
        public final FlowableSequenceEqual.c<T> d;
        public final AtomicThrowable e = new AtomicThrowable();
        public T f;
        public T g;

        public a(SingleObserver<? super Boolean> singleObserver, int i, BiPredicate<? super T, ? super T> biPredicate) {
            this.a = singleObserver;
            this.b = biPredicate;
            this.c = new FlowableSequenceEqual.c<>(this, i);
            this.d = new FlowableSequenceEqual.c<>(this, i);
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableSequenceEqual.b
        public void a(Throwable th) {
            if (this.e.tryAddThrowableOrReport(th)) {
                drain();
            }
        }

        public void b() {
            FlowableSequenceEqual.c<T> cVar = this.c;
            Objects.requireNonNull(cVar);
            SubscriptionHelper.cancel(cVar);
            this.c.a();
            FlowableSequenceEqual.c<T> cVar2 = this.d;
            Objects.requireNonNull(cVar2);
            SubscriptionHelper.cancel(cVar2);
            this.d.a();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            FlowableSequenceEqual.c<T> cVar = this.c;
            Objects.requireNonNull(cVar);
            SubscriptionHelper.cancel(cVar);
            FlowableSequenceEqual.c<T> cVar2 = this.d;
            Objects.requireNonNull(cVar2);
            SubscriptionHelper.cancel(cVar2);
            this.e.tryTerminateAndReport();
            if (getAndIncrement() == 0) {
                this.c.a();
                this.d.a();
            }
        }

        @Override // io.reactivex.rxjava3.internal.operators.flowable.FlowableSequenceEqual.b
        public void drain() {
            if (getAndIncrement() == 0) {
                int i = 1;
                do {
                    SimpleQueue<T> simpleQueue = this.c.e;
                    SimpleQueue<T> simpleQueue2 = this.d.e;
                    if (simpleQueue != null && simpleQueue2 != null) {
                        while (!isDisposed()) {
                            if (((Throwable) this.e.get()) != null) {
                                b();
                                this.e.tryTerminateConsumer(this.a);
                                return;
                            }
                            boolean z = this.c.f;
                            T t = this.f;
                            if (t == null) {
                                try {
                                    t = simpleQueue.poll();
                                    this.f = t;
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    b();
                                    this.e.tryAddThrowableOrReport(th);
                                    this.e.tryTerminateConsumer(this.a);
                                    return;
                                }
                            }
                            boolean z2 = false;
                            boolean z3 = t == null;
                            boolean z4 = this.d.f;
                            T t2 = this.g;
                            if (t2 == null) {
                                try {
                                    t2 = simpleQueue2.poll();
                                    this.g = t2;
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    b();
                                    this.e.tryAddThrowableOrReport(th2);
                                    this.e.tryTerminateConsumer(this.a);
                                    return;
                                }
                            }
                            if (t2 == null) {
                                z2 = true;
                            }
                            if (z && z4 && z3 && z2) {
                                this.a.onSuccess(Boolean.TRUE);
                                return;
                            } else if (z && z4 && z3 != z2) {
                                b();
                                this.a.onSuccess(Boolean.FALSE);
                                return;
                            } else if (!z3 && !z2) {
                                try {
                                    if (!this.b.test(t, t2)) {
                                        b();
                                        this.a.onSuccess(Boolean.FALSE);
                                        return;
                                    }
                                    this.f = null;
                                    this.g = null;
                                    this.c.b();
                                    this.d.b();
                                } catch (Throwable th3) {
                                    Exceptions.throwIfFatal(th3);
                                    b();
                                    this.e.tryAddThrowableOrReport(th3);
                                    this.e.tryTerminateConsumer(this.a);
                                    return;
                                }
                            }
                        }
                        this.c.a();
                        this.d.a();
                        return;
                    } else if (isDisposed()) {
                        this.c.a();
                        this.d.a();
                        return;
                    } else if (((Throwable) this.e.get()) != null) {
                        b();
                        this.e.tryTerminateConsumer(this.a);
                        return;
                    }
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.c.get() == SubscriptionHelper.CANCELLED;
        }
    }

    public FlowableSequenceEqualSingle(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        this.a = publisher;
        this.b = publisher2;
        this.c = biPredicate;
        this.d = i;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.FuseToFlowable
    public Flowable<Boolean> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableSequenceEqual(this.a, this.b, this.c, this.d));
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        a aVar = new a(singleObserver, this.d, this.c);
        singleObserver.onSubscribe(aVar);
        Publisher<? extends T> publisher = this.a;
        Publisher<? extends T> publisher2 = this.b;
        publisher.subscribe(aVar.c);
        publisher2.subscribe(aVar.d);
    }
}
