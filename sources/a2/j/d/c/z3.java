package a2.j.d.c;

import a2.j.d.c.y3;
import com.google.common.base.Preconditions;
import java.util.Map;
public class z3 extends g<R, V> {
    public final /* synthetic */ Map.Entry a;
    public final /* synthetic */ y3.c.b b;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public z3(y3.c.b bVar, Map.Entry entry) {
        this.b = bVar;
        this.a = entry;
    }

    @Override // a2.j.d.c.g, java.util.Map.Entry
    public R getKey() {
        return (R) this.a.getKey();
    }

    @Override // a2.j.d.c.g, java.util.Map.Entry
    public V getValue() {
        return (V) ((Map) this.a.getValue()).get(y3.c.this.d);
    }

    @Override // a2.j.d.c.g, java.util.Map.Entry
    public V setValue(V v) {
        return (V) ((Map) this.a.getValue()).put(y3.c.this.d, Preconditions.checkNotNull(v));
    }
}
