package r6.a.a.h;

import hu.akarnokd.rxjava2.operators.BasicEmitter;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class o<T, R> extends Flowable<R> implements FlowableTransformer<T, R> {
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

        @Override // io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscription
        public void cancel() {
            this.s.cancel();
        }

        @Override // hu.akarnokd.rxjava2.operators.BasicEmitter
        public void doComplete() {
            if (!this.done) {
                this.s.cancel();
                this.done = true;
            }
        }

        @Override // hu.akarnokd.rxjava2.operators.BasicEmitter
        public void doError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.s.cancel();
            this.done = true;
            this.d = th;
        }

        @Override // hu.akarnokd.rxjava2.operators.BasicEmitter
        public void doNext(R r) {
            if (this.b) {
                doError(new IllegalStateException("doNext already called"));
                return;
            }
            this.c = r;
            this.b = true;
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.s.request(1);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public R poll() throws Exception {
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
                    this.s.request(1);
                }
            }
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber, org.reactivestreams.Subscription
        public void request(long j) {
            this.s.request(j);
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.sourceMode != 0) {
                return this.actual.tryOnNext(null);
            }
            try {
                this.a.accept(t, this);
                boolean z = this.b;
                this.b = false;
                if (z) {
                    R r = this.c;
                    this.c = null;
                    z = this.actual.tryOnNext(r);
                }
                if (!this.done) {
                    return z;
                }
                Throwable th = this.d;
                this.d = null;
                if (th != null) {
                    this.actual.onError(th);
                } else {
                    this.actual.onComplete();
                }
                return true;
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.s.cancel();
                Throwable th3 = this.d;
                this.d = null;
                if (th3 != null) {
                    this.actual.onError(new CompositeException(th3, th2));
                } else {
                    this.actual.onError(th2);
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

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscription
        public void cancel() {
            this.s.cancel();
        }

        @Override // hu.akarnokd.rxjava2.operators.BasicEmitter
        public void doComplete() {
            if (!this.done) {
                this.s.cancel();
                this.done = true;
            }
        }

        @Override // hu.akarnokd.rxjava2.operators.BasicEmitter
        public void doError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.s.cancel();
            this.done = true;
            this.d = th;
        }

        @Override // hu.akarnokd.rxjava2.operators.BasicEmitter
        public void doNext(R r) {
            if (this.b) {
                doError(new IllegalStateException("doNext already called"));
                return;
            }
            this.c = r;
            this.b = true;
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.s.request(1);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public R poll() throws Exception {
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
                    this.s.request(1);
                }
            }
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscription
        public void request(long j) {
            this.s.request(j);
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.sourceMode != 0) {
                this.actual.onNext(null);
                return true;
            }
            try {
                this.a.accept(t, this);
                boolean z = this.b;
                this.b = false;
                if (z) {
                    R r = this.c;
                    this.c = null;
                    this.actual.onNext(r);
                }
                if (!this.done) {
                    return z;
                }
                Throwable th = this.d;
                this.d = null;
                if (th != null) {
                    this.actual.onError(th);
                } else {
                    this.actual.onComplete();
                }
                return true;
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.s.cancel();
                Throwable th3 = this.d;
                this.d = null;
                if (th3 != null) {
                    this.actual.onError(new CompositeException(th3, th2));
                } else {
                    this.actual.onError(th2);
                }
                return true;
            }
        }
    }

    public o(Publisher<T> publisher, BiConsumer<? super T, ? super BasicEmitter<R>> biConsumer) {
        this.b = publisher;
        this.c = biConsumer;
    }

    @Override // io.reactivex.FlowableTransformer
    public Publisher<R> apply(Flowable<T> flowable) {
        return new o(flowable, this.c);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.b.subscribe(new a((ConditionalSubscriber) subscriber, this.c));
        } else {
            this.b.subscribe(new b(subscriber, this.c));
        }
    }
}
