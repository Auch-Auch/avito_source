package io.reactivex.internal.queue;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements SimplePlainQueue<E> {
    public static final Integer f = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;
    public final int a = (length() - 1);
    public final AtomicLong b = new AtomicLong();
    public long c;
    public final AtomicLong d = new AtomicLong();
    public final int e;

    public SpscArrayQueue(int i) {
        super(Pow2.roundToPowerOfTwo(i));
        this.e = Math.min(i / 4, f.intValue());
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.b.get() == this.d.get();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(E e2) {
        Objects.requireNonNull(e2, "Null is not a valid element");
        int i = this.a;
        long j = this.b.get();
        int i2 = ((int) j) & i;
        if (j >= this.c) {
            long j2 = ((long) this.e) + j;
            if (get(i & ((int) j2)) == null) {
                this.c = j2;
            } else if (get(i2) != null) {
                return false;
            }
        }
        lazySet(i2, e2);
        this.b.lazySet(j + 1);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public E poll() {
        long j = this.d.get();
        int i = ((int) j) & this.a;
        E e2 = get(i);
        if (e2 == null) {
            return null;
        }
        this.d.lazySet(j + 1);
        lazySet(i, null);
        return e2;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(E e2, E e3) {
        return offer(e2) && offer(e3);
    }
}
