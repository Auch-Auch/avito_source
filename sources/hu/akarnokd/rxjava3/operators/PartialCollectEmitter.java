package hu.akarnokd.rxjava3.operators;
public interface PartialCollectEmitter<T, I, A, R> {
    void cleanupItem(T t);

    void complete();

    long demand();

    void dropItems(int i);

    A getAccumulator();

    I getIndex();

    T getItem(int i);

    boolean isCancelled();

    boolean isComplete();

    void next(R r);

    void setAccumulator(A a);

    void setIndex(I i);

    int size();
}
