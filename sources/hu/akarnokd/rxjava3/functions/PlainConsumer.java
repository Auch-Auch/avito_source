package hu.akarnokd.rxjava3.functions;

import io.reactivex.rxjava3.functions.Consumer;
public interface PlainConsumer<T> extends Consumer<T> {
    @Override // io.reactivex.rxjava3.functions.Consumer
    void accept(T t);
}
