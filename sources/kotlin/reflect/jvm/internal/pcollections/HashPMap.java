package kotlin.reflect.jvm.internal.pcollections;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import t6.w.f.a.n.a;
import t6.w.f.a.n.b;
import t6.w.f.a.n.c;
import t6.w.f.a.n.d;
public final class HashPMap<K, V> {
    public static final HashPMap<Object, Object> c = new HashPMap<>(c.b, 0);
    public final c<a<d<K, V>>> a;
    public final int b;

    static {
        c<Object> cVar = c.b;
    }

    public HashPMap(c<a<d<K, V>>> cVar, int i) {
        this.a = cVar;
        this.b = i;
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[2];
        objArr[0] = "kotlin/reflect/jvm/internal/pcollections/HashPMap";
        if (i != 1) {
            objArr[1] = "empty";
        } else {
            objArr[1] = "minus";
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", objArr));
    }

    public static <K, V> int c(a<d<K, V>> aVar, Object obj) {
        int i = 0;
        while (aVar != null && aVar.c > 0) {
            if (aVar.a.a.equals(obj)) {
                return i;
            }
            aVar = aVar.b;
            i++;
        }
        return -1;
    }

    @NotNull
    public static <K, V> HashPMap<K, V> empty() {
        HashPMap<K, V> hashPMap = (HashPMap<K, V>) c;
        if (hashPMap != null) {
            return hashPMap;
        }
        a(0);
        throw null;
    }

    public final a<d<K, V>> b(int i) {
        V a3 = this.a.a.a((long) i);
        return a3 == null ? (a<d<K, V>>) a.d : a3;
    }

    public boolean containsKey(Object obj) {
        return c(b(obj.hashCode()), obj) != -1;
    }

    public V get(Object obj) {
        a<d<K, V>> b2 = b(obj.hashCode());
        while (b2 != null && b2.c > 0) {
            E e = b2.a;
            if (e.a.equals(obj)) {
                return e.b;
            }
            b2 = b2.b;
        }
        return null;
    }

    @NotNull
    public HashPMap<K, V> minus(Object obj) {
        a<d<K, V>> b2 = b(obj.hashCode());
        int c2 = c(b2, obj);
        if (c2 == -1) {
            return this;
        }
        a<d<K, V>> a3 = b2.a(c2);
        if (a3.c != 0) {
            return new HashPMap<>(this.a.a(obj.hashCode(), a3), this.b - 1);
        }
        c<a<d<K, V>>> cVar = this.a;
        b<V> c3 = cVar.a.c((long) obj.hashCode());
        if (c3 != cVar.a) {
            cVar = new c<>(c3);
        }
        return new HashPMap<>(cVar, this.b - 1);
    }

    @NotNull
    public HashPMap<K, V> plus(K k, V v) {
        a<d<K, V>> b2 = b(k.hashCode());
        int i = b2.c;
        int c2 = c(b2, k);
        if (c2 != -1) {
            b2 = b2.a(c2);
        }
        d dVar = new d(k, v);
        Objects.requireNonNull(b2);
        a<d<K, V>> aVar = new a<>(dVar, b2);
        return new HashPMap<>(this.a.a(k.hashCode(), aVar), (this.b - i) + aVar.c);
    }

    public int size() {
        return this.b;
    }
}
