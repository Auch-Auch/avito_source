package com.google.common.collect;

import a2.j.d.c.b5;
import a2.j.d.c.e1;
import a2.j.d.c.e2;
import a2.j.d.c.f1;
import a2.j.d.c.f2;
import a2.j.d.c.g2;
import a2.j.d.c.g4;
import a2.j.d.c.h2;
import a2.j.d.c.i2;
import a2.j.d.c.j2;
import a2.j.d.c.k2;
import a2.j.d.c.l2;
import a2.j.d.c.m2;
import a2.j.d.c.o2;
import a2.j.d.c.p4;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public final class Maps {

    public interface EntryTransformer<K, V1, V2> {
        V2 transformEntry(@NullableDecl K k, @NullableDecl V1 v1);
    }

    public static class a extends b5<K, Map.Entry<K, V>> {
        public final /* synthetic */ Function b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Iterator it, Function function) {
            super(it);
            this.b = function;
        }

        @Override // a2.j.d.c.b5
        public Object a(Object obj) {
            return Maps.immutableEntry(obj, this.b.apply(obj));
        }
    }

    public static class a0<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        public final Map<K, V> a;
        public final BiMap<? extends K, ? extends V> b;
        @RetainedWith
        @MonotonicNonNullDecl
        public BiMap<V, K> c;
        @MonotonicNonNullDecl
        public transient Set<V> d;

        public a0(BiMap<? extends K, ? extends V> biMap, @NullableDecl BiMap<V, K> biMap2) {
            this.a = Collections.unmodifiableMap(biMap);
            this.b = biMap;
            this.c = biMap2;
        }

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Object mo147delegate() {
            return this.a;
        }

        @Override // com.google.common.collect.BiMap
        public V forcePut(K k, V v) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.BiMap
        /* renamed from: inverse */
        public BiMap<V, K> mo35inverse() {
            BiMap<V, K> biMap = this.c;
            if (biMap != null) {
                return biMap;
            }
            a0 a0Var = new a0(this.b.mo35inverse(), this);
            this.c = a0Var;
            return a0Var;
        }

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        /* renamed from: delegate  reason: collision with other method in class */
        public Map<K, V> mo147delegate() {
            return this.a;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
        public Set<V> values() {
            Set<V> set = this.d;
            if (set != null) {
                return set;
            }
            Set<V> unmodifiableSet = Collections.unmodifiableSet(this.b.values());
            this.d = unmodifiableSet;
            return unmodifiableSet;
        }
    }

    public static class b extends a2.j.d.c.g<K, V> {
        public final /* synthetic */ Map.Entry a;

        public b(Map.Entry entry) {
            this.a = entry;
        }

        @Override // a2.j.d.c.g, java.util.Map.Entry
        public K getKey() {
            return (K) this.a.getKey();
        }

        @Override // a2.j.d.c.g, java.util.Map.Entry
        public V getValue() {
            return (V) this.a.getValue();
        }
    }

    public static class b0<K, V> extends ForwardingCollection<Map.Entry<K, V>> {
        public final Collection<Map.Entry<K, V>> a;

        public b0(Collection<Map.Entry<K, V>> collection) {
            this.a = collection;
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Object mo147delegate() {
            return this.a;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new l2(this.a.iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate  reason: collision with other method in class */
        public Collection<Map.Entry<K, V>> mo147delegate() {
            return this.a;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }
    }

    public static class c implements EntryTransformer<K, V1, V2> {
        public final /* synthetic */ Function a;

        public c(Function function) {
            this.a = function;
        }

        @Override // com.google.common.collect.Maps.EntryTransformer
        public V2 transformEntry(K k, V1 v1) {
            return (V2) this.a.apply(v1);
        }
    }

    public static class c0<K, V> extends b0<K, V> implements Set<Map.Entry<K, V>> {
        public c0(Set<Map.Entry<K, V>> set) {
            super(set);
        }

        @Override // java.util.Collection, java.lang.Object, java.util.Set
        public boolean equals(@NullableDecl Object obj) {
            return Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.lang.Object, java.util.Set
        public int hashCode() {
            return Sets.b(this);
        }
    }

    public static abstract class d<K, V> extends g0<K, V> {
        public final Map<K, V> d;
        public final Predicate<? super Map.Entry<K, V>> e;

        public d(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate) {
            this.d = map;
            this.e = predicate;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            if (this.d.containsKey(obj)) {
                if (this.e.apply(Maps.immutableEntry(obj, this.d.get(obj)))) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.Maps.g0
        public Collection<V> d() {
            return new o(this, this.d, this.e);
        }

        public boolean e(@NullableDecl Object obj, @NullableDecl V v) {
            return this.e.apply(Maps.immutableEntry(obj, v));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            V v = this.d.get(obj);
            if (v == null || !this.e.apply(Maps.immutableEntry(obj, v))) {
                return null;
            }
            return v;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return entrySet().isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            Preconditions.checkArgument(this.e.apply(Maps.immutableEntry(k, v)));
            return this.d.put(k, v);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.collect.Maps$d<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                Preconditions.checkArgument(e(entry.getKey(), entry.getValue()));
            }
            this.d.putAll(map);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            if (containsKey(obj)) {
                return this.d.remove(obj);
            }
            return null;
        }
    }

    @GwtIncompatible
    public static class d0<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V>, Serializable {
        public final NavigableMap<K, ? extends V> a;
        @MonotonicNonNullDecl
        public transient d0<K, V> b;

        public d0(NavigableMap<K, ? extends V> navigableMap) {
            this.a = navigableMap;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k) {
            return Maps.b(this.a.ceilingEntry(k));
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return this.a.ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return Sets.unmodifiableNavigableSet(this.a.descendingKeySet());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            d0<K, V> d0Var = this.b;
            if (d0Var != null) {
                return d0Var;
            }
            d0<K, V> d0Var2 = new d0<>(this.a.descendingMap(), this);
            this.b = d0Var2;
            return d0Var2;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return Maps.b(this.a.firstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k) {
            return Maps.b(this.a.floorEntry(k));
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return this.a.floorKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k, boolean z) {
            return Maps.unmodifiableNavigableMap(this.a.headMap(k, z));
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k) {
            return Maps.b(this.a.higherEntry(k));
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return this.a.higherKey(k);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return Maps.b(this.a.lastEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k) {
            return Maps.b(this.a.lowerEntry(k));
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return this.a.lowerKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return Sets.unmodifiableNavigableSet(this.a.navigableKeySet());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            return Maps.unmodifiableNavigableMap(this.a.subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k, boolean z) {
            return Maps.unmodifiableNavigableMap(this.a.tailMap(k, z));
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K k) {
            return Maps.unmodifiableNavigableMap(this.a.headMap(k, false));
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K k) {
            return Maps.unmodifiableNavigableMap(this.a.tailMap(k, true));
        }

        public d0(NavigableMap<K, ? extends V> navigableMap, d0<K, V> d0Var) {
            this.a = navigableMap;
            this.b = d0Var;
        }

        @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public SortedMap<K, V> mo147delegate() {
            return Collections.unmodifiableSortedMap(this.a);
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K k, K k2) {
            return Maps.unmodifiableNavigableMap(this.a.subMap(k, true, k2, false));
        }
    }

    public static class e<K, V> extends g0<K, V> {
        public final Set<K> d;
        public final Function<? super K, V> e;

        public class a extends i<K, V> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.i
            public Map<K, V> d() {
                return e.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<Map.Entry<K, V>> iterator() {
                return Maps.d(e.this.e(), e.this.e);
            }
        }

        public e(Set<K> set, Function<? super K, V> function) {
            this.d = (Set) Preconditions.checkNotNull(set);
            this.e = (Function) Preconditions.checkNotNull(function);
        }

        @Override // com.google.common.collect.Maps.g0
        public Set<Map.Entry<K, V>> a() {
            return new a();
        }

        @Override // com.google.common.collect.Maps.g0
        public Set<K> c() {
            return new i2(e());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            e().clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return e().contains(obj);
        }

        @Override // com.google.common.collect.Maps.g0
        public Collection<V> d() {
            return Collections2.transform(this.d, this.e);
        }

        public Set<K> e() {
            return this.d;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(@NullableDecl Object obj) {
            if (Collections2.e(e(), obj)) {
                return this.e.apply(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(@NullableDecl Object obj) {
            if (e().remove(obj)) {
                return this.e.apply(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return e().size();
        }
    }

    public static class e0<V> implements MapDifference.ValueDifference<V> {
        @NullableDecl
        public final V a;
        @NullableDecl
        public final V b;

        public e0(@NullableDecl V v, @NullableDecl V v2) {
            this.a = v;
            this.b = v2;
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof MapDifference.ValueDifference)) {
                return false;
            }
            MapDifference.ValueDifference valueDifference = (MapDifference.ValueDifference) obj;
            if (!Objects.equal(this.a, valueDifference.leftValue()) || !Objects.equal(this.b, valueDifference.rightValue())) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public int hashCode() {
            return Objects.hashCode(this.a, this.b);
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public V leftValue() {
            return this.a;
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public V rightValue() {
            return this.b;
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("(");
            L.append((Object) this.a);
            L.append(", ");
            return a2.b.a.a.a.r(L, this.b, ")");
        }
    }

    public static final class f<A, B> extends Converter<A, B> implements Serializable {
        private static final long serialVersionUID = 0;
        public final BiMap<A, B> c;

        public f(BiMap<A, B> biMap) {
            this.c = (BiMap) Preconditions.checkNotNull(biMap);
        }

        @Override // com.google.common.base.Converter
        public A doBackward(B b) {
            A a = this.c.mo35inverse().get(b);
            Preconditions.checkArgument(a != null, "No non-null mapping present for input: %s", b);
            return a;
        }

        @Override // com.google.common.base.Converter
        public B doForward(A a) {
            B b = this.c.get(a);
            Preconditions.checkArgument(b != null, "No non-null mapping present for input: %s", a);
            return b;
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof f) {
                return this.c.equals(((f) obj).c);
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.c.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Maps.asConverter(");
            L.append(this.c);
            L.append(")");
            return L.toString();
        }
    }

    public static class f0<K, V> extends AbstractCollection<V> {
        @Weak
        public final Map<K, V> a;

        public f0(Map<K, V> map) {
            this.a = (Map) Preconditions.checkNotNull(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            return this.a.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new h2(this.a.entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry<K, V> entry : this.a.entrySet()) {
                    if (Objects.equal(obj, entry.getValue())) {
                        this.a.remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet newHashSet = Sets.newHashSet();
                for (Map.Entry<K, V> entry : this.a.entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        newHashSet.add(entry.getKey());
                    }
                }
                return this.a.keySet().removeAll(newHashSet);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet newHashSet = Sets.newHashSet();
                for (Map.Entry<K, V> entry : this.a.entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        newHashSet.add(entry.getKey());
                    }
                }
                return this.a.keySet().retainAll(newHashSet);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.a.size();
        }
    }

    @GwtIncompatible
    public static abstract class g<K, V> extends ForwardingMap<K, V> implements NavigableMap<K, V> {
        @MonotonicNonNullDecl
        public transient Comparator<? super K> a;
        @MonotonicNonNullDecl
        public transient Set<Map.Entry<K, V>> b;
        @MonotonicNonNullDecl
        public transient NavigableSet<K> c;

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k) {
            return d().floorEntry(k);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return d().floorKey(k);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator = this.a;
            if (comparator != null) {
                return comparator;
            }
            Comparator<? super K> comparator2 = d().comparator();
            if (comparator2 == null) {
                comparator2 = Ordering.natural();
            }
            Ordering reverse = Ordering.from(comparator2).reverse();
            this.a = reverse;
            return reverse;
        }

        public abstract NavigableMap<K, V> d();

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return d().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return d();
        }

        public abstract Iterator<Map.Entry<K, V>> entryIterator();

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.b;
            if (set != null) {
                return set;
            }
            m2 m2Var = new m2(this);
            this.b = m2Var;
            return m2Var;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return d().lastEntry();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return d().lastKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k) {
            return d().ceilingEntry(k);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return d().ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k, boolean z) {
            return d().tailMap(k, z).descendingMap();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k) {
            return d().lowerEntry(k);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return d().lowerKey(k);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return d().firstEntry();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return d().firstKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k) {
            return d().higherEntry(k);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return d().higherKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> navigableSet = this.c;
            if (navigableSet != null) {
                return navigableSet;
            }
            t tVar = new t(this);
            this.c = tVar;
            return tVar;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return d().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return d().pollFirstEntry();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            return d().subMap(k2, z2, k, z).descendingMap();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k, boolean z) {
            return d().headMap(k, z).descendingMap();
        }

        @Override // com.google.common.collect.ForwardingObject, java.lang.Object
        public String toString() {
            return standardToString();
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
        public Collection<V> values() {
            return new f0(this);
        }

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public final Map<K, V> mo147delegate() {
            return d();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K k) {
            return headMap(k, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K k) {
            return tailMap(k, true);
        }
    }

    @GwtCompatible
    public static abstract class g0<K, V> extends AbstractMap<K, V> {
        @MonotonicNonNullDecl
        public transient Set<Map.Entry<K, V>> a;
        @MonotonicNonNullDecl
        public transient Set<K> b;
        @MonotonicNonNullDecl
        public transient Collection<V> c;

        public abstract Set<Map.Entry<K, V>> a();

        public Set<K> c() {
            return new q(this);
        }

        public Collection<V> d() {
            return new f0(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.a;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> a3 = a();
            this.a = a3;
            return a3;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            Set<K> set = this.b;
            if (set != null) {
                return set;
            }
            Set<K> c2 = c();
            this.b = c2;
            return c2;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.c;
            if (collection != null) {
                return collection;
            }
            Collection<V> d = d();
            this.c = d;
            return d;
        }
    }

    public enum h implements Function<Map.Entry<?, ?>, Object> {
        KEY {
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.common.base.Function
            @NullableDecl
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE {
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.common.base.Function
            @NullableDecl
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        };

        /* access modifiers changed from: public */
        h(g2 g2Var) {
        }
    }

    public static abstract class i<K, V> extends Sets.k<Map.Entry<K, V>> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            d().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object l = Maps.l(d(), key);
            if (!Objects.equal(l, entry.getValue())) {
                return false;
            }
            if (l != null || d().containsKey(key)) {
                return true;
            }
            return false;
        }

        public abstract Map<K, V> d();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return d().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj)) {
                return d().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // com.google.common.collect.Sets.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                return Sets.d(this, collection.iterator());
            }
        }

        @Override // com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet newHashSetWithExpectedSize = Sets.newHashSetWithExpectedSize(collection.size());
                for (Object obj : collection) {
                    if (contains(obj)) {
                        newHashSetWithExpectedSize.add(((Map.Entry) obj).getKey());
                    }
                }
                return d().keySet().retainAll(newHashSetWithExpectedSize);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return d().size();
        }
    }

    public static final class j<K, V> extends k<K, V> implements BiMap<K, V> {
        @RetainedWith
        public final BiMap<V, K> g = this;

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.collect.Maps$j, com.google.common.collect.Maps$k, com.google.common.collect.BiMap<V, K>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public j(com.google.common.collect.BiMap<K, V> r3, com.google.common.base.Predicate<? super java.util.Map.Entry<K, V>> r4) {
            /*
                r2 = this;
                r2.<init>(r3, r4)
                com.google.common.collect.Maps$j r0 = new com.google.common.collect.Maps$j
                com.google.common.collect.BiMap r3 = r3.mo35inverse()
                a2.j.d.c.n2 r1 = new a2.j.d.c.n2
                r1.<init>(r4)
                r0.<init>(r3, r1)
                r0.g = r2
                r2.g = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Maps.j.<init>(com.google.common.collect.BiMap, com.google.common.base.Predicate):void");
        }

        @Override // com.google.common.collect.BiMap
        public V forcePut(@NullableDecl K k, @NullableDecl V v) {
            Preconditions.checkArgument(this.e.apply(Maps.immutableEntry(k, v)));
            return (V) ((BiMap) this.d).forcePut(k, v);
        }

        @Override // com.google.common.collect.BiMap
        /* renamed from: inverse */
        public BiMap<V, K> mo35inverse() {
            return this.g;
        }

        @Override // com.google.common.collect.Maps.g0, java.util.AbstractMap, java.util.Map
        public Set<V> values() {
            return this.g.keySet();
        }
    }

    public static class k<K, V> extends d<K, V> {
        public final Set<Map.Entry<K, V>> f;

        public class a extends ForwardingSet<Map.Entry<K, V>> {

            /* renamed from: com.google.common.collect.Maps$k$a$a  reason: collision with other inner class name */
            public class C0280a extends b5<Map.Entry<K, V>, Map.Entry<K, V>> {
                public C0280a(Iterator it) {
                    super(it);
                }

                @Override // a2.j.d.c.b5
                public Object a(Object obj) {
                    return new o2(this, (Map.Entry) obj);
                }
            }

            public a(g2 g2Var) {
            }

            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            /* renamed from: delegate */
            public Object mo147delegate() {
                return k.this.f;
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return new C0280a(k.this.f.iterator());
            }

            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            /* renamed from: delegate  reason: collision with other method in class */
            public Collection mo147delegate() {
                return k.this.f;
            }

            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            /* renamed from: delegate */
            public Set<Map.Entry<K, V>> mo147delegate() {
                return k.this.f;
            }
        }

        public class b extends q<K, V> {
            public b() {
                super(k.this);
            }

            @Override // com.google.common.collect.Maps.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!k.this.containsKey(obj)) {
                    return false;
                }
                k.this.d.remove(obj);
                return true;
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                k kVar = k.this;
                return k.f(kVar.d, kVar.e, collection);
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                k kVar = k.this;
                return k.g(kVar.d, kVar.e, collection);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public Object[] toArray() {
                return Lists.newArrayList(iterator()).toArray();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public <T> T[] toArray(T[] tArr) {
                return (T[]) Lists.newArrayList(iterator()).toArray(tArr);
            }
        }

        public k(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate) {
            super(map, predicate);
            this.f = Sets.filter(map.entrySet(), this.e);
        }

        public static <K, V> boolean f(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate, Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (predicate.apply(next) && collection.contains(next.getKey())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        public static <K, V> boolean g(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate, Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (predicate.apply(next) && !collection.contains(next.getKey())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Maps.g0
        public Set<Map.Entry<K, V>> a() {
            return new a(null);
        }

        @Override // com.google.common.collect.Maps.g0
        public Set<K> c() {
            return new b();
        }
    }

    @GwtIncompatible
    public static class l<K, V> extends a2.j.d.c.j<K, V> {
        public final NavigableMap<K, V> a;
        public final Predicate<? super Map.Entry<K, V>> b;
        public final Map<K, V> c;

        public class a extends t<K, V> {
            public a(NavigableMap navigableMap) {
                super(navigableMap);
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                l lVar = l.this;
                return k.f(lVar.a, lVar.b, collection);
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                l lVar = l.this;
                return k.g(lVar.a, lVar.b, collection);
            }
        }

        public l(NavigableMap<K, V> navigableMap, Predicate<? super Map.Entry<K, V>> predicate) {
            this.a = (NavigableMap) Preconditions.checkNotNull(navigableMap);
            this.b = predicate;
            this.c = new k(navigableMap, predicate);
        }

        @Override // com.google.common.collect.Maps.p
        public Iterator<Map.Entry<K, V>> a() {
            return Iterators.filter(this.a.entrySet().iterator(), this.b);
        }

        @Override // a2.j.d.c.j
        public Iterator<Map.Entry<K, V>> c() {
            return Iterators.filter(this.a.descendingMap().entrySet().iterator(), this.b);
        }

        @Override // com.google.common.collect.Maps.p, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.c.clear();
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.a.comparator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return this.c.containsKey(obj);
        }

        @Override // a2.j.d.c.j, java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return Maps.filterEntries((NavigableMap) this.a.descendingMap(), (Predicate) this.b);
        }

        @Override // com.google.common.collect.Maps.p, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set<Map.Entry<K, V>> entrySet() {
            return this.c.entrySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @NullableDecl
        public V get(@NullableDecl Object obj) {
            return this.c.get(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k, boolean z) {
            return Maps.filterEntries((NavigableMap) this.a.headMap(k, z), (Predicate) this.b);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return !Iterables.any(this.a.entrySet(), this.b);
        }

        @Override // a2.j.d.c.j, java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return new a(this);
        }

        @Override // a2.j.d.c.j, java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return (Map.Entry) Iterables.a(this.a.entrySet(), this.b);
        }

        @Override // a2.j.d.c.j, java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return (Map.Entry) Iterables.a(this.a.descendingMap().entrySet(), this.b);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            return this.c.put(k, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            this.c.putAll(map);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(@NullableDecl Object obj) {
            return this.c.remove(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.c.size();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            return Maps.filterEntries((NavigableMap) this.a.subMap(k, z, k2, z2), (Predicate) this.b);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k, boolean z) {
            return Maps.filterEntries((NavigableMap) this.a.tailMap(k, z), (Predicate) this.b);
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Collection<V> values() {
            return new o(this, this.a, this.b);
        }
    }

    public static class m<K, V> extends k<K, V> implements SortedMap<K, V> {

        public class a extends k<K, V>.b implements SortedSet<K> {
            public a() {
                super();
            }

            @Override // java.util.SortedSet
            public Comparator<? super K> comparator() {
                return ((SortedMap) m.this.d).comparator();
            }

            @Override // java.util.SortedSet
            public K first() {
                return (K) m.this.firstKey();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> headSet(K k) {
                return (SortedSet) ((m) m.this.headMap(k)).keySet();
            }

            @Override // java.util.SortedSet
            public K last() {
                return (K) m.this.lastKey();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> subSet(K k, K k2) {
                return (SortedSet) ((m) m.this.subMap(k, k2)).keySet();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> tailSet(K k) {
                return (SortedSet) ((m) m.this.tailMap(k)).keySet();
            }
        }

        public m(SortedMap<K, V> sortedMap, Predicate<? super Map.Entry<K, V>> predicate) {
            super(sortedMap, predicate);
        }

        @Override // com.google.common.collect.Maps.k, com.google.common.collect.Maps.g0
        public Set c() {
            return new a();
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return ((SortedMap) this.d).comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return (K) ((SortedSet) super.keySet()).iterator().next();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> headMap(K k) {
            return new m(((SortedMap) this.d).headMap(k), this.e);
        }

        @Override // com.google.common.collect.Maps.g0, java.util.AbstractMap, java.util.Map
        public Set keySet() {
            return (SortedSet) super.keySet();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            SortedMap<K, V> sortedMap = (SortedMap) this.d;
            while (true) {
                K lastKey = sortedMap.lastKey();
                if (e(lastKey, this.d.get(lastKey))) {
                    return lastKey;
                }
                sortedMap = ((SortedMap) this.d).headMap(lastKey);
            }
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> subMap(K k, K k2) {
            return new m(((SortedMap) this.d).subMap(k, k2), this.e);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> tailMap(K k) {
            return new m(((SortedMap) this.d).tailMap(k), this.e);
        }
    }

    public static class n<K, V> extends d<K, V> {
        public final Predicate<? super K> f;

        public n(Map<K, V> map, Predicate<? super K> predicate, Predicate<? super Map.Entry<K, V>> predicate2) {
            super(map, predicate2);
            this.f = predicate;
        }

        @Override // com.google.common.collect.Maps.g0
        public Set<Map.Entry<K, V>> a() {
            return Sets.filter(this.d.entrySet(), this.e);
        }

        @Override // com.google.common.collect.Maps.g0
        public Set<K> c() {
            return Sets.filter(this.d.keySet(), this.f);
        }

        @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.d.containsKey(obj) && this.f.apply(obj);
        }
    }

    public static final class o<K, V> extends f0<K, V> {
        public final Map<K, V> b;
        public final Predicate<? super Map.Entry<K, V>> c;

        public o(Map<K, V> map, Map<K, V> map2, Predicate<? super Map.Entry<K, V>> predicate) {
            super(map);
            this.b = map2;
            this.c = predicate;
        }

        @Override // com.google.common.collect.Maps.f0, java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            Iterator<Map.Entry<K, V>> it = this.b.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (this.c.apply(next) && Objects.equal(next.getValue(), obj)) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.Maps.f0, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = this.b.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (this.c.apply(next) && collection.contains(next.getValue())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Maps.f0, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = this.b.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (this.c.apply(next) && !collection.contains(next.getValue())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return Lists.newArrayList(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) Lists.newArrayList(iterator()).toArray(tArr);
        }
    }

    public static abstract class p<K, V> extends AbstractMap<K, V> {

        public class a extends i<K, V> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.i
            public Map<K, V> d() {
                return p.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<Map.Entry<K, V>> iterator() {
                return p.this.a();
            }
        }

        public abstract Iterator<Map.Entry<K, V>> a();

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Iterators.b(a());
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set<Map.Entry<K, V>> entrySet() {
            return new a();
        }
    }

    public static class q<K, V> extends Sets.k<K> {
        @Weak
        public final Map<K, V> a;

        public q(Map<K, V> map) {
            this.a = (Map) Preconditions.checkNotNull(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            d().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return d().containsKey(obj);
        }

        public Map<K, V> d() {
            return this.a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return d().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return new g2(d().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            d().remove(obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return d().size();
        }
    }

    public static class r<K, V> implements MapDifference<K, V> {
        public final Map<K, V> a;
        public final Map<K, V> b;
        public final Map<K, V> c;
        public final Map<K, MapDifference.ValueDifference<V>> d;

        public r(Map<K, V> map, Map<K, V> map2, Map<K, V> map3, Map<K, MapDifference.ValueDifference<V>> map4) {
            this.a = Maps.a(map);
            this.b = Maps.a(map2);
            this.c = Maps.a(map3);
            this.d = Maps.a(map4);
        }

        @Override // com.google.common.collect.MapDifference
        public boolean areEqual() {
            return this.a.isEmpty() && this.b.isEmpty() && this.d.isEmpty();
        }

        @Override // com.google.common.collect.MapDifference
        /* renamed from: entriesDiffering */
        public Map<K, MapDifference.ValueDifference<V>> mo103entriesDiffering() {
            return this.d;
        }

        @Override // com.google.common.collect.MapDifference
        /* renamed from: entriesInCommon */
        public Map<K, V> mo104entriesInCommon() {
            return this.c;
        }

        @Override // com.google.common.collect.MapDifference
        /* renamed from: entriesOnlyOnLeft */
        public Map<K, V> mo105entriesOnlyOnLeft() {
            return this.a;
        }

        @Override // com.google.common.collect.MapDifference
        /* renamed from: entriesOnlyOnRight */
        public Map<K, V> mo106entriesOnlyOnRight() {
            return this.b;
        }

        @Override // com.google.common.collect.MapDifference
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MapDifference)) {
                return false;
            }
            MapDifference mapDifference = (MapDifference) obj;
            if (!mo105entriesOnlyOnLeft().equals(mapDifference.mo105entriesOnlyOnLeft()) || !mo106entriesOnlyOnRight().equals(mapDifference.mo106entriesOnlyOnRight()) || !mo104entriesInCommon().equals(mapDifference.mo104entriesInCommon()) || !mo103entriesDiffering().equals(mapDifference.mo103entriesDiffering())) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.collect.MapDifference
        public int hashCode() {
            return Objects.hashCode(mo105entriesOnlyOnLeft(), mo106entriesOnlyOnRight(), mo104entriesInCommon(), mo103entriesDiffering());
        }

        public String toString() {
            if (this.a.isEmpty() && this.b.isEmpty() && this.d.isEmpty()) {
                return "equal";
            }
            StringBuilder sb = new StringBuilder("not equal");
            if (!this.a.isEmpty()) {
                sb.append(": only on left=");
                sb.append(this.a);
            }
            if (!this.b.isEmpty()) {
                sb.append(": only on right=");
                sb.append(this.b);
            }
            if (!this.d.isEmpty()) {
                sb.append(": value differences=");
                sb.append(this.d);
            }
            return sb.toString();
        }
    }

    @GwtIncompatible
    public static final class s<K, V> extends a2.j.d.c.j<K, V> {
        public final NavigableSet<K> a;
        public final Function<? super K, V> b;

        public s(NavigableSet<K> navigableSet, Function<? super K, V> function) {
            this.a = (NavigableSet) Preconditions.checkNotNull(navigableSet);
            this.b = (Function) Preconditions.checkNotNull(function);
        }

        @Override // com.google.common.collect.Maps.p
        public Iterator<Map.Entry<K, V>> a() {
            return Maps.d(this.a, this.b);
        }

        @Override // a2.j.d.c.j
        public Iterator<Map.Entry<K, V>> c() {
            return descendingMap().entrySet().iterator();
        }

        @Override // com.google.common.collect.Maps.p, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.a.comparator();
        }

        @Override // a2.j.d.c.j, java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return Maps.asMap((NavigableSet) this.a.descendingSet(), (Function) this.b);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @NullableDecl
        public V get(@NullableDecl Object obj) {
            if (Collections2.e(this.a, obj)) {
                return this.b.apply(obj);
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k, boolean z) {
            return Maps.asMap((NavigableSet) this.a.headSet(k, z), (Function) this.b);
        }

        @Override // a2.j.d.c.j, java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return new k2(this.a);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.a.size();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            return Maps.asMap((NavigableSet) this.a.subSet(k, z, k2, z2), (Function) this.b);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k, boolean z) {
            return Maps.asMap((NavigableSet) this.a.tailSet(k, z), (Function) this.b);
        }
    }

    public static class u<K, V> extends e<K, V> implements SortedMap<K, V> {
        public u(SortedSet<K> sortedSet, Function<? super K, V> function) {
            super(sortedSet, function);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return ((SortedSet) this.d).comparator();
        }

        @Override // com.google.common.collect.Maps.e
        public Set e() {
            return (SortedSet) this.d;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return (K) ((SortedSet) this.d).first();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> headMap(K k) {
            return Maps.asMap(((SortedSet) this.d).headSet(k), (Function) this.e);
        }

        @Override // com.google.common.collect.Maps.g0, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return new j2((SortedSet) this.d);
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return (K) ((SortedSet) this.d).last();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> subMap(K k, K k2) {
            return Maps.asMap(((SortedSet) this.d).subSet(k, k2), (Function) this.e);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> tailMap(K k) {
            return Maps.asMap(((SortedSet) this.d).tailSet(k), (Function) this.e);
        }
    }

    public static class v<K, V> extends q<K, V> implements SortedSet<K> {
        public v(SortedMap<K, V> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return d().comparator();
        }

        /* renamed from: e */
        public SortedMap<K, V> d() {
            return (SortedMap) this.a;
        }

        @Override // java.util.SortedSet
        public K first() {
            return d().firstKey();
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(K k) {
            return new v(d().headMap(k));
        }

        @Override // java.util.SortedSet
        public K last() {
            return d().lastKey();
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(K k, K k2) {
            return new v(d().subMap(k, k2));
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(K k) {
            return new v(d().tailMap(k));
        }
    }

    public static class x<K, V1, V2> extends p<K, V2> {
        public final Map<K, V1> a;
        public final EntryTransformer<? super K, ? super V1, V2> b;

        public x(Map<K, V1> map, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            this.a = (Map) Preconditions.checkNotNull(map);
            this.b = (EntryTransformer) Preconditions.checkNotNull(entryTransformer);
        }

        @Override // com.google.common.collect.Maps.p
        public Iterator<Map.Entry<K, V2>> a() {
            Iterator<Map.Entry<K, V1>> it = this.a.entrySet().iterator();
            EntryTransformer<? super K, ? super V1, V2> entryTransformer = this.b;
            Preconditions.checkNotNull(entryTransformer);
            return Iterators.transform(it, new f2(entryTransformer));
        }

        @Override // com.google.common.collect.Maps.p, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.a.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 get(Object obj) {
            V1 v1 = this.a.get(obj);
            if (v1 != null || this.a.containsKey(obj)) {
                return this.b.transformEntry(obj, v1);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 remove(Object obj) {
            if (this.a.containsKey(obj)) {
                return this.b.transformEntry(obj, this.a.remove(obj));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.a.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V2> values() {
            return new f0(this);
        }
    }

    @GwtIncompatible
    public static class y<K, V1, V2> extends z<K, V1, V2> implements NavigableMap<K, V2> {
        public y(NavigableMap<K, V1> navigableMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(navigableMap, entryTransformer);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> ceilingEntry(K k) {
            return e(c().ceilingEntry(k));
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return c().ceilingKey(k);
        }

        /* renamed from: d */
        public NavigableMap<K, V1> c() {
            return (NavigableMap) ((SortedMap) this.a);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return c().descendingKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> descendingMap() {
            return Maps.transformEntries((NavigableMap) c().descendingMap(), (EntryTransformer) this.b);
        }

        @NullableDecl
        public final Map.Entry<K, V2> e(@NullableDecl Map.Entry<K, V1> entry) {
            if (entry == null) {
                return null;
            }
            EntryTransformer<? super K, ? super V1, V2> entryTransformer = this.b;
            Preconditions.checkNotNull(entryTransformer);
            Preconditions.checkNotNull(entry);
            return new e2(entry, entryTransformer);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> firstEntry() {
            return e(c().firstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> floorEntry(K k) {
            return e(c().floorEntry(k));
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return c().floorKey(k);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Maps.z, java.util.SortedMap, java.util.NavigableMap
        public SortedMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> higherEntry(K k) {
            return e(c().higherEntry(k));
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return c().higherKey(k);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> lastEntry() {
            return e(c().lastEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> lowerEntry(K k) {
            return e(c().lowerEntry(k));
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return c().lowerKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return c().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> pollFirstEntry() {
            return e(c().pollFirstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> pollLastEntry() {
            return e(c().pollLastEntry());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> subMap(K k, boolean z, K k2, boolean z2) {
            return Maps.transformEntries((NavigableMap) c().subMap(k, z, k2, z2), (EntryTransformer) this.b);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Maps.z, java.util.SortedMap, java.util.NavigableMap
        public SortedMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> headMap(K k, boolean z) {
            return Maps.transformEntries((NavigableMap) c().headMap(k, z), (EntryTransformer) this.b);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> tailMap(K k, boolean z) {
            return Maps.transformEntries((NavigableMap) c().tailMap(k, z), (EntryTransformer) this.b);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Maps.z, java.util.SortedMap, java.util.NavigableMap
        public SortedMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }
    }

    public static class z<K, V1, V2> extends x<K, V1, V2> implements SortedMap<K, V2> {
        public z(SortedMap<K, V1> sortedMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(sortedMap, entryTransformer);
        }

        public SortedMap<K, V1> c() {
            return (SortedMap) this.a;
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return c().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return c().firstKey();
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V2> headMap(K k) {
            return Maps.transformEntries((SortedMap) c().headMap(k), (EntryTransformer) this.b);
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return c().lastKey();
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V2> subMap(K k, K k2) {
            return Maps.transformEntries((SortedMap) c().subMap(k, k2), (EntryTransformer) this.b);
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V2> tailMap(K k) {
            return Maps.transformEntries((SortedMap) c().tailMap(k), (EntryTransformer) this.b);
        }
    }

    public static Map a(Map map) {
        if (map instanceof SortedMap) {
            return Collections.unmodifiableSortedMap((SortedMap) map);
        }
        return Collections.unmodifiableMap(map);
    }

    public static <A, B> Converter<A, B> asConverter(BiMap<A, B> biMap) {
        return new f(biMap);
    }

    public static <K, V> Map<K, V> asMap(Set<K> set, Function<? super K, V> function) {
        return new e(set, function);
    }

    public static Map.Entry b(Map.Entry entry) {
        if (entry == null) {
            return null;
        }
        return n(entry);
    }

    public static <K, V1, V2> EntryTransformer<K, V1, V2> c(Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        return new c(function);
    }

    public static <K, V> Iterator<Map.Entry<K, V>> d(Set<K> set, Function<? super K, V> function) {
        return new a(set.iterator(), function);
    }

    public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        if (map instanceof SortedMap) {
            return difference((SortedMap) map, (Map) map2);
        }
        return difference(map, map2, Equivalence.equals());
    }

    public static int e(int i2) {
        if (i2 < 3) {
            AppCompatDelegateImpl.i.z(i2, "expectedSize");
            return i2 + 1;
        } else if (i2 < 1073741824) {
            return (int) ((((float) i2) / 0.75f) + 1.0f);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.Map<K, V> */
    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.util.Map<K, V> */
    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.util.Map<K, com.google.common.collect.MapDifference$ValueDifference<V>> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: ? super V */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void f(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2, Equivalence<? super V> equivalence, Map<K, V> map3, Map<K, V> map4, Map<K, V> map5, Map<K, MapDifference.ValueDifference<V>> map6) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object obj = (Object) entry.getValue();
            if (map2.containsKey(key)) {
                V remove = map4.remove(key);
                if (equivalence.equivalent(obj, remove)) {
                    map5.put(key, obj);
                } else {
                    map6.put(key, new e0(obj, remove));
                }
            } else {
                map3.put(key, obj);
            }
        }
    }

    public static <K, V> Map<K, V> filterEntries(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (!(map instanceof d)) {
            return new k((Map) Preconditions.checkNotNull(map), predicate);
        }
        d dVar = (d) map;
        return new k(dVar.d, Predicates.and(dVar.e, predicate));
    }

    public static <K, V> Map<K, V> filterKeys(Map<K, V> map, Predicate<? super K> predicate) {
        Preconditions.checkNotNull(predicate);
        Predicate j2 = j(predicate);
        if (!(map instanceof d)) {
            return new n((Map) Preconditions.checkNotNull(map), predicate, j2);
        }
        d dVar = (d) map;
        return new k(dVar.d, Predicates.and(dVar.e, j2));
    }

    public static <K, V> Map<K, V> filterValues(Map<K, V> map, Predicate<? super V> predicate) {
        return filterEntries(map, o(predicate));
    }

    @GwtIncompatible
    public static ImmutableMap<String, String> fromProperties(Properties properties) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            builder.put(str, properties.getProperty(str));
        }
        return builder.build();
    }

    public static boolean g(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static <E> ImmutableMap<E, Integer> h(Collection<E> collection) {
        ImmutableMap.Builder builder = new ImmutableMap.Builder(collection.size());
        int i2 = 0;
        for (E e2 : collection) {
            builder.put(e2, Integer.valueOf(i2));
            i2++;
        }
        return builder.build();
    }

    @NullableDecl
    public static <K> K i(@NullableDecl Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    @GwtCompatible(serializable = true)
    public static <K, V> Map.Entry<K, V> immutableEntry(@NullableDecl K k2, @NullableDecl V v2) {
        return new e1(k2, v2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.EnumMap */
    /* JADX WARN: Multi-variable type inference failed */
    @GwtCompatible(serializable = true)
    public static <K extends Enum<K>, V> ImmutableMap<K, V> immutableEnumMap(Map<K, ? extends V> map) {
        if (map instanceof f1) {
            return (f1) map;
        }
        Iterator<Map.Entry<K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return ImmutableMap.of();
        }
        Map.Entry<K, ? extends V> next = it.next();
        K key = next.getKey();
        Object value = next.getValue();
        AppCompatDelegateImpl.i.s(key, value);
        EnumMap enumMap = new EnumMap(key.getDeclaringClass());
        enumMap.put((EnumMap) key, (K) value);
        while (it.hasNext()) {
            Map.Entry<K, ? extends V> next2 = it.next();
            K key2 = next2.getKey();
            Object value2 = next2.getValue();
            AppCompatDelegateImpl.i.s(key2, value2);
            enumMap.put((EnumMap) key2, (K) value2);
        }
        int size = enumMap.size();
        if (size == 0) {
            return ImmutableMap.of();
        }
        if (size != 1) {
            return new f1(enumMap);
        }
        Map.Entry entry = (Map.Entry) Iterables.getOnlyElement(enumMap.entrySet());
        return ImmutableMap.of(entry.getKey(), entry.getValue());
    }

    public static <K> Predicate<Map.Entry<K, ?>> j(Predicate<? super K> predicate) {
        return Predicates.compose(predicate, h.KEY);
    }

    public static boolean k(Map<?, ?> map, Object obj) {
        Preconditions.checkNotNull(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static <V> V l(Map<?, V> map, @NullableDecl Object obj) {
        Preconditions.checkNotNull(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static String m(Map<?, ?> map) {
        StringBuilder d2 = Collections2.d(map.size());
        d2.append('{');
        boolean z2 = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z2) {
                d2.append(", ");
            }
            z2 = false;
            d2.append(entry.getKey());
            d2.append('=');
            d2.append(entry.getValue());
        }
        d2.append('}');
        return d2.toString();
    }

    public static <K, V> Map.Entry<K, V> n(Map.Entry<? extends K, ? extends V> entry) {
        Preconditions.checkNotNull(entry);
        return new b(entry);
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentMap() {
        return new ConcurrentHashMap();
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Class<K> cls) {
        return new EnumMap<>((Class) Preconditions.checkNotNull(cls));
    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> newHashMapWithExpectedSize(int i2) {
        return new HashMap<>(e(i2));
    }

    public static <K, V> IdentityHashMap<K, V> newIdentityHashMap() {
        return new IdentityHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
        return new LinkedHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int i2) {
        return new LinkedHashMap<>(e(i2));
    }

    public static <K extends Comparable, V> TreeMap<K, V> newTreeMap() {
        return new TreeMap<>();
    }

    public static <V> Predicate<Map.Entry<?, V>> o(Predicate<? super V> predicate) {
        return Predicates.compose(predicate, h.VALUE);
    }

    @Beta
    @GwtIncompatible
    public static <K extends Comparable<? super K>, V> NavigableMap<K, V> subMap(NavigableMap<K, V> navigableMap, Range<K> range) {
        boolean z2 = true;
        if (navigableMap.comparator() != null && navigableMap.comparator() != Ordering.natural() && range.hasLowerBound() && range.hasUpperBound()) {
            Preconditions.checkArgument(navigableMap.comparator().compare(range.lowerEndpoint(), range.upperEndpoint()) <= 0, "map is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (range.hasLowerBound() && range.hasUpperBound()) {
            K lowerEndpoint = range.lowerEndpoint();
            BoundType lowerBoundType = range.lowerBoundType();
            BoundType boundType = BoundType.CLOSED;
            boolean z3 = lowerBoundType == boundType;
            K upperEndpoint = range.upperEndpoint();
            if (range.upperBoundType() != boundType) {
                z2 = false;
            }
            return navigableMap.subMap(lowerEndpoint, z3, upperEndpoint, z2);
        } else if (range.hasLowerBound()) {
            K lowerEndpoint2 = range.lowerEndpoint();
            if (range.lowerBoundType() != BoundType.CLOSED) {
                z2 = false;
            }
            return navigableMap.tailMap(lowerEndpoint2, z2);
        } else if (!range.hasUpperBound()) {
            return (NavigableMap) Preconditions.checkNotNull(navigableMap);
        } else {
            K upperEndpoint2 = range.upperEndpoint();
            if (range.upperBoundType() != BoundType.CLOSED) {
                z2 = false;
            }
            return navigableMap.headMap(upperEndpoint2, z2);
        }
    }

    public static <K, V> BiMap<K, V> synchronizedBiMap(BiMap<K, V> biMap) {
        return ((biMap instanceof g4) || (biMap instanceof ImmutableBiMap)) ? biMap : new g4(biMap, null, null, null);
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> synchronizedNavigableMap(NavigableMap<K, V> navigableMap) {
        return new p4(navigableMap, null);
    }

    public static <K, V> ImmutableMap<K, V> toMap(Iterable<K> iterable, Function<? super K, V> function) {
        return toMap(iterable.iterator(), function);
    }

    public static <K, V1, V2> Map<K, V2> transformEntries(Map<K, V1> map, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new x(map, entryTransformer);
    }

    public static <K, V1, V2> Map<K, V2> transformValues(Map<K, V1> map, Function<? super V1, V2> function) {
        return transformEntries(map, c(function));
    }

    @CanIgnoreReturnValue
    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterable<V> iterable, Function<? super V, K> function) {
        return uniqueIndex(iterable.iterator(), function);
    }

    public static <K, V> BiMap<K, V> unmodifiableBiMap(BiMap<? extends K, ? extends V> biMap) {
        return new a0(biMap, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.NavigableMap<K, ? extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> unmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap) {
        Preconditions.checkNotNull(navigableMap);
        if (navigableMap instanceof d0) {
            return navigableMap;
        }
        return new d0(navigableMap);
    }

    @GwtIncompatible
    public static class t<K, V> extends v<K, V> implements NavigableSet<K> {
        public t(NavigableMap<K, V> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k) {
            return (K) ((NavigableMap) this.a).ceilingKey(k);
        }

        @Override // com.google.common.collect.Maps.v, com.google.common.collect.Maps.q
        public Map d() {
            return (NavigableMap) this.a;
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return ((NavigableMap) this.a).descendingKeySet();
        }

        @Override // com.google.common.collect.Maps.v
        public SortedMap e() {
            return (NavigableMap) this.a;
        }

        @Override // java.util.NavigableSet
        public K floor(K k) {
            return (K) ((NavigableMap) this.a).floorKey(k);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k, boolean z) {
            return ((NavigableMap) this.a).headMap(k, z).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public K higher(K k) {
            return (K) ((NavigableMap) this.a).higherKey(k);
        }

        @Override // java.util.NavigableSet
        public K lower(K k) {
            return (K) ((NavigableMap) this.a).lowerKey(k);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) Maps.i(((NavigableMap) this.a).pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) Maps.i(((NavigableMap) this.a).pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return ((NavigableMap) this.a).subMap(k, z, k2, z2).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k, boolean z) {
            return ((NavigableMap) this.a).tailMap(k, z).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.v, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(K k) {
            return headSet(k, false);
        }

        @Override // com.google.common.collect.Maps.v, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(K k, K k2) {
            return subSet(k, true, k2, false);
        }

        @Override // com.google.common.collect.Maps.v, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(K k) {
            return tailSet(k, true);
        }
    }

    public static class w<K, V> extends r<K, V> implements SortedMapDifference<K, V> {
        public w(SortedMap<K, V> sortedMap, SortedMap<K, V> sortedMap2, SortedMap<K, V> sortedMap3, SortedMap<K, MapDifference.ValueDifference<V>> sortedMap4) {
            super(sortedMap, sortedMap2, sortedMap3, sortedMap4);
        }

        @Override // com.google.common.collect.Maps.r, com.google.common.collect.MapDifference
        /* renamed from: entriesDiffering */
        public Map mo103entriesDiffering() {
            return (SortedMap) this.d;
        }

        @Override // com.google.common.collect.Maps.r, com.google.common.collect.MapDifference
        /* renamed from: entriesInCommon */
        public Map mo104entriesInCommon() {
            return (SortedMap) this.c;
        }

        @Override // com.google.common.collect.Maps.r, com.google.common.collect.MapDifference
        /* renamed from: entriesOnlyOnLeft */
        public Map mo105entriesOnlyOnLeft() {
            return (SortedMap) this.a;
        }

        @Override // com.google.common.collect.Maps.r, com.google.common.collect.MapDifference
        /* renamed from: entriesOnlyOnRight */
        public Map mo106entriesOnlyOnRight() {
            return (SortedMap) this.b;
        }

        @Override // com.google.common.collect.Maps.r, com.google.common.collect.MapDifference
        /* renamed from: entriesDiffering  reason: collision with other method in class */
        public SortedMap<K, MapDifference.ValueDifference<V>> mo103entriesDiffering() {
            return (SortedMap) this.d;
        }

        @Override // com.google.common.collect.Maps.r, com.google.common.collect.MapDifference
        /* renamed from: entriesInCommon  reason: collision with other method in class */
        public SortedMap<K, V> mo104entriesInCommon() {
            return (SortedMap) this.c;
        }

        @Override // com.google.common.collect.Maps.r, com.google.common.collect.MapDifference
        /* renamed from: entriesOnlyOnLeft  reason: collision with other method in class */
        public SortedMap<K, V> mo105entriesOnlyOnLeft() {
            return (SortedMap) this.a;
        }

        @Override // com.google.common.collect.Maps.r, com.google.common.collect.MapDifference
        /* renamed from: entriesOnlyOnRight  reason: collision with other method in class */
        public SortedMap<K, V> mo106entriesOnlyOnRight() {
            return (SortedMap) this.b;
        }
    }

    public static <K, V> SortedMap<K, V> asMap(SortedSet<K> sortedSet, Function<? super K, V> function) {
        return new u(sortedSet, function);
    }

    public static <K, V> SortedMap<K, V> filterValues(SortedMap<K, V> sortedMap, Predicate<? super V> predicate) {
        return filterEntries((SortedMap) sortedMap, o(predicate));
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Map<K, ? extends V> map) {
        return new EnumMap<>(map);
    }

    public static <K, V> HashMap<K, V> newHashMap(Map<? extends K, ? extends V> map) {
        return new HashMap<>(map);
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(Map<? extends K, ? extends V> map) {
        return new LinkedHashMap<>(map);
    }

    public static <K, V> TreeMap<K, V> newTreeMap(SortedMap<K, ? extends V> sortedMap) {
        return new TreeMap<>((SortedMap) sortedMap);
    }

    public static <K, V> ImmutableMap<K, V> toMap(Iterator<K> it, Function<? super K, V> function) {
        Preconditions.checkNotNull(function);
        LinkedHashMap newLinkedHashMap = newLinkedHashMap();
        while (it.hasNext()) {
            K next = it.next();
            newLinkedHashMap.put(next, function.apply(next));
        }
        return ImmutableMap.copyOf(newLinkedHashMap);
    }

    public static <K, V1, V2> SortedMap<K, V2> transformEntries(SortedMap<K, V1> sortedMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new z(sortedMap, entryTransformer);
    }

    public static <K, V1, V2> SortedMap<K, V2> transformValues(SortedMap<K, V1> sortedMap, Function<? super V1, V2> function) {
        return transformEntries((SortedMap) sortedMap, c(function));
    }

    @CanIgnoreReturnValue
    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterator<V> it, Function<? super V, K> function) {
        Preconditions.checkNotNull(function);
        ImmutableMap.Builder builder = ImmutableMap.builder();
        while (it.hasNext()) {
            V next = it.next();
            builder.put(function.apply(next), next);
        }
        try {
            return builder.build();
        } catch (IllegalArgumentException e2) {
            throw new IllegalArgumentException(e2.getMessage() + ". To index multiple values under a key, use Multimaps.index.");
        }
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> asMap(NavigableSet<K> navigableSet, Function<? super K, V> function) {
        return new s(navigableSet, function);
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> filterValues(NavigableMap<K, V> navigableMap, Predicate<? super V> predicate) {
        return filterEntries((NavigableMap) navigableMap, o(predicate));
    }

    public static <C, K extends C, V> TreeMap<K, V> newTreeMap(@NullableDecl Comparator<C> comparator) {
        return new TreeMap<>(comparator);
    }

    @GwtIncompatible
    public static <K, V1, V2> NavigableMap<K, V2> transformEntries(NavigableMap<K, V1> navigableMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new y(navigableMap, entryTransformer);
    }

    @GwtIncompatible
    public static <K, V1, V2> NavigableMap<K, V2> transformValues(NavigableMap<K, V1> navigableMap, Function<? super V1, V2> function) {
        return transformEntries((NavigableMap) navigableMap, c(function));
    }

    public static <K, V> BiMap<K, V> filterValues(BiMap<K, V> biMap, Predicate<? super V> predicate) {
        return filterEntries((BiMap) biMap, o(predicate));
    }

    public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2, Equivalence<? super V> equivalence) {
        Preconditions.checkNotNull(equivalence);
        LinkedHashMap newLinkedHashMap = newLinkedHashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap(map2);
        LinkedHashMap newLinkedHashMap2 = newLinkedHashMap();
        LinkedHashMap newLinkedHashMap3 = newLinkedHashMap();
        f(map, map2, equivalence, newLinkedHashMap, linkedHashMap, newLinkedHashMap2, newLinkedHashMap3);
        return new r(newLinkedHashMap, linkedHashMap, newLinkedHashMap2, newLinkedHashMap3);
    }

    public static <K, V> SortedMap<K, V> filterEntries(SortedMap<K, V> sortedMap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (!(sortedMap instanceof m)) {
            return new m((SortedMap) Preconditions.checkNotNull(sortedMap), predicate);
        }
        m mVar = (m) sortedMap;
        return new m((SortedMap) mVar.d, Predicates.and(mVar.e, predicate));
    }

    public static <K, V> SortedMap<K, V> filterKeys(SortedMap<K, V> sortedMap, Predicate<? super K> predicate) {
        return filterEntries((SortedMap) sortedMap, j(predicate));
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> filterKeys(NavigableMap<K, V> navigableMap, Predicate<? super K> predicate) {
        return filterEntries((NavigableMap) navigableMap, j(predicate));
    }

    public static <K, V> BiMap<K, V> filterKeys(BiMap<K, V> biMap, Predicate<? super K> predicate) {
        Preconditions.checkNotNull(predicate);
        return filterEntries((BiMap) biMap, j(predicate));
    }

    public static <K, V> SortedMapDifference<K, V> difference(SortedMap<K, ? extends V> sortedMap, Map<? extends K, ? extends V> map) {
        Preconditions.checkNotNull(sortedMap);
        Preconditions.checkNotNull(map);
        Comparator<? super K> comparator = sortedMap.comparator();
        if (comparator == null) {
            comparator = Ordering.natural();
        }
        TreeMap newTreeMap = newTreeMap(comparator);
        TreeMap newTreeMap2 = newTreeMap(comparator);
        newTreeMap2.putAll(map);
        TreeMap newTreeMap3 = newTreeMap(comparator);
        TreeMap newTreeMap4 = newTreeMap(comparator);
        f(sortedMap, map, Equivalence.equals(), newTreeMap, newTreeMap2, newTreeMap3, newTreeMap4);
        return new w(newTreeMap, newTreeMap2, newTreeMap3, newTreeMap4);
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> filterEntries(NavigableMap<K, V> navigableMap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (!(navigableMap instanceof l)) {
            return new l((NavigableMap) Preconditions.checkNotNull(navigableMap), predicate);
        }
        l lVar = (l) navigableMap;
        return new l(lVar.a, Predicates.and(lVar.b, predicate));
    }

    public static <K, V> BiMap<K, V> filterEntries(BiMap<K, V> biMap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(biMap);
        Preconditions.checkNotNull(predicate);
        if (!(biMap instanceof j)) {
            return new j(biMap, predicate);
        }
        j jVar = (j) biMap;
        return new j((BiMap) jVar.d, Predicates.and(jVar.e, predicate));
    }
}
