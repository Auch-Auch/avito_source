package com.google.common.collect;

import a2.j.d.c.b0;
import a2.j.d.c.l1;
import a2.j.d.c.l3;
import a2.j.d.c.u;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public abstract class ImmutableMultimap<K, V> extends u<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    public final transient ImmutableMap<K, ? extends ImmutableCollection<V>> f;
    public final transient int g;

    public class a extends UnmodifiableIterator<V> {
        public Iterator<? extends ImmutableCollection<V>> a;
        public Iterator<V> b = Iterators.j.e;

        public a() {
            this.a = ImmutableMultimap.this.f.values().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b.hasNext() || this.a.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            if (!this.b.hasNext()) {
                this.b = ((ImmutableCollection) this.a.next()).iterator();
            }
            return this.b.next();
        }
    }

    public static class b<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;
        @Weak
        public final ImmutableMultimap<K, V> b;

        public b(ImmutableMultimap<K, V> immutableMultimap) {
            this.b = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.b.containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean e() {
            return this.b.l();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.b.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: iterator */
        public UnmodifiableIterator<Map.Entry<K, V>> mo99iterator() {
            ImmutableMultimap<K, V> immutableMultimap = this.b;
            Objects.requireNonNull(immutableMultimap);
            return new l1(immutableMultimap);
        }
    }

    @GwtIncompatible
    public static class c {
        public static final l3<ImmutableMultimap> a = AppCompatDelegateImpl.i.D0(ImmutableMultimap.class, "map");
        public static final l3<ImmutableMultimap> b = AppCompatDelegateImpl.i.D0(ImmutableMultimap.class, "size");
    }

    public class d extends ImmutableMultiset<K> {
        public d() {
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return ImmutableMultimap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.Multiset
        public int count(@NullableDecl Object obj) {
            Collection collection = (Collection) ImmutableMultimap.this.f.get(obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean e() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableMultiset
        public Multiset.Entry<K> h(int i) {
            Map.Entry<K, ? extends ImmutableCollection<V>> entry = ImmutableMultimap.this.f.entrySet().asList().get(i);
            return Multisets.immutableEntry(entry.getKey(), ((Collection) entry.getValue()).size());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return ImmutableMultimap.this.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
        @GwtIncompatible
        public Object writeReplace() {
            return new e(ImmutableMultimap.this);
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
        /* renamed from: elementSet */
        public ImmutableSet<K> mo6elementSet() {
            return ImmutableMultimap.this.keySet();
        }
    }

    @GwtIncompatible
    public static final class e implements Serializable {
        public final ImmutableMultimap<?, ?> a;

        public e(ImmutableMultimap<?, ?> immutableMultimap) {
            this.a = immutableMultimap;
        }

        public Object readResolve() {
            return this.a.keys();
        }
    }

    public static final class f<K, V> extends ImmutableCollection<V> {
        private static final long serialVersionUID = 0;
        @Weak
        public final transient ImmutableMultimap<K, V> b;

        public f(ImmutableMultimap<K, V> immutableMultimap) {
            this.b = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection
        @GwtIncompatible
        public int a(Object[] objArr, int i) {
            UnmodifiableIterator<? extends ImmutableCollection<V>> it = this.b.f.values().iterator();
            while (it.hasNext()) {
                i = ((ImmutableCollection) it.next()).a(objArr, i);
            }
            return i;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            return this.b.containsValue(obj);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean e() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.b.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: iterator */
        public UnmodifiableIterator<V> mo99iterator() {
            return this.b.m();
        }
    }

    public ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i) {
        this.f = immutableMap;
        this.g = i;
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        if (multimap instanceof ImmutableMultimap) {
            ImmutableMultimap<K, V> immutableMultimap = (ImmutableMultimap) multimap;
            if (!immutableMultimap.l()) {
                return immutableMultimap;
            }
        }
        return ImmutableListMultimap.copyOf((Multimap) multimap);
    }

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    @Override // a2.j.d.c.h
    public Map<K, Collection<V>> b() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.Multimap
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@NullableDecl Object obj) {
        return this.f.containsKey(obj);
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public boolean containsValue(@NullableDecl Object obj) {
        return obj != null && super.containsValue(obj);
    }

    @Override // a2.j.d.c.h
    public Collection d() {
        return new b(this);
    }

    @Override // a2.j.d.c.h
    public Set<K> e() {
        throw new AssertionError("unreachable");
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap, java.lang.Object, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // a2.j.d.c.h
    public Multiset f() {
        return new d();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public abstract ImmutableCollection<V> mo118get(K k);

    @Override // a2.j.d.c.h
    public Collection h() {
        return new f(this);
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // a2.j.d.c.h
    public Iterator i() {
        return new l1(this);
    }

    public abstract ImmutableMultimap<V, K> inverse();

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // a2.j.d.c.h
    public Iterator j() {
        return new a();
    }

    public boolean l() {
        return this.f.h();
    }

    public UnmodifiableIterator<V> m() {
        return new a();
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public boolean put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.g;
    }

    @Override // a2.j.d.c.h, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static class Builder<K, V> {
        public Map<K, Collection<V>> a = new b0();
        @MonotonicNonNullDecl
        public Comparator<? super K> b;
        @MonotonicNonNullDecl
        public Comparator<? super V> c;

        public Collection<V> a() {
            return new ArrayList();
        }

        public ImmutableMultimap<K, V> build() {
            Collection entrySet = this.a.entrySet();
            Comparator<? super K> comparator = this.b;
            if (comparator != null) {
                entrySet = Ordering.from(comparator).a().immutableSortedCopy(entrySet);
            }
            return ImmutableListMultimap.n(entrySet, this.c);
        }

        @CanIgnoreReturnValue
        public Builder<K, V> orderKeysBy(Comparator<? super K> comparator) {
            this.b = (Comparator) Preconditions.checkNotNull(comparator);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> orderValuesBy(Comparator<? super V> comparator) {
            this.c = (Comparator) Preconditions.checkNotNull(comparator);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(K k, V v) {
            AppCompatDelegateImpl.i.s(k, v);
            Collection<V> collection = this.a.get(k);
            if (collection == null) {
                Map<K, Collection<V>> map = this.a;
                Collection<V> a3 = a();
                map.put(k, a3);
                collection = a3;
            }
            collection.add(v);
            return this;
        }

        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            for (Map.Entry<? extends K, ? extends V> entry : iterable) {
                put(entry);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(K k, Iterable<? extends V> iterable) {
            if (k != null) {
                Collection<V> collection = this.a.get(k);
                if (collection != null) {
                    for (V v : iterable) {
                        AppCompatDelegateImpl.i.s(k, v);
                        collection.add(v);
                    }
                    return this;
                }
                Iterator<? extends V> it = iterable.iterator();
                if (!it.hasNext()) {
                    return this;
                }
                Collection<V> a3 = a();
                while (it.hasNext()) {
                    V v2 = (V) it.next();
                    AppCompatDelegateImpl.i.s(k, v2);
                    a3.add(v2);
                }
                this.a.put(k, a3);
                return this;
            }
            StringBuilder L = a2.b.a.a.a.L("null key in entry: null=");
            L.append(Iterables.toString(iterable));
            throw new NullPointerException(L.toString());
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.ImmutableMultimap$Builder<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            return put(entry.getKey(), entry.getValue());
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(K k, V... vArr) {
            return putAll(k, Arrays.asList(vArr));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.collect.ImmutableMultimap$Builder<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Multimap<? extends K, ? extends V> multimap) {
            for (Map.Entry<? extends K, Collection<? extends V>> entry : multimap.asMap().entrySet()) {
                putAll((Builder<K, V>) entry.getKey(), entry.getValue());
            }
            return this;
        }
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v) {
        return ImmutableListMultimap.of((Object) k, (Object) v);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: com.google.common.collect.ImmutableMap<K, ? extends com.google.common.collect.ImmutableCollection<V>>, com.google.common.collect.ImmutableMap<K, java.util.Collection<V>> */
    @Override // a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public ImmutableMap<K, Collection<V>> asMap() {
        return (ImmutableMap<K, ? extends ImmutableCollection<V>>) this.f;
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public ImmutableCollection<Map.Entry<K, V>> entries() {
        return (ImmutableCollection) super.entries();
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public ImmutableSet<K> keySet() {
        return this.f.keySet();
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) super.keys();
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    @Deprecated
    /* renamed from: removeAll */
    public ImmutableCollection<V> mo119removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    @Deprecated
    /* renamed from: replaceValues */
    public ImmutableCollection<V> mo120replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3);
    }

    @Beta
    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return ImmutableListMultimap.copyOf((Iterable) iterable);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3, (Object) k4, (Object) v4);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3, (Object) k4, (Object) v4, (Object) k5, (Object) v5);
    }
}
