package hu.akarnokd.rxjava3.functions;

import io.reactivex.rxjava3.functions.BiConsumer;
public interface PlainBiConsumer<T1, T2> extends BiConsumer<T1, T2> {
    @Override // io.reactivex.rxjava3.functions.BiConsumer
    void accept(T1 t1, T2 t2);
}
