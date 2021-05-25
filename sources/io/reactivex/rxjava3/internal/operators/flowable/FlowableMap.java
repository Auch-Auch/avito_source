package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import java.util.Objects;
import org.reactivestreams.Subscriber;
public final class FlowableMap<T, U> extends s6.a.e.d.c.a.a<T, U> {
    public final Function<? super T, ? extends U> b;

    public static final class a<T, U> extends BasicFuseableConditionalSubscriber<T, U> {
        public final Function<? super T, ? extends U> a;

        public a(ConditionalSubscriber<? super U> conditionalSubscriber, Function<? super T, ? extends U> function) {
            super(conditionalSubscriber);
            this.a = function;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 0) {
                    this.downstream.onNext(null);
                    return;
                }
                try {
                    Object apply = this.a.apply(t);
                    Objects.requireNonNull(apply, "The mapper function returned a null value.");
                    this.downstream.onNext(apply);
                } catch (Throwable th) {
                    fail(th);
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public U poll() throws Throwable {
            T poll = this.qs.poll();
            if (poll == null) {
                return null;
            }
            U u = (U) this.a.apply(poll);
            Objects.requireNonNull(u, "The mapper function returned a null value.");
            return u;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber
        public boolean tryOnNext(T t) {
            if (this.done) {
                return true;
            }
            if (this.sourceMode != 0) {
                this.downstream.tryOnNext(null);
                return true;
            }
            try {
                Object apply = this.a.apply(t);
                Objects.requireNonNull(apply, "The mapper function returned a null value.");
                return this.downstream.tryOnNext(apply);
            } catch (Throwable th) {
                fail(th);
                return true;
            }
        }
    }

    public static final class b<T, U> extends BasicFuseableSubscriber<T, U> {
        public final Function<? super T, ? extends U> a;

        public b(Subscriber<? super U> subscriber, Function<? super T, ? extends U> function) {
            super(subscriber);
            this.a = function;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 0) {
                    this.downstream.onNext(null);
                    return;
                }
                try {
                    Object apply = this.a.apply(t);
                    Objects.requireNonNull(apply, "The mapper function returned a null value.");
                    this.downstream.onNext(apply);
                } catch (Throwable th) {
                    fail(th);
                }
            }
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public U poll() throws Throwable {
            T poll = this.qs.poll();
            if (poll == null) {
                return null;
            }
            U u = (U) this.a.apply(poll);
            Objects.requireNonNull(u, "The mapper function returned a null value.");
            return u;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }
    }

    public FlowableMap(Flowable<T> flowable, Function<? super T, ? extends U> function) {
        super(flowable);
        this.b = function;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super U> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe((FlowableSubscriber) new a((ConditionalSubscriber) subscriber, this.b));
        } else {
            this.source.subscribe((FlowableSubscriber) new b(subscriber, this.b));
        }
    }
}
