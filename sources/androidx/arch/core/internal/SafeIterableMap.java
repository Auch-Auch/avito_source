package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {
    public c<K, V> a;
    public c<K, V> b;
    public WeakHashMap<f<K, V>, Boolean> c = new WeakHashMap<>();
    public int d = 0;

    public static class a<K, V> extends e<K, V> {
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.d;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.c;
        }
    }

    public static class b<K, V> extends e<K, V> {
        public b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.c;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.d;
        }
    }

    public static class c<K, V> implements Map.Entry<K, V> {
        @NonNull
        public final K a;
        @NonNull
        public final V b;
        public c<K, V> c;
        public c<K, V> d;

        public c(@NonNull K k, @NonNull V v) {
            this.a = k;
            this.b = v;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!this.a.equals(cVar.a) || !this.b.equals(cVar.b)) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public K getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public V getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        @Override // java.lang.Object
        public String toString() {
            return ((Object) this.a) + "=" + ((Object) this.b);
        }
    }

    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {
        public c<K, V> a;
        public boolean b = true;

        public d() {
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.f
        public void a(@NonNull c<K, V> cVar) {
            c<K, V> cVar2 = this.a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.d;
                this.a = cVar3;
                this.b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.b) {
                c<K, V> cVar = this.a;
                if (cVar == null || cVar.c == null) {
                    return false;
                }
                return true;
            } else if (SafeIterableMap.this.a != null) {
                return true;
            } else {
                return false;
            }
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.b) {
                this.b = false;
                this.a = SafeIterableMap.this.a;
            } else {
                c<K, V> cVar = this.a;
                this.a = cVar != null ? cVar.c : null;
            }
            return this.a;
        }
    }

    public static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {
        public c<K, V> a;
        public c<K, V> b;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.a = cVar2;
            this.b = cVar;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.f
        public void a(@NonNull c<K, V> cVar) {
            c<K, V> cVar2 = null;
            if (this.a == cVar && cVar == this.b) {
                this.b = null;
                this.a = null;
            }
            c<K, V> cVar3 = this.a;
            if (cVar3 == cVar) {
                this.a = b(cVar3);
            }
            c<K, V> cVar4 = this.b;
            if (cVar4 == cVar) {
                c<K, V> cVar5 = this.a;
                if (!(cVar4 == cVar5 || cVar5 == null)) {
                    cVar2 = c(cVar4);
                }
                this.b = cVar2;
            }
        }

        public abstract c<K, V> b(c<K, V> cVar);

        public abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b != null;
        }

        @Override // java.util.Iterator
        public Object next() {
            c<K, V> cVar = this.b;
            c<K, V> cVar2 = this.a;
            this.b = (cVar == cVar2 || cVar2 == null) ? null : c(cVar);
            return cVar;
        }
    }

    public interface f<K, V> {
        void a(@NonNull c<K, V> cVar);
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        b bVar = new b(this.b, this.a);
        this.c.put(bVar, Boolean.FALSE);
        return bVar;
    }

    public Map.Entry<K, V> eldest() {
        return this.a;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
        if (size() != safeIterableMap.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = safeIterableMap.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            return false;
        }
        return true;
    }

    public c<K, V> get(K k) {
        c<K, V> cVar = this.a;
        while (cVar != null && !cVar.a.equals(k)) {
            cVar = cVar.c;
        }
        return cVar;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().hashCode();
        }
        return i;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.a, this.b);
        this.c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public SafeIterableMap<K, V>.d iteratorWithAdditions() {
        SafeIterableMap<K, V>.d dVar = new d();
        this.c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry<K, V> newest() {
        return this.b;
    }

    public c<K, V> put(@NonNull K k, @NonNull V v) {
        c<K, V> cVar = new c<>(k, v);
        this.d++;
        c<K, V> cVar2 = this.b;
        if (cVar2 == null) {
            this.a = cVar;
            this.b = cVar;
            return cVar;
        }
        cVar2.c = cVar;
        cVar.d = cVar2;
        this.b = cVar;
        return cVar;
    }

    public V putIfAbsent(@NonNull K k, @NonNull V v) {
        c<K, V> cVar = get(k);
        if (cVar != null) {
            return cVar.b;
        }
        put(k, v);
        return null;
    }

    public V remove(@NonNull K k) {
        c<K, V> cVar = get(k);
        if (cVar == null) {
            return null;
        }
        this.d--;
        if (!this.c.isEmpty()) {
            for (f<K, V> fVar : this.c.keySet()) {
                fVar.a(cVar);
            }
        }
        c<K, V> cVar2 = cVar.d;
        if (cVar2 != null) {
            cVar2.c = cVar.c;
        } else {
            this.a = cVar.c;
        }
        c<K, V> cVar3 = cVar.c;
        if (cVar3 != null) {
            cVar3.d = cVar2;
        } else {
            this.b = cVar2;
        }
        cVar.c = null;
        cVar.d = null;
        return cVar.b;
    }

    public int size() {
        return this.d;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            L.append(it.next().toString());
            if (it.hasNext()) {
                L.append(", ");
            }
        }
        L.append("]");
        return L.toString();
    }
}
