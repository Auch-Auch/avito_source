package hu.akarnokd.rxjava3.util;

import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
public final class SpscOneQueue<T> extends AtomicReference<T> implements SimplePlainQueue<T> {
    private static final long serialVersionUID = -8766520133280966316L;

    @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    public void clear() {
        lazySet(null);
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return get() == null;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    public boolean offer(T t) {
        Objects.requireNonNull(t, "value is null");
        if (get() != null) {
            return false;
        }
        lazySet(t);
        return true;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue, io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    public T poll() {
        T t = (T) get();
        if (t != null) {
            lazySet(null);
        }
        return t;
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException();
    }
}
