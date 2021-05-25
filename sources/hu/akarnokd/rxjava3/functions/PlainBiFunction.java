package hu.akarnokd.rxjava3.functions;

import io.reactivex.rxjava3.functions.BiFunction;
public interface PlainBiFunction<T1, T2, R> extends BiFunction<T1, T2, R> {
    @Override // io.reactivex.rxjava3.functions.BiFunction
    R apply(T1 t1, T2 t2);
}
