package a2.j.d.c;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class n4<K, V> extends r4 implements Multimap<K, V> {
    private static final long serialVersionUID = 0;
    @MonotonicNonNullDecl
    public transient Set<K> c;
    @MonotonicNonNullDecl
    public transient Collection<V> d;
    @MonotonicNonNullDecl
    public transient Collection<Map.Entry<K, V>> e;
    @MonotonicNonNullDecl
    public transient Map<K, Collection<V>> f;
    @MonotonicNonNullDecl
    public transient Multiset<K> g;

    public n4(Multimap<K, V> multimap, @NullableDecl Object obj) {
        super(multimap, obj);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> map;
        synchronized (this.b) {
            if (this.f == null) {
                this.f = new c4(d().asMap(), this.b);
            }
            map = this.f;
        }
        return map;
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        synchronized (this.b) {
            d().clear();
        }
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsEntry(Object obj, Object obj2) {
        boolean containsEntry;
        synchronized (this.b) {
            containsEntry = d().containsEntry(obj, obj2);
        }
        return containsEntry;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(Object obj) {
        boolean containsKey;
        synchronized (this.b) {
            containsKey = d().containsKey(obj);
        }
        return containsKey;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsValue(Object obj) {
        boolean containsValue;
        synchronized (this.b) {
            containsValue = d().containsValue(obj);
        }
        return containsValue;
    }

    public Multimap<K, V> d() {
        return (Multimap) this.a;
    }

    @Override // com.google.common.collect.Multimap
    public Collection<Map.Entry<K, V>> entries() {
        Collection<Map.Entry<K, V>> collection;
        synchronized (this.b) {
            if (this.e == null) {
                this.e = AppCompatDelegateImpl.i.d(d().entries(), this.b);
            }
            collection = this.e;
        }
        return collection;
    }

    @Override // java.lang.Object, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
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

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public Collection<V> mo118get(K k) {
        Collection<V> d2;
        synchronized (this.b) {
            d2 = AppCompatDelegateImpl.i.d(d().mo118get(k), this.b);
        }
        return d2;
    }

    @Override // java.lang.Object, com.google.common.collect.Multimap
    public int hashCode() {
        int hashCode;
        synchronized (this.b) {
            hashCode = d().hashCode();
        }
        return hashCode;
    }

    @Override // com.google.common.collect.Multimap
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.b) {
            isEmpty = d().isEmpty();
        }
        return isEmpty;
    }

    @Override // com.google.common.collect.Multimap
    public Set<K> keySet() {
        Set<K> set;
        synchronized (this.b) {
            if (this.c == null) {
                this.c = AppCompatDelegateImpl.i.c(d().keySet(), this.b);
            }
            set = this.c;
        }
        return set;
    }

    @Override // com.google.common.collect.Multimap
    public Multiset<K> keys() {
        Multiset<K> multiset;
        synchronized (this.b) {
            if (this.g == null) {
                Multiset<K> keys = d().keys();
                Object obj = this.b;
                if (!(keys instanceof o4)) {
                    if (!(keys instanceof ImmutableMultiset)) {
                        keys = new o4(keys, obj);
                    }
                }
                this.g = keys;
            }
            multiset = this.g;
        }
        return multiset;
    }

    @Override // com.google.common.collect.Multimap
    public boolean put(K k, V v) {
        boolean put;
        synchronized (this.b) {
            put = d().put(k, v);
        }
        return put;
    }

    @Override // com.google.common.collect.Multimap
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        boolean putAll;
        synchronized (this.b) {
            putAll = d().putAll(k, iterable);
        }
        return putAll;
    }

    @Override // com.google.common.collect.Multimap
    public boolean remove(Object obj, Object obj2) {
        boolean remove;
        synchronized (this.b) {
            remove = d().remove(obj, obj2);
        }
        return remove;
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: removeAll */
    public Collection<V> mo119removeAll(Object obj) {
        Collection<V> removeAll;
        synchronized (this.b) {
            removeAll = d().mo119removeAll(obj);
        }
        return removeAll;
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: replaceValues */
    public Collection<V> mo120replaceValues(K k, Iterable<? extends V> iterable) {
        Collection<V> replaceValues;
        synchronized (this.b) {
            replaceValues = d().mo120replaceValues(k, iterable);
        }
        return replaceValues;
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        int size;
        synchronized (this.b) {
            size = d().size();
        }
        return size;
    }

    @Override // com.google.common.collect.Multimap
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

    @Override // com.google.common.collect.Multimap
    public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        boolean putAll;
        synchronized (this.b) {
            putAll = d().putAll(multimap);
        }
        return putAll;
    }
}
