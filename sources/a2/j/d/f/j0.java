package a2.j.d.f;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class j0<K, V> extends i0<K, V> {
    @NullableDecl
    public transient a<K, V> c;
    @NullableDecl
    public transient a<K, V> d;

    public static final class a<K, V> {
        public final K a;
        public final V b;

        public a(K k, V v) {
            this.a = k;
            this.b = v;
        }
    }

    public j0(Map<K, V> map) {
        super(map);
    }

    @Override // a2.j.d.f.i0
    public void a() {
        this.b = null;
        this.c = null;
        this.d = null;
    }

    @Override // a2.j.d.f.i0
    public V c(@NullableDecl Object obj) {
        V d2 = d(obj);
        if (d2 != null) {
            return d2;
        }
        V v = this.a.get(obj);
        if (v != null) {
            a<K, V> aVar = new a<>(obj, v);
            this.d = this.c;
            this.c = aVar;
        }
        return v;
    }

    @Override // a2.j.d.f.i0
    public V d(@NullableDecl Object obj) {
        V v = (V) super.d(obj);
        if (v != null) {
            return v;
        }
        a<K, V> aVar = this.c;
        if (aVar != null && aVar.a == obj) {
            return aVar.b;
        }
        a<K, V> aVar2 = this.d;
        if (aVar2 == null || aVar2.a != obj) {
            return null;
        }
        this.d = aVar;
        this.c = aVar2;
        return aVar2.b;
    }
}
