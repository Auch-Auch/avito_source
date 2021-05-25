package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqual;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
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

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.b
        public void a(Throwable th) {
            if (this.e.addThrowable(th)) {
                drain();
            } else {
                RxJavaPlugins.onError(th);
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

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            FlowableSequenceEqual.c<T> cVar = this.c;
            Objects.requireNonNull(cVar);
            SubscriptionHelper.cancel(cVar);
            FlowableSequenceEqual.c<T> cVar2 = this.d;
            Objects.requireNonNull(cVar2);
            SubscriptionHelper.cancel(cVar2);
            if (getAndIncrement() == 0) {
                this.c.a();
                this.d.a();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.b
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
                                this.a.onError(this.e.terminate());
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
                                    this.e.addThrowable(th);
                                    this.a.onError(this.e.terminate());
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
                                    this.e.addThrowable(th2);
                                    this.a.onError(this.e.terminate());
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
                                    this.e.addThrowable(th3);
                                    this.a.onError(this.e.terminate());
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
                        this.a.onError(this.e.terminate());
                        return;
                    }
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }

        @Override // io.reactivex.disposables.Disposable
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

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public Flowable<Boolean> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableSequenceEqual(this.a, this.b, this.c, this.d));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        a aVar = new a(singleObserver, this.d, this.c);
        singleObserver.onSubscribe(aVar);
        Publisher<? extends T> publisher = this.a;
        Publisher<? extends T> publisher2 = this.b;
        publisher.subscribe(aVar.c);
        publisher2.subscribe(aVar.d);
    }
}
