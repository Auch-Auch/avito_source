package com.google.common.collect;

import a2.j.d.c.i;
import a2.j.d.c.l3;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtIncompatible
public final class ConcurrentHashMultiset<E> extends i<E> implements Serializable {
    private static final long serialVersionUID = 1;
    public final transient ConcurrentMap<E, AtomicInteger> c;

    public class a extends ForwardingSet<E> {
        public final /* synthetic */ Set a;

        public a(ConcurrentHashMultiset concurrentHashMultiset, Set set) {
            this.a = set;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return obj != null && Collections2.e(this.a, obj);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Object mo147delegate() {
            return this.a;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean z;
            if (obj == null) {
                return false;
            }
            Set set = this.a;
            Preconditions.checkNotNull(set);
            try {
                z = set.remove(obj);
            } catch (ClassCastException | NullPointerException unused) {
                z = false;
            }
            if (z) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate  reason: collision with other method in class */
        public Collection mo147delegate() {
            return this.a;
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Set<E> mo147delegate() {
            return this.a;
        }
    }

    public class b extends AbstractIterator<Multiset.Entry<E>> {
        public final Iterator<Map.Entry<E, AtomicInteger>> c;

        public b() {
            this.c = ConcurrentHashMultiset.this.c.entrySet().iterator();
        }

        @Override // com.google.common.collect.AbstractIterator
        public Object computeNext() {
            while (this.c.hasNext()) {
                Map.Entry<E, AtomicInteger> next = this.c.next();
                int i = next.getValue().get();
                if (i != 0) {
                    return Multisets.immutableEntry(next.getKey(), i);
                }
            }
            return (Multiset.Entry) endOfData();
        }
    }

    public class c extends ForwardingIterator<Multiset.Entry<E>> {
        @NullableDecl
        public Multiset.Entry<E> a;
        public final /* synthetic */ Iterator b;

        public c(Iterator it) {
            this.b = it;
        }

        @Override // com.google.common.collect.ForwardingIterator, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Object mo147delegate() {
            return this.b;
        }

        @Override // com.google.common.collect.ForwardingIterator, java.util.Iterator
        public Object next() {
            Multiset.Entry<E> entry = (Multiset.Entry) super.next();
            this.a = entry;
            return entry;
        }

        @Override // com.google.common.collect.ForwardingIterator, java.util.Iterator
        public void remove() {
            Preconditions.checkState(this.a != null, "no calls to next() since the last call to remove()");
            ConcurrentHashMultiset.this.setCount(this.a.getElement(), 0);
            this.a = null;
        }

        @Override // com.google.common.collect.ForwardingIterator, com.google.common.collect.ForwardingObject
        /* renamed from: delegate  reason: collision with other method in class */
        public Iterator<Multiset.Entry<E>> mo147delegate() {
            return this.b;
        }
    }

    public static class e {
        public static final l3<ConcurrentHashMultiset> a = AppCompatDelegateImpl.i.D0(ConcurrentHashMultiset.class, "countMap");
    }

    @VisibleForTesting
    public ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        Preconditions.checkArgument(concurrentMap.isEmpty(), "the backing map (%s) must be empty", concurrentMap);
        this.c = concurrentMap;
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset<>(new ConcurrentHashMap());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        e.a.a(this, (ConcurrentMap) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.c);
    }

    @Override // a2.j.d.c.i
    public Set<E> a() {
        return new a(this, this.c.keySet());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
        if (r4.c.putIfAbsent(r5, r2) == null) goto L_0x005e;
     */
    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int add(E r5, int r6) {
        /*
            r4 = this;
            com.google.common.base.Preconditions.checkNotNull(r5)
            if (r6 != 0) goto L_0x000a
            int r5 = r4.count(r5)
            return r5
        L_0x000a:
            java.lang.String r0 = "occurences"
            androidx.appcompat.app.AppCompatDelegateImpl.i.E(r6, r0)
        L_0x000f:
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r4.c
            java.lang.Object r0 = com.google.common.collect.Maps.l(r0, r5)
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            r1 = 0
            if (r0 != 0) goto L_0x002a
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r4.c
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger
            r2.<init>(r6)
            java.lang.Object r0 = r0.putIfAbsent(r5, r2)
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            if (r0 != 0) goto L_0x002a
            return r1
        L_0x002a:
            int r2 = r0.get()
            if (r2 == 0) goto L_0x0049
            int r3 = com.google.common.math.IntMath.checkedAdd(r2, r6)     // Catch:{ ArithmeticException -> 0x003b }
            boolean r3 = r0.compareAndSet(r2, r3)     // Catch:{ ArithmeticException -> 0x003b }
            if (r3 == 0) goto L_0x002a
            return r2
        L_0x003b:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Overflow adding "
            java.lang.String r1 = " occurrences to a count of "
            java.lang.String r6 = a2.b.a.a.a.R2(r0, r6, r1, r2)
            r5.<init>(r6)
            throw r5
        L_0x0049:
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger
            r2.<init>(r6)
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r3 = r4.c
            java.lang.Object r3 = r3.putIfAbsent(r5, r2)
            if (r3 == 0) goto L_0x005e
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r3 = r4.c
            boolean r0 = r3.replace(r5, r0, r2)
            if (r0 == 0) goto L_0x000f
        L_0x005e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ConcurrentHashMultiset.add(java.lang.Object, int):int");
    }

    @Override // a2.j.d.c.i
    public int b() {
        return this.c.size();
    }

    @Override // a2.j.d.c.i
    public Iterator<E> c() {
        throw new AssertionError("should never be called");
    }

    @Override // a2.j.d.c.i, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.c.clear();
    }

    @Override // a2.j.d.c.i, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) Maps.l(this.c, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    @Override // a2.j.d.c.i
    @Deprecated
    public Set<Multiset.Entry<E>> createEntrySet() {
        return new d(null);
    }

    @Override // a2.j.d.c.i
    public Iterator<Multiset.Entry<E>> d() {
        return new c(new b());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<E> e() {
        ArrayList newArrayListWithExpectedSize = Lists.newArrayListWithExpectedSize(size());
        for (E e2 : entrySet()) {
            Object element = e2.getElement();
            for (int count = e2.getCount(); count > 0; count--) {
                newArrayListWithExpectedSize.add(element);
            }
        }
        return newArrayListWithExpectedSize;
    }

    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    /* renamed from: elementSet */
    public /* bridge */ /* synthetic */ Set mo6elementSet() {
        return super.mo6elementSet();
    }

    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // a2.j.d.c.i, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return new Multisets.k(this, entrySet().iterator());
    }

    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object obj, int i) {
        int i2;
        int max;
        if (i == 0) {
            return count(obj);
        }
        AppCompatDelegateImpl.i.E(i, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.l(this.c, obj);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 == 0) {
                return 0;
            }
            max = Math.max(0, i2 - i);
        } while (!atomicInteger.compareAndSet(i2, max));
        if (max == 0) {
            this.c.remove(obj, atomicInteger);
        }
        return i2;
    }

    @CanIgnoreReturnValue
    public boolean removeExactly(@NullableDecl Object obj, int i) {
        int i2;
        int i3;
        if (i == 0) {
            return true;
        }
        AppCompatDelegateImpl.i.E(i, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.l(this.c, obj);
        if (atomicInteger == null) {
            return false;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 < i) {
                return false;
            }
            i3 = i2 - i;
        } while (!atomicInteger.compareAndSet(i2, i3));
        if (i3 == 0) {
            this.c.remove(obj, atomicInteger);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        if (r6 != 0) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        if (r4.c.putIfAbsent(r5, r2) == null) goto L_0x0044;
     */
    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int setCount(E r5, int r6) {
        /*
            r4 = this;
            com.google.common.base.Preconditions.checkNotNull(r5)
            java.lang.String r0 = "count"
            androidx.appcompat.app.AppCompatDelegateImpl.i.z(r6, r0)
        L_0x0008:
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r4.c
            java.lang.Object r0 = com.google.common.collect.Maps.l(r0, r5)
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            r1 = 0
            if (r0 != 0) goto L_0x0026
            if (r6 != 0) goto L_0x0016
            return r1
        L_0x0016:
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r4.c
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger
            r2.<init>(r6)
            java.lang.Object r0 = r0.putIfAbsent(r5, r2)
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            if (r0 != 0) goto L_0x0026
            return r1
        L_0x0026:
            int r2 = r0.get()
            if (r2 != 0) goto L_0x0045
            if (r6 != 0) goto L_0x002f
            return r1
        L_0x002f:
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger
            r2.<init>(r6)
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r3 = r4.c
            java.lang.Object r3 = r3.putIfAbsent(r5, r2)
            if (r3 == 0) goto L_0x0044
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r3 = r4.c
            boolean r0 = r3.replace(r5, r0, r2)
            if (r0 == 0) goto L_0x0008
        L_0x0044:
            return r1
        L_0x0045:
            boolean r3 = r0.compareAndSet(r2, r6)
            if (r3 == 0) goto L_0x0026
            if (r6 != 0) goto L_0x0052
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r6 = r4.c
            r6.remove(r5, r0)
        L_0x0052:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ConcurrentHashMultiset.setCount(java.lang.Object, int):int");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        long j = 0;
        for (AtomicInteger atomicInteger : this.c.values()) {
            j += (long) atomicInteger.get();
        }
        return Ints.saturatedCast(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return e().toArray();
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> iterable) {
        ConcurrentHashMultiset<E> create = create();
        Iterables.addAll(create, iterable);
        return create;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) e().toArray(tArr);
    }

    public class d extends i<E>.b {
        public d(a aVar) {
            super();
        }

        @Override // a2.j.d.c.i.b, com.google.common.collect.Multisets.h
        public Multiset d() {
            return ConcurrentHashMultiset.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            ArrayList newArrayListWithExpectedSize = Lists.newArrayListWithExpectedSize(size());
            Iterators.addAll(newArrayListWithExpectedSize, iterator());
            return newArrayListWithExpectedSize.toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            ArrayList newArrayListWithExpectedSize = Lists.newArrayListWithExpectedSize(size());
            Iterators.addAll(newArrayListWithExpectedSize, iterator());
            return (T[]) newArrayListWithExpectedSize.toArray(tArr);
        }
    }

    @Beta
    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        return new ConcurrentHashMultiset<>(concurrentMap);
    }

    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(E e2, int i, int i2) {
        Preconditions.checkNotNull(e2);
        AppCompatDelegateImpl.i.z(i, "oldCount");
        AppCompatDelegateImpl.i.z(i2, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.l(this.c, e2);
        if (atomicInteger != null) {
            int i3 = atomicInteger.get();
            if (i3 == i) {
                if (i3 == 0) {
                    if (i2 == 0) {
                        this.c.remove(e2, atomicInteger);
                        return true;
                    }
                    AtomicInteger atomicInteger2 = new AtomicInteger(i2);
                    if (this.c.putIfAbsent(e2, atomicInteger2) == null || this.c.replace(e2, atomicInteger, atomicInteger2)) {
                        return true;
                    }
                    return false;
                } else if (atomicInteger.compareAndSet(i3, i2)) {
                    if (i2 == 0) {
                        this.c.remove(e2, atomicInteger);
                    }
                    return true;
                }
            }
            return false;
        } else if (i != 0) {
            return false;
        } else {
            if (i2 == 0 || this.c.putIfAbsent(e2, new AtomicInteger(i2)) == null) {
                return true;
            }
            return false;
        }
    }
}
