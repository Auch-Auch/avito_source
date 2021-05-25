package a2.j.d.c;

import androidx.appcompat.app.AppCompatDelegateImpl;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class c4<K, V> extends m4<K, Collection<V>> {
    private static final long serialVersionUID = 0;
    @MonotonicNonNullDecl
    public transient Set<Map.Entry<K, Collection<V>>> f;
    @MonotonicNonNullDecl
    public transient Collection<Collection<V>> g;

    public c4(Map<K, Collection<V>> map, @NullableDecl Object obj) {
        super(map, obj);
    }

    @Override // a2.j.d.c.m4, java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // a2.j.d.c.m4, java.util.Map
    public Set<Map.Entry<K, Collection<V>>> entrySet() {
        Set<Map.Entry<K, Collection<V>>> set;
        synchronized (this.b) {
            if (this.f == null) {
                this.f = new e4(((Map) this.a).entrySet(), this.b);
            }
            set = this.f;
        }
        return set;
    }

    @Override // a2.j.d.c.m4, java.util.Map
    public Object get(Object obj) {
        Collection collection;
        synchronized (this.b) {
            Collection collection2 = (Collection) super.get(obj);
            if (collection2 == null) {
                collection = null;
            } else {
                collection = AppCompatDelegateImpl.i.d(collection2, this.b);
            }
        }
        return collection;
    }

    @Override // a2.j.d.c.m4, java.util.Map
    public Collection<Collection<V>> values() {
        Collection<Collection<V>> collection;
        synchronized (this.b) {
            if (this.g == null) {
                this.g = new f4(((Map) this.a).values(), this.b);
            }
            collection = this.g;
        }
        return collection;
    }
}
