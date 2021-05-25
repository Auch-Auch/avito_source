package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import l6.e.c;
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {
    @Nullable
    public c<K, V> h;

    public class a extends c<K, V> {
        public a() {
        }

        @Override // l6.e.c
        public void a() {
            ArrayMap.this.clear();
        }

        @Override // l6.e.c
        public Object b(int i, int i2) {
            return ArrayMap.this.b[(i << 1) + i2];
        }

        @Override // l6.e.c
        public Map<K, V> c() {
            return ArrayMap.this;
        }

        @Override // l6.e.c
        public int d() {
            return ArrayMap.this.c;
        }

        @Override // l6.e.c
        public int e(Object obj) {
            return ArrayMap.this.indexOfKey(obj);
        }

        @Override // l6.e.c
        public int f(Object obj) {
            return ArrayMap.this.f(obj);
        }

        @Override // l6.e.c
        public void g(K k, V v) {
            ArrayMap.this.put(k, v);
        }

        @Override // l6.e.c
        public void h(int i) {
            ArrayMap.this.removeAt(i);
        }

        @Override // l6.e.c
        public V i(int i, V v) {
            return (V) ArrayMap.this.setValueAt(i, v);
        }
    }

    public ArrayMap() {
    }

    public boolean containsAll(@NonNull Collection<?> collection) {
        return c.j(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        c<K, V> g = g();
        if (g.a == null) {
            g.a = new c.b();
        }
        return g.a;
    }

    public final c<K, V> g() {
        if (this.h == null) {
            this.h = new a();
        }
        return this.h;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        c<K, V> g = g();
        if (g.b == null) {
            g.b = new c.C0523c();
        }
        return g.b;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: androidx.collection.ArrayMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(map.size() + this.c);
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean removeAll(@NonNull Collection<?> collection) {
        return c.l(this, collection);
    }

    public boolean retainAll(@NonNull Collection<?> collection) {
        return c.m(this, collection);
    }

    @Override // java.util.Map
    public Collection<V> values() {
        c<K, V> g = g();
        if (g.c == null) {
            g.c = new c.e();
        }
        return g.c;
    }

    public ArrayMap(int i) {
        super(i);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }
}
