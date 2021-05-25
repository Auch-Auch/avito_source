package hu.akarnokd.rxjava3.functions;

import io.reactivex.rxjava3.functions.Function4;
public interface PlainFunction4<T1, T2, T3, T4, R> extends Function4<T1, T2, T3, T4, R> {
    @Override // io.reactivex.rxjava3.functions.Function4
    R apply(T1 t1, T2 t2, T3 t3, T4 t4);
}
