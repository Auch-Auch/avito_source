package hu.akarnokd.rxjava2.functions;

import io.reactivex.functions.BiFunction;
public interface PlainBiFunction<T1, T2, R> extends BiFunction<T1, T2, R> {
    @Override // io.reactivex.functions.BiFunction
    R apply(T1 t1, T2 t2);
}
