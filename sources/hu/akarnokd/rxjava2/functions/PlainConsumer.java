package hu.akarnokd.rxjava2.functions;

import io.reactivex.functions.Consumer;
public interface PlainConsumer<T> extends Consumer<T> {
    @Override // io.reactivex.functions.Consumer
    void accept(T t);
}
