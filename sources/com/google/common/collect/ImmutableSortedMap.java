package com.google.common.collect;

import a2.j.d.c.f3;
import a2.j.d.c.i1;
import a2.j.d.c.o1;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
@GwtCompatible(emulated = true, serializable = true)
public final class ImmutableSortedMap<K, V> extends o1<K, V> implements NavigableMap<K, V> {
    public static final Comparator<Comparable> i = Ordering.natural();
    public static final ImmutableSortedMap<Comparable, Object> j = new ImmutableSortedMap<>(ImmutableSortedSet.n(Ordering.natural()), ImmutableList.of());
    private static final long serialVersionUID = 0;
    public final transient f3<K> f;
    public final transient ImmutableList<V> g;
    public transient ImmutableSortedMap<K, V> h;

    public static class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        public transient Object[] e = new Object[4];
        public transient Object[] f = new Object[4];
        public final Comparator<? super K> g;

        public Builder(Comparator<? super K> comparator) {
            this.g = (Comparator) Preconditions.checkNotNull(comparator);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableSortedMap<K, V> build() {
            int i = this.c;
            if (i == 0) {
                return ImmutableSortedMap.l(this.g);
            }
            if (i == 1) {
                return ImmutableSortedMap.p(this.g, this.e[0], this.f[0]);
            }
            Object[] copyOf = Arrays.copyOf(this.e, i);
            Arrays.sort(copyOf, this.g);
            int i2 = this.c;
            Object[] objArr = new Object[i2];
            for (int i3 = 0; i3 < this.c; i3++) {
                if (i3 > 0) {
                    int i4 = i3 - 1;
                    if (this.g.compare(copyOf[i4], copyOf[i3]) == 0) {
                        StringBuilder L = a2.b.a.a.a.L("keys required to be distinct but compared as equal: ");
                        L.append(copyOf[i4]);
                        L.append(" and ");
                        L.append(copyOf[i3]);
                        throw new IllegalArgumentException(L.toString());
                    }
                }
                objArr[Arrays.binarySearch(copyOf, this.e[i3], this.g)] = this.f[i3];
            }
            return new ImmutableSortedMap<>(new f3(ImmutableList.f(copyOf), this.g), ImmutableList.h(objArr, i2));
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @Beta
        @Deprecated
        @CanIgnoreReturnValue
        public Builder<K, V> orderEntriesByValue(Comparator<? super V> comparator) {
            throw new UnsupportedOperationException("Not available on ImmutableSortedMap.Builder");
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(K k, V v) {
            int i = this.c + 1;
            Object[] objArr = this.e;
            if (i > objArr.length) {
                int a = ImmutableCollection.Builder.a(objArr.length, i);
                this.e = Arrays.copyOf(this.e, a);
                this.f = Arrays.copyOf(this.f, a);
            }
            AppCompatDelegateImpl.i.s(k, v);
            Object[] objArr2 = this.e;
            int i2 = this.c;
            objArr2[i2] = k;
            this.f[i2] = v;
            this.c = i2 + 1;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            super.putAll((Map) map);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.putAll((Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            super.put((Map.Entry) entry);
            return this;
        }
    }

    public static class a implements Comparator<Map.Entry<K, V>> {
        public final /* synthetic */ Comparator a;

        public a(Comparator comparator) {
            this.a = comparator;
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return this.a.compare(((Map.Entry) obj).getKey(), ((Map.Entry) obj2).getKey());
        }
    }

    public class b extends i1<K, V> {

        public class a extends ImmutableList<Map.Entry<K, V>> {
            public a() {
            }

            @Override // com.google.common.collect.ImmutableCollection
            public boolean e() {
                return true;
            }

            @Override // java.util.List
            public Object get(int i) {
                return new AbstractMap.SimpleImmutableEntry(ImmutableSortedMap.this.f.e.get(i), ImmutableSortedMap.this.g.get(i));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return ImmutableSortedMap.this.size();
            }
        }

        public b() {
        }

        @Override // com.google.common.collect.ImmutableSet
        public ImmutableList<Map.Entry<K, V>> i() {
            return new a();
        }

        @Override // a2.j.d.c.i1, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: iterator */
        public UnmodifiableIterator<Map.Entry<K, V>> mo99iterator() {
            return asList().mo99iterator();
        }

        @Override // a2.j.d.c.i1
        public ImmutableMap<K, V> l() {
            return ImmutableSortedMap.this;
        }
    }

    public static class c extends ImmutableMap.d {
        private static final long serialVersionUID = 0;
        public final Comparator<Object> c;

        public c(ImmutableSortedMap<?, ?> immutableSortedMap) {
            super(immutableSortedMap);
            this.c = immutableSortedMap.comparator();
        }

        @Override // com.google.common.collect.ImmutableMap.d
        public Object readResolve() {
            return a(new Builder(this.c));
        }
    }

    public ImmutableSortedMap(f3<K> f3Var, ImmutableList<V> immutableList) {
        this.f = f3Var;
        this.g = immutableList;
        this.h = null;
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        return j(map, (Ordering) i);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> sortedMap) {
        Comparator<? super K> comparator = sortedMap.comparator();
        if (comparator == null) {
            comparator = i;
        }
        if (sortedMap instanceof ImmutableSortedMap) {
            ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) sortedMap;
            if (!immutableSortedMap.h()) {
                return immutableSortedMap;
            }
        }
        return m(comparator, true, sortedMap.entrySet());
    }

    public static <K, V> ImmutableSortedMap<K, V> j(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        boolean z = false;
        if (map instanceof SortedMap) {
            Comparator<? super K> comparator2 = ((SortedMap) map).comparator();
            if (comparator2 != null) {
                z = comparator.equals(comparator2);
            } else if (comparator == i) {
                z = true;
            }
        }
        if (z && (map instanceof ImmutableSortedMap)) {
            ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) map;
            if (!immutableSortedMap.h()) {
                return immutableSortedMap;
            }
        }
        return m(comparator, z, map.entrySet());
    }

    public static <K, V> ImmutableSortedMap<K, V> l(Comparator<? super K> comparator) {
        if (Ordering.natural().equals(comparator)) {
            return of();
        }
        return new ImmutableSortedMap<>(ImmutableSortedSet.n(comparator), ImmutableList.of());
    }

    public static <K, V> ImmutableSortedMap<K, V> m(Comparator<? super K> comparator, boolean z, Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Map.Entry[] entryArr = (Map.Entry[]) Iterables.d(iterable, ImmutableMap.e);
        return n(comparator, z, entryArr, entryArr.length);
    }

    public static <K, V> ImmutableSortedMap<K, V> n(Comparator<? super K> comparator, boolean z, Map.Entry<K, V>[] entryArr, int i2) {
        if (i2 == 0) {
            return l(comparator);
        }
        if (i2 == 1) {
            return p(comparator, entryArr[0].getKey(), entryArr[0].getValue());
        }
        Object[] objArr = new Object[i2];
        Object[] objArr2 = new Object[i2];
        if (z) {
            for (int i3 = 0; i3 < i2; i3++) {
                K key = entryArr[i3].getKey();
                V value = entryArr[i3].getValue();
                AppCompatDelegateImpl.i.s(key, value);
                objArr[i3] = key;
                objArr2[i3] = value;
            }
        } else {
            Arrays.sort(entryArr, 0, i2, new a(comparator));
            K key2 = entryArr[0].getKey();
            objArr[0] = key2;
            objArr2[0] = entryArr[0].getValue();
            AppCompatDelegateImpl.i.s(objArr[0], objArr2[0]);
            int i4 = 1;
            while (i4 < i2) {
                K key3 = entryArr[i4].getKey();
                V value2 = entryArr[i4].getValue();
                AppCompatDelegateImpl.i.s(key3, value2);
                objArr[i4] = key3;
                objArr2[i4] = value2;
                boolean z2 = comparator.compare(key2, key3) != 0;
                Map.Entry<K, V> entry = entryArr[i4 - 1];
                Map.Entry<K, V> entry2 = entryArr[i4];
                if (z2) {
                    i4++;
                    key2 = key3;
                } else {
                    throw new IllegalArgumentException("Multiple entries with same key: " + entry + " and " + entry2);
                }
            }
        }
        return new ImmutableSortedMap<>(new f3(ImmutableList.h(objArr, i2), comparator), ImmutableList.h(objArr2, i2));
    }

    public static <K extends Comparable<?>, V> Builder<K, V> naturalOrder() {
        return new Builder<>(Ordering.natural());
    }

    public static <K, V> ImmutableSortedMap<K, V> of() {
        return (ImmutableSortedMap<K, V>) j;
    }

    public static <K, V> Builder<K, V> orderedBy(Comparator<K> comparator) {
        return new Builder<>(comparator);
    }

    public static <K, V> ImmutableSortedMap<K, V> p(Comparator<? super K> comparator, K k, V v) {
        return new ImmutableSortedMap<>(new f3(ImmutableList.of(k), (Comparator) Preconditions.checkNotNull(comparator)), ImmutableList.of(v));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> q(Map.Entry<K, V>... entryArr) {
        return n(Ordering.natural(), false, entryArr, entryArr.length);
    }

    public static <K extends Comparable<?>, V> Builder<K, V> reverseOrder() {
        return new Builder<>(Ordering.natural().reverse());
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> a() {
        return isEmpty() ? ImmutableSet.of() : new b();
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> c() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k) {
        return tailMap((ImmutableSortedMap<K, V>) k, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k) {
        return (K) Maps.i(ceilingEntry(k));
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableCollection<V> d() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().asList().get(0);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return keySet().first();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k) {
        return headMap((ImmutableSortedMap<K, V>) k, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k) {
        return (K) Maps.i(floorEntry(k));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        if (r4 >= 0) goto L_0x0015;
     */
    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V get(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object r4) {
        /*
            r3 = this;
            a2.j.d.c.f3<K> r0 = r3.f
            java.util.Objects.requireNonNull(r0)
            r1 = -1
            if (r4 != 0) goto L_0x0009
            goto L_0x0014
        L_0x0009:
            com.google.common.collect.ImmutableList<E> r2 = r0.e     // Catch:{ ClassCastException -> 0x0014 }
            java.util.Comparator<? super E> r0 = r0.c     // Catch:{ ClassCastException -> 0x0014 }
            int r4 = java.util.Collections.binarySearch(r2, r4, r0)     // Catch:{ ClassCastException -> 0x0014 }
            if (r4 < 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r4 = -1
        L_0x0015:
            if (r4 != r1) goto L_0x0019
            r4 = 0
            goto L_0x001f
        L_0x0019:
            com.google.common.collect.ImmutableList<V> r0 = r3.g
            java.lang.Object r4 = r0.get(r4)
        L_0x001f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ImmutableSortedMap.get(java.lang.Object):java.lang.Object");
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean h() {
        return this.f.e() || this.g.e();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k) {
        return tailMap((ImmutableSortedMap<K, V>) k, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k) {
        return (K) Maps.i(higherEntry(k));
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().asList().get(size() - 1);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return keySet().last();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k) {
        return headMap((ImmutableSortedMap<K, V>) k, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k) {
        return (K) Maps.i(lowerEntry(k));
    }

    public final ImmutableSortedMap<K, V> o(int i2, int i3) {
        if (i2 == 0 && i3 == size()) {
            return this;
        }
        if (i2 == i3) {
            return l(comparator());
        }
        return new ImmutableSortedMap<>(this.f.r(i2, i3), this.g.subList(i2, i3));
    }

    @Override // java.util.NavigableMap
    @CanIgnoreReturnValue
    @Deprecated
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @CanIgnoreReturnValue
    @Deprecated
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public int size() {
        return this.g.size();
    }

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new c(this);
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k, V v) {
        return p(Ordering.natural(), k, v);
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> descendingKeySet() {
        return this.f.descendingSet();
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> immutableSortedMap = this.h;
        if (immutableSortedMap != null) {
            return immutableSortedMap;
        }
        if (isEmpty()) {
            return l(Ordering.from(comparator()).reverse());
        }
        return new ImmutableSortedMap<>((f3) this.f.descendingSet(), this.g.reverse(), this);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> navigableKeySet() {
        return this.f;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
    public ImmutableCollection<V> values() {
        return this.g;
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        return j(map, (Comparator) Preconditions.checkNotNull(comparator));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k, V v, K k2, V v2) {
        return q(ImmutableMap.e(k, v), ImmutableMap.e(k2, v2));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> headMap(K k) {
        return headMap((ImmutableSortedMap<K, V>) k, false);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSortedSet<K> keySet() {
        return this.f;
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> subMap(K k, K k2) {
        return subMap((boolean) k, true, (boolean) k2, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> tailMap(K k) {
        return tailMap((ImmutableSortedMap<K, V>) k, true);
    }

    @Beta
    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return copyOf(iterable, (Ordering) i);
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        return q(ImmutableMap.e(k, v), ImmutableMap.e(k2, v2), ImmutableMap.e(k3, v3));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: a2.j.d.c.f3<K> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> headMap(K k, boolean z) {
        return o(0, this.f.s(Preconditions.checkNotNull(k), z));
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(k2);
        Preconditions.checkArgument(comparator().compare(k, k2) <= 0, "expected fromKey <= toKey but %s > %s", k, k2);
        return headMap((ImmutableSortedMap<K, V>) k2, z2).tailMap((ImmutableSortedMap<K, V>) k, z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: a2.j.d.c.f3<K> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> tailMap(K k, boolean z) {
        return o(this.f.t(Preconditions.checkNotNull(k), z), size());
    }

    public ImmutableSortedMap(f3<K> f3Var, ImmutableList<V> immutableList, ImmutableSortedMap<K, V> immutableSortedMap) {
        this.f = f3Var;
        this.g = immutableList;
        this.h = immutableSortedMap;
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return q(ImmutableMap.e(k, v), ImmutableMap.e(k2, v2), ImmutableMap.e(k3, v3), ImmutableMap.e(k4, v4));
    }

    @Beta
    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable, Comparator<? super K> comparator) {
        return m((Comparator) Preconditions.checkNotNull(comparator), false, iterable);
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return q(ImmutableMap.e(k, v), ImmutableMap.e(k2, v2), ImmutableMap.e(k3, v3), ImmutableMap.e(k4, v4), ImmutableMap.e(k5, v5));
    }
}
