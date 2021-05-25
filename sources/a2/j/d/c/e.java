package a2.j.d.c;

import a2.j.d.c.h;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class e<K, V> extends h<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    public transient Map<K, Collection<V>> f;
    public transient int g;

    public class a extends e<K, V>.d {
        public a(e eVar) {
            super();
        }

        @Override // a2.j.d.c.e.d
        public V a(K k, V v) {
            return v;
        }
    }

    public class b extends e<K, V>.d {
        public b(e eVar) {
            super();
        }

        @Override // a2.j.d.c.e.d
        public Object a(Object obj, Object obj2) {
            return Maps.immutableEntry(obj, obj2);
        }
    }

    public class c extends Maps.g0<K, Collection<V>> {
        public final transient Map<K, Collection<V>> d;

        public class a extends Maps.i<K, Collection<V>> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return Collections2.e(c.this.d.entrySet(), obj);
            }

            @Override // com.google.common.collect.Maps.i
            public Map<K, Collection<V>> d() {
                return c.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new b();
            }

            @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                Collection<V> collection;
                if (!Collections2.e(c.this.d.entrySet(), obj)) {
                    return false;
                }
                e eVar = e.this;
                Object key = ((Map.Entry) obj).getKey();
                Map<K, Collection<V>> map = eVar.f;
                Preconditions.checkNotNull(map);
                try {
                    collection = map.remove(key);
                } catch (ClassCastException | NullPointerException unused) {
                    collection = null;
                }
                Collection<V> collection2 = collection;
                if (collection2 == null) {
                    return true;
                }
                int size = collection2.size();
                collection2.clear();
                eVar.g -= size;
                return true;
            }
        }

        public class b implements Iterator<Map.Entry<K, Collection<V>>> {
            public final Iterator<Map.Entry<K, Collection<V>>> a;
            @NullableDecl
            public Collection<V> b;

            public b() {
                this.a = c.this.d.entrySet().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                Map.Entry<K, Collection<V>> next = this.a.next();
                this.b = next.getValue();
                return c.this.e(next);
            }

            @Override // java.util.Iterator
            public void remove() {
                Preconditions.checkState(this.b != null, "no calls to next() since the last call to remove()");
                this.a.remove();
                e.this.g -= this.b.size();
                this.b.clear();
                this.b = null;
            }
        }

        public c(Map<K, Collection<V>> map) {
            this.d = map;
        }

        @Override // com.google.common.collect.Maps.g0
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Map<K, Collection<V>> map = this.d;
            e eVar = e.this;
            if (map == eVar.f) {
                eVar.clear();
            } else {
                Iterators.b(new b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return Maps.k(this.d, obj);
        }

        public Map.Entry<K, Collection<V>> e(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return Maps.immutableEntry(key, e.this.u(key, entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            return this == obj || this.d.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            Collection<V> collection = (Collection) Maps.l(this.d, obj);
            if (collection == null) {
                return null;
            }
            return e.this.u(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map, java.lang.Object
        public int hashCode() {
            return this.d.hashCode();
        }

        @Override // com.google.common.collect.Maps.g0, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return e.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            Collection<V> remove = this.d.remove(obj);
            if (remove == null) {
                return null;
            }
            Collection<V> n = e.this.n();
            n.addAll(remove);
            e.this.g -= remove.size();
            remove.clear();
            return n;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.d.size();
        }

        @Override // java.util.AbstractMap, java.lang.Object
        public String toString() {
            return this.d.toString();
        }
    }

    public abstract class d<T> implements Iterator<T> {
        public final Iterator<Map.Entry<K, Collection<V>>> a;
        @NullableDecl
        public K b = null;
        @MonotonicNonNullDecl
        public Collection<V> c = null;
        public Iterator<V> d = Iterators.l.INSTANCE;

        public d() {
            this.a = e.this.f.entrySet().iterator();
        }

        public abstract T a(K k, V v);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext() || this.d.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.d.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.a.next();
                this.b = next.getKey();
                Collection<V> value = next.getValue();
                this.c = value;
                this.d = value.iterator();
            }
            return a(this.b, this.d.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.d.remove();
            if (this.c.isEmpty()) {
                this.a.remove();
            }
            e.m(e.this);
        }
    }

    /* renamed from: a2.j.d.c.e$e  reason: collision with other inner class name */
    public class C0061e extends Maps.q<K, Collection<V>> {

        /* renamed from: a2.j.d.c.e$e$a */
        public class a implements Iterator<K> {
            @NullableDecl
            public Map.Entry<K, Collection<V>> a;
            public final /* synthetic */ Iterator b;

            public a(Iterator it) {
                this.b = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                Map.Entry<K, Collection<V>> entry = (Map.Entry) this.b.next();
                this.a = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                Preconditions.checkState(this.a != null, "no calls to next() since the last call to remove()");
                Collection<V> value = this.a.getValue();
                this.b.remove();
                e.this.g -= value.size();
                value.clear();
                this.a = null;
            }
        }

        public C0061e(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // com.google.common.collect.Maps.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterators.b(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.a.keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            return this == obj || this.a.keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set, java.lang.Object
        public int hashCode() {
            return this.a.keySet().hashCode();
        }

        @Override // com.google.common.collect.Maps.q, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(this.a.entrySet().iterator());
        }

        @Override // com.google.common.collect.Maps.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int i;
            V remove = this.a.remove(obj);
            if (remove != null) {
                i = remove.size();
                remove.clear();
                e.this.g -= i;
            } else {
                i = 0;
            }
            if (i > 0) {
                return true;
            }
            return false;
        }
    }

    public class f extends e<K, V>.i implements NavigableMap<K, Collection<V>> {
        public f(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // a2.j.d.c.e.i, com.google.common.collect.Maps.g0
        public Set c() {
            return new g(h());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> ceilingEntry(K k) {
            Map.Entry<K, Collection<V>> ceilingEntry = h().ceilingEntry(k);
            if (ceilingEntry == null) {
                return null;
            }
            return e(ceilingEntry);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return h().ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return ((f) descendingMap()).navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new f(h().descendingMap());
        }

        @Override // a2.j.d.c.e.i
        public SortedSet f() {
            return new g(h());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> firstEntry = h().firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return e(firstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> floorEntry(K k) {
            Map.Entry<K, Collection<V>> floorEntry = h().floorEntry(k);
            if (floorEntry == null) {
                return null;
            }
            return e(floorEntry);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return h().floorKey(k);
        }

        @Override // a2.j.d.c.e.i, java.util.SortedMap, java.util.NavigableMap
        public SortedMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> higherEntry(K k) {
            Map.Entry<K, Collection<V>> higherEntry = h().higherEntry(k);
            if (higherEntry == null) {
                return null;
            }
            return e(higherEntry);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return h().higherKey(k);
        }

        /* renamed from: i */
        public NavigableSet<K> keySet() {
            SortedSet<K> sortedSet = this.f;
            if (sortedSet == null) {
                sortedSet = f();
                this.f = sortedSet;
            }
            return (NavigableSet) sortedSet;
        }

        public Map.Entry<K, Collection<V>> j(Iterator<Map.Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<K, Collection<V>> next = it.next();
            Collection<V> n = e.this.n();
            n.addAll(next.getValue());
            it.remove();
            return Maps.immutableEntry(next.getKey(), e.this.t(n));
        }

        /* renamed from: k */
        public NavigableMap<K, Collection<V>> h() {
            return (NavigableMap) ((SortedMap) this.d);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> lastEntry = h().lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return e(lastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lowerEntry(K k) {
            Map.Entry<K, Collection<V>> lowerEntry = h().lowerEntry(k);
            if (lowerEntry == null) {
                return null;
            }
            return e(lowerEntry);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return h().lowerKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return keySet();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: a2.j.d.c.e$f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return j(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return j(((Maps.g0) descendingMap()).entrySet().iterator());
        }

        @Override // a2.j.d.c.e.i, java.util.SortedMap, java.util.NavigableMap
        public SortedMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // a2.j.d.c.e.i, java.util.SortedMap, java.util.NavigableMap
        public SortedMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(K k, boolean z) {
            return new f(h().headMap(k, z));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(K k, boolean z, K k2, boolean z2) {
            return new f(h().subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(K k, boolean z) {
            return new f(h().tailMap(k, z));
        }
    }

    public class g extends e<K, V>.j implements NavigableSet<K> {
        public g(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k) {
            return e().ceilingKey(k);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return ((C0061e) descendingSet()).iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new g(e().descendingMap());
        }

        /* renamed from: f */
        public NavigableMap<K, Collection<V>> e() {
            return (NavigableMap) ((SortedMap) this.a);
        }

        @Override // java.util.NavigableSet
        public K floor(K k) {
            return e().floorKey(k);
        }

        @Override // a2.j.d.c.e.j, java.util.SortedSet, java.util.NavigableSet
        public SortedSet headSet(Object obj) {
            return headSet(obj, false);
        }

        @Override // java.util.NavigableSet
        public K higher(K k) {
            return e().higherKey(k);
        }

        @Override // java.util.NavigableSet
        public K lower(K k) {
            return e().lowerKey(k);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) Iterators.c(iterator());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) Iterators.c(descendingIterator());
        }

        @Override // a2.j.d.c.e.j, java.util.SortedSet, java.util.NavigableSet
        public SortedSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        @Override // a2.j.d.c.e.j, java.util.SortedSet, java.util.NavigableSet
        public SortedSet tailSet(Object obj) {
            return tailSet(obj, true);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k, boolean z) {
            return new g(e().headMap(k, z));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return new g(e().subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k, boolean z) {
            return new g(e().tailMap(k, z));
        }
    }

    public class h extends e<K, V>.l implements RandomAccess {
        public h(@NullableDecl e eVar, K k, @NullableDecl List<V> list, e<K, V>.k kVar) {
            super(k, list, kVar);
        }
    }

    public class i extends e<K, V>.c implements SortedMap<K, Collection<V>> {
        @MonotonicNonNullDecl
        public SortedSet<K> f;

        public i(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return h().comparator();
        }

        /* renamed from: f */
        public SortedSet<K> c() {
            return new j(h());
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return h().firstKey();
        }

        /* renamed from: g */
        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.f;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> f2 = c();
            this.f = f2;
            return f2;
        }

        public SortedMap<K, Collection<V>> h() {
            return (SortedMap) this.d;
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, Collection<V>> headMap(K k) {
            return new i(h().headMap(k));
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return h().lastKey();
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new i(h().subMap(k, k2));
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, Collection<V>> tailMap(K k) {
            return new i(h().tailMap(k));
        }
    }

    public class j extends e<K, V>.C0061e implements SortedSet<K> {
        public j(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return e().comparator();
        }

        public SortedMap<K, Collection<V>> e() {
            return (SortedMap) this.a;
        }

        @Override // java.util.SortedSet
        public K first() {
            return e().firstKey();
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(K k) {
            return new j(e().headMap(k));
        }

        @Override // java.util.SortedSet
        public K last() {
            return e().lastKey();
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(K k, K k2) {
            return new j(e().subMap(k, k2));
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(K k) {
            return new j(e().tailMap(k));
        }
    }

    public class m extends e<K, V>.o implements NavigableSet<V> {
        public m(@NullableDecl K k, NavigableSet<V> navigableSet, @NullableDecl e<K, V>.k kVar) {
            super(k, navigableSet, kVar);
        }

        @Override // java.util.NavigableSet
        public V ceiling(V v) {
            return d().ceiling(v);
        }

        @Override // java.util.NavigableSet
        public Iterator<V> descendingIterator() {
            return new k.a(d().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> descendingSet() {
            return f(d().descendingSet());
        }

        /* renamed from: e */
        public NavigableSet<V> d() {
            return (NavigableSet) ((SortedSet) this.b);
        }

        public final NavigableSet<V> f(NavigableSet<V> navigableSet) {
            e eVar = e.this;
            K k = this.a;
            e<K, V>.k kVar = this.c;
            if (kVar == null) {
                kVar = this;
            }
            return new m(k, navigableSet, kVar);
        }

        @Override // java.util.NavigableSet
        public V floor(V v) {
            return d().floor(v);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> headSet(V v, boolean z) {
            return f(d().headSet(v, z));
        }

        @Override // java.util.NavigableSet
        public V higher(V v) {
            return d().higher(v);
        }

        @Override // java.util.NavigableSet
        public V lower(V v) {
            return d().lower(v);
        }

        @Override // java.util.NavigableSet
        public V pollFirst() {
            return (V) Iterators.c(iterator());
        }

        @Override // java.util.NavigableSet
        public V pollLast() {
            return (V) Iterators.c(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> subSet(V v, boolean z, V v2, boolean z2) {
            return f(d().subSet(v, z, v2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> tailSet(V v, boolean z) {
            return f(d().tailSet(v, z));
        }
    }

    public class n extends e<K, V>.k implements Set<V> {
        public n(@NullableDecl K k, Set<V> set) {
            super(k, set, null);
        }

        @Override // a2.j.d.c.e.k, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean c = Sets.c((Set) this.b, collection);
            if (c) {
                int size2 = this.b.size();
                e eVar = e.this;
                eVar.g = (size2 - size) + eVar.g;
                c();
            }
            return c;
        }
    }

    public class o extends e<K, V>.k implements SortedSet<V> {
        public o(@NullableDecl K k, SortedSet<V> sortedSet, @NullableDecl e<K, V>.k kVar) {
            super(k, sortedSet, kVar);
        }

        @Override // java.util.SortedSet
        public Comparator<? super V> comparator() {
            return d().comparator();
        }

        public SortedSet<V> d() {
            return (SortedSet) this.b;
        }

        @Override // java.util.SortedSet
        public V first() {
            b();
            return d().first();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> headSet(V v) {
            b();
            e eVar = e.this;
            K k = this.a;
            SortedSet<V> headSet = d().headSet(v);
            e<K, V>.k kVar = this.c;
            if (kVar == null) {
                kVar = this;
            }
            return new o(k, headSet, kVar);
        }

        @Override // java.util.SortedSet
        public V last() {
            b();
            return d().last();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> subSet(V v, V v2) {
            b();
            e eVar = e.this;
            K k = this.a;
            SortedSet<V> subSet = d().subSet(v, v2);
            e<K, V>.k kVar = this.c;
            if (kVar == null) {
                kVar = this;
            }
            return new o(k, subSet, kVar);
        }

        @Override // java.util.SortedSet
        public SortedSet<V> tailSet(V v) {
            b();
            e eVar = e.this;
            K k = this.a;
            SortedSet<V> tailSet = d().tailSet(v);
            e<K, V>.k kVar = this.c;
            if (kVar == null) {
                kVar = this;
            }
            return new o(k, tailSet, kVar);
        }
    }

    public e(Map<K, Collection<V>> map) {
        Preconditions.checkArgument(map.isEmpty());
        this.f = map;
    }

    public static /* synthetic */ int l(e eVar) {
        int i2 = eVar.g;
        eVar.g = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int m(e eVar) {
        int i2 = eVar.g;
        eVar.g = i2 - 1;
        return i2;
    }

    @Override // a2.j.d.c.h
    public Map<K, Collection<V>> b() {
        return new c(this.f);
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        for (Collection<V> collection : this.f.values()) {
            collection.clear();
        }
        this.f.clear();
        this.g = 0;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@NullableDecl Object obj) {
        return this.f.containsKey(obj);
    }

    @Override // a2.j.d.c.h
    public Collection<Map.Entry<K, V>> d() {
        if (this instanceof SetMultimap) {
            return new h.b(this);
        }
        return new h.a();
    }

    @Override // a2.j.d.c.h
    public Set<K> e() {
        return new C0061e(this.f);
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public Collection<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // a2.j.d.c.h
    public Multiset<K> f() {
        return new Multimaps.g(this);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public Collection<V> mo118get(@NullableDecl K k2) {
        Collection<V> collection = this.f.get(k2);
        if (collection == null) {
            collection = o(k2);
        }
        return u(k2, collection);
    }

    @Override // a2.j.d.c.h
    public Collection<V> h() {
        return new h.c();
    }

    @Override // a2.j.d.c.h
    public Iterator<Map.Entry<K, V>> i() {
        return new b(this);
    }

    @Override // a2.j.d.c.h
    public Iterator<V> j() {
        return new a(this);
    }

    public abstract Collection<V> n();

    public Collection<V> o(@NullableDecl K k2) {
        return n();
    }

    public final Map<K, Collection<V>> p() {
        Map<K, Collection<V>> map = this.f;
        if (map instanceof NavigableMap) {
            return new f((NavigableMap) this.f);
        }
        if (map instanceof SortedMap) {
            return new i((SortedMap) this.f);
        }
        return new c(this.f);
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public boolean put(@NullableDecl K k2, @NullableDecl V v) {
        Collection<V> collection = this.f.get(k2);
        if (collection == null) {
            Collection<V> o2 = o(k2);
            if (o2.add(v)) {
                this.g++;
                this.f.put(k2, o2);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(v)) {
            return false;
        } else {
            this.g++;
            return true;
        }
    }

    public final Set<K> q() {
        Map<K, Collection<V>> map = this.f;
        if (map instanceof NavigableMap) {
            return new g((NavigableMap) this.f);
        }
        if (map instanceof SortedMap) {
            return new j((SortedMap) this.f);
        }
        return new C0061e(this.f);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.Collection<V>, java.util.Collection<E> */
    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.Collection<E>, java.util.Collection<V> */
    public Collection<V> r() {
        return (Collection<E>) t(n());
    }

    /* JADX DEBUG: Type inference failed for r4v3. Raw type applied. Possible types: java.util.Collection<E>, java.util.Collection<V> */
    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: removeAll */
    public Collection<V> mo119removeAll(@NullableDecl Object obj) {
        Collection<V> remove = this.f.remove(obj);
        if (remove == null) {
            return r();
        }
        Collection n2 = n();
        n2.addAll(remove);
        this.g -= remove.size();
        remove.clear();
        return (Collection<E>) t(n2);
    }

    /* JADX DEBUG: Type inference failed for r4v2. Raw type applied. Possible types: java.util.Collection<E>, java.util.Collection<V> */
    @Override // a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: replaceValues */
    public Collection<V> mo120replaceValues(@NullableDecl K k2, Iterable<? extends V> iterable) {
        Iterator<? extends V> it = iterable.iterator();
        if (!it.hasNext()) {
            return mo119removeAll(k2);
        }
        Collection<V> collection = this.f.get(k2);
        if (collection == null) {
            collection = o(k2);
            this.f.put(k2, collection);
        }
        Collection n2 = n();
        n2.addAll(collection);
        this.g -= collection.size();
        collection.clear();
        while (it.hasNext()) {
            if (collection.add((V) it.next())) {
                this.g++;
            }
        }
        return (Collection<E>) t(n2);
    }

    public final void s(Map<K, Collection<V>> map) {
        this.f = map;
        this.g = 0;
        for (Collection<V> collection : map.values()) {
            Preconditions.checkArgument(!collection.isEmpty());
            this.g = collection.size() + this.g;
        }
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.g;
    }

    public abstract <E> Collection<E> t(Collection<E> collection);

    public abstract Collection<V> u(@NullableDecl K k2, Collection<V> collection);

    public final List<V> v(@NullableDecl K k2, List<V> list, @NullableDecl e<K, V>.k kVar) {
        return list instanceof RandomAccess ? new h(this, k2, list, kVar) : new l(k2, list, kVar);
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public Collection<V> values() {
        return super.values();
    }

    public class l extends e<K, V>.k implements List<V> {

        public class a extends e<K, V>.k.a implements ListIterator<V> {
            public a() {
                super();
            }

            @Override // java.util.ListIterator
            public void add(V v) {
                boolean isEmpty = l.this.isEmpty();
                b().add(v);
                e.l(e.this);
                if (isEmpty) {
                    l.this.a();
                }
            }

            public final ListIterator<V> b() {
                a();
                return (ListIterator) this.a;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return b().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return b().nextIndex();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return b().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return b().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V v) {
                b().set(v);
            }

            public a(int i) {
                super(((List) l.this.b).listIterator(i));
            }
        }

        public l(@NullableDecl K k, List<V> list, @NullableDecl e<K, V>.k kVar) {
            super(k, list, kVar);
        }

        @Override // java.util.List
        public void add(int i, V v) {
            b();
            boolean isEmpty = this.b.isEmpty();
            ((List) this.b).add(i, v);
            e.l(e.this);
            if (isEmpty) {
                a();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = ((List) this.b).addAll(i, collection);
            if (addAll) {
                int size2 = this.b.size();
                e eVar = e.this;
                eVar.g = (size2 - size) + eVar.g;
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        @Override // java.util.List
        public V get(int i) {
            b();
            return (V) ((List) this.b).get(i);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            b();
            return ((List) this.b).indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            b();
            return ((List) this.b).lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            b();
            return new a();
        }

        @Override // java.util.List
        public V remove(int i) {
            b();
            V v = (V) ((List) this.b).remove(i);
            e.m(e.this);
            c();
            return v;
        }

        @Override // java.util.List
        public V set(int i, V v) {
            b();
            return (V) ((List) this.b).set(i, v);
        }

        @Override // java.util.List
        public List<V> subList(int i, int i2) {
            b();
            e eVar = e.this;
            K k = this.a;
            List<V> subList = ((List) this.b).subList(i, i2);
            e<K, V>.k kVar = this.c;
            if (kVar == null) {
                kVar = this;
            }
            return eVar.v(k, subList, kVar);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i) {
            b();
            return new a(i);
        }
    }

    public class k extends AbstractCollection<V> {
        @NullableDecl
        public final K a;
        public Collection<V> b;
        @NullableDecl
        public final e<K, V>.k c;
        @NullableDecl
        public final Collection<V> d;

        public k(@NullableDecl K k, Collection<V> collection, @NullableDecl e<K, V>.k kVar) {
            Collection<V> collection2;
            this.a = k;
            this.b = collection;
            this.c = kVar;
            if (kVar == null) {
                collection2 = null;
            } else {
                collection2 = kVar.b;
            }
            this.d = collection2;
        }

        public void a() {
            e<K, V>.k kVar = this.c;
            if (kVar != null) {
                kVar.a();
            } else {
                e.this.f.put(this.a, this.b);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v) {
            b();
            boolean isEmpty = this.b.isEmpty();
            boolean add = this.b.add(v);
            if (add) {
                e.l(e.this);
                if (isEmpty) {
                    a();
                }
            }
            return add;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.b.addAll(collection);
            if (addAll) {
                int size2 = this.b.size();
                e eVar = e.this;
                eVar.g = (size2 - size) + eVar.g;
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        public void b() {
            Collection<V> collection;
            e<K, V>.k kVar = this.c;
            if (kVar != null) {
                kVar.b();
                if (this.c.b != this.d) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.b.isEmpty() && (collection = e.this.f.get(this.a)) != null) {
                this.b = collection;
            }
        }

        public void c() {
            e<K, V>.k kVar = this.c;
            if (kVar != null) {
                kVar.c();
            } else if (this.b.isEmpty()) {
                e.this.f.remove(this.a);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size != 0) {
                this.b.clear();
                e.this.g -= size;
                c();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            b();
            return this.b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            b();
            return this.b.containsAll(collection);
        }

        @Override // java.util.Collection, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            b();
            return this.b.equals(obj);
        }

        @Override // java.util.Collection, java.lang.Object
        public int hashCode() {
            b();
            return this.b.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            b();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            b();
            boolean remove = this.b.remove(obj);
            if (remove) {
                e.m(e.this);
                c();
            }
            return remove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.b.removeAll(collection);
            if (removeAll) {
                int size2 = this.b.size();
                e eVar = e.this;
                eVar.g = (size2 - size) + eVar.g;
                c();
            }
            return removeAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Preconditions.checkNotNull(collection);
            int size = size();
            boolean retainAll = this.b.retainAll(collection);
            if (retainAll) {
                int size2 = this.b.size();
                e eVar = e.this;
                eVar.g = (size2 - size) + eVar.g;
                c();
            }
            return retainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            b();
            return this.b.size();
        }

        @Override // java.util.AbstractCollection, java.lang.Object
        public String toString() {
            b();
            return this.b.toString();
        }

        public class a implements Iterator<V> {
            public final Iterator<V> a;
            public final Collection<V> b;

            public a() {
                Iterator<V> it;
                Collection<V> collection = k.this.b;
                this.b = collection;
                if (collection instanceof List) {
                    it = ((List) collection).listIterator();
                } else {
                    it = collection.iterator();
                }
                this.a = it;
            }

            public void a() {
                k.this.b();
                if (k.this.b != this.b) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                a();
                return this.a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.a.remove();
                e.m(e.this);
                k.this.c();
            }

            public a(Iterator<V> it) {
                this.b = k.this.b;
                this.a = it;
            }
        }
    }
}
