package t6.w.f.a.m.e;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
public class d<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    public static final /* synthetic */ int f = 0;
    public final int a;
    public List<d<K, V>.b> b = Collections.emptyList();
    public Map<K, V> c = Collections.emptyMap();
    public boolean d;
    public volatile d<K, V>.C0685d e;

    public static class a {
        public static final Iterator<Object> a = new C0684a();
        public static final Iterable<Object> b = new b();

        /* renamed from: t6.w.f.a.m.e.d$a$a  reason: collision with other inner class name */
        public static class C0684a implements Iterator<Object> {
            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        public static class b implements Iterable<Object> {
            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return a.a;
            }
        }
    }

    public class c implements Iterator<Map.Entry<K, V>> {
        public int a = -1;
        public boolean b;
        public Iterator<Map.Entry<K, V>> c;

        public c(c cVar) {
        }

        /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.Iterator<java.util.Map$Entry<K, V>>, java.util.Iterator<java.util.Map$Entry<K extends java.lang.Comparable<K>, V>> */
        public final Iterator<Map.Entry<K, V>> a() {
            if (this.c == null) {
                this.c = d.this.c.entrySet().iterator();
            }
            return (Iterator<Map.Entry<K, V>>) this.c;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a + 1 < d.this.b.size() || a().hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            this.b = true;
            int i = this.a + 1;
            this.a = i;
            if (i < d.this.b.size()) {
                return d.this.b.get(this.a);
            }
            return a().next();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.b) {
                this.b = false;
                d dVar = d.this;
                int i = d.f;
                dVar.c();
                if (this.a < d.this.b.size()) {
                    d dVar2 = d.this;
                    int i2 = this.a;
                    this.a = i2 - 1;
                    dVar2.i(i2);
                    return;
                }
                a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }
    }

    /* renamed from: t6.w.f.a.m.e.d$d  reason: collision with other inner class name */
    public class C0685d extends AbstractSet<Map.Entry<K, V>> {
        public C0685d(c cVar) {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: t6.w.f.a.m.e.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                return false;
            }
            d.this.h((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            d.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = d.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new c(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            d.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return d.this.size();
        }
    }

    public d(int i, c cVar) {
        this.a = i;
    }

    public final int a(K k) {
        int size = this.b.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo(this.b.get(size).a);
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo(this.b.get(i2).a);
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    public final void c() {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        c();
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (!this.c.isEmpty()) {
            this.c.clear();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: t6.w.f.a.m.e.d<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.c.containsKey(comparable);
    }

    public Map.Entry<K, V> d(int i) {
        return this.b.get(i);
    }

    public int e() {
        return this.b.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.e == null) {
            this.e = new C0685d(null);
        }
        return this.e;
    }

    public Iterable<Map.Entry<K, V>> f() {
        return this.c.isEmpty() ? (Iterable<Map.Entry<K, V>>) a.b : this.c.entrySet();
    }

    public final SortedMap<K, V> g() {
        c();
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            this.c = new TreeMap();
        }
        return (SortedMap) this.c;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: t6.w.f.a.m.e.d<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a3 = a(comparable);
        if (a3 >= 0) {
            return this.b.get(a3).b;
        }
        return this.c.get(comparable);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, K] */
    public V h(K k, V v) {
        c();
        int a3 = a(k);
        if (a3 >= 0) {
            d<K, V>.b bVar = this.b.get(a3);
            d.this.c();
            V v2 = bVar.b;
            bVar.b = v;
            return v2;
        }
        c();
        if (this.b.isEmpty() && !(this.b instanceof ArrayList)) {
            this.b = new ArrayList(this.a);
        }
        int i = -(a3 + 1);
        if (i >= this.a) {
            return g().put(k, v);
        }
        int size = this.b.size();
        int i2 = this.a;
        if (size == i2) {
            d<K, V>.b remove = this.b.remove(i2 - 1);
            g().put(remove.a, remove.b);
        }
        this.b.add(i, new b(k, v));
        return null;
    }

    public final V i(int i) {
        c();
        V v = this.b.remove(i).b;
        if (!this.c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = g().entrySet().iterator();
            this.b.add(new b(this, it.next()));
            it.remove();
        }
        return v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: t6.w.f.a.m.e.d<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        c();
        Comparable comparable = (Comparable) obj;
        int a3 = a(comparable);
        if (a3 >= 0) {
            return (V) i(a3);
        }
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.c.size() + this.b.size();
    }

    public class b implements Comparable<d<K, V>.b>, Map.Entry<K, V> {
        public final K a;
        public V b;

        public b(d dVar, Map.Entry<K, V> entry) {
            V value = entry.getValue();
            d.this = dVar;
            this.a = entry.getKey();
            this.b = value;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(d<K, V>.b bVar) {
            return this.a.compareTo(bVar.a);
        }

        @Override // java.lang.Object, java.util.Map.Entry
        public boolean equals(Object obj) {
            boolean z;
            boolean z2;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k = this.a;
            Object key = entry.getKey();
            if (k == null) {
                z = key == null;
            } else {
                z = k.equals(key);
            }
            if (z) {
                V v = this.b;
                Object value = entry.getValue();
                if (v == null) {
                    z2 = value == null;
                } else {
                    z2 = v.equals(value);
                }
                if (z2) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // java.lang.Object, java.util.Map.Entry
        public int hashCode() {
            K k = this.a;
            int i = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.b;
            if (v != null) {
                i = v.hashCode();
            }
            return hashCode ^ i;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            d dVar = d.this;
            int i = d.f;
            dVar.c();
            V v2 = this.b;
            this.b = v;
            return v2;
        }

        @Override // java.lang.Object
        public String toString() {
            String valueOf = String.valueOf(this.a);
            String valueOf2 = String.valueOf(this.b);
            return a2.b.a.a.a.u(new StringBuilder(valueOf2.length() + valueOf.length() + 1), valueOf, "=", valueOf2);
        }

        public b(K k, V v) {
            this.a = k;
            this.b = v;
        }
    }
}
