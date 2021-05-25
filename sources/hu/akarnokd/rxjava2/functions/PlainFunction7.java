package hu.akarnokd.rxjava2.functions;

import io.reactivex.functions.Function7;
public interface PlainFunction7<T1, T2, T3, T4, T5, T6, T7, R> extends Function7<T1, T2, T3, T4, T5, T6, T7, R> {
    @Override // io.reactivex.functions.Function7
    R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62, T7 t7);
}
