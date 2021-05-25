package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlattenIterable;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;
public final class ParallelFlatMapIterable<T, R> extends ParallelFlowable<R> {
    public final ParallelFlowable<T> a;
    public final Function<? super T, ? extends Iterable<? extends R>> b;
    public final int c;

    public ParallelFlatMapIterable(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Iterable<? extends R>> function, int i) {
        this.a = parallelFlowable;
        this.b = function;
        this.c = i;
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public int parallelism() {
        return this.a.parallelism();
    }

    @Override // io.reactivex.rxjava3.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                subscriberArr2[i] = FlowableFlattenIterable.subscribe(subscriberArr[i], this.b, this.c);
            }
            this.a.subscribe(subscriberArr2);
        }
    }
}
