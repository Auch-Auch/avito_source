package r6.a.b.i;

import hu.akarnokd.rxjava3.operators.BasicEmitter;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableTransformer;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class t<T, R> extends Flowable<R> implements FlowableTransformer<T, R> {
    public final Publisher<T> b;
    public final BiConsumer<? super T, ? super BasicEmitter<R>> c;

    public static final class a<T, R> extends BasicFuseableConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, BasicEmitter<R> {
        public final BiConsumer<? super T, ? super BasicEmitter<R>> a;
        public boolean b;
        public R c;
        public Throwable d;

        public a(ConditionalSubscriber<? super R> conditionalSubscriber, BiConsumer<? super T, ? super BasicEmitter<R>> biConsumer) {
            super(conditionalSubscriber);
            this.a = biConsumer;
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // hu.akarnokd.rxjava3.operators.BasicEmitter
        public void doComplete() {
            if (!this.done) {
                this.upstream.cancel();
                this.done = true;
            }
        }

        @Override // hu.akarnokd.rxjava3.operators.BasicEmitter
        public void doError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.upstream.cancel();
            this.done = true;
            this.d = th;
        }

        @Override // hu.akarnokd.rxjava3.operators.BasicEmitter
        public void doNext(R r) {
            if (this.b) {
                IllegalStateException illegalStateException = new IllegalStateException("doNext already called");
                if (this.done) {
                    RxJavaPlugins.onError(illegalStateException);
                    return;
                }
                this.upstream.cancel();
                this.done = true;
                this.d = illegalStateException;
                return;
            }
            this.c = r;
            this.b = true;
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.upstream.request(1);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public R poll() throws Throwable {
            while (true) {
                T poll = this.qs.poll();
                if (poll == null) {
                    if (this.done) {
                        Throwable th = this.d;
                        this.d = null;
                        if (th != null) {
                            throw th;
                        }
                    }
                    return null;
                }
                this.a.accept(poll, this);
                boolean z = this.b;
                this.b = false;
                if (z) {
                    R r = this.c;
                    this.c = null;
                    return r;
                } else if (this.done) {
                    Throwable th2 = this.d;
                    this.d = null;
                    if (th2 == null) {
                        return null;
                    }
                    throw th2;
                } else if (this.sourceMode != 1) {
                    this.upstream.request(1);
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscription
        public void request(long j) {
            this.upstream.request(j);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.sourceMode != 0) {
                return this.downstream.tryOnNext(null);
            }
            try {
                this.a.accept(t, this);
                boolean z = this.b;
                this.b = false;
                if (z) {
                    R r = this.c;
                    this.c = null;
                    z = this.downstream.tryOnNext(r);
                }
                if (!this.done) {
                    return z;
                }
                Throwable th = this.d;
                this.d = null;
                if (th != null) {
                    this.downstream.onError(th);
                } else {
                    this.downstream.onComplete();
                }
                return true;
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.upstream.cancel();
                Throwable th3 = this.d;
                this.d = null;
                if (th3 != null) {
                    this.downstream.onError(new CompositeException(th3, th2));
                } else {
                    this.downstream.onError(th2);
                }
                return true;
            }
        }
    }

    public static final class b<T, R> extends BasicFuseableSubscriber<T, R> implements ConditionalSubscriber<T>, BasicEmitter<R> {
        public final BiConsumer<? super T, ? super BasicEmitter<R>> a;
        public boolean b;
        public R c;
        public Throwable d;

        public b(Subscriber<? super R> subscriber, BiConsumer<? super T, ? super BasicEmitter<R>> biConsumer) {
            super(subscriber);
            this.a = biConsumer;
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // hu.akarnokd.rxjava3.operators.BasicEmitter
        public void doComplete() {
            if (!this.done) {
                this.upstream.cancel();
                this.done = true;
            }
        }

        @Override // hu.akarnokd.rxjava3.operators.BasicEmitter
        public void doError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.upstream.cancel();
            this.done = true;
            this.d = th;
        }

        @Override // hu.akarnokd.rxjava3.operators.BasicEmitter
        public void doNext(R r) {
            if (this.b) {
                IllegalStateException illegalStateException = new IllegalStateException("doNext already called");
                if (this.done) {
                    RxJavaPlugins.onError(illegalStateException);
                    return;
                }
                this.upstream.cancel();
                this.done = true;
                this.d = illegalStateException;
                return;
            }
            this.c = r;
            this.b = true;
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.upstream.request(1);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public R poll() throws Throwable {
            while (true) {
                T poll = this.qs.poll();
                if (poll == null) {
                    if (this.done) {
                        Throwable th = this.d;
                        this.d = null;
                        if (th != null) {
                            throw th;
                        }
                    }
                    return null;
                }
                this.a.accept(poll, this);
                boolean z = this.b;
                this.b = false;
                if (z) {
                    R r = this.c;
                    this.c = null;
                    return r;
                } else if (this.done) {
                    Throwable th2 = this.d;
                    this.d = null;
                    if (th2 == null) {
                        return null;
                    }
                    throw th2;
                } else if (this.sourceMode != 1) {
                    this.upstream.request(1);
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscription
        public void request(long j) {
            this.upstream.request(j);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.sourceMode != 0) {
                this.downstream.onNext(null);
                return true;
            }
            try {
                this.a.accept(t, this);
                boolean z = this.b;
                this.b = false;
                if (z) {
                    R r = this.c;
                    this.c = null;
                    this.downstream.onNext(r);
                }
                if (!this.done) {
                    return z;
                }
                Throwable th = this.d;
                this.d = null;
                if (th != null) {
                    this.downstream.onError(th);
                } else {
                    this.downstream.onComplete();
                }
                return true;
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.upstream.cancel();
                Throwable th3 = this.d;
                this.d = null;
                if (th3 != null) {
                    this.downstream.onError(new CompositeException(th3, th2));
                } else {
                    this.downstream.onError(th2);
                }
                return true;
            }
        }
    }

    public t(Publisher<T> publisher, BiConsumer<? super T, ? super BasicEmitter<R>> biConsumer) {
        this.b = publisher;
        this.c = biConsumer;
    }

    @Override // io.reactivex.rxjava3.core.FlowableTransformer
    public Publisher<R> apply(Flowable<T> flowable) {
        return new t(flowable, this.c);
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.b.subscribe(new a((ConditionalSubscriber) subscriber, this.c));
        } else {
            this.b.subscribe(new b(subscriber, this.c));
        }
    }
}
