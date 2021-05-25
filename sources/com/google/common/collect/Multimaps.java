package com.google.common.collect;

import a2.j.d.c.b1;
import a2.j.d.c.b5;
import a2.j.d.c.c2;
import a2.j.d.c.d2;
import a2.j.d.c.e;
import a2.j.d.c.f2;
import a2.j.d.c.g2;
import a2.j.d.c.h;
import a2.j.d.c.l4;
import a2.j.d.c.n4;
import a2.j.d.c.p;
import a2.j.d.c.p2;
import a2.j.d.c.t0;
import a2.j.d.c.u;
import a2.j.d.c.v0;
import a2.j.d.c.v4;
import a2.j.d.c.w0;
import a2.j.d.c.x0;
import a2.j.d.c.y0;
import a2.j.d.c.y4;
import a2.j.d.c.z0;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public final class Multimaps {

    public static final class a<K, V> extends Maps.g0<K, Collection<V>> {
        @Weak
        public final Multimap<K, V> d;

        /* renamed from: com.google.common.collect.Multimaps$a$a  reason: collision with other inner class name */
        public class C0281a extends Maps.i<K, Collection<V>> {

            /* renamed from: com.google.common.collect.Multimaps$a$a$a  reason: collision with other inner class name */
            public class C0282a implements Function<K, Collection<V>> {
                public C0282a() {
                }

                @Override // com.google.common.base.Function
                public Object apply(Object obj) {
                    return a.this.d.mo118get(obj);
                }
            }

            public C0281a() {
            }

            @Override // com.google.common.collect.Maps.i
            public Map<K, Collection<V>> d() {
                return a.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return Maps.d(a.this.d.keySet(), new C0282a());
            }

            @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                a aVar = a.this;
                aVar.d.keySet().remove(((Map.Entry) obj).getKey());
                return true;
            }
        }

        public a(Multimap<K, V> multimap) {
            this.d = (Multimap) Preconditions.checkNotNull(multimap);
        }

        @Override // com.google.common.collect.Maps.g0
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new C0281a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.d.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.d.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            if (this.d.containsKey(obj)) {
                return this.d.mo118get(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.d.isEmpty();
        }

        @Override // com.google.common.collect.Maps.g0, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.d.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            if (this.d.containsKey(obj)) {
                return this.d.mo119removeAll(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.d.keySet().size();
        }
    }

    public static class b<K, V> extends a2.j.d.c.d<K, V> {
        @GwtIncompatible
        private static final long serialVersionUID = 0;
        public transient Supplier<? extends List<V>> h;

        public b(Map<K, Collection<V>> map, Supplier<? extends List<V>> supplier) {
            super(map);
            this.h = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.h = (Supplier) objectInputStream.readObject();
            s((Map) objectInputStream.readObject());
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.h);
            objectOutputStream.writeObject(this.f);
        }

        @Override // a2.j.d.c.e, a2.j.d.c.h
        public Map<K, Collection<V>> b() {
            return p();
        }

        @Override // a2.j.d.c.e, a2.j.d.c.h
        public Set<K> e() {
            return q();
        }

        @Override // a2.j.d.c.e
        public Collection n() {
            return (List) this.h.get();
        }
    }

    public static class c<K, V> extends a2.j.d.c.e<K, V> {
        @GwtIncompatible
        private static final long serialVersionUID = 0;
        public transient Supplier<? extends Collection<V>> h;

        public c(Map<K, Collection<V>> map, Supplier<? extends Collection<V>> supplier) {
            super(map);
            this.h = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.h = (Supplier) objectInputStream.readObject();
            s((Map) objectInputStream.readObject());
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.h);
            objectOutputStream.writeObject(this.f);
        }

        @Override // a2.j.d.c.e, a2.j.d.c.h
        public Map<K, Collection<V>> b() {
            return p();
        }

        @Override // a2.j.d.c.e, a2.j.d.c.h
        public Set<K> e() {
            return q();
        }

        @Override // a2.j.d.c.e
        public Collection<V> n() {
            return (Collection) this.h.get();
        }

        @Override // a2.j.d.c.e
        public <E> Collection<E> t(Collection<E> collection) {
            if (collection instanceof NavigableSet) {
                return Sets.unmodifiableNavigableSet((NavigableSet) collection);
            }
            if (collection instanceof SortedSet) {
                return Collections.unmodifiableSortedSet((SortedSet) collection);
            }
            if (collection instanceof Set) {
                return Collections.unmodifiableSet((Set) collection);
            }
            if (collection instanceof List) {
                return Collections.unmodifiableList((List) collection);
            }
            return Collections.unmodifiableCollection(collection);
        }

        @Override // a2.j.d.c.e
        public Collection<V> u(K k, Collection<V> collection) {
            if (collection instanceof List) {
                return v(k, (List) collection, null);
            }
            if (collection instanceof NavigableSet) {
                return new e.m(k, (NavigableSet) collection, null);
            }
            if (collection instanceof SortedSet) {
                return new e.o(k, (SortedSet) collection, null);
            }
            if (collection instanceof Set) {
                return new e.n(k, (Set) collection);
            }
            return new e.k(k, collection, null);
        }
    }

    public static class d<K, V> extends a2.j.d.c.l<K, V> {
        @GwtIncompatible
        private static final long serialVersionUID = 0;
        public transient Supplier<? extends Set<V>> h;

        public d(Map<K, Collection<V>> map, Supplier<? extends Set<V>> supplier) {
            super(map);
            this.h = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.h = (Supplier) objectInputStream.readObject();
            s((Map) objectInputStream.readObject());
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.h);
            objectOutputStream.writeObject(this.f);
        }

        @Override // a2.j.d.c.e, a2.j.d.c.h
        public Map<K, Collection<V>> b() {
            return p();
        }

        @Override // a2.j.d.c.e, a2.j.d.c.h
        public Set<K> e() {
            return q();
        }

        @Override // a2.j.d.c.e
        public Collection n() {
            return (Set) this.h.get();
        }

        @Override // a2.j.d.c.l, a2.j.d.c.e
        public <E> Collection<E> t(Collection<E> collection) {
            if (collection instanceof NavigableSet) {
                return Sets.unmodifiableNavigableSet((NavigableSet) collection);
            }
            if (collection instanceof SortedSet) {
                return Collections.unmodifiableSortedSet((SortedSet) collection);
            }
            return Collections.unmodifiableSet((Set) collection);
        }

        @Override // a2.j.d.c.l, a2.j.d.c.e
        public Collection<V> u(K k, Collection<V> collection) {
            if (collection instanceof NavigableSet) {
                return new e.m(k, (NavigableSet) collection, null);
            }
            if (collection instanceof SortedSet) {
                return new e.o(k, (SortedSet) collection, null);
            }
            return new e.n(k, (Set) collection);
        }
    }

    public static class e<K, V> extends p<K, V> {
        @GwtIncompatible
        private static final long serialVersionUID = 0;
        public transient Supplier<? extends SortedSet<V>> h;
        public transient Comparator<? super V> i;

        public e(Map<K, Collection<V>> map, Supplier<? extends SortedSet<V>> supplier) {
            super(map);
            this.h = (Supplier) Preconditions.checkNotNull(supplier);
            this.i = ((SortedSet) supplier.get()).comparator();
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            Supplier<? extends SortedSet<V>> supplier = (Supplier) objectInputStream.readObject();
            this.h = supplier;
            this.i = ((SortedSet) supplier.get()).comparator();
            s((Map) objectInputStream.readObject());
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.h);
            objectOutputStream.writeObject(this.f);
        }

        @Override // a2.j.d.c.e, a2.j.d.c.h
        public Map<K, Collection<V>> b() {
            return p();
        }

        @Override // a2.j.d.c.e, a2.j.d.c.h
        public Set<K> e() {
            return q();
        }

        @Override // a2.j.d.c.e
        public Collection n() {
            return (SortedSet) this.h.get();
        }

        @Override // com.google.common.collect.SortedSetMultimap
        public Comparator<? super V> valueComparator() {
            return this.i;
        }

        @Override // a2.j.d.c.p
        public SortedSet<V> x() {
            return (SortedSet) this.h.get();
        }
    }

    public static abstract class f<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a2.j.d.c.h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a2.j.d.c.h.this.containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a2.j.d.c.h.this.remove(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a2.j.d.c.h.this.size();
        }
    }

    public static class g<K, V> extends a2.j.d.c.i<K> {
        @Weak
        public final Multimap<K, V> c;

        public class a extends b5<Map.Entry<K, Collection<V>>, Multiset.Entry<K>> {
            public a(g gVar, Iterator it) {
                super(it);
            }

            @Override // a2.j.d.c.b5
            public Object a(Object obj) {
                return new p2(this, (Map.Entry) obj);
            }
        }

        public g(Multimap<K, V> multimap) {
            this.c = multimap;
        }

        @Override // a2.j.d.c.i
        public int b() {
            return this.c.asMap().size();
        }

        @Override // a2.j.d.c.i
        public Iterator<K> c() {
            throw new AssertionError("should never be called");
        }

        @Override // a2.j.d.c.i, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.c.clear();
        }

        @Override // a2.j.d.c.i, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public boolean contains(@NullableDecl Object obj) {
            return this.c.containsKey(obj);
        }

        @Override // com.google.common.collect.Multiset
        public int count(@NullableDecl Object obj) {
            Collection collection = (Collection) Maps.l(this.c.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        @Override // a2.j.d.c.i
        public Iterator<Multiset.Entry<K>> d() {
            return new a(this, this.c.asMap().entrySet().iterator());
        }

        @Override // a2.j.d.c.i, com.google.common.collect.Multiset
        /* renamed from: elementSet */
        public Set<K> mo6elementSet() {
            return this.c.keySet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public Iterator<K> iterator() {
            return new g2(this.c.entries().iterator());
        }

        @Override // a2.j.d.c.i, com.google.common.collect.Multiset
        public int remove(@NullableDecl Object obj, int i) {
            AppCompatDelegateImpl.i.z(i, "occurrences");
            if (i == 0) {
                return count(obj);
            }
            Collection collection = (Collection) Maps.l(this.c.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            int size = collection.size();
            if (i >= size) {
                collection.clear();
            } else {
                Iterator it = collection.iterator();
                for (int i2 = 0; i2 < i; i2++) {
                    it.next();
                    it.remove();
                }
            }
            return size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return this.c.size();
        }
    }

    public static class h<K, V> extends a2.j.d.c.h<K, V> implements SetMultimap<K, V>, Serializable {
        private static final long serialVersionUID = 7845222491160860175L;
        public final Map<K, V> f;

        public class a extends Sets.k<V> {
            public final /* synthetic */ Object a;

            /* renamed from: com.google.common.collect.Multimaps$h$a$a  reason: collision with other inner class name */
            public class C0283a implements Iterator<V> {
                public int a;

                public C0283a() {
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    if (this.a == 0) {
                        a aVar = a.this;
                        if (h.this.f.containsKey(aVar.a)) {
                            return true;
                        }
                    }
                    return false;
                }

                @Override // java.util.Iterator
                public V next() {
                    if (hasNext()) {
                        this.a++;
                        a aVar = a.this;
                        return h.this.f.get(aVar.a);
                    }
                    throw new NoSuchElementException();
                }

                @Override // java.util.Iterator
                public void remove() {
                    boolean z = true;
                    if (this.a != 1) {
                        z = false;
                    }
                    Preconditions.checkState(z, "no calls to next() since the last call to remove()");
                    this.a = -1;
                    a aVar = a.this;
                    h.this.f.remove(aVar.a);
                }
            }

            public a(Object obj) {
                this.a = obj;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<V> iterator() {
                return new C0283a();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return h.this.f.containsKey(this.a) ? 1 : 0;
            }
        }

        public h(Map<K, V> map) {
            this.f = (Map) Preconditions.checkNotNull(map);
        }

        @Override // a2.j.d.c.h
        public Map<K, Collection<V>> b() {
            return new a(this);
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            this.f.clear();
        }

        @Override // a2.j.d.c.h, com.google.common.collect.Multimap
        public boolean containsEntry(Object obj, Object obj2) {
            return this.f.entrySet().contains(Maps.immutableEntry(obj, obj2));
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(Object obj) {
            return this.f.containsKey(obj);
        }

        @Override // a2.j.d.c.h, com.google.common.collect.Multimap
        public boolean containsValue(Object obj) {
            return this.f.containsValue(obj);
        }

        @Override // a2.j.d.c.h
        public Collection<Map.Entry<K, V>> d() {
            throw new AssertionError("unreachable");
        }

        @Override // a2.j.d.c.h
        public Set<K> e() {
            return this.f.keySet();
        }

        @Override // a2.j.d.c.h
        public Multiset<K> f() {
            return new g(this);
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get */
        public Collection mo118get(Object obj) {
            return new a(obj);
        }

        @Override // a2.j.d.c.h
        public Collection<V> h() {
            return this.f.values();
        }

        @Override // a2.j.d.c.h, com.google.common.collect.Multimap
        public int hashCode() {
            return this.f.hashCode();
        }

        @Override // a2.j.d.c.h
        public Iterator<Map.Entry<K, V>> i() {
            return this.f.entrySet().iterator();
        }

        @Override // a2.j.d.c.h, com.google.common.collect.Multimap
        public boolean put(K k, V v) {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.c.h, com.google.common.collect.Multimap
        public boolean putAll(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.c.h, com.google.common.collect.Multimap
        public boolean remove(Object obj, Object obj2) {
            return this.f.entrySet().remove(Maps.immutableEntry(obj, obj2));
        }

        @Override // a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: replaceValues */
        public Collection mo120replaceValues(Object obj, Iterable iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            return this.f.size();
        }

        @Override // a2.j.d.c.h, com.google.common.collect.Multimap
        public Set<Map.Entry<K, V>> entries() {
            return this.f.entrySet();
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get  reason: collision with other method in class */
        public Set<V> mo118get(K k) {
            return new a(k);
        }

        @Override // a2.j.d.c.h, com.google.common.collect.Multimap
        public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: removeAll */
        public Set<V> mo119removeAll(Object obj) {
            HashSet hashSet = new HashSet(2);
            if (!this.f.containsKey(obj)) {
                return hashSet;
            }
            hashSet.add(this.f.remove(obj));
            return hashSet;
        }

        @Override // a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: replaceValues  reason: collision with other method in class */
        public Set<V> mo120replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class i<K, V1, V2> extends j<K, V1, V2> implements ListMultimap<K, V2> {
        public i(ListMultimap<K, V1> listMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(listMultimap, entryTransformer);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.j, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get */
        public Collection mo118get(Object obj) {
            return l(obj, this.f.mo118get(obj));
        }

        /* renamed from: m */
        public List<V2> l(K k, Collection<V1> collection) {
            Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer = this.g;
            Preconditions.checkNotNull(entryTransformer);
            return Lists.transform((List) collection, new c2(entryTransformer, k));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.j, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: removeAll */
        public Collection mo119removeAll(Object obj) {
            return l(obj, this.f.mo119removeAll(obj));
        }

        @Override // com.google.common.collect.Multimaps.j, a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: replaceValues */
        public Collection mo120replaceValues(Object obj, Iterable iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.j, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get  reason: collision with other method in class */
        public List<V2> mo118get(K k) {
            return l(k, this.f.mo118get(k));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.j, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: removeAll  reason: collision with other method in class */
        public List<V2> mo119removeAll(Object obj) {
            return l(obj, this.f.mo119removeAll(obj));
        }

        @Override // com.google.common.collect.Multimaps.j, a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: replaceValues  reason: collision with other method in class */
        public List<V2> mo120replaceValues(K k, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }
    }

    public static class j<K, V1, V2> extends a2.j.d.c.h<K, V2> {
        public final Multimap<K, V1> f;
        public final Maps.EntryTransformer<? super K, ? super V1, V2> g;

        public class a implements Maps.EntryTransformer<K, Collection<V1>, Collection<V2>> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.EntryTransformer
            public Object transformEntry(Object obj, Object obj2) {
                return j.this.l(obj, (Collection) obj2);
            }
        }

        public j(Multimap<K, V1> multimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            this.f = (Multimap) Preconditions.checkNotNull(multimap);
            this.g = (Maps.EntryTransformer) Preconditions.checkNotNull(entryTransformer);
        }

        @Override // a2.j.d.c.h
        public Map<K, Collection<V2>> b() {
            return Maps.transformEntries(this.f.asMap(), new a());
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            this.f.clear();
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(Object obj) {
            return this.f.containsKey(obj);
        }

        @Override // a2.j.d.c.h
        public Collection<Map.Entry<K, V2>> d() {
            return new h.a();
        }

        @Override // a2.j.d.c.h
        public Set<K> e() {
            return this.f.keySet();
        }

        @Override // a2.j.d.c.h
        public Multiset<K> f() {
            return this.f.keys();
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get */
        public Collection<V2> mo118get(K k) {
            return l(k, this.f.mo118get(k));
        }

        @Override // a2.j.d.c.h
        public Collection<V2> h() {
            Collection<Map.Entry<K, V1>> entries = this.f.entries();
            Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer = this.g;
            Preconditions.checkNotNull(entryTransformer);
            return Collections2.transform(entries, new d2(entryTransformer));
        }

        @Override // a2.j.d.c.h
        public Iterator<Map.Entry<K, V2>> i() {
            Iterator<Map.Entry<K, V1>> it = this.f.entries().iterator();
            Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer = this.g;
            Preconditions.checkNotNull(entryTransformer);
            return Iterators.transform(it, new f2(entryTransformer));
        }

        @Override // a2.j.d.c.h, com.google.common.collect.Multimap
        public boolean isEmpty() {
            return this.f.isEmpty();
        }

        public Collection<V2> l(K k, Collection<V1> collection) {
            Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer = this.g;
            Preconditions.checkNotNull(entryTransformer);
            c2 c2Var = new c2(entryTransformer, k);
            if (collection instanceof List) {
                return Lists.transform((List) collection, c2Var);
            }
            return Collections2.transform(collection, c2Var);
        }

        @Override // a2.j.d.c.h, com.google.common.collect.Multimap
        public boolean put(K k, V2 v2) {
            throw new UnsupportedOperationException();
        }

        @Override // a2.j.d.c.h, com.google.common.collect.Multimap
        public boolean putAll(K k, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // a2.j.d.c.h, com.google.common.collect.Multimap
        public boolean remove(Object obj, Object obj2) {
            return mo118get(obj).remove(obj2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: removeAll */
        public Collection<V2> mo119removeAll(Object obj) {
            return l(obj, this.f.mo119removeAll(obj));
        }

        @Override // a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: replaceValues */
        public Collection<V2> mo120replaceValues(K k, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            return this.f.size();
        }

        @Override // a2.j.d.c.h, com.google.common.collect.Multimap
        public boolean putAll(Multimap<? extends K, ? extends V2> multimap) {
            throw new UnsupportedOperationException();
        }
    }

    public static class k<K, V> extends l<K, V> implements ListMultimap<K, V> {
        private static final long serialVersionUID = 0;

        public k(ListMultimap<K, V> listMultimap) {
            super(listMultimap);
        }

        @Override // com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Multimap mo147delegate() {
            return (ListMultimap) this.a;
        }

        @Override // com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get */
        public Collection mo118get(Object obj) {
            return Collections.unmodifiableList(((ListMultimap) this.a).mo118get((ListMultimap) obj));
        }

        @Override // com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: removeAll */
        public Collection mo119removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: replaceValues */
        public Collection mo120replaceValues(Object obj, Iterable iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: removeAll  reason: collision with other method in class */
        public List<V> mo119removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: replaceValues  reason: collision with other method in class */
        public List<V> mo120replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        /* renamed from: delegate  reason: collision with other method in class */
        public Object mo147delegate() {
            return (ListMultimap) this.a;
        }

        @Override // com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get  reason: collision with other method in class */
        public List<V> mo118get(K k) {
            return Collections.unmodifiableList(((ListMultimap) this.a).mo118get((ListMultimap) k));
        }
    }

    public static class l<K, V> extends ForwardingMultimap<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        public final Multimap<K, V> a;
        @MonotonicNonNullDecl
        public transient Collection<Map.Entry<K, V>> b;
        @MonotonicNonNullDecl
        public transient Multiset<K> c;
        @MonotonicNonNullDecl
        public transient Set<K> d;
        @MonotonicNonNullDecl
        public transient Collection<V> e;
        @MonotonicNonNullDecl
        public transient Map<K, Collection<V>> f;

        public class a implements Function<Collection<V>, Collection<V>> {
            public a(l lVar) {
            }

            @Override // com.google.common.base.Function
            public Object apply(Object obj) {
                return Multimaps.a((Collection) obj);
            }
        }

        public l(Multimap<K, V> multimap) {
            this.a = (Multimap) Preconditions.checkNotNull(multimap);
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> map = this.f;
            if (map != null) {
                return map;
            }
            Map<K, Collection<V>> unmodifiableMap = Collections.unmodifiableMap(Maps.transformValues(this.a.asMap(), new a(this)));
            this.f = unmodifiableMap;
            return unmodifiableMap;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> collection;
            Collection<Map.Entry<K, V>> collection2 = this.b;
            if (collection2 != null) {
                return collection2;
            }
            Collection<Map.Entry<K, V>> entries = this.a.entries();
            if (entries instanceof Set) {
                collection = new Maps.c0<>(Collections.unmodifiableSet((Set) entries));
            } else {
                collection = new Maps.b0<>(Collections.unmodifiableCollection(entries));
            }
            this.b = collection;
            return collection;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get */
        public Collection<V> mo118get(K k) {
            return Multimaps.a(this.a.mo118get(k));
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Set<K> keySet() {
            Set<K> set = this.d;
            if (set != null) {
                return set;
            }
            Set<K> unmodifiableSet = Collections.unmodifiableSet(this.a.keySet());
            this.d = unmodifiableSet;
            return unmodifiableSet;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Multiset<K> keys() {
            Multiset<K> multiset = this.c;
            if (multiset != null) {
                return multiset;
            }
            Multiset<K> unmodifiableMultiset = Multisets.unmodifiableMultiset(this.a.keys());
            this.c = unmodifiableMultiset;
            return unmodifiableMultiset;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean put(K k, V v) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean putAll(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean remove(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: removeAll */
        public Collection<V> mo119removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: replaceValues */
        public Collection<V> mo120replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Collection<V> values() {
            Collection<V> collection = this.e;
            if (collection != null) {
                return collection;
            }
            Collection<V> unmodifiableCollection = Collections.unmodifiableCollection(this.a.values());
            this.e = unmodifiableCollection;
            return unmodifiableCollection;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Multimap<K, V> mo147delegate() {
            return this.a;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
            throw new UnsupportedOperationException();
        }
    }

    public static class m<K, V> extends l<K, V> implements SetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        public m(SetMultimap<K, V> setMultimap) {
            super(setMultimap);
        }

        @Override // com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public SetMultimap<K, V> mo147delegate() {
            return (SetMultimap) this.a;
        }

        @Override // com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Set<Map.Entry<K, V>> entries() {
            return new Maps.c0(Collections.unmodifiableSet(mo147delegate().entries()));
        }

        @Override // com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get */
        public Set<V> mo118get(K k) {
            return Collections.unmodifiableSet(mo147delegate().mo118get((SetMultimap<K, V>) k));
        }

        @Override // com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: removeAll */
        public Set<V> mo119removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: replaceValues */
        public Set<V> mo120replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }
    }

    public static class n<K, V> extends m<K, V> implements SortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        public n(SortedSetMultimap<K, V> sortedSetMultimap) {
            super(sortedSetMultimap);
        }

        @Override // com.google.common.collect.Multimaps.m, com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public SortedSetMultimap<K, V> mo147delegate() {
            return (SortedSetMultimap) ((SetMultimap) this.a);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.m, com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get */
        public Collection mo118get(Object obj) {
            return Collections.unmodifiableSortedSet(mo147delegate().mo118get((SortedSetMultimap<K, V>) obj));
        }

        @Override // com.google.common.collect.Multimaps.m, com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: removeAll */
        public Collection mo119removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.m, com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: replaceValues */
        public Collection mo120replaceValues(Object obj, Iterable iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.SortedSetMultimap
        public Comparator<? super V> valueComparator() {
            return mo147delegate().valueComparator();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.m, com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get  reason: collision with other method in class */
        public Set mo118get(Object obj) {
            return Collections.unmodifiableSortedSet(mo147delegate().mo118get((SortedSetMultimap<K, V>) obj));
        }

        @Override // com.google.common.collect.Multimaps.m, com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: removeAll  reason: collision with other method in class */
        public Set mo119removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.m, com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: replaceValues  reason: collision with other method in class */
        public Set mo120replaceValues(Object obj, Iterable iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.m, com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get */
        public SortedSet<V> mo118get(K k) {
            return Collections.unmodifiableSortedSet(mo147delegate().mo118get((SortedSetMultimap<K, V>) k));
        }

        @Override // com.google.common.collect.Multimaps.m, com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: removeAll */
        public SortedSet<V> mo119removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.m, com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: replaceValues */
        public SortedSet<V> mo120replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }
    }

    public static Collection a(Collection collection) {
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet) collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set) collection);
        }
        if (collection instanceof List) {
            return Collections.unmodifiableList((List) collection);
        }
        return Collections.unmodifiableCollection(collection);
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.Map<K, java.util.Collection<V>>, java.util.Map<K, java.util.List<V>> */
    @Beta
    public static <K, V> Map<K, List<V>> asMap(ListMultimap<K, V> listMultimap) {
        return (Map<K, Collection<V>>) listMultimap.asMap();
    }

    public static <K, V> Multimap<K, V> filterEntries(Multimap<K, V> multimap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (multimap instanceof SetMultimap) {
            return filterEntries((SetMultimap) multimap, (Predicate) predicate);
        }
        if (!(multimap instanceof z0)) {
            return new t0((Multimap) Preconditions.checkNotNull(multimap), predicate);
        }
        z0 z0Var = (z0) multimap;
        return new t0(z0Var.mo31a(), Predicates.and(z0Var.c(), predicate));
    }

    public static <K, V> Multimap<K, V> filterKeys(Multimap<K, V> multimap, Predicate<? super K> predicate) {
        if (multimap instanceof SetMultimap) {
            return filterKeys((SetMultimap) multimap, (Predicate) predicate);
        }
        if (multimap instanceof ListMultimap) {
            return filterKeys((ListMultimap) multimap, (Predicate) predicate);
        }
        if (multimap instanceof x0) {
            x0 x0Var = (x0) multimap;
            return new x0(x0Var.f, Predicates.and(x0Var.g, predicate));
        } else if (!(multimap instanceof z0)) {
            return new x0(multimap, predicate);
        } else {
            z0 z0Var = (z0) multimap;
            return new t0(z0Var.mo31a(), Predicates.and(z0Var.c(), Maps.j(predicate)));
        }
    }

    public static <K, V> Multimap<K, V> filterValues(Multimap<K, V> multimap, Predicate<? super V> predicate) {
        return filterEntries(multimap, Maps.o(predicate));
    }

    public static <K, V> SetMultimap<K, V> forMap(Map<K, V> map) {
        return new h(map);
    }

    public static <K, V> ImmutableListMultimap<K, V> index(Iterable<V> iterable, Function<? super V, K> function) {
        return index(iterable.iterator(), function);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: M extends com.google.common.collect.Multimap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @CanIgnoreReturnValue
    public static <K, V, M extends Multimap<K, V>> M invertFrom(Multimap<? extends V, ? extends K> multimap, M m2) {
        Preconditions.checkNotNull(m2);
        for (Map.Entry<? extends V, ? extends K> entry : multimap.entries()) {
            m2.put(entry.getValue(), entry.getKey());
        }
        return m2;
    }

    public static <K, V> ListMultimap<K, V> newListMultimap(Map<K, Collection<V>> map, Supplier<? extends List<V>> supplier) {
        return new b(map, supplier);
    }

    public static <K, V> Multimap<K, V> newMultimap(Map<K, Collection<V>> map, Supplier<? extends Collection<V>> supplier) {
        return new c(map, supplier);
    }

    public static <K, V> SetMultimap<K, V> newSetMultimap(Map<K, Collection<V>> map, Supplier<? extends Set<V>> supplier) {
        return new d(map, supplier);
    }

    public static <K, V> SortedSetMultimap<K, V> newSortedSetMultimap(Map<K, Collection<V>> map, Supplier<? extends SortedSet<V>> supplier) {
        return new e(map, supplier);
    }

    public static <K, V> ListMultimap<K, V> synchronizedListMultimap(ListMultimap<K, V> listMultimap) {
        return ((listMultimap instanceof l4) || (listMultimap instanceof u)) ? listMultimap : new l4(listMultimap, null);
    }

    public static <K, V> Multimap<K, V> synchronizedMultimap(Multimap<K, V> multimap) {
        return ((multimap instanceof n4) || (multimap instanceof u)) ? multimap : new n4(multimap, null);
    }

    public static <K, V> SetMultimap<K, V> synchronizedSetMultimap(SetMultimap<K, V> setMultimap) {
        return ((setMultimap instanceof v4) || (setMultimap instanceof u)) ? setMultimap : new v4(setMultimap, null);
    }

    public static <K, V> SortedSetMultimap<K, V> synchronizedSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap) {
        return sortedSetMultimap instanceof y4 ? sortedSetMultimap : new y4(sortedSetMultimap, null);
    }

    public static <K, V1, V2> Multimap<K, V2> transformEntries(Multimap<K, V1> multimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new j(multimap, entryTransformer);
    }

    public static <K, V1, V2> Multimap<K, V2> transformValues(Multimap<K, V1> multimap, Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        return transformEntries(multimap, Maps.c(function));
    }

    public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ListMultimap<K, V> listMultimap) {
        return ((listMultimap instanceof k) || (listMultimap instanceof ImmutableListMultimap)) ? listMultimap : new k(listMultimap);
    }

    public static <K, V> Multimap<K, V> unmodifiableMultimap(Multimap<K, V> multimap) {
        return ((multimap instanceof l) || (multimap instanceof ImmutableMultimap)) ? multimap : new l(multimap);
    }

    public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(SetMultimap<K, V> setMultimap) {
        return ((setMultimap instanceof m) || (setMultimap instanceof ImmutableSetMultimap)) ? setMultimap : new m(setMultimap);
    }

    public static <K, V> SortedSetMultimap<K, V> unmodifiableSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap) {
        if (sortedSetMultimap instanceof n) {
            return sortedSetMultimap;
        }
        return new n(sortedSetMultimap);
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.Map<K, java.util.Collection<V>>, java.util.Map<K, java.util.Set<V>> */
    @Beta
    public static <K, V> Map<K, Set<V>> asMap(SetMultimap<K, V> setMultimap) {
        return (Map<K, Collection<V>>) setMultimap.asMap();
    }

    public static <K, V> SetMultimap<K, V> filterValues(SetMultimap<K, V> setMultimap, Predicate<? super V> predicate) {
        return filterEntries((SetMultimap) setMultimap, Maps.o(predicate));
    }

    public static <K, V> ImmutableListMultimap<K, V> index(Iterator<V> it, Function<? super V, K> function) {
        Preconditions.checkNotNull(function);
        ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
        while (it.hasNext()) {
            V next = it.next();
            Preconditions.checkNotNull(next, it);
            builder.put((ImmutableListMultimap.Builder) function.apply(next), (K) next);
        }
        return builder.build();
    }

    public static <K, V1, V2> ListMultimap<K, V2> transformEntries(ListMultimap<K, V1> listMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new i(listMultimap, entryTransformer);
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.Map<K, java.util.Collection<V>>, java.util.Map<K, java.util.SortedSet<V>> */
    @Beta
    public static <K, V> Map<K, SortedSet<V>> asMap(SortedSetMultimap<K, V> sortedSetMultimap) {
        return (Map<K, Collection<V>>) sortedSetMultimap.asMap();
    }

    @Deprecated
    public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ImmutableListMultimap<K, V> immutableListMultimap) {
        return (ListMultimap) Preconditions.checkNotNull(immutableListMultimap);
    }

    @Deprecated
    public static <K, V> Multimap<K, V> unmodifiableMultimap(ImmutableMultimap<K, V> immutableMultimap) {
        return (Multimap) Preconditions.checkNotNull(immutableMultimap);
    }

    @Deprecated
    public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(ImmutableSetMultimap<K, V> immutableSetMultimap) {
        return (SetMultimap) Preconditions.checkNotNull(immutableSetMultimap);
    }

    @Beta
    public static <K, V> Map<K, Collection<V>> asMap(Multimap<K, V> multimap) {
        return multimap.asMap();
    }

    public static <K, V1, V2> ListMultimap<K, V2> transformValues(ListMultimap<K, V1> listMultimap, Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        return transformEntries((ListMultimap) listMultimap, Maps.c(function));
    }

    public static <K, V> SetMultimap<K, V> filterEntries(SetMultimap<K, V> setMultimap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (!(setMultimap instanceof b1)) {
            return new v0((SetMultimap) Preconditions.checkNotNull(setMultimap), predicate);
        }
        b1 b1Var = (b1) setMultimap;
        return new v0(b1Var.mo31a(), Predicates.and(b1Var.c(), predicate));
    }

    public static <K, V> SetMultimap<K, V> filterKeys(SetMultimap<K, V> setMultimap, Predicate<? super K> predicate) {
        if (setMultimap instanceof y0) {
            y0 y0Var = (y0) setMultimap;
            return new y0((SetMultimap) y0Var.f, Predicates.and(y0Var.g, predicate));
        } else if (!(setMultimap instanceof b1)) {
            return new y0(setMultimap, predicate);
        } else {
            b1 b1Var = (b1) setMultimap;
            return new v0(b1Var.mo31a(), Predicates.and(b1Var.c(), Maps.j(predicate)));
        }
    }

    public static <K, V> ListMultimap<K, V> filterKeys(ListMultimap<K, V> listMultimap, Predicate<? super K> predicate) {
        if (!(listMultimap instanceof w0)) {
            return new w0(listMultimap, predicate);
        }
        w0 w0Var = (w0) listMultimap;
        return new w0((ListMultimap) w0Var.f, Predicates.and(w0Var.g, predicate));
    }
}
