package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
@GwtCompatible
public final class MinMaxPriorityQueue<E> extends AbstractQueue<E> {
    public final MinMaxPriorityQueue<E>.b a;
    public final MinMaxPriorityQueue<E>.b b;
    @VisibleForTesting
    public final int c;
    public Object[] d;
    public int e;
    public int f;

    @Beta
    public static final class Builder<B> {
        public final Comparator<B> a;
        public int b = -1;
        public int c = Integer.MAX_VALUE;

        public Builder(Comparator comparator, a aVar) {
            this.a = (Comparator) Preconditions.checkNotNull(comparator);
        }

        public <T extends B> MinMaxPriorityQueue<T> create() {
            return create(Collections.emptySet());
        }

        @CanIgnoreReturnValue
        public Builder<B> expectedSize(int i) {
            Preconditions.checkArgument(i >= 0);
            this.b = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<B> maximumSize(int i) {
            Preconditions.checkArgument(i > 0);
            this.c = i;
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.MinMaxPriorityQueue<T extends B> */
        /* JADX WARN: Multi-variable type inference failed */
        public <T extends B> MinMaxPriorityQueue<T> create(Iterable<? extends T> iterable) {
            int i = this.b;
            int i2 = this.c;
            if (i == -1) {
                i = 11;
            }
            if (iterable instanceof Collection) {
                i = Math.max(i, ((Collection) iterable).size());
            }
            MinMaxPriorityQueue<T> minMaxPriorityQueue = (MinMaxPriorityQueue<T>) new MinMaxPriorityQueue(this, Math.min(i - 1, i2) + 1, null);
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                minMaxPriorityQueue.offer(it.next());
            }
            return minMaxPriorityQueue;
        }
    }

    public class b {
        public final Ordering<E> a;
        @Weak
        @MonotonicNonNullDecl
        public MinMaxPriorityQueue<E>.b b;

        public b(Ordering<E> ordering) {
            this.a = ordering;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.collect.Ordering<E> */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public int a(int i, E e) {
            while (i > 2) {
                int i2 = (((i - 1) / 2) - 1) / 2;
                Object obj = MinMaxPriorityQueue.this.d[i2];
                if (this.a.compare(obj, e) <= 0) {
                    break;
                }
                MinMaxPriorityQueue.this.d[i] = obj;
                i = i2;
            }
            MinMaxPriorityQueue.this.d[i] = e;
            return i;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.google.common.collect.Ordering<E> */
        /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.google.common.collect.Ordering<E> */
        /* JADX WARN: Multi-variable type inference failed */
        public int b(int i, E e) {
            int i2;
            if (i == 0) {
                MinMaxPriorityQueue.this.d[0] = e;
                return 0;
            }
            int i3 = (i - 1) / 2;
            MinMaxPriorityQueue minMaxPriorityQueue = MinMaxPriorityQueue.this;
            Object[] objArr = minMaxPriorityQueue.d;
            Object obj = objArr[i3];
            if (!(i3 == 0 || (i2 = (((i3 - 1) / 2) * 2) + 2) == i3 || (i2 * 2) + 1 < minMaxPriorityQueue.e)) {
                Object obj2 = objArr[i2];
                if (this.a.compare(obj2, obj) < 0) {
                    obj = obj2;
                    i3 = i2;
                }
            }
            if (this.a.compare(obj, e) < 0) {
                Object[] objArr2 = MinMaxPriorityQueue.this.d;
                objArr2[i] = obj;
                objArr2[i3] = e;
                return i3;
            }
            MinMaxPriorityQueue.this.d[i] = e;
            return i;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.Ordering<E> */
        /* JADX WARN: Multi-variable type inference failed */
        public int c(int i, int i2) {
            if (i >= MinMaxPriorityQueue.this.e) {
                return -1;
            }
            Preconditions.checkState(i > 0);
            int min = Math.min(i, MinMaxPriorityQueue.this.e - i2) + i2;
            for (int i3 = i + 1; i3 < min; i3++) {
                Object[] objArr = MinMaxPriorityQueue.this.d;
                if (this.a.compare(objArr[i3], objArr[i]) < 0) {
                    i = i3;
                }
            }
            return i;
        }
    }

    public static class c<E> {
        public final E a;
        public final E b;

        public c(E e, E e2) {
            this.a = e;
            this.b = e2;
        }
    }

    public class d implements Iterator<E> {
        public int a = -1;
        public int b = -1;
        public int c;
        @MonotonicNonNullDecl
        public Queue<E> d;
        @MonotonicNonNullDecl
        public List<E> e;
        @NullableDecl
        public E f;
        public boolean g;

        public d(a aVar) {
            this.c = MinMaxPriorityQueue.this.f;
        }

        public final void a() {
            if (MinMaxPriorityQueue.this.f != this.c) {
                throw new ConcurrentModificationException();
            }
        }

        public final boolean b(Iterable<E> iterable, E e2) {
            Iterator<E> it = iterable.iterator();
            while (it.hasNext()) {
                if (it.next() == e2) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.collect.MinMaxPriorityQueue$d */
        /* JADX WARN: Multi-variable type inference failed */
        public final void c(int i) {
            if (this.b < i) {
                if (this.e != null) {
                    while (i < MinMaxPriorityQueue.this.size() && b(this.e, MinMaxPriorityQueue.this.d[i])) {
                        i++;
                    }
                }
                this.b = i;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            c(this.a + 1);
            if (this.b < MinMaxPriorityQueue.this.size()) {
                return true;
            }
            Queue<E> queue = this.d;
            if (queue == null || queue.isEmpty()) {
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public E next() {
            a();
            c(this.a + 1);
            if (this.b < MinMaxPriorityQueue.this.size()) {
                int i = this.b;
                this.a = i;
                this.g = true;
                return (E) MinMaxPriorityQueue.this.d[i];
            }
            if (this.d != null) {
                this.a = MinMaxPriorityQueue.this.size();
                E poll = this.d.poll();
                this.f = poll;
                if (poll != null) {
                    this.g = true;
                    return poll;
                }
            }
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.checkState(this.g, "no calls to next() since the last call to remove()");
            a();
            boolean z = false;
            this.g = false;
            this.c++;
            if (this.a < MinMaxPriorityQueue.this.size()) {
                c<E> d2 = MinMaxPriorityQueue.this.d(this.a);
                if (d2 != null) {
                    if (this.d == null) {
                        this.d = new ArrayDeque();
                        this.e = new ArrayList(3);
                    }
                    if (!b(this.e, d2.a)) {
                        this.d.add(d2.a);
                    }
                    if (!b(this.d, d2.b)) {
                        this.e.add(d2.b);
                    }
                }
                this.a--;
                this.b--;
                return;
            }
            E e2 = this.f;
            int i = 0;
            while (true) {
                MinMaxPriorityQueue minMaxPriorityQueue = MinMaxPriorityQueue.this;
                if (i >= minMaxPriorityQueue.e) {
                    break;
                } else if (minMaxPriorityQueue.d[i] == e2) {
                    minMaxPriorityQueue.d(i);
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            Preconditions.checkState(z);
            this.f = null;
        }
    }

    public MinMaxPriorityQueue(Builder builder, int i, a aVar) {
        Ordering from = Ordering.from(builder.a);
        MinMaxPriorityQueue<E>.b bVar = new b(from);
        this.a = bVar;
        MinMaxPriorityQueue<E>.b bVar2 = new b(from.reverse());
        this.b = bVar2;
        bVar.b = bVar2;
        bVar2.b = bVar;
        this.c = builder.c;
        this.d = new Object[i];
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create() {
        return new Builder(Ordering.natural(), null).create();
    }

    public static Builder<Comparable> expectedSize(int i) {
        return new Builder(Ordering.natural(), null).expectedSize(i);
    }

    public static Builder<Comparable> maximumSize(int i) {
        return new Builder(Ordering.natural(), null).maximumSize(i);
    }

    public static <B> Builder<B> orderedBy(Comparator<B> comparator) {
        return new Builder<>(comparator, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.collect.Ordering<E> */
    /* JADX WARN: Multi-variable type inference failed */
    public final int a() {
        int i = this.e;
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        MinMaxPriorityQueue<E>.b bVar = this.b;
        Object[] objArr = MinMaxPriorityQueue.this.d;
        if (bVar.a.compare(objArr[1], objArr[2]) <= 0) {
            return 1;
        }
        return 2;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    @CanIgnoreReturnValue
    public boolean add(E e2) {
        offer(e2);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.collect.MinMaxPriorityQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            offer(it.next());
            z = true;
        }
        return z;
    }

    public final MinMaxPriorityQueue<E>.b b(int i) {
        boolean z = true;
        int i2 = ~(~(i + 1));
        Preconditions.checkState(i2 > 0, "negative index");
        if ((1431655765 & i2) <= (i2 & -1431655766)) {
            z = false;
        }
        return z ? this.a : this.b;
    }

    public final E c(int i) {
        E e2 = (E) this.d[i];
        d(i);
        return e2;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (int i = 0; i < this.e; i++) {
            this.d[i] = null;
        }
        this.e = 0;
    }

    public Comparator<? super E> comparator() {
        return this.a.a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: com.google.common.collect.MinMaxPriorityQueue<E>$b */
    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: com.google.common.collect.MinMaxPriorityQueue<E>$b */
    /* JADX DEBUG: Multi-variable search result rejected for r8v4, resolved type: com.google.common.collect.Ordering<E> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: com.google.common.collect.Ordering<E> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005d  */
    @com.google.common.annotations.VisibleForTesting
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.common.collect.MinMaxPriorityQueue.c<E> d(int r11) {
        /*
        // Method dump skipped, instructions count: 244
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MinMaxPriorityQueue.d(int):com.google.common.collect.MinMaxPriorityQueue$c");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new d(null);
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public boolean offer(E e2) {
        int i;
        Preconditions.checkNotNull(e2);
        this.f++;
        int i2 = this.e;
        int i3 = i2 + 1;
        this.e = i3;
        Object[] objArr = this.d;
        if (i3 > objArr.length) {
            int length = objArr.length;
            if (length < 64) {
                i = (length + 1) * 2;
            } else {
                i = IntMath.checkedMultiply(length / 2, 3);
            }
            Object[] objArr2 = new Object[(Math.min(i - 1, this.c) + 1)];
            Object[] objArr3 = this.d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.d = objArr2;
        }
        MinMaxPriorityQueue<E>.b b2 = b(i2);
        int b3 = b2.b(i2, e2);
        if (b3 != i2) {
            b2 = b2.b;
            i2 = b3;
        }
        b2.a(i2, e2);
        if (this.e <= this.c || pollLast() != e2) {
            return true;
        }
        return false;
    }

    @Override // java.util.Queue
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.d[0];
    }

    public E peekFirst() {
        return peek();
    }

    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.d[a()];
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return c(0);
    }

    @CanIgnoreReturnValue
    public E pollFirst() {
        return poll();
    }

    @CanIgnoreReturnValue
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        return c(a());
    }

    @CanIgnoreReturnValue
    public E removeFirst() {
        return remove();
    }

    @CanIgnoreReturnValue
    public E removeLast() {
        if (!isEmpty()) {
            return c(a());
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        int i = this.e;
        Object[] objArr = new Object[i];
        System.arraycopy(this.d, 0, objArr, 0, i);
        return objArr;
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create(Iterable<? extends E> iterable) {
        return new Builder(Ordering.natural(), null).create(iterable);
    }
}
