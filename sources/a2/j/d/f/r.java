package a2.j.d.f;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.graph.Graphs;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class r<N, V> implements a0<N, V> {
    public static final Object d = new Object();
    public final Map<N, Object> a;
    public int b;
    public int c;

    public class a extends AbstractSet<N> {
        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            Object obj2 = r.this.a.get(obj);
            return obj2 == r.d || (obj2 instanceof c);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator iterator() {
            return new q(this, r.this.a.entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return r.this.b;
        }
    }

    public class b extends AbstractSet<N> {
        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            Object obj2 = r.this.a.get(obj);
            return (obj2 == r.d || obj2 == null) ? false : true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator iterator() {
            return new s(this, r.this.a.entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return r.this.c;
        }
    }

    public static final class c {
        public final Object a;

        public c(Object obj) {
            this.a = obj;
        }
    }

    public r(Map<N, Object> map, int i, int i2) {
        this.a = (Map) Preconditions.checkNotNull(map);
        Graphs.a(i);
        this.b = i;
        Graphs.a(i2);
        this.c = i2;
        Preconditions.checkState(i <= map.size() && i2 <= map.size());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.HashMap */
    /* JADX WARN: Multi-variable type inference failed */
    public static <N, V> r<N, V> i(Set<N> set, Map<N, V> map) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        for (N n : set) {
            Object put = hashMap.put(n, d);
            if (put != null) {
                hashMap.put(n, new c(put));
            }
        }
        return new r<>(ImmutableMap.copyOf(hashMap), set.size(), map.size());
    }

    @Override // a2.j.d.f.a0
    public Set<N> a() {
        return Collections.unmodifiableSet(this.a.keySet());
    }

    @Override // a2.j.d.f.a0
    public Set<N> b() {
        return new b();
    }

    @Override // a2.j.d.f.a0
    public Set<N> c() {
        return new a();
    }

    @Override // a2.j.d.f.a0
    public void d(N n, V v) {
        Map<N, Object> map = this.a;
        Object obj = d;
        Object put = map.put(n, obj);
        if (put == null) {
            int i = this.b + 1;
            this.b = i;
            Graphs.c(i);
        } else if (put instanceof c) {
            this.a.put(n, put);
        } else if (put != obj) {
            this.a.put(n, new c(put));
            int i2 = this.b + 1;
            this.b = i2;
            Graphs.c(i2);
        }
    }

    @Override // a2.j.d.f.a0
    public V e(N n) {
        V v = (V) this.a.get(n);
        if (v == d) {
            return null;
        }
        return v instanceof c ? (V) v.a : v;
    }

    @Override // a2.j.d.f.a0
    public V f(Object obj) {
        Object obj2;
        V v = (V) this.a.get(obj);
        if (v == null || v == (obj2 = d)) {
            return null;
        }
        if (v instanceof c) {
            this.a.put(obj, obj2);
            int i = this.c - 1;
            this.c = i;
            Graphs.a(i);
            return (V) v.a;
        }
        this.a.remove(obj);
        int i2 = this.c - 1;
        this.c = i2;
        Graphs.a(i2);
        return v;
    }

    @Override // a2.j.d.f.a0
    public void g(N n) {
        Object obj = this.a.get(n);
        if (obj == d) {
            this.a.remove(n);
            int i = this.b - 1;
            this.b = i;
            Graphs.a(i);
        } else if (obj instanceof c) {
            this.a.put(n, ((c) obj).a);
            int i2 = this.b - 1;
            this.b = i2;
            Graphs.a(i2);
        }
    }

    @Override // a2.j.d.f.a0
    public V h(N n, V v) {
        V v2 = (V) this.a.put(n, v);
        if (v2 == null) {
            int i = this.c + 1;
            this.c = i;
            Graphs.c(i);
            return null;
        } else if (v2 instanceof c) {
            this.a.put(n, new c(v));
            return (V) v2.a;
        } else if (v2 != d) {
            return v2;
        } else {
            this.a.put(n, new c(v));
            int i2 = this.c + 1;
            this.c = i2;
            Graphs.c(i2);
            return null;
        }
    }
}
