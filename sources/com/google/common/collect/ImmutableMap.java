package com.google.common.collect;

import a2.j.d.c.b3;
import a2.j.d.c.h1;
import a2.j.d.c.i1;
import a2.j.d.c.j1;
import a2.j.d.c.k1;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    public static final Map.Entry<?, ?>[] e = new Map.Entry[0];
    @RetainedWith
    @LazyInit
    public transient ImmutableSet<Map.Entry<K, V>> a;
    @RetainedWith
    @LazyInit
    public transient ImmutableSet<K> b;
    @RetainedWith
    @LazyInit
    public transient ImmutableCollection<V> c;
    @LazyInit
    public transient ImmutableSetMultimap<K, V> d;

    public static class Builder<K, V> {
        @MonotonicNonNullDecl
        public Comparator<? super V> a;
        public Object[] b;
        public int c;
        public boolean d;

        public Builder() {
            this(4);
        }

        public final void a(int i) {
            int i2 = i * 2;
            Object[] objArr = this.b;
            if (i2 > objArr.length) {
                this.b = Arrays.copyOf(objArr, ImmutableCollection.Builder.a(objArr.length, i2));
                this.d = false;
            }
        }

        public void b() {
            int i;
            if (this.a != null) {
                if (this.d) {
                    this.b = Arrays.copyOf(this.b, this.c * 2);
                }
                Map.Entry[] entryArr = new Map.Entry[this.c];
                int i2 = 0;
                while (true) {
                    i = this.c;
                    if (i2 >= i) {
                        break;
                    }
                    Object[] objArr = this.b;
                    int i3 = i2 * 2;
                    entryArr[i2] = new AbstractMap.SimpleImmutableEntry(objArr[i3], objArr[i3 + 1]);
                    i2++;
                }
                Arrays.sort(entryArr, 0, i, Ordering.from(this.a).onResultOf(Maps.h.VALUE));
                for (int i4 = 0; i4 < this.c; i4++) {
                    int i5 = i4 * 2;
                    this.b[i5] = entryArr[i4].getKey();
                    this.b[i5 + 1] = entryArr[i4].getValue();
                }
            }
        }

        public ImmutableMap<K, V> build() {
            b();
            this.d = true;
            return b3.j(this.c, this.b);
        }

        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> orderEntriesByValue(Comparator<? super V> comparator) {
            Preconditions.checkState(this.a == null, "valueComparator was already set");
            this.a = (Comparator) Preconditions.checkNotNull(comparator, "valueComparator");
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(K k, V v) {
            a(this.c + 1);
            AppCompatDelegateImpl.i.s(k, v);
            Object[] objArr = this.b;
            int i = this.c;
            objArr[i * 2] = k;
            objArr[(i * 2) + 1] = v;
            this.c = i + 1;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            return putAll(map.entrySet());
        }

        public Builder(int i) {
            this.b = new Object[(i * 2)];
            this.c = 0;
            this.d = false;
        }

        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                a(((Collection) iterable).size() + this.c);
            }
            for (Map.Entry<? extends K, ? extends V> entry : iterable) {
                put(entry);
            }
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.ImmutableMap$Builder<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            return put(entry.getKey(), entry.getValue());
        }
    }

    public class a extends UnmodifiableIterator<K> {
        public final /* synthetic */ UnmodifiableIterator a;

        public a(ImmutableMap immutableMap, UnmodifiableIterator unmodifiableIterator) {
            this.a = unmodifiableIterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public K next() {
            return (K) ((Map.Entry) this.a.next()).getKey();
        }
    }

    public static abstract class b<K, V> extends ImmutableMap<K, V> {

        public class a extends i1<K, V> {
            public a() {
            }

            @Override // a2.j.d.c.i1, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* renamed from: iterator */
            public UnmodifiableIterator<Map.Entry<K, V>> mo99iterator() {
                return b.this.j();
            }

            @Override // a2.j.d.c.i1
            public ImmutableMap<K, V> l() {
                return b.this;
            }
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<Map.Entry<K, V>> a() {
            return new a();
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<K> c() {
            return new j1(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        public ImmutableCollection<V> d() {
            return new k1(this);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return ImmutableMap.super.entrySet();
        }

        public abstract UnmodifiableIterator<Map.Entry<K, V>> j();

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return ImmutableMap.super.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
        public /* bridge */ /* synthetic */ Collection values() {
            return ImmutableMap.super.values();
        }
    }

    public final class c extends b<K, ImmutableSet<V>> {

        public class a extends UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>> {
            public final /* synthetic */ Iterator a;

            public a(c cVar, Iterator it) {
                this.a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                return new h1(this, (Map.Entry) this.a.next());
            }
        }

        public c(a aVar) {
        }

        @Override // com.google.common.collect.ImmutableMap.b, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> c() {
            return ImmutableMap.this.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return ImmutableMap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean f() {
            return ImmutableMap.this.f();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public Object get(@NullableDecl Object obj) {
            Object obj2 = ImmutableMap.this.get(obj);
            if (obj2 == null) {
                return null;
            }
            return ImmutableSet.of(obj2);
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean h() {
            return ImmutableMap.this.h();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map, java.lang.Object
        public int hashCode() {
            return ImmutableMap.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableMap.b
        public UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>> j() {
            return new a(this, ImmutableMap.this.entrySet().mo99iterator());
        }

        @Override // java.util.Map
        public int size() {
            return ImmutableMap.this.size();
        }
    }

    public static class d implements Serializable {
        private static final long serialVersionUID = 0;
        public final Object[] a;
        public final Object[] b;

        public d(ImmutableMap<?, ?> immutableMap) {
            this.a = new Object[immutableMap.size()];
            this.b = new Object[immutableMap.size()];
            UnmodifiableIterator<Map.Entry<?, ?>> it = immutableMap.entrySet().mo99iterator();
            int i = 0;
            while (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                this.a[i] = next.getKey();
                this.b[i] = next.getValue();
                i++;
            }
        }

        public Object a(Builder<Object, Object> builder) {
            int i = 0;
            while (true) {
                Object[] objArr = this.a;
                if (i >= objArr.length) {
                    return builder.build();
                }
                builder.put(objArr[i], this.b[i]);
                i++;
            }
        }

        public Object readResolve() {
            return a(new Builder<>(this.a.length));
        }
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    @Beta
    public static <K, V> Builder<K, V> builderWithExpectedSize(int i) {
        AppCompatDelegateImpl.i.z(i, "expectedSize");
        return new Builder<>(i);
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.h()) {
                return immutableMap;
            }
        }
        return copyOf(map.entrySet());
    }

    public static <K, V> Map.Entry<K, V> e(K k, V v) {
        AppCompatDelegateImpl.i.s(k, v);
        return new AbstractMap.SimpleImmutableEntry(k, v);
    }

    public static <K, V> ImmutableMap<K, V> of() {
        return (ImmutableMap<K, V>) b3.i;
    }

    public abstract ImmutableSet<Map.Entry<K, V>> a();

    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty()) {
            return ImmutableSetMultimap.of();
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap = this.d;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap2 = new ImmutableSetMultimap<>(new c(null), size(), null);
        this.d = immutableSetMultimap2;
        return immutableSetMultimap2;
    }

    public abstract ImmutableSet<K> c();

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return values().contains(obj);
    }

    public abstract ImmutableCollection<V> d();

    @Override // java.util.Map, java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        return Maps.g(this, obj);
    }

    public boolean f() {
        return false;
    }

    @Override // java.util.Map
    public abstract V get(@NullableDecl Object obj);

    @Override // java.util.Map
    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    public abstract boolean h();

    @Override // java.util.Map, java.lang.Object
    public int hashCode() {
        return Sets.b(entrySet());
    }

    public UnmodifiableIterator<K> i() {
        return new a(this, entrySet().mo99iterator());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.Object
    public String toString() {
        return Maps.m(this);
    }

    public Object writeReplace() {
        return new d(this);
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v) {
        AppCompatDelegateImpl.i.s(k, v);
        return b3.j(1, new Object[]{k, v});
    }

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.a;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Map.Entry<K, V>> a3 = a();
        this.a = a3;
        return a3;
    }

    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.b;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<K> c2 = c();
        this.b = c2;
        return c2;
    }

    @Override // java.util.Map, com.google.common.collect.BiMap
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.c;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        ImmutableCollection<V> d2 = d();
        this.c = d2;
        return d2;
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2) {
        AppCompatDelegateImpl.i.s(k, v);
        AppCompatDelegateImpl.i.s(k2, v2);
        return b3.j(2, new Object[]{k, v, k2, v2});
    }

    @Beta
    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Builder builder = new Builder(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        builder.putAll(iterable);
        return builder.build();
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        AppCompatDelegateImpl.i.s(k, v);
        AppCompatDelegateImpl.i.s(k2, v2);
        AppCompatDelegateImpl.i.s(k3, v3);
        return b3.j(3, new Object[]{k, v, k2, v2, k3, v3});
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        AppCompatDelegateImpl.i.s(k, v);
        AppCompatDelegateImpl.i.s(k2, v2);
        AppCompatDelegateImpl.i.s(k3, v3);
        AppCompatDelegateImpl.i.s(k4, v4);
        return b3.j(4, new Object[]{k, v, k2, v2, k3, v3, k4, v4});
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        AppCompatDelegateImpl.i.s(k, v);
        AppCompatDelegateImpl.i.s(k2, v2);
        AppCompatDelegateImpl.i.s(k3, v3);
        AppCompatDelegateImpl.i.s(k4, v4);
        AppCompatDelegateImpl.i.s(k5, v5);
        return b3.j(5, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5});
    }
}
