package hu.akarnokd.rxjava2.functions;

import io.reactivex.functions.Function6;
public interface PlainFunction6<T1, T2, T3, T4, T5, T6, R> extends Function6<T1, T2, T3, T4, T5, T6, R> {
    @Override // io.reactivex.functions.Function6
    R apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t62);
}
