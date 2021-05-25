package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public abstract class b<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    @MonotonicNonNullDecl
    public transient Map<K, V> a;
    @RetainedWith
    @MonotonicNonNullDecl
    public transient b<V, K> b;
    @MonotonicNonNullDecl
    public transient Set<K> c;
    @MonotonicNonNullDecl
    public transient Set<V> d;
    @MonotonicNonNullDecl
    public transient Set<Map.Entry<K, V>> e;

    public class a extends ForwardingMapEntry<K, V> {
        public final Map.Entry<K, V> a;

        public a(Map.Entry<K, V> entry) {
            this.a = entry;
        }

        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Object mo147delegate() {
            return this.a;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.util.Map<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
        public V setValue(V v) {
            b.this.e(v);
            Preconditions.checkState(b.this.entrySet().contains(this), "entry no longer in map");
            if (Objects.equal(v, getValue())) {
                return v;
            }
            Preconditions.checkArgument(!b.this.containsValue(v), "value already present: %s", v);
            V value = this.a.setValue(v);
            Preconditions.checkState(Objects.equal(v, b.this.get(getKey())), "entry no longer in map");
            b bVar = b.this;
            Object key = getKey();
            bVar.b.a.remove(value);
            bVar.b.a.put(v, key);
            return value;
        }

        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
        /* renamed from: delegate  reason: collision with other method in class */
        public Map.Entry<K, V> mo147delegate() {
            return this.a;
        }
    }

    /* renamed from: a2.j.d.c.b$b  reason: collision with other inner class name */
    public class C0059b extends ForwardingSet<Map.Entry<K, V>> {
        public final Set<Map.Entry<K, V>> a;

        public C0059b(a aVar) {
            this.a = b.this.a.entrySet();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public void clear() {
            b.this.clear();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Set<Map.Entry<K, V>> set = this.a;
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            return set.contains(Maps.n((Map.Entry) obj));
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Object mo147delegate() {
            return this.a;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            b bVar = b.this;
            return new a(bVar, bVar.a.entrySet().iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!this.a.contains(obj)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            b.this.b.a.remove(entry.getValue());
            this.a.remove(entry);
            return true;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate  reason: collision with other method in class */
        public Collection mo147delegate() {
            return this.a;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Set<Map.Entry<K, V>> mo147delegate() {
            return this.a;
        }
    }

    public static class c<K, V> extends b<K, V> {
        @GwtIncompatible
        private static final long serialVersionUID = 0;

        public c(Map<K, V> map, b<V, K> bVar) {
            super(map, bVar, null);
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.b = (b) objectInputStream.readObject();
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(mo35inverse());
        }

        @Override // a2.j.d.c.b
        public K d(K k) {
            return this.b.e(k);
        }

        @Override // a2.j.d.c.b, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public /* bridge */ /* synthetic */ Object mo147delegate() {
            return b.super.mo147delegate();
        }

        @Override // a2.j.d.c.b
        public V e(V v) {
            return this.b.d(v);
        }

        @GwtIncompatible
        public Object readResolve() {
            return mo35inverse().mo35inverse();
        }

        @Override // a2.j.d.c.b, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
        public /* bridge */ /* synthetic */ Collection values() {
            return b.super.values();
        }
    }

    public class e extends ForwardingSet<V> {
        public final Set<V> a;

        public e(a aVar) {
            this.a = b.this.b.keySet();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Object mo147delegate() {
            return this.a;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new h2(b.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingObject, java.lang.Object
        public String toString() {
            return standardToString();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate  reason: collision with other method in class */
        public Collection mo147delegate() {
            return this.a;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Set<V> mo147delegate() {
            return this.a;
        }
    }

    public b(Map<K, V> map, Map<V, K> map2) {
        i(map, map2);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public void clear() {
        this.a.clear();
        this.b.a.clear();
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return this.b.containsKey(obj);
    }

    @CanIgnoreReturnValue
    public K d(@NullableDecl K k) {
        return k;
    }

    @CanIgnoreReturnValue
    public V e(@NullableDecl V v) {
        return v;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.e;
        if (set != null) {
            return set;
        }
        C0059b bVar = new C0059b(null);
        this.e = bVar;
        return bVar;
    }

    public final V f(@NullableDecl K k, @NullableDecl V v, boolean z) {
        d(k);
        e(v);
        boolean containsKey = containsKey(k);
        if (containsKey && Objects.equal(v, get(k))) {
            return v;
        }
        if (z) {
            mo35inverse().remove(v);
        } else {
            Preconditions.checkArgument(!containsValue(v), "value already present: %s", v);
        }
        V put = this.a.put(k, v);
        if (containsKey) {
            this.b.a.remove(put);
        }
        this.b.a.put(v, k);
        return put;
    }

    @Override // com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public V forcePut(@NullableDecl K k, @NullableDecl V v) {
        return f(k, v, true);
    }

    public final void h(V v) {
        this.b.a.remove(v);
    }

    public void i(Map<K, V> map, Map<V, K> map2) {
        boolean z = true;
        Preconditions.checkState(this.a == null);
        Preconditions.checkState(this.b == null);
        Preconditions.checkArgument(map.isEmpty());
        Preconditions.checkArgument(map2.isEmpty());
        if (map == map2) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.a = map;
        this.b = new c(map2, this);
    }

    @Override // com.google.common.collect.BiMap
    /* renamed from: inverse */
    public BiMap<V, K> mo35inverse() {
        return this.b;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.c;
        if (set != null) {
            return set;
        }
        d dVar = new d(null);
        this.c = dVar;
        return dVar;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public V put(@NullableDecl K k, @NullableDecl V v) {
        return f(k, v, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: a2.j.d.c.b<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object obj) {
        if (!containsKey(obj)) {
            return null;
        }
        V remove = this.a.remove(obj);
        h(remove);
        return remove;
    }

    public class d extends ForwardingSet<K> {
        public d(a aVar) {
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public void clear() {
            b.this.clear();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new g2(b.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            b bVar = b.this;
            bVar.h(bVar.a.remove(obj));
            return true;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: delegate */
        public Set<K> mo147delegate() {
            return b.this.a.keySet();
        }
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    /* renamed from: delegate */
    public Map<K, V> mo147delegate() {
        return this.a;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public Set<V> values() {
        Set<V> set = this.d;
        if (set != null) {
            return set;
        }
        e eVar = new e(null);
        this.d = eVar;
        return eVar;
    }

    public b(Map map, b bVar, a aVar) {
        this.a = map;
        this.b = bVar;
    }
}
