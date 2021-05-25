package com.google.common.collect;

import a2.j.d.c.b0;
import a2.j.d.c.d0;
import a2.j.d.c.h;
import a2.j.d.c.x1;
import a2.j.d.c.y1;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true, serializable = true)
public class LinkedListMultimap<K, V> extends h<K, V> implements ListMultimap<K, V>, Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    @NullableDecl
    public transient e<K, V> f;
    @NullableDecl
    public transient e<K, V> g;
    public transient Map<K, d<K, V>> h;
    public transient int i;
    public transient int j;

    public class a extends AbstractSequentialList<V> {
        public final /* synthetic */ Object a;

        public a(Object obj) {
            this.a = obj;
        }

        @Override // java.util.AbstractSequentialList, java.util.List, java.util.AbstractList
        public ListIterator<V> listIterator(int i) {
            return new g(this.a, i);
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            d<K, V> dVar = LinkedListMultimap.this.h.get(this.a);
            if (dVar == null) {
                return 0;
            }
            return dVar.c;
        }
    }

    public class b extends Sets.k<K> {
        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedListMultimap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return new c(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return !LinkedListMultimap.this.mo119removeAll(obj).isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedListMultimap.this.h.size();
        }
    }

    public class c implements Iterator<K> {
        public final Set<K> a;
        public e<K, V> b;
        @NullableDecl
        public e<K, V> c;
        public int d;

        public c(a aVar) {
            this.a = Sets.newHashSetWithExpectedSize(LinkedListMultimap.this.keySet().size());
            this.b = LinkedListMultimap.this.f;
            this.d = LinkedListMultimap.this.j;
        }

        public final void a() {
            if (LinkedListMultimap.this.j != this.d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.b != null;
        }

        @Override // java.util.Iterator
        public K next() {
            e<K, V> eVar;
            a();
            LinkedListMultimap.l(this.b);
            e<K, V> eVar2 = this.b;
            this.c = eVar2;
            this.a.add(eVar2.a);
            do {
                eVar = this.b.c;
                this.b = eVar;
                if (eVar == null) {
                    break;
                }
            } while (!this.a.add(eVar.a));
            return this.c.a;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            Preconditions.checkState(this.c != null, "no calls to next() since the last call to remove()");
            LinkedListMultimap linkedListMultimap = LinkedListMultimap.this;
            K k = this.c.a;
            Objects.requireNonNull(linkedListMultimap);
            Iterators.b(new g(k));
            this.c = null;
            this.d = LinkedListMultimap.this.j;
        }
    }

    public static class d<K, V> {
        public e<K, V> a;
        public e<K, V> b;
        public int c = 1;

        public d(e<K, V> eVar) {
            this.a = eVar;
            this.b = eVar;
            eVar.f = null;
            eVar.e = null;
        }
    }

    public static final class e<K, V> extends a2.j.d.c.g<K, V> {
        @NullableDecl
        public final K a;
        @NullableDecl
        public V b;
        @NullableDecl
        public e<K, V> c;
        @NullableDecl
        public e<K, V> d;
        @NullableDecl
        public e<K, V> e;
        @NullableDecl
        public e<K, V> f;

        public e(@NullableDecl K k, @NullableDecl V v) {
            this.a = k;
            this.b = v;
        }

        @Override // a2.j.d.c.g, java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        @Override // a2.j.d.c.g, java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // a2.j.d.c.g, java.util.Map.Entry
        public V setValue(@NullableDecl V v) {
            V v2 = this.b;
            this.b = v;
            return v2;
        }
    }

    public class f implements ListIterator<Map.Entry<K, V>> {
        public int a;
        @NullableDecl
        public e<K, V> b;
        @NullableDecl
        public e<K, V> c;
        @NullableDecl
        public e<K, V> d;
        public int e;

        public f(int i) {
            this.e = LinkedListMultimap.this.j;
            int size = LinkedListMultimap.this.size();
            Preconditions.checkPositionIndex(i, size);
            if (i < size / 2) {
                this.b = LinkedListMultimap.this.f;
                while (true) {
                    int i2 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i2;
                }
            } else {
                this.d = LinkedListMultimap.this.g;
                this.a = size;
                while (true) {
                    int i3 = i + 1;
                    if (i >= size) {
                        break;
                    }
                    previous();
                    i = i3;
                }
            }
            this.c = null;
        }

        public final void a() {
            if (LinkedListMultimap.this.j != this.e) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            throw new UnsupportedOperationException();
        }

        @CanIgnoreReturnValue
        /* renamed from: b */
        public e<K, V> next() {
            a();
            LinkedListMultimap.l(this.b);
            e<K, V> eVar = this.b;
            this.c = eVar;
            this.d = eVar;
            this.b = eVar.c;
            this.a++;
            return eVar;
        }

        @CanIgnoreReturnValue
        /* renamed from: c */
        public e<K, V> previous() {
            a();
            LinkedListMultimap.l(this.d);
            e<K, V> eVar = this.d;
            this.c = eVar;
            this.b = eVar;
            this.d = eVar.d;
            this.a--;
            return eVar;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            a();
            return this.b != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            a();
            return this.d != null;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.a;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.a - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            a();
            Preconditions.checkState(this.c != null, "no calls to next() since the last call to remove()");
            e<K, V> eVar = this.c;
            if (eVar != this.b) {
                this.d = eVar.d;
                this.a--;
            } else {
                this.b = eVar.c;
            }
            LinkedListMultimap.m(LinkedListMultimap.this, eVar);
            this.c = null;
            this.e = LinkedListMultimap.this.j;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            throw new UnsupportedOperationException();
        }
    }

    public LinkedListMultimap() {
        this(12);
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<>(12);
    }

    public static void l(Object obj) {
        if (obj == null) {
            throw new NoSuchElementException();
        }
    }

    public static void m(LinkedListMultimap linkedListMultimap, e eVar) {
        Objects.requireNonNull(linkedListMultimap);
        e<K, V> eVar2 = eVar.d;
        if (eVar2 != null) {
            eVar2.c = eVar.c;
        } else {
            linkedListMultimap.f = eVar.c;
        }
        e<K, V> eVar3 = eVar.c;
        if (eVar3 != null) {
            eVar3.d = eVar2;
        } else {
            linkedListMultimap.g = eVar2;
        }
        if (eVar.f == null && eVar.e == null) {
            linkedListMultimap.h.remove(eVar.a).c = 0;
            linkedListMultimap.j++;
        } else {
            d<K, V> dVar = linkedListMultimap.h.get(eVar.a);
            dVar.c--;
            e<K, V> eVar4 = eVar.f;
            if (eVar4 == null) {
                dVar.a = eVar.e;
            } else {
                eVar4.e = eVar.e;
            }
            e<K, V> eVar5 = eVar.e;
            if (eVar5 == null) {
                dVar.b = eVar4;
            } else {
                eVar5.f = eVar4;
            }
        }
        linkedListMultimap.i--;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.LinkedListMultimap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.h = new d0();
        int readInt = objectInputStream.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // a2.j.d.c.h
    public Map<K, Collection<V>> b() {
        return new Multimaps.a(this);
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        this.f = null;
        this.g = null;
        this.h.clear();
        this.i = 0;
        this.j++;
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@NullableDecl Object obj) {
        return this.h.containsKey(obj);
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public boolean containsValue(@NullableDecl Object obj) {
        return values().contains(obj);
    }

    @Override // a2.j.d.c.h
    public Collection d() {
        return new x1(this);
    }

    @Override // a2.j.d.c.h
    public Set<K> e() {
        return new b();
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap, java.lang.Object, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // a2.j.d.c.h
    public Multiset<K> f() {
        return new Multimaps.g(this);
    }

    @Override // a2.j.d.c.h
    public Collection h() {
        return new y1(this);
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // a2.j.d.c.h
    public Iterator<Map.Entry<K, V>> i() {
        throw new AssertionError("should never be called");
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public boolean isEmpty() {
        return this.f == null;
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    @CanIgnoreReturnValue
    public final e<K, V> n(@NullableDecl K k, @NullableDecl V v, @NullableDecl e<K, V> eVar) {
        e<K, V> eVar2 = new e<>(k, v);
        if (this.f == null) {
            this.g = eVar2;
            this.f = eVar2;
            this.h.put(k, new d<>(eVar2));
            this.j++;
        } else if (eVar == null) {
            e<K, V> eVar3 = this.g;
            eVar3.c = eVar2;
            eVar2.d = eVar3;
            this.g = eVar2;
            d<K, V> dVar = this.h.get(k);
            if (dVar == null) {
                this.h.put(k, new d<>(eVar2));
                this.j++;
            } else {
                dVar.c++;
                e<K, V> eVar4 = dVar.b;
                eVar4.e = eVar2;
                eVar2.f = eVar4;
                dVar.b = eVar2;
            }
        } else {
            this.h.get(k).c++;
            eVar2.d = eVar.d;
            eVar2.f = eVar.f;
            eVar2.c = eVar;
            eVar2.e = eVar;
            e<K, V> eVar5 = eVar.f;
            if (eVar5 == null) {
                this.h.get(k).a = eVar2;
            } else {
                eVar5.e = eVar2;
            }
            e<K, V> eVar6 = eVar.d;
            if (eVar6 == null) {
                this.f = eVar2;
            } else {
                eVar6.c = eVar2;
            }
            eVar.d = eVar2;
            eVar.f = eVar2;
        }
        this.i++;
        return eVar2;
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public boolean put(@NullableDecl K k, @NullableDecl V v) {
        n(k, v, null);
        return true;
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Multimap multimap) {
        return super.putAll(multimap);
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.i;
    }

    @Override // a2.j.d.c.h, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public LinkedListMultimap(int i2) {
        this.h = new b0(i2);
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public List<V> mo118get(@NullableDecl K k) {
        return new a(k);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(@NullableDecl Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    /* renamed from: removeAll */
    public List<V> mo119removeAll(@NullableDecl Object obj) {
        List<V> unmodifiableList = Collections.unmodifiableList(Lists.newArrayList(new g(obj)));
        Iterators.b(new g(obj));
        return unmodifiableList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.LinkedListMultimap$g */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.c.h, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    /* renamed from: replaceValues */
    public List<V> mo120replaceValues(@NullableDecl K k, Iterable<? extends V> iterable) {
        List<V> unmodifiableList = Collections.unmodifiableList(Lists.newArrayList(new g(k)));
        g gVar = new g(k);
        Iterator<? extends V> it = iterable.iterator();
        while (gVar.hasNext() && it.hasNext()) {
            gVar.next();
            gVar.set(it.next());
        }
        while (gVar.hasNext()) {
            gVar.next();
            gVar.remove();
        }
        while (it.hasNext()) {
            gVar.add(it.next());
        }
        return unmodifiableList;
    }

    @Override // a2.j.d.c.h, com.google.common.collect.Multimap
    public List<V> values() {
        return (List) super.values();
    }

    public static <K, V> LinkedListMultimap<K, V> create(int i2) {
        return new LinkedListMultimap<>(i2);
    }

    public static <K, V> LinkedListMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        LinkedListMultimap<K, V> linkedListMultimap = new LinkedListMultimap<>(multimap.keySet().size());
        linkedListMultimap.putAll(multimap);
        return linkedListMultimap;
    }

    public class g implements ListIterator<V> {
        @NullableDecl
        public final Object a;
        public int b;
        @NullableDecl
        public e<K, V> c;
        @NullableDecl
        public e<K, V> d;
        @NullableDecl
        public e<K, V> e;

        public g(@NullableDecl Object obj) {
            e<K, V> eVar;
            this.a = obj;
            d<K, V> dVar = LinkedListMultimap.this.h.get(obj);
            if (dVar == null) {
                eVar = null;
            } else {
                eVar = dVar.a;
            }
            this.c = eVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.LinkedListMultimap */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.ListIterator
        public void add(V v) {
            this.e = LinkedListMultimap.this.n(this.a, v, this.c);
            this.b++;
            this.d = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.c != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.e != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @CanIgnoreReturnValue
        public V next() {
            LinkedListMultimap.l(this.c);
            e<K, V> eVar = this.c;
            this.d = eVar;
            this.e = eVar;
            this.c = eVar.e;
            this.b++;
            return eVar.b;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.b;
        }

        @Override // java.util.ListIterator
        @CanIgnoreReturnValue
        public V previous() {
            LinkedListMultimap.l(this.e);
            e<K, V> eVar = this.e;
            this.d = eVar;
            this.c = eVar;
            this.e = eVar.f;
            this.b--;
            return eVar.b;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            Preconditions.checkState(this.d != null, "no calls to next() since the last call to remove()");
            e<K, V> eVar = this.d;
            if (eVar != this.c) {
                this.e = eVar.f;
                this.b--;
            } else {
                this.c = eVar.e;
            }
            LinkedListMultimap.m(LinkedListMultimap.this, eVar);
            this.d = null;
        }

        @Override // java.util.ListIterator
        public void set(V v) {
            Preconditions.checkState(this.d != null);
            this.d.b = v;
        }

        public g(@NullableDecl Object obj, int i) {
            int i2;
            e<K, V> eVar;
            e<K, V> eVar2;
            d<K, V> dVar = LinkedListMultimap.this.h.get(obj);
            if (dVar == null) {
                i2 = 0;
            } else {
                i2 = dVar.c;
            }
            Preconditions.checkPositionIndex(i, i2);
            if (i < i2 / 2) {
                if (dVar == null) {
                    eVar = null;
                } else {
                    eVar = dVar.a;
                }
                this.c = eVar;
                while (true) {
                    int i3 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i3;
                }
            } else {
                if (dVar == null) {
                    eVar2 = null;
                } else {
                    eVar2 = dVar.b;
                }
                this.e = eVar2;
                this.b = i2;
                while (true) {
                    int i4 = i + 1;
                    if (i >= i2) {
                        break;
                    }
                    previous();
                    i = i4;
                }
            }
            this.a = obj;
            this.d = null;
        }
    }
}
