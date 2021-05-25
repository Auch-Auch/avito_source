package hu.akarnokd.rxjava3.functions;

import io.reactivex.rxjava3.functions.Function8;
public interface PlainFunction8<T1, T2, T3, T4, T5, T6, T7, T8, R> extends Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> {
    @Override // io.reactivex.rxjava3.functions.Function8
    R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62, T7 t7, T8 t8);
}
