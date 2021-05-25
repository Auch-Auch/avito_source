package hu.akarnokd.rxjava2.functions;

import io.reactivex.functions.Function;
public interface PlainFunction<T, R> extends Function<T, R> {
    @Override // io.reactivex.functions.Function
    R apply(T t);
}
