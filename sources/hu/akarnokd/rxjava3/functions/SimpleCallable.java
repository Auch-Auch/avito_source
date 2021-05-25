package hu.akarnokd.rxjava3.functions;

import java.util.concurrent.Callable;
public interface SimpleCallable<T> extends Callable<T> {
    @Override // java.util.concurrent.Callable
    T call();
}
