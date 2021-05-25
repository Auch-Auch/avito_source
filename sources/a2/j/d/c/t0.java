package a2.j.d.c;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public class t0<K, V> extends h<K, V> implements z0<K, V> {
    public final Multimap<K, V> f;
    public final Predicate<? super Map.Entry<K, V>> g;

    public class a extends Maps.g0<K, Collection<V>> {

        /* renamed from: a2.j.d.c.t0$a$a  reason: collision with other inner class name */
        public class C0062a extends Maps.i<K, Collection<V>> {

            /* renamed from: a2.j.d.c.t0$a$a$a  reason: collision with other inner class name */
            public class C0063a extends AbstractIterator<Map.Entry<K, Collection<V>>> {
                public final Iterator<Map.Entry<K, Collection<V>>> c;

                public C0063a() {
                    this.c = t0.this.f.asMap().entrySet().iterator();
                }

                @Override // com.google.common.collect.AbstractIterator
                public Object computeNext() {
                    while (this.c.hasNext()) {
                        Map.Entry<K, Collection<V>> next = this.c.next();
                        K key = next.getKey();
                        Collection m = t0.m(next.getValue(), new c(key));
                        if (!m.isEmpty()) {
                            return Maps.immutableEntry(key, m);
                        }
                    }
                    return (Map.Entry) endOfData();
                }
            }

            public C0062a() {
            }

            @Override // com.google.common.collect.Maps.i
            public Map<K, Collection<V>> d() {
                return a.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new C0063a();
            }

            @Override // com.google.common.collect.Maps.i, com.google.common.collect.Sets.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                return t0.this.n(Predicates.in(collection));
            }

            @Override // com.google.common.collect.Maps.i, com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return t0.this.n(Predicates.not(Predicates.in(collection)));
            }

            @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return Iterators.size(new C0063a());
            }
        }

        public class b extends Maps.q<K, Collection<V>> {
            public b() {
                super(a.this);
            }

            @Override // com.google.common.collect.Maps.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@NullableDecl Object obj) {
                return a.this.remove(obj) != null;
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                return t0.this.n(Maps.j(Predicates.in(collection)));
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return t0.this.n(Maps.j(Predicates.not(Predicates.in(collection))));
            }
        }

        public class c extends Maps.f0<K, Collection<V>> {
            public c() {
                super(a.this);
            }

            @Override // com.google.common.collect.Maps.f0, java.util.AbstractCollection, java.util.Collection
            public boolean remove(@NullableDecl Object obj) {
                if (!(obj instanceof Collection)) {
                    return false;
                }
                Collection collection = (Collection) obj;
                Iterator<Map.Entry<K, Collection<V>>> it = t0.this.f.asMap().entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<K, Collection<V>> next = it.next();
                    Collection m = t0.m(next.getValue(), new c(next.getKey()));
                    if (!m.isEmpty() && collection.equals(m)) {
                        if (m.size() == next.getValue().size()) {
                            it.remove();
                            return true;
                        }
                        m.clear();
                        return true;
                    }
                }
                return false;
            }

            @Override // com.google.common.collect.Maps.f0, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                return t0.this.n(Maps.o(Predicates.in(collection)));
            }

            @Override // com.google.common.collect.Maps.f0, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                return t0.this.n(Maps.o(Predicates.not(Predicates.in(collection))));
            }
        }

        public a() {
        }

        @Override // com.google.common.collect.Maps.g0
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new C0062a();
        }

        @Override // com.google.common.collect.Maps.g0
        public Set<K> c() {
            return new b();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            t0.this.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@NullableDecl Object obj) {
            return get(obj) != null;
        }

        @Override // com.google.common.collect.Maps.g0
        public Collection<Collection<V>> d() {
            return new c();
        }

        /* renamed from: e */
        public Collection<V> get(@NullableDecl Object obj) {
            Collection<V> collection = t0.this.f.asMap().get(obj);
            if (collection == null) {
                return null;
            }
            Collection<V> m = t0.m(collection, new c(obj));
            if (m.isEmpty()) {
                return null;
            }
            return m;
        }

        /* renamed from: f */
        public Collection<V> remove(@NullableDecl Object obj) {
            Collection<V> collection = t0.this.f.asMap().get(obj);
            if (collection == null) {
                return null;
            }
            ArrayList newArrayList = Lists.newArrayList();
            Iterator<V> it = collection.iterator();
            while (it.hasNext()) {
                V next = it.next();
                if (t0.l(t0.this, obj, next)) {
                    it.remove();
                    newArrayList.add(next);
                }
            }
            if (newArrayList.isEmpty()) {
                return null;
            }
            if (t0.this.f instanceof SetMultimap) {
                return Collections.unmodifiableSet(Sets.newLinkedHashSet(newArrayList));
            }
            return Collections.unmodifiableList(newArrayList);
        }
    }

    public class b extends Multimaps.g<K, V> {

        public class a extends Multisets.h<K> {
            public a() {
            }

            @Override // com.google.common.collect.Multisets.h
            public Multiset<K> d() {
                return b.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<Multiset.Entry<K>> iterator() {
                return b.this.d();
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                return t0.this.n(new u0(this, Predicates.in(collection)));
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return t0.this.n(new u0(this, Predicates.not(Predicates.in(collection))));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return t0.this.keySet().size();
            }
        }

        public b() {
            super(t0.this);
        }

        @Override // a2.j.d.c.i, com.google.common.collect.Multiset
        public Set<Multiset.Entry<K>> entrySet() {
            return new a();
        }

        @Override // com.google.common.collect.Multimaps.g, a2.j.d.c.i, com.google.common.collect.Multiset
        public int remove(@NullableDecl Object obj, int i) {
            AppCompatDelegateImpl.i.z(i, "occurrences");
            if (i == 0) {
                return count(obj);
            }
            Collection<V> collection = t0.this.f.asMap().get(obj);
            int i2 = 0;
            if (collection == null) {
                return 0;
            }
            Iterator<V> it = collection.iterator();
            while (it.hasNext()) {
                if (t0.l(t0.this, obj, it.next()) && (i2 = i2 + 1) <= i) {
                    it.remove();
                }
            }
            return i2;
        }
    }

    public final class c implements Predicate<V> {
        public final K a;

        public c(K k) {
            this.a = k;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl V v) {
            return t0.l(t0.this, this.a, v);
        }
    }

    public t0(Multimap<K, V> multimap, Predicate<? super Map.Entry<K, V>> predicate) {
        this.f = (Multimap) Preconditions.checkNotNull(multimap);
        this.g = (Predicate) Preconditions.checkNotNull(predicate);
    }

    public static boolean l(t0 t0Var, Object obj, Object obj2) {
        return t0Var.g.apply(Maps.immutableEntry(obj, obj2));
    }

    public static <E> Collection<E> m(Collection<E> collection, Predicate<? super E> predicate) {
        if (collection instanceof Set) {
            return Sets.filter((Set) collection, predicate);
        }
        return Collections2.filter(collection, predicate);
    }

    @Override // a2.j.d.c.z0
    /* renamed from: a */
    public Multimap<K, V> mo31a() {
        return this.f;
    }

    @Override // a2.j.d.c.h
    public Map<K, Collection<V>> b() {
        return new a();
    }

    @Override // a2.j.d.c.z0
    public Predicate<? super Map.Entry<K, V>> c() {
        return this.g;
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        entries().clear();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@NullableDecl Object obj) {
        return asMap().get(obj) != null;
    }

    @Override // a2.j.d.c.h
    public Collection<Map.Entry<K, V>> d() {
        return m(this.f.entries(), this.g);
    }

    @Override // a2.j.d.c.h
    public Set<K> e() {
        return asMap().keySet();
    }

    @Override // a2.j.d.c.h
    public Multiset<K> f() {
        return new b();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public Collection<V> mo118get(K k) {
        return m(this.f.mo118get(k), new c(k));
    }

    @Override // a2.j.d.c.h
    public Collection<V> h() {
        return new a1(this);
    }

    @Override // a2.j.d.c.h
    public Iterator<Map.Entry<K, V>> i() {
        throw new AssertionError("should never be called");
    }

    public boolean n(Predicate<? super Map.Entry<K, Collection<V>>> predicate) {
        Iterator<Map.Entry<K, Collection<V>>> it = this.f.asMap().entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Map.Entry<K, Collection<V>> next = it.next();
            K key = next.getKey();
            Collection m = m(next.getValue(), new c(key));
            if (!m.isEmpty() && predicate.apply(Maps.immutableEntry(key, m))) {
                if (m.size() == next.getValue().size()) {
                    it.remove();
                } else {
                    m.clear();
                }
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: removeAll */
    public Collection<V> mo119removeAll(@NullableDecl Object obj) {
        Object obj2;
        Collection<V> remove = asMap().remove(obj);
        if (this.f instanceof SetMultimap) {
            obj2 = Collections.emptySet();
        } else {
            obj2 = Collections.emptyList();
        }
        return (Collection) MoreObjects.firstNonNull(remove, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return entries().size();
    }
}
