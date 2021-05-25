package hu.akarnokd.rxjava2.functions;

import io.reactivex.functions.BiConsumer;
public interface PlainBiConsumer<T1, T2> extends BiConsumer<T1, T2> {
    @Override // io.reactivex.functions.BiConsumer
    void accept(T1 t1, T2 t2);
}
