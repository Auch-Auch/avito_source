package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;
public final class FlowableDistinctUntilChanged<T, K> extends s6.a.e.d.c.a.a<T, T> {
    public final Function<? super T, K> b;
    public final BiPredicate<? super K, ? super K> c;

    public static final class a<T, K> extends BasicFuseableConditionalSubscriber<T, T> {
        public final Function<? super T, K> a;
        public final BiPredicate<? super K, ? super K> b;
        public K c;
        public boolean d;

        public a(ConditionalSubscriber<? super T> conditionalSubscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(conditionalSubscriber);
            this.a = function;
            this.b = biPredicate;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.upstream.request(1);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Throwable {
            while (true) {
                T poll = this.qs.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.a.apply(poll);
                if (!this.d) {
                    this.d = true;
                    this.c = apply;
                    return poll;
                } else if (!this.b.test(this.c, apply)) {
                    this.c = apply;
                    return poll;
                } else {
                    this.c = apply;
                    if (this.sourceMode != 1) {
                        this.upstream.request(1);
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            if (this.sourceMode != 0) {
                return this.downstream.tryOnNext(t);
            }
            try {
                K apply = this.a.apply(t);
                if (this.d) {
                    boolean test = this.b.test(this.c, apply);
                    this.c = apply;
                    if (test) {
                        return false;
                    }
                } else {
                    this.d = true;
                    this.c = apply;
                }
                this.downstream.onNext(t);
                return true;
            } catch (Throwable th) {
                fail(th);
                return true;
            }
        }
    }

    public static final class b<T, K> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {
        public final Function<? super T, K> a;
        public final BiPredicate<? super K, ? super K> b;
        public K c;
        public boolean d;

        public b(Subscriber<? super T> subscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(subscriber);
            this.a = function;
            this.b = biPredicate;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.upstream.request(1);
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() throws Throwable {
            while (true) {
                T poll = this.qs.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.a.apply(poll);
                if (!this.d) {
                    this.d = true;
                    this.c = apply;
                    return poll;
                } else if (!this.b.test(this.c, apply)) {
                    this.c = apply;
                    return poll;
                } else {
                    this.c = apply;
                    if (this.sourceMode != 1) {
                        this.upstream.request(1);
                    }
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.done) {
                return false;
            }
            if (this.sourceMode != 0) {
                this.downstream.onNext(t);
                return true;
            }
            try {
                K apply = this.a.apply(t);
                if (this.d) {
                    boolean test = this.b.test(this.c, apply);
                    this.c = apply;
                    if (test) {
                        return false;
                    }
                } else {
                    this.d = true;
                    this.c = apply;
                }
                this.downstream.onNext(t);
                return true;
            } catch (Throwable th) {
                fail(th);
                return true;
            }
        }
    }

    public FlowableDistinctUntilChanged(Flowable<T> flowable, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(flowable);
        this.b = function;
        this.c = biPredicate;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe((FlowableSubscriber) new a((ConditionalSubscriber) subscriber, this.b, this.c));
        } else {
            this.source.subscribe((FlowableSubscriber) new b(subscriber, this.b, this.c));
        }
    }
}
