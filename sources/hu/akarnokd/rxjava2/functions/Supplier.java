package hu.akarnokd.rxjava2.functions;

import java.util.concurrent.Callable;
public interface Supplier<T> extends Callable<T> {
    @Override // java.util.concurrent.Callable
    T call();
}
