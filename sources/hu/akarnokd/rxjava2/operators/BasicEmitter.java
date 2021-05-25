package hu.akarnokd.rxjava2.operators;
public interface BasicEmitter<T> {
    void doComplete();

    void doError(Throwable th);

    void doNext(T t);
}
