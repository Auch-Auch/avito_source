package hu.akarnokd.rxjava3.functions;

import io.reactivex.rxjava3.functions.Function5;
public interface PlainFunction5<T1, T2, T3, T4, T5, R> extends Function5<T1, T2, T3, T4, T5, R> {
    @Override // io.reactivex.rxjava3.functions.Function5
    R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5);
}
