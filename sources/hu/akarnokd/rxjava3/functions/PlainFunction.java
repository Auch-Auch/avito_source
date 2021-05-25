package hu.akarnokd.rxjava3.functions;

import io.reactivex.rxjava3.functions.Function;
public interface PlainFunction<T, R> extends Function<T, R> {
    @Override // io.reactivex.rxjava3.functions.Function
    R apply(T t);
}
