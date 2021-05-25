package a2.j.d.c;

import androidx.appcompat.app.AppCompatDelegateImpl;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class m4<K, V> extends r4 implements Map<K, V> {
    private static final long serialVersionUID = 0;
    @MonotonicNonNullDecl
    public transient Set<K> c;
    @MonotonicNonNullDecl
    public transient Collection<V> d;
    @MonotonicNonNullDecl
    public transient Set<Map.Entry<K, V>> e;

    public m4(Map<K, V> map, @NullableDecl Object obj) {
        super(map, obj);
    }

    @Override // java.util.Map
    public void clear() {
        synchronized (this.b) {
            d().clear();
        }
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        boolean containsKey;
        synchronized (this.b) {
            containsKey = d().containsKey(obj);
        }
        return containsKey;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        boolean containsValue;
        synchronized (this.b) {
            containsValue = d().containsValue(obj);
        }
        return containsValue;
    }

    public Map<K, V> d() {
        return (Map) this.a;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set;
        synchronized (this.b) {
            if (this.e == null) {
                this.e = new u4(d().entrySet(), this.b);
            }
            set = this.e;
        }
        return set;
    }

    @Override // java.lang.Object, java.util.Map
    public boolean equals(Object obj) {
        boolean equals;
        if (obj == this) {
            return true;
        }
        synchronized (this.b) {
            equals = d().equals(obj);
        }
        return equals;
    }

    @Override // java.util.Map
    public V get(Object obj) {
        V v;
        synchronized (this.b) {
            v = d().get(obj);
        }
        return v;
    }

    @Override // java.lang.Object, java.util.Map
    public int hashCode() {
        int hashCode;
        synchronized (this.b) {
            hashCode = d().hashCode();
        }
        return hashCode;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.b) {
            isEmpty = d().isEmpty();
        }
        return isEmpty;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        Set<K> set;
        synchronized (this.b) {
            if (this.c == null) {
                this.c = new u4(d().keySet(), this.b);
            }
            set = this.c;
        }
        return set;
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        V put;
        synchronized (this.b) {
            put = d().put(k, v);
        }
        return put;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        synchronized (this.b) {
            d().putAll(map);
        }
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        V remove;
        synchronized (this.b) {
            remove = d().remove(obj);
        }
        return remove;
    }

    @Override // java.util.Map
    public int size() {
        int size;
        synchronized (this.b) {
            size = d().size();
        }
        return size;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        Collection<V> collection;
        synchronized (this.b) {
            if (this.d == null) {
                this.d = AppCompatDelegateImpl.i.e(d().values(), this.b);
            }
            collection = this.d;
        }
        return collection;
    }
}
