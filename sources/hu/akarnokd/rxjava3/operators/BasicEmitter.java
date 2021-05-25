package hu.akarnokd.rxjava3.operators;
public interface BasicEmitter<T> {
    void doComplete();

    void doError(Throwable th);

    void doNext(T t);
}
