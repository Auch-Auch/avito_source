package io.reactivex.rxjava3.internal.fuseable;

import io.reactivex.rxjava3.functions.Supplier;
@FunctionalInterface
public interface ScalarSupplier<T> extends Supplier<T> {
    @Override // io.reactivex.rxjava3.functions.Supplier
    T get();
}
