package io.reactivex.rxjava3.internal.queue;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
public final class MpscLinkedQueue<T> implements SimplePlainQueue<T> {
    public final AtomicReference<a<T>> a;
    public final AtomicReference<a<T>> b;

    public static final class a<E> extends AtomicReference<a<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        public E a;

        public a() {
        }

        public a(E e) {
            this.a = e;
        }
    }

    public MpscLinkedQueue() {
        AtomicReference<a<T>> atomicReference = new AtomicReference<>();
        this.a = atomicReference;
        AtomicReference<a<T>> atomicReference2 = new AtomicReference<>();
        this.b = atomicReference2;
        a<T> aVar = new a<>();
        atomicReference2.lazySet(aVar);
        atomicReference.getAndSet(aVar);
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.b.get() == this.a.get();
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    public boolean offer(T t) {
        Objects.requireNonNull(t, "Null is not a valid element");
        a<T> aVar = new a<>(t);
        this.a.getAndSet(aVar).lazySet(aVar);
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, E] */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, E] */
    @Override // io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue, io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    @Nullable
    public T poll() {
        a<T> aVar;
        a<T> aVar2 = this.b.get();
        a<T> aVar3 = (a) aVar2.get();
        if (aVar3 != null) {
            E e = aVar3.a;
            aVar3.a = null;
            this.b.lazySet(aVar3);
            return e;
        } else if (aVar2 == this.a.get()) {
            return null;
        } else {
            do {
                aVar = (a) aVar2.get();
            } while (aVar == null);
            E e2 = aVar.a;
            aVar.a = null;
            this.b.lazySet(aVar);
            return e2;
        }
    }

    @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
    public boolean offer(T t, T t2) {
        offer(t);
        offer(t2);
        return true;
    }
}
