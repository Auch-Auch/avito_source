package hu.akarnokd.rxjava2.util;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
public final class SpmcLinkedArrayQueue<T> implements SimplePlainQueue<T> {
    public a a;
    public int b;
    public final AtomicReference<a> c;

    public static final class a extends AtomicReferenceArray<Object> {
        private static final long serialVersionUID = 5627139329189102514L;
        public final AtomicInteger a = new AtomicInteger();

        public a(int i) {
            super(i);
        }
    }

    public SpmcLinkedArrayQueue(int i) {
        a aVar = new a(Math.max(2, i) + 1);
        this.a = aVar;
        this.c = new AtomicReference<>(aVar);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        do {
        } while (poll() != null);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        a aVar = this.c.get();
        AtomicInteger atomicInteger = aVar.a;
        while (true) {
            int i = atomicInteger.get();
            if (i < aVar.length() - 1) {
                Object obj = aVar.get(i);
                if (i == atomicInteger.get()) {
                    if (obj == null) {
                        return true;
                    }
                    return false;
                }
            } else {
                aVar = (a) aVar.get(aVar.length() - 1);
                if (aVar == null) {
                    return true;
                }
                atomicInteger = aVar.a;
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t) {
        int i;
        ObjectHelper.requireNonNull(t, "value is null");
        a aVar = this.a;
        int i2 = this.b;
        if (i2 == aVar.length() - 1) {
            a aVar2 = new a(aVar.length());
            this.a = aVar2;
            aVar2.lazySet(0, t);
            aVar.lazySet(aVar.length() - 1, aVar2);
            i = 1;
        } else {
            aVar.lazySet(i2, t);
            i = i2 + 1;
        }
        this.b = i;
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    public T poll() {
        AtomicReference<a> atomicReference = this.c;
        a aVar = atomicReference.get();
        AtomicInteger atomicInteger = aVar.a;
        while (true) {
            int i = atomicInteger.get();
            if (i < aVar.length() - 1) {
                T t = (T) aVar.get(i);
                if (i != atomicInteger.get()) {
                    continue;
                } else if (t == null) {
                    return null;
                } else {
                    if (atomicInteger.compareAndSet(i, i + 1)) {
                        aVar.lazySet(i, null);
                        return t;
                    }
                }
            } else {
                a aVar2 = (a) aVar.get(aVar.length() - 1);
                if (aVar2 == null) {
                    return null;
                }
                atomicReference.compareAndSet(aVar, aVar2);
                aVar = atomicReference.get();
                atomicInteger = aVar.a;
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t, T t2) {
        ObjectHelper.requireNonNull(t, "v1 is null");
        ObjectHelper.requireNonNull(t2, "v2 is null");
        a aVar = this.a;
        int i = this.b;
        int i2 = 2;
        if (i == aVar.length() - 1) {
            a aVar2 = new a(aVar.length());
            this.a = aVar2;
            aVar2.lazySet(0, t);
            aVar2.lazySet(1, t2);
            aVar.lazySet(aVar.length() - 1, aVar2);
        } else {
            aVar.lazySet(i + 1, t2);
            aVar.lazySet(i, t);
            i2 = 2 + i;
        }
        this.b = i2;
        return true;
    }
}
