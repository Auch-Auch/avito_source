package a2.j.d.f;

import com.google.common.base.Preconditions;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class i0<K, V> {
    public final Map<K, V> a;
    @NullableDecl
    public transient Map.Entry<K, V> b;

    public i0(Map<K, V> map) {
        this.a = (Map) Preconditions.checkNotNull(map);
    }

    public void a() {
        this.b = null;
    }

    public final boolean b(@NullableDecl Object obj) {
        return d(obj) != null || this.a.containsKey(obj);
    }

    public V c(@NullableDecl Object obj) {
        V d = d(obj);
        return d != null ? d : this.a.get(obj);
    }

    public V d(@NullableDecl Object obj) {
        Map.Entry<K, V> entry = this.b;
        if (entry == null || entry.getKey() != obj) {
            return null;
        }
        return entry.getValue();
    }

    public final V e(@NullableDecl Object obj) {
        return this.a.get(obj);
    }
}
