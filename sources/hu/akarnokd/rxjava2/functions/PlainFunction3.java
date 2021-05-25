package hu.akarnokd.rxjava2.functions;

import io.reactivex.functions.Function3;
public interface PlainFunction3<T1, T2, T3, R> extends Function3<T1, T2, T3, R> {
    @Override // io.reactivex.functions.Function3
    R apply(T1 t1, T2 t2, T3 t3);
}
