package com.google.common.util.concurrent;

import a2.j.d.l.a.q;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.MapMaker;
import com.google.common.math.IntMath;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
@Beta
@GwtIncompatible
public abstract class Striped<L> {
    public static final Supplier<ReadWriteLock> a = new e();
    public static final Supplier<ReadWriteLock> b = new f();

    public static class a implements Supplier<Lock> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.common.base.Supplier
        public Lock get() {
            return new i();
        }
    }

    public static class b implements Supplier<Lock> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.common.base.Supplier
        public Lock get() {
            return new ReentrantLock(false);
        }
    }

    public static class c implements Supplier<Semaphore> {
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.common.base.Supplier
        public Semaphore get() {
            return new j(this.a);
        }
    }

    public static class d implements Supplier<Semaphore> {
        public final /* synthetic */ int a;

        public d(int i) {
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.common.base.Supplier
        public Semaphore get() {
            return new Semaphore(this.a, false);
        }
    }

    public static class e implements Supplier<ReadWriteLock> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.common.base.Supplier
        public ReadWriteLock get() {
            return new ReentrantReadWriteLock();
        }
    }

    public static class f implements Supplier<ReadWriteLock> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.common.base.Supplier
        public ReadWriteLock get() {
            return new o();
        }
    }

    public static class g<L> extends k<L> {
        public final Object[] d;

        public g(int i, Supplier supplier, a aVar) {
            super(i);
            int i2 = 0;
            Preconditions.checkArgument(i <= 1073741824, "Stripes must be <= 2^30)");
            this.d = new Object[(this.c + 1)];
            while (true) {
                Object[] objArr = this.d;
                if (i2 < objArr.length) {
                    objArr[i2] = supplier.get();
                    i2++;
                } else {
                    return;
                }
            }
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i) {
            return (L) this.d[i];
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.d.length;
        }
    }

    @VisibleForTesting
    public static class h<L> extends k<L> {
        public final ConcurrentMap<Integer, L> d;
        public final Supplier<L> e;
        public final int f;

        public h(int i, Supplier<L> supplier) {
            super(i);
            int i2 = this.c;
            this.f = i2 == -1 ? Integer.MAX_VALUE : i2 + 1;
            this.e = supplier;
            this.d = new MapMaker().weakValues().makeMap();
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i) {
            int i2 = this.f;
            if (i2 != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(i, i2);
            }
            L l = this.d.get(Integer.valueOf(i));
            if (l != null) {
                return l;
            }
            L l2 = this.e.get();
            return (L) MoreObjects.firstNonNull(this.d.putIfAbsent(Integer.valueOf(i), l2), l2);
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.f;
        }
    }

    public static class i extends ReentrantLock {
        public i() {
            super(false);
        }
    }

    public static class j extends Semaphore {
        public j(int i) {
            super(i, false);
        }
    }

    public static abstract class k<L> extends Striped<L> {
        public final int c;

        public k(int i) {
            super(null);
            int i2;
            Preconditions.checkArgument(i > 0, "Stripes must be positive");
            if (i > 1073741824) {
                i2 = -1;
            } else {
                i2 = (1 << IntMath.log2(i, RoundingMode.CEILING)) - 1;
            }
            this.c = i2;
        }

        @Override // com.google.common.util.concurrent.Striped
        public final int b(Object obj) {
            int hashCode = obj.hashCode();
            int i = hashCode ^ ((hashCode >>> 20) ^ (hashCode >>> 12));
            return ((i >>> 4) ^ ((i >>> 7) ^ i)) & this.c;
        }

        @Override // com.google.common.util.concurrent.Striped
        public final L get(Object obj) {
            return getAt(b(obj));
        }
    }

    @VisibleForTesting
    public static class l<L> extends k<L> {
        public final AtomicReferenceArray<a<? extends L>> d;
        public final Supplier<L> e;
        public final int f;
        public final ReferenceQueue<L> g = new ReferenceQueue<>();

        public static final class a<L> extends WeakReference<L> {
            public final int a;

            public a(L l, int i, ReferenceQueue<L> referenceQueue) {
                super(l, referenceQueue);
                this.a = i;
            }
        }

        public l(int i, Supplier<L> supplier) {
            super(i);
            int i2 = this.c;
            int i3 = i2 == -1 ? Integer.MAX_VALUE : i2 + 1;
            this.f = i3;
            this.d = new AtomicReferenceArray<>(i3);
            this.e = supplier;
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i) {
            L l;
            int i2 = this.f;
            if (i2 != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(i, i2);
            }
            a<? extends L> aVar = this.d.get(i);
            L l2 = aVar == null ? null : (L) aVar.get();
            if (l2 != null) {
                return l2;
            }
            L l3 = this.e.get();
            a<? extends L> aVar2 = new a<>(l3, i, this.g);
            while (!this.d.compareAndSet(i, aVar, aVar2)) {
                aVar = this.d.get(i);
                if (aVar == null) {
                    l = null;
                    continue;
                } else {
                    l = (L) aVar.get();
                    continue;
                }
                if (l != null) {
                    return l;
                }
            }
            while (true) {
                Reference<? extends L> poll = this.g.poll();
                if (poll == null) {
                    return l3;
                }
                a<? extends L> aVar3 = (a) poll;
                this.d.compareAndSet(aVar3.a, aVar3, null);
            }
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.f;
        }
    }

    public static final class m extends a2.j.d.l.a.o {
        public final Condition a;

        public m(Condition condition, o oVar) {
            this.a = condition;
        }
    }

    public static final class n extends q {
        public final Lock a;
        public final o b;

        public n(Lock lock, o oVar) {
            this.a = lock;
            this.b = oVar;
        }

        @Override // java.util.concurrent.locks.Lock
        public Condition newCondition() {
            return new m(this.a.newCondition(), this.b);
        }
    }

    public static final class o implements ReadWriteLock {
        public final ReadWriteLock a = new ReentrantReadWriteLock();

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock readLock() {
            return new n(this.a.readLock(), this);
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock writeLock() {
            return new n(this.a.writeLock(), this);
        }
    }

    public Striped() {
    }

    public static <L> Striped<L> a(int i2, Supplier<L> supplier) {
        return new g(i2, supplier, null);
    }

    public static <L> Striped<L> c(int i2, Supplier<L> supplier) {
        return i2 < 1024 ? new l(i2, supplier) : new h(i2, supplier);
    }

    public static Striped<Lock> lazyWeakLock(int i2) {
        return c(i2, new b());
    }

    public static Striped<ReadWriteLock> lazyWeakReadWriteLock(int i2) {
        return c(i2, b);
    }

    public static Striped<Semaphore> lazyWeakSemaphore(int i2, int i3) {
        return c(i2, new d(i3));
    }

    public static Striped<Lock> lock(int i2) {
        return a(i2, new a());
    }

    public static Striped<ReadWriteLock> readWriteLock(int i2) {
        return a(i2, a);
    }

    public static Striped<Semaphore> semaphore(int i2, int i3) {
        return a(i2, new c(i3));
    }

    public abstract int b(Object obj);

    public Iterable<L> bulkGet(Iterable<?> iterable) {
        Object[] array = Iterables.toArray(iterable, Object.class);
        if (array.length == 0) {
            return ImmutableList.of();
        }
        int[] iArr = new int[array.length];
        for (int i2 = 0; i2 < array.length; i2++) {
            iArr[i2] = b(array[i2]);
        }
        Arrays.sort(iArr);
        int i3 = iArr[0];
        array[0] = getAt(i3);
        for (int i4 = 1; i4 < array.length; i4++) {
            int i5 = iArr[i4];
            if (i5 == i3) {
                array[i4] = array[i4 - 1];
            } else {
                array[i4] = getAt(i5);
                i3 = i5;
            }
        }
        return Collections.unmodifiableList(Arrays.asList(array));
    }

    public abstract L get(Object obj);

    public abstract L getAt(int i2);

    public abstract int size();

    public Striped(a aVar) {
    }
}
