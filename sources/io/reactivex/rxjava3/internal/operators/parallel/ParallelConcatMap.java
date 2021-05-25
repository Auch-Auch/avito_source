package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class ParallelConcatMap<T, R> extends ParallelFlowable<R> {
    public final ParallelFlowable<T> a;
    public final Function<? super T, ? extends Publisher<? extends R>> b;
    public final int c;
    public final ErrorMode d;

    public ParallelConcatMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode) {
        this.a = parallelFlowable;
        Objects.requireNonNull(function, "mapper");
        this.b = function;
        this.c = i;
        Objects.requireNonNull(errorMode, "errorMode");
        this.d = errorMode;
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
                subscriberArr2[i] = FlowableConcatMap.subscribe(subscriberArr[i], this.b, this.c, this.d);
            }
            this.a.subscribe(subscriberArr2);
        }
    }
}
